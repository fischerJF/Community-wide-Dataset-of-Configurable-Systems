package atm;

import specifications.Configuration;

// Deposit.java
// Represents a deposit ATM transaction

public class Deposit extends Transaction
{
   private double amount; // amount to deposit
   private Keypad keypad; // reference to keypad
   private DepositSlot depositSlot; // reference to deposit slot
   private final static int CANCELED = 0; // constant for cancel option

   // Deposit constructor
   public Deposit( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot )
   {
      // initialize superclass variables
      super( userAccountNumber, atmScreen, atmBankDatabase );
      if(Configuration.DEPOSITING) {
    	  // initialize references to keypad and deposit slot
    	  keypad = atmKeypad;
    	  depositSlot = atmDepositSlot;
      }
   } // end Deposit constructor

   // perform transaction
   @Override
   public void execute()
   {
	  if(Configuration.DEPOSITING) {
		  BankDatabase bankDatabase = getBankDatabase(); // get reference
		  Screen screen = getScreen(); // get reference

		  if(!Configuration.USER_INTERFACE) {
			  amount = promptForDepositAmount(); // get deposit amount from user
		  }
		  
		  
		  // check whether user entered a deposit amount or canceled
		  if ( amount != CANCELED )
		  {
			  // request deposit envelope containing specified amount
			  screen.displayMessage( 
					  "\nPlease insert a deposit envelope containing " );
			  if(!Configuration.USER_INTERFACE) {
				  screen.displayDollarAmount( amount );
				  screen.displayMessageLine( "." );
			  }
			  // receive deposit envelope
			  boolean envelopeReceived = depositSlot.isEnvelopeReceived();

			  // check whether deposit envelope was received
			  if ( envelopeReceived )
			  {  
				  screen.displayMessageLine( "\nYour envelope has been " + 
						  "received.\nNOTE: The money just deposited will not " + 
						  "be available until we verify the amount of any " +
						  "enclosed cash and your checks clear." );
            
				  // credit account to reflect the deposit
				  bankDatabase.credit( getAccountNumber(), amount ); 
			  } // end if
			  else // deposit envelope not received
			  {
				  screen.displayMessageLine( "\nYou did not insert an " +
						  "envelope, so the ATM has canceled your transaction." );
			  } // end else
		  } // end if 
		  else // user canceled instead of entering amount
		  {
			  screen.displayMessageLine( "\nCanceling transaction..." );
		  } // end else
	  }//end   Configuration.DEPOSITING
   } // end method execute

   // prompt user to enter a deposit amount in cents 
   private double promptForDepositAmount()
   {
      Screen screen = getScreen(); // get reference to screen

      // display the prompt
      screen.displayMessage( "\nPlease enter a deposit amount in " + 
         "CENTS (or 0 to cancel): " );
      int input = keypad.getInput(); // receive input of deposit amount
      // check whether the user canceled or entered a valid amount
      if ( input == CANCELED ) 
         return CANCELED;
      else
      {
         return ( double ) input / 100; // return dollar amount 
      } // end else
   } // end method promptForDepositAmount

   public double getAmount() {
	   return amount;
   }

   public void setAmount(double amount) {
	   this.amount = amount;
   }

   public DepositSlot getDepositSlot() {
	 return depositSlot; 
   }
   
   
} // end class Deposit
