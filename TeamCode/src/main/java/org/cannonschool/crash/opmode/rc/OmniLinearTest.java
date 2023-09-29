package org.cannonschool.crash.opmode.opmode.rc;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.cannonschool.crash.hardware.CrashHardware;

// Mostly pulled from org.firstinspires.ftc.robotcontroller.external.samples.BasicOmniOpMode_Linear

@TeleOp(name = "[test] Omniwheel Linear", group = "tele/linear")
public class OmniLinearTest extends LinearOpMode  {
    private ElapsedTime runtime = new ElapsedTime();

    // Motors
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;

    @Override
    public void runOpMode() {
        /*frontLeft = hardwareMap.get(DcMotor.class, CrashHardware.MOTOR_FRONT_LEFT.hardware_id);
        frontRight = hardwareMap.get(DcMotor.class, CrashHardware.MOTOR_FRONT_RIGHT.hardware_id);
        backLeft = hardwareMap.get(DcMotor.class, CrashHardware.MOTOR_BACK_LEFT.hardware_id);
        backRight = hardwareMap.get(DcMotor.class, CrashHardware.MOTOR_BACK_RIGHT.hardware_id);

        // Change these constants in RobotHardware if motors are going backwards.
        frontLeft.setDirection(CrashHardware.MOTOR_FRONT_LEFT.forward_direction);
        frontRight.setDirection(CrashHardware.MOTOR_FRONT_RIGHT.forward_direction);
        backLeft.setDirection(CrashHardware.MOTOR_BACK_LEFT.forward_direction);
        backRight.setDirection(CrashHardware.MOTOR_BACK_RIGHT.forward_direction);

         */

        // Wait for the game to start
        telemetry.addData("Status", "Ready");
        telemetry.update();

        waitForStart();
        runtime.reset(); // start our run time counter

        // run until game ends (driver presses STOP)
        while (opModeIsActive()) {
            double max;

            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral =  gamepad1.left_stick_x;
            double yaw     =  gamepad1.right_stick_x;

            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            double leftFrontPower  = axial + lateral + yaw;
            double rightFrontPower = axial - lateral - yaw;
            double leftBackPower   = axial - lateral + yaw;
            double rightBackPower  = axial + lateral - yaw;

            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));

            if (max > 1.0) {
                leftFrontPower  /= max;
                rightFrontPower /= max;
                leftBackPower   /= max;
                rightBackPower  /= max;
            }

            // This is test code:
            //
            // Uncomment the following code to test your motor directions.
            // Each button should make the corresponding motor run FORWARD.
            //   1) First get all the motors to take to correct positions on the robot
            //      by adjusting your Robot Configuration if necessary.
            //   2) Then make sure they run in the correct direction by modifying the
            //      the setDirection() calls above.
            // Once the correct motors move in the correct direction re-comment this code.

            /*
            leftFrontPower  = gamepad1.x ? 1.0 : 0.0;  // X gamepad
            leftBackPower   = gamepad1.a ? 1.0 : 0.0;  // A gamepad
            rightFrontPower = gamepad1.y ? 1.0 : 0.0;  // Y gamepad
            rightBackPower  = gamepad1.b ? 1.0 : 0.0;  // B gamepad
            */

            // Send calculated power to wheels
            //frontLeft.setPower(leftFrontPower);
            //frontRight.setPower(rightFrontPower);
            //backLeft.setPower(leftBackPower);
            //backRight.setPower(rightBackPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Running " + runtime.toString());
            telemetry.addData("Front", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
            telemetry.addData(" Back", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            telemetry.update();
        }
    }
}
