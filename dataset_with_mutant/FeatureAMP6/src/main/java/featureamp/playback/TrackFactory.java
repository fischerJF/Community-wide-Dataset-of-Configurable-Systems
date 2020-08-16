package featureamp.playback; 

import java.io.File; 
import java.util.HashSet; 
import java.util.Set; 

import featureamp.playback.Track; 

/**
 * TODO description
 */
public   class  TrackFactory {
	
	
	private static Set<String> formats = new HashSet<String>();

	
	
	 private static void  setup__wrappee__Base  () {}

	

	 private static void  setup__wrappee__MP3  () {
		if (!specifications.Configuration.mp3) {
			setup__wrappee__Base();
			return;
		}
		//MP3
		formats.add("mp3");
		setup__wrappee__Base();
	}

	

	 private static void  setup__wrappee__AAC  () {
		if (!specifications.Configuration.aac) {
			setup__wrappee__MP3();
			return;
		}
		// AAC
		formats.add("m4a");
		setup__wrappee__MP3();
	}

	
	 private static void  setup__wrappee__OGG  () {
		if (!specifications.Configuration.ogg) {
			setup__wrappee__AAC();
			return;
		}
		// OGG
		formats.add("ogg");
		setup__wrappee__AAC();
	}

	
	public static void setup() {
		if (!specifications.Configuration.wav) {
			setup__wrappee__OGG();
			return;
		}
		// WAV
		formats.add("wav");
		setup__wrappee__OGG();
	}

	

	 private static Track  createTrack__wrappee__Base  (File f) {
		// Base
		return null;
	}

	

	 private static Track  createTrack__wrappee__MP3  (File f) {
		if (!specifications.Configuration.mp3)
			return createTrack__wrappee__Base(f);
		//MP3
		Track t = createTrack__wrappee__Base(f);
		if (t == null && f.getName().endsWith("mp3")) {
			return new MP3Track(f);
		}
		return t;
	}

	
	 private static Track  createTrack__wrappee__AAC  (File f) {
		if (!specifications.Configuration.aac)
			return createTrack__wrappee__MP3(f);
		// AAC
		Track t = createTrack__wrappee__MP3(f);
		if (t == null && f.getName().endsWith("m4a")) {
			return new AACTrack(f);
		}
		return t;
	}

	

	 private static Track  createTrack__wrappee__OGG  (File f) {
		if (!specifications.Configuration.ogg)
			return createTrack__wrappee__AAC(f);
		// OGG
		Track t = createTrack__wrappee__AAC(f);
		if (t == null && f.getName().endsWith("ogg")) {
			return new OGGTrack(f);
		}
		return t;
	}

	

	public static Track createTrack(File f) {
		if (!specifications.Configuration.wav)
			return createTrack__wrappee__OGG(f);
		// WAV
		Track t = createTrack__wrappee__OGG(f);
		if (t == null && f.getName().endsWith("wav")) {
			return new WAVTrack(f);
		}
		return t;
	}

	
	
	public static Set<String> getFormats() {
		// Base
		return formats;
	}


}
