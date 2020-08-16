package featureamp.playback; 

import java.awt.Image; 

import java.io.File; 

import featureamp.playback.Track; 

/**
 * TODO description
 */
public   class  BasicTrack  implements Track {
	

	protected File source;

	
	protected String artist, title, album, length, tracknumber;

	
	protected Image cover;

	
	private boolean enabled;

	

	public BasicTrack(File f) {
		if (specifications.Configuration.base) {
			// Base
			source = f;
			artist = "";
			title = "";
			album = "";
			length = "0:00";
			tracknumber = "-1";
			enabled = true;
				}
	}

	

	public String getArtist() {
		// Base
		return artist;
	}

	

	public String getTitle() {
		// Base
		return title;
	}

	

	public String getLength() {
		// Base
		return length;
	}

	

	public File getFile() {
		// Base
		return source;
	}

	

	
	public boolean enabled() {
		// Base
		return enabled;
	}

	
	
	public void setEnabled(boolean b) {
		// SkipTrack
		enabled = b;
	}

	

	public Image getCover() {
		// Cover
		return cover;
	}

	

	public String getTracknumber() {
		// TrackNumber
		return tracknumber;
	}

	

	public String getAlbum() {
		// Album
		return album;
	}


}
