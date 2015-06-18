package spectrum3847;

import spectrum3847.commands.CommandBase;
import spectrum3847.commands.CompressorDashboard;
import spectrum3847.commands.SendCameraImage;
import spectrum3847.commands.collector.CollectActuate;
import spectrum3847.commands.collector.CollectControl;
import spectrum3847.commands.collector.CollectTop;
import spectrum3847.commands.driving.HaloDrive;
import spectrum3847.commands.lifting.Expand;
import spectrum3847.commands.lifting.LiftControl;
/**
 *
 * @author matthew
 */
public class Init {

    public static HaloDrive halodrive = new HaloDrive();
    
    public static LiftControl liftcontrol = new LiftControl();
    public static CollectControl collectcontrol = new CollectControl();
    
    public static CollectTop collecttop = new CollectTop();
    public static CollectActuate collectactuate = new CollectActuate();
    
    public static Expand expand = new Expand();
    
    public static SendCameraImage sendCam = new SendCameraImage();
    public static CompressorDashboard compressordashboard = new CompressorDashboard();

    public static void init() {
    	try {
            CommandBase.init();
            System.out.println("init");
            Dashboard.intializeDashboard();
        } catch(Exception e) {e.printStackTrace();}
    }

    public static void periodic() {
    }
}
