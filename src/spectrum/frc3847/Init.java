package spectrum.frc3847;

import spectrum.frc3847.commands.CommandBase;
import spectrum.frc3847.commands.driving.DriveSelect;
import spectrum.frc3847.commands.driving.HaloDrive;
import spectrum.frc3847.commands.driving.HaloStrafeDrive;
import spectrum.frc3847.commands.driving.SquareOff;
import spectrum.frc3847.commands.lifting.LiftControl;
import spectrum.frc3847.commands.lifting.TiltLift;
/**
 *
 * @author matthew
 */
public class Init {

    public static HaloDrive halodrive = new HaloDrive();
    public static HaloStrafeDrive halostrafedrive = new HaloStrafeDrive();
    public static DriveSelect driveselect = new DriveSelect(halodrive);
    public static SquareOff squareoff = new SquareOff();
    
    public static LiftControl liftcontrol = new LiftControl();
    public static TiltLift tiltlift = new TiltLift();

    public static void init() {
        CommandBase.init();
        System.out.println("init");
        Dashboard.intializeDashboard();
    }

    public static void periodic() {
    }
}
