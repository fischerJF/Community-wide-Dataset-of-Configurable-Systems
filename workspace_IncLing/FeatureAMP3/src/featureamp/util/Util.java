package featureamp.util; 

public  class  Util {
	
	public static String secondsToTimeString(int seconds) {
		String lengthString = "";
		// hours
		if(seconds >= 60*60) {
			int hours = (int)Math.floor(seconds/(60*60));
			lengthString += (hours < 10 ? "0" : "") + hours;
			seconds -= 60*60*hours;
		}
		
		if(lengthString != "") {
			lengthString += ":";
		}
		
		// minutes
		if(seconds >= 60) {
			int minutes = (int)Math.floor(seconds/60);
			lengthString += (minutes < 10 ? "0" : "") + minutes;
			seconds -= 60*minutes;
		} else {
			lengthString += "00";
		}
		if(lengthString != "") {
			lengthString += ":";
		}
		lengthString += (seconds < 10 ? "0" : "") + seconds;
		
		return lengthString;
	}


}
