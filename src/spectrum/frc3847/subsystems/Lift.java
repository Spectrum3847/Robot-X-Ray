package spectrum.frc3847.subsystems;

import spectrum.frc3847.HW;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {
	
	public Talon lift;
	public DoubleSolenoid tilt;
	
	public Lift() {
		lift = new Talon(HW.LIFT);
		tilt = new DoubleSolenoid(0, 1);
	}
	
	public void tiltOn() {
		tilt.set(Value.kForward);
	}
	
	public void tiltOff() {
		tilt.set(Value.kReverse);
	}
	
	public void setLift(double v) {
		lift.set(v);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
