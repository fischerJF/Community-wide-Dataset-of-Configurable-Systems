package vending;

import specifications.Configuration;

public class Dispenser {
	 private int MINSEL = 1; // Índice do primeiro item
	 private int MAXSEL = 20; // Índice do último item
     final private int VAL = 50; // Preço máximo dos itens

	private int[] availSelectionVals = { 1, 2, 3, 4,5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, /*18*/ 19 ,20 };
	private int[] stock = {20,20,20,0,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20};

	
	
	public Dispenser() {
		if(Configuration.flexiblequantity) {
			DispenserInput.leitor();
			availSelectionVals=new int [DispenserInput.a.length];
			stock= new int [DispenserInput.b.length];
			
			availSelectionVals=DispenserInput.a;
			stock=DispenserInput.b;
			MAXSEL=DispenserInput.a.length;
		}
	}
	
	public int dispense(int credit, int sel) {
		int val = 0;

		if (credit == 0) // no coins inserted
			val = -1;
		else if ((sel < MINSEL) || (sel > MAXSEL)) //item selected out of range 
			val = -3;
		else if (!available(sel)) // item sold out
			val = -4;
		else {
			val = VAL;
			if (credit < val) { // not enough credit to purchase item
				int value = val - credit;

				val = -2;
			} 
		}
		return val;
	}

	private boolean available(int sel) {
		for (int i = 0; i < availSelectionVals.length; i++)
			if (availSelectionVals[i] == sel)
				return true;
		return false;
	}
	protected void removeItem(int sel){
		for (int i = 0; i < availSelectionVals.length; i++)
			if (availSelectionVals[i] == sel){
				stock[i] -= 1;
				return;
			}
	}
	protected boolean checkAvailable(int sel){
		if(stock.length>=sel ) {
			return (stock[sel] > 0);
		}
		
		return false;
	}
	
	protected String printItem(){
		int total = 0;
		String items="";
		for (int i = 0; i < availSelectionVals.length; i++){
			items+="Item: " + availSelectionVals[i] + "\t Stock: " + stock[i]+"\n";
			if(this.checkAvailable(i)) {
				total += stock[i];	
			}
			
		}
		items+="Available items total: " + total;
		return items;
	}
	
} // classe Dispenser
