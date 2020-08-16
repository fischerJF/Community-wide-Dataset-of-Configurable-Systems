/*if[MP3]*/
package players; 

import java.io.File; 
import java.io.ByteArrayInputStream; 
import java.io.IOException; 
import java.util.Map; 

import java.awt.Image; 

import javax.imageio.ImageIO; 
import javax.sound.sampled.AudioFileFormat; 
import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.FloatControl; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

import org.tritonus.share.sampled.file.TAudioFileFormat; 

import players.Player; 
import players.TrackMetadata; 

import javazoom.jl.decoder.JavaLayerException; 

public  class  OGGPlayer  extends Player {
	
	
	private AudioInputStream audioStream;

	
	private Clip clip;

	
	private TrackMetadata metadata;

	
	private FloatControl volume;

	
	private String filename;

	
	public OGGPlayer(String filename) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (specifications.Configuration.ogg) {
			File file = new File(filename);
			this.filename = filename;
			audioStream = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = audioStream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);
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
			audioStream = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = audioStream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);
			clip = AudioSystem.getClip();
			clip.open(stream);
			metadata.setRuntime(clip.getMicrosecondLength() / 1000000);
			volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				}
	}

	
	
	/**
	 * Starts playback (resumes if paused).
	 * @throws JavaLayerException when there is a problem decoding the file.
	 */
	public void play() {
		synchronized (clip) {
			if(clip != null && clip.isOpen()) {
				if (playerStatus == State.PLAYING && clip.getMicrosecondPosition() == clip.getMicrosecondLength()) {
					clip.stop();
					clip.setFramePosition(0);
					playerStatus = State.READY;
				}
				clip.start();
				playerStatus = State.PLAYING;
			}
		}
	}

	

	/**
	 * Pauses playback.
	 */
	public void pause() {
		synchronized (clip) {
			if (playerStatus == State.PLAYING) {
				clip.stop();
				playerStatus = State.PAUSED;
			}
		}
	}

	

	/**
	 * Resumes playback.
	 */
	public void resume() {
		synchronized (clip) {
			if (playerStatus == State.PAUSED) {
				clip.start();
				playerStatus = State.PLAYING;
			}
		}
	}

	

	/**
	 * Stops playback. If not playing, does nothing.
	 */
	public void stop() {
		synchronized (clip) {
			clip.stop();
			clip.setFramePosition(0);
			playerStatus = State.READY;
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
		clip = null;
		volume = null;
		try {
			audioStream.close();
			audioStream = null;
		} catch (IOException e) {
			// we are terminating, thus ignore exception
		}
	}

	
	
	public void setVolume(int vol) {
		double gain = vol / 100.0f;
		volume.setValue((float)(Math.log(gain) / Math.log(10.0) * 20.0));	
	}

	
	
	public long position() {
		synchronized (clip) {
			long micros = clip.getMicrosecondPosition();
			return micros / 1000000;
		}
	}

	
	
	public TrackMetadata getTrackMetadata()
	{
		if (this.metadata == null) {
			this.metadata = getTrackMetadata(this.filename);
			metadata.setRuntime(clip.getMicrosecondLength() / 1000000);
		}
		return this.metadata;
	}

	
	
	public static TrackMetadata getTrackMetadata(String filename)
	{
		try {
			TrackMetadata metadata = new TrackMetadata();
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
		        metadata.setRuntime(length);
		        metadata.setAlbum(album);
			}
			metadata.setFileName(filename);
			return metadata;
		} catch (Exception e) {
			// keine arme, keine schokolade!
			e.printStackTrace();
			return null;
		}
	}

	
	
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


}
