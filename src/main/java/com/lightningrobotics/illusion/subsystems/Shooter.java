// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.illusion.subsystems;

import java.net.CacheRequest;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.lightningrobotics.illusion.IllusionContainer;
import com.lightningrobotics.illusion.drivetrain.RobotMap;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  
  private CANSparkMax shooter;

  // private CANPIDController shooterPIDFController;
  /** Creates a new Indexer. 
   * @param Constants */
  public Shooter() {

    shooter = new CANSparkMax(RobotMap.SHOOTER_ID, MotorType.kBrushless); // TODO: change later when we know what port
    
    shooter.setIdleMode(CANSparkMax.IdleMode.kCoast);
    shooter.setInverted(true); // TODO: Change if necessary
    shooter.setClosedLoopRampRate(.02);
    // shooterPIDFController = shooter.getPIDController();

    // setGains(shooterPIDFController);
  } 

  @Override
  public void periodic() {
    // SmartDashboard.putData("setPower", setPower());
  }

  public void setSpeed(double speed) {
    shooter.set(speed);
  }

  public void stop() {
    setSpeed(0);
  }

}
