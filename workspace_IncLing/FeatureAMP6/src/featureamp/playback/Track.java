package featureamp.playback; 

import java.awt.Image; 
import java.io.File; 

/**
 * TODO description
 */
public   interface  Track {
	

	String getArtist();

	
	String getTitle();

	
	String getLength();

	
	File getFile();

	
	boolean enabled();

	
	void setEnabled(boolean b);

	

	Image getCover();

	

	String getTracknumber();

	

	String getAlbum();


}
