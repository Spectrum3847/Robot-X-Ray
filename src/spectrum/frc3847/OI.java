package spectrum.frc3847;

import spectrum.frc3847.driver.Gamepad;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static final Gamepad gamepad = new Gamepad(HW.usbPort_one);
    public static final Gamepad gamepad_aux = new Gamepad(HW.usbPort_two);
    public static final Joystick drivestick = new Joystick(HW.usbPort_three);
    public static final Joystick auxstick = new Joystick(HW.usbPort_four);

    public static final Button drive_toggle = new JoystickButton(gamepad.getGamepad(), Gamepad.A_BUTTON);
    
    public static final Button joy_square = new JoystickButton(drivestick, 4);
    
    public static final Button joy_tilt = new JoystickButton(auxstick, 1);
    
    //Use this constructor to setup up button schedulers for commands
    public OI() {
    	drive_toggle.toggleWhenPressed(Init.triangledrive);
    	
        joy_square.toggleWhenPressed(Init.squareoff);
        
        joy_tilt.toggleWhenActive(Init.tiltlift);
    }
}
