package main; 

import java.util.Observer; 
import java.util.Observable; 

import main.OpenFile; 

public  class  ShowCoverNewInfoObserv  implements Observer {
	
  private CoverPane currentPane;

	
  
  public ShowCoverNewInfoObserv(CoverPane currentPaneIn) {
		if (specifications.Configuration.showcover) {
	    currentPane = currentPaneIn;
	  		}
	}

	
  
  public void update(Observable obs, Object x) {
    currentPane.setCover(OpenFile.getInstance().getCover());
  }


}
