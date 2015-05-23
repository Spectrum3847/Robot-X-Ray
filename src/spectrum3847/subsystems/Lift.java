package spectrum3847.subsystems;

import spectrum3847.HW;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {

	private CANTalon liftTalon;
	private CANTalon liftTalon2;
	private DoubleSolenoid fGuideSolenoid;
	
	public Lift() {
		fGuideSolenoid = new DoubleSolenoid(HW.STABALIZERS_DS,HW.STABALIZERS_DS+1);
		liftTalon = new CANTalon(HW.LIFT_TALON_ID);
		liftTalon2 = new CANTalon(HW.LIFT_TALON_ID_TWO);
		
		liftTalon.setFeedbackDevice(CANTalon.FeedbackDevice.AnalogPot);
		liftTalon2.changeControlMode(ControlMode.Follower);
		liftTalon2.reverseOutput(true);
		liftTalon2.set(liftTalon.getDeviceID());
	}
	
	public void setLift(double v) {
		liftTalon.set(v);
	}
	
	public double getPotValue() {
		return liftTalon.getPosition();
	}
	
	public CANTalon getTalon() {
		return liftTalon;
	}
	
	public CANTalon getTalon2() {
		return liftTalon2;
	}

	public void expand(){
		fGuideSolenoid.set(Value.kForward);
	}
	
	public void collapse(){
		fGuideSolenoid.set(Value.kReverse);
	}
	
	protected void initDefaultCommand() {
	}
}
