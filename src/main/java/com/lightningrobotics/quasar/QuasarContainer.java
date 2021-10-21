package com.lightningrobotics.quasar;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Map;

import com.lightningrobotics.quasar.drivetrain.Drivetrain;
import com.lightningrobotics.quasar.drivetrain.QuasarConfig;
import com.lightningrobotics.quasar.subsystems.Collector;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    private static final Collector collector = new Collector();

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
    protected void initializeDashboardCommands() 
    { 
        Shuffleboard.getTab("collector").add("SetPoint", 1).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of(min));

    }

    @Override
    protected void configureAutonomousCommands() { }

    @Override
    public LightningConfig getConfig() { return config; }

    @Override
    public LightningDrivetrain getDrivetrain() { return drivetrain; }
    
}
