package telecom;

public privileged aspect Timing
{	
	/*Implementation element 1*/
	Timer Connection.timer = new Timer(); //Duration of a connection
	
	/*Implementation element 3*/
	protected long Customer.totalConnectTime = 0; //Connection time of a customer
	
	/*Implementation element 2*/
	/*It was not being called in any part of the system, so it could be or not refactored*/
	//Returns the elapsed time of a connection
	public double Connection.connectionTime() 
	{
    	return timer.getTime();
    }
	
	/*Implementation element 4*/
	//How much time this costumer spent on calls
	public long Customer.getTotalConnectTime() 
	{
        return totalConnectTime;
    }
    
    /*Implementation element 5*/
	//Increase the costumer time on calls
	public void Customer.increaseTotalConnectTime(long time) 
	{
    	this.totalConnectTime += time;
    }
    
    /*Implementation element 7*/
    //Starts to count the connection time
    after(Connection connection):call(void Connection.complete())&&target(connection);
    {
    	connection.timer.start();
    }
    
    /*Implementation element 8*/
    //Finishes the connection time record
    after(Connection connection):call(void Connection.drop())&&target(connection)
    {
    	connection.timer.stop();
    	
    	//Increases the connection time of the caller and the receiver
    	connection.caller.increaseTotalConnectionTime(connection.timer.getTime());
    	connection.receiver.increaseTotalConnectionTime(connection.timer.getTime());
    }
    
    /*Implementation element 9*/
    /*OBS: The method BasicSimulation.report() could be or not considered completely dedicated to the Timing concern*/
    //Performs the connection time report
    after(Customer customer):timeReport(customer):call(protected void BasicSimulation.report(Customer))&&args(customer)
    {
    	System.out.println(customer+" spent "+customer.getTotalConnectTime());
    }
    
    /*
     * OBS: The Timer class (implementation element 6) is not abstract. Since it could has instances 
     * and it is completely dedicated to Timing, this class could be considered already modularized
     */
}