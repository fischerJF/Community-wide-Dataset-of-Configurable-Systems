package featureamp.playback; 

import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 

import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineEvent; 
import javax.sound.sampled.LineListener; 

import featureamp.playback.Track; 

import javax.sound.sampled.FloatControl; 

/**
 * TODO description
 */
public   class  Player  implements LineListener {
	

	private static Player instance;

	

	private State state;

	

	private Clip clip  ;

	
	private Track track;

	

	public static Player getInstance() {
		// Base
		return instance = instance == null ? new Player() : instance;
	}

	

	public static String formatTime(int val) {
		// Base
		int sec = val / 1000;
		int minutes = sec / 60;
		int hours = minutes / 60;
		int seconds = sec % 60;
		return (hours > 0 ? hours + ":" + (minutes < 10 ? "0" : "") : "")
				+ minutes + ":" + (seconds < 10 ? "0" : "") + seconds + " "
				+ (hours > 0 ? "h" : "min");
	}

	
	
	public void addLineListener(LineListener l) {
		// Base
		clip.addLineListener(l);
	}

	

	private Player() {
		if (specifications.Configuration.base) {
			// Base
			try {
				clip = AudioSystem.getClip();
				clip.addLineListener(this);
				state = State.empty;
			} catch (Exception e) {
				state = State.error;
			}
				}
	}

	

	public void load(Track t) {
		// Base

		// preventing unnecessary exceptions
		if (state == State.error) {
			return;
		}

		// closing old track
		close();

		// loading new track
		track = t;
		try {
			openClip(t);
			state = State.ready;
		} catch (Exception e) {
			state = State.error;
		}
	}

	

	private void openClip(Track t) throws Exception {
		// Base

		// creating audio input stream
		AudioInputStream in = AudioSystem.getAudioInputStream(t.getFile());

		// open clip with input stream and output format
		clip.open(AudioSystem.getAudioInputStream(getOutputFormat(in), in));
	}

	

	private AudioFormat getOutputFormat(AudioInputStream input) {
		// Base

		// creating audio output format
		return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, input
				.getFormat().getSampleRate(), 16, input.getFormat()
				.getChannels(), input.getFormat().getChannels() * 2, input
				.getFormat().getSampleRate(), false);
	}

	

	private boolean ready() {
		// Base
		return state != State.empty && state != State.error;
	}

	

	public Track currentTrack() {
		// Base
		return track;
	}

	

	public State state() {
		// Base
		return state;
	}

	

	public void play() {
		// Base
		synchronized (clip) {
			if (ready()) {
				clip.start();
				state = State.playing;
			}
		}
	}

	

	public void pause() {
		// Base
		synchronized (clip) {
			if (state == State.playing) {
				clip.stop();
				state = State.paused;
			}
		}
	}

	

	public void resume() {
		// Base
		play();
	}

	

	public void stop() {
		// Base
		synchronized (clip) {
			if (ready()) {
				clip.stop();
				clip.setFramePosition(0);
				state = State.stopped;
			}
		}
	}

	

	private void close() {
		// Base
		synchronized (clip) {
			if (clip.isOpen()) {
				clip.stop();
				clip.close();
			}
		}
	}

	

	public void removeTrack() {
		// Base
		close();
		track = null;
		state = State.empty;
	}

	

	@Override
	public void update(LineEvent e) {
		// Base
		if (finished()) {
			stop();
			state = State.finished;
		}
	}

	

	private boolean finished() {
		// Base
		int length = getTrackLength();
		int pos = getTrackPosition();
		return pos == length;
	}

	

	public int getTrackLength() {
		// Base
		return (int) clip.getMicrosecondLength() / 1000;
	}

	

	public int getTrackPosition() {
		// Base
		return (int) clip.getMicrosecondPosition() / 1000;
	}

	

	public enum  State {
		// Base
		error ,  empty ,  ready ,  playing ,  paused ,  stopped ,  finished;}

	
	
	public static FloatControl getVolumeControl() {
		// Volume
		if (instance.ready()) {
			return (FloatControl) instance.clip
					.getControl(FloatControl.Type.MASTER_GAIN);
		}
		return null;
	}

	

	public void jumpTo(int miliseconds) {
		// JumpPosition
		synchronized (clip) {
			float percent = ((float) miliseconds)
					/ ((float) clip.getMicrosecondLength() / 1000f);
			int newFrame = (int)((float)clip.getFrameLength() * percent);
			clip.setFramePosition(newFrame);
		}
	}


}
