package spectrum.frc3847;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author matthew
 */
public class Disabled {

    static int t = 0;
    static boolean b = true;

    public static void init() {
        Scheduler.getInstance().removeAll();
        //Init.sendCam.start();
    }

    public static void periodic() {
        //Flash a light on the dashboard while disabled, know that the dashboard is refreshing.
        if (t > 20) {
            t = 0;
            b = !b;
            SmartDashboard.putBoolean("Disabled Toggle", b);
        }
        t++;
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();



    }

    public static void continuous() {
    }
}
