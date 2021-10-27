// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.illusion.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.lightningrobotics.illusion.drivetrain.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collector extends SubsystemBase {
  VictorSPX collector;

  public Collector() {
    collector = new VictorSPX(RobotMap.COLLECTOR_ID); // identify collector motor
  }

  public void setCollectorPower(double pwr){
    collector.set(ControlMode.PercentOutput, pwr); // set motor power
  }

  public void stopCollecting() {
    setCollectorPower(0); // call setCollectorPower and set it to 0
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
