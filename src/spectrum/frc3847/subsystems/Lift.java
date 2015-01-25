package spectrum.frc3847.subsystems;

import spectrum.frc3847.HW;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {

	public CANTalon lift;
	public CANTalon lifta;
	public DoubleSolenoid tilt;
	
	public Lift() {
		lift = new CANTalon(HW.LIFT);
		lifta = new CANTalon(HW.LIFTA);
		lifta.changeControlMode(ControlMode.Follower);
		lifta.set(lift.getDeviceID());
		lift.enableBrakeMode(true);
		lifta.enableBrakeMode(true);
		tilt = new DoubleSolenoid(HW.LIFT_TILT_DOUBLE, HW.LIFT_TILT_DOUBLE + 1);
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
	
	protected void initDefaultCommand() {
	}

}
