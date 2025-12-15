package org.firstinspires.ftc.teamcode.Sensing;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class DeadWheels {
    public DcMotor encoderback, encoderright, encoderleft;
    public double encLeftValue, encRightValue, encFrontValue;
    public static double ticksToInches = 376;
    HardwareMap hwMap;

    public DeadWheels(HardwareMap ahwMap){initEncoders(ahwMap);}

    public void initEncoders(HardwareMap ahwMap) {
        hwMap = ahwMap;

        //encoder
        encoderback = hwMap.dcMotor.get("frontleft");
        encoderleft = hwMap.dcMotor.get("backleft");
        encoderright = hwMap.dcMotor.get("backright");

        encoderright.setDirection(DcMotorSimple.Direction.FORWARD);
        encoderleft.setDirection(DcMotorSimple.Direction.FORWARD);
        encoderback.setDirection(DcMotorSimple.Direction.REVERSE);
        encoderleft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        encoderright.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        encoderback.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        encoderback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoderright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        encoderleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void runEncoders(){
        encFrontValue = encoderback.getCurrentPosition() * ticksToInches;
        encLeftValue = encoderleft.getCurrentPosition() * ticksToInches;
        encRightValue = encoderright.getCurrentPosition() * ticksToInches;


    }
}
