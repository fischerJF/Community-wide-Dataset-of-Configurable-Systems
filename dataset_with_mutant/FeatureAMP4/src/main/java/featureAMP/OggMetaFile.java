package featureAMP;
import java.io.File; 
import java.util.Map; 

import javax.sound.sampled.AudioFileFormat; 
import javax.sound.sampled.AudioSystem; 

import org.tritonus.share.sampled.file.TAudioFileFormat; 

public  class  OggMetaFile  extends AbstractAudioFile {
	

	private int totalSec = 0;

	
	
	private String artist = null;

	
	private String title = null;

	
	private String track = null;

	
	private String album = null;

	
	
	@SuppressWarnings("rawtypes")
	public OggMetaFile(String filename) {
//		if (specifications.Configuration.ogg) {
			
			super(filename);
			
			File file = new File(filename);
			
			try {
				AudioFileFormat baseFileFormat = AudioSystem.getAudioFileFormat(file);
				if (baseFileFormat instanceof TAudioFileFormat) {
					Map props = ((TAudioFileFormat)baseFileFormat).properties();
					this.totalSec = (int) Math.round((((Long)props.get("duration")).longValue())/1000000);
					this.artist = (String) props.get("author");
					this.title = (String) props.get("title");
					this.track = (String) props.get("ogg.comment.track");
					this.album = (String) props.get("album");
				}
			}
			catch (Exception e) {
			    e.printStackTrace();
			}
			
			if (this.artist == null)
				this.artist = "Unbekannter Interpret";
			if (this.title == null)
				this.title = "Unbekannter Titel";
			if (this.track == null)
				this.track = "0";
			if (this.album == null)
				this.album = "Unbekanntes Album";
			
//				}
	}

	

	@Override
	public int getTotalSec() {
		return this.totalSec;
	}

	

	@Override
	public String getArtist() {
		return this.artist;
	}

	

	@Override
	public String getTitle() {
		return this.title;
	}

	

	@Override
	public String getTrack() {
		return this.track;
	}

	

	@Override
	public String getAlbum() {
		return this.album;
	}

	

	@Override
	public byte[] getAlbumArt() {
		return null;
	}


}
