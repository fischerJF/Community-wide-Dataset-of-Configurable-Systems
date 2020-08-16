package players; 

import java.io.File; 

public abstract  class  Player {
	
	public enum  State {
		// Indicates that the player is ready to start playing a file
		READY , 
		// Indicates that the player is playing a file
		PLAYING , 
		// Indicates that the player has paused playing a file
		PAUSED , 
		// Indicates that the player has finished playing a file
		FINISHED , 
	}

	
	
	public abstract void play();

	
	public abstract void pause();

	
	public abstract void stop();

	
	public abstract void resume();

	
	public abstract void close();

	
	
	public abstract void setVolume(int vol);

	
	
	/*
	 * This should return seconds
	 */
	public abstract long position();

	
		
	public static PlayerFileFilter getFileFilter()
	{
		return null;
	}

	
	
	public abstract TrackMetadata getTrackMetadata();

	
	
	public static TrackMetadata getTrackMetadata(String filename)
	{
		return null;
	}

	
	
	// From here: http://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
	public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

	
	
	protected State playerStatus = State.READY;

	
	
	public State getState() {
		return this.playerStatus;
	}


}
