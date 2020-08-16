package experiment;




public class MainBaseline {
	public static void main(String[] args) throws Exception {

		searchTime(args);

	}

	private static void searchTime(String[] args) throws Exception {
		
		long startTime = 0;
		long finishTime = 0;
		int totalExecution = 1;
		int index = 0;
		finishTime = 0;

		startTime = System.currentTimeMillis();

//		while (index < totalExecution) {
		System.err.println("Start");
		BaselineAdapter baseline= new BaselineAdapter();
		baseline.baselineRun();
			   
			    /****** Fim ******/
			    
			index++;
//		}
		finishTime = System.currentTimeMillis() - startTime;


		float media = finishTime / index;

		System.out.println(
				"Tempo gasto total (milisegundos): " + finishTime + " tempo médio (milisegundos): " + media + " número de vezes executadas:" + index);

	}

	

	
}
