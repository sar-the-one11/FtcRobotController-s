package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Auto_Drive_21944 {
    public class RobotHardware {
        public DcMotor frontLeft, frontRight, backLeft, backRight;
        public DcMotor sliderClaw, sliderHook;
        public Servo clawServo;

        public void init(HardwareMap hardwareMap) {
            // Map wheels (fill in name)
            frontLeft = hardwareMap.get(DcMotor.class, "Left Upper");
            frontRight = hardwareMap.get(DcMotor.class, "Right Upper");
            backLeft = hardwareMap.get(DcMotor.class, "Left Lower");
            backRight = hardwareMap.get(DcMotor.class, "Right Lower");

            // Map sliders
            sliderClaw = hardwareMap.get(DcMotor.class, "sliderClaw");
            sliderHook = hardwareMap.get(DcMotor.class, "sliderHook");

            // Map servo (rack and pinion)
            clawServo = hardwareMap.get(Servo.class, "Left Claw");

            // Reverse motors (if we need to)
            frontLeft.setDirection(DcMotor.Direction.REVERSE);
            backLeft.setDirection(DcMotor.Direction.REVERSE);

            // Make motors break when power = 0
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }
    @Autonomous(name = "IntoTheDeepAuto", group = "FTC")
    public class IntoTheDeepAuto extends LinearOpMode {
        RobotHardware robot = new RobotHardware();

        @Override
        public void runOpMode() {
            robot.init(hardwareMap);

            // Wait for start button
            waitForStart();

            // MOVE TO ASSEMBLY
            moveToAssemblyZone();

            // DROP SAMPLE IN ASSEMBLY
            placeSample();

            // LEAVE ASSEMBLY
            exitAssemblyZone();

            // PAUSE FOR HOOK
            sleep(5000); // filler time (we need to test how long elaine takes)

            // GET BACK SPECIMEN
            retrieveSpecimen();

            // HANG IN HIGH CHAMBER
            hangSpecimen();

            // PARK IN OBS ZONE
            parkInObservationZone();
        }

        // create the action functions

        private void moveToAssemblyZone() {
            drive(0.5, 0.5, 0.5, 0.5, 5000); // Move forward (filler times and speeds)
        }

        private void placeSample() {
            robot.sliderClaw.setPower(0.5);  // Extend claw arm
            sleep(1000);                     // Adjust based on slider travel distance
            robot.clawServo.setPosition(0.0); // Open claw to release the sample
            sleep(500);
            robot.sliderClaw.setPower(-0.5); // Retract claw arm
            sleep(1000);
            robot.sliderClaw.setPower(0);    // Stop slider motor
        }

        private void exitAssemblyZone() {
            drive(-0.5, -0.5, -0.5, -0.5, 1000); // drive back to get outta assembly
        }

        private void retrieveSpecimen() {
            drive(0.5, 0.5, 0.5, 0.5, 1000); // Drive back into assembly zone
            robot.sliderClaw.setPower(0.5);   // Extend claw arm
            sleep(1000);
            robot.clawServo.setPosition(1.0); // Close claw to grab specimen
            sleep(500);
            robot.sliderClaw.setPower(-0.5);  // Retract claw arm
            sleep(1000);
            robot.sliderClaw.setPower(0);     // Stop slider motor
        }

        private void hangSpecimen() {
            drive(0.5, 0.5, 0.5, 0.5, 2000);  // Drive to high chamber zone
            robot.sliderHook.setPower(1.0);   // Extend hook slider
            sleep(1500);                      // Adjust based on slider travel distance
            robot.sliderHook.setPower(-1.0);  // Retract hook slider
            sleep(1500);
            robot.sliderHook.setPower(0);     // Stop slider motor
        }

        private void parkInObservationZone() {
            drive(-0.5, -0.5, -0.5, -0.5, 2000); // Drive to observation zone
        }

        // set power to all 4 motors
        private void drive(double fl, double fr, double bl, double br, int duration) {
            robot.frontLeft.setPower(fl);
            robot.frontRight.setPower(fr);
            robot.backLeft.setPower(bl);
            robot.backRight.setPower(br);
            sleep(duration);
            stopMotors();
        }

        // Stop all 4 motors
        private void stopMotors() {
            robot.frontLeft.setPower(0);
            robot.frontRight.setPower(0);
            robot.backLeft.setPower(0);
            robot.backRight.setPower(0);
        }
    }
}
