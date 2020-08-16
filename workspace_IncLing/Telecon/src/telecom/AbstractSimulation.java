package telecom;

import specifications.Configuration;

public abstract class AbstractSimulation {

     /**
     * Creates objects and puts them to work.
     */
    public abstract void run();
    
    /**
     * Print a report of the connection time for customer
     */
    protected abstract void report(Customer c);

    /**
     * Wait 0.1 seconds per "second" for simulation
     */
    protected static void wait(double seconds) {
        Object dummy = new Object();
        if(Configuration.HISTORIC) {
        	Historic.addRecords("wait: "+ seconds );
        }
        synchronized (dummy) {
	    //XXX cheat and only wait 0.1 seconds per second
            try {dummy.wait((long)(seconds*100)); }
            catch (Exception e) {}
        }
    }

    /**
     * Put a message on standard output
     */
    protected static void say(String s){
    	if(Configuration.HISTORIC) {
    		Historic.addRecords(s);
    	}
    	System.out.println(s);
    }
}
