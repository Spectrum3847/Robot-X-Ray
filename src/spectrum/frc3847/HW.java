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
    
    public static final int H_WHEEL = 4;
    
    /**NON-DRIVEBASE MOTOR ASSIGNMENTS (PWM)**/
    public static final int LIFT = 5;
    
    /**DIGITAL SENSOR ALLOCATIONS**/
    
    /**Pneumatics**/
    
    /**ANALOG SENSOR ALLOCATIONS**/
    public static final int FRONT_LEFT_IR = 0;
    public static final int FRONT_RIGHT_IR = 1;
    
    /**RELAY ALLOCATIONS**/
    
    /**SOLENOID ALLOCATIONS**/
    
    /**PID CONSTANTS**/
    
    /**JOYSTICKS/GAMEPAD ASSIGNMENTS**/
    public static final int usbPort_one = 1;
    public static final int usbPort_two = 2;
    public static final int usbPort_three = 3;
    public static final int usbPort_four = 4;
}