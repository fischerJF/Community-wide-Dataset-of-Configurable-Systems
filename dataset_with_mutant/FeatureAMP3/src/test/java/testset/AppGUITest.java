package testset;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import featureamp.FeatureAmp;
import featureamp.gui.IconButton;
import featureamp.playlist.PlaylistDataModel;
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
import javax.swing.text.TableView.TableCell;

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
		if(demo != null)
		demo.cleanUp();
	}

	@Test
	public void playMP3Test() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
  		Configuration.light=true;
  		Configuration.time=true;
  		Configuration.showtime=true;
	
		
		if (Configuration.filesupport &&
			Configuration.mp3 &&
			Configuration.featureamp &&
			Configuration.base &&
			Configuration.gui &&
			Configuration.skins &&
		  	Configuration.light &&
		  	Configuration.time &&
		  	Configuration.showtime) {
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			start();
			
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			assertTrue(os.toString().contains("File Loaded:"));		
			assertTrue(os.toString().contains("note.mp3"));		
			assertTrue(os.toString().contains("[Base] notifySongLoaded:"));		
        	assertTrue(os.toString().contains("[Base.playSong] Load:"));		
			demo.button("play").click();
			JButton play = (JButton) MemberModifier.field(FeatureAmp.class, "playButton").get(gui);
			assertEquals(play.getName(), "play");
			assertTrue(play.isEnabled());
			assertEquals(play.getText(),"\uF04B");
			
			demo.button("play").click();
			JButton pause = (JButton) MemberModifier.field(FeatureAmp.class, "playButton").get(gui);
			assertEquals(pause.getName(), "play");
			assertTrue(pause.isEnabled());
			assertEquals(pause.getText(),"\uF04C");
			
			demo.button("stop").click();
			
			JButton stop = (JButton) MemberModifier.field(FeatureAmp.class, "stopButton").get(gui);
			assertEquals(stop.getName(), "stop");
			assertTrue(stop.getPreferredSize().getWidth()==25);
			assertTrue(stop.getPreferredSize().getHeight()==25);
			assertFalse(stop.isEnabled());
            assertNotNull(stop.getComponentListeners());
			assertEquals(stop.getText(),"\uF04D");
			
		}
	}
	@Test
	public void playOGGTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.ogg=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
		Configuration.light=true;
		Configuration.time=true;
		Configuration.showtime=true;
		
		
		if (Configuration.filesupport &&
				Configuration.ogg &&
				Configuration.featureamp &&
				Configuration.base &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.time &&
				Configuration.showtime) {
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			start();
			
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("hollow.ogg");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			assertTrue(os.toString().contains("File Loaded:"));		
			assertTrue(os.toString().contains("hollow.ogg"));		
			assertTrue(os.toString().contains("[Base] notifySongLoaded:"));		
			assertTrue(os.toString().contains("[Base.playSong] Load:"));		
			demo.button("play").click();
			JButton play = (JButton) MemberModifier.field(FeatureAmp.class, "playButton").get(gui);
			assertEquals(play.getName(), "play");
			assertTrue(play.isEnabled());
			assertEquals(play.getText(),"\uF04B");
			
			demo.button("play").click();
			JButton pause = (JButton) MemberModifier.field(FeatureAmp.class, "playButton").get(gui);
			assertEquals(pause.getName(), "play");
			assertTrue(pause.isEnabled());
			assertEquals(pause.getText(),"\uF04C");
			
			demo.button("stop").click();
			
			JButton stop = (JButton) MemberModifier.field(FeatureAmp.class, "stopButton").get(gui);
			assertEquals(stop.getName(), "stop");
			assertTrue(stop.getPreferredSize().getWidth()==25);
			assertTrue(stop.getPreferredSize().getHeight()==25);
			assertFalse(stop.isEnabled());
			assertNotNull(stop.getComponentListeners());
			assertEquals(stop.getText(),"\uF04D");
			
		}
	}
	@Test
	public void playWAVTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.wav=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
		Configuration.light=true;
		Configuration.time=true;
		Configuration.showtime=true;
		
		
		if (Configuration.filesupport &&
				Configuration.wav &&
				Configuration.featureamp &&
				Configuration.base &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.time &&
				Configuration.showtime) {
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			start();
			
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("alarme.wav");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			assertTrue(os.toString().contains("File Loaded:"));		
			assertTrue(os.toString().contains("alarme.wav"));		
			assertTrue(os.toString().contains("[Base] notifySongLoaded:"));		
			assertTrue(os.toString().contains("[Base.playSong] Load:"));		
			demo.button("play").click();
			JButton play = (JButton) MemberModifier.field(FeatureAmp.class, "playButton").get(gui);
			assertEquals(play.getName(), "play");
			assertTrue(play.isEnabled());
			assertEquals(play.getText(),"\uF04B");
			
			demo.button("play").click();
			JButton pause = (JButton) MemberModifier.field(FeatureAmp.class, "playButton").get(gui);
			assertEquals(pause.getName(), "play");
			assertTrue(pause.isEnabled());
			assertEquals(pause.getText(),"\uF04C");
			
			demo.button("stop").click();
			
			JButton stop = (JButton) MemberModifier.field(FeatureAmp.class, "stopButton").get(gui);
			assertEquals(stop.getName(), "stop");
			assertTrue(stop.getPreferredSize().getWidth()==25);
			assertTrue(stop.getPreferredSize().getHeight()==25);
			assertFalse(stop.isEnabled());
			assertNotNull(stop.getComponentListeners());
			assertEquals(stop.getText(),"\uF04D");
			
		}
	}
	
	@Test
	public void volumecontrolTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
		Configuration.light=true;
		Configuration.time=true;
		Configuration.showtime=true;
		Configuration.volumecontrol=true;
		Configuration.volumecontrol=true;
		
		if (Configuration.filesupport &&
				Configuration.mp3 &&
				Configuration.featureamp &&
				Configuration.base &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.time &&
				Configuration.showtime &&
				Configuration.volumecontrol) {		
			start();
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			JSlider volume = (JSlider) MemberModifier.field(FeatureAmp.class, "volumeSlider").get(gui);
			assertEquals(volume.getName(),"volumeSlider");
			demo.slider("volumeSlider").rightClick();
			demo.slider("volumeSlider").slideToMinimum();
			assertTrue(volume.getValue()==0);
			demo.slider("volumeSlider").slideToMaximum();
			assertTrue(volume.getValue()==100);
			demo.slider("volumeSlider").slideTo(25);
			assertTrue(volume.getValue()==25);
			assertTrue(volume.getPreferredSize().getWidth()==100);
			assertTrue(volume.getPreferredSize().getHeight()==25);

			assertTrue(volume.getMaximumSize().getWidth()==100);
			assertTrue(volume.getMaximumSize().getHeight()==25);
			
			
			
		}
	}
	@Test
	public void muteTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
		Configuration.light=true;
		Configuration.time=true;
		Configuration.showtime=true;
		Configuration.volumecontrol=true;
		Configuration.mute=true;
		
		if (Configuration.filesupport &&
				Configuration.mp3 &&
				Configuration.featureamp &&
				Configuration.base &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.time &&
				Configuration.showtime &&
				Configuration.mute &&
				Configuration.volumecontrol) {		
			
			start();
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("mute").click();
			JButton mute = (JButton) MemberModifier.field(FeatureAmp.class, "muteButton").get(gui);
			assertEquals(mute.getName(), "mute");
		}
	}
	@Test
	public void showtimeTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
		Configuration.light=true;
		Configuration.time=true;
		Configuration.showtime=true;
		Configuration.volumecontrol=true;
		Configuration.mute=true;
		Configuration.playlist=true;
		
		if (Configuration.filesupport &&
				Configuration.mp3 &&
				Configuration.featureamp &&
				Configuration.base &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.time &&
				Configuration.showtime &&
				Configuration.mute &&
				Configuration.volumecontrol &&
				Configuration.playlist) {		
			start();
			demo.menuItemWithPath("File", "Open file").click();			
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
//			PlaylistDataModel playlist = (PlaylistDataModel) MemberModifier.field(FeatureAmp.class, "playlist").get(gui);
//			Map<String, String> map= (Map<String, String>) MemberModifier.field(PlaylistDataModel.class, "columnsToFunctionsMap").get(playlist);
//         
//			System.err.println(map.toString());
			//			JLabel title= (JLabel) MemberModifier.field(FeatureAmp.class, "title").get(gui);
//			assertEquals(artist.getText(),"Mariana Aydar");
//			assertEquals(title.getText(),"Na Gangorra");
		}
	}
		
	@Test
	public void progressBarTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
		Configuration.light=true;
		Configuration.time=true;
		Configuration.showtime=true;
		Configuration.playlist=true;
		Configuration.progressbar=true;
		
		if (Configuration.filesupport &&
				Configuration.mp3 &&
				Configuration.featureamp &&
				Configuration.base &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.time &&
				Configuration.showtime &&
				Configuration.progressbar &&
				Configuration.playlist) {		
			start();
			demo.menuItemWithPath("File", "Open file").click();			
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			JSlider positionSlider = (JSlider) MemberModifier.field(FeatureAmp.class, "positionSlider").get(gui);
			assertEquals(positionSlider.getName(), "progress");
			demo.slider("progress").slideToMinimum();
		}
	}
	@Test
	public void showCoverTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
  		Configuration.light=true;
  		Configuration.time=true;
  		Configuration.showtime=true;
  		Configuration.showcover=true;
		
		if (Configuration.filesupport &&
			Configuration.mp3 &&
			Configuration.featureamp &&
			Configuration.base &&
			Configuration.gui &&
			Configuration.skins &&
		  	Configuration.light &&
		  	Configuration.time &&
		  	Configuration.showtime &&
		  	Configuration.showcover) {
			
			start();			
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
		
			JPanel panel = (JPanel) MemberModifier.field(FeatureAmp.class, "coverPanel").get(gui);
			JLabel noCoverLabel = (JLabel) MemberModifier.field(FeatureAmp.class, "noCoverLabel").get(gui);
			assertTrue(panel != null);
		
			assertTrue(noCoverLabel != null);
			assertEquals(noCoverLabel.getText(), "No cover available");
		}
	}
	
	
	@Test
	public void playSkipTrackTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
  		Configuration.light=true;
  		Configuration.time=true;
  		Configuration.showtime=true;
  		Configuration.playlist=true;
  		Configuration.playlistcontrol=true;
  		Configuration.skiptrack=true;
		
		if (Configuration.filesupport &&
			Configuration.mp3 &&
			Configuration.featureamp &&
			Configuration.base &&
			Configuration.gui &&
			Configuration.skins &&
		  	Configuration.light &&
		  	Configuration.time &&
		  	Configuration.showtime &&
		   	Configuration.playlist &&
		  	Configuration.skiptrack) {
			start();
			
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("discreet.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			 file= new File("hollow.ogg");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("previousButton").click();
			demo.button("nextButton").click();
		
			IconButton previousButton = (IconButton) MemberModifier.field(FeatureAmp.class, "previousButton").get(gui);
			assertEquals(previousButton.getName(), "previousButton");
			
			IconButton nextButton = (IconButton) MemberModifier.field(FeatureAmp.class, "nextButton").get(gui);
			assertEquals(nextButton.getName(), "nextButton");
		}
	}




	@Test
	public void playModeTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
  		Configuration.light=true;
  		Configuration.time=true;
  		Configuration.showtime=true;
  		Configuration.playlist=true;
  		Configuration.playlistcontrol=true;
  		Configuration.skiptrack=true;
  		Configuration.shufflerepeat=true;
		
		if (Configuration.filesupport &&
			Configuration.mp3 &&
			Configuration.featureamp &&
			Configuration.base &&
			Configuration.gui &&
			Configuration.skins &&
		  	Configuration.light &&
		  	Configuration.time &&
		  	Configuration.showtime &&
		  	Configuration.playlist &&
		   	Configuration.shufflerepeat &&
		  	Configuration.skiptrack) {
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			IconButton button = (IconButton) MemberModifier.field(FeatureAmp.class, "shuffleRepeatButton").get(gui);

			demo.button("shuffle").click();
			assertEquals(button.getToolTipText(),"Shuffle: Play Random.");
			
			demo.button("shuffle").click();
			assertEquals(button.getToolTipText(),"Shuffle: Repeat Song.");
			
			demo.button("shuffle").click();
			assertEquals(button.getToolTipText(),"Shuffle: Repeat Playlist.");
			
			demo.button("shuffle").click();
			assertEquals(button.getToolTipText(),"Shuffle: Play playlist once.");
		}
	}
	@Test
	public void removeTrackTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
  		Configuration.light=true;
  		Configuration.time=true;
  		Configuration.showtime=true;
  		Configuration.playlist=true;
  		Configuration.playlistcontrol=true;
  		Configuration.removetrack=true;
  		Configuration.clearplaylist=true;
  		Configuration.playlistmenu=true;
		
		if (Configuration.filesupport &&
			Configuration.mp3 &&
			Configuration.featureamp &&
			Configuration.base &&
			Configuration.gui &&
			Configuration.skins &&
		  	Configuration.light &&
		  	Configuration.time &&
		  	Configuration.showtime &&
		  	Configuration.playlist &&
		  	Configuration.playlistcontrol &&
		  	Configuration.removetrack &&
		   	Configuration.clearplaylist &&
		  	Configuration.playlistmenu) {
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.table("p_list").click();
			demo.menuItemWithPath("Playlist", "Remove Track").click();
		}
	}
	
	
	@Test
	public void removePlayListTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
  		Configuration.light=true;
  		Configuration.time=true;
  		Configuration.showtime=true;
  		Configuration.playlist=true;
  		Configuration.playlistcontrol=true;
  		Configuration.removetrack=true;
  		Configuration.clearplaylist=true;
  		Configuration.playlistmenu=true;
		
		if (Configuration.filesupport &&
			Configuration.mp3 &&
			Configuration.featureamp &&
			Configuration.base &&
			Configuration.gui &&
			Configuration.skins &&
		  	Configuration.light &&
		  	Configuration.time &&
		  	Configuration.showtime &&
		  	Configuration.playlist &&
		  	Configuration.playlistcontrol &&
		  	Configuration.removetrack &&
		   	Configuration.clearplaylist &&
		  	Configuration.playlistmenu) {
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("Playlist", "Clear Playlist").click();			
		}
	}
	@Test
	public void saveandloadplaylistTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
		Configuration.light=true;
		Configuration.playlist=true;
		Configuration.saveandloadplaylist=true;
		Configuration.playlistmenu=true;
		Configuration.loadfolder=true;
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.playlist &&
				Configuration.loadfolder &&
				Configuration.playlistmenu &&
				Configuration.saveandloadplaylist &&
				Configuration.light) {
			start();
			
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.menuItemWithPath("File", "Open file").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("Playlist", "Save Playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("p1.m3u");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
		}
	}
	@Test
	public void loadplaylistTest() throws Exception {
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
  		Configuration.light=true;
  		Configuration.playlist=true;
  		Configuration.saveandloadplaylist=true;
  		Configuration.playlistmenu=true;
  		Configuration.loadfolder=true;
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.playlist &&
				Configuration.loadfolder &&
				Configuration.playlistmenu &&
				Configuration.saveandloadplaylist &&
				Configuration.light) {
			start();
		
			
					
			demo.menuItemWithPath("Playlist", "Load Playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
		    File file = new File("p1.m3u");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
		}
	}
	@Test
	public void changeSkinLightTest() throws Exception {
		Configuration.featureamp=true;
		Configuration.gui=true;
		Configuration.skins=true;
		Configuration.dark=false;
		Configuration.light=true;
		Configuration.filesupport =true;
		Configuration.mp3=true;
		
		if (Configuration.featureamp &&
				Configuration.gui &&
				Configuration.mp3 &&
				Configuration.filesupport &&
				Configuration.skins &&
				!Configuration.dark &&
				Configuration.light
				) {System.err.println("Entrou");
			start();
								
			assertTrue(gui.getContentPane().getBackground().getRed()==255);
			assertTrue(gui.getContentPane().getBackground().getGreen()==255);
			assertTrue(gui.getContentPane().getBackground().getBlue()==255);
		}
		
	}
	
	@Test
	public void changeSkinDarkTest() throws Exception {
		Configuration.featureamp=true;
		Configuration.gui=true;
		Configuration.skins=true;
		Configuration.dark=true;
		Configuration.light=false;
		Configuration.filesupport =true;
		Configuration.mp3=true;
		
		if (Configuration.featureamp &&
				Configuration.gui &&
				Configuration.mp3 &&
				Configuration.filesupport &&
				Configuration.skins &&
				Configuration.dark &&
				!Configuration.light
				) {
			start();
			
			
			
			assertTrue(gui.getBackground().getRed()==238);
			assertTrue(gui.getBackground().getGreen()==238);
			assertTrue(gui.getBackground().getBlue()==238);
		}
		
	}
	
//	@Test
//	public void queueListTest() throws Exception {
//		Configuration.filesupport=true;
//		Configuration.mp3=true;
//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//  		Configuration.light=true;
//  		Configuration.time=true;
//  		Configuration.showtime=true;
//  		Configuration.playlist=true;
//  		Configuration.queuetrack=true;
//		
//		if (Configuration.filesupport &&
//			Configuration.mp3 &&
//			Configuration.featureamp &&
//			Configuration.base &&
//			Configuration.gui &&
//			Configuration.skins &&
//		  	Configuration.light &&
//		  	Configuration.time &&
//		  	Configuration.showtime &&
//		  	Configuration.playlist &&
//		  	Configuration.queuetrack ) {
//	
//			start();
//
//			File file = new File("discreet.mp3");
//			demo.menuItemWithPath("File", "Load File").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			demo.fileChooser().approveButton().click();
//		
//			file = new File("insight.mp3");
//			demo.menuItemWithPath("File", "Load File").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			
//			demo.fileChooser().approveButton().click();
//			file = new File("long-expected.mp3");
//			demo.menuItemWithPath("File", "Load File").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			demo.fileChooser().approveButton().click();
//
//			demo.list("p_list").clickItem(0);
//			demo.button("addToQueue").click();
//			
//			demo.list("p_list").clickItem(1);
//			demo.button("addToQueue").click();
//			
//			demo.list("p_list").clickItem(2);
//			demo.button("addToQueue").click();
//			
//			demo.list("queueLis").clickItem(1);
//			demo.button("removeFromQueue").click();
//		
//			demo.list("queueLis").clickItem(0);
//			demo.button("removeFromQueue").click();
//		}
//	}
//	@Test
//	public void reorderplaylistTest() throws Exception {
//		Configuration.filesupport=true;
//		Configuration.mp3=true;
//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//  		Configuration.light=true;
//  		Configuration.time=true;
//  		Configuration.showtime=true;
//  		Configuration.playlist=true;
//  		Configuration.playlistcontrol=true;
//  		Configuration.reorderplaylist=true;
//		
//		if (Configuration.filesupport &&
//			Configuration.mp3 &&
//			Configuration.featureamp &&
//			Configuration.base &&
//			Configuration.gui &&
//			Configuration.skins &&
//		  	Configuration.light &&
//		  	Configuration.time &&
//		  	Configuration.showtime &&
//		  	Configuration.playlist &&
//		  	Configuration.playlistcontrol &&
//		  	Configuration.reorderplaylist) {
//			
//			start();
//			
//			File file = new File("discreet.mp3");
//			demo.menuItemWithPath("File", "Open file").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			demo.fileChooser().approveButton().click();
//			
//			file = new File("insight.mp3");
//			demo.menuItemWithPath("File", "Open file").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			
//			demo.fileChooser().approveButton().click();
//			file = new File("long-expected.mp3");
//			demo.menuItemWithPath("File", "Open file").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			demo.fileChooser().approveButton().click();
//			
//		
//			
//			
//		}
//	}
//	
//	//@Test
//	public void saveandlistTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.playlist=true;
//		Configuration.controlplayist=true;
//		Configuration.removetrack=true;
//		
//		if (Configuration.featureamp &&
//		Configuration.gui  &&
//		Configuration.player   &&
//		Configuration.mp3   &&
//		Configuration.skins   &&
//		Configuration.lightskin   &&
//		Configuration.saveandloadplaylist &&
//		Configuration.playlist &&
//		Configuration.controlplayist &&
//		Configuration.removetrack) {
//			
//			start();
//			
//			File file = new File("p2.m3u");
//			demo.menuItemWithPath("File", "Import playlist").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			demo.fileChooser().approveButton().click();
//
//			file = new File("insight.mp3");
//			demo.menuItemWithPath("File", "Import playlist").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			
//			demo.fileChooser().approveButton().click();
//			file = new File("long-expected.mp3");
//			demo.menuItemWithPath("File", "Import playlist").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			demo.fileChooser().approveButton().click();
//
//			demo.menuItemWithPath("File", "Export playlist").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			File file2 = new File("your-turn.mp3");
//			demo.fileChooser().selectFile(file2);
//			demo.fileChooser().approveButton().click();
//
//		
//			}
//	}
//
//	@Test
//	public void clearplaylistTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.playlist=true;
//		Configuration.clearplaylist=true;
//		Configuration.controlplayist=true;
//		Configuration.removetrack=true;
//		
//		if (Configuration.featureamp &&
//		Configuration.gui  &&
//		Configuration.player   &&
//		Configuration.mp3   &&
//		Configuration.skins   &&
//		Configuration.lightskin   &&
//		Configuration.saveandloadplaylist &&
//		Configuration.clearplaylist &&
//		Configuration.playlist &&
//		Configuration.controlplayist &&
//		Configuration.removetrack) {
//			
//			start();
//			
//			File file = new File("discreet.mp3");
//			demo.menuItemWithPath("File", "Import playlist").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			demo.fileChooser().approveButton().click();
//			
//			file = new File("insight.mp3");
//			demo.menuItemWithPath("File", "Import playlist").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			
//			demo.fileChooser().approveButton().click();
//			file = new File("long-expected.mp3");
//			demo.menuItemWithPath("File", "Import playlist").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().selectFile(file);
//			demo.fileChooser().approveButton().click();
//			demo.button("clear_playlist").click();
//			}
//	}
//	@Test
//	public void init_lightskinTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		
//		
//		if (Configuration.featureamp &&
//				Configuration.gui  &&
//				Configuration.player   &&
//				Configuration.mp3   &&
//				Configuration.skins   &&
//				Configuration.lightskin   ) {
//			
//			start();
//			gui.init();
//			DefaultPanel head = (DefaultPanel) MemberModifier.field(GUI.class, "head").get(gui);
//			DefaultPanel meta = (DefaultPanel) MemberModifier.field(GUI.class, "meta").get(gui);
//			DefaultPanel panelPlaylist = (DefaultPanel) MemberModifier.field(GUI.class, "panelPlaylist").get(gui);
//			DefaultPanel content = (DefaultPanel) MemberModifier.field(GUI.class, "content").get(gui);
//			DefaultPanel vol = (DefaultPanel) MemberModifier.field(GUI.class, "vol").get(gui);
//			DefaultPanel buttons = (DefaultPanel) MemberModifier.field(GUI.class, "buttons").get(gui);
//			
//			assertTrue(head.getBackground() == Color.WHITE);
//			assertTrue(meta.getBackground() == Color.WHITE);
//			assertTrue(panelPlaylist.getBackground() ==Color.WHITE);
//			assertTrue(content.getBackground() ==Color.WHITE);
//			assertTrue(vol.getBackground() ==Color.WHITE);
//			assertTrue(buttons.getBackground() ==Color.WHITE);
//		}
//	}
//	@Test
//	public void initTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.darkskin=true;
//		
//		
//		if (Configuration.featureamp &&
//		Configuration.gui  &&
//		Configuration.player   &&
//		Configuration.mp3   &&
//		Configuration.skins   &&
//		Configuration.darkskin   ) {
//			
//			start();
//			gui.init();
//			DefaultPanel head = (DefaultPanel) MemberModifier.field(GUI.class, "head").get(gui);
//			DefaultPanel meta = (DefaultPanel) MemberModifier.field(GUI.class, "meta").get(gui);
//			DefaultPanel panelPlaylist = (DefaultPanel) MemberModifier.field(GUI.class, "panelPlaylist").get(gui);
//			DefaultPanel content = (DefaultPanel) MemberModifier.field(GUI.class, "content").get(gui);
//			DefaultPanel vol = (DefaultPanel) MemberModifier.field(GUI.class, "vol").get(gui);
//			DefaultPanel buttons = (DefaultPanel) MemberModifier.field(GUI.class, "buttons").get(gui);
//			
//			assertTrue(head.getBackground() == Color.DARK_GRAY);
//			assertTrue(meta.getBackground() == Color.DARK_GRAY);
//			assertTrue(panelPlaylist.getBackground() ==Color.DARK_GRAY);
//			assertTrue(content.getBackground() ==Color.DARK_GRAY);
//			assertTrue(vol.getBackground() ==Color.DARK_GRAY);
//			assertTrue(buttons.getBackground() ==Color.DARK_GRAY);
//		}
//	}
//	@Test
//	public void LoadFolderTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.skiptrack=true;
//		Configuration.removetrack=true;
//		Configuration.playlist=true;
//		Configuration.reorderplaylist=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.loadfolder=true;
//		
//		if (Configuration.featureamp &&
//		Configuration.gui &&
//		Configuration.player &&
//		Configuration.mp3 &&
//		Configuration.skins &&
//		Configuration.lightskin &&
//		Configuration.skiptrack  &&
//		Configuration.removetrack  &&
//		Configuration.playlist  &&
//		Configuration.reorderplaylist  &&
//		Configuration.saveandloadplaylist &&
//		Configuration.loadfolder) {
//			start();
//			
//			demo.menuItemWithPath("File", "Open Folder...").click();
//			demo.fileChooser().setCurrentDirectory(new File("media/"));
//			demo.fileChooser().approveButton().click();
//			
//			demo.button("play").click();
//		}
//	}
////
////	@Test
////	public void queueListTest() throws IllegalArgumentException, IllegalAccessException {
////		Configuration.time=true;
////		Configuration.resizable=true;
////		Configuration.wav=true;
////		Configuration.supportedformats=true;
////		Configuration.playlist=true;
////		Configuration.control=true;
////		Configuration.gui=true;
////		Configuration.featureamp=true;
////		Configuration.showtime=true;
////		Configuration.id3information=true;
////		Configuration.loadfolder=true;
////		Configuration.base=true;
////		Configuration.mp3=true;
////		Configuration.skins=true;
////		Configuration.openfile=true;
////		
////		Configuration.queuetrack=true;
////		
////		if (Configuration.time &&
////				Configuration.resizable &&
////				Configuration.wav &&
////				Configuration.supportedformats &&
////				Configuration.playlist &&
////				Configuration.control &&
////				Configuration.gui &&
////				Configuration.featureamp &&
////				Configuration.showtime &&
////				Configuration.id3information &&
////				Configuration.loadfolder &&
////				Configuration.base &&
////				Configuration.mp3 &&
////				Configuration.skins &&
////				Configuration.openfile &&
////				Configuration.queuetrack ) {
////
////			start();
////
////			File file = new File("discreet.mp3");
////			demo.menuItemWithPath("File", "Load File").click();
////			demo.fileChooser().setCurrentDirectory(new File("media/"));
////			demo.fileChooser().selectFile(file);
////			demo.fileChooser().approveButton().click();
////		
////			file = new File("insight.mp3");
////			demo.menuItemWithPath("File", "Load File").click();
////			demo.fileChooser().setCurrentDirectory(new File("media/"));
////			demo.fileChooser().selectFile(file);
////			
////			demo.fileChooser().approveButton().click();
////			file = new File("long-expected.mp3");
////			demo.menuItemWithPath("File", "Load File").click();
////			demo.fileChooser().setCurrentDirectory(new File("media/"));
////			demo.fileChooser().selectFile(file);
////			demo.fileChooser().approveButton().click();
////
////			demo.list("p_list").clickItem(0);
////			demo.button("addToQueue").click();
////			
////			demo.list("p_list").clickItem(1);
////			demo.button("addToQueue").click();
////			
////			demo.list("p_list").clickItem(2);
////			demo.button("addToQueue").click();
////			
////			demo.list("queueLis").clickItem(1);
////			demo.button("removeFromQueue").click();
////		
////			demo.list("queueLis").clickItem(0);
////			demo.button("removeFromQueue").click();
////		}
////	}
////
////	@Test
////	public void setTitleTest() throws IllegalArgumentException, IllegalAccessException {
////		Configuration.time=true;
////		Configuration.resizable=true;
////		Configuration.supportedformats=true;
////		Configuration.playlist=true;
////		Configuration.control=true;
////		Configuration.gui=true;
////		Configuration.featureamp=true;
////		Configuration.showtime=true;
////		Configuration.id3information=true;
////		Configuration.loadfolder=true;
////		Configuration.base=true;
////		Configuration.wav=true;
////		Configuration.mp3=true;
////		Configuration.skins=true;
////		Configuration.openfile=true;
////		
////		if (Configuration.time &&
////				Configuration.resizable &&
////				Configuration.wav &&
////				Configuration.supportedformats &&
////				Configuration.playlist &&
////				Configuration.control &&
////				Configuration.gui &&
////				Configuration.featureamp &&
////				Configuration.showtime &&
////				Configuration.id3information &&
////				Configuration.loadfolder &&
////				Configuration.base &&
////				Configuration.wav &&
////				Configuration.skins &&
////				Configuration.openfile) {
////			
////			start();
////			JFrame frame = (JFrame) MemberModifier.field(App.class, "frame").get(gui);
////			gui.setTitle("test");
////			assertEquals(gui.getFrame().getTitle(),"test");
////		}
////		
////			
////	}
////	

	
	private void start() throws Exception{
		gui = new FeatureAmp();
		Whitebox.invokeMethod(gui, "launch");
		demo = new FrameFixture(gui);
	}
}
