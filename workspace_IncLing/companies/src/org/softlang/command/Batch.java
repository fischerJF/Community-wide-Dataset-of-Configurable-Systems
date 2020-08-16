package org.softlang.command;






import static java.util.Collections.reverse;

import java.util.LinkedList;
import java.util.List;

/**
 * Aggregate many commands.
 */
public class Batch extends Command {
		
	private List<Command> commands = new LinkedList<Command>();
	
	public void add(Command c) {
		commands.add(c);
	}
	
	public void execute() {
		super.execute();		
		for (Command c : commands)
			c.execute();
	}
	
	public void undo() { 
		super.undo();
		reverse(commands);
		for (Command c : commands)
			c.undo();		
		reverse(commands);
	}
}
