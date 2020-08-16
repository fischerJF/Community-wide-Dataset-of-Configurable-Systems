package featureAmp; 

import java.io.File; 

import com.mpatric.mp3agic.Mp3File; 

import featureAmp.MusicFileWrapper; 
import featureAmp.Type; 


public  class  MP3MusicFile  extends MusicFileWrapper {
	

	private Mp3File mp3File;

	
	
	public MP3MusicFile(String path) throws Exception{
//		if (specifications.Configuration.mp3) {
			super(path);
			this.type = Type.MP3;
			this.mp3File = new Mp3File(path);
//				}
	}

	
	
	@Override
	public String getTitle(){
		String title = "";
		if (mp3File.hasId3v2Tag()) {
			title = mp3File.getId3v2Tag().getTitle();
		}
		else if(mp3File.hasId3v1Tag()){
			title = mp3File.getId3v1Tag().getTitle();
		}
		return title != null ? title : new File(filePath).getName();
	}

	
	
	@Override
	public String getArtist(){
		String artist = "";
		if (mp3File.hasId3v2Tag()) {
			artist = mp3File.getId3v2Tag().getAlbumArtist();
		}
		else if (mp3File.hasId3v1Tag()) {
			artist = mp3File.getId3v1Tag().getArtist();
		}
		return artist != null ? artist : "";
	}

	 
	
	@Override
	public long getLength(){
		return mp3File.getLengthInSeconds();
	}

	
	
	@Override
	public byte[] getImage(){
		if(mp3File.hasId3v2Tag()){
			byte[] image = mp3File.getId3v2Tag().getAlbumImage(); 
			return image != null ? image : new byte[0];
		}
		return new byte[0];
	}

	
	
	@Override
	public String getAlbum(){
		String album = "";
		if (mp3File.hasId3v2Tag()) {
			album = mp3File.getId3v2Tag().getAlbum();
		}
		else if (mp3File.hasId3v1Tag()) {
			album = mp3File.getId3v1Tag().getAlbum();
		}
		return album != null ? album : "";
	}

	
	
	@Override
	public String getTrack(){
		String track = "";
		if (mp3File.hasId3v2Tag()) {
			track = mp3File.getId3v2Tag().getTrack();
		}
		else if (mp3File.hasId3v1Tag()) {
			track = mp3File.getId3v1Tag().getTrack();
		}
		return track != null ? track : "";		
	}

	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(getTrack()).
		append(" - ").
		append(getTitle()).
		append(" - ").
		append(getArtist()).
		append(" - ").
		append(getAlbum()).
		append(" - ").
		append(Util.formatTime(getLength()));
		
		return builder.toString();
	}


}
