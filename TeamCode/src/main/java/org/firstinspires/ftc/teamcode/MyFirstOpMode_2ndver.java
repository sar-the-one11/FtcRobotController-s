package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class MyFirstOpMode_2ndver extends LinearOpMode {

    protected DcMotor frontLeft;
    protected DcMotor frontRight;
    protected DcMotor backLeft;
    protected DcMotor backRight;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.get(DcMotor.class, "Left Upper");
        frontRight = hardwareMap.get(DcMotor.class, "Right Upper");
        backLeft = hardwareMap.get(DcMotor.class, "Left Lower");
        backRight = hardwareMap.get(DcMotor.class, "Right Lower");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        waitForStart();
        frontLeft.setPower(0.2);
        frontRight.setPower(0.2);
        backLeft.setPower(0.2);
        backRight.setPower(0.2);
        sleep(2000);
        frontLeft.setPower(-0.1);
        frontRight.setPower(-0.1);
        backLeft.setPower(-0.1);
        backRight.setPower(-0.1);
        sleep (300);
        frontLeft.setPower(0);
        frontRight.setPower(0.2);
        backLeft.setPower(-0.1);
        backRight.setPower(0.2);
        sleep(3500);
        frontLeft.setPower(0.3);
        frontRight.setPower(0.3);
        backLeft.setPower(0.3);
        backRight.setPower(0.3);
        sleep(4000);
        frontLeft.setPower(-0.2);
        frontRight.setPower(-0.2);
        backLeft.setPower(-0.2);
        backRight.setPower(-0.2);
        sleep (4000);
        frontLeft.setPower(-0.1);
        frontRight.setPower(0.2);
        backLeft.setPower(0);
        backRight.setPower(0.2);
        sleep(6300);
        frontLeft.setPower(0.3);
        frontRight.setPower(0.3);
        backLeft.setPower(0.3);
        backRight.setPower(0.3);
        sleep(7500);



        ElapsedTime runtime = new ElapsedTime();

        // Calculate the COUNTS_PER_INCH for your specific drive train.
        // Go to your motor vendor website to determine your motor's COUNTS_PER_MOTOR_REV
        // For external drive gearing, set DRIVE_GEAR_REDUCTION as needed.
        // For example, use a value of 2.0 for a 12-tooth spur gear driving a 24-tooth spur gear.
        // This is gearing DOWN for less speed and more torque.
        // For gearing UP, use a gear ratio less than 1.0. Note this will affect the direction of wheel rotation.
        final double     COUNTS_PER_MOTOR_REV    = 537.6 ;    // eg: TETRIX Motor Encoder
        final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // No External Gearing.
        final double     WHEEL_DIAMETER_INCHES   = 4.1 ;     // For figuring circumference
        final double     COUNTS_PER_INCH         = 41.7;
        final double     DRIVE_SPEED             = 0.5;
        final double     TURN_SPEED              = 0.4;



            // Initialize the drive system variables.
            frontLeft = hardwareMap.get(DcMotor.class, "Left Upper");
            frontRight = hardwareMap.get(DcMotor.class, "Right Upper");
            backLeft = hardwareMap.get(DcMotor.class, "Left Lower" );
            backRight = hardwareMap.get(DcMotor.class, "Right Lower");
            // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
            // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
            // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
            frontRight.setDirection(DcMotor.Direction.REVERSE);
            backLeft.setDirection(DcMotor.Direction.REVERSE);
            frontLeft.setDirection(DcMotor.Direction.FORWARD);
            backRight.setDirection(DcMotor.Direction.FORWARD);

            backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            // Send telemetry message to indicate successful Encoder reset
            telemetry.addData("Starting at",  "%7d :%7d",
                    frontLeft.getCurrentPosition(),
                    frontRight.getCurrentPosition(),
                    backLeft.getCurrentPosition(),
                    backRight.getCurrentPosition());
            telemetry.update();

            // Wait for the game to start (driver presses START)
            waitForStart();

            // Step through each leg of the path,
            // Note: Reverse movement is obtained by setting a negative distance (not speed)
            encoderDrive(DRIVE_SPEED,  48,  48, 10.0);
            sleep(5000);
            encoderDrive(TURN_SPEED,   0, 0, 4.0);
            sleep(2000);
            encoderDrive(DRIVE_SPEED, 24, 24, 4.0);  // S3: Reverse 24 Inches with 4 Sec timeout

            telemetry.addData("Path", "Complete");
            telemetry.update();
            sleep(1000);  // pause to display final telemetry message.
        }

    private void encoderDrive(double driveSpeed, int i, int i1, double v) {
    }
}




