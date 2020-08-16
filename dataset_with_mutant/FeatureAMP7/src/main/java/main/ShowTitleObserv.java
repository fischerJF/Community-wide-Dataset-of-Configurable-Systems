package main; 

import java.util.Observer; 
import java.util.Observable; 

import main.FeatureAmp; 
import main.OpenFile; 

public  class  ShowTitleObserv  implements Observer {
	  
  public void update(Observable obs, Object x) {
    if (OpenFile.getInstance().getTagsEnabled()) {
      FeatureAmp.setTitleToSet("FeatureAmp - " + OpenFile.getInstance().getArtist() + " - " + OpenFile.getInstance().getTitle());
    } else {
      FeatureAmp.setTitleToSet("FeatureAmp - " + OpenFile.getInstance().getFilename());
    }
  }


}
