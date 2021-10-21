
package com.lightningrobotics.howitzer;

import frc.lightning.util.REVGains;

public class HowitzerConstants {

    public static final int NEO_MAX_RPM = 5700;

    public static class ShooterConstants{
        public static final int SHOOTER_MOTOR = 1; // TODO: Change when we know the id of the motor
        public static REVGains ShooterMotorGains = new REVGains(0.0, 0.0, 0.0, 0.0, 0.0, 1.0, -1.0, NEO_MAX_RPM); // TODO: set these values when ready to tune pid
    }

    public static class JoystickConstants {
        public static final int OPERATOR = 0;
    }

}
