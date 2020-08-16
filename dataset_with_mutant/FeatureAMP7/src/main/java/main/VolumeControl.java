package main; 

import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.CompoundControl; 
import javax.sound.sampled.Control; 
import javax.sound.sampled.FloatControl; 
import javax.sound.sampled.BooleanControl; 
import javax.sound.sampled.Line; 
import javax.sound.sampled.Mixer; 
import javax.swing.*; 

import main.FeatureAmp; 

import javax.swing.JCheckBox; 
import javax.swing.JLabel; 
import main.MuteChange; 

public   class  VolumeControl  extends JPanel {
	
  // Since JPanel is serializable, we need this
  static final long serialVersionUID = 1;

	
  
  private FloatControl volumeControl;

	
  private BooleanControl muteControl;

	
  
  private boolean logScale;

	

  private JSlider actualScrollBar;

	
  
  private static VolumeControl volumeControlInstance = new VolumeControl();

	
  
  private VolumeControl() {
		if (specifications.Configuration.volumecontrol) {
	    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	    setBackground(FeatureAmp.getBackgroundColor());
	    setForeground(FeatureAmp.getForegroundColor());
	    JLabel label = new JLabel("Lautst\u00e4rke:");
	    label.setForeground(FeatureAmp.getForegroundColor());
	    add(label);
	    actualScrollBar = new JSlider();
	    actualScrollBar.setMinimum(0);
	    actualScrollBar.setMaximum(100);
	    actualScrollBar.setMinorTickSpacing(5);
	    actualScrollBar.setMajorTickSpacing(25);
	    actualScrollBar.setOrientation(JSlider.HORIZONTAL);
	    actualScrollBar.setPaintTicks(false);
	    actualScrollBar.setPaintLabels(false);
	    actualScrollBar.setSnapToTicks(false);
	    actualScrollBar.setBackground(FeatureAmp.getBackgroundColor());
	    actualScrollBar.setForeground(FeatureAmp.getForegroundColor());
	    add(actualScrollBar);
	
	    Control PCMControl = null;
	    Control MasterControl = null;
	    Control SpeakerControl = null;
	    Control WaveControl = null;
	    Control VolumeControl = null;
	    Control MuteControl = null;
	    
	    Mixer.Info[] mixers = AudioSystem.getMixerInfo();
	    for (Mixer.Info mixerInfo : mixers) {
	      Mixer mixer = AudioSystem.getMixer(mixerInfo);
	      Line.Info[] lineinfos = mixer.getTargetLineInfo();
	      for (Line.Info lineinfo : lineinfos) {
	        try {
	          Line line = mixer.getLine(lineinfo);
	          line.open();
	          Control con[] = line.getControls();
	          for (Control checkCont : con) {
	            if (checkCont.toString().substring(0, 3).toUpperCase().equals("PCM")) {
	              PCMControl = checkCont;
	            }
	            if (checkCont.toString().substring(0, 6).toUpperCase().equals("MASTER")) {
	              MasterControl = checkCont;
	            }
	            if (checkCont.toString().substring(0, 7).toUpperCase().equals("SPEAKER")) {
	              SpeakerControl = checkCont;
	            }
	            if (checkCont.toString().substring(0, 4).toUpperCase().equals("WAVE")) {
	              WaveControl = checkCont;
	            }
	            if (checkCont.toString().substring(0, 6).toUpperCase().equals("VOLUME")) {
	              VolumeControl = checkCont;
	            }
	            if (checkCont.toString().substring(0, 4).toUpperCase().equals("MUTE")) {
	              MuteControl = checkCont;
	            }
	          }
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	      }
	    }
	    
	    if (MasterControl != null) {
	      logScale = true;
	      useCompoundControl(MasterControl);
	    } else if (PCMControl != null) {
	      logScale = true;
	      useCompoundControl(PCMControl);
	    } else if (SpeakerControl != null) {
	      logScale = true;
	      useCompoundControl(SpeakerControl);
	    } else if (WaveControl != null) {
	      logScale = false;
	      useCompoundControl(WaveControl);
	    } else if (VolumeControl != null){
	      if (VolumeControl.getType().equals(FloatControl.Type.VOLUME)) {
	        volumeControl = (FloatControl)VolumeControl;
	        int value = (int)(volumeControl.getValue()*100.0);
	        actualScrollBar.setValue(value);
	        actualScrollBar.addChangeListener(new VolumeChange(volumeControl, actualScrollBar, logScale));
	        if (MuteControl.getType().equals(BooleanControl.Type.MUTE)) {
	          muteControl = (BooleanControl)MuteControl;
	          addMuteButton(muteControl);
	        } else {
	          System.out.println("Stummschaltung wird nicht unterst\u00fctzt!");
	        }
	      } else {
	    	System.out.println("Kein passender Lautst\u00e4rke-Regler gefunden!");
	      }
	    } else {
	      System.out.println("Kein passender Lautst\u00e4rke-Regler gefunden!");
	    }
	 /*else if (VolumeControl != null) {
	      volumeControl = volumeControl;
	    }*/
	    
	    addMuteControls(getVolume());
	  		}
	}

	
  
   private void  addMuteControls__wrappee__VolumeControl  (int oldVolume) {
  }

	
  public void addMuteControls(int currentVolume) {
		if (!specifications.Configuration.mute) {
			addMuteControls__wrappee__VolumeControl(currentVolume);
			return;
		}
    JCheckBox checkbox = new JCheckBox(); // Show a checkbox for switches
    checkbox.setBackground(FeatureAmp.getBackgroundColor());
    checkbox.setForeground(FeatureAmp.getForegroundColor());
    JLabel label = new JLabel("Stumm:");
    label.setForeground(FeatureAmp.getForegroundColor());
    checkbox.addActionListener(new MuteChange(checkbox, currentVolume));

    checkbox.setSelected(getMuteControl().getValue());

    addComponent(label);
    addComponent(checkbox);
  }

	
  
  private void useCompoundControl(Control useCont) {
    if (useCont != null) {
      if( useCont instanceof CompoundControl) {
        CompoundControl tmpCont = (CompoundControl)useCont;
        Control con2[] = tmpCont.getMemberControls();
        for (Control newCont : con2) {
          if (newCont.getType().equals(BooleanControl.Type.MUTE)) {
            muteControl = (BooleanControl)newCont;
            addMuteButton(muteControl);
          }
          if (newCont.getType().equals(FloatControl.Type.VOLUME)) {
            volumeControl = (FloatControl)newCont;
            int value;
            if (logScale) {
              value = (int) (Math.exp( ( (double)volumeControl.getValue()) * 2.0 * (Math.log(2.0)+Math.log(5.0)) ) );
            } else {
              value = (int)(volumeControl.getValue()*100.0);
            }
            actualScrollBar.setValue(value);
            actualScrollBar.addChangeListener(new VolumeChange(volumeControl, actualScrollBar, logScale));
          }
        }
      }
    }
  }

	
  
  private void addMuteButton(BooleanControl muteControl) {
  }

	
  
  public void addComponent(JComponent newComponent) {
    add(newComponent);
  }

	
  
  public int getVolume() {
    return actualScrollBar.getValue();
  }

	
  
  public void setVolume(int newVolume) {
    actualScrollBar.setValue(newVolume);
  }

	
  
  public BooleanControl getMuteControl() {
    return muteControl;
  }

	
  
  public static VolumeControl getInstance() {
    return volumeControlInstance;
  }


}
