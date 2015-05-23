package spectrum3847;

import spectrum3847.driver.Gamepad;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static final Gamepad gamepad = new Gamepad(HW.usbPort_zero);
    public static final Gamepad gamepad_aux = new Gamepad(HW.usbPort_one);
   
    public static final Button expand_toggle = new JoystickButton(gamepad_aux.getGamepad(), Gamepad.A_BUTTON);

    //Use this constructor to setup up button schedulers for commands
    public OI() {
        expand_toggle.toggleWhenPressed(Init.expand);
    }
}
