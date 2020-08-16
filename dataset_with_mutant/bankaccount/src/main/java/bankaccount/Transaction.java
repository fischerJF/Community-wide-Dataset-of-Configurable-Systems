package bankaccount;

import specifications.Configuration;

/**
 * @author chupanw
 */
public class Transaction {
    private boolean transfer__Transaction(Account source, Account destination, int amount) {
        if (!lock(source, destination)) return false;
        if (amount <= 0) {
            return false;
        }
        if (!source.update(amount * -1)) {
            return false;
        }
        if (!destination.update(amount)) {
            source.undoUpdate(amount * -1);
            return false;
        }
        return true;
    }

   public  boolean transfer(Account source, Account destination, int amount) {
        if (!Configuration.transactionlog)
            return transfer__Transaction(source, destination, amount);
        if (transfer__Transaction(source, destination, amount)) {
            transactionCounter = (transactionCounter + 1);
            return true;
        }
        return false;
    }

    private static synchronized boolean lock(Account source, Account destination) {
        if (source.isLocked()) return false;
        if (destination.isLocked()) return false;
        source.lock();
        destination.lock();
        return true;
    }

    int transactionCounter = 0;
}
