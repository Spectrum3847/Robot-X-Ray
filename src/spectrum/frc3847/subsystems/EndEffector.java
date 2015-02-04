package spectrum.frc3847.subsystems;

import spectrum.frc3847.HW;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class EndEffector extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private DoubleSolenoid fSolenoid;
	
	public EndEffector(){
		fSolenoid = new DoubleSolenoid(HW.ENDEFFECTOR_GRIP_DS,HW.ENDEFFECTOR_GRIP_DS+1);
	}

	public void expand(){
		fSolenoid.set(Value.kForward);
	}
	
	public void close(){
		fSolenoid.set(Value.kReverse);
	}

    protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

