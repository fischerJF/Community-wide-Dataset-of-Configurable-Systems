package featureamp; 

import java.io.File; 
import java.io.IOException; 
import java.io.RandomAccessFile; 
import java.util.Map; 

import javax.sound.sampled.AudioFileFormat; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import javax.swing.ImageIcon; 

import org.jaudiotagger.audio.mp3.MP3File; 
import org.jaudiotagger.audio.ogg.OggVorbisTagReader; 
import org.jaudiotagger.tag.FieldKey; 
import org.jaudiotagger.tag.Tag; 
import org.jaudiotagger.tag.TagException; 
import org.jaudiotagger.tag.id3.AbstractID3v2Tag; 
import org.jaudiotagger.tag.id3.ID3v1Tag; 
import org.jaudiotagger.tag.images.Artwork; 
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentFieldKey; 
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag; 
import org.jaudiotagger.audio.exceptions.CannotReadException; 
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException; 
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException; 
import org.tritonus.share.sampled.file.TAudioFileFormat; 

import featureamp.util.Util; 

public  class  OggSong  implements Song {
	
	private File file;

	
	
	//private MP3File mp3File;
	
	private VorbisCommentTag tag;

	
	
	private Integer milliseconds;

	
	
	public OggSong(File file) throws
	TagException, ReadOnlyFileException, InvalidAudioFrameException, 
	IOException, CannotReadException {
		if (specifications.Configuration.ogg) {
			this.file = file;
			
			OggVorbisTagReader reader = new OggVorbisTagReader();
			tag = (VorbisCommentTag) reader.read(new RandomAccessFile(file, "r"));
			/*
			mp3File = new MP3File(file);
			if(mp3File.hasID3v2Tag()) {
				id3v2 = mp3File.getID3v2Tag();
			}
			
			if(mp3File.hasID3v1Tag()) {
				id3v1 = mp3File.getID3v1Tag();
			}
			*/
			
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
		if(tag != null)
			return tag.getFirst(VorbisCommentFieldKey.TITLE);
		return getFileName();
	}

	

	@Override
	public String getArtist() {
		if(tag != null)
			return tag.getFirst(VorbisCommentFieldKey.ARTIST);
		return getFileName();
	}

	

	@Override
	public int getLengthInSeconds() {
		return milliseconds/1000;
	}

	

	@Override
	public String getAlbum() {
		if(tag != null)
			return tag.getFirst(VorbisCommentFieldKey.ALBUM);

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
		if(tag != null)
			return tag.getArtworkBinaryData();
		
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
		if(tag != null) {
			String track = tag.getFirst(VorbisCommentFieldKey.TRACKNUMBER);
			if(track != null && !track.equals(""))
				return Integer.parseInt(track);
		}

		return 0;
	}


}
