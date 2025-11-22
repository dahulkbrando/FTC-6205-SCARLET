package org.firstinspires.ftc.teamcode.TeleOps;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.teamcode.DriveTrain.Drivetrain;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@Config
@TeleOp
public class MainOp extends LinearOpMode {
    private DcMotor frontLeftMotor = null;
    private DcMotor frontRightMotor = null;
    private DcMotor backLeftMotor = null;
    private DcMotor backRightMotor = null;
    private IMU imu;
    private double refHeading, botHeading;
    private Drivetrain drivetrain;


    private double x, y, rotX, rotY, turn;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Ready to Start");
        telemetry.update();
        initMotors();
        initIMU();

        waitForStart();


        while (opModeIsActive()){
            //define your controls
            y= gamepad1.left_stick_y;
            x = gamepad1.left_stick_x;
            turn = gamepad1.right_stick_x;

            rotX = x;
            rotY = y;



            if (gamepad1.start){
                refHeading = 0;
                //botHeading = 0;
                imu.resetYaw();
            }

            //equations
            double frontLeftPower = (rotY - rotX - turn);
            double frontRightPower = (-rotY - rotX - turn);
            double backLeftPower = (rotY + rotX - turn);
            double backRightPower = (-rotY + rotX - turn);

            //set power
            frontLeftMotor.setPower(frontLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backLeftMotor.setPower(backLeftPower);
            backRightMotor.setPower(backRightPower);

            //telemetry
            telemetry.addData("X Value", rotX);
            telemetry.addData("Y Value", rotY);
            telemetry.addData("bot heading", botHeading);
            telemetry.addData("ref heading", refHeading);
            telemetry.update();

        }
    }

    private void initMotors(){
            frontRightMotor = hardwareMap.dcMotor.get("frontright");
            frontLeftMotor = hardwareMap.dcMotor.get("frontleft");
            backLeftMotor = hardwareMap.dcMotor.get("backleft");
            backRightMotor = hardwareMap.dcMotor.get("backright");
//        drivetrain = new Drivetrain(hardwareMap);
    }

    private void initIMU() {
        imu = hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        imu.initialize(parameters);
    }

}
