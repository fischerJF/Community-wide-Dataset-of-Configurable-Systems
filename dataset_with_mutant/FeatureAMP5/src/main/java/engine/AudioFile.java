package engine; 

import java.io.File; 
import java.io.IOException; 

import com.mpatric.mp3agic.ID3v1; 
import com.mpatric.mp3agic.ID3v2; 
import com.mpatric.mp3agic.InvalidDataException; 
import com.mpatric.mp3agic.Mp3File; 
import com.mpatric.mp3agic.UnsupportedTagException; import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.UnsupportedAudioFileException; 

public final   class  AudioFile {
	
	private final MetaData metaData;

	
	private final File file;

	
	
	public AudioFile(File file) {
//		if (FM.FeatureModel.base) {
			this.file = file;
			this.metaData = readMetaData();
//				}
	}

	

	 private MetaData  readMetaData__wrappee__Base  () {
		return new MetaData("Unknown", removeExtension(file.getName()), 0);
	}

	
	 private MetaData  readMetaData__wrappee__MP3  () {
		if (!specifications.Configuration.mp3)
			return readMetaData__wrappee__Base();
		if(!getExtension(file.getPath()).equals("mp3"))
			return readMetaData__wrappee__Base();
		
		try {
			Mp3File mp3File = new Mp3File(file.getPath());
			
			ID3v1 tag;
			
			ID3v2 tagV2 = mp3File.getId3v2Tag();
			if(tagV2 != null) {
				tag = tagV2;
			}
			else {
				tag = mp3File.getId3v2Tag();
			}
			if(tag != null) {
				return createMetaData(tag, mp3File);
			}
			else {
				return new MetaData("Unknown", removeExtension(file.getName()),
						(int) mp3File.getLengthInSeconds());
			}	
		}
		catch(IOException e) {
			return readMetaData__wrappee__Base();
		}
		catch(InvalidDataException e) {
			return readMetaData__wrappee__Base();
		}
		catch(UnsupportedTagException e) {
			return readMetaData__wrappee__Base();
		}
	}

	
	private MetaData readMetaData() {
		if (!specifications.Configuration.wave)
			return readMetaData__wrappee__MP3();
		if(!getExtension(file.getPath()).equals("wav"))
			return readMetaData__wrappee__MP3();
		
		AudioInputStream stream = null;
		
		// from http://stackoverflow.com/questions/3009908/
		try {
		    stream = AudioSystem.getAudioInputStream(file);
		    AudioFormat format = stream.getFormat();
		    long length = file.length();
		    int frameSize = format.getFrameSize();
		    float rate = format.getFrameRate();
		    int duration = (int) (length / (frameSize * rate));
		    return new MetaData("Unknown", removeExtension(file.getName()), duration);
		}
		catch(UnsupportedAudioFileException e) {
			return readMetaData__wrappee__MP3();
		}
		catch(IOException e) {
			return readMetaData__wrappee__MP3();
		}
		finally {
			if(stream != null) {
				try {
					stream.close();
				}
				catch(Exception e) {
					// ignore
				}
			}
		}
	}

	
	
	private static String removeExtension(String filename) {
		int index = filename.lastIndexOf('.');
		return index < 0 ? filename : filename.substring(0, index);
	}

	
	
	public File getFile() {
		return file;
	}

	
	
	public MetaData getMetaData() {
		return metaData;
	}

	
	
	public static String getExtension(String filename) {
		int index = filename.lastIndexOf('.');
		if(index < 0)
			return "";
		return filename.substring(index + 1).toLowerCase();
	}

	
	
	 private MetaData  createMetaData__wrappee__MP3  (ID3v1 tag, Mp3File mp3File) {
		int track = 0;
		try {
			if(tag.getTrack() != null)
				track = Integer.parseInt(tag.getTrack().trim());
		}
		catch(NumberFormatException e) {
			// ignore
		}
		
		
		return new MetaData(tag.getArtist(), tag.getTitle(),(int) mp3File.getLengthInSeconds(), tag.getAlbum(), track);
		
	}

	
	private MetaData createMetaData(ID3v1 tag, Mp3File mp3File) {
		if (!specifications.Configuration.showcover)
			return createMetaData__wrappee__MP3(tag, mp3File);
		MetaData data = createMetaData__wrappee__MP3(tag, mp3File);
		
		if(tag instanceof ID3v2)
			data.setImage(((ID3v2) tag).getAlbumImage());
		return data;
	}


}
