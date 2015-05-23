package spectrum3847.commands.lifting;

import spectrum3847.OI;
import spectrum3847.Utilities;
import spectrum3847.commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftControl extends CommandBase {
	
	public LiftControl(){
		requires(lift);
	}

	protected void initialize() {
		lift.setLift(0);
	}

	protected void execute() {
		double pow = -Utilities.deadBand(OI.gamepad_aux.getY(), 0.14);
		lift.setLift(pow);
		SmartDashboard.putNumber("Lift Motor 1 Current", lift.getTalon().getOutputCurrent());
		SmartDashboard.putNumber("Lift Motor 2 Current", lift.getTalon2().getOutputCurrent());
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