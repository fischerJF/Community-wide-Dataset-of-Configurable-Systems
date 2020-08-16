package MinePumpSystem;

import MinePumpSystem.Environment;
import MinePumpSystem.MinePump;
import specifications.Configuration;

public class Actions {

	Environment env;
	MinePump p;
	
	public Actions() {
		env = new Environment();
		p = new MinePump(env);
	}
	
	void waterRise() {
		env.waterRise();
	}
	void methaneChange() {
		env.changeMethaneLevel();
	}
	void stopSystem() {
		if(Configuration.stopCommand) {
			
		}
		
		PL_Interface_impl.executedUnimplementedAction = true;
	}
	void startSystem() {
		PL_Interface_impl.executedUnimplementedAction = true;
	}
	
	void timeShift() {
		p.timeShift();
	}
	
	String getSystemState() {
		return p.toString();
	}

}
