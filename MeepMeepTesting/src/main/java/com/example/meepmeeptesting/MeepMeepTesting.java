package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

/*
    First, click on the drop down menu on the top bar of Android Studio, where it says "TeamCode" with a little Android logo next to it.
    Click Edit Configurations
    Click on the "+" symbol in the top left of the window, and when it prompts you, select "Application".
    Change the name to your liking (ex. meepmeep-run)
    Where it says "module not specified", click to open the dropdown, then select your JRE.
    Where it says "cp " click it to open the dropdown, and then select FtcRobotController.MeepMeepTesting.main
    Where it says "Main Class", click the little "file" icon to the right of the text and then select the name of the main class for your MeepMeepTesting module.
    From here, in the bottom right of the window, press "Apply" then "Ok".
    It will now automatically switch to that Run/Debug Configuration profile.

    https://github.com/acmerobotics/MeepMeep?tab=readme-ov-file#-installing-android-studio
 */

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(0, 0, 0))
                        .forward(30)
                        .turn(Math.toRadians(90))
                        .forward(30)
                        .turn(Math.toRadians(90))
                        .forward(30)
                        .turn(Math.toRadians(90))
                        .forward(30)
                        .turn(Math.toRadians(90))
                        .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}