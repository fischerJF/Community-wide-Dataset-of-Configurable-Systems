package player; 

import java.io.File; 

import player.PlayerFileFilter; 

public abstract  class  Player {
	
	
	public final static int STATUS_ERROR = -1;

	
	public final static int STATUS_READY = 0;

	
	public final static int STATUS_PLAYING = 1;

	
	public final static int STATUS_PAUSED = 2;

	
	public final static int STATUS_FINISHED = 3;

	

	public abstract void play();

	
	public abstract void pause();

	
	public abstract void stop();

	
	public abstract void resume();

	
	public abstract void close();

	
	
	public abstract void setVolume(int vol);

	
	
	public abstract long getPosition();

	
	
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

	
	
	public abstract int playerStatus();


}
