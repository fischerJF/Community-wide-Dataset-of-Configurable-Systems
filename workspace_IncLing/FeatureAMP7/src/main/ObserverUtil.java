package main; 

import java.util.Observable; 

public  class  ObserverUtil  extends Observable {
	
  public void update() {
    // Notify observers of change
    setChanged();
    notifyObservers();
  }


}
