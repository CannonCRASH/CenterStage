package org.cannonschool.crash.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class HardwareMotor {
    public String hardware_id;
    public DcMotor.Direction forward_direction;

    public HardwareMotor(String hwid, DcMotorSimple.Direction fwdir) {
        hardware_id = hwid;
        forward_direction = fwdir;
    }
}
