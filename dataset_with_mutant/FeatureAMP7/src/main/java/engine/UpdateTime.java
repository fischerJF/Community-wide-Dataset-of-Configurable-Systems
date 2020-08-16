package engine; 

import main.FeatureAmp; 

/**
 * This thread updates the time in the title of the GUI
 * @author Arne Kreddig
 */
public  class  UpdateTime <T extends PlayerInterface>  extends Thread {
	
  private boolean stopThread;

	
  private boolean pauseThread;

	
  private T connectedPlayer;

	

  /**
   * The constructer initializes some parameters and sets the player that
   * is connected to this thread
   * @param player
   */
  public UpdateTime (T player) {
		if (specifications.Configuration.time) {
	    stopThread = false;
	    pauseThread = false;
	    connectedPlayer = player;
	  		}
	}

	

  /**
   * The main method of this thread
   */
  public void run() {
    while (true) {
      // The actual update of the title and/or progress bar
      FeatureAmp.updateTime(connectedPlayer.getPlayerPosition());
      FeatureAmp.getNewTimeObserv().update();
      try {
        sleep(30);
        synchronized (this) {
          if (stopThread) { // If we got a command to stop this thread
            break;
          }
          if (pauseThread) { // If we got a acommand to pause this thread..
            wait(); // ..wait to continue this thread
          }
        }
      } catch (InterruptedException e) {
        break;
      }
    }
  }

	

  /**
   * Pause this thread
   */
  public void pauseTimer() {
    synchronized (this) {
      pauseThread = true;
    }
  }

	
  
  /**
   * Resume this thread
   */
  public void resumeTimer() {
    synchronized (this) {
      pauseThread = false;
      notify();
    }
  }

	  
  
  /**
   * Stop this thread
   */
  public void stopTimer() {
    synchronized (this) {
      stopThread = true;
      interrupt();
    }
  }


}
