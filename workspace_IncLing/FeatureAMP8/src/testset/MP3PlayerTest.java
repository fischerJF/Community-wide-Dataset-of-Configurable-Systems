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

import engine.MP3Player;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class MP3PlayerTest {

	private MP3Player mp3;

	@Before
	public void setUp() {

	}

	@Test
	public void MP3PlayerTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException  {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			mp3 = new MP3Player("media/note.mp3");
			AudioInputStream audioStream = (AudioInputStream) MemberModifier.field(MP3Player.class, "audioStream")
					.get(mp3);
			assertNotNull(audioStream);
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertNotNull(clip);
			
		}
	}

	@Test
	public void MP3PlayerTest2() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException   {
//		Configuration.featureamp = false;
		if (!Configuration.featureamp) {
			mp3 = new MP3Player("media/note.mp3");
			AudioInputStream audioStream = (AudioInputStream) MemberModifier.field(MP3Player.class, "audioStream")
					.get(mp3);
			assertNull(audioStream);
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertNull(clip);
			
		}
	}
	@Test
	public void playTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			mp3 = new MP3Player("media/note.mp3");
			mp3.play();
			
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
		
//			assertTrue(clip.isActive());
			assertTrue(clip.isOpen());
			int playerStatus=(int)MemberModifier.field(MP3Player.class, "playerStatus").get(mp3);
			assertTrue(playerStatus == 1);
		}
	}


	@Test
	public void pauseTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			mp3 = new MP3Player("media/note.mp3");
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3, MP3Player.STATUS_PLAYING);
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			mp3.pause();
			assertFalse(clip.isRunning());
		    int playerStatus=(int)MemberModifier.field(MP3Player.class, "playerStatus").get(mp3);
			assertTrue(playerStatus == 2);
		}
	 }

	@Test
	public void resumeTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			mp3 = new MP3Player("media/note.mp3");
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3, MP3Player.STATUS_PAUSED);

			mp3.resume();
			
			
		    int playerStatus=(int)MemberModifier.field(MP3Player.class, "playerStatus").get(mp3);
			assertTrue(playerStatus == 1);
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
//			assertTrue(clip.isActive());
			}
	}

	@Test
	public void stopTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			mp3 = new MP3Player("media/note.mp3");
			
			mp3.stop();

			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertEquals(clip.getFramePosition(), 0);
			assertFalse(clip.isRunning());
			assertEquals(clip.getFramePosition(), 0);
			assertTrue(clip.getFramePosition()==0);
			int playerStatus=(int)MemberModifier.field(MP3Player.class, "playerStatus").get(mp3);
			assertTrue(playerStatus == 3);
		}
	}

	@Test
	public void closeTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			mp3 = new MP3Player("media/note.mp3");
			mp3.close();
			Clip clip = (Clip) MemberModifier.field(MP3Player.class, "clip").get(mp3);
			assertNotNull(clip);

			AudioInputStream audioStream = (AudioInputStream) MemberModifier.field(MP3Player.class, "audioStream").get(mp3);
			assertNull(audioStream);
		}
	}
    
	@Test
	public void getPlayerStatusTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			mp3 = new MP3Player("media/note.mp3");
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3,MP3Player.STATUS_FINISHED);
			assertEquals(mp3.getPlayerStatus(), 3);

			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3,MP3Player.STATUS_PAUSED);
			assertEquals(mp3.getPlayerStatus(), 2);

			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3,MP3Player.STATUS_PLAYING);
			assertEquals(mp3.getPlayerStatus(), 1);
		
			MemberModifier.field(MP3Player.class, "playerStatus").set(mp3,MP3Player.STATUS_READY);
			assertEquals(mp3.getPlayerStatus(), 0);
		}
	}
	
	@Test
	public void setLautstaerkeTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			mp3 = new MP3Player("media/note.mp3");
			mp3.setLautstaerke(100);
		     
		}
	}

}
