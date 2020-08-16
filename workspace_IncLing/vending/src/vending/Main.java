package vending;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import specifications.Configuration;

public class Main {

	BufferedReader drvInput;
	
	public void start(String args[])  {
		Menu m= new Menu();
		if(Configuration.keyboard) {
			drvInput = new BufferedReader(new InputStreamReader(System.in));	
			m.run(drvInput);
		}else if(Configuration.terminal) {
			try {
			drvInput = new BufferedReader(new FileReader(args[0]));
			m.run(drvInput);
			}catch(Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		Configuration.keyboard=false;
		Configuration.terminal=false;
		Configuration.showStock=false;
		Configuration.flexiblequantity=true;
		
		Main m = new Main();
		m.start(args);
	}
}
