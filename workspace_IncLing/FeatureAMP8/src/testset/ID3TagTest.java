package testset;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import engine.ID3Tag;
import engine.MP3Player;

import static org.mockito.Matchers.anyObject;

import java.io.IOException;

import javax.swing.ImageIcon;

import specifications.Configuration;

public class ID3TagTest {

	private ID3Tag id;

	@Before
	public void setUp() {
	}

	@Test
	public void ID3TagTest() throws IllegalArgumentException, IllegalAccessException, UnsupportedTagException,
			InvalidDataException, IOException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			long lengthInSec = (long) MemberModifier.field(ID3Tag.class, "lengthInSec").get(id);
			assertEquals(lengthInSec, 4);

			int hh = (int) MemberModifier.field(ID3Tag.class, "hh").get(id);
			assertEquals(hh, 0);

			int mm = (int) MemberModifier.field(ID3Tag.class, "mm").get(id);
			assertEquals(mm, 0);

			long ss = (long) MemberModifier.field(ID3Tag.class, "ss").get(id);
			assertEquals(ss, 4);
			assertNotNull(ss);
			assertTrue(ss > 0);

			String lengthString = (String) MemberModifier.field(ID3Tag.class, "lengthString").get(id);
			assertEquals(lengthString, "00:00:04");

			boolean hasId3V1Tag = (boolean) MemberModifier.field(ID3Tag.class, "hasId3V1Tag").get(id);
			assertTrue(hasId3V1Tag);

			ImageIcon albumImage = (ImageIcon) MemberModifier.field(ID3Tag.class, "albumImage").get(id);
			assertNotNull(albumImage);

			assertNull(id.getArtist());
			assertNull(id.getTitle());
			assertTrue(id.getAlbum() != " ");
			assertEquals(id.getGenre(), "Unknown");
			assertTrue(id.getComment() != " ");
			assertTrue(id.getYear() != " ");

			assertTrue(id.hasId3V2Tag());
			assertTrue(id.hasId3V1Tag());

		}
	}

	@Test
	public void ssTest() throws IllegalArgumentException, IllegalAccessException, UnsupportedTagException, InvalidDataException, IOException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			long ssTest = 9223372036854775807L;
			MemberModifier.field(ID3Tag.class, "ss").set(id, ssTest);
			long ss = (long) MemberModifier.field(ID3Tag.class, "ss").get(id);
			assertEquals(ss, ssTest);
		}
	}

	@Test
	public void getAlbumImageTest() throws UnsupportedTagException, InvalidDataException, IOException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			assertTrue(id.getAlbumImage() != null);
		}
	}

	@Test
	public void getGenreTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			Whitebox.invokeMethod(id, "setGenre", "genre");
			assertEquals(id.getGenre(), "genre");
		}
	}

	@Test
	public void getCommentTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			Whitebox.invokeMethod(id, "setComment", "comment__");
			assertEquals(id.getComment(), "comment__");
		}
	}

	@Test
	public void getTrackTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			Whitebox.invokeMethod(id, "setTrack", "track 1");
			assertEquals(id.getTrack(), "track 1");
		}
	}

	@Test
	public void getYearTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			Whitebox.invokeMethod(id, "setYear", "2019");
			assertEquals(id.getYear(), "2019");
		}
	}

	@Test
	public void getTitleTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			Whitebox.invokeMethod(id, "setTitle", "title");
			assertEquals(id.getTitle(), "title");
		}
	}

	@Test
	public void getArtistTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			Whitebox.invokeMethod(id, "setArtist", "artist");
			assertEquals(id.getArtist(), "artist");
		}
	}

	@Test
	public void getLengthInSecTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			assertEquals(id.getLengthInSec(), 4);
		}
	}

	@Test
	public void getlengthStringTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			assertEquals(id.getlengthString(), "00:00:04");
		}
	}

	@Test
	public void getTitleleisteTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			assertTrue(id.getTitleleiste() != "");
		}
	}

	@Test
	public void hasId3V1TagTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			assertTrue(id.hasId3V1Tag());
		}
	}

	@Test
	public void hasId3V2TagTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			assertTrue(id.hasId3V2Tag());
		}
	}

	@Test
	public void getAlbumTest() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			Whitebox.invokeMethod(id, "setAlbum", "album");

			assertEquals(id.getAlbum(), "album");
		}
	}

	@Test
	public void getTitle_id3V1Test() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			ID3v1 id3v1 = (ID3v1) MemberModifier.field(ID3Tag.class, "id3V1Tag").get(id);
			Whitebox.invokeMethod(id, "setTitle", id3v1.getArtist());
			assertEquals(id.getTitle(), id3v1.getArtist());
		}
	}

	@Test
	public void getArtist_id3V1Test() throws Exception {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			Mp3File mp3 = new Mp3File("media/note.mp3");
			id = new ID3Tag(mp3, 100, 100, true);
			ID3v1 id3v1 = (ID3v1) MemberModifier.field(ID3Tag.class, "id3V1Tag").get(id);

			Whitebox.invokeMethod(id, "setArtist", id3v1.getArtist());
			assertEquals(id.getArtist(), id3v1.getArtist());
		}
	}
}
