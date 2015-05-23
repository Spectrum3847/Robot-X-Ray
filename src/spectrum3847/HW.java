package spectrum3847;

/**
 * The HW is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class HW {
    /**DRIVEBASE MOTOR ASSIGNMENTS (PWM)**/
    public static final int FRONT_RDRIVE_MOTOR = 0;
    public static final int FRONT_LDRIVE_MOTOR = 8;
    
    /**NON-DRIVEBASE MOTOR ASSIGNMENTS (PWM)**/
    public static final int RIGHT_COLLECTOR = 1;
    public static final int LEFT_COLLECTOR = 7;
    
    /**NON-DRIVEBASE MOTOR ASSIGNMENTS (CAN)**/
    public static final int LIFT_TALON_ID = 1;
    public static final int LIFT_TALON_ID_TWO = 2;
    
    /**DIGITAL SENSOR ALLOCATIONS**/

    /**Pneumatics**/
    public static final int PCM_ONE = 0;

    public static final int STABALIZERS_DS = 2;
    public static final int CANGRAB_SS = 4;
    public static final int GRAB_SHORTEN_SS = 6;
    
    /**ANALOG SENSOR ALLOCATIONS**/
    
    /**RELAY ALLOCATIONS**/
    
    /**SOLENOID ALLOCATIONS**/
    
    /**PID CONSTANTS**/
    
    /**JOYSTICKS/GAMEPAD ASSIGNMENTS**/
    public static final int usbPort_zero = 0;
    public static final int usbPort_one = 1;
    public static final int usbPort_two = 2;
    public static final int usbPort_three = 3;

}
