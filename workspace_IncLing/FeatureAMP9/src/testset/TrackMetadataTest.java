package testset;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import players.TrackMetadata;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class TrackMetadataTest {

	private TrackMetadata trackMetada;

	@Before
	public void setUp() {
	}

	@Test
	public void TrackMetadataTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.gui = true;
		if (Configuration.gui) {
			trackMetada = new TrackMetadata("title");
			String title = (String) MemberModifier.field(TrackMetadata.class, "title").get(trackMetada);
			assertEquals(title, "title");
		}
	}

	//@Test
	public void TrackMetadataTest2() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.gui = false;
		if (!Configuration.gui) {
			trackMetada = new TrackMetadata("title");
			String title = (String) MemberModifier.field(TrackMetadata.class, "title").get(trackMetada);
			assertEquals(title, "");
		}
	}

	@Test
	public void TrackMetadataTest3() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.gui = true;
		if (Configuration.gui) {
			trackMetada = new TrackMetadata("title", "artist");
			String title = (String) MemberModifier.field(TrackMetadata.class, "title").get(trackMetada);
			String artist = (String) MemberModifier.field(TrackMetadata.class, "artist").get(trackMetada);
			assertEquals(title, "title");
			assertEquals(artist, "artist");
		}
	}

	@Test
	public void TrackMetadataTest4() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.gui = false;
		if (!Configuration.gui) {
			trackMetada = new TrackMetadata("title", "artist");
			String title = (String) MemberModifier.field(TrackMetadata.class, "title").get(trackMetada);
			String artist = (String) MemberModifier.field(TrackMetadata.class, "artist").get(trackMetada);
			assertEquals(title, "");
			assertEquals(artist, "");
		}
	}

	@Test
	public void TrackMetadataTest5() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.gui = true;
		if (Configuration.gui) {
			trackMetada = new TrackMetadata("title", "artist", 5454);
			String title = (String) MemberModifier.field(TrackMetadata.class, "title").get(trackMetada);
			String artist = (String) MemberModifier.field(TrackMetadata.class, "artist").get(trackMetada);
			long runtime = (long) MemberModifier.field(TrackMetadata.class, "runtime").get(trackMetada);
			assertEquals(title, "title");
			assertEquals(artist, "artist");
			assertEquals(runtime, 5454);
		}
	}

	@Test
	public void TrackMetadataTest6() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.gui = false;
		if (!Configuration.gui) {
			trackMetada = new TrackMetadata("title", "artist", 5454);
			String title = (String) MemberModifier.field(TrackMetadata.class, "title").get(trackMetada);
			String artist = (String) MemberModifier.field(TrackMetadata.class, "artist").get(trackMetada);
			long runtime = (long) MemberModifier.field(TrackMetadata.class, "runtime").get(trackMetada);
			assertEquals(title, "");
			assertEquals(artist, "");
			assertEquals(runtime, -2147483648);
		}
	}

	@Test
	public void TrackMetadataTest7() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.gui = true;
		if (Configuration.gui) {
			trackMetada = new TrackMetadata("title", 5454);
			String title = (String) MemberModifier.field(TrackMetadata.class, "title").get(trackMetada);
			String artist = (String) MemberModifier.field(TrackMetadata.class, "artist").get(trackMetada);
			long runtime = (long) MemberModifier.field(TrackMetadata.class, "runtime").get(trackMetada);
			assertEquals(title, "title");

			assertEquals(runtime, 5454);
		}
	}

	@Test
	public void TrackMetadataTest8() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.gui = false;
		if (!Configuration.gui) {
			trackMetada = new TrackMetadata("title", 5454);
			String title = (String) MemberModifier.field(TrackMetadata.class, "title").get(trackMetada);
			String artist = (String) MemberModifier.field(TrackMetadata.class, "artist").get(trackMetada);
			long runtime = (long) MemberModifier.field(TrackMetadata.class, "runtime").get(trackMetada);
			assertEquals(title, "");
			assertEquals(runtime, -2147483648);
		}
	}

	@Test
	public void getTitleTest() {
		trackMetada = new TrackMetadata();
		trackMetada.setTitle("title");
		assertEquals(trackMetada.getTitle(), "title");
	}

	@Test
	public void getArtistTest() {
		trackMetada = new TrackMetadata();
		trackMetada.setArtist("artist");
		assertEquals(trackMetada.getArtist(), "artist");
	}

	@Test
	public void getAlbumTest() {
		trackMetada = new TrackMetadata();
		trackMetada.setAlbum("album");
		assertEquals(trackMetada.getAlbum(), "album");
	}

	@Test
	public void getRuntimeTest() {
		trackMetada = new TrackMetadata();
		trackMetada.setRuntime(2121);
		assertEquals(trackMetada.getRuntime(), 2121);
	}

	@Test
	public void getTrackTest() {
		trackMetada = new TrackMetadata();
		trackMetada.setTrackNumber(1);
		assertEquals(trackMetada.getTrackNumber(), 1);
	}

	@Test
	public void toString__wrappee__GUITest() throws Exception {
		trackMetada = new TrackMetadata("title", "artist", 5454);
		trackMetada.setTrackNumber(12);
		String output = (Whitebox.invokeMethod(trackMetada, "toString__wrappee__GUI"));
		assertTrue(output.contains("12"));
	}

	@Test
	public void toStringTest() throws Exception {
//		Configuration.queuetrack = false;
		if (!Configuration.queuetrack) {
			toString__wrappee__GUITest();
		}
	}
	
		
	@Test
	public void formatTime() {
		trackMetada = new TrackMetadata("title", "artist", 5454);
		assertEquals(trackMetada.formatTime(123456),"34:17:36");
	}

	@Test
	public void compareToTest() throws Exception {
			trackMetada = new TrackMetadata("title", "artist", 5454);
			trackMetada.setTrackNumber(4);
			TrackMetadata trackMetada2 = new TrackMetadata(); 
			trackMetada2.setTrackNumber(0);
			assertTrue(trackMetada.compareTo(trackMetada2)==1);
	}
	
	@Test
	public void setQueuedTest() throws IllegalArgumentException, IllegalAccessException {
		trackMetada = new TrackMetadata("title", "artist", 5454);
		trackMetada.setQueued(4);
		int i = (int) MemberModifier.field(TrackMetadata.class, "queuePos").get(trackMetada);

		assertEquals(i,4);
	}
	
}
