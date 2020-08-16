package defects;

import queval.*;
import specifications.Configuration;

public class GetDivByZero {
	
	public static void main(String[] args) {
		Configuration.VA_SSA = true;
		Configuration.BPD4 = true;
		Configuration.EXACT_MATCH_QUERY = true;
		
		MainClass.run();
	}

}
