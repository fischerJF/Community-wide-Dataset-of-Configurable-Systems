package main; 

import javax.swing.*; 
import java.awt.Dimension; 
import java.awt.event.ActionListener; 

import javax.swing.JButton; 

import java.awt.event.*; 

public   class  Buttons  extends JPanel {
	
  // Since JPanel is serializable, we need this
  static final long serialVersionUID = 1;

	
  
  private JButton stopButton = new JButton("Stop");

	
  private JButton startButton = new JButton("Start");

	
  private JButton pauseButton = new JButton("Pause");

	
  
  public static Buttons buttonsInstance = new Buttons();

	
  
  /**
   * Create a layout and the buttons
   */
  private Buttons() {
		if (specifications.Configuration.gui) {
	    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	    stopButton.setMinimumSize(new Dimension(100, 20));
	    stopButton.setMaximumSize(new Dimension(20000, 40));
	    stopButton.setBackground(FeatureAmp.getBackgroundColor());
	    stopButton.setForeground(FeatureAmp.getForegroundColor());
	    stopButton.setName("stop");
	    startButton.setMinimumSize(new Dimension(100, 20));
	    startButton.setMaximumSize(new Dimension(20000, 40));
	    startButton.setBackground(FeatureAmp.getBackgroundColor());
	    startButton.setForeground(FeatureAmp.getForegroundColor());
	    startButton.setName("start");
	    pauseButton.setMinimumSize(new Dimension(100, 20));
	    pauseButton.setMaximumSize(new Dimension(20000, 40));
	    pauseButton.setBackground(FeatureAmp.getBackgroundColor());
	    pauseButton.setForeground(FeatureAmp.getForegroundColor());
	    add(stopButton);
	    add(startButton);
	    add(pauseButton);
	    
	    addSkipButton();
	  		}
	}

	
  
   private void  addSkipButton__wrappee__GUI  () {
  }

	

  public void addSkipButton() {
		if (!specifications.Configuration.skiptrack) {
			addSkipButton__wrappee__GUI();
			return;
		}
    skipButton.setMinimumSize(new Dimension(100, 20));
    skipButton.setMaximumSize(new Dimension(20000, 40));
    skipButton.setBackground(FeatureAmp.getBackgroundColor());
    skipButton.setForeground(FeatureAmp.getForegroundColor());
    skipButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Playlist.getInstance().nextSong();
      }
    });
    addButton(skipButton);
  }

	
  
  /**
   * This function is called internally to exchange the ActionListeners of the buttons
   * @param button The button on wich the listner should be exchanged
   * @param newListener The new listener
   */
  private void setButtonActionListener(JButton button, ActionListener newListener) {
    ActionListener currentListeners[] = button.getActionListeners();
    
    // There should just be 1 ActionListener on the button, but to make it more fail safe....
    for (int i = 0; i < currentListeners.length; i++) {
      button.removeActionListener(currentListeners[i]);
    }
    
    button.addActionListener(newListener);
  }

	
  
  /**
   * Exchange the ActionListener of the start button
   * @param newListener The new listener
   */
  public void setStartButtonActionListener(ActionListener newListener) {
    setButtonActionListener(startButton, newListener);
  }

	

  /**
   * Exchange the ActionListener of the stop button
   * @param newListener The new listener
   */
  public void setStopButtonActionListener(ActionListener newListener) {
    setButtonActionListener(stopButton, newListener);
  }

	

  /**
   * Exchange the ActionListener of the pause button
   * @param newListener The new listener
   */
  public void setPauseButtonActionListener(ActionListener newListener) {
    setButtonActionListener(pauseButton, newListener);
  }

	
  
  public ActionListener getStopButtonListener() {
    ActionListener[] listeners = stopButton.getActionListeners();
    
    if (listeners.length > 0) {
      return listeners[0];
    } else {
      return null;
    }
  }

	
  
  public ActionListener getPlayButtonListener() {
    ActionListener[] listeners = startButton.getActionListeners();
    
    if (listeners.length > 0) {
      return listeners[0];
    } else {
      return null;
    }
  }

	
  
  public void addButton(JButton newButton) {
    add(newButton);
  }

	
  
  public static Buttons getInstance() {
    return buttonsInstance;
  }

	
  private JButton skipButton = new JButton("Weiter");


}
