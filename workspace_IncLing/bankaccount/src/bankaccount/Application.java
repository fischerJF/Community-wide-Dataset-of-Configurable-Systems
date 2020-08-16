package bankaccount;

import specifications.Configuration;

/**
 * @author chupanw
 */
public class Application {
    public Account account = new Account();

    

    private void nextDay__DailyLimit() {
        if (Configuration.dailylimit) {
        	 account.withdraw = 0;
        }
       
    }

    
   public void nextDay() {
        if (!Configuration.interest) {
            nextDay__DailyLimit();
            return;
        }
        nextDay__DailyLimit();
        account.interest += account.calculateInterest();
    }

   

    public void nextYear() {
        account.balance += account.interest;
        account.interest = 0;
    }

}
