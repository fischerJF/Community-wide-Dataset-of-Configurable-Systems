package engine; 

import java.io.File; import java.io.IOException; 

import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; import javax.sound.sampled.BooleanControl; 
import javax.sound.sampled.Clip; 

import javax.sound.sampled.FloatControl; 
import javax.sound.sampled.LineEvent; 
import javax.sound.sampled.LineListener; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

import javazoom.jl.decoder.JavaLayerException; 

public   class  Playback {
	
	public final static int STATUS_READY 	= 0;

	
	public final static int STATUS_PLAYING 	= 1;

	
	public final static int STATUS_PAUSED 	= 2;

	
	public final static int STATUS_FINISHED = 3;

	

	private volatile int playerStatus = STATUS_READY;

	
	private AudioInputStream audioStream;

	
	private Clip clip;

	
	
	private AudioFile audioFile;

	
	private UpdateHandler updateHandler;

	
	
	public Playback  (AudioFile audioFile, UpdateHandler handler) 
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (specifications.Configuration.base) {
			this.audioFile = audioFile;
			this.updateHandler = handler;
			audioStream = AudioSystem.getAudioInputStream(audioFile.getFile());
			AudioFormat baseFormat = audioStream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);
			clip = AudioSystem.getClip();
			clip.addLineListener(new Listener());
			clip.open(stream);
				}
	
		if (specifications.Configuration.volumecontrol) {
			masterVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				}
	
		if (specifications.Configuration.mute) {
			muteControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
				}
	}

	
	
	private  class  Listener  implements LineListener {
		
		@Override
		public void update(LineEvent event) {
			int status = -1;
			synchronized(clip) {
				LineEvent.Type type = event.getType();
				if(type == LineEvent.Type.STOP && playerStatus == STATUS_PLAYING) {
					clip.setFramePosition(0);
					playerStatus = status = STATUS_FINISHED;	
				}	
			};
			
			if(status == STATUS_FINISHED)
				updateHandler.update();
		}


	}

	
	
	public  interface  UpdateHandler {
		
		public void update();


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
		updateHandler.update();
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
		updateHandler.update();
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
		updateHandler.update();
	}

	

	/**
	 * Returns the current player status.
	 * @return the player status
	 */
	public int getPlayerStatus() {
		return this.playerStatus;
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
		
		playerStatus = STATUS_FINISHED;
		updateHandler.update();
	}

	
	
	
	/**
	 * 
	 * @return current playback position (seconds)
	 */
	public int getPosition() {
		synchronized(clip) {
			if(clip.isOpen())
				return (int) (clip.getMicrosecondPosition() / (1000 * 1000));
			return 0;
		}
	}

	
	
	public AudioFile getAudioFile() {
		return audioFile;
	}

	
	private FloatControl masterVolume;

	
	
	public int getVolume() {
		return (int) (Math.pow(10.0, masterVolume.getValue()/20.0) * 100); 
	}

	
	
	public void setVolume(int volume) {
		float value = (float) (20 * Math.log10(volume / 100d));
		masterVolume.setValue(value);
	}

	
	private BooleanControl muteControl;

	
	
	public boolean isMuted() {
		return muteControl.getValue();
	}

	
	
	public void setMute(boolean value) {
		muteControl.setValue(value);
	}


}
