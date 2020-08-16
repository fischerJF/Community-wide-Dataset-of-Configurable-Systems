package defects;

import queval.*;
import specifications.Configuration;

public class GetStackOverflow {

	public static void main(String[] args) {
//		if RVariant & !GiSTII & !VA_SSA & !RStarSplit & !LinearSplit & QuadraticCostAlgorithm & SS11:
//		if RVariant & !GiSTII & !VA_SSA & !RStarSplit & !LinearSplit & QuadraticCostAlgorithm & !SS11:
		
		Configuration.RVariant = true;
		Configuration.QuadraticCostAlgorithm = true;
		Configuration.SS17 = true;
//		Configuration.SS11 = true;
		Configuration.EPSILON_NN_QUERY = true;
		Configuration.GuttmanInsert = true;
		
		MainClass.run();
	}
	
}