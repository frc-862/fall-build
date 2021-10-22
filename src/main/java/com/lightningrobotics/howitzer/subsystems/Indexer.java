// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.howitzer.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.lightningrobotics.howitzer.HowitzerConstants.IndexerConstants;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {

  private WPI_VictorSPX indexerMotor;
  private Servo door;

  private int servoDefultAngle = 0; // TODO: change when we know the defult angle for the servo to rest 

  /** Creates a new Indexer. */
  public Indexer() {
    indexerMotor = new WPI_VictorSPX(IndexerConstants.INDEXER_MOTOR);
    door = new Servo(IndexerConstants.INDEXER_SERVO);

  }

  public void setPower(double pwr){
    indexerMotor.set(ControlMode.PercentOutput, pwr);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop(){
    indexerMotor.set(ControlMode.PercentOutput, 0);
  }

}
