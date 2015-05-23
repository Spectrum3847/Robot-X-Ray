package spectrum3847.subsystems;

import spectrum3847.HW;
import spectrum3847.Init;
import spectrum3847.driver.SpectrumDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author David, Matthew
 */
public class DriveBase extends Subsystem{
    private Victor fVic1, fVic2;
    private Victor[] fVicArray;
    private final SpectrumDrive fSpectrumDrive;

    public DriveBase() {
        super();
        setVictor();
        fSpectrumDrive = new SpectrumDrive(fVic1, fVic2);
    }

    /**r
     * Set the Default Command Sets it to driveSelector so that we always have
     * the correct drive mode re-enabled after breaking or turning.
     */
    public void initDefaultCommand() {
        setDefaultCommand(Init.halodrive);   // set default command
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
        fVic2 = new Victor(HW.FRONT_LDRIVE_MOTOR);
        fVicArray[1] = fVic2;
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
}
