package spectrum.frc3847.commands;

import spectrum.frc3847.Dashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CompressorDashboard extends CommandBase {

	public CompressorDashboard() {
		requires(pneumatics);
	}

	protected void initialize() {
	}

	protected void execute() {
		if (SmartDashboard.getBoolean(Dashboard.COMPRESSOR, true)) {
			pneumatics.startCompressor();
		} else {
			pneumatics.stopCompressor();
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		pneumatics.startCompressor();
	}

	protected void interrupted() {
		end();
	}
}
