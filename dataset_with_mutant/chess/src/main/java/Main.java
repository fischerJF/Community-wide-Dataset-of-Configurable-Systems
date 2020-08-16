import MVC.*;
import specifications.Configuration;
public class Main{
	public static void main(String[]args){
        
		Configuration.AI_PLAYER=true;
        Configuration.OFFLINE_PLAYER=false;
        Configuration.ONLINE_PLAYER=false;
        
		MVC mvc = new MVC();
	}
}