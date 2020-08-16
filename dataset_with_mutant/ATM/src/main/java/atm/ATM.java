package atm;

import specifications.Configuration;

// ATM.java
// Represents an automated teller machine

public class ATM {
	private boolean userAuthenticated; // whether user is authenticated
	private int currentAccountNumber; // current user's account number
	private Screen screen; // ATM's screen
	private Keypad keypad; // ATM's keypad
	private CashDispenser cashDispenser; // ATM's cash dispenser
	private DepositSlot depositSlot; // ATM's deposit slot
	private BankDatabase bankDatabase; // account information database
	private boolean userExited; // user has not chosen to exit
    private double totalDeposit;
    private Transaction currentTransaction;
    private int accountNumber;
    private int pin;
	// constants corresponding to main menu options
	private static final int BALANCE_INQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;
	private static final int EXIT = 4;
	private static final int LOG = 0;

	// no-argument ATM constructor initializes instance variables
	public ATM() {
		
		userAuthenticated = false; // user is not authenticated to start
		currentAccountNumber = 0; // no current account number to start
		screen = new Screen(this); // create screen
		keypad = new Keypad(); // create keypad
		cashDispenser = new CashDispenser(); // create cash dispenser
		depositSlot = new DepositSlot(); // create deposit slot
		bankDatabase = new BankDatabase(); // create acct info database
		totalDeposit=0;
		currentTransaction=null;
	} // end no-argument ATM constructor

	// start ATM
	public void run() {
	if(!Configuration.USER_INTERFACE) {
		// welcome and authenticate user; perform transactions
		while (true) {
			// loop while user is not yet authenticated
			while (!userAuthenticated) {
				screen.displayMessageLine("\nWelcome!");
				authenticateUser(); // authenticate user
			} // end while

			performTransactions(); // user is now authenticated
			userAuthenticated = false; // reset before next ATM session
			currentAccountNumber = 0; // reset before next ATM session
			screen.displayMessageLine("\nThank you! Goodbye!");
		} // end while
	 }
	} // end method run

	// attempts to authenticate user against database
	private void authenticateUser() {
		if (!Configuration.USER_INTERFACE) {
			screen.displayMessage("\nPlease enter your account number: ");
			accountNumber = keypad.getInput(); // input account number
			screen.displayMessage("\nEnter your PIN: "); // prompt for PIN
			pin = keypad.getInput(); // input PIN

			// set userAuthenticated to boolean value returned by database
			userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);

			// check whether authentication succeeded
			if (userAuthenticated) {
				currentAccountNumber = accountNumber; // save user's account #
			} // end if
			else
				screen.displayMessageLine("Invalid account number or PIN. Please try again.");
		}
	} // end method authenticateUser

	// attempts to authenticate user against database
	public String authenticateUser_UserInterface(int accountNumber, int pin) {

		// set userAuthenticated to boolean value returned by database
		userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);

		// check whether authentication succeeded
		if (userAuthenticated) {
			currentAccountNumber = accountNumber; // save user's account #
			return "You are connected";
		} // end if
		else
			return "Invalid account number or PIN. Please try again.";
	} // end method authenticateUser

	// display the main menu and perform transactions
	private void performTransactions() {
		// local variable to store transaction currently being processed
		 currentTransaction = null;

		userExited = false; // user has not chosen to exit

		// loop while user has not chosen option to exit system
		while (!userExited) {
			// show main menu and get user selection
			int mainMenuSelection = displayMainMenu();

			// decide how to proceed based on user's menu selection
			switch (mainMenuSelection) {
			// user chose to perform one of three transaction types
			case BALANCE_INQUIRY:
			case WITHDRAWAL:
			case DEPOSIT:

				// initialize as new object of chosen type
				if (Configuration.DEPOSITING || Configuration.WITHDRAWING || Configuration.BALANCE_INQUIRY) {
					currentTransaction = createTransaction(mainMenuSelection);
					currentTransaction.execute(); // execute transaction
				}
				break;
			case EXIT: // user chose to terminate session
				screen.displayMessageLine("\nExiting the system...");
				userExited = true; // this ATM session should end
				break;
			case LOG: // user chose to print log
				if (Configuration.LOGGING) {
					Logger.printLog(screen);
				}
				break;
			default: // user did not enter an integer from 1-4
				screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
				break;
			} // end switch
		} // end while
	} // end method performTransactions

	// display the main menu and return an input selection
	private int displayMainMenu() {
		if (!Configuration.USER_INTERFACE) {
			screen.displayMessageLine("\nMain menu:");
			if (Configuration.BALANCE_INQUIRY) {
				screen.displayMessageLine("1 - View my balance");
			}
			if (Configuration.WITHDRAWING) {
				screen.displayMessageLine("2 - Withdraw cash");
			}
			if (Configuration.DEPOSITING) {
				screen.displayMessageLine("3 - Deposit funds");
			}
			screen.displayMessageLine("4 - Exit\n");

			if (Configuration.LOGGING) {
				screen.displayMessageLine("0 - log\n");
			}
			screen.displayMessage("Enter a choice: ");
			int option = keypad.getInput(); // return user's selection
			if (Configuration.LOGGING) {
				Logger.log("User option: " + option);
			}
			return option;
		}
		return 0;
	} // end method displayMainMenu

	// return object of specified Transaction subclass
	private Transaction createTransaction(int type) {
		Transaction temp = null; // temporary Transaction variable

		// determine which type of Transaction to create
	if(!Configuration.USER_INTERFACE) {
		switch (type) {
		case BALANCE_INQUIRY: // create new BalanceInquiry transaction
			if (Configuration.BALANCE_INQUIRY) {
				temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
				
			}
			break;
		case WITHDRAWAL: // create new Withdrawal transaction
			if (Configuration.WITHDRAWING) {
				temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
			}
			break;
		case DEPOSIT: // create new Deposit transaction
			if (Configuration.DEPOSITING) {
				temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
			}
			break;
		} // end switch
	}
		return temp; // return the newly created object
	} // end method createTransaction

	public void balance() {
		if (Configuration.BALANCE_INQUIRY) {
			if (userExited == false) {
				BalanceInquiry temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
				temp.execute();
				currentTransaction=temp;
			}
		}
	}

	public void Withdrawal(int amount) {
		if (Configuration.WITHDRAWING) {
			Withdrawal temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
			temp.setAmount(amount);
			temp.execute();
			currentTransaction=temp;
		}
	}

	public void deposit(int amount) {
		if (Configuration.DEPOSITING) {
			Deposit temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
			temp.setAmount(amount);
			temp.execute();
			totalDeposit+=temp.getAmount();
			currentTransaction=temp;
		}
	}

	public boolean isUserExited() {
		return userExited;
	}

	public void setUserExited(boolean userExited) {
		this.userExited = userExited;
	}

	public boolean isUserAuthenticated() {
		return userAuthenticated;
	}
	

	public void setUserAuthenticated(boolean userAuthenticated) {
		this.userAuthenticated = userAuthenticated;
	}

	public Screen getScreen() {
		return screen;
	}

	public double getTotalDeposit() {
		return totalDeposit;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public DepositSlot getDepositSlot() {
		return depositSlot;
	}

	public int getCurrentAccountNumber() {
		return currentAccountNumber;
	}

	public void setCurrentAccountNumber(int currentAccountNumber) {
		this.currentAccountNumber = currentAccountNumber;
	}
	
	

} // end class ATM
