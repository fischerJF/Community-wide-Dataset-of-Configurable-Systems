package engine; public   class  MetaData {
	
	private final int duration;

	
	private final String artist;

	
	private final String title;

	
	private final String album;

	
	private final int track;

	
	
	MetaData(String artist, String title, int duration) {
//		if (FM.FeatureModel.base) {
			this(artist, title, duration, null, 0);
//				}
	}

	
	
	MetaData(String artist, String title, int duration, String album, int track) {
//		if (FM.FeatureModel.base) {
			this.duration = duration;
			this.artist = artist;
			this.title = title;
			this.album = album;
			this.track = track;
//				}
	}

	
	
	public int getDuration() {
		return duration;
	}

	
	
	public String getArtist() {
		return artist;
	}

	
	
	public String getTitle() {
		return title;
	}

	
	
	public String getAlbum() {
		return album;
	}

	
	
	public int getTrack() {
		return track;
	}

	
	private byte[] image;

		
	
	void setImage(byte[] image) {
		this.image = image;
	}

	
	
	public byte[] getImage() {
		return image;
	}


}
