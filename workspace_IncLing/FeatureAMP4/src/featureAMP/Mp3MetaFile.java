package featureAMP;
import java.io.IOException; 

import com.mpatric.mp3agic.InvalidDataException; 
import com.mpatric.mp3agic.Mp3File; 
import com.mpatric.mp3agic.UnsupportedTagException; 

public  class  Mp3MetaFile  extends AbstractAudioFile {
	

	private int totalSec = 0;

	
	
	private String artist = null;

	
	private String title = null;

	
	private String track = null;

	
	private String album = null;

	
	private byte[] image = null;

	
	
	public Mp3MetaFile(String filename) throws UnsupportedTagException, InvalidDataException, IOException {
//		if (specifications.Configuration.mp3) {
			
			super(filename);
				
			Mp3File mp3File = new Mp3File(filename);
		
			this.totalSec = (int) mp3File.getLengthInSeconds();
			
			// ID3-Tags initialisieren
			if (mp3File.hasId3v2Tag()) {
				this.artist = mp3File.getId3v2Tag().getArtist();
				this.title = mp3File.getId3v2Tag().getTitle();
				this.track = mp3File.getId3v2Tag().getTrack();
				this.album = mp3File.getId3v2Tag().getAlbum();
				this.image = mp3File.getId3v2Tag().getAlbumImage();
			}
			else if (mp3File.hasId3v1Tag()) {
				this.artist = mp3File.getId3v1Tag().getArtist();
				this.title = mp3File.getId3v1Tag().getTitle();
				this.track = mp3File.getId3v1Tag().getTrack();
				this.album = mp3File.getId3v1Tag().getAlbum();
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
		return this.image;
	}


}
