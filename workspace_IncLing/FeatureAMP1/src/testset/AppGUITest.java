package testset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import featureAmp.view.App;
import featureAmp.view.VolumeSlider;
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
	private App gui;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
		if(demo != null)
		   demo.cleanUp();
	}
	@Test
	public void playWAVTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.wav=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.wav &&
				Configuration.skins &&
				Configuration.openfile) {
			
			start();
			
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("alarme.wav");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("play").click();
			demo.button("pause").click();
			demo.button("play").click();
			demo.button("stop").click();
			demo.button("play").click();
			demo.button("pause").click();
		}
	}
	@Test
	public void playSkipTrackTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		Configuration.skiptrack=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile) {
			start();
			
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("discreet.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			 file= new File("hollow.ogg");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("play").click();
			demo.button("skiptrack").click();
			demo.button("skiptrack").click();
		
			JButton button = (JButton) MemberModifier.field(App.class, "skipTrack").get(gui);
			assertEquals(button.getName(), "skiptrack");
			
			
		}
	}
	@Test
	public void playMP3Test() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
		
		if (Configuration.time &&
		Configuration.resizable &&
		Configuration.wav &&
		Configuration.supportedformats &&
		Configuration.playlist &&
		Configuration.control &&
		Configuration.gui &&
		Configuration.featureamp &&
		Configuration.showtime &&
		Configuration.id3information &&
		Configuration.loadfolder &&
		Configuration.base &&
		Configuration.mp3 &&
		Configuration.skins &&
		Configuration.openfile) {
			start();
			
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("play").click();
			demo.button("pause").click();
			demo.button("play").click();
			demo.button("stop").click();
			demo.button("play").click();
			demo.button("pause").click();
			JButton button = (JButton) MemberModifier.field(App.class, "play").get(gui);
			assertEquals(button.getName(), "play");
			
			button = (JButton) MemberModifier.field(App.class, "pause").get(gui);
			assertEquals(button.getName(), "pause");
			
			button = (JButton) MemberModifier.field(App.class, "stop").get(gui);
			assertEquals(button.getName(), "stop");
		}
	}
	@Test
	public void volumecontrolTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		Configuration.volumecontrol=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.volumecontrol &&
				Configuration.openfile) {
			
			start();
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			VolumeSlider volume = (VolumeSlider) MemberModifier.field(App.class, "volumeSlider").get(gui);
			demo.slider("volumeSlider").rightClick();
			demo.slider("volumeSlider").slideToMinimum();
			assertTrue(volume.getValue()==0);
			demo.slider("volumeSlider").slideToMaximum();
			assertTrue(volume.getValue()==100);
			demo.slider("volumeSlider").slideTo(25);
			assertTrue(volume.getValue()==25);
		}
	}
	@Test
	public void showCoverTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		Configuration.showcover=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.showcover &&
				Configuration.openfile) {
			
			start();
			
			
			JLabel label = (JLabel) MemberModifier.field(App.class, "imagePanel").get(gui);
			assertTrue(label != null);
			assertTrue(label.getIcon().getIconHeight()==300);
			assertTrue(label.getIcon().getIconWidth()==400);
			System.out.println(label.getIcon());
		}
	}
	@Test
	public void muteTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		Configuration.mute=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.mute &&
				Configuration.openfile) {
			
			start();
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.toggleButton("mute").click();
			JToggleButton mute = (JToggleButton) MemberModifier.field(App.class, "mute").get(gui);
			assertEquals(mute.getName(), "mute");
		}
	}
	@Test
	public void showtimeTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		
//		Configuration.showtime=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile &&
				Configuration.showtime ) {
			start();
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			String artist= (String) MemberModifier.field(App.class, "artist").get(gui);
			String titel= (String) MemberModifier.field(App.class, "titel").get(gui);
			assertEquals(artist,"Mariana Aydar");
			assertEquals(titel,"Na Gangorra");
		}
	}
	@Test
	public void progressBarTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		
//		Configuration.progressbar=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile &&
				Configuration.progressbar ) {
			start();
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			JProgressBar progressBar = (JProgressBar) MemberModifier.field(App.class, "progressBar").get(gui);
			assertEquals(progressBar.getName(), "progress_bar");
			demo.progressBar("progress_bar").requireValue(0);
		}
	}
	
	@Test
	public void playModeTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		
//		Configuration.shufflerepeat=true;
//		Configuration.queuetrack=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile &&
				Configuration.queuetrack &&
				Configuration.shufflerepeat ) {
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			JButton button = (JButton) MemberModifier.field(App.class, "playModeButton").get(gui);

			demo.button("playModeButton").click();
//			assertEquals(button.getText(), "repeat one track");
	
			demo.button("playModeButton").click();
//			assertEquals(button.getText(), "repeat playlist");
			
			demo.button("playModeButton").click();
//			assertEquals(button.getText(), "shuffle");
						
			demo.button("playModeButton").click();
//			assertEquals(button.getText(), "normal");
			
			demo.button("playModeButton").click();
//			assertEquals(button.getText(), "repeat one track");
			
		}
	}
	
	
	@Test
	public void removePlayListTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		
//		Configuration.removetrack=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile &&
				Configuration.removetrack ) {
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.list("p_list").clickItem(0);
			demo.button("remove").click();
			
			demo.list("p_list").clickItem(1);
			demo.button("remove").click();
		}
	}
	@Test
	public void saveandlistTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		
//		Configuration.saveandloadplaylist=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile &&
				Configuration.saveandloadplaylist ) {
			
			start();
			
			File file = new File("p1.m3u");
			demo.menuItemWithPath("Playlists", "load playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.optionPane().button().click();
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.menuItemWithPath("Playlists", "save playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file2 = new File("your-turn.mp3");
			demo.fileChooser().selectFile(file2);
			demo.fileChooser().approveButton().click();

		
			}
	}
	@Test
	public void saveandloadplaylistTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		
//		Configuration.saveandloadplaylist=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile &&
				Configuration.saveandloadplaylist ) {
			
			start();
			
			File file = new File("p1.m3u");
			demo.menuItemWithPath("Playlists", "load playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.button("play").click();
		}
	}
	@Test
	public void clearplaylistTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		
//		Configuration.clearplaylist=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile &&
				Configuration.clearplaylist ) {
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("clear").click();
			}
	}
	@Test
	public void reorderplaylistTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		
//		Configuration.reorderplaylist=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile &&
				Configuration.reorderplaylist ) {
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.list("p_list").clickItem(0);
			demo.button("down").click();
			
			demo.list("p_list").clickItem(1);
			demo.button("up").click();
		}
	}
	@Test
	public void removeTrackTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		
//		Configuration.removetrack=true;
//		Configuration.queuetrack=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile &&
				Configuration.queuetrack &&
				Configuration.removetrack ) {
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.list("p_list").clickItem(0);
			demo.button("addToQueue").click();
			
			demo.list("p_list").clickItem(1);
			demo.button("addToQueue").click();
			
			demo.list("p_list").clickItem(2);
			demo.button("addToQueue").click();
			
			demo.list("queueLis").clickItem(1);
			demo.button("removeFromQueue").click();
			
			demo.list("queueLis").clickItem(0);
			demo.button("removeFromQueue").click();
		}
	}
	@Test
	public void queueListTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.wav=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
//		
//		Configuration.queuetrack=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.openfile &&
				Configuration.queuetrack ) {

			start();

			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
		
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Load File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.list("p_list").clickItem(0);
			demo.button("addToQueue").click();
			
			demo.list("p_list").clickItem(1);
			demo.button("addToQueue").click();
			
			demo.list("p_list").clickItem(2);
			demo.button("addToQueue").click();
			
			demo.list("queueLis").clickItem(1);
			demo.button("removeFromQueue").click();
		
			demo.list("queueLis").clickItem(0);
			demo.button("removeFromQueue").click();
		}
	}

	@Test
	public void setTitleTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.wav=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.wav &&
				Configuration.skins &&
				Configuration.openfile) {
			
			start();
			JFrame frame = (JFrame) MemberModifier.field(App.class, "frame").get(gui);
			gui.setTitle("test");
			assertEquals(gui.getFrame().getTitle(),"test");
		}
		
			
	}
	
	@Test
	public void setSkinColorTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.time=true;
//		Configuration.resizable=true;
//		Configuration.supportedformats=true;
//		Configuration.playlist=true;
//		Configuration.control=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.showtime=true;
//		Configuration.id3information=true;
//		Configuration.loadfolder=true;
//		Configuration.base=true;
//		Configuration.wav=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.openfile=true;
		
		if (Configuration.time &&
				Configuration.resizable &&
				Configuration.wav &&
				Configuration.supportedformats &&
				Configuration.playlist &&
				Configuration.control &&
				Configuration.gui &&
				Configuration.featureamp &&
				Configuration.showtime &&
				Configuration.id3information &&
				Configuration.loadfolder &&
				Configuration.base &&
				Configuration.wav &&
				Configuration.skins &&
				Configuration.openfile) {
			
			start();
			Color color= new Color(2);
			gui.setSkinColor(color);
			JFrame frame = (JFrame) MemberModifier.field(App.class, "frame").get(gui);
			
			for(Component c: frame.getContentPane().getComponents()){
				assertTrue(c.getBackground()==color);
				assertTrue(c.getForeground()==color);
			}
			
			assertTrue(frame.getContentPane().getBackground() ==color);
			assertTrue(frame.getContentPane().getForeground() ==color);
			assertTrue(frame.getForeground() ==color);
			assertTrue(frame.getForeground() ==color);
			JPanel controlPanel = (JPanel) MemberModifier.field(App.class, "controlPanel").get(gui);
			assertTrue(frame.getForeground() ==color);
			assertTrue(frame.getForeground() ==color);
			
			Box upper = (Box) MemberModifier.field(App.class, "upperCentralArea").get(gui);
			assertTrue(upper.getForeground() ==color);
			assertTrue(upper.getForeground() ==color);
			
			Box lower = (Box) MemberModifier.field(App.class, "lowerCentralArea").get(gui);
			assertTrue(lower.getForeground() ==color);
			assertTrue(lower.getForeground() ==color);
			
		}
	}
	
	private void start() throws IllegalArgumentException, IllegalAccessException {

		gui = new App();
		JFrame g = (JFrame) MemberModifier.field(App.class, "frame").get(gui);
		demo = new FrameFixture(g);
	}
}
