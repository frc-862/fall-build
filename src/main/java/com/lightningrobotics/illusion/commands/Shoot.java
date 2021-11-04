// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.illusion.commands;

import com.lightningrobotics.illusion.subsystems.Indexer;
import com.lightningrobotics.illusion.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shoot extends CommandBase {
  private Indexer indexer;
  private Shooter shooter;

  private double time;

  public Shoot(Indexer indexer, Shooter shooter) {
    this.indexer = indexer;
    this.shooter = shooter;

    addRequirements(indexer, shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.setShooterVelocity(-0.6); // TODO: change later
    Timer.delay(1); // pause for a second to let shooter speed up 
    indexer.feedShooter(); // set indexer velocity and shooter velocity

    time = Timer.getFPGATimestamp(); // initiate time
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }
 
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stop(); // when stopped stop shooter and indexer
    indexer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // return ((Timer.getFPGATimestamp() - time) > 7); // TODO: Change Later
    // when current time exceed 5 seconds past the original time, the command will stop
    return false;
  }
}
