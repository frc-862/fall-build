// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.illusion.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collector extends SubsystemBase {
  VictorSPX collector;
  Servo dropMotor;

  public Collector() {
    collector = new VictorSPX(1); // TODO: change device number later
    dropMotor = new Servo(1); // TODO: change device number later
  }

  public void setCollectorPower(double pwr){
    collector.set(ControlMode.PercentOutput, pwr);
  }

  public void stopCollecting() {
    setCollectorPower(0);
  }
  
  public void drop() {
    dropMotor.setAngle(1); // TODO: set later (degrees)
  }

  public void lift() {
    dropMotor.setAngle(0); // TODO: set later (degrees)
  } 


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
