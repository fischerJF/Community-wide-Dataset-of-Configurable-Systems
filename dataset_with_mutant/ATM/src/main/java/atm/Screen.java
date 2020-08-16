package atm;

import specifications.Configuration;

// Screen.java
// Represents the screen of the ATM

public class Screen
{
	ATMUserInterface frame;
	
	public Screen(ATM atm) {
	
		if(Configuration.USER_INTERFACE) {
		frame = new ATMUserInterface(atm);
    	
		}

	}
   // displays a message without a carriage return
   public void displayMessage( String message ) 
   {
	  if(Configuration.USER_INTERFACE) { 
		   frame.msg+="\n"+message;
	   }else {
		   System.out.print( message );
	   }
		
   } // end method displayMessage

   // display a message with a carriage return
   public void displayMessageLine( String message ) 
   {
	   if(Configuration.USER_INTERFACE) {
		   frame.msg+="\n"+message;
	   }else {
		   System.out.println( message );
	   }
   } // end method displayMessageLine

   // display a dollar amount
   public void displayDollarAmount( double amount )
   {
       if(Configuration.USER_INTERFACE) {
    	   frame.msg+= "$%"+amount;
       }else {
    	   System.out.printf( "$%,.2f", amount );
       }
   } // end method displayDollarAmount 
} // end class Screen
