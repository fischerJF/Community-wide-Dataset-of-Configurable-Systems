package featureAmp.view; 

import javax.sound.sampled.FloatControl; 
import javax.swing.JSlider; 
import javax.swing.SwingConstants; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener; 

public  class  VolumeSlider  extends JSlider {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private FloatControl volumeControl;

	

	public VolumeSlider(){
//		if (specifications.Configuration.volumecontrol) {
			super(SwingConstants.HORIZONTAL, 0,100,80);
			setPaintTicks(true);
			setPaintLabels(true);
			setPaintTrack(true);
			addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					if (volumeControl != null) {
						float newVolume = getNewVolume();
						volumeControl.setValue(newVolume);
					}
					setToolTipText(String.valueOf(getValue()));
				}
			});
//				}
	}

	

	public FloatControl getVolumeControl() {
		return volumeControl;
	}

	

	public void setVolumeControl(FloatControl volumeControl) {
		this.volumeControl = volumeControl;
		this.volumeControl.setValue(getNewVolume());
	}

	
	
	private float getNewVolume(){
		return (volumeControl.getMaximum() - Math.abs(volumeControl.getMinimum())) * (100-getValue()) / 100;
	}


}
