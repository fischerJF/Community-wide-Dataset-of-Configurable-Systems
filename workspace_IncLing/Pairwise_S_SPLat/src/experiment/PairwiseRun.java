package experiment;


import sampling.Pairwise;
import sampling.Pairwise.Requirement;
import splat.GPLVariables;


public class PairwiseRun {
	
	public static void runExp() {
		
		Pairwise pw = new Pairwise(GPLVariables.getSINGLETON());
		System.out.println(pw);
		for ( Requirement r : pw.requirements) {
			System.out.println(r.index_1+ " "+r.val_1 );
			
			String palavra = ""; 
			palavra = r.index_1.substring (0, r.index_1.length() - 3);
			System.out.println(palavra);
		}
//		pw.requirements
	}


}
