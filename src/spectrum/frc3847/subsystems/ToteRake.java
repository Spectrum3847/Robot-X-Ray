package spectrum.frc3847.subsystems;

import spectrum.frc3847.HW;
import spectrum.frc3847.driver.SpectrumDoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteRake extends Subsystem {
	private SpectrumDoubleSolenoid fDrop;

	public ToteRake(){
		fDrop = new SpectrumDoubleSolenoid(HW.TOTERAKE_DS,HW.TOTERAKE_DS+1);
	}

	public void drop(){
		fDrop.set(Value.kForward);
	}

	public void recoup(){
		fDrop.set(Value.kReverse);
	}

    public void initDefaultCommand() {
    }
}

