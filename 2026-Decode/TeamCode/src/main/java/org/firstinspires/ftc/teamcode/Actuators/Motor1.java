package org.firstinspires.ftc.teamcode.Actuators;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;


//intake motor
@Disabled
@TeleOp
public class Motor1 extends OpMode {
    private DcMotor intakemotor;
    HardwareMap hwMap;
    Gamepad gpad2;
    boolean power = gamepad2.a;

    public Motor1(HardwareMap ahwMap){
        hwMap = ahwMap;

    }


    @Override
    public void init() {
    intakemotor = hardwareMap.get(DcMotor.class, "motor1");
    intakemotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    intakemotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop() {
        if (gamepad2.a){
            intakemotor.setPower(1);
        } else{
            intakemotor.setPower(0);
        }


        telemetry.addData("intake going?", intakemotor.isBusy());

    }

    public void initIntake(HardwareMap hwMap){
        intakemotor = hwMap.get(DcMotor.class, "motor1");
        intakemotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakemotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakemotor.setDirection(DcMotorSimple.Direction.FORWARD);
        intakemotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}
