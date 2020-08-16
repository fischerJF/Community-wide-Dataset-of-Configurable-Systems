package featureAMP;
import java.io.File; 
import java.io.IOException; 

import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.FloatControl; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

public  class  OggController  extends AbstractAudioController {
	

	private OggMetaFile oggMetaFile;

	
	
	private int playerStatus = STATUS_READY;

	
	private AudioInputStream audioStream;

	
	private Clip clip;

	
	
	public OggController(OggMetaFile oggMetaFile) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		if (specifications.Configuration.ogg) {
			
			this.oggMetaFile = oggMetaFile;
			
			File file = new File(this.oggMetaFile.getFilename());
	
			audioStream = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = audioStream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);
			clip = AudioSystem.getClip();
			clip.open(stream);
			
				}
	}

	
	
	@Override
	public AudioFile getAudioFile() {
		return this.oggMetaFile;
	}

	

	@Override
	public int getStatus() {
		return this.playerStatus;
	}

	

	@Override
	public void play() {
		synchronized (this.clip) {
			if (this.clip != null && this.clip.isOpen()) {
				this.clip.start();
				this.playerStatus = STATUS_PLAYING;
			}
		}
		this.timer.start();
		this.notifyPlayListeners();
	}

	

	@Override
	public void pause() {
		synchronized (this.clip) {
			if (this.playerStatus == STATUS_PLAYING) {
				this.clip.stop();
				this.playerStatus = STATUS_PAUSED;
			}
		}
		this.timer.stop();
		this.notifyPauseListeners();
	}

	

	@Override
	public void resume() {
		synchronized (this.clip) {
			if (this.playerStatus == STATUS_PAUSED) {
				this.clip.start();
				this.playerStatus = STATUS_PLAYING;
			}
		}
		this.timer.start();
		this.notifyResumeListeners();
	}

	

	@Override
	public void stop() {
		synchronized (this.clip) {
			this.clip.stop();
			this.clip.setFramePosition(0);
			this.playerStatus = STATUS_READY;
		}
		this.timer.stop();
		this.currentSec = 0;
		this.notifyTimeListeners();
		this.notifyStopListeners();
	}

	
	
	@Override 
	public void setVolume(int percent) {
		synchronized (this.clip) {
			FloatControl volumeCtrl = (FloatControl) this.clip.getControl(
					FloatControl.Type.MASTER_GAIN);
			float value = 0.0f;
			if (percent > 0)
				value = 0.5f * (1.0f * percent - 100.0f);
			else
				value = -79.0f;
			volumeCtrl.setValue(value);
		}
	}


}
