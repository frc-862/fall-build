// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.illusion.subsystems;

import com.lightningrobotics.illusion.drivetrain.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collector extends SubsystemBase {
  CANSparkMax collector;

  public Collector() {
    collector = new CANSparkMax(RobotMap.COLLECTOR_ID, MotorType.kBrushless); // identify collector motor
  }

  public void SetCollectorSpeed(double speed){
    collector.set(speed); // set motor power
  }

  public void stop() {
    SetCollectorSpeed(0); // call setCollectorPower and set it to 0
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
