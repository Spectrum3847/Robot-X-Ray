package spectrum3847.commands.autonomous;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonLoader extends CommandGroup {
	public AutonLoader(String loadfile) throws FileNotFoundException {
		File file = new File(loadfile);
		Scanner scanner = new Scanner(file);

		ArrayList<Object> cmdlist = new ArrayList<Object>();
		
		while(scanner.hasNext()) {
			String[] sa = scanner.nextLine().split(" \"");
			System.out.println(Arrays.toString(sa));
			cmdlist.add(sa[0].split(" ")[0]);
			cmdlist.add(sa[0].split(" ")[1]);
			String[] a = new String[sa.length - 1];
			for (int j = 0; j < sa.length - 1; j++) {
				a[j] = sa[j + 1].replace("\"", "");
			}
			cmdlist.add(a);
		}
		scanner.close();
		System.out.println(cmdlist);

		for (int i = 0; i < cmdlist.size(); i += 3) {
			try {
				Command c = CommandLoader(((String) cmdlist.get(i + 1)),
						(Object[]) cmdlist.get(i + 2));
				if(((String) cmdlist.get(i)).equals("S")) {

					try {
						float time = Float.parseFloat(((String) cmdlist.get(i)).split("[|]")[1]);
						System.out.println();
						addSequential(c, time);
					} catch (Exception e) {
						System.out.println(((String) cmdlist.get(i)));
						addSequential(c);
					}
				}
				else {
					addParallel(c);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	private Command CommandLoader(String cmd, Object[] args)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			SecurityException, ClassNotFoundException {

		ClassLoader loader = AutonLoader.class.getClassLoader();
		Class<?> Cmd = loader.loadClass(cmd);
		return (Command) Cmd.getDeclaredConstructors()[0].newInstance(args);
	}

}
