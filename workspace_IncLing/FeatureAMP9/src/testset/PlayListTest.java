package testset;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import gui.Playlist;
import gui.Playlist.PlayMode;
import players.TrackMetadata;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class PlayListTest {

	Playlist playlist;

	@Before
	public void setUp() {

	}

	@Test
	public void playListTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();
			List t = (List) MemberModifier.field(Playlist.class, "tracks").get(playlist);
			assertNotNull(t);
		}
	}

	@Test
	public void addTrackTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			List t = (List) MemberModifier.field(Playlist.class, "tracks").get(playlist);
			assertNotNull(t);
			assertEquals(t.size(), 2);
		}
	}

	@Test
	public void removeTrackTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {

			playlist = new Playlist();
			TrackMetadata track = new TrackMetadata();
			playlist.addTrack(track);
			playlist.removeTrack(track);
			int position = (int) MemberModifier.field(Playlist.class, "position").get(playlist);

			assertEquals(position, 0);
			List t = (List) MemberModifier.field(Playlist.class, "tracks").get(playlist);
			assertNotNull(t);
			assertEquals(t.size(), 0);
		}
	}

	@Test
	public void clearListTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			playlist.clearList();

			int position = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			List t = (List) MemberModifier.field(Playlist.class, "tracks").get(playlist);
			assertNotNull(t);
			assertEquals(t.size(), 0);
		}
	}

	@Test
	public void getArrayTest() {
//		Configuration.playlist = true;
		if (Configuration.playlist) {

			playlist = new Playlist();
			TrackMetadata t1 = new TrackMetadata();
			TrackMetadata t2 = new TrackMetadata();
			TrackMetadata t3 = new TrackMetadata();
			TrackMetadata t4 = new TrackMetadata();
			playlist.addTrack(t1);
			playlist.addTrack(t2);
			playlist.addTrack(t3);
			playlist.addTrack(t4);

			assertTrue(playlist.getArray().length == 4);
			assertTrue(playlist.getArray()[0] == t1);
			assertTrue(playlist.getArray()[1] == t2);
			assertTrue(playlist.getArray()[2] == t3);
			assertTrue(playlist.getArray()[3] == t4);
		}
	}

	@Test
	public void shuffleListTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();
			playlist.shuffleList();
			int position = (int) MemberModifier.field(Playlist.class, "position").get(playlist);

			assertTrue(position == 0);
		}
	}

	@Test
	public void nextTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();
			assertNull(playlist.next());
		}
	}

	@Test
	public void next__wrappee__PlaylistTest() throws Exception {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();

			assertNull(Whitebox.invokeMethod(playlist, "next__wrappee__Playlist", true));
			int position = (int) MemberModifier.field(Playlist.class, "position").get(playlist);

			assertTrue(position == 1);
		}
	}

	@Test
	public void next__wrappee__PlaylistTest2() throws Exception {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "position").set(playlist, 0);
			int position = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			List t = (List) MemberModifier.field(Playlist.class, "tracks").get(playlist);
			assertNotNull(Whitebox.invokeMethod(playlist, "next__wrappee__Playlist", true));
		}
	}

	@Test
	public void next__wrappee__ShuffleRepeatTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.playlist = true;
		if (Configuration.shufflerepeat && Configuration.playlist) {
			playlist = new Playlist();
			int position = (int) MemberModifier.field(Playlist.class, "position").get(playlist);

			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "mode").set(playlist, PlayMode.Normal);
			TrackMetadata track = (TrackMetadata) Whitebox.invokeMethod(playlist, "next__wrappee__ShuffleRepeat", true);
			int pos = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			assertTrue(position == (pos - 1));
			List t = (List) MemberModifier.field(Playlist.class, "tracks").get(playlist);
			assertNotNull(track);
		}
	}

	@Test
	public void next__wrappee__ShuffleRepeatTest2() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.playlist = true;
		if (Configuration.shufflerepeat && Configuration.playlist) {
			playlist = new Playlist();
			int position = (int) MemberModifier.field(Playlist.class, "position").get(playlist);

			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "mode").set(playlist, PlayMode.RepeatOne);
			TrackMetadata track = (TrackMetadata) Whitebox.invokeMethod(playlist, "next__wrappee__ShuffleRepeat",
					false);
			int pos = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			assertTrue(position == pos);
			assertNotNull(track);
		}
	}

	@Test
	public void next__wrappee__ShuffleRepeatTest3() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.playlist = true;
		if (Configuration.shufflerepeat && Configuration.playlist) {
			playlist = new Playlist();
			int position = (int) MemberModifier.field(Playlist.class, "position").get(playlist);

			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "mode").set(playlist, PlayMode.RepeatOne);
			MemberModifier.field(Playlist.class, "position").set(playlist, 5);
			TrackMetadata track = (TrackMetadata) Whitebox.invokeMethod(playlist, "next__wrappee__ShuffleRepeat", true);
			int pos = (int) MemberModifier.field(Playlist.class, "position").get(playlist);

			List t = (List) MemberModifier.field(Playlist.class, "tracks").get(playlist);
			assertNull(track);
		}
	}

	@Test
	public void next__wrappee__ShuffleRepeatTest4() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.playlist = true;
		if (Configuration.shufflerepeat && Configuration.playlist) {
			playlist = new Playlist();
			int position = (int) MemberModifier.field(Playlist.class, "position").get(playlist);

			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "mode").set(playlist, PlayMode.RepeatAll);
			MemberModifier.field(Playlist.class, "position").set(playlist, 5);
			TrackMetadata track = (TrackMetadata) Whitebox.invokeMethod(playlist, "next__wrappee__ShuffleRepeat", true);
			int pos = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			assertEquals(pos, 0);
		}
	}

	@Test
	public void next__wrappee__ShuffleRepeatTest5() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.playlist = true;
		if (Configuration.shufflerepeat && Configuration.playlist) {
			playlist = new Playlist();
			int position = (int) MemberModifier.field(Playlist.class, "position").get(playlist);

			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "mode").set(playlist, PlayMode.RepeatAll);
			MemberModifier.field(Playlist.class, "position").set(playlist, 0);
			TrackMetadata track = (TrackMetadata) Whitebox.invokeMethod(playlist, "next__wrappee__ShuffleRepeat", true);
			int pos = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			assertEquals(pos, 1);
			assertNotNull(track);
		}
	}

	@Test
	public void next__wrappee__ShuffleRepeatTest6() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.playlist = true;
		if (Configuration.shufflerepeat && Configuration.playlist) {
			playlist = new Playlist();
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "mode").set(playlist, null);
			TrackMetadata track = (TrackMetadata) Whitebox.invokeMethod(playlist, "next__wrappee__ShuffleRepeat", true);
			assertNotNull(track);
		}
	}

	@Test
	public void next__wrappee__ShuffleRepeatTest7() throws Exception {
//		Configuration.shufflerepeat = false;
//		Configuration.playlist = true;
		if (!Configuration.shufflerepeat && Configuration.playlist) {
			playlist = new Playlist();
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "mode").set(playlist, null);
			Whitebox.invokeMethod(playlist, "next__wrappee__Playlist", true);
		}
	}

	@Test
	public void nextTest2() throws Exception {
//		Configuration.queuetrack = false;
//		Configuration.playlist = true;
		if (!Configuration.queuetrack && Configuration.playlist) {
			next__wrappee__ShuffleRepeatTest7();
			next__wrappee__ShuffleRepeatTest6();
			next__wrappee__ShuffleRepeatTest5();
			next__wrappee__ShuffleRepeatTest4();
			next__wrappee__ShuffleRepeatTest3();
			next__wrappee__ShuffleRepeatTest2();
			next__wrappee__ShuffleRepeatTest();
		}
	}

	 @Test
	public void nextTest3() throws Exception {
//		Configuration.queuetrack = true;
//		Configuration.playlist = true;
		if (Configuration.queuetrack && Configuration.playlist) {
			playlist = new Playlist();
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "queue").set(playlist, null);
			playlist.next(true);
			List queue = (List) MemberModifier.field(Playlist.class, "queue").get(playlist);
			List track = (List) MemberModifier.field(Playlist.class, "tracks").get(playlist);

			assertTrue(track.size()>0);
		}
	}

	@Test
	public void getModeTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {

			playlist = new Playlist();
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "mode").set(playlist, PlayMode.RepeatAll);

			assertEquals(playlist.getMode(), PlayMode.RepeatAll);
		}
	}

	@Test
	public void moveUpTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			int previous = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			playlist.moveUp(1);
			int later = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			assertNotEquals(previous, later);
		}
	}

	@Test
	public void moveDownTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			playlist.addTrack(new TrackMetadata());
			int previous = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			playlist.moveDown(0);
			int later = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			System.err.println(previous + " " + later);
			assertNotEquals(previous, later);
		}
	}

	@Test
	public void sortListTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();

			TrackMetadata t1 = new TrackMetadata();
			t1.setTrackNumber(4);

			TrackMetadata t2 = new TrackMetadata();
			t2.setTrackNumber(3);

			TrackMetadata t3 = new TrackMetadata();
			t3.setTrackNumber(2);

			TrackMetadata t4 = new TrackMetadata();
			t4.setTrackNumber(1);

			playlist.addTrack(t1);
			playlist.addTrack(t2);
			playlist.addTrack(t3);
			playlist.addTrack(t4);

			int previous = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			playlist.sortList();
			int later = (int) MemberModifier.field(Playlist.class, "position").get(playlist);
			List latertracks = (List) MemberModifier.field(Playlist.class, "tracks").get(playlist);

			assertTrue((TrackMetadata) latertracks.get(0) == t4);
			assertTrue((TrackMetadata) latertracks.get(1) == t3);
			assertTrue((TrackMetadata) latertracks.get(2) == t2);
			assertTrue((TrackMetadata) latertracks.get(3) == t1);
			assertNotEquals(previous, later);
		}
	}

	@Test
	public void goToTest() {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();

			TrackMetadata t1 = new TrackMetadata();
			t1.setTrackNumber(4);

			TrackMetadata t2 = new TrackMetadata();
			t2.setTrackNumber(3);

			TrackMetadata t3 = new TrackMetadata();
			t3.setTrackNumber(2);

			TrackMetadata t4 = new TrackMetadata();
			t4.setTrackNumber(1);

			playlist.addTrack(t1);
			playlist.addTrack(t2);
			playlist.addTrack(t3);
			playlist.addTrack(t4);

			assertTrue(playlist.goTo(0) == t1);
			assertTrue(playlist.goTo(1) == t2);
			assertTrue(playlist.goTo(2) == t3);
			assertTrue(playlist.goTo(3) == t4);
		}
	}

	@Test
	public void queue_queueNULL_TrackTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();
			playlist.addTrack(new TrackMetadata());
			MemberModifier.field(Playlist.class, "queue").set(playlist, null);
			playlist.queueTrack(0);
			List queue = (List) MemberModifier.field(Playlist.class, "queue").get(playlist);
			assertNotNull(queue);
		}
	}

	@Test
	public void queueTrackTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();

			TrackMetadata t1 = new TrackMetadata();
			t1.setTrackNumber(4);

			TrackMetadata t2 = new TrackMetadata();
			t2.setTrackNumber(3);

			TrackMetadata t3 = new TrackMetadata();
			t3.setTrackNumber(2);

			TrackMetadata t4 = new TrackMetadata();
			t4.setTrackNumber(1);

			playlist.addTrack(t1);
			playlist.addTrack(t2);
			playlist.addTrack(t3);
			playlist.addTrack(t4);

			playlist.queueTrack(0);

			List queue = (List) MemberModifier.field(Playlist.class, "queue").get(playlist);
			assertTrue(queue.get(0) == t1);
		}
	}

	@Test
	public void queueTrack_containsTrack_Test() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();

			TrackMetadata t1 = new TrackMetadata();
			t1.setTrackNumber(4);

			TrackMetadata t2 = new TrackMetadata();
			t2.setTrackNumber(3);

			TrackMetadata t3 = new TrackMetadata();
			t3.setTrackNumber(2);

			TrackMetadata t4 = new TrackMetadata();
			t4.setTrackNumber(1);

			playlist.addTrack(t1);
			playlist.addTrack(t2);
			playlist.addTrack(t3);
			playlist.addTrack(t4);

			playlist.queueTrack(0);
			List queue = (List) MemberModifier.field(Playlist.class, "queue").get(playlist);
			System.err.println(queue);

			playlist.queueTrack(0);
			System.err.println(queue);
			assertTrue(queue.size() == 0);
		}
	}

	@Test
	public void setModeTest() {
//		Configuration.playlist = true;
		if (Configuration.playlist) {
			playlist = new Playlist();

		    playlist.setMode(PlayMode.RepeatOne);
		    assertEquals(PlayMode.RepeatOne, playlist.getMode());
		}
	}
	@Test
	public void next4_Test() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.playlist = true;
//		Configuration.queuetrack=true;
		if (Configuration.playlist && Configuration.queuetrack) {
			playlist = new Playlist();

			TrackMetadata t1 = new TrackMetadata();
			t1.setTrackNumber(4);

			TrackMetadata t2 = new TrackMetadata();
			t2.setTrackNumber(3);

			TrackMetadata t3 = new TrackMetadata();
			t3.setTrackNumber(2);

			TrackMetadata t4 = new TrackMetadata();
			t4.setTrackNumber(1);

			playlist.addTrack(t1);
			playlist.addTrack(t2);
			playlist.addTrack(t3);
			playlist.addTrack(t4);

			playlist.queueTrack(0);
			
			playlist.next(true);
			
			List queue = (List) MemberModifier.field(Playlist.class, "queue").get(playlist);
			System.err.println(queue);

			playlist.queueTrack(0);
			System.err.println(queue);
			assertTrue(queue.size() != 0);
		}
	}
}
