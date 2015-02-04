package spectrum.frc3847.commands.toterake;

import spectrum.frc3847.commands.CommandBase;

/**
 *
 */
public class Drop extends CommandBase {

    public Drop() {
    	requires(toterake);
    }

    @Override
    protected void initialize() {
    	toterake.drop();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	toterake.recoup();
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
