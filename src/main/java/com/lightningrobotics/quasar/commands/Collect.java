// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.quasar.commands;

import com.lightningrobotics.quasar.subsystems.Collector;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Collect extends CommandBase {
  /** Creates a new Collect. */
  private Collector collector;
  public Collect(Collector collector) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(collector);
    this.collector = collector;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    collector.collect(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    collector.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}