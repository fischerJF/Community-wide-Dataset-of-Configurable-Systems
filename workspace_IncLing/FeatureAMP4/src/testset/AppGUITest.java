package testset;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import featureAMP.FeatureAmp;
import featureAMP.PlayerBar;
import featureAMP.PlayerControl;
import featureAMP.ProgressBar;
import featureAMP.ShowCover;
import featureAMP.TitleTimeListener;
import featureAMP.VolumeControl;
import specifications.Configuration;

import static org.junit.Assert.assertTrue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JToggleButton;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import org.fest.swing.fixture.FrameFixture;

public class AppGUITest {

	private FrameFixture demo;
	private FeatureAmp gui;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
		if(demo!=null)
		demo.cleanUp();
	}

	@Test
	public void playOGGTest() throws Exception {
//		Configuration.base_featureamp=true;
//		Configuration.file_support=true;
//		Configuration.ogg=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.id3_title=true;
//		Configuration.player_bar=true;
//		Configuration.progress=true;
//		Configuration.title_time=true;
//		
		
		if (Configuration.base_featureamp &&
				Configuration.file_support &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.id3_title &&
				Configuration.player_bar &&
				Configuration.progress &&
				Configuration.title_time) {
			start();
			PlayerBar pb = (PlayerBar) MemberModifier.field(FeatureAmp.class, "playerBar").get(gui);
			
			JButton play = (JButton) MemberModifier.field(PlayerBar.class, "playButton").get(pb);
			JButton pause = (JButton) MemberModifier.field(PlayerBar.class, "pauseButton").get(pb);
			JButton stop = (JButton) MemberModifier.field(PlayerBar.class, "stopButton").get(pb);
			
			assertFalse(play.isEnabled());
			assertFalse(pause.isEnabled());
			assertFalse(stop.isEnabled());
			
			
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("hollow.ogg");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			assertEquals(play.getName(), "play");
			assertEquals(play.getText(),"Play");
			assertFalse(play.isEnabled());
			assertTrue(pause.isEnabled());
			assertTrue(stop.isEnabled());
			
			demo.button("pause").click();
			assertEquals(pause.getName(), "pause");
			assertEquals(pause.getText(),"Pause");
			assertFalse(pause.isEnabled());
			assertFalse(pause.isEnabled());
			assertTrue(stop.isEnabled());
			assertTrue(play.isEnabled());
			
			demo.button("play").click();
			demo.button("stop").click();
			assertEquals(stop.getName(), "stop");
			assertEquals(stop.getText(),"Stop");
			assertFalse(stop.isEnabled());
		}
	}
	@Test
	public void playMP3Test() throws Exception {
//		 Configuration.base_featureamp=true;
//		 Configuration.file_support=true;
//		 Configuration.mp3=true;
//		 Configuration.skins=true;
//		 Configuration.light=true;
//		 Configuration.id3_title=true;
//		 Configuration.player_bar=true;
//		 Configuration.progress=true;
//		 Configuration.title_time=true;
//	
		
		if (Configuration.base_featureamp &&
				 Configuration.file_support &&
				 Configuration.mp3 &&
				 Configuration.skins &&
				 Configuration.light &&
				 Configuration.id3_title &&
				 Configuration.player_bar &&
				 Configuration.progress &&
				 Configuration.title_time) {
			start();
			PlayerBar pb = (PlayerBar) MemberModifier.field(FeatureAmp.class, "playerBar").get(gui);
			
			JButton play = (JButton) MemberModifier.field(PlayerBar.class, "playButton").get(pb);
			JButton pause = (JButton) MemberModifier.field(PlayerBar.class, "pauseButton").get(pb);
			JButton stop = (JButton) MemberModifier.field(PlayerBar.class, "stopButton").get(pb);

			assertFalse(play.isEnabled());
			assertFalse(pause.isEnabled());
			assertFalse(stop.isEnabled());

			
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			assertEquals(play.getName(), "play");
			assertEquals(play.getText(),"Play");
			assertFalse(play.isEnabled());
			assertTrue(pause.isEnabled());
			assertTrue(stop.isEnabled());
			
			demo.button("pause").click();
			assertEquals(pause.getName(), "pause");
			assertEquals(pause.getText(),"Pause");
			assertFalse(pause.isEnabled());
			assertFalse(pause.isEnabled());
			assertTrue(stop.isEnabled());
			assertTrue(play.isEnabled());
			
			demo.button("play").click();
			demo.button("stop").click();
			assertEquals(stop.getName(), "stop");
			assertEquals(stop.getText(),"Stop");
			assertFalse(stop.isEnabled());
		}
	}
	@Test
	public void muteTest() throws Exception {
//		Configuration.base_featureamp=true;
//		Configuration.file_support=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.id3_title=true;
//		Configuration.player_bar=true;
//		Configuration.progress=true;
//		Configuration.title_time=true;
//		Configuration.volume_control=true;
//		Configuration.mute=true;
		
		
		if (Configuration.base_featureamp &&
				Configuration.file_support &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.id3_title &&
				Configuration.player_bar &&
				Configuration.progress &&
				Configuration.volume_control &&
				Configuration.mute &&
				Configuration.title_time) {
			start();
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			VolumeControl volumeControl = (VolumeControl) MemberModifier.field(FeatureAmp.class, "volumeControl").get(gui);
			demo.toggleButton("mute").click();
			JToggleButton mute = (JToggleButton) MemberModifier.field(VolumeControl.class, "muteButton").get(volumeControl);
			assertEquals(mute.getName(), "mute");
			assertTrue(mute.isEnabled());
			
			
		}
	}
	@Test
	public void volumecontrolTest() throws Exception {
//	  	 Configuration.base_featureamp=true;
//		 Configuration.file_support=true;
//		 Configuration.mp3=true;
//		 Configuration.skins=true;
//		 Configuration.light=true;
//		 Configuration.id3_title=true;
//		 Configuration.player_bar=true;
//		 Configuration.progress=true;
//		 Configuration.title_time=true;
//		 Configuration.volume_control=true;
	
		
		if (Configuration.base_featureamp &&
				 Configuration.file_support &&
				 Configuration.mp3 &&
				 Configuration.skins &&
				 Configuration.light &&
				 Configuration.id3_title &&
				 Configuration.player_bar &&
				 Configuration.progress &&
				 Configuration.volume_control &&
				 Configuration.title_time) {
			start();
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			VolumeControl volumeControl = (VolumeControl) MemberModifier.field(FeatureAmp.class, "volumeControl").get(gui);
			
			JButton less_volume = (JButton) MemberModifier.field(VolumeControl.class, "quieterButton").get(volumeControl);
			assertEquals(less_volume.getName(),"less_volume");
			assertTrue(less_volume.isEnabled());
			JButton more_volume = (JButton) MemberModifier.field(VolumeControl.class, "louderButton").get(volumeControl);
			assertFalse(more_volume.isEnabled());

			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			assertEquals(more_volume.getName(),"more_volume");
			assertTrue(more_volume.isEnabled());

			JLabel percent = (JLabel) MemberModifier.field(VolumeControl.class, "percentLabel").get(volumeControl);
			assertEquals(percent.getText(),"75 %");
			demo.button("more_volume").click();
			demo.button("more_volume").click();
			demo.button("more_volume").click();
			demo.button("more_volume").click();
			demo.button("more_volume").click();
			assertEquals(percent.getText(),"100 %");
		  
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
	
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
	
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
	
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			assertEquals(percent.getText(),"0 %");
			assertFalse(less_volume.isEnabled());
			
		}
	}
	@Test
	public void progressBarTest() throws Exception {
//		 Configuration.base_featureamp=true;
//		 Configuration.file_support=true;
//		 Configuration.mp3=true;
//		 Configuration.skins=true;
//		 Configuration.light=true;
//		 Configuration.id3_title=true;
//		 Configuration.player_bar=true;
//		 Configuration.progress=true;
//		 Configuration.progress_bar=true;
	
		
		if (Configuration.base_featureamp &&
				 Configuration.file_support &&
				 Configuration.mp3 &&
				 Configuration.skins &&
				 Configuration.light &&
				 Configuration.id3_title &&
				 Configuration.player_bar &&
				 Configuration.progress &&
				 Configuration.progress_bar ) {	
			start();
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
		
			ProgressBar pb= new ProgressBar(gui);
			JProgressBar progressBar = (JProgressBar) MemberModifier.field(ProgressBar.class, "progressBar").get(pb);
			assertEquals(progressBar.getName(), "progress");
			demo.progressBar("progress").requireValue(0);
		}
	}
	@Test
	public void showtimeTest() throws Exception {
//		 Configuration.base_featureamp=true;
//		 Configuration.file_support=true;
//		 Configuration.mp3=true;
//		 Configuration.skins=true;
//		 Configuration.light=true;
//		 Configuration.id3_title=true;
//		 Configuration.player_bar=true;
//		 Configuration.progress=true;
//		 Configuration.title_time=true;
		
		
		if (Configuration.base_featureamp &&
				 Configuration.file_support &&
				 Configuration.mp3 &&
				 Configuration.skins &&
				 Configuration.light &&
				 Configuration.id3_title &&
				 Configuration.player_bar &&
				 Configuration.progress &&
				 Configuration.title_time) {	
			
			start();
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			JFrame frame = (JFrame) MemberModifier.field(FeatureAmp.class, "frame").get(gui);
			assertTrue(frame.getTitle().contains("Mariana Aydar"));
			assertTrue(frame.getTitle().contains("Na Gangorra"));
			
		}
	}
	@Test
	public void showCoverTest() throws Exception {
//		 Configuration.base_featureamp=true;
//		 Configuration.file_support=true;
//		 Configuration.mp3=true;
//		 Configuration.skins=true;
//		 Configuration.light=true;
//		 Configuration.id3_title=true;
//		 Configuration.player_bar=true;
//		 Configuration.progress=true;
//		 Configuration.title_time=true;
//		 Configuration.show_cover=true;
	
		
		if (Configuration.base_featureamp &&
				 Configuration.file_support &&
				 Configuration.mp3 &&
				 Configuration.skins &&
				 Configuration.light &&
				 Configuration.id3_title &&
				 Configuration.player_bar &&
				 Configuration.progress &&
				 Configuration.show_cover &&
				 Configuration.title_time) {	
			
			start();
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
		
			ShowCover sc= new ShowCover(gui);
			JPanel panel = (JPanel) MemberModifier.field(ShowCover.class, "imagePanel").get(sc);
			JLabel noCoverLabel = (JLabel) MemberModifier.field(ShowCover.class, "noCoverLabel").get(sc);
			assertTrue(panel != null);
			assertTrue(panel.getPreferredSize().getHeight()==200);
			assertTrue(panel.getPreferredSize().getWidth()==200);
			
			assertTrue(noCoverLabel != null);
			assertEquals(noCoverLabel.getText(), "kein AlbumArt vorhanden");
			assertEquals(noCoverLabel.getHorizontalAlignment(), JLabel.CENTER);
			
		}
	}
	
	@Test
	public void removeTrackTest() throws Exception {
//		Configuration.base_featureamp=true;
//		Configuration.file_support=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.id3_title=true;
//		Configuration.player_bar=true;
//		Configuration.progress=true;
//		Configuration.playlist=true;
//		Configuration.player_control=true;
//		Configuration.remove_track=true;
		
		
		if (Configuration.base_featureamp &&
				Configuration.file_support &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.id3_title &&
				Configuration.player_bar &&
				Configuration.progress &&
				Configuration.playlist &&
				Configuration.remove_track &&
				Configuration.player_control) {	
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.table("p_list").click();
			demo.button("remove").click();
			
			demo.table("p_list").click();
			demo.button("remove").click();
			
			demo.table("p_list").click();
			demo.button("remove").click();
			PlayerControl playerControl = (PlayerControl) MemberModifier.field(FeatureAmp.class, "playerControl").get(gui);
			
			JButton remove = (JButton) MemberModifier.field(PlayerControl.class, "removeButton").get(playerControl);
			assertEquals(remove.getName(), "remove");
			assertEquals(remove.getText(),"– Track");
		}
	}
	@Test
	public void reorderPlaylistTest() throws Exception {
//		Configuration.base_featureamp=true;
//		Configuration.file_support=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.id3_title=true;
//		Configuration.player_bar=true;
//		Configuration.progress=true;
//		Configuration.playlist=true;
//		Configuration.player_control=true;
//		Configuration.reorder_playlist=true;
		
		
		if (Configuration.base_featureamp &&
				Configuration.file_support &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.id3_title &&
				Configuration.player_bar &&
				Configuration.progress &&
				Configuration.playlist &&
				Configuration.player_control &&
				Configuration.reorder_playlist) {	
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.table("p_list").click();
			demo.button("up").click();
			
			demo.table("p_list").click();
			demo.button("down").click();
			
			PlayerControl playerControl = (PlayerControl) MemberModifier.field(FeatureAmp.class, "playerControl").get(gui);
			
			JButton up = (JButton) MemberModifier.field(PlayerControl.class, "upButton").get(playerControl);
			assertEquals(up.getName(), "up");
			assertEquals(up.getText(),"auf");
			assertTrue(up.getComponentListeners()!= null);

			JButton down = (JButton) MemberModifier.field(PlayerControl.class, "downButton").get(playerControl);
			assertEquals(down.getName(), "down");
			assertEquals(down.getText(),"ab");
			assertTrue(down.getComponentListeners()!= null);
		}
	}
	@Test
	public void skipTrackTest() throws Exception {
//		Configuration.base_featureamp=true;
//		Configuration.file_support=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.id3_title=true;
//		Configuration.player_bar=true;
//		Configuration.progress=true;
//		Configuration.playlist=true;
//		Configuration.player_control=true;
//		Configuration.skip_track=true;
		
		
		if (Configuration.base_featureamp &&
				Configuration.file_support &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.id3_title &&
				Configuration.player_bar &&
				Configuration.progress &&
				Configuration.playlist &&
				Configuration.skip_track &&
				Configuration.player_control) {	
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.button("skip").click();
			PlayerControl playerControl = (PlayerControl) MemberModifier.field(FeatureAmp.class, "playerControl").get(gui);
			
			JButton remove = (JButton) MemberModifier.field(PlayerControl.class, "skipButton").get(playerControl);
			assertEquals(remove.getName(), "skip");
			assertEquals(remove.getText(),"Skip");
		}
	}
	
	@Test
	public void clearTrackTest() throws Exception {
//		 Configuration.base_featureamp=true;
//		 Configuration.file_support=true;
//		 Configuration.mp3=true;
//		 Configuration.skins=true;
//		 Configuration.light=true;
//		 Configuration.id3_title=true;
//		 Configuration.player_bar=true;
//		 Configuration.progress=true;
//		 Configuration.playlist=true;
//		 Configuration.player_control=true;
//		 Configuration.remove_track=true;
//		 Configuration.clear_playlist=true;
	
		
		if (Configuration.base_featureamp &&
				 Configuration.file_support &&
				 Configuration.mp3 &&
				 Configuration.skins &&
				 Configuration.light &&
				 Configuration.id3_title &&
				 Configuration.player_bar &&
				 Configuration.progress &&
				 Configuration.playlist &&
				 Configuration.remove_track &&
				 Configuration.clear_playlist &&
				 Configuration.player_control) {	
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.button("clear").click();
			PlayerControl playerControl = (PlayerControl) MemberModifier.field(FeatureAmp.class, "playerControl").get(gui);

			JButton remove = (JButton) MemberModifier.field(PlayerControl.class, "clearButton").get(playerControl);
			assertEquals(remove.getName(), "clear");
			assertEquals(remove.getText(),"Clear");
		}
	}
	
	@Test
	public void playModeTest() throws Exception {
//	     Configuration.base_featureamp=true;
//		 Configuration.file_support=true;
//		 Configuration.mp3=true;
//		 Configuration.skins=true;
//		 Configuration.light=true;
//		 Configuration.id3_title=true;
//		 Configuration.player_bar=true;
//		 Configuration.progress=true;
//		 Configuration.playlist=true;
//		 Configuration.player_control=true;
//		 Configuration.shuffle_repeat=true;
	
	
		
		if (Configuration.base_featureamp &&
				 Configuration.file_support &&
				 Configuration.mp3 &&
				 Configuration.skins &&
				 Configuration.light &&
				 Configuration.id3_title &&
				 Configuration.player_bar &&
				 Configuration.progress &&
				 Configuration.playlist &&
				 Configuration.shuffle_repeat &&
				 Configuration.player_control) {	
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("Datei", "Datei öffnen...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			PlayerControl playerControl = (PlayerControl) MemberModifier.field(FeatureAmp.class, "playerControl").get(gui);
			JButton button = (JButton) MemberModifier.field(PlayerControl.class, "shuffleButton").get(playerControl);
		

			demo.button("playModeButton").click();
			demo.button("playModeButton").click();
			demo.button("playModeButton").click();
			demo.button("playModeButton").click();
			demo.button("playModeButton").click();
			
		}
	}
	
	private void start() throws Exception{
		gui = new FeatureAmp();		
		JFrame frame = (JFrame) MemberModifier.field(FeatureAmp.class, "frame").get(gui);
		demo = new FrameFixture(frame);
	}
}
