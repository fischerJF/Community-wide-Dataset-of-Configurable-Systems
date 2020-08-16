package featureamp.playback; 

import java.io.ByteArrayInputStream; 
import java.io.File; 

import javax.imageio.ImageIO; 

import com.mpatric.mp3agic.ID3v1; 
import com.mpatric.mp3agic.ID3v2; 
import com.mpatric.mp3agic.Mp3File; 

import featureamp.playback.BasicTrack; 

/**
 * TODO description
 */
public  class  MP3Track  extends BasicTrack {
	

	public MP3Track(File f) {
//		if (specifications.Configuration.mp3) {
			// MP3
			super(f);
			Mp3File file;
			try {
				file = new Mp3File(f.getAbsolutePath());
				if (file.hasId3v2Tag()) {
					ID3v2 tag = file.getId3v2Tag();
					artist = tag.getArtist();
					title = tag.getTitle();
					length = getLength(tag.getLength());
					album = tag.getAlbum();
					tracknumber = tag.getTrack();
					byte[] image = tag.getAlbumImage();
					if (image != null) {
						cover = ImageIO.read(new ByteArrayInputStream(image));
					}
				} else if (file.hasId3v1Tag()) {
					ID3v1 tag = file.getId3v1Tag();
					artist = tag.getArtist();
					title = tag.getTitle();
					length = getLength(0);
					album = tag.getAlbum();
					tracknumber = tag.getTrack();
				}
			} catch (Exception e) {
			}
//				}
	}

	

	private String getLength(int l) {
		int mins = l / 60;
		int secs = l % 60;
		return mins + ":" + (secs < 10 ? "0" : "") + secs;

	}


}
