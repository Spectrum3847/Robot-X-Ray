package spectrum.frc3847;

/**
 * The HW is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class HW {
    /**DRIVEBASE MOTOR ASSIGNMENTS (PWM)**/
    public static final int FRONT_RDRIVE_MOTOR = 9;
    public static final int FRONT_LDRIVE_MOTOR = 0;
    public static final int REAR_RDRIVE_MOTOR = 8;
    public static final int REAR_LDRIVE_MOTOR = 1;
    
    public static final int H_WHEEL = 7;
    
    /**NON-DRIVEBASE MOTOR ASSIGNMENTS (PWM)**/
    public static final int LEFT_COLLECTOR = 3;
    public static final int RIGHT_COLLECTOR = 6;
    
    /**NON-DRIVEBASE MOTOR ASSIGNMENTS (CAN)**/
    public static final int LIFTA = 1;
    public static final int LIFT = 2;
    
    /**DIGITAL SENSOR ALLOCATIONS**/
    
    /**Pneumatics**/
    public static final int PCM_ONE = 0;
    public static final int PCM_TWO = 1;
    public static final int HWHEEL_DOUBLE = 0;
    public static final int LIFT_TILT_DOUBLE = 2;
    public static final int ENDEFFECTOR_GRIP_DS = 4;
    public static final int TOTERAKE_DS = 6;
    public static final int LIFT_LOCK_DOUBLE = 10; //Uses SpectrumDoubleSolenoid to define 1 as CAN ID
    
    /**ANALOG SENSOR ALLOCATIONS**/
    public static final int FRONT_LEFT_IR = 0;
    public static final int FRONT_RIGHT_IR = 1;
    
    /**RELAY ALLOCATIONS**/
    
    /**SOLENOID ALLOCATIONS**/
    
    /**PID CONSTANTS**/
    
    /**JOYSTICKS/GAMEPAD ASSIGNMENTS**/
    public static final int usbPort_zero = 0;
    public static final int usbPort_one = 1;
    public static final int usbPort_two = 2;
    public static final int usbPort_three = 3;

}
