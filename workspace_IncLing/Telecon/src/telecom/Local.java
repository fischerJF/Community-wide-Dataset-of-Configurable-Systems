package telecom;

public class Local extends Connection {
    
  public  Local(Customer a, Customer b) {
	super(a, b);
	System.out.println("[new local connection from " + 
	   a + " to " + b + "]");
    }
}
