package com.lightningrobotics.illusion;

import java.util.Map;

import com.lightningrobotics.illusion.commands.Shoot;
import com.lightningrobotics.illusion.drivetrain.Drivetrain;
import com.lightningrobotics.illusion.drivetrain.JoystickConstants;
import com.lightningrobotics.illusion.subsystems.Collector;
import com.lightningrobotics.illusion.subsystems.Indexer;
import com.lightningrobotics.illusion.subsystems.Shooter;
import com.lightningrobotics.illusion.drivetrain.IllusionConfig;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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
    private static final Indexer indexer = new Indexer();
    private static final Collector collector = new Collector();
    private static final Shooter shooter = new Shooter();

    @Override
    protected void configureButtonBindings() {
        // (new JoystickButton(driver, 5)).whileHeld(new InstantCommand(() -> {indexer.setPower(0.5); System.out.println("oisfjoisd");}));
        // (new JoystickButton(driver, 6)).whileHeld(new InstantCommand(() -> shooter.setSpeed(0.5)));
        (new JoystickButton(driver, 6)).whenPressed(new Shoot(indexer, shooter));


    }

    @Override
    protected void configureSystemTests() {}

    @Override
    protected void configureDefaultCommands() {
        // shooter.setDefaultCommand(new Shoot(indexer, shooter));
        drivetrain.setDefaultCommand(new VoltDrive(drivetrain, () -> -driver.getY(GenericHID.Hand.kLeft), () -> -driver.getY(GenericHID.Hand.kRight)));
    }

    @Override
    protected void releaseDefaultCommands() {}

    @Override
    protected void initializeDashboardCommands() {
        // Indexer Tab
        final var indexer_tab = Shuffleboard.getTab("Indexer"); // create indexer tab

        final var indexerSpeed = indexer_tab.add("SetIndexerSpeed", 0) // add indexerSpeed widget to the indexer tab in Shuffleboard
                .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -1, "max", 1)).getEntry(); // adds a slider to change indexer speed [1, 1]
        
        indexer_tab.add("Stop Index", new InstantCommand(() -> indexer.stop(), indexer));

        indexerSpeed.addListener((e) -> {
            indexer.setPower(indexerSpeed.getDouble(0)); // creates a listener that watches the indexerSpeed tab and sets the power to the value of the tab 
        }, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);
        
        // indexer_tab.addBoolean("isTriggerPressed", )
        // Collector Tab
        final var collector_tab = Shuffleboard.getTab("Collector");

        collector_tab.add("Stop Collect", new InstantCommand(() -> collector.stopCollecting(), collector));

        final var collectorSpeed = collector_tab.add("SetCollectorSpeed", 0) // same as indexer speed but with collector
                .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -1, "max", 1)).getEntry(); 
        
        collectorSpeed.addListener((e) -> {
            collector.setCollectorPower(collectorSpeed.getDouble(0));
        }, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);
        
        // Shooter Tab
        final var shooter_tab = Shuffleboard.getTab("Shooter");

        final var shooterSpeed = shooter_tab.add("SetShooterSpeed", 0) // same as shooter speed but with collector
        .withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -1, "max", 1)).getEntry(); 

        shooter_tab.add("Stop Shooting", new InstantCommand(() -> shooter.stop(), shooter));
        shooter_tab.add("Shoot for 5 sec (with index)", new Shoot(indexer, shooter));

        shooterSpeed.addListener((e) -> {
            shooter.setShooterVelocity(shooterSpeed.getDouble(0)); 
        }, EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

        
    }

    @Override
    protected void configureAutonomousCommands() {}

    @Override
    public LightningConfig getConfig() { return config; }

    @Override
    public LightningDrivetrain getDrivetrain() { return drivetrain; }
}
