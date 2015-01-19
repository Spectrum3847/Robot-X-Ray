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

	@Override
	protected void initialize() {
		lift.setLift(0);
	}

	@Override
	protected void execute() {
		double pow = Utilities.deadBand(OI.auxstick.getY(), 0.18);
		if(pow < 0) pow *= SmartDashboard.getNumber(Dashboard.LIFT_DOWN_MULTIPLIER, 0.1);
		lift.setLift(pow);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		lift.setLift(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
