// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.illusion.commands;

import com.lightningrobotics.illusion.IllusionContainer;
import com.lightningrobotics.illusion.subsystems.Indexer;
import com.lightningrobotics.illusion.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
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
    shooter.setSpeed(0.5); // TODO: change later
    
    time = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    indexer.feedShooter();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stop();
    indexer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return ((Timer.getFPGATimestamp() - time) > 5); // TODO: Change Later
  }
}
