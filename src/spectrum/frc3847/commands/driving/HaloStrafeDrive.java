package spectrum.frc3847.commands.driving;

import java.math.BigDecimal;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import spectrum.frc3847.Dashboard;
import spectrum.frc3847.OI;
import spectrum.frc3847.Utilities;
import spectrum.frc3847.commands.CommandBase;
import spectrum.frc3847.driver.Gamepad;
import spectrum.frc3847.math.Expression;

public class HaloStrafeDrive extends CommandBase {

	protected void initialize() {
		System.out.println("HaloStrafe, GO!");
	}

	protected void execute() {
        Expression exp = new Expression(SmartDashboard.getString(Dashboard.DRIVE_RAMP_FUNCTION));
        double throttle = -Utilities.haloDeadBand(OI.gamepad.getLeftY(), OI.gamepad.getRightX(), .15, .17);
        double wheel = -Utilities.haloDeadBand(OI.gamepad.getRightX(), OI.gamepad.getLeftY(), .15, .17);
        double quickTurnTriggers = OI.gamepad.getOldTriggers();
        
        double result = exp.with("x", BigDecimal.valueOf(throttle)).eval().doubleValue();
        double result_turn = exp.with("x", BigDecimal.valueOf(wheel)).eval().doubleValue();
        double result_trigger = exp.with("x", BigDecimal.valueOf(quickTurnTriggers)).eval().doubleValue();
        
        drivebase.setArcade(result, result_turn);;
        drivebase.setHWheel(result_trigger);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
        drivebase.setArcade(0, 0);
	}

	protected void interrupted() {
		end();
	}

}
