// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.quasar.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private CANSparkMax motor;

  public Shooter() {
    motor = new CANSparkMax(0, MotorType.kBrushed);
  }

  public void shoot(double speed){
    motor.set(speed);
  }
  public void stop(){
    shoot(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

