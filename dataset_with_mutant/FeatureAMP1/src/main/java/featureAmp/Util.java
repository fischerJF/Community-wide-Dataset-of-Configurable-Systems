package featureAmp; 

import java.text.DecimalFormat; 

public abstract  class  Util {
	
	public static String formatTime(long seconds){
		DecimalFormat df = new DecimalFormat("00");
		return df.format(seconds / 60) + ":"
				+ df.format(seconds % 60);
	}


}
