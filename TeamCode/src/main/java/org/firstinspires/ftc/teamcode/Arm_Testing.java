package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@TeleOp(name="Basic: Omni Linear OpMode", group="Linear OpMode")
//@Disabled

public class Arm_Testing extends LinearOpMode {
    //This is the code for the 2 lifting/leaning motors

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor LeaningArm_Left = null;
    private DcMotor LiftingArm_Right = null;
   // private Servo   LeftClaw = null;


    //Divide encoder resolution by 360 to get ticks per degree and then multiply by required degrees
    final double LEANFORWARDMAX = 356.275;
    final int LEANBACKWARDMAX = 0;
    // final int SERVOOPENMAX = ;

    @Override
    public void runOpMode() {
        LeaningArm_Left = hardwareMap.get(DcMotor.class, "sliderClaw");
        LiftingArm_Right = hardwareMap.get(DcMotor.class,"sliderHook");
       // LeftClaw = hardwareMap.get(Servo.class, "Left Claw");


        LeaningArm_Left.setDirection(DcMotor.Direction.FORWARD);
        LiftingArm_Right.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            boolean leanForward = gamepad1.dpad_up;
            boolean leanBackward = gamepad1.dpad_down;
            // boolean openClaw = gamepad1.dpad_left;
            // boolean closeClaw = gamepad1.dpad_right;

            // boolean raiseUpwards = gamepad1.a;
            // Is this code even relevant because of the run to position code?

            if (leanForward) {
                LeaningArm_Left.setPower(0.5); // Move arm forward
            } else if (leanBackward) {
                LeaningArm_Left.setPower(-0.5); // Move arm backward
            } else {
                LeaningArm_Left.setPower(0); // Stop motor

            }
            if (gamepad1.a) {
                LeaningArm_Left.setTargetPosition((int) LEANFORWARDMAX);
                LiftingArm_Right.setTargetPosition((int) LEANFORWARDMAX);

            }
               LeaningArm_Left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               LiftingArm_Right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               LeaningArm_Left.setPower(0.5);
               LiftingArm_Right.setPower(0.5);
               // Would we need to include the code above in the if statement?
            // Would we need the right trigger code to put the rms at a specific angle be needed?
            // This code already sets the arm at an angle
           if (gamepad1.b) {
               LeaningArm_Left.setTargetPosition(LEANBACKWARDMAX);
               LiftingArm_Right.setTargetPosition(LEANBACKWARDMAX);
           }
               LeaningArm_Left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               LiftingArm_Right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               LeaningArm_Left.setPower(-0.3);
               LiftingArm_Right.setPower(-0.3);




            }
        }}





