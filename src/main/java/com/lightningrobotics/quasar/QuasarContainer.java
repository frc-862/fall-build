package com.lightningrobotics.quasar;

import com.lightningrobotics.quasar.drivetrain.Drivetrain;
import com.lightningrobotics.quasar.drivetrain.QuasarConfig;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.lightning.LightningConfig;
import frc.lightning.LightningContainer;
import frc.lightning.commands.VoltDrive;
import frc.lightning.subsystems.IMU;
import frc.lightning.subsystems.LightningDrivetrain;

public class QuasarContainer extends LightningContainer {

    // GAMEPADS
    private static final XboxController driver = new XboxController(0);

    // ROBOT COMPONENTS
    private static final LightningConfig config = new QuasarConfig();
    private static final IMU imu = IMU.none();

    // SUBSYSTEMS
    private static final LightningDrivetrain drivetrain = new Drivetrain(config, imu.heading(), imu.zero());

    @Override
    protected void configureDefaultCommands() {
        drivetrain.setDefaultCommand(new VoltDrive(drivetrain, () -> -driver.getY(GenericHID.Hand.kLeft), () -> -driver.getY(GenericHID.Hand.kRight)));
    }
    
    @Override
    protected void configureButtonBindings() { }

    @Override
    protected void configureSystemTests() { }

    @Override
    protected void releaseDefaultCommands() { }

    @Override
    protected void initializeDashboardCommands() { }

    @Override
    protected void configureAutonomousCommands() { }

    @Override
    public LightningConfig getConfig() { return config; }

    @Override
    public LightningDrivetrain getDrivetrain() { return drivetrain; }
    
}
