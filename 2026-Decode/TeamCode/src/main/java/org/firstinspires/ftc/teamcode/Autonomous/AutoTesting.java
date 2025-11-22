package org.firstinspires.ftc.teamcode.Autonomous;
import static org.firstinspires.ftc.teamcode.Sensing.FieldCoredinates.*;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config
@Autonomous
public class AutoTesting extends LinearOpMode {
    public static double Start_Angle = Math.toRadians(0);
    public static double Start_X = I;
    public static double Start_Y_Offset = 0;
    public static double Start_Y = C - Start_Y_Offset;
    public static double Wall_X = II;
    public static double Wall_X_Offset = PanelWidth/2;
    public static double Wall_Y = E;
    public static double Wall_Y_Offset = PanelWidth/2;
    public static double H_Offset = Math.toRadians(-2); //irrelevant as of rn 
    public static double X_Offset = 0;
    public static double testVar = 0;
    MecanumDrive drive;


    //trajectories
    TrajectoryActionBuilder
        initTraj,
        trajA,
        trajB;

    Pose2d startPose = new Pose2d(Start_X, Start_Y, Start_Angle);
    Vector2d startWallPose = new Vector2d(Wall_X + Wall_X_Offset, Wall_Y + Wall_Y_Offset);
    Vector2d shootWallPose = new Vector2d(Wall_X + Wall_X_Offset, Wall_Y - Wall_Y_Offset);


    @Override
    public void runOpMode() throws InterruptedException {
    initSubsystems();
    buildTrajectories();

        waitForStart();
        if(isStopRequested()) return;

        //TODO --- point a
        Actions.runBlocking(
                new ParallelAction(
                        new SleepAction(1.0),
                        trajA.build()
                )
        );

        //TODO --- point b
        Actions.runBlocking(
                new ParallelAction(
                        new SleepAction(2.0),
                        trajB.build()
                )
        );






    }
    private void initSubsystems(){
        drive = new MecanumDrive(hardwareMap, startPose);
    }

    private void buildTrajectories(){
    initTraj = drive.actionBuilder(startPose);


        //TODO --- go to point A
            trajA = initTraj.endTrajectory().fresh()
                .strafeToLinearHeading(new Vector2d(V + (X_Offset), C), NORTHWEST);
        //TODO --- go to point B
        trajB = trajA.endTrajectory().fresh()
                .strafeToLinearHeading(new Vector2d(I + (X_Offset), C), NORTH);




    }
}

