package featureAmp; 


import featureAmp.Type; 

public abstract  class  MusicFileWrapper {
	
	protected String filePath;

	
	protected boolean isPlaying;

	
	protected Type type;

	
	
	
	public MusicFileWrapper(String filePath) throws Exception {
		if (specifications.Configuration.base) {
			this.filePath = filePath;
				}
	}

	
	

	public String getFilePath() {
		return filePath;
	}

	
	public boolean isPlaying() {
		return isPlaying;
	}

	
	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	
	
	public abstract String getTitle();

	
	
	public abstract String getArtist();

	
	
	public abstract long getLength();

	
	
	public abstract byte[] getImage();

	
	
	public abstract String getAlbum();

	

	public abstract String getTrack();

	
	
	
	@Override
	public abstract String toString();


}
