package bankaccount;

import specifications.Configuration;

/**
 * @author chupanw
 */
public class LogEntry {
    private Account source;

    private Account destination;

    private int value;

    public LogEntry(Account source, Account destination, int amount) {
        if (Configuration.logging) {
            this.source = source;
            this.destination = destination;
            this.value = amount;
        }
    }

    public Account getSource() {
        return source;
    }

    public Account getDestination() {
        return destination;
    }

    public int getAmount() {
        return value;
    }


}

