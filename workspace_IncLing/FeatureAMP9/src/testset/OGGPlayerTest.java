package testset;

import static org.junit.Assert.*;


import java.io.IOException;

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
import players.OGGPlayer;
import players.TrackMetadata;
import players.Player.State;
import players.PlayerFileFilter;

import specifications.Configuration;

public class OGGPlayerTest {

	private OGGPlayer ogg;

	@Before
	public void setUp() {

	}

	//@Test
	public void OGGPlayerTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException  {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
		if (!Configuration.mp3 && Configuration.ogg) {
			ogg = new OGGPlayer("media/hollow.ogg");
			AudioInputStream audioStream = (AudioInputStream) MemberModifier.field(OGGPlayer.class, "audioStream")
					.get(ogg);
			assertNotNull(audioStream);
			String filename = (String) MemberModifier.field(OGGPlayer.class, "filename").get(ogg);
			assertEquals(filename, "media/hollow.ogg");
			Clip clip = (Clip) MemberModifier.field(OGGPlayer.class, "clip").get(ogg);
			assertNotNull(clip);
			FloatControl volume= (FloatControl) MemberModifier.field(OGGPlayer.class, "volume").get(ogg);
			assertNotNull(volume);
		}
	}
	//@Test
	public void OGGPlayerTest2() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
	IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
		if (!Configuration.mp3 && !Configuration.ogg) {
			ogg = new OGGPlayer("media/hollow.ogg");
			AudioInputStream audioStream = (AudioInputStream) MemberModifier.field(OGGPlayer.class, "audioStream")
					.get(ogg);
			assertNull(audioStream);
			String filename = (String) MemberModifier.field(OGGPlayer.class, "filename").get(ogg);
			assertNotEquals(filename, "media/hollow.ogg");
			Clip clip = (Clip) MemberModifier.field(OGGPlayer.class, "clip").get(ogg);
			assertNull(clip);
			FloatControl volume= (FloatControl) MemberModifier.field(OGGPlayer.class, "volume").get(ogg);
			assertNull(volume);
		}
	}
	
	@Test
	public void OGGPlayerTest3() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
			IllegalArgumentException, IllegalAccessException {
		
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
		if (!Configuration.mp3 && Configuration.ogg) {
			TrackMetadata track= new TrackMetadata();
			track.setFileName("media/hollow.ogg");
			ogg = new OGGPlayer(track);
			AudioInputStream audioStream = (AudioInputStream) MemberModifier.field(OGGPlayer.class, "audioStream")
					.get(ogg);
			assertNotNull(audioStream);
			String filename = (String) MemberModifier.field(OGGPlayer.class, "filename").get(ogg);
			assertEquals(filename, "media/hollow.ogg");
			Clip clip = (Clip) MemberModifier.field(OGGPlayer.class, "clip").get(ogg);
			assertNotNull(clip);
			FloatControl volume= (FloatControl) MemberModifier.field(OGGPlayer.class, "volume").get(ogg);
			assertNotNull(volume);
			
			TrackMetadata metadata= (TrackMetadata) MemberModifier.field(OGGPlayer.class, "metadata").get(ogg);
            assertEquals(metadata.getRuntime(),2);
		}
	}
	
//	@Test
//	public void playTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			ogg.play();
//			State playerStatus= (State) MemberModifier.field(OGGPlayer.class, "playerStatus").get(ogg);
//			assertTrue(playerStatus == State.PLAYING);
//			
//			ogg.play();
//			Clip clip = (Clip) MemberModifier.field(OGGPlayer.class, "clip").get(ogg);
//			assertEquals(clip.getFramePosition(),0);  
//			assertTrue(playerStatus == State.PLAYING);
//		}
//	}
//	@Test
//	public void playTest2() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			MemberModifier.field(OGGPlayer.class, "playerStatus").set(ogg,State.PLAYING);
//			ogg.play();
//			ogg.stop();
//			ogg.play();
//			
//			State playerStatus= (State)  MemberModifier.field(OGGPlayer.class, "playerStatus").get(ogg);
//			Clip clip = (Clip) MemberModifier.field(OGGPlayer.class, "clip").get(ogg);
//			assertEquals(clip.getFramePosition(),0);  
////			assertTrue(clip.isRunning());
//			assertTrue(playerStatus == State.PLAYING);
//		}
//	}
//	@Test
//	public void pauseTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			MemberModifier.field(OGGPlayer.class, "playerStatus").set(ogg,State.PLAYING);
//			ogg.pause();
//			
//			State playerStatus= (State)  MemberModifier.field(OGGPlayer.class, "playerStatus").get(ogg);
//			Clip clip = (Clip) MemberModifier.field(OGGPlayer.class, "clip").get(ogg);
//			assertFalse(clip.isRunning());  
//			assertTrue(playerStatus == State.PAUSED);
//		}
//	}
//
//	@Test
//	public void resumeTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			MemberModifier.field(OGGPlayer.class, "playerStatus").set(ogg,State.PAUSED);
//			ogg.resume();
//			
//			State playerStatus= (State)  MemberModifier.field(OGGPlayer.class, "playerStatus").get(ogg);
//			Clip clip = (Clip) MemberModifier.field(OGGPlayer.class, "clip").get(ogg);
//         //   assertTrue(clip.isRunning());  
//			assertTrue(playerStatus == State.PLAYING);
//		}
//	}
//	
//	@Test
//	public void stopTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			MemberModifier.field(OGGPlayer.class, "playerStatus").set(ogg,State.PLAYING);
//			
//			ogg.stop();
//			
//			State playerStatus= (State)  MemberModifier.field(OGGPlayer.class, "playerStatus").get(ogg);
//			Clip clip = (Clip) MemberModifier.field(OGGPlayer.class, "clip").get(ogg);
//			assertEquals(clip.getFramePosition(),0);  
//			assertFalse(clip.isRunning());
//			assertTrue(playerStatus == State.READY);
//		}
//	}
//	
//	@Test
//	public void closeTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			MemberModifier.field(OGGPlayer.class, "playerStatus").set(ogg,State.PLAYING);
//			
//			ogg.close();
//			
//			State playerStatus= (State)  MemberModifier.field(OGGPlayer.class, "playerStatus").get(ogg);
//			Clip clip = (Clip) MemberModifier.field(OGGPlayer.class, "clip").get(ogg);
//			assertNull(clip);  
//			
//			FloatControl volume= (FloatControl) MemberModifier.field(OGGPlayer.class, "volume").get(ogg);
//			assertNull(volume);  
//			
//			
//		}
//	}
//	@Test
//	public void setVolumeTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			MemberModifier.field(OGGPlayer.class, "playerStatus").set(ogg,State.PLAYING);
//			
//			ogg.setVolume(50);
//			
//			FloatControl volume= (FloatControl) MemberModifier.field(OGGPlayer.class, "volume").get(ogg);
//			assertNotNull(volume);  
//			float v=(float) -6.0206;
//			assertTrue(volume.getValue()==v);
//			System.out.println(volume.getValue());
//		}
//	}
//	
//	@Test
//	public void positionTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			MemberModifier.field(OGGPlayer.class, "playerStatus").set(ogg,State.PLAYING);
//			assertTrue(ogg.position()==0);
//		}
//	}
//	
//	@Test
//	public void getTrackMetadataTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			TrackMetadata track= new TrackMetadata();
//			track.setFileName("media/hollow.ogg");
//			ogg = new OGGPlayer(track);
//			MemberModifier.field(OGGPlayer.class, "playerStatus").set(ogg,State.PLAYING);
//			assertTrue(ogg.getTrackMetadata()==track);
//		}
//	}
//	@Test
//	public void getTrackMetadataTest2() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			
//			TrackMetadata metadata= (TrackMetadata) MemberModifier.field(OGGPlayer.class, "metadata").get(ogg);
//			
//			assertNotNull(ogg.getTrackMetadata());
//		}
//	}
//	@Test
//	public void getFileFilterTest() throws UnsupportedAudioFileException, IOException, LineUnavailableException, IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		Configuration.mp3 = false;
//		if (!Configuration.mp3 && Configuration.ogg) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			
////			TrackMetadata metadata= (TrackMetadata) MemberModifier.field(OGGPlayer.class, "metadata").get(ogg);
//			assertTrue( OGGPlayer.getFileFilter() instanceof PlayerFileFilter);
//		}
//	}
//	@Test
//	public void getState() throws UnsupportedAudioFileException, IOException, LineUnavailableException,
//	IllegalArgumentException, IllegalAccessException {
//		Configuration.ogg = true;
//		if (Configuration.mp3) {
//			ogg = new OGGPlayer("media/hollow.ogg");
//			assertEquals(ogg.getState(), State.READY);
//		}
//	}
//	
}
