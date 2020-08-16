package main; 

import javax.swing.event.*; 
import javax.swing.*; 
import javax.sound.sampled.FloatControl; 
import java.lang.Math; 

public  class  VolumeChange  implements ChangeListener {
	
  private FloatControl control;

	
  private JSlider slider;

	
  private boolean logScale;

	
  
  public VolumeChange (FloatControl controlIn, JSlider sliderIn, boolean logScaleIn){
		if (specifications.Configuration.volumecontrol) {
	    control = controlIn;
	    slider = sliderIn;
	    logScale = logScaleIn;
	  		}
	}

	
  
  public void stateChanged(ChangeEvent e) {
    float setValue;
    if (logScale) {
    	setValue = (float)( ( (50.0 * Math.log((double)slider.getValue())) / (Math.log(2.0)+Math.log(5.0)) )/100.0);
    } else {
      setValue = (float)(slider.getValue()/100.0);
    }
    control.setValue(setValue);
  }


}
