
package com.lightningrobotics.howitzer;

import frc.lightning.util.REVGains;

public class HowitzerConstants {

    public static final int NEO_MAX_RPM = 5700;

    public static class IndexerConstants{
        public static final int INDEXER_MOTOR = 4; 
        public static final double MOTOR_POWER = 0.40; 
    }

    public static class ShooterConstants{
        public static final int SHOOTER_MOTOR = 6; 
        public static REVGains ShooterMotorGains = new REVGains(.00026, 0.000000004, 0.0, 0.000175, 0.0, 1.0, -1.0, NEO_MAX_RPM); 
    }

    public static class JoystickConstants {
    }

}
