package spectrum3847.subsystems;

import spectrum3847.HW;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CanGrabber extends Subsystem {
	
	private Solenoid cangraba;
	private Solenoid cangrabb;
	private DoubleSolenoid grabshorten;
	
	public CanGrabber() {
		
		cangraba = new Solenoid(HW.CANGRAB_SS);
		cangrabb = new Solenoid(HW.CANGRAB_SS+1);
		grabshorten = new DoubleSolenoid(HW.GRAB_SHORTEN_SS, HW.GRAB_SHORTEN_SS+1);
	}
	
	public void castGrabber() {
		cangraba.set(true);
		cangrabb.set(true);
	}
	
	public void reelGrabber() {
		cangraba.set(false);
		cangrabb.set(false);
	}
	
	public void shorten() {
		grabshorten.set(Value.kReverse);
	}
	
	public void lengthen() {
		grabshorten.set(Value.kForward);
	}
	
	protected void initDefaultCommand() {
	}

}
