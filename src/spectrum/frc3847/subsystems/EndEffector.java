package spectrum.frc3847.subsystems;

import spectrum.frc3847.HW;
import spectrum.frc3847.driver.SpectrumDoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class EndEffector extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpectrumDoubleSolenoid fSolenoid;
	private Victor trOne;
	private Victor trTwo;
	
	public EndEffector(){
		fSolenoid = new SpectrumDoubleSolenoid(HW.ENDEFFECTOR_GRIP_DS,HW.ENDEFFECTOR_GRIP_DS+1);
		trOne = new Victor(HW.TR_VICTOR_ONE);
		trTwo = new Victor(HW.TR_VICTOR_TWO);
	}

	public void expand(){
		fSolenoid.set(Value.kForward);
	}
	
	public void close(){
		fSolenoid.set(Value.kReverse);
	}

	public void setHoldSpeed(double x){
		trOne.set(x);
		trTwo.set(-x);
	}
    protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

