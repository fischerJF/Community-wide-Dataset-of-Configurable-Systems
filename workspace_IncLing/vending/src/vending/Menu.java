package vending;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import specifications.Configuration;

public class Menu {

	public void run (BufferedReader drvInput) {
		String methodName = new String();
		String tcLine = new String();
		VendingMachine machine = new VendingMachine();

  		System.out.println("VendingMachine LIGADA");
		// para entradas via teclado, CTRL+D pára a execução da máquina
  		try {
		while ((tcLine = drvInput.readLine()) != null) {
			StringTokenizer tcTokens = new StringTokenizer(tcLine);


			if (tcTokens.hasMoreTokens())
				methodName = tcTokens.nextToken();

			int value = 0;
			
			if (methodName.equals("insertCoin")) {
				value = machine.insertCoin(Integer.parseInt(tcTokens.nextToken()));
				System.out.println("Current Credit = " + value);
			} // Uma ou mais moedas são devolvidas (caso exista alguma)
			else if (methodName.equals("returnCoin")) {
				value = machine.returnCoin();
				if (value == 0)
					System.out.println("No credit for return");
				else
					System.out.println("Withdraw your coins");
			} // Solicitação para a entrega de determinado item
			else if (methodName.equals("vendItem")) {
				Integer selection = new Integer(tcTokens.nextToken());

				value = machine.vendItem(selection.intValue());
				if (value >= 0) {
					System.out.println("Remove the desired item!");
					System.out.println("Current Credit = " + value);
				} else if (value == -1) {
					System.out.println("No coins inserted!");
				} else if (value == -3) {
					System.out.println("The selected item(" + selection
							+ ")  is invalid!!!");
				} else if (value == -4) {
					System.out.println("The selected item(" + selection
							+ ") is sold out!!!");
				} else if (value == -2) {
					System.out
							.println("Current credit is insufficient for purchase of item "
									+ selection + ".");
				}
			} else if (methodName.equals("showItems") && Configuration.showStock) {
				System.out.println(machine.showItem());
			}else if(methodName.equals("totalValueCollected") && Configuration.totalValueCollected) {
				System.out.println(machine.totalValueCollected());
			}
			else {
				System.out.println("Invalid operation!");
			}
		}
  		}catch(Exception e) {
  			
  		}
		System.out.println("VendingMachine DESLIGADA");
	}

}	

