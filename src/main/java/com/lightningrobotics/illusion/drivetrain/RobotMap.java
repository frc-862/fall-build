/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.lightningrobotics.illusion.drivetrain;

import frc.lightning.util.REVGains;

public class RobotMap {

    // DRIVETRAIN
    public static final int MOTORS_PER_SIDE = 3;
    public static final int LEFT_1_CAN_ID   = 1; // MASTER
    public static final int LEFT_2_CAN_ID   = 2;
    public static final int LEFT_3_CAN_ID   = 3;
    public static final int RIGHT_1_CAN_ID  = 4; // MASTER
    public static final int RIGHT_2_CAN_ID  = 5;
    public static final int RIGHT_3_CAN_ID  = 6;
    public static final int LEFT_ENCODER_CHANNEL_A = 0;
    public static final int LEFT_ENCODER_CHANNEL_B = 1;
    public static final int RIGHT_ENCODER_CHANNEL_A = 2;
    public static final int RIGHT_ENCODER_CHANNEL_B = 3;

    // COLLECTOR
    public static final int COLLECTOR_ID = 30; // victor TODO: change when known

    // SHOOTER
    public static final int SHOOTER_ID = 8;
    public static final int NEO_MAX_RPM = 5700; // can spark max
    public static REVGains shooterGains = new REVGains(.00026, 0.000000004, 0.0, 0.000175, 0.0, 1.0, -1.0, NEO_MAX_RPM);

    // INDEXER
    public static final int INDEXER_ID = 12; // can spark max TODO: i thought it was right but it's maybe not?
    
    // TODO: add correct ids ASAP
}
