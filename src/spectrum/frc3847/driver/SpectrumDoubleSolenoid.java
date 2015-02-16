package spectrum.frc3847.driver;

import edu.wpi.first.wpilibj.DoubleSolenoid;

//Spectrum Class that allows for solenoids to be defined as a double digit number with the
//first number representing the module that they are on.
public class SpectrumDoubleSolenoid extends DoubleSolenoid {

	public SpectrumDoubleSolenoid(int forwardChannel, int reverseChannel) {
		super(forwardChannel/10, forwardChannel % 10, reverseChannel % 10);
	}

	public SpectrumDoubleSolenoid(int moduleNumber, int forwardChannel,
			int reverseChannel) {
		super(moduleNumber, forwardChannel, reverseChannel);
		// TODO Auto-generated constructor stub
	}

}
