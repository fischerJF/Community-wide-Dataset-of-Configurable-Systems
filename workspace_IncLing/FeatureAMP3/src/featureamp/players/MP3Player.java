package featureamp.players; 

import java.io.File; 
import java.io.IOException; 

import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

import javazoom.jl.decoder.JavaLayerException; 

public  class  MP3Player  extends CommonPlayer {
	
	/**
	 * Creates a new MP3Player from given InputStream.
	 * 
	 * @param filename
	 * 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 * @throws LineUnavailableException
	 */
	public MP3Player(String filename) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (specifications.Configuration.base) {
			File file = new File(filename);
	
			audioStream = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = audioStream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);
			clip = AudioSystem.getClip();
			clip.open(stream);
				}
	}

	

	/**
	 * Closes the player, regardless of current state.
	 */
	public void close() {
		synchronized(clip) {
			if(clip != null && clip.isOpen()) {
				clip.stop();
				clip.close();
			}
		}
		try {
			audioStream.close();
			audioStream = null;
		} catch (IOException e) {
			e.printStackTrace();
			// we are terminating, thus ignore exception
		}
	}

	
	
	/**
	 * Starts playback (resumes if paused).
	 * @throws JavaLayerException when there is a problem decoding the file.
	 */
	
	@Override
	public void play() {
		synchronized (clip) {
			if(clip != null && clip.isOpen()) {
				clip.start();
				playerStatus = Status.PLAYING;
			} else {
				System.err.println("[Mp3Player.play] Error while playing clip.");
			}
		}
	}

	

	@Override
	public void stop() {
		synchronized (clip) {
			clip.stop();
			clip.setFramePosition(0);
			playerStatus = Status.STOPPED;
		}
	}

	

	@Override
	public void pause() {
		synchronized (clip) {
			if (playerStatus == Status.PLAYING) {
				clip.stop();
				playerStatus = Status.PAUSED;
			}
		}
	}

	
	
	/**
	 * Resumes playback.
	 */
	public void resume() {
		synchronized (clip) {
			if (playerStatus == Status.PAUSED) {
				clip.start();
				playerStatus = Status.PLAYING;
			}
		}
	}

	

	@Override
	public void seek(int position) {
		clip.setMicrosecondPosition(position);
	}


}
