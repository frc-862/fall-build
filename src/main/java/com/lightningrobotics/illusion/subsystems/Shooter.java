// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.illusion.subsystems;

import com.lightningrobotics.illusion.drivetrain.RobotMap;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lightning.util.LightningMath;
import frc.lightning.util.REVGains;

public class Shooter extends SubsystemBase {
  
  private CANSparkMax shooter; // set shooter motor

  private CANPIDController shooterPIDFController; // identify pid controller

  private double setSpeed = 0; // setSpeed variable (initially 0)
  public double shootersetpoint = 0; // shootersetpoint (initially 0)

  double backspin = 1500; // set backspin
  private static final int PRACTICAL_RPM_MAX = 5000; // set practical limit for the motor
  /** Creates a new Shoooter. 
   * @param Constants */

  private static void setGains(CANPIDController controller, REVGains gains) { // setGains function, set the controller values
    controller.setP(gains.getkP());
    controller.setI(gains.getkI());
    controller.setD(gains.getkD());
    controller.setFF(gains.getkFF());
    controller.setIZone(gains.getkIz());
    controller.setOutputRange(gains.getkMinOutput(), gains.getkMaxOutput());
  }
  public Shooter() {

    shooter = new CANSparkMax(RobotMap.SHOOTER_ID, MotorType.kBrushless); // initiate shooter motor with shooter id
    
    shooter.setIdleMode(CANSparkMax.IdleMode.kCoast); // set idlemode
    shooter.setInverted(true); // TODO: Change if necessary
    shooter.setClosedLoopRampRate(.02); // maximum rate of change
    shooterPIDFController = shooter.getPIDController(); // take pidf controller

    setGains(shooterPIDFController, RobotMap.shooterGains); // set gains of the shooter pidf controller   

    shooter.burnFlash(); // add settings to the shooter
  } 

  @Override
  public void periodic() {
  }

  public void setShooterVelocity(double velocity) {
    setSpeed = velocity;
    if(setSpeed > 100){ // if motors running 
        shootersetpoint = velocity - backspin;
        this.shooterPIDFController.setReference(LightningMath.constrain(shootersetpoint, 0, PRACTICAL_RPM_MAX), ControlType.kVelocity);
    } else { // setting motors equal to zero
        shootersetpoint = 0;
        this.shooterPIDFController.setReference(0, ControlType.kVoltage);
    }
 }

 /*
 public void setShooterVelocity(double velocity) {
   shooter.set(velocity);
 }
*/

  public void stop() {
    setShooterVelocity(0);
  }

}
