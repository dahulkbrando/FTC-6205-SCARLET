package org.firstinspires.ftc.teamcode.DriveTrain;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {


    //motors
    public DcMotor frontleft;
    public DcMotor frontright;
    public DcMotor backleft;
    public DcMotor backright;

    HardwareMap hdwMp;


    public Drivetrain(HardwareMap ahwMap){
        hdwMp = ahwMap;
        this.initMotors(ahwMap);
    }

    public void power(double frontLeftPower,
                      double frontRightPower,
                      double backLeftPower,
                      double backRightPower){
        frontleft.setPower(frontLeftPower);
        frontright.setPower(frontRightPower);
        backleft.setPower(backLeftPower);
        backright.setPower(backRightPower);
    }

    public void initMotors(HardwareMap ahwMap){
        hdwMp = ahwMap;

        //mapping
        frontleft = hdwMp.dcMotor.get("frontleft");
        frontright = hdwMp.dcMotor.get("frontright");
        backleft = hdwMp.dcMotor.get("backleft");
        backright = hdwMp.dcMotor.get("backright");

        //the direction
        frontright.setDirection(DcMotorSimple.Direction.REVERSE);
        backright.setDirection(DcMotorSimple.Direction.REVERSE);
        frontleft.setDirection(DcMotorSimple.Direction.FORWARD);
        backleft.setDirection(DcMotorSimple.Direction.FORWARD);

        //the brake
        frontleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
