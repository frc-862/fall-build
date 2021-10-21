// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.howitzer.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ControlType;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lightning.util.LightningMath;
import frc.lightning.util.REVGains;

import com.lightningrobotics.howitzer.HowitzerConstants;
import com.lightningrobotics.howitzer.HowitzerConstants.*;

public class Shooter extends SubsystemBase {

  // Motor stuff
  private CANSparkMax motor1;
  private CANEncoder motor1encoder;
  private CANPIDController motor1PIDFController;

  public double motor1setpoint = 0; // what we want it to be
  private double setSpeed = 0; // what were setting when we call the function  

  private static final int PRACTICAL_RPM_MAX = 5000;
  private int test = 1;

  private boolean armed = false; 

  private static void setGains(CANPIDController controller, REVGains gains) {
    controller.setP(gains.getkP());
    controller.setI(gains.getkI());
    controller.setD(gains.getkD());
    controller.setFF(gains.getkFF());
    controller.setIZone(gains.getkIz());
    controller.setOutputRange(gains.getkMinOutput(), gains.getkMaxOutput());
}


  /** Creates a new Shooter2. */
  public Shooter() {
    NetworkTableInstance.getDefault().getTable("Shooter").getEntry("Velocity").setDouble(motor1setpoint);

    // MOTOR CONFIG 
    motor1 = new CANSparkMax(ShooterConstants.SHOOTER_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    motor1.setInverted(false); // TODO: check to see if this needs to be change 
    motor1PIDFController = motor1.getPIDController();
    motor1encoder = motor1.getEncoder();

    // setGains(motor1PIDFController, ShooterConstants.ShooterMotorGains); TODO: use this when ready to tune pid

    motor1.burnFlash();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Current Shooter Velocity", getShooterVelocity());
  }

  public void setPower(double pwr) {
    motor1.set(pwr);
  }

  public void setShooterVelocity(double velocity) {
      setSpeed = velocity;
      if(setSpeed > 100){ // if motors running
        this.motor1PIDFController.setReference(LightningMath.constrain(setSpeed, 0, PRACTICAL_RPM_MAX), ControlType.kVelocity);
      } else { // setting motors equal to zero
          setSpeed = 0;
          this.motor1PIDFController.setReference(0, ControlType.kVoltage);
      }
  }

  public void stop(){
      setShooterVelocity(0);
  }

  public double getShooterVelocity(){
      return motor1encoder.getVelocity();
  }

}
