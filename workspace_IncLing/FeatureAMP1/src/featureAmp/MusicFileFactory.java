package featureAmp; 

import java.io.File; 

import featureAmp.MP3MusicFile; 
import featureAmp.MusicFileWrapper; 

import featureAmp.WAVMusicFile; 

public   class  MusicFileFactory {
	

	 private static MusicFileWrapper  createMusicFile__wrappee__Base  (File file) throws Exception{
		throw new Exception("File extension not recognized");
	}

	

	 private static MusicFileWrapper  createMusicFile__wrappee__MP3  (File file) throws Exception{
		if (!specifications.Configuration.mp3)
			return createMusicFile__wrappee__Base(file);
		if(file.getName().endsWith(".mp3")){
			return new MP3MusicFile(file.getPath());
		}
		return createMusicFile__wrappee__Base(file);
	}

	
	
	public static MusicFileWrapper createMusicFile(File file) throws Exception{
		if (!specifications.Configuration.wav)
			return createMusicFile__wrappee__MP3(file);
		if(file.getName().endsWith(".wav")){
			return new WAVMusicFile(file.getPath());
		}
		return createMusicFile__wrappee__MP3(file);
	}


}
