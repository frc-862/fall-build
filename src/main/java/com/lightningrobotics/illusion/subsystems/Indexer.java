// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.illusion.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.lightningrobotics.illusion.drivetrain.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
  
  private VictorSPX indexer;
  
  /** Creates a new Indexer. */
  public Indexer() {
    indexer = new VictorSPX(RobotMap.INDEXER_ID); // TODO: change later when we know what port
  } 

  @Override
  public void periodic() {
    // SmartDashboard.putData("setPower", setPower());
  }

  public void setPower(double pwr) {
    indexer.set(ControlMode.PercentOutput, pwr);
  }

  public void stop() {
    setPower(0);
  }

  public void feedShooter() {
    setPower(1);
  }

}
