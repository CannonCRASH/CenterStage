package org.cannonschool.crash.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class CrashHardware {

    public static final HardwareMotor MOTOR_FRONT_LEFT = new HardwareMotor("front_left_motor", DcMotor.Direction.REVERSE);
    public static final HardwareMotor MOTOR_FRONT_RIGHT = new HardwareMotor("front_right_motor", DcMotor.Direction.REVERSE);
    public static final HardwareMotor MOTOR_BACK_LEFT = new HardwareMotor("back_left_motor", DcMotor.Direction.FORWARD);
    public static final HardwareMotor MOTOR_BACK_RIGHT = new HardwareMotor("back_right_motor", DcMotor.Direction.FORWARD);
}
