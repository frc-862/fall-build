package com.lightningrobotics.howitzer;

import com.lightningrobotics.howitzer.drivetrain.Constants.RobotMap;
import com.lightningrobotics.howitzer.drivetrain.commands.SwerveDriveCommand;
import com.lightningrobotics.howitzer.drivetrain.subsystems.Drivetrain;
import com.lightningrobotics.howitzer.drivetrain.util.LightningIMU;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.lightning.LightningConfig;
import frc.lightning.LightningContainer;
import frc.lightning.subsystems.LightningDrivetrain;

public class HowitzerContainer extends LightningContainer {

    // GAMEPADS
    private static final XboxController driver = new XboxController(0);

    // ROBOT COMPONENTS
    private static final LightningIMU imu = LightningIMU.pigeon(RobotMap.PIGEON);

    // SUBSYSTEMS
    private static final Drivetrain drivetrain = new Drivetrain();

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
    protected void configureButtonBindings() { }

    @Override
    protected void configureSystemTests() { }

    @Override
    public LightningConfig getConfig() { return null; }

    @Override
    public LightningDrivetrain getDrivetrain() { return null; }

    @Override
    protected void releaseDefaultCommands() { }

}

