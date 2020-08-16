package main; 

import java.awt.event.*; 
import javax.swing.*; 

import main.VolumeControl; 
 
 /**
  * This class is an ActionListener for a JCheckBox and
  * writes the checkbox value to the device
  *
  * @author Arne Kreddig
  */
 public  class  MuteChange  implements ActionListener {
	
   /**
    * The checkbox to with this listener is connected to
    */
   private JCheckBox checkbox;

	
   
   private int oldVolume;

	
 
   /**
    * The constructor just sets the private variables
    *
    * @author Arne Kreddig
    * @param address The device address which the value should be written to
    * @param checkboxIn The checkbox to be controled
    */
   public MuteChange(JCheckBox checkboxIn, int currentVolume) {
		if (specifications.Configuration.mute) {
	     checkbox = checkboxIn;
	     oldVolume = currentVolume;
	   		}
	}

	
 
   /**
    * The method that is called on checking/unchecking
    * It evaluates the checbkbox and writes the new value to the device
    *
    * @author Arne Kreddig
    * @param e The ActionEvent that was triggered
    */
   public void actionPerformed(ActionEvent e) {
     VolumeControl.getInstance().getMuteControl().setValue(checkbox.isSelected());
     setMute(checkbox.isSelected());
   }

	
   
   private void setMute(boolean mute) {
     if (mute == true) {
       oldVolume = VolumeControl.getInstance().getVolume();
       VolumeControl.getInstance().setVolume(0);
     } else {
       VolumeControl.getInstance().setVolume(oldVolume);
     }
   }


}
