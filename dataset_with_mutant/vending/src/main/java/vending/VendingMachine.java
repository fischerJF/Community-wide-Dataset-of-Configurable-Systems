package vending;

import specifications.Configuration;


public class VendingMachine {
	final private int COIN = 0; 
	private int totValue; 
	private int totalValueCollected; 
	private int currValue; // Valor atual depositado
	private Dispenser d;

	public VendingMachine() {
		totValue = 0;
		currValue = 0;
		totalValueCollected=0;
		d = new Dispenser();
	}

	public int insertCoin(int coin) {
		if(Configuration.coinValidation) {
			if(validateCoin(coin)){
				currValue += coin;
				}	
		}else {
			  currValue += coin;
		}
		if(Configuration.totalValueCollected) {
		totalValueCollected+=coin;
		}
		
		return currValue;
	}
	
	private boolean validateCoin(int coin){
		return coin % 25 == 0 && coin > 0 && coin <= 100; 
	}

	public int returnCoin() {
		int value = currValue;

		if (currValue != 0)
			currValue = 0;

		return value;
	}

	
	public int vendItem(int selection) {
		int expense;
		if(d.checkAvailable(selection)){
			d.removeItem(selection);
		}
		expense = d.dispense(currValue, selection);
		if (expense > 0) {
			totValue += expense;
			currValue -= expense;
			expense = currValue;
		}
		return expense;
	}
	public String showItem(){
		if(Configuration.showStock) {
		   return d.printItem();
		}
		return "";
	}
	public int totalValueCollected() {
		if(Configuration.totalValueCollected) {
		return totalValueCollected; 
		}
		return 0;
	}
	
} // classe VendingMachine
