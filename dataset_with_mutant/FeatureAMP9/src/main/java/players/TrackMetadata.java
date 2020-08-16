package players; 

import java.awt.Image; public   class  TrackMetadata  implements Comparable<TrackMetadata> {
	
	private String title = "";

	
	private String artist = "";

	
	private String album = "";

	
	private long runtime = Integer.MIN_VALUE;

	
	private Image cover = null;

	
	private String fileName = "";

	
	private int trackNumber = -1;

	
	
	public TrackMetadata() {
		if (specifications.Configuration.gui) {
			// empty
				}
	}

	
	
	public TrackMetadata(String title) {
		if (specifications.Configuration.gui) {
			this.title = title;
				}
	}

	
	
	public TrackMetadata(String title, String artist) {
		if (specifications.Configuration.gui) {
			this.title = title;
			this.artist = artist;
				}
	}

	
	
	public TrackMetadata(String title, String artist, long runtime) {
		if (specifications.Configuration.gui) {
			this.title = title;
			this.artist = artist;
			this.runtime = runtime;
				}
	}

	
	
	public TrackMetadata(String title, int runtime) {
		if (specifications.Configuration.gui) {
			this.title = title;
			this.runtime = runtime;
				}
	}

	
	
	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getArtist() {
		return artist;
	}

	
	public void setArtist(String artist) {
		this.artist = artist;
	}

	
	
	public String getAlbum() {
		return album;
	}

	

	public void setAlbum(String album) {
		this.album = album;
	}

	

	public long getRuntime() {
		return runtime;
	}

	
	public void setRuntime(long runtime) {
		this.runtime = runtime;
	}

	
	
	public String getFileName() {
		return fileName;
	}

	

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

	public void setCover(Image image) {
		this.cover = image;
	}

	
	public Image getCover() {
		return this.cover;
	}

	

	public int getTrackNumber() {
		return trackNumber;
	}

	

	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}

	
	
	 private String  toString__wrappee__GUI  () {
		return String.format("%d - %s - %s - %s - %s", trackNumber,
				artist == null ? "unknown" : artist,
				album == null ? "unknown" : album,
				title == null ? "unknown" : title,
				formatTime(runtime));
	}

	
	
	
	public String toString() {
		if (!specifications.Configuration.queuetrack)
			return toString__wrappee__GUI();
		if (queuePos >= 0)
		{
			return String.format("+%d+ %s", queuePos, toString__wrappee__GUI());
		}
		else
		{
			return toString__wrappee__GUI();
		}
	}

	
	
	public String formatTime(long time)
	{
		long hours = time / (60*60);
		time -= hours * 60*60;
		long minutes = time / 60;
		time -= minutes * 60;
		long seconds = time;
		
		if (hours > 0)
			return String.format("%d:%02d:%02d", hours, minutes,seconds);
		return String.format("%d:%02d", minutes, seconds);
	}

	

	@Override
	public int compareTo(TrackMetadata o) {
		if (o == null) {
			return 1;
		}
		return this.trackNumber > o.trackNumber ? 1 : (this.trackNumber < o.trackNumber ? -1 : 0);
	}

	
	private int queuePos = -1;

	
	
	public void setQueued(int pos)
	{
		this.queuePos = pos;
	}


}
