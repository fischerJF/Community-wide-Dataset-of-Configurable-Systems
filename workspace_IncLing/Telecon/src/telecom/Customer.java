package telecom;

import java.util.Vector;

import specifications.Configuration;

/**
 * Customers have a unique id (name in this case for didactic purposes
 * but it could be telephone number) and area code.
 * They also have protocol for managing calls: call, pickup, etc.
 */
public class Customer {

    private String name;
    private int areacode;
    private Vector calls = new Vector();
    
    protected long totalConnectTime = 0;

    /**
     * unregister a call
     */
    protected void removeCall(Call c){
    	calls.removeElement(c);
    	if(Configuration.HISTORIC) {
    		Historic.addRecords("remove: "+name);
    	}
    }

    /**
     * register a call
     */
    protected void addCall(Call c){
    	calls.addElement(c);
    	if(Configuration.HISTORIC) {
    		Historic.addRecords("pickup - caller: "+c.getCaller()+ " receiver: "+c.getReceiver());
    	}
    }

    /**
     * Make a new customer with given name
     */
    public Customer(String name, int areacode) {
        this.name = name;
        this.areacode = areacode;
    }

    /**
     * String rendition of customer
     */
    public String toString() {
        return name + "(" + areacode + ")";
    }

    /**
     * what area is the customer in?
     */
    public int getAreacode(){
    	return areacode;
    }

    /**
     * Is the other customer in the same area?
     */
    public boolean localTo(Customer other){
    	return areacode == other.areacode;
    }

    /**
     * Make a new call to receiver
     */
    public Call call(Customer receiver) {
        Call call = new Call(this, receiver);
        addCall(call);
        if(Configuration.HISTORIC) {
        	Historic.addRecords("called Name: "+this.name+ " areacode: "+this.areacode +
        		            " to name:" + receiver.name + "areacode: "+ receiver.areacode );
        }
        return call;
    }

    /**
     * pick up a call
     */
    public void pickup(Call call) {
        call.pickup();
        addCall(call);
    }

    /**
     * hang up a call
     */
    public void hangup(Call call) {
    	call.hangup(this);
    	removeCall(call);
    }

    /**
     * Merge a pair of calls -- conference them
     * PRE: call1.includes(this)
     *      call2.includes(this)
     *      call1.connected()
     *      call2.connected()
     * POST: call1 includes all customers connected by call1@pre and call2@pre
     */
    public void merge(Call call1, Call call2){
    	call1.merge(call2);
    	removeCall(call2);
    }

    public void increaseTotalConnectTime(long time)  {
        this.totalConnectTime += time;
    }
    public long getTotalConnectTime(){
        return totalConnectTime;
    }

   public Vector getCall() {
	   return calls;
   }
    
}
