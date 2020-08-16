package player; 

import java.io.File;  
import java.io.IOException;  
import java.util.Map; 


import javax.sound.sampled.AudioFileFormat; 
import javax.sound.sampled.AudioFormat;  
import javax.sound.sampled.AudioInputStream;  
import javax.sound.sampled.AudioSystem;  
import javax.sound.sampled.Clip;  
import javax.sound.sampled.FloatControl;  
import javax.sound.sampled.LineUnavailableException;  
import javax.sound.sampled.UnsupportedAudioFileException;  

import org.tritonus.share.sampled.file.TAudioFileFormat; 

import player.PlayerFileFilter;  

public  class  OGGPlayer  extends Player {
	

	private AudioInputStream stream;

	
	private String filename;

	
	private Clip clip;

	
	private int playerStatus;

	
	private TrackMetadata metadata;

	
	private FloatControl volume;

	

	public OGGPlayer(String filename) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (specifications.Configuration.ogg) {
			File file = new File(filename);
			this.filename = filename;
			stream = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = stream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, this.stream);
			clip = AudioSystem.getClip();
			clip.open(stream);
			volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				}
	}

	

	public OGGPlayer(TrackMetadata track)  throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (specifications.Configuration.ogg) {
			this.filename = track.getFileName();
			File file = new File(track.getFileName());
			this.metadata = track;
			stream = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = stream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, this.stream);
			clip = AudioSystem.getClip();
			clip.open(stream);
			metadata.setLength(clip.getMicrosecondLength() / 1000000);
			volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				}
	}

	


	@Override
	public void play() {
		synchronized (clip) {
			if (clip != null && clip.isOpen()) {
				if (playerStatus == STATUS_PLAYING && clip.getMicrosecondPosition() == clip.getMicrosecondLength()) {
					clip.stop();
					clip.setFramePosition(0);
					playerStatus = STATUS_READY;
				}
				clip.start();
				playerStatus = STATUS_PLAYING;
			}
		}
	}

	

	@Override
	public void pause() {
		synchronized (clip) {
			if (playerStatus == STATUS_PLAYING) {
				clip.stop();
				playerStatus = STATUS_PAUSED;
			}
		}
	}

	

	@Override
	public void resume() {
		synchronized (clip) {
			if (playerStatus == STATUS_PAUSED) {
				clip.start();
				playerStatus = STATUS_PLAYING;
			}
		}
	}

	

	@Override
	public void stop() {
		synchronized (clip) {
			clip.stop();
			clip.setFramePosition(0);
			playerStatus = STATUS_FINISHED;
		}
	}

	
	
	/**
	 * Closes the player, regardless of current state.
	 */
	public void close() {
		synchronized (clip) {
			if(clip != null && clip.isOpen()) {
				clip.stop();
				clip.close();
			}
		}
		try {
			stream.close();
			stream = null;
		} catch (IOException e) {
			// we are terminating, thus ignore exception
		}
	}

	
	
	// aktuelle Position abfragen
	public long getPosition() {
		synchronized (clip) {
			long micros = clip.getMicrosecondPosition();
			return micros / 1000000;
		}
	}

	
	
	// Filefilter um OGG Dateien nur zu wählen
	public static PlayerFileFilter getFileFilter()
	{
		return new PlayerFileFilter() {
			public Class<? extends Player> getParentClass()
			{
				return OGGPlayer.class;
			}
			
			public String getDescription()
			{
				return "OGG Files";
			}
			
			public boolean accept(File f)
			{
				if (f == null) {
					return false;
				}
				if (f.isDirectory()) {
					return true;
				}
				String ext = Player.getExtension(f);
				if (ext == null) {
					return false;
				}
				return ext.equals("ogg");
			}
		};
	}

	
	
	// brauch ich momentan nicht, weiß nicht mehr genau warum eigentlich geschrieben 
//	public String getTimer() {
//		long currentPosition = clip.getMicrosecondPosition() / 1000 / 1000;
//		return (currentPosition / 60) + ":"
//				+ ((currentPosition % 60) < 10 ? "0" : "")
//				+ (currentPosition % 60);
//	}
	
	// setzt die Lautstärke
	public void setVolume(int vol) {
		double gain = vol / 100.0f;
		volume.setValue((float)(Math.log(gain) / Math.log(10.0) * 20.0));	
	}

	
	
	// ruft die Metadaten für den Track ab
	public TrackMetadata getTrackMetadata()
	{
		if (this.metadata == null) {
			this.metadata = getTrackMetadata(this.filename);
			metadata.setLength(clip.getMicrosecondLength() / 1000000);
		}
		return this.metadata;
	}

	
	
	// baut die Metadata für einen File zusammen
	public static TrackMetadata getTrackMetadata(String filename)
	{
		TrackMetadata metadata = new TrackMetadata();
		 try
		  {
		    File file = new File(filename);
		    // Get AudioFileFormat from given file.	
		    AudioFileFormat baseFileFormat = AudioSystem.getAudioFileFormat(file);
		    if (baseFileFormat instanceof TAudioFileFormat)
		    {
		    	Map props = ((TAudioFileFormat)baseFileFormat).properties();
		        // Length in seconds
		        long length = (long) Math.round((((Long)props.get("duration")).longValue())/1000000);
		        // Title of song (comment)
		        String title = (String)props.get("title");
		        // Artist of song (comment)
		        String artist = (String)props.get("author");
		        // album of song (comment)
		        String album = (String)props.get("album");
		        
		        // and so on ... check Javadoc or readme.txt for all properties (around 20)
		        metadata.setTitle(title);
		        metadata.setArtist(artist);
		        metadata.setLength(length);
		        metadata.setAlbum(album);
		    }}
		    catch (Exception e)
		    {
		        e.printStackTrace();
		    }
		 	metadata.setFileName(filename);
			return metadata;
		
	}

	

	@Override
	public int playerStatus() {
		return this.playerStatus;
	}


}
