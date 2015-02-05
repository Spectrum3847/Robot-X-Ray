package spectrum.frc3847.subsystems;

import spectrum.frc3847.Dashboard;
import spectrum.frc3847.HW;
import spectrum.frc3847.driver.SpectrumDoubleSolenoid;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lift extends Subsystem {

	public CANTalon liftTalon;
	public CANTalon liftTalon2;
	public SpectrumDoubleSolenoid tilt;
	public SpectrumDoubleSolenoid lock;
	
	public Lift() {
		liftTalon = new CANTalon(HW.LIFT_TALON_ID);
		liftTalon2 = new CANTalon(HW.LIFT_TALON_ID_TWO);
		liftTalon2.changeControlMode(ControlMode.Follower);
		liftTalon2.set(liftTalon.getDeviceID());
		liftTalon.enableBrakeMode(true);
		liftTalon2.enableBrakeMode(true);
		liftTalon.setFeedbackDevice(CANTalon.FeedbackDevice.AnalogPot);
		tilt = new SpectrumDoubleSolenoid(HW.LIFT_TILT_DOUBLE, HW.LIFT_TILT_DOUBLE + 1);
		lock = new SpectrumDoubleSolenoid(HW.LIFT_LOCK_DOUBLE, HW.LIFT_LOCK_DOUBLE + 1);
	}
	
	public void tiltOn() {
		tilt.set(Value.kForward);
	}
	
	public void tiltOff() {
		tilt.set(Value.kReverse);
	}
	
	public void setLift(double v) {
		liftTalon.set(v);
	}
	
	public void lockOn(){
		lock.set(Value.kForward);
	}
	
	public void lockOff(){
		lock.set(Value.kReverse);
	}
	
	protected void initDefaultCommand() {
	}

}
