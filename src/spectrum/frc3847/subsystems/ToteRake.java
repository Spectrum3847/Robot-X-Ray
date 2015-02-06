package spectrum.frc3847.subsystems;

import spectrum.frc3847.HW;
import spectrum.frc3847.driver.SpectrumDoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteRake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpectrumDoubleSolenoid drop;
	
	public ToteRake(){
		drop = new SpectrumDoubleSolenoid(HW.TOTERAKE_DS,HW.TOTERAKE_DS+1);
	}
	
	public void drop(){
		drop.set(Value.kForward);
	}
	
	public void recoup(){
		drop.set(Value.kReverse);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

