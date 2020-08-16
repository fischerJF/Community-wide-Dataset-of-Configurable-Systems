package atm;

import specifications.Configuration;

// BalanceInquiry.java
// Represents a balance inquiry ATM transaction

public class BalanceInquiry extends Transaction
{
   // BalanceInquiry constructor
   public BalanceInquiry( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase )
   {
      super( userAccountNumber, atmScreen, atmBankDatabase );
   } // end BalanceInquiry constructor

   // performs the transaction
   @Override
   public void execute()
   {
	   if(Configuration.BALANCE_INQUIRY) {
		   // get references to bank database and screen
		   BankDatabase bankDatabase = getBankDatabase();

		   // get the available balance for the account involved
		   double availableBalance = 
				   bankDatabase.getAvailableBalance( getAccountNumber() );

		   // get the total balance for the account involved
		   double totalBalance = 
				   bankDatabase.getTotalBalance( getAccountNumber() );
      
		   printBalance(availableBalance, totalBalance);
	  }
   } // end method execute
	   
   
   private void printBalance(double availableBalance, double totalBalance) {
	      if(Configuration.BALANCE_INQUIRY) {
	    	  Screen screen = getScreen();
	    	  // display the balance information on the screen
	    	  screen.displayMessageLine( "\nBalance Information:" );
	    	  screen.displayMessage( " - Available balance: " ); 
	    	  screen.displayDollarAmount( availableBalance );
	    	  screen.displayMessage( "\n - Total balance:     " );
	    	  screen.displayDollarAmount( totalBalance );
	    	  screen.displayMessageLine( "" );
	    	  if(Configuration.LOGGING) {
	    		  Logger.log("User balance: "+availableBalance+", "+totalBalance);
	    	  }
	      }
   }
} // end class BalanceInquiry
