package main; 

import java.util.Observer; 
import java.util.Observable; 

import main.OpenFile; 

public  class  PlaylistNewSongObserv  implements Observer {
	
  public void update(Observable obs, Object x) {
    Playlist.getInstance().addSong(OpenFile.getInstance().parseFile(OpenFile.getInstance().getFilename()));
  }


}
