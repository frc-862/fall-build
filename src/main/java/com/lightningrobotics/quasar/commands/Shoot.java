// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.quasar.commands;

import com.lightningrobotics.quasar.subsystems.Indexer;
import com.lightningrobotics.quasar.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shoot extends CommandBase {
  /** Creates a new Shoot. */
  private Shooter shooter;
  private Indexer indexer;
  private double power;
  public Shoot(Shooter shooter, Indexer indexer, double power) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter, indexer);
    this.shooter = shooter;
    this.indexer = indexer;
    this.power = power;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    indexer.index(0.5);
    shooter.shoot(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
