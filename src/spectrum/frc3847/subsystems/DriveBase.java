package spectrum.frc3847.subsystems;

import spectrum.frc3847.HW;
import spectrum.frc3847.Init;
import spectrum.frc3847.driver.ShortRangeSharp;
import spectrum.frc3847.driver.SpectrumDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author David, Matthew
 */
public class DriveBase extends Subsystem{
	
    private Victor Victor_1, Victor_2, Victor_3, Victor_4;
    private Victor h_wheel;
    private Victor[] Victor_arr;
    private final SpectrumDrive spectrumDrive;
    private final ShortRangeSharp leftir, rightir;

    public DriveBase() {
        super();
        setVictor();
        h_wheel = new Victor(HW.H_WHEEL);
        spectrumDrive = new SpectrumDrive(Victor_1, Victor_2, Victor_3, Victor_4);
        leftir = new ShortRangeSharp(HW.FRONT_LEFT_IR);
        rightir = new ShortRangeSharp(HW.FRONT_RIGHT_IR);
    }

    /**
     * Set the Default Command Sets it to driveSelector so that we always have
     * the correct drive mode re-enabled after breaking or turning.
     */
    public void initDefaultCommand() {
        setDefaultCommand(Init.driveselect);   // set default command
    }

    public void setArcade(double straight_speed, double turn_speed) {
        spectrumDrive.arcadeDrive(straight_speed, turn_speed, true);
    }

    public void setTank(double left, double right) {
        spectrumDrive.tankDrive(left, right);
    }

    public void setCheesyDrive(double throttle, double wheel, boolean quickTurn) {
        spectrumDrive.Cheesydrive(throttle, -1 * wheel, quickTurn);
    }

    public void setCheesySensetivity(double sensetivity) {
        spectrumDrive.setSensitivity(sensetivity);
    }

    private void setVictor() {
        Victor_arr = new Victor[6];
        Victor_1 = new Victor(HW.FRONT_RDRIVE_MOTOR);
        Victor_arr[0] = Victor_1;
        Victor_2 = new Victor(HW.REAR_RDRIVE_MOTOR);
        Victor_arr[1] = Victor_2;
        Victor_3 = new Victor(HW.FRONT_LDRIVE_MOTOR);
        Victor_arr[2] = Victor_3;
        Victor_4 = new Victor(HW.REAR_LDRIVE_MOTOR);
        Victor_arr[3] = Victor_4;
    }

    public Victor getVictor(int id) {
        return Victor_arr[id];
    }

    public Victor[] getVictorArr() {
        return Victor_arr;
    }

    public SpectrumDrive getDrive() {
        return spectrumDrive;
    }
    
    public void setHWheel(double v) {
    	h_wheel.set(v);
    }

    public double getLeftSharpDistance() {
    	return leftir.getDistance();
    }

    public double getRightSharpDistance() {
    	return rightir.getDistance();
    }

    public double getLeftSharpVoltage() {
    	return leftir.getVoltage();
    }

    public double getRightSharpVoltage() {
    	return rightir.getVoltage();
    }
}
