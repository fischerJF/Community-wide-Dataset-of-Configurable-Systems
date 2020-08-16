package testset;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;


import gui.Main;
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

public class AppGUITest {

	private FrameFixture demo;
	private Main gui;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
		if(demo!=null)
		demo.cleanUp();
	}

	@Test
	public void playWavTest() throws Exception {
//		Configuration.filesupport =true;
//		Configuration.gui=true;
//		Configuration.base=true;
//		Configuration.wave=true;
//		Configuration.progress=true;
//		Configuration.skins=true;
//		Configuration.light=true;
		
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.wave &&
				Configuration.progress &&
				Configuration.skins &&
				Configuration.light) {
			start();
			
			JButton play = (JButton) MemberModifier.field(Main.class, "btnPlay").get(gui);
			JButton pause = (JButton) MemberModifier.field(Main.class, "btnPause").get(gui);
			JButton stop = (JButton) MemberModifier.field(Main.class, "btnStop").get(gui);
			
			assertFalse(play.isEnabled());
			assertFalse(pause.isEnabled());
			assertFalse(stop.isEnabled());
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("alarme.wav");
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
//		Configuration.filesupport =true;
//		Configuration.gui=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.progress=true;
//		Configuration.skins=true;
//		Configuration.light=true;
	
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.progress &&
				Configuration.skins &&
				Configuration.light) {
			start();
			
			JButton play = (JButton) MemberModifier.field(Main.class, "btnPlay").get(gui);
			JButton pause = (JButton) MemberModifier.field(Main.class, "btnPause").get(gui);
			JButton stop = (JButton) MemberModifier.field(Main.class, "btnStop").get(gui);

			assertFalse(play.isEnabled());
			assertFalse(pause.isEnabled());
			assertFalse(stop.isEnabled());
			
			demo.menuItemWithPath("File", "Open...").click();
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
//		Configuration.filesupport =true;
//		Configuration.gui=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.progress=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.volumecontrol=true;
//		Configuration.mute=true;
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.progress &&
				Configuration.skins &&
				Configuration.volumecontrol &&
				Configuration.mute &&
				Configuration.light) {
			start();
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			JButton mute = (JButton) MemberModifier.field(Main.class, "muteButton").get(gui);
			demo.button("mute").click();
			
			assertEquals(mute.getName(), "mute");
			assertEquals(mute.getText(), "Mute");
			assertTrue(mute.isVisible());
		}
	}
	
//	@Test
	public void showCoverTest() throws Exception {
//		Configuration.filesupport =true;
//		Configuration.gui=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.progress=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.showcover=true;
	
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.progress &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.showcover
				) {
			start();
					
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			JLabel cover = (JLabel) MemberModifier.field(Main.class, "coverLabel").get(gui);
			
			assertNull(cover.getText());
			assertNotNull(cover.getIcon());
		}
	}
	
	@Test
	public void volumecontrolTest() throws Exception {
//		Configuration.filesupport =true;
//		Configuration.gui=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.progress=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.volumecontrol=true;
//		Configuration.mute=true;
	
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.progress &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.volumecontrol &&
				Configuration.mute
				
				) {
			start();
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			JButton less_volume = (JButton) MemberModifier.field(Main.class, "volumeDown").get(gui);
			assertEquals(less_volume.getName(),"less_volume");
			assertTrue(less_volume.isEnabled());
			JButton more_volume = (JButton) MemberModifier.field(Main.class, "volumeUp").get(gui);
			assertFalse(more_volume.isEnabled());

			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			demo.button("less_volume").click();
			assertEquals(more_volume.getName(),"more_volume");
			assertTrue(more_volume.isEnabled());

			JLabel percent = (JLabel) MemberModifier.field(Main.class, "volumeDisplay").get(gui);
			assertEquals(percent.getText(),"95%");
			demo.button("more_volume").click();
			demo.button("more_volume").click();
			demo.button("more_volume").click();
			demo.button("more_volume").click();
			demo.button("more_volume").click();
			assertEquals(percent.getText(),"100%");
		}
	}
	
	@Test
	public void progressBarTest() throws Exception {
//		Configuration.filesupport =true;
//		Configuration.gui=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.progress=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.progress=true;
//		Configuration.progressbar=true;
	
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.progress &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.progress &&
				Configuration.progressbar
				) {
			start();
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			JProgressBar progressBar = (JProgressBar) MemberModifier.field(Main.class, "trackProgress").get(gui);
			assertEquals(progressBar.getName(), "progress");
			demo.progressBar("progress").requireValue(0);
		}
	}
/**	@Test**/
	public void showtimeTest() throws Exception {
//		Configuration.filesupport =true;
//		Configuration.gui=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.progress=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.progress=true;
//		Configuration.progressbar=true;
	
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.progress &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.progress &&
				Configuration.progressbar
				) {
			start();
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
	
			assertTrue(gui.getTitle().contains("Mariana Aydar"));
			assertTrue(gui.getTitle().contains("Na Gangorra"));
			
		}
	}
	
	@Test
	public void changeSkinLightTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.dark=false;
//		Configuration.light=true;
//		Configuration.filesupport =true;
//		Configuration.mp3=true;
		
		if (Configuration.featureamp &&
				Configuration.gui &&
				Configuration.mp3 &&
				Configuration.filesupport &&
				Configuration.skins &&
				!Configuration.dark &&
				Configuration.light
				) {
			start();
			Whitebox.invokeMethod(gui, "initComponents");
					
			assertTrue(gui.getContentPane().getBackground().getRed()==255);
			assertTrue(gui.getContentPane().getBackground().getGreen()==255);
			assertTrue(gui.getContentPane().getBackground().getBlue()==255);
		}
		
	}
	
	@Test
	public void changeSkinDarkTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.light=false;
//		Configuration.filesupport =true;
//		Configuration.mp3=true;
		
		if (Configuration.featureamp &&
				Configuration.gui &&
				Configuration.mp3 &&
				Configuration.filesupport &&
				Configuration.skins &&
				Configuration.dark &&
				!Configuration.light
				) {
			start();
			Whitebox.invokeMethod(gui, "initComponents");
			
			
			assertTrue(gui.getBackground().getRed()==238);
			assertTrue(gui.getBackground().getGreen()==238);
			assertTrue(gui.getBackground().getBlue()==238);
		}
		
	}
	
	@Test
	public void clearTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.filesupport =true;
//		Configuration.mp3=true;
//		Configuration.playlist=true;
//		Configuration.playlistcontrols=true;
//		Configuration.removetrack=true;
//		Configuration.clearplaylist=true;
//		Configuration.base=true;
		
		if (Configuration.base &&
				Configuration.featureamp &&
				Configuration.gui &&
				Configuration.mp3 &&
				Configuration.filesupport &&
				Configuration.skins &&
				Configuration.dark &&
				Configuration.playlist &&
				Configuration.playlistcontrols &&
				Configuration.removetrack &&
				Configuration.clearplaylist
				) {
			start();
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("discreet.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("insight.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("clear").click();
		}
	}
	@Test
	public void shufflerepeatTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.filesupport =true;
//		Configuration.mp3=true;
//		Configuration.playlist=true;
//		Configuration.playlistcontrols=true;
//		Configuration.skiptrack=true;
//		Configuration.base=true;
//		Configuration.skiprepeat=true;
//		Configuration.shufflerepeat=true;
		
		if (Configuration.base &&
				Configuration.featureamp &&
				Configuration.gui &&
				Configuration.mp3 &&
				Configuration.filesupport &&
				Configuration.skins &&
				Configuration.dark &&
				Configuration.playlist &&
				Configuration.playlistcontrols &&
				Configuration.skiprepeat &&
				Configuration.shufflerepeat &&
				Configuration.skiptrack) {
			start();
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File	file = new File("discreet.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("insight.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.radioButton("rbRepeatList").click();
			demo.radioButton("rbRepeatTrack").click();
			demo.radioButton("rbRepeatNone").click();
			demo.checkBox("shuffle").click();
		}
	}
	@Test
	public void skipTrackTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.filesupport =true;
//		Configuration.mp3=true;
//		Configuration.playlist=true;
//		Configuration.playlistcontrols=true;
//		Configuration.skiptrack=true;
//		Configuration.base=true;
		
		if (Configuration.base &&
				Configuration.featureamp &&
				Configuration.gui &&
				Configuration.mp3 &&
				Configuration.filesupport &&
				Configuration.skins &&
				Configuration.dark &&
				Configuration.playlist &&
				Configuration.playlistcontrols &&
				Configuration.skiptrack) {
			start();
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("discreet.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("insight.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("skipTrack").click();
			demo.button("skipTrack").click();
			demo.button("skipTrack").click();
			demo.button("skipTrack").click();
		}
	}
	@Test
	public void deEnqueueTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.filesupport =true;
//		Configuration.mp3=true;
//		Configuration.playlist=true;
//		Configuration.playlistcontrols=true;
//		Configuration.removetrack=true;
//		Configuration.base=true;
//		Configuration.queuetrack=true;
//		Configuration.queueremove=true;
		
		if (Configuration.base &&
				Configuration.featureamp &&
				Configuration.gui &&
				Configuration.mp3 &&
				Configuration.filesupport &&
				Configuration.skins &&
				Configuration.dark &&
				Configuration.playlist &&
				Configuration.playlistcontrols &&
				Configuration.removetrack &&
				Configuration.queuetrack &&
		        Configuration.queueremove) {
			start();
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("discreet.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("insight.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.list("p_list").clickItem(3);
			demo.button("de_enqueue").click();
			demo.list("p_list").clickItem(2);
			demo.button("de_enqueue").click();
			demo.list("p_list").clickItem(1);
			demo.button("de_enqueue").click();
			demo.list("p_list").clickItem(0);
			demo.button("de_enqueue").click();
			
		}
	}
	@Test
	public void removeTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.filesupport =true;
//		Configuration.mp3=true;
//		Configuration.playlist=true;
//		Configuration.playlistcontrols=true;
//		Configuration.removetrack=true;
//		Configuration.base=true;
		
		if (Configuration.base &&
		        Configuration.featureamp &&
				Configuration.gui &&
				Configuration.mp3 &&
				Configuration.filesupport &&
				Configuration.skins &&
				Configuration.dark &&
				Configuration.playlist &&
				Configuration.playlistcontrols &&
				Configuration.removetrack) {
			start();
			demo.menuItemWithPath("File", "Open Folder...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().approveButton().click();
		}
	}
	@Test
	public void reorderPlaylistTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.filesupport =true;
//		Configuration.mp3=true;
//		Configuration.playlist=true;
//		Configuration.playlistcontrols=true;
//		Configuration.removetrack=true;
//		Configuration.reorderplaylist=true;
//		Configuration.base=true;
		
		if (Configuration.base &&
		        Configuration.featureamp &&
				Configuration.gui &&
				Configuration.mp3 &&
				Configuration.filesupport &&
				Configuration.skins &&
				Configuration.dark &&
				Configuration.playlist &&
				Configuration.playlistcontrols &&
				Configuration.reorderplaylist &&
				Configuration.removetrack) {
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.list("p_list").click();
			demo.button("up").click();
			
			demo.list("p_list").click();
			demo.button("down").click();
		}
	}
	@Test
	public void saveandloadplaylistTest() throws Exception {
//		Configuration.filesupport =true;
//		Configuration.gui=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.progress=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.playlist=true;
//		Configuration.saveandloadplaylist=true;
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.progress &&
				Configuration.skins &&
				Configuration.playlist &&
				Configuration.saveandloadplaylist &&
				Configuration.light) {
			start();
		
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.menuItemWithPath("File", "Open...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("save").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));

			file = new File("p1.m3u");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
		}
	}
	@Test
	public void loadFolderTest() throws Exception {
//		Configuration.filesupport =true;
//		Configuration.gui=true;
//		Configuration.base=true;
//		Configuration.mp3=true;
//		Configuration.progress=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.playlist=true;
//		Configuration.loadfolder=true;
		
		if (Configuration.filesupport  &&
				Configuration.gui &&
				Configuration.base &&
				Configuration.mp3 &&
				Configuration.progress &&
				Configuration.skins &&
				Configuration.playlist &&
				Configuration.loadfolder &&
				Configuration.light) {
			start();
			demo.menuItemWithPath("File", "Open Folder...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			
		}
	}
	
	private void start() throws Exception{
		gui = new Main();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				gui.setVisible(true);
			}
		});
		demo = new FrameFixture(gui);
	}
}
