package featureAmp; 

import java.io.File; 

import org.jaudiotagger.audio.AudioFile; 
import org.jaudiotagger.audio.AudioFileIO; 
import org.jaudiotagger.tag.FieldKey; 


import org.jaudiotagger.tag.images.Artwork; 

import featureAmp.MusicFileWrapper; 
import featureAmp.Type; 
import featureAmp.Util; 


public  class  WAVMusicFile  extends MusicFileWrapper {
	
	
	private AudioFile wav;

	
	
	public WAVMusicFile(String filePath) throws Exception{
//		if (specifications.Configuration.wav) {
			super(filePath);
			this.wav = AudioFileIO.read(new File(filePath));
			this.type = Type.WAV;
//				}
	}

	

	@Override
	public String getTitle(){
		return wav.getTag().getFirst(FieldKey.TITLE);
	}

	
	
	@Override
	public long getLength(){
		return wav.getAudioHeader().getTrackLength();
	}

	
	
	@Override
	public String getArtist(){
		return wav.getTag().getFirst(FieldKey.ARTIST);
	}

	
	
	@Override
	public String getAlbum(){
		return wav.getTag().getFirst(FieldKey.ALBUM);
	}

	
	
	@Override
	public String getTrack(){
		return wav.getTag().getFirst(FieldKey.TRACK);
	}

	
	
	@Override
	public byte[] getImage(){
		Artwork artwork = wav.getTag().getFirstArtwork();
		return artwork != null ? artwork.getBinaryData() : new byte[0];
	}

	
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		
		
		builder.append(getTrack()).
		append(" - ").
		append(!getTitle().isEmpty() ? getTitle() : new File(filePath).getName()).
		append(" - ").
		append(getArtist()).
		append(" - ").
		append(getAlbum()).
		append(" - ").
		append(Util.formatTime(getLength()));
		
		return builder.toString();
	}


}
