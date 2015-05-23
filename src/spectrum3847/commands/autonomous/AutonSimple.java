package spectrum3847.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutonSimple extends CommandGroup{
	    public AutonSimple() {
	        addSequential(new WaitCommand(0.22));
	        addParallel(new AutonDrive(), 0.5);
	        addParallel(new GrabShorten());
	        addSequential(new WaitCommand(0.25));
	        addSequential(new CanGrabLift());
	        addSequential(new AutonDrive(), 0.5);
	        addSequential(new AutonDrive(), 1);
	    }
}
