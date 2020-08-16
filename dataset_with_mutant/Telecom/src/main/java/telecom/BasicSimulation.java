package telecom;

import specifications.Configuration;

/**
 * This simulation subclass implements AbstractSimulation.run(..)
 * with  a test script for the telecom system with only the
 * basic objects.
 */
public class BasicSimulation extends AbstractSimulation {

    /* Creates objects and puts them to work.
     * (non-Javadoc)
     * @see telecom.AbstractSimulation#run()
     */
    public void run() {
        Customer jim = new Customer("Jim", 650);
        Customer mik = new Customer("Mik", 650);
        Customer crista = new Customer("Crista", 415);

        say("jim calls mik...");
        Call c1 = jim.call(mik);
        wait(1.0);
        say("mik accepts...");
        mik.pickup(c1);
        wait(2.0);
        say("jim hangs up...");
        jim.hangup(c1);
        report(jim);
        report(mik);
        report(crista);

        say("mik calls crista...");
        Call c2 = mik.call(crista);
        say("crista accepts...");
        crista.pickup(c2);
        wait(1.5);
        say("crista hangs up...");
        crista.hangup(c2);
        report(jim);
        report(mik);
        report(crista);
    }

    /* (non-Javadoc)
     * @see telecom.AbstractSimulation#report(telecom.Customer)
     */
    protected void report(Customer c) {
    	System.out.println(c+"spent"+c.getTotalConnectTime());
    	
    	if(Configuration.HISTORIC) {
    		Historic.addRecords(c+"spent"+c.getTotalConnectTime());
    	}
    }

    /**
     * @param args
     */
//    public static void main(String[] args){
//    	AbstractSimulation simulation = new BasicSimulation();
//    	simulation.run();
//    }
}
