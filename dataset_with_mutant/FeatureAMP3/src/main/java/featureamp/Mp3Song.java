package featureamp; 

import java.io.File; 
import java.io.IOException; 
import java.util.Map; 

import javax.sound.sampled.AudioFileFormat; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import javax.swing.ImageIcon; 

import org.jaudiotagger.audio.mp3.MP3File; 
import org.jaudiotagger.tag.FieldKey; 
import org.jaudiotagger.tag.TagException; 
import org.jaudiotagger.tag.id3.AbstractID3v2Tag; 
import org.jaudiotagger.tag.id3.ID3v1Tag; 
import org.jaudiotagger.tag.images.Artwork; 
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException; 
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException; 
import org.tritonus.share.sampled.file.TAudioFileFormat; 

import featureamp.util.Util; 

public  class  Mp3Song  implements Song {
	
	private File file;

	
	
	private MP3File mp3File;

	
	
	private ID3v1Tag id3v1;

	
	
	private AbstractID3v2Tag id3v2;

	
	
	private Integer milliseconds;

	
	
	public Mp3Song(File file) throws
	TagException, ReadOnlyFileException, InvalidAudioFrameException, 
	IOException {
		if (specifications.Configuration.mp3) {
			this.file = file;
			
			mp3File = new MP3File(file);
			if(mp3File.hasID3v2Tag()) {
				id3v2 = mp3File.getID3v2Tag();
			}
			
			if(mp3File.hasID3v1Tag()) {
				id3v1 = mp3File.getID3v1Tag();
			}
			
			if(milliseconds == null) {
				AudioFileFormat fileFormat;
				try {
					fileFormat = AudioSystem.getAudioFileFormat(file);
					if (fileFormat instanceof TAudioFileFormat) {
				        Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
				        String key = "duration";
				        Long microseconds = (Long) properties.get(key);
				        milliseconds = (int) (microseconds / 1000);
				    } else {
						System.err.println("[Mp3Song] No information about length in mp3 file " + file.getName());
						milliseconds = 0;
					}
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				}
	}

	

	@Override
	public String getFileName() {
		return file.getName();
	}

	

	@Override
	public String getFilePath() {
		// TODO Auto-generated method stub
		return file.getPath();
	}

	

	@Override
	public String getTitle() {
		if(id3v1 != null)
			return id3v1.getFirstTitle();
		if(id3v2 != null)
			return id3v2.getFirst(FieldKey.TITLE);
		return getFileName();
	}

	

	@Override
	public String getArtist() {
		if(id3v1 != null)
			return id3v1.getFirstArtist();
		if(id3v2 != null)
			return id3v2.getFirst(FieldKey.ARTIST);
		// #endif
		return getFileName();
	}

	

	@Override
	public int getLengthInSeconds() {
		return milliseconds/1000;
	}

	

	@Override
	public String getAlbum() {
		if(id3v1 != null)
			return id3v1.getFirstAlbum();
		if(id3v2 != null)
			return id3v2.getFirst(FieldKey.ALBUM);

		return "";
	}

	
	
	public String toString() {
		return getTitle();
	}

	

	@Override
	public String getDirectory() {
		return file.getParent();
	}

	
	
	@Override
	public String getLength() {
		return Util.secondsToTimeString(getLengthInSeconds());
	}

	

	@Override
	public byte[] getImage() {
		if(id3v2 != null) {
			Artwork aw = id3v2.getFirstArtwork();
			if(aw != null)
				return aw.getBinaryData();
		}
		
		if(id3v1 != null) {
			Artwork aw = id3v1.getFirstArtwork();
			if(aw != null)
				return aw.getBinaryData();
		}
		
		return null;
	}

	

	@Override
	public ImageIcon getImageIcon() {
		byte[] data = getImage();
		if(data == null)
			return null;
		
		ImageIcon image = new ImageIcon(data);
		return new ImageIcon(image.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
	}

	

	@Override
	public Integer getTrackNumber() {
		try {
			if(id3v2 != null)
				return Integer.parseInt(id3v2.getFirst(FieldKey.TRACK));
			if(id3v1 != null)
				return Integer.parseInt(id3v1.getFirstTrack());
		} catch(Exception e) {
			
		}
		return 0;
	}


}
