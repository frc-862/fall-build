package com.lightningrobotics.howitzer;

import com.lightningrobotics.howitzer.HowitzerConstants.IndexerConstants;
import com.lightningrobotics.howitzer.HowitzerConstants.JoystickConstants;
import com.lightningrobotics.howitzer.commands.RunIndexer;
import com.lightningrobotics.howitzer.commands.RunShooter;
import com.lightningrobotics.howitzer.drivetrain.Constants;
import com.lightningrobotics.howitzer.drivetrain.Constants.RobotMap;
import com.lightningrobotics.howitzer.drivetrain.commands.SwerveDriveCommand;
import com.lightningrobotics.howitzer.drivetrain.subsystems.Drivetrain;
import com.lightningrobotics.howitzer.drivetrain.util.LightningIMU;
import com.lightningrobotics.howitzer.subsystems.Indexer;
import com.lightningrobotics.howitzer.subsystems.Shooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.lightning.LightningConfig;
import frc.lightning.LightningContainer;
import frc.lightning.subsystems.LightningDrivetrain;
import com.lightningrobotics.howitzer.HowitzerConstants.JoystickConstants;

public class HowitzerContainer extends LightningContainer {

    // GAMEPADS
    private static final XboxController driver = new XboxController(0);
    private static final XboxController operator = new XboxController(JoystickConstants.OPERATOR);

    // ROBOT COMPONENTS
    private static final LightningIMU imu = LightningIMU.pigeon(RobotMap.PIGEON);

    // SUBSYSTEMS
    private static final Drivetrain drivetrain = new Drivetrain();
    private static final Shooter shooter = new Shooter();
    private static final Indexer indexer = new Indexer();

    @Override
    protected void configureDefaultCommands() {
        drivetrain.setDefaultCommand(new SwerveDriveCommand(drivetrain, imu, driver, true));
    }

    @Override
    protected void initializeDashboardCommands() {
        var tab = Shuffleboard.getTab("Commands");
        tab.add("Reset Heading", new InstantCommand(imu::reset, imu));
    }

    @Override
    protected void configureAutonomousCommands() { }

    @Override
    protected void configureButtonBindings() { 
        (new JoystickButton(operator, 1)).whileHeld(new RunShooter(shooter)); // TODO: change the the button we want to run the shooter
        (new JoystickButton(operator, 1)).whileHeld(new RunIndexer(indexer, IndexerConstants.MOTOR_POWER)); // TODO: change the the button we want to run the shooter
        (new JoystickButton(operator, 2)).whileHeld(new RunIndexer(indexer, -IndexerConstants.MOTOR_POWER)); // reverse and ^
    }

    @Override
    protected void configureSystemTests() { }

    @Override
    public LightningConfig getConfig() { return null; }

    @Override
    public LightningDrivetrain getDrivetrain() { return null; }

    @Override
    protected void releaseDefaultCommands() { }

}

