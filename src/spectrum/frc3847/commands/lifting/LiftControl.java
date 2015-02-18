package spectrum.frc3847.commands.lifting;

import spectrum.frc3847.Dashboard;
import spectrum.frc3847.OI;
import spectrum.frc3847.Utilities;
import spectrum.frc3847.commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftControl extends CommandBase {
	
	public LiftControl(){
		requires(lift);
	}

	protected void initialize() {
		lift.setLift(0);
	}

	protected void execute() {
		lift.getTalon().setVoltageRampRate((int)SmartDashboard.getNumber(Dashboard.LIFT_UP_RAMP_RATE, 8));
		
		lift.getTalon().setForwardSoftLimit((int)SmartDashboard.getNumber(Dashboard.LIFT_UP_LIMIT, 1023));
		lift.getTalon().enableForwardSoftLimit(true);
		lift.getTalon().setReverseSoftLimit((int)SmartDashboard.getNumber(Dashboard.LIFT_DOWN_LIMIT, 0));
		lift.getTalon().enableReverseSoftLimit(true);
		
		double pow = -Utilities.deadBand(OI.gamepad_aux.getY(), 0.18);
		if(pow < 0)
			pow *= SmartDashboard.getNumber(Dashboard.LIFT_DOWN_MULTIPLIER, 0.2);
		else
			pow *= SmartDashboard.getNumber(Dashboard.LIFT_UP_MULTIPLIER, 1.0);
		lift.setLift(pow);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		lift.setLift(0);
	}

	//Override
	protected void interrupted() {
		end();
	}
}