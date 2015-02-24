package spectrum.frc3847.subsystems;

import spectrum.frc3847.HW;
import spectrum.frc3847.Init;
import spectrum.frc3847.driver.IMU;
import spectrum.frc3847.driver.SpectrumDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author David, Matthew
 */
public class DriveBase extends Subsystem{
    private Victor fVic1, fVic2, fVic3, fVic4;
    private Victor fVicH;
    private Victor[] fVicArray;
    private final SpectrumDrive fSpectrumDrive;
    private DoubleSolenoid fLift;
    private SerialPort fSerial;
    private IMU fIMU;

    public DriveBase() {
        super();
        setVictor();
        fVicH = new Victor(HW.H_WHEEL);
        fSpectrumDrive = new SpectrumDrive(fVic1, fVic2, fVic3, fVic4);
        fLift = new DoubleSolenoid(HW.HWHEEL_DOUBLE, HW.HWHEEL_DOUBLE+1);
        fSerial = new SerialPort(57600, Port.kMXP);
        fSerial.setReadBufferSize(1);
        fSerial.setWriteBufferSize(1);
        fSerial.setTimeout(1);
        try {fIMU = new IMU(fSerial, (byte)10);}catch(Exception e){e.printStackTrace();}
    }

    /**r
     * Set the Default Command Sets it to driveSelector so that we always have
     * the correct drive mode re-enabled after breaking or turning.
     */
    public void initDefaultCommand() {
        setDefaultCommand(Init.driveselect);   // set default command
    }

    public void setArcade(double straight_speed, double turn_speed) {
        fSpectrumDrive.arcadeDrive(straight_speed, turn_speed, false);
    }

    public void setTank(double left, double right) {
        fSpectrumDrive.tankDrive(left, right);
    }

    public void setCheesyDrive(double throttle, double wheel, boolean quickTurn) {
        fSpectrumDrive.Cheesydrive(throttle, -1 * wheel, quickTurn);
    }

    public void setCheesySensetivity(double sensetivity) {
        fSpectrumDrive.setSensitivity(sensetivity);
    }

    private void setVictor() {
        fVicArray = new Victor[6];
        fVic1 = new Victor(HW.FRONT_RDRIVE_MOTOR);
        fVicArray[0] = fVic1;
        fVic2 = new Victor(HW.REAR_RDRIVE_MOTOR);
        fVicArray[1] = fVic2;
        fVic3 = new Victor(HW.FRONT_LDRIVE_MOTOR);
        fVicArray[2] = fVic3;
        fVic4 = new Victor(HW.REAR_LDRIVE_MOTOR);
        fVicArray[3] = fVic4;
    }

    public Victor getVictor(int id) {
        return fVicArray[id];
    }

    public Victor[] getVictorArr() {
        return fVicArray;
    }

    public SpectrumDrive getDrive() {
        return fSpectrumDrive;
    }

    public void setHWheel(double v) {
    	fVicH.set(v);
    }

    public void setHLift(boolean drop) {
    	if(drop)
        	fLift.set(Value.kForward);
    	else
        	fLift.set(Value.kReverse);
    }
    
    public void dropHWheel() {
    	fLift.set(Value.kForward);
    }
    
    public void liftHWheel() {
    	fLift.set(Value.kReverse);
    }
    
    public IMU getIMU() {
    	return fIMU;
    }
}
