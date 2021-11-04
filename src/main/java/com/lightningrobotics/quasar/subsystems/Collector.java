// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.quasar.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collector extends SubsystemBase {
  /** Creates a new Collector. */
  CANSparkMax motor = new CANSparkMax(0, MotorType.kBrushed);
  public Collector() {
    motor.burnFlash();
    motor.setIdleMode(IdleMode.kBrake);
  }

  public void collect(double speed) 
  {
    motor.set(speed);
  }

  public void stop() 
  {
    collect(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
