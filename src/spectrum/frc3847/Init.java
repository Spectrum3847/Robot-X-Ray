package spectrum.frc3847;

import spectrum.frc3847.commands.CommandBase;
import spectrum.frc3847.commands.SendCameraImage;
import spectrum.frc3847.commands.driving.DriveSelect;
import spectrum.frc3847.commands.driving.HaloDrive;
import spectrum.frc3847.commands.driving.HaloStrafeDrive;
import spectrum.frc3847.commands.endeffector.Collect;
import spectrum.frc3847.commands.endeffector.Eject;
import spectrum.frc3847.commands.endeffector.Expand;
import spectrum.frc3847.commands.lifting.LiftControl;
import spectrum.frc3847.commands.lifting.TiltLift;
import spectrum.frc3847.commands.toterake.Drop;
/**
 *
 * @author matthew
 */
public class Init {

    public static HaloDrive halodrive = new HaloDrive();
    public static HaloStrafeDrive halostrafedrive = new HaloStrafeDrive();
    public static DriveSelect driveselect = new DriveSelect(halodrive);
    
    public static LiftControl liftcontrol = new LiftControl();
    public static TiltLift tiltlift = new TiltLift();
    public static Expand expand = new Expand();
    public static Drop drop = new Drop();
    public static Collect eeCollect = new Collect();
    public static Eject eeEject = new Eject();
    public static SendCameraImage sendCam = new SendCameraImage();

    public static void init() {
        CommandBase.init();
        System.out.println("init");
        Dashboard.intializeDashboard();
    }

    public static void periodic() {
    }
}
