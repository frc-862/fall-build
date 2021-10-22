// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.howitzer.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.lightningrobotics.howitzer.HowitzerConstants.IndexerConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {

  private CANSparkMax indexerMotor;
  private Servo door;

  private int servoDefultAngle = 0; // TODO: change when we know the defult angle for the servo to rest 

  /** Creates a new Indexer. */
  public Indexer() {
    indexerMotor = new CANSparkMax(IndexerConstants.INDEXER_MOTOR, MotorType.kBrushed);
    door = new Servo(IndexerConstants.INDEXER_SERVO);

  }

  public void setPower(double pwr){
    indexerMotor.set(pwr);
  }

  @Override
  public void periodic() {
    
  }

  public void stop(){
    setClosed();
    indexerMotor.set(0);
  }

  public void setClosed(){
    door.setAngle(0); // TODO: find the angle at which the indexer hole would be closed
  }

  public void setOpen(){
    door.setAngle(180); // TODO: find open angle
  }

}
