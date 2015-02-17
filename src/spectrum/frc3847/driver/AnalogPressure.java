package spectrum.frc3847.driver;

import edu.wpi.first.wpilibj.AnalogInput;

public class AnalogPressure {
	private AnalogInput fPressure;
	
	public AnalogPressure(int port) {
		fPressure = new AnalogInput(port);
	}
	
	public double getRawVoltage() {
		return fPressure.getVoltage();
	}
	
	public double getPressure() {
		return (120/3.1)*(fPressure.getVoltage()-0.5);
	}
}
