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
  private CANSparkMax shooterMotor;
  private CANEncoder shooterMotorEncoder;
  private CANPIDController shooterMotorPIDFController;

  private double setSpeed = 0; // what were setting when we call the function  

  private static final int PRACTICAL_RPM_MAX = 5000;

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

    // MOTOR CONFIG 
    shooterMotor = new CANSparkMax(ShooterConstants.SHOOTER_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    shooterMotor.setInverted(false); // TODO: check to see if this needs to be change 
    shooterMotorPIDFController = shooterMotor.getPIDController();
    shooterMotorEncoder = shooterMotor.getEncoder();

    setGains(shooterMotorPIDFController, ShooterConstants.ShooterMotorGains);

    shooterMotor.burnFlash();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter Velocity", getShooterVelocity());
  }

  public void setPower(double pwr) {
    shooterMotor.set(pwr);
  }

  public void setShooterVelocity(double velocity) {
      setSpeed = velocity;
      if(setSpeed > 100){ // if motors running
        this.shooterMotorPIDFController.setReference(LightningMath.constrain(setSpeed, 0, PRACTICAL_RPM_MAX), ControlType.kVelocity);
      } else { // setting motors equal to zero
          setSpeed = 0;
          this.shooterMotorPIDFController.setReference(0, ControlType.kVoltage);
      }
  }

  public void stop(){
      setShooterVelocity(0);
  }

  public double getShooterVelocity(){
      return shooterMotorEncoder.getVelocity();
  }

}
