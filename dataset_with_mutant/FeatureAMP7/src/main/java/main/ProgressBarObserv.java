package main; 

import java.util.Observer; 
import java.util.Observable; 

import main.FeatureAmp; 
import main.OpenFile; 
import main.ProgressBar; 

public  class  ProgressBarObserv  implements Observer {
	
  private ProgressBar progBar;

	
  
  public ProgressBarObserv(ProgressBar progBarIn) {
		if (specifications.Configuration.progressbar) {
	    progBar = progBarIn;
	  		}
	}

	
  
  public void update(Observable obs, Object x) {
    progBar.setDuration(OpenFile.getInstance().getDuration());
    progBar.updateTime(FeatureAmp.getCurrentTime());
  }


}
