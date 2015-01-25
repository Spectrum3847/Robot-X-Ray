package spectrum.frc3847.commands.driving;

import spectrum.frc3847.commands.CommandBase;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 * @author matthew
 */
public class DriveSelect extends CommandBase {

    private final Command DEFAULT;
    private Command defaultDriveMode;

    public DriveSelect(Command com) {
        requires(drivebase);
        DEFAULT = com;
        defaultDriveMode = DEFAULT;
    }

    public void setDefaultDriveMode(Command command) {
        defaultDriveMode = command;
    }

    public Command getDefaultDriveMode() {
        return defaultDriveMode;
    }

    protected void initialize() {
    }

    /**
     * if we are here we need to leave to a useful drive mode Do this by
     * starting defaultDriveMode if it's not null and it requires drivebase
     */
    protected void execute() {
        if (defaultDriveMode == null || !defaultDriveMode.doesRequire(drivebase)) {
            defaultDriveMode = DEFAULT;
        }
        defaultDriveMode.start();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
}
