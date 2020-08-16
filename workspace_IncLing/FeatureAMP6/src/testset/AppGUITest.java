package testset;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import featureamp.controler.Kernel;
import featureamp.gui.MainWindow;
import gui.IconButton;
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
import javax.swing.SwingUtilities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import org.fest.swing.fixture.FrameFixture;
import featureamp.gui.elements.Label;
public class AppGUITest {

	private FrameFixture demo;
	private MainWindow gui;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
		if(demo!=null)
		demo.cleanUp();
	}

	@Test
	public void playAACTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.codecs=true;
//		Configuration.aac=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.progress=true;
		
		
		if (Configuration.featureamp &&
				Configuration.base &&
				Configuration.codecs &&
				Configuration.aac &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.progress) {
			start();
			System.err.println("playAACTest");
			IconButton play = (IconButton) MemberModifier.field(MainWindow.class, "play").get(gui);
			IconButton open = (IconButton) MemberModifier.field(MainWindow.class, "open").get(gui);
			IconButton stop = (IconButton) MemberModifier.field(MainWindow.class, "stop").get(gui);
			
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("example.aac");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			demo.button("play").click();
			
			demo.button("stop").click();
			
			assertEquals(play.getName(), "play");
			assertEquals(play.getToolTipText(), "Play/Pause");
			
			assertEquals(stop.getName(), "stop");
			assertEquals(stop.getToolTipText(), "Stop");
			
			assertEquals(open.getName(), "open");
			assertEquals(open.getToolTipText(), "Open menu");
		}
	}
	@Test
	public void playOGGTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.codecs=true;
//		Configuration.ogg=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.progress=true;
		
		
		if (Configuration.featureamp &&
				Configuration.base &&
				Configuration.codecs &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.progress) {
			start();
			System.err.println("playOGGTest");
			IconButton play = (IconButton) MemberModifier.field(MainWindow.class, "play").get(gui);
			IconButton open = (IconButton) MemberModifier.field(MainWindow.class, "open").get(gui);
			IconButton stop = (IconButton) MemberModifier.field(MainWindow.class, "stop").get(gui);
			
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("discreet.OGG");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			demo.button("play").click();
			
			demo.button("stop").click();
			
			assertEquals(play.getName(), "play");
			assertEquals(play.getToolTipText(), "Play/Pause");
			
			assertEquals(stop.getName(), "stop");
			assertEquals(stop.getToolTipText(), "Stop");
			
			assertEquals(open.getName(), "open");
			assertEquals(open.getToolTipText(), "Open menu");
		}
	}
	@Test
	public void playWAVTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.codecs=true;
//		Configuration.wav=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.progress=true;
		
		
		if (Configuration.featureamp &&
				Configuration.base &&
				Configuration.codecs &&
				Configuration.wav &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.progress) {
			start();
			System.err.println("playWAVTest");
			IconButton play = (IconButton) MemberModifier.field(MainWindow.class, "play").get(gui);
			IconButton open = (IconButton) MemberModifier.field(MainWindow.class, "open").get(gui);
			IconButton stop = (IconButton) MemberModifier.field(MainWindow.class, "stop").get(gui);
			
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("alarme.wav");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			demo.button("play").click();
			
			demo.button("stop").click();
			
			assertEquals(play.getName(), "play");
			assertEquals(play.getToolTipText(), "Play/Pause");
			
			assertEquals(stop.getName(), "stop");
			assertEquals(stop.getToolTipText(), "Stop");
			
			assertEquals(open.getName(), "open");
			assertEquals(open.getToolTipText(), "Open menu");
		}
	}
	@Test
	public void playMP3Test() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.codecs=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.progress=true;
	
		
		if (Configuration.featureamp &&
				Configuration.base &&
				Configuration.codecs &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.progress) {
			start();
			System.err.println("playMP3Test");
			IconButton play = (IconButton) MemberModifier.field(MainWindow.class, "play").get(gui);
			IconButton open = (IconButton) MemberModifier.field(MainWindow.class, "open").get(gui);
			IconButton stop = (IconButton) MemberModifier.field(MainWindow.class, "stop").get(gui);
			
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			demo.button("play").click();
			
			demo.button("stop").click();
			
			assertEquals(play.getName(), "play");
			assertEquals(play.getToolTipText(), "Play/Pause");
		
			assertEquals(stop.getName(), "stop");
			assertEquals(stop.getToolTipText(), "Stop");
			
			assertEquals(open.getName(), "open");
			assertEquals(open.getToolTipText(), "Open menu");
		}
	}

	
	@Test
	public void volumeControlTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.codecs=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.progress=true;
//		Configuration.volume=true;
//		Configuration.mute=true;
//		Configuration.gui=true;
		if (Configuration.featureamp &&
				Configuration.base &&
				Configuration.codecs &&
				Configuration.mp3 &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.progress &&
				Configuration.volume &&
				Configuration.mute &&
				Configuration.gui) {
			start();
			System.err.println("volumeControlTest");
			IconButton volUp = (IconButton) MemberModifier.field(MainWindow.class, "volUp").get(gui);
			IconButton volDown = (IconButton) MemberModifier.field(MainWindow.class, "volDown").get(gui);
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("volumeDown").click();
			demo.button("volumeDown").click();
			demo.button("volumeDown").click();
			demo.button("volumeDown").click();
			demo.button("volumeUP").click();
			demo.button("volumeUP").click();
			demo.button("volumeUP").click();
			
			
			assertEquals(volUp.getName(), "volumeUP");		
			assertEquals(volDown.getName(), "volumeDown");	
			
		}
	}
	@Test
	public void muteTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.codecs=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.progress=true;
//		Configuration.volume=true;
//		Configuration.mute=true;
//		Configuration.gui=true;
		if (Configuration.featureamp &&
		Configuration.base &&
		Configuration.codecs &&
		Configuration.mp3 &&
		Configuration.skins &&
		Configuration.light &&
		Configuration.progress &&
		Configuration.volume &&
		Configuration.mute &&
		Configuration.gui) {
			start();
			System.err.println("muteTest");
			IconButton mute = (IconButton) MemberModifier.field(MainWindow.class, "mute").get(gui);
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("muteVolume").click();
			assertEquals(mute.getName(), "muteVolume");		}
	}
	
	@Test
	public void progressBarTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.codecs=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.progress=true;
//		Configuration.progressbar=true;
//		Configuration.mute=true;
//		Configuration.gui=true;
		
		if (Configuration.featureamp &&
		Configuration.base &&
		Configuration.codecs &&
		Configuration.mp3 &&
		Configuration.skins &&
		Configuration.light &&
		Configuration.progress &&
		Configuration.progressbar&&
		Configuration.mute &&
		Configuration.gui) {
			start();
			System.err.println("progressBarTest");
			Kernel kernel = (Kernel) MemberModifier.field(MainWindow.class, "kernel").get(gui);
			Label length = (Label) MemberModifier.field(Kernel.class, "length").get(kernel);
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			assertFalse(length.getText().equals(""));
			System.err.println(length.getText());
			demo.button("play").click();
			demo.button("play").click();
		}
	}
	
	@Test
	public void skipTrack_Test() throws Exception {

//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.codecs=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.progressbar=true;
//		Configuration.mute=true;
//		Configuration.gui=true;
//		Configuration.playlist=true;
//		Configuration.playlistcontrols=true;
//		Configuration.removetrack=true;
//		Configuration.clearplaylist=true;
		
		if (Configuration.featureamp &&
		Configuration.base &&
		Configuration.codecs &&
		Configuration.mp3 &&
		Configuration.skins &&
		Configuration.dark &&
		Configuration.progressbar&&
		Configuration.mute &&
		Configuration.gui &&
		Configuration.playlist &&
		Configuration.playlistcontrols &&
		Configuration.removetrack &&
		Configuration.clearplaylist) {
			start();
			
			System.err.println("skipTrack_Test");
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("discreet.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("just-like-magic.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("long-expected.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
		
			
			demo.scrollPane("p_list").click();
			demo.button("removeTrack").click();
			demo.scrollPane("p_list").click();
			demo.button("removeTrack").click();
			demo.scrollPane("p_list").click();
			demo.button("removeTrack").click();
			}
	}

	
	@Test
	public void clearPlayListTest() throws Exception {

//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.codecs=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.progressbar=true;
//		Configuration.mute=true;
//		Configuration.gui=true;
//		Configuration.playlist=true;
//		Configuration.playlistcontrols=true;
//		Configuration.removetrack=true;
//		Configuration.clearplaylist=true;
		
		if (Configuration.featureamp &&
		Configuration.base &&
		Configuration.codecs &&
		Configuration.mp3 &&
		Configuration.skins &&
		Configuration.dark &&
		Configuration.progressbar&&
		Configuration.mute &&
		Configuration.gui &&
		Configuration.playlist &&
		Configuration.playlistcontrols &&
		Configuration.removetrack &&
		Configuration.clearplaylist) {
			start();
			
			System.err.println("clearPlayListTest");
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("discreet.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("just-like-magic.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("open").click();
			demo.menuItemWithPath("Open File").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("long-expected.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
		
			
			demo.button("clearPlayList").click();
			}
	}
	private void start() throws Exception{
		gui = new MainWindow();
		demo = new FrameFixture(gui);
	}
}
