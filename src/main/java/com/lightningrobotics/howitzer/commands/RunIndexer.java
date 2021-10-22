// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics.howitzer.commands;

import com.lightningrobotics.howitzer.subsystems.Indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunIndexer extends CommandBase {

  private Indexer indexer;
  private double power = 0.2; // TODO: change to the proper speed

  /** Creates a new RunIndexer. */
  public RunIndexer(Indexer indexer) {
    this.indexer = indexer;

    addRequirements(indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    indexer.setOpen();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    indexer.setPower(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    indexer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
