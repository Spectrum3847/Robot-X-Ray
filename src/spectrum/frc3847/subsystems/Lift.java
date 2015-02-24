package spectrum.frc3847.subsystems;

import spectrum.frc3847.HW;
import spectrum.frc3847.driver.SpectrumDoubleSolenoid;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {

	private CANTalon liftTalon;
	private CANTalon liftTalon2;
	private DoubleSolenoid fTilt;
	private SpectrumDoubleSolenoid fLock;
	public DigitalInput fUpLim;
	private DigitalInput fLowLim;
	
	public Lift() {
		fTilt = new DoubleSolenoid(HW.LIFT_TILT_DOUBLE, HW.LIFT_TILT_DOUBLE + 1);
		fLock = new SpectrumDoubleSolenoid(HW.LIFT_LOCK_DOUBLE, HW.LIFT_LOCK_DOUBLE + 1);
		liftTalon = new CANTalon(HW.LIFT_TALON_ID);
		liftTalon2 = new CANTalon(HW.LIFT_TALON_ID_TWO);
		fUpLim = new DigitalInput(1);
		fLowLim = new DigitalInput(2);
		
		liftTalon.setFeedbackDevice(CANTalon.FeedbackDevice.AnalogPot);
		liftTalon2.changeControlMode(ControlMode.Follower);
		liftTalon2.set(liftTalon.getDeviceID());
		liftTalon.enableBrakeMode(true);
		liftTalon2.enableBrakeMode(true);
	}
	
	public void tiltOn() {
		fTilt.set(Value.kForward);
	}
	
	public void tiltOff() {
		fTilt.set(Value.kReverse);
	}
	
	public void setLift(double v) {
		liftTalon.set(v);
	}
	
	public void lockOn(){
		fLock.set(Value.kForward);
	}
	
	public void lockOff(){
		fLock.set(Value.kReverse);
	}
	
	public double getPotValue() {
		return liftTalon.getAnalogInRaw();
	}
	
	public CANTalon getTalon() {
		return liftTalon;
	}
	
	public boolean atUpLim() {
		return !fUpLim.get();
	}
	
	public boolean atLowLim() {
		return !fLowLim.get();
	}
	
	protected void initDefaultCommand() {
	}
}
