package gui; 

import java.util.Objects; 

import engine.AudioFile; 
import engine.MetaData;  class  PlaylistItem {
	
	private final AudioFile audioFile;

	
	
	PlaylistItem(AudioFile audioFile) {
//		if (FM.FeatureModel.playlist) {
			this.audioFile = audioFile;
//				}
	}

	
	
	
	 private String  toString__wrappee__Playlist() {
		MetaData metaData = audioFile.getMetaData();
		// track, artist, title, album, laufzeit
		return String.format("%s %s - %s - %s - %d:%02d",
				metaData.getTrack() > 0 ? String.valueOf(metaData.getTrack()) : "",
				metaData.getArtist(),
				metaData.getTitle(),
				Objects.toString(metaData.getAlbum(), ""),
				metaData.getDuration() / 60,
				metaData.getDuration() % 60);
	}

	
	
	public String toString() {
		if (!specifications.Configuration.queuetrack)
			return toString__wrappee__Playlist();
		if(queuePosition < 0)
			return toString__wrappee__Playlist();
		return toString__wrappee__Playlist() + String.format(" [%d]", queuePosition + 1);
	}

	
	
	AudioFile getAudioFile() {
		return audioFile;
	}

	
	private int queuePosition = -1;

	
	
	
	void setQueuePosition(int position) {
		this.queuePosition = position;
	}


}
