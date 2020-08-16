package featureamp.players; 

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.BooleanControl; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.FloatControl; 

abstract public  class  CommonPlayer  implements Player {
	
	Status playerStatus = Status.READY;

	
	AudioInputStream audioStream;

	
	Clip clip;

	
	
	public long getPosition() {
		return clip.getMicrosecondPosition();
	}

	
	
	public long getLength() {
		return clip.getMicrosecondLength();
	}

	
	
	public Status getPlayerStatus() {
		//FloatControl volumeControl = getVolumeControl();
		return this.playerStatus;
	}

	
	
	public float getLevel() {
		return clip.getLevel();
	}

	
	
	public void mute() {
		if(!isMuted()) {
			getMuteControl().setValue(true);
		}
	}

	
	
	public void unmute() {
		if(isMuted()) {
			getMuteControl().setValue(false);
		}
	}

	
	
	public boolean isMuted() {
		return getMuteControl().getValue();
	}

	
	
	/**
	 * Sets Volume
	 * 
	 * @param vol Range from [0..1] 
	 */
    
	public void setVolume(float vol) {
		// http://www.dr-lex.be/info-stuff/volumecontrols.html
		FloatControl volumeControl = getVolumeControl();
		double b = Math.log(Math.pow(10, (volumeControl.getMaximum() - volumeControl.getMinimum())/20));
		double a = 1/b;
		double y = a * Math.exp(b*vol-volumeControl.getMaximum()-1.0);
		double db = (20 * Math.log10(y));
		if(db < volumeControl.getMinimum()) {
			db = volumeControl.getMinimum();
		} else if(db > volumeControl.getMaximum()) {
			db = volumeControl.getMaximum();
		}
		volumeControl.setValue((float) db);
	}

	
	
	public float getVolume() {
		FloatControl volumeControl = getVolumeControl();
		return volumeControl.getValue();
	}

	
	
	public FloatControl getVolumeControl() {
		return (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	}

	
	
	public BooleanControl getMuteControl() {
		return (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
	}


}
