// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.quasar.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
  VictorSPX motor = new VictorSPX(0); // Change to correct indexer ID
  public Indexer() {}

  public void index(double speed) {
    motor.set(ControlMode.PercentOutput, speed);
  }

  public void stop() {
    index(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
