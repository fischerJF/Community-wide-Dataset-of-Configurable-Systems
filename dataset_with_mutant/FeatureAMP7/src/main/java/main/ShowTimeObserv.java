package main; 

import java.util.Observer; 
import java.util.Observable; 

import main.FeatureAmp; 
import main.OpenFile; 

public  class  ShowTimeObserv  implements Observer {
	
  private static long currentDuration = 0;

	
  
  public void update(Observable obs, Object x) {
    currentDuration = OpenFile.getInstance().getDuration();
    FeatureAmp.getFrame().setTitle(FeatureAmp.getTitleToSet() + " - " + Utils.timeToString(FeatureAmp.getCurrentTime()/1000) + "/" + Utils.timeToString(currentDuration));
  }


}
