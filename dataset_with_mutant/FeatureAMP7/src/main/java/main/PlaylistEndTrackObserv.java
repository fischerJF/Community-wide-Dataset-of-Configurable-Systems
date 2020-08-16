package main; 

import java.util.Observer; 
import java.util.Observable; 

import main.Playlist; 

public  class  PlaylistEndTrackObserv  implements Observer {
	  
  public void update(Observable obs, Object x) {
    Playlist.getInstance().nextSong();
  }


}
