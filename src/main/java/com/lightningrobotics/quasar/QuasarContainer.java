package com.lightningrobotics.quasar;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Map;

import com.lightningrobotics.quasar.drivetrain.Drivetrain;
import com.lightningrobotics.quasar.drivetrain.QuasarConfig;
import com.lightningrobotics.quasar.subsystems.Collector;
import com.lightningrobotics.quasar.subsystems.Indexer;
import com.lightningrobotics.quasar.subsystems.Shooter;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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
    private static final Shooter shooter = new Shooter();
    private static final Indexer indexer = new Indexer();

    @Override
    protected void configureDefaultCommands() {
        drivetrain.setDefaultCommand(new VoltDrive(drivetrain, () -> -driver.getY(GenericHID.Hand.kLeft), () -> -driver.getY(GenericHID.Hand.kRight)));
    }
    
    @Override
    protected void configureButtonBindings() {
        (new JoystickButton(driver, 2)).whenPressed(new InstantCommand(() -> { indexer.index(1); shooter.setSpeed(1); }));  // x
        (new JoystickButton(driver, 2)).whenReleased(new InstantCommand(() -> { indexer.stop(); shooter.stop(); }));
        (new JoystickButton(driver, 0)).whenPressed(new InstantCommand(() -> collector.collect(1))); // a
        (new JoystickButton(driver, 0)).whenReleased(new InstantCommand(() -> collector.stop()));
     }

    @Override
    protected void configureSystemTests() { }

    @Override
    protected void releaseDefaultCommands() { }

    @Override
    protected void initializeDashboardCommands() 
    { 
        
    }

    @Override
    protected void configureAutonomousCommands() { }

    @Override
    public LightningConfig getConfig() { return config; }

    @Override
    public LightningDrivetrain getDrivetrain() { return drivetrain; }
    
}
