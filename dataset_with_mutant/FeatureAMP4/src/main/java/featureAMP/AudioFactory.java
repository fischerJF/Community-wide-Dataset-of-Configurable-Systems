package featureAMP;
import java.io.File; 
import java.util.ArrayList; 
import java.util.Collection; 

public   class  AudioFactory {
	
	
	 private static Collection<String>  getSupportedFileExtensions__wrappee__BASE_FEATUREAMP  () {
		return new ArrayList<String>();
	}

	
	
	 private static Collection<String>  getSupportedFileExtensions__wrappee__MP3  () {
		if (!specifications.Configuration.mp3)
			return getSupportedFileExtensions__wrappee__BASE_FEATUREAMP();
		
		Collection<String> extensions = getSupportedFileExtensions__wrappee__BASE_FEATUREAMP();
		extensions.add("mp3");
		return extensions;
		
	}

	
	
	public static Collection<String> getSupportedFileExtensions() {
		if (!specifications.Configuration.ogg)
			return getSupportedFileExtensions__wrappee__MP3();
		
		Collection<String> extensions = getSupportedFileExtensions__wrappee__MP3();
		extensions.add("ogg");
		return extensions;
		
	}

	
	
	private static String getFileExtension(File file) {
		
		String filename = file.getName();
		String extension = "";

		int i = filename.lastIndexOf('.');
		if (i > 0) {
		    extension = filename.substring(i+1);
		}
		
		return extension;
		
	}

	
	
	 private static AudioFile  createAudioFile__wrappee__BASE_FEATUREAMP  (File file) throws AudioFormatNotSupportedException {
		throw new AudioFormatNotSupportedException();
	}

	
	
	 private static AudioFile  createAudioFile__wrappee__MP3  (File file) throws AudioFormatNotSupportedException {
		if (!specifications.Configuration.mp3)
			return createAudioFile__wrappee__BASE_FEATUREAMP(file);
		
		String extension = getFileExtension(file);
		if (extension.equals("mp3")) {
			try {
				return new Mp3MetaFile(file.getAbsolutePath());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return createAudioFile__wrappee__BASE_FEATUREAMP(file);
		
	}

	
	
	public static AudioFile createAudioFile(File file) throws AudioFormatNotSupportedException {
		if (!specifications.Configuration.ogg)
			return createAudioFile__wrappee__MP3(file);
		
		String extension = getFileExtension(file);
		if (extension.equals("ogg")) {
			try {
				return new OggMetaFile(file.getAbsolutePath());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return createAudioFile__wrappee__MP3(file);
		
	}

	
	
	 private static AudioController  createAudioController__wrappee__BASE_FEATUREAMP  (AudioFile audioFile) throws AudioFormatNotSupportedException {
		throw new AudioFormatNotSupportedException();
	}

	
	
	 private static AudioController  createAudioController__wrappee__MP3  (AudioFile audioFile) throws AudioFormatNotSupportedException {
		if (!specifications.Configuration.mp3)
			return createAudioController__wrappee__BASE_FEATUREAMP(audioFile);
		
		if (audioFile instanceof Mp3MetaFile) {
			try {
				return new Mp3Controller((Mp3MetaFile) audioFile);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return createAudioController__wrappee__BASE_FEATUREAMP(audioFile);
		
	}

	
	
	public static AudioController createAudioController(AudioFile audioFile) throws AudioFormatNotSupportedException {
		if (!specifications.Configuration.ogg)
			return createAudioController__wrappee__MP3(audioFile);
		
		if (audioFile instanceof OggMetaFile) {
			try {
				return new OggController((OggMetaFile) audioFile);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return createAudioController__wrappee__MP3(audioFile);
		
	}

	
	
	public static  class  AudioFormatNotSupportedException  extends Exception {
		
		private static final long serialVersionUID = 1L;


	}


}
