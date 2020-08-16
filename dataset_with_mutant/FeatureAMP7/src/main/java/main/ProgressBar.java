package main; 

import javax.swing.*; 

import main.FeatureAmp; 
import main.Utils; 

public  class  ProgressBar  extends JPanel {
	
  // Since JPanel is serializable, we need this
  static final long serialVersionUID = 1;

	
  
  private long currentDuration;

	
  
  JProgressBar actualProgBar;

	
  
  private long currentTime;

	
  
  public ProgressBar() {
		if (specifications.Configuration.progressbar) {
	    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    actualProgBar = new JProgressBar();
	    actualProgBar.setMinimum(0);
	    actualProgBar.setValue(0);
	    actualProgBar.setString("0:00 / 0:00");
	    actualProgBar.setStringPainted(true);
	    actualProgBar.setIndeterminate(false);
	    
	    actualProgBar.setUI(new OwnUI());
	    //UIManager.put("ProgressBar.foreground", FeatureAmp.getForegroundColor());
	    
	    actualProgBar.setBackground(FeatureAmp.getBackgroundColor());
	    actualProgBar.setForeground(FeatureAmp.getForegroundColor());
	    
	    currentTime = 0;
	    
	    add(actualProgBar);
	  		}
	}

	
  
  public void setDuration(long duration) {
    currentDuration = duration;

    actualProgBar.setMaximum((int)(currentDuration*1000));
    redraw();
  }

	
  
  public void updateTime(long time) {
    currentTime = time;
    redraw();
  }

	
  
  private void redraw() {
    actualProgBar.setValue((int)currentTime);
    actualProgBar.setString(Utils.timeToString(currentTime/1000) + " / " + Utils.timeToString(currentDuration));    
  }


}
