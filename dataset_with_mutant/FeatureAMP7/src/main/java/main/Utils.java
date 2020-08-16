package main; 

public  class  Utils {
	
  private Utils() {
		if (specifications.Configuration.time) {
	  		}
	}

	

  /**
   * Format the time from a timestamp to a readable format
   * @param time The time in seconds
   * @return The time as string HH:MM:SS (hours only shown, when HH>0)
   */
  public static String timeToString (long time) {
    String retStr = "";

    long hours = time/3600;
    int minutes = ((int)(time-3600*hours))/60;
    int seconds = (int)(time-3600*hours-60*(long)minutes);
    
    if (hours > 0) {
      retStr += String.format("%02d", hours) + ":";
    }
    retStr += String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
    return retStr;
  }


}
