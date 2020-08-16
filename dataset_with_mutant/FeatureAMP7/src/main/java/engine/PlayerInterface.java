package engine; 

/**
 * This is an abstract class to derive real Players from
 * @author Arne Kreddig
 */
public  interface  PlayerInterface {
	
  // The modes in which the player can be
  public final static int STATUS_READY = 0;

	
  public final static int STATUS_PLAYING = 1;

	
  public final static int STATUS_PAUSED = 2;

	
  public final static int STATUS_FINISHED = 3;

	
  
  // Here we save the currently active player
  //private static PlayerAbstr currentPlayer = null;
  
  // The thread that updates the time in the title
//  protected static UpdateTime updateThread;

  /**
   * Creates a new player with the input sound file 'filename'
   * 
   * @param filename The sound file
   */
  /*public PlayerAbstr(String filename) {
    // Close the old player if there is one
    if (currentPlayer != null) {
      currentPlayer.cmdStop();
      currentPlayer.cmdClose();
    }
    
    // Create a thread that will update the time in the title
    updateThread = new UpdateTime(this);
    
    // This player will be our new player
    currentPlayer = this;
  }*/

  /**
   * Starts playback (resumes if paused).
   */
  public void cmdPlay();

	

  /**
   * Pauses playback.
   */
  public void cmdPause();

	

  /**
   * Resumes playback.
   */
  public void cmdResume();

	

  /**
   * Stops playback. If not playing, does nothing.
   */
  public void cmdStop();

	

  /**
   * Returns the current player status.
   * 
   * @return The player status
   */
  public int getPlayerStatus();

	

  /**
   * Returns the current time position within the sound file
   * 
   * @return The current position in the sound file
   */
  public long getPlayerPosition();

	

  /**
   * Closes the player, regardless of current state.
   */
  public void cmdClose();


}
