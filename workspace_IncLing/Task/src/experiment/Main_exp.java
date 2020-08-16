package experiment;

public class Main_exp {
	public static void main(String[] args) throws Exception {

		searchTime(args);

	}

	private static void searchTime(String[] args) throws Exception {
		
		long startTime = 0;
		long finishTime = 0;
		int totalExecution = 10;
		int index = 0;
		finishTime = 0;

		startTime = System.currentTimeMillis();
System.out.println("inicio");
		//while (index < totalExecution) {
		
		BaselineAdapter baseline= new BaselineAdapter();
    baseline.baselineRun();
			   
			    /****** Fim ******/
			    
			index++;
		///}
		finishTime = System.currentTimeMillis() - startTime;


		float media = finishTime / index;

		System.out.println(
				"Tempo gasto total (milisegundos): " + finishTime + " tempo médio (milisegundos): " + media + " número de vezes executadas:" + index);

	}

	

	
}
