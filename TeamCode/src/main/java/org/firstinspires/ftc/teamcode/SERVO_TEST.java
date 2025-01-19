package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name="CRServoControlOpMode", group="Iterative OpMode")
public class SERVO_TEST extends OpMode {
    private CRServo crServo;
    private final double SERVO_SPEED = 1.0; // Full speed, adjust

    @Override
    public void init() {
        crServo = hardwareMap.get(CRServo.class, "servo");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            // Forward motion
            crServo.setPower(SERVO_SPEED);
        } else if (gamepad1.b) {
            // Backward motion
            crServo.setPower(-SERVO_SPEED);
        } else {
            // Stop the servo when no button is pressed
            crServo.setPower(0);
        }

        telemetry.addData("CR Servo Power", crServo.getPower());
        telemetry.addData("A Button", gamepad1.a ? "Pressed" : "Not Pressed");
        telemetry.addData("B Button", gamepad1.b ? "Pressed" : "Not Pressed");
        telemetry.update();
    }
}