package featureamp.players; 

public  interface  Player {
	
	public enum  Status {READY ,  PLAYING ,  PAUSED ,  STOPPED}

	;

	
	
	public void play();

	
	
	public void stop();

	
	
	public void pause();

	
	
	public void resume();

	
	
	public void close();

	
	
	/**
	 * Mute
	 */
	
	public void mute();

	
	
	public void unmute();

	
	
	public boolean isMuted();

	
	
	/**
	 * Volume
	 */
    
	public void setVolume(float vol);

	
	
	public float getVolume();

	
	
	public long getPosition();

	
	
	public long getLength();

	
	
	public void seek(int position);

	
	
	public Status getPlayerStatus();


}
