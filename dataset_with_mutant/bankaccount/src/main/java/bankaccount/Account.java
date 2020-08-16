package bankaccount;

import specifications.Configuration;

/**
 * @author chupanw
 */
public class Account {

	public static int DAILY_LIMIT = -1000;
    public int withdraw = 0;
    static int INTEREST_RATE = 2;
    public int interest = 0;
    public int OVERDRAFT_LIMIT = Configuration.overdraft ? -5000 : 0;

    public int balance = 0;

   public Account() {
        if (Configuration.bankaccount) {
        }
    }

    private boolean update__BankAccount(int x) {
        int newBalance = balance + x;
        if (newBalance < OVERDRAFT_LIMIT)
            return false;
        balance = balance + x;
        return true;
    }

    private boolean update__DailyLimit(int x) {
        if (!Configuration.dailylimit)
            return update__BankAccount(x);
        int newWithdraw = withdraw;
        if (x < 0) {
            newWithdraw += x;
            if (newWithdraw < DAILY_LIMIT)
                return false;
        }
        if (!update__BankAccount(x))
            return false;
        withdraw = newWithdraw;
        return true;
    }

    public boolean update(int x) {
        if (!Configuration.logging)
            return update__DailyLimit(x);
        if (update__DailyLimit(x)) {
            return true;
        }
        return false;

    }

    private boolean undoUpdate__BankAccount(int x) {
        int newBalance = balance - x;
        if (newBalance < OVERDRAFT_LIMIT)
            return false;
        balance = newBalance;
        return true;
    }

    private boolean undoUpdate__DailyLimit(int x) {
        if (!Configuration.dailylimit)
            return undoUpdate__BankAccount(x);
        int newWithdraw = withdraw;
        if (x < 0) {
            newWithdraw -= x;
            if (newWithdraw < DAILY_LIMIT)
                return false;
        }
        if (!undoUpdate__BankAccount(x))
            return false;
        withdraw = newWithdraw;
        return true;
    }

    public boolean undoUpdate(int x) {
        if (!Configuration.logging)
            return undoUpdate__DailyLimit(x);
        if (undoUpdate__DailyLimit(x)) {
            return true;
        }
        return false;

    }

    public int calculateInterest() {
        return balance * INTEREST_RATE / 36500;
    }

   public  int estimatedInterest(int daysLeft) {
        return interest + daysLeft * calculateInterest();
    }

    public boolean credit(int amount) {
    	if(Configuration.creditworthiness)
    		return balance >= amount;
        
        return false;
    
    }

    public boolean lock = false;

    public void lock() {
        lock = true;
    }

    public void unLock() {
        lock = false;
    }

    public boolean isLocked() {
        return lock;
    }

}
