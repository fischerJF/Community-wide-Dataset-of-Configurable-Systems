package main; 

import java.util.Observer; 
import java.util.Observable; 

import main.OpenFile; 

public  class  PlaylistNewInfoObserv  implements Observer {
	  
  public void update(Observable obs, Object x) {
    if (OpenFile.getInstance().getNewFile()) {
      Song newSong = new Song(OpenFile.getInstance().getFilename(), OpenFile.getInstance().getTagsEnabled(), OpenFile.getInstance().getArtist(), OpenFile.getInstance().getTitle(), OpenFile.getInstance().getAlbum(), OpenFile.getInstance().getTrackNr(), OpenFile.getInstance().getDuration(), OpenFile.getInstance().getType());
      Playlist.getInstance().addSingleSong(newSong);
    }
  }


}
