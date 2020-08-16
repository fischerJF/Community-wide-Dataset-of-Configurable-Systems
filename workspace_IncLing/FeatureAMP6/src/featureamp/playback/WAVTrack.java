package featureamp.playback; 

import java.io.File; 

/**
 * TODO description
 */
public  class  WAVTrack  extends BasicTrack {
	

	public WAVTrack(File f) {
//		if (specifications.Configuration.wav) {
			// WAV
			super(f);
			String name = f.getName().trim();
			String[] meta = name.split("-");
			if (meta.length > 1) {
				artist = meta[0];
				title = meta[1];
			}
//				}
	}


}
