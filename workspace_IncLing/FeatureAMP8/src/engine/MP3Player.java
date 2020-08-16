package engine; 

import java.io.File; 
import java.io.IOException; 

import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.FloatControl; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

import javazoom.jl.decoder.JavaLayerException; 


/**
 * A simple MP3Player, which is able to play an .mp3-file and pause, resume, and stop the playblack.
 */
public  class  MP3Player {
	
	public final static int STATUS_READY 	= 0;

	
	public final static int STATUS_PLAYING 	= 1;

	
	public final static int STATUS_PAUSED 	= 2;

	
	public final static int STATUS_FINISHED = 3;

	

	private int playerStatus = STATUS_READY;

	
	private AudioInputStream audioStream;

	
	private Clip clip;

	


	/**
	 * Creates a new MP3Player from given InputStream.
	 * @param filename
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 * @throws LineUnavailableException
	 */
	public MP3Player(String filename) throws UnsupportedAudioFileException, IOException, LineUnavailableException 
		{
		if (specifications.Configuration.featureamp) {
			File file = new File(filename);
			
	
		    audioStream = AudioSystem.getAudioInputStream(file); // Obtains an audio input stream of the song
			AudioFormat baseFormat = audioStream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);
			clip = AudioSystem.getClip();
			clip.open(stream);
			
					}
	}

	

	/**
	 * Starts playback (resumes if paused).
	 * @throws JavaLayerException when there is a problem decoding the file.
	 */
	public void play() {
		synchronized (clip) {
			if(clip != null && clip.isOpen()) {
				clip.start();
				playerStatus = STATUS_PLAYING;
			}
		}
	}

	

	/**
	 * Pauses playback.
	 */
	public void pause() {
		synchronized (clip) {
			if (playerStatus == STATUS_PLAYING) {
				clip.stop();
				playerStatus = STATUS_PAUSED;
			}
		}
	}

	

	/**
	 * Resumes playback.
	 */
	public void resume() {
		synchronized (clip) {
			if (playerStatus == STATUS_PAUSED) {
				clip.start();
				playerStatus = STATUS_PLAYING;
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
			playerStatus = STATUS_FINISHED;
		}
	}

	

	/**
	 * Returns the current player status.
	 * @return the player status
	 */
	public int getPlayerStatus() {
		return this.playerStatus;
	}

	
	
	public void setLautstaerke(float control){
		double gain = control / 100;                
		float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(dB);
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
			audioStream.close();
			audioStream = null;
		} catch (IOException e) {
			// we are terminating, thus ignore exception
		}
	}


}
