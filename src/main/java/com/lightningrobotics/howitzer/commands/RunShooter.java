package com.lightningrobotics.howitzer.commands;

import com.lightningrobotics.howitzer.subsystems.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunShooter extends CommandBase {

    private Shooter shooter;
    private double setVelocity = 2000; // TODO: change after testing

    public RunShooter(Shooter shooter){
        this.shooter = shooter;

        addRequirements(shooter);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.setShooterVelocity(setVelocity);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("I am ending " + interrupted);
    shooter.setShooterVelocity(0d);
    shooter.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return false;
  }
    
}
