package spectrum.frc3847.subsystems;

import spectrum.frc3847.HW;
import spectrum.frc3847.commands.CompressorDashboard;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	private Compressor fCompressor;

	public Pneumatics() {
		fCompressor = new Compressor(HW.PCM_ONE);
		startCompressor();
	}

	public void stopCompressor (){
		fCompressor.stop();
	}
	
	public void startCompressor (){
		fCompressor.start();
	}
	protected void initDefaultCommand() {
        setDefaultCommand(new CompressorDashboard());
	}
}