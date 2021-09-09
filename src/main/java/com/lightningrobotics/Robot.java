// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.lightningrobotics;

import frc.lightning.LightningRobot;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.lightningrobotics.howitzer.HowitzerContainer;
import com.lightningrobotics.illusion.IllusionContainer;
import com.lightningrobotics.quasar.QuasarContainer;

import frc.lightning.LightningContainer;

public class Robot extends LightningRobot {

    public Robot() {
        super(getRobot());
    }

    private static LightningContainer getRobot() {
        if(isHowitzer()) return new HowitzerContainer();
        if(isQuasar()) return new QuasarContainer();
        if(isIllusion()) return new IllusionContainer();
        return null;
    }

    private static boolean isHowitzer() {
        return Files.exists(Paths.get("/home/lvuser/howitzer"));
    }

    private static boolean isQuasar() {
        return Files.exists(Paths.get("/home/lvuser/quasar"));
    }

    private static boolean isIllusion() {
        return Files.exists(Paths.get("/home/lvuser/illusion"));
    }

}
