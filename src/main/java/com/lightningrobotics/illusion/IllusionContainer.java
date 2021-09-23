package com.lightningrobotics.illusion;

import com.lightningrobotics.illusion.drivetrain.Drivetrain;
import com.lightningrobotics.illusion.drivetrain.JoystickConstants;
import com.lightningrobotics.illusion.drivetrain.IllusionConfig;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.lightning.LightningConfig;
import frc.lightning.LightningContainer;
import frc.lightning.commands.VoltDrive;
import frc.lightning.subsystems.*;
import frc.lightning.subsystems.IMU;


public class IllusionContainer extends LightningContainer {

    // GAMEPADS
    private static final XboxController driver = new XboxController(JoystickConstants.DRIVER);

    // ROBOT COMPONENTS
    private static final LightningConfig config = new IllusionConfig();
    private static final IMU imu = IMU.navX();

    // SUBSYSTEMS
    private static final LightningDrivetrain drivetrain = new Drivetrain(config, imu.heading(), imu.zero());

    @Override
    protected void configureButtonBindings() {}

    @Override
    protected void configureSystemTests() {}

    @Override
    protected void configureDefaultCommands() {
        drivetrain.setDefaultCommand(new VoltDrive(drivetrain, () -> -driver.getY(GenericHID.Hand.kLeft), () -> -driver.getY(GenericHID.Hand.kRight)));
    }

    @Override
    protected void releaseDefaultCommands() {}

    @Override
    protected void initializeDashboardCommands() {}

    @Override
    protected void configureAutonomousCommands() {}

    @Override
    public LightningConfig getConfig() { return config; }

    @Override
    public LightningDrivetrain getDrivetrain() { return drivetrain; }
}
