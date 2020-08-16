package featureamp; 

import java.io.File; 
import java.io.IOException; 
import java.util.Iterator; 
import java.util.Map; 

import javax.sound.sampled.AudioFileFormat; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import javax.swing.ImageIcon; 

import org.jaudiotagger.audio.AudioFile; 
import org.jaudiotagger.audio.AudioFileIO; 
import org.jaudiotagger.audio.AudioHeader; 
import org.jaudiotagger.audio.exceptions.CannotReadException; 
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException; 
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException; 
import org.jaudiotagger.audio.generic.GenericAudioHeader; 
import org.jaudiotagger.audio.wav.WavFileReader; 
//import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey; 
import org.jaudiotagger.tag.Tag; 
import org.jaudiotagger.tag.TagException; 
import org.jaudiotagger.tag.TagField; 
import org.jaudiotagger.tag.id3.AbstractID3v2Tag; 
import org.jaudiotagger.tag.id3.ID3v1Tag; 
import org.jaudiotagger.tag.images.Artwork; 
import org.tritonus.share.sampled.file.TAudioFileFormat; 

import featureamp.util.Util; 

public  class  WavSong  implements Song {
	
	private File file;

	
	
	private Integer milliseconds;

	
	
	public WavSong(File file) throws IOException, CannotReadException, InvalidAudioFrameException, ReadOnlyFileException, TagException {
		if (specifications.Configuration.wav) {
			this.file = file;
			
			AudioFile audioFile = AudioFileIO.read(file);
			GenericAudioHeader audioHeader = (GenericAudioHeader) audioFile.getAudioHeader();
			milliseconds = (int) (audioHeader.getPreciseLength() * 1000);
			//System.out.println("milliseconds=" + milliseconds);
			System.out.println("audioHeader=" + audioHeader.getClass().getName());
	
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
					}
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				}
			}
				}
	}

	

	
	public String getFileName() {
		return file.getName();
	}

	

	public String getFilePath() {
		// TODO Auto-generated method stub
		return file.getPath();
	}

	

	public String getTitle() {
//		if(id3v1 != null)
//			return id3v1.getFirstTitle();
//		if(id3v2 != null)
//			return id3v2.getFirst(FieldKey.TITLE);
		return getFileName();
	}

	

	public String getArtist() {
//		if(id3v1 != null)
//			return id3v1.getFirstArtist();
//		if(id3v2 != null)
//			return id3v2.getFirst(FieldKey.ARTIST);
		return getFileName();
	}

	

	public int getLengthInSeconds() {
		return milliseconds/1000;
	}

	

	public String getAlbum() {
//		if(id3v1 != null)
//			return id3v1.getFirstAlbum();
//		if(id3v2 != null)
//			return id3v2.getFirst(FieldKey.ALBUM);

		return "";
	}

	
	
	public String toString() {
		return getTitle();
	}

	

	public String getDirectory() {
		return file.getParent();
	}

	
	
	public String getLength() {
		return Util.secondsToTimeString(getLengthInSeconds());
	}

	

	public byte[] getImage() {
//		if(id3v2 != null) {
//			Artwork aw = id3v2.getFirstArtwork();
//			if(aw != null)
//				return aw.getBinaryData();
//		}
//		
//		if(id3v1 != null) {
//			Artwork aw = id3v1.getFirstArtwork();
//			if(aw != null)
//				return aw.getBinaryData();
//		}
		
		return null;
	}

	

	public ImageIcon getImageIcon() {
		byte[] data = getImage();
		if(data == null)
			return null;
		
		ImageIcon image = new ImageIcon(data);
		return new ImageIcon(image.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
	}

	

	public Integer getTrackNumber() {
//		if(id3v1 != null)
//			return Integer.parseInt(id3v1.getFirstTitle());
//		if(id3v2 != null)
//			return Integer.parseInt(id3v2.getFirst(FieldKey.TRACK));

		return 0;
	}


}
