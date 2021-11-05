// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.howitzer.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.lightningrobotics.howitzer.HowitzerConstants.IndexerConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {

  private VictorSPX indexerMotor;

  /** Creates a new Indexer. */
  public Indexer() {
    indexerMotor = new VictorSPX(IndexerConstants.INDEXER_MOTOR);
    indexerMotor.setInverted(true);

  }

  public void setPower(double pwr){
    indexerMotor.set(ControlMode.PercentOutput, pwr);
  }

  @Override
  public void periodic() {
    
  }

  public void stop(){
    indexerMotor.set(ControlMode.PercentOutput, 0);
  }
}
