package org.firstinspires.ftc.teamcode.Actuators;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gamepad;


//shooty
@Disabled
@TeleOp
public class Motor2 extends OpMode {
    private DcMotor outtakemotor;
    HardwareMap hwMap;
    Gamepad gpad2;
    boolean shoot = gpad2.b;

    public Motor2(HardwareMap ahwMap){
        hwMap = ahwMap;
    }


    @Override
    public void init() {
        outtakemotor = hardwareMap.get(DcMotor.class, "motor2");
        outtakemotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtakemotor.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    @Override
    public void loop() {
        if (gpad2.a){
            outtakemotor.setPower(1);
        } else{
            outtakemotor.setPower(0);
        }
    }

    public void initOuttake(HardwareMap hwMap){
        outtakemotor = hwMap.get(DcMotor.class, "motor2");
        outtakemotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        outtakemotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        outtakemotor.setDirection(DcMotorSimple.Direction.FORWARD);
        outtakemotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
