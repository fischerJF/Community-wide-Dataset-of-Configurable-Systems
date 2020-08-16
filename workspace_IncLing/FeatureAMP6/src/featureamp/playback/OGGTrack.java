package featureamp.playback; 

import java.io.ByteArrayInputStream; 
import java.io.File; 

import javax.imageio.ImageIO; 

import org.jaudiotagger.audio.AudioFile; 
import org.jaudiotagger.audio.AudioFileIO; 
import org.jaudiotagger.tag.FieldKey; 
import org.jaudiotagger.tag.Tag; 
import org.jaudiotagger.tag.images.Artwork; 

import featureamp.playback.BasicTrack; 

/**
 * TODO description
 */
public  class  OGGTrack  extends BasicTrack {
	

	public OGGTrack(File f) {
//		if (specifications.Configuration.ogg) {
			// OGG
			super(f);
			try {
				AudioFile file;
				file = AudioFileIO.read(getFile());
				Tag t = file.getTag();
				artist = t.getFirst(FieldKey.ARTIST).length() > 0 ? t
						.getFirst(FieldKey.ARTIST) : artist;
				title = t.getFirst(FieldKey.TITLE).length() > 0 ? t
						.getFirst(FieldKey.TITLE) : title;
				album = t.getFirst(FieldKey.ALBUM).length() > 0 ? t
						.getFirst(FieldKey.ALBUM) : album;
				tracknumber = t.getFirst(FieldKey.TRACK).length() > 0 ? t
						.getFirst(FieldKey.TRACK) : tracknumber;
				Artwork a = t.getFirstArtwork();
				if (a != null) {
					byte[] b = a.getBinaryData();
					cover = ImageIO.read(new ByteArrayInputStream(b));
				}
			} catch (Exception e) {
			}
//				}
	}


}
