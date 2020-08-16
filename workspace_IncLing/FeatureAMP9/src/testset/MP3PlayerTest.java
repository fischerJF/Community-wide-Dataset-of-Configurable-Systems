package testset;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import players.MP3Player;
import players.TrackMetadata;
import players.Player.State;
import players.PlayerFileFilter;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class MP3PlayerTest {

	private MP3Player mp3;

	@Before
	public void setUp() {

	}

	@Test
	public void MP3PlayerTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			AudioInputStream audioStream = (AudioInputStream) MemberModifier.field(MP3Player.class, "audioStream")
					.get(mp3);
			assertNotNull(audioStream);
			String filename = (String) MemberModifier.field(MP3Player.class, "filename").get(mp3);
			assertEquals(filename, "media/note.mp3");
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertNotNull(clip);
			FloatControl volume = (FloatControl) MemberModifier.field(MP3Player.class, "volume").get(mp3);
			assertNotNull(volume);
		}
	}

	@Test
	public void MP3PlayerTest2() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = false;
		if (!Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			AudioInputStream audioStream = (AudioInputStream) MemberModifier.field(MP3Player.class, "audioStream")
					.get(mp3);
			assertNull(audioStream);
			String filename = (String) MemberModifier.field(MP3Player.class, "filename").get(mp3);
			assertNotEquals(filename, "media/note.mp3");
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertNull(clip);
			FloatControl volume = (FloatControl) MemberModifier.field(MP3Player.class, "volume").get(mp3);
			assertNull(volume);
		}
	}

	@Test
	public void MP3PlayerTest3() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {

//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			TrackMetadata track = new TrackMetadata();
			track.setFileName("media/note.mp3");
			mp3 = new MP3Player(track);
			AudioInputStream audioStream = (AudioInputStream) MemberModifier.field(MP3Player.class, "audioStream")
					.get(mp3);
			assertNotNull(audioStream);
			String filename = (String) MemberModifier.field(MP3Player.class, "filename").get(mp3);
			assertEquals(filename, "media/note.mp3");
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertNotNull(clip);
			FloatControl volume = (FloatControl) MemberModifier.field(MP3Player.class, "volume").get(mp3);
			assertNotNull(volume);

			TrackMetadata metadata = (TrackMetadata) MemberModifier.field(MP3Player.class, "metadata").get(mp3);
			assertEquals(metadata.getRuntime(), 4);
		}
	}

	@Test
	public void playTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			mp3.play();
			State playerStatus = (State) MemberModifier.field(MP3Player.class, "playerStatus").get(mp3);
			assertTrue(playerStatus == State.PLAYING);

			mp3.play();
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertEquals(clip.getFramePosition(), 0);
			assertTrue(playerStatus == State.PLAYING);
		}
	}

	@Test
	public void playTest2() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3, State.PLAYING);
			mp3.play();
			mp3.stop();
			mp3.play();

			State playerStatus = (State) MemberModifier.field(MP3Player.class, "playerStatus").get(mp3);
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertEquals(clip.getFramePosition(), 0);
//			assertTrue(clip.isRunning());
			assertTrue(playerStatus == State.PLAYING);
		}
	}

	@Test
	public void pauseTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3, State.PLAYING);
			mp3.pause();

			State playerStatus = (State) MemberModifier.field(MP3Player.class, "playerStatus").get(mp3);
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertFalse(clip.isRunning());
			assertTrue(playerStatus == State.PAUSED);
		}
	}

	@Test
	public void resumeTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3, State.PAUSED);
			mp3.resume();

			State playerStatus = (State) MemberModifier.field(MP3Player.class, "playerStatus").get(mp3);
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			// assertTrue(clip.isRunning());
			assertTrue(playerStatus == State.PLAYING);
		}
	}

	@Test
	public void stopTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3, State.PLAYING);

			mp3.stop();

			State playerStatus = (State) MemberModifier.field(MP3Player.class, "playerStatus").get(mp3);
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertEquals(clip.getFramePosition(), 0);
			assertFalse(clip.isRunning());
			assertTrue(playerStatus == State.READY);
		}
	}

	@Test
	public void closeTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3, State.PLAYING);

			mp3.close();

			State playerStatus = (State) MemberModifier.field(MP3Player.class, "playerStatus").get(mp3);
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertNull(clip);

			FloatControl volume = (FloatControl) MemberModifier.field(MP3Player.class, "volume").get(mp3);
			assertNull(volume);

		}
	}

	@Test
	public void setVolumeTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3, State.PLAYING);

			mp3.setVolume(50);

			FloatControl volume = (FloatControl) MemberModifier.field(MP3Player.class, "volume").get(mp3);
			assertNotNull(volume);
			float v = (float) -6.0206;
			assertTrue(volume.getValue() == v);
			System.out.println(volume.getValue());
		}
	}

	@Test
	public void positionTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3, State.PLAYING);
			assertTrue(mp3.position() == 0);
		}
	}

	@Test
	public void getTrackMetadataTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			TrackMetadata track = new TrackMetadata();
			track.setFileName("media/note.mp3");
			mp3 = new MP3Player(track);
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3, State.PLAYING);
			assertTrue(mp3.getTrackMetadata() == track);
		}
	}

	@Test
	public void getTrackMetadataTest2() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");

			TrackMetadata metadata = (TrackMetadata) MemberModifier.field(MP3Player.class, "metadata").get(mp3);

			assertNotNull(mp3.getTrackMetadata());
		}
	}

	@Test
	public void getFileFilterTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");

			// TrackMetadata metadata= (TrackMetadata) MemberModifier.field(MP3Player.class,
			// "metadata").get(mp3);
			assertTrue(MP3Player.getFileFilter() instanceof PlayerFileFilter);
		}
	}

	@Test
	public void getState() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
	IllegalArgumentException, IllegalAccessException {
//		Configuration.mp3 = true;
		if (Configuration.mp3) {
			mp3 = new MP3Player("media/note.mp3");
			assertEquals(mp3.getState(), State.READY);
		}
	}

}
