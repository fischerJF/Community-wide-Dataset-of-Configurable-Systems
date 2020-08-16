package testset;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import gui.DefaultPanel;
import gui.GUI;
import gui.Picture;
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
	private GUI gui;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
		
		if(demo!=null)
	    	demo.cleanUp();
	}

	@Test
	public void playOGGTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.ogg=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		
		if (Configuration.featureamp &&
				Configuration.gui &&
				Configuration.player &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.lightskin) {
			start();
			
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("discreet.OGG");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("play").click();
			demo.button("pause").click();
			demo.button("play").click();
			demo.button("stop").click();
			demo.button("play").click();
			demo.button("pause").click();
			demo.button("open").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("hollow.ogg");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			demo.button("pause").click();
			demo.button("stop").click();
			
			JButton button = (JButton) MemberModifier.field(GUI.class, "play").get(gui);
			assertEquals(button.getName(), "play");
			
			button = (JButton) MemberModifier.field(GUI.class, "pause").get(gui);
			assertEquals(button.getName(), "pause");
			
			button = (JButton) MemberModifier.field(GUI.class, "stop").get(gui);
			assertEquals(button.getName(), "stop");
			
			button = (JButton) MemberModifier.field(GUI.class, "open").get(gui);
			assertEquals(button.getName(), "open");
		}
	}
	@Test
	public void playMP3Test() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui &&
		Configuration.player &&
		Configuration.mp3 &&
		Configuration.skins &&
		Configuration.lightskin) {
			start();
			
			demo.menuItemWithPath("File", "Open File...").click();
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
			demo.button("open").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("discreet.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			demo.button("pause").click();
			demo.button("stop").click();
			
			JButton button = (JButton) MemberModifier.field(GUI.class, "play").get(gui);
			assertEquals(button.getName(), "play");
			assertEquals(button.getText(), "Play");
			
			button = (JButton) MemberModifier.field(GUI.class, "pause").get(gui);
			assertEquals(button.getName(), "pause");
			assertEquals(button.getText(), "Pause");
			
			button = (JButton) MemberModifier.field(GUI.class, "stop").get(gui);
			assertEquals(button.getName(), "stop");
			assertEquals(button.getText(), "Stop");
			
			button = (JButton) MemberModifier.field(GUI.class, "open").get(gui);
			assertEquals(button.getName(), "open");
			assertEquals(button.getText(), "Open");
		}
	}
	@Test
	public void volumecontrolTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.volumecontrol=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui &&
		Configuration.player &&
		Configuration.mp3 &&
		Configuration.skins &&
		Configuration.lightskin &&
		Configuration.volumecontrol) {
			
			start();
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			JSlider volume = (JSlider) MemberModifier.field(GUI.class, "volume").get(gui);
			assertEquals(volume.getName(),"volumeSlider");
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
	public void muteTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.mute=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui &&
		Configuration.player &&
		Configuration.mp3 &&
		Configuration.skins &&
		Configuration.lightskin &&
		Configuration.mute) {
			
			start();
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("mute").click();
			JButton mute = (JButton) MemberModifier.field(GUI.class, "muteButton").get(gui);
			assertEquals(mute.getName(), "mute");
			assertEquals(mute.getText(), "Mute");
		}
	}
	//@Test
	public void showtimeTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.time=true;
//		Configuration.showtime=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.lightskin   &&
		Configuration.time   &&
		Configuration.showtime  ) {
			start();
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("na_Gangorra.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			JLabel artist= (JLabel) MemberModifier.field(GUI.class, "artist").get(gui);
			JLabel title= (JLabel) MemberModifier.field(GUI.class, "title").get(gui);
			assertEquals(artist.getText(),"Mariana Aydar");
			assertEquals(title.getText(),"Na Gangorra");
		}
	}
	
		
	@Test
	public void progressBarTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.time=true;
//		Configuration.progressbar=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.lightskin   &&
		Configuration.time   &&
		Configuration.progressbar  ) {
			start();
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			JProgressBar progressBar = (JProgressBar) MemberModifier.field(GUI.class, "progress").get(gui);
			assertEquals(progressBar.getName(), "progress");
			demo.progressBar("progress").requireValue(0);
		}
	}
	@Test
	public void showCoverTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.showcover=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.lightskin   &&
		Configuration.showcover  ) {
			
			start();			
			
			Picture picture = (Picture) MemberModifier.field(GUI.class, "cover").get(gui);
			assertTrue(picture != null);
			assertTrue(picture.getMaximumSize().getWidth()==400);
			assertTrue(picture.getMaximumSize().getHeight()==400);
			assertTrue(picture.getMinimumSize().getWidth()==300);
			assertTrue(picture.getMinimumSize().getHeight()==300);
		}
	}
	
	
	@Test
	public void playSkipTrackTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.skiptrack=true;
//		Configuration. controlplayist=true;
//		Configuration. playlist=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.lightskin   &&
		Configuration.skiptrack &&
		Configuration.controlplayist &&
		Configuration.playlist
		
				) {
			start();
			
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file= new File("discreet.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			 file= new File("hollow.ogg");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("play").click();
			demo.button("skiptrack").click();
			demo.button("skiptrack").click();
		
			JButton button = (JButton) MemberModifier.field(GUI.class, "skipTrackButton").get(gui);
			assertEquals(button.getName(), "skiptrack");
			
			
		}
	}




	@Test
	public void playModeTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.shufflerepeat=true;
//		Configuration. controlplayist=true;
//		Configuration. playlist=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.lightskin   &&
		Configuration.shufflerepeat &&
		Configuration.controlplayist &&
		Configuration.playlist) {
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			JButton button = (JButton) MemberModifier.field(GUI.class, "modeButton").get(gui);

			demo.button("mode").click();
			assertEquals(button.getText(), "Repeat One");
	       demo.button("mode").click();
			assertEquals(button.getText(), "Repeat All");
			  System.out.println(button.getText());
			demo.button("mode").click();
			assertEquals(button.getText(), "Linear");
			  System.out.println(button.getText());
			demo.button("mode").click();
			assertEquals(button.getText(), "Repeat One");
			  System.out.println(button.getText());
			demo.button("mode").click();
			assertEquals(button.getText(), "Repeat All");
			  System.out.println(button.getText());
		}
	}
	@Test
	public void removeTrackTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		
//		Configuration.shufflerepeat=true;
//		Configuration.removetrack=true;
//		Configuration.playlist=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.lightskin   &&
		Configuration.shufflerepeat &&
		Configuration.removetrack &&
		Configuration.playlist) {
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.list("p_list").clickItem(0);
			demo.button("remove").click();
			
			demo.list("p_list").clickItem(0);
			demo.button("remove").click();
			
			demo.list("p_list").clickItem(0);
			demo.button("remove").click();
						
		}
	}
	
	
	@Test
	public void removePlayListTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.queuetrack=true;
//		Configuration.playlist=true;
//		Configuration.clearplaylist=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.lightskin   &&
		Configuration.queuetrack &&
		Configuration.playlist &&
		Configuration.clearplaylist
		) {
			
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.list("p_list").clickItem(0);
			demo.button("add").click();
			
			demo.list("p_list").clickItem(1);
			demo.button("add").click();
			
			demo.list("p_list").clickItem(0);
			demo.button("delete").click();
			
			demo.button("clear_playlist").click();
		}
	}
	@Test
	public void reorderplaylistTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		Configuration.reorderplaylist=true;
//		Configuration.playlist=true;
//		
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.lightskin   &&
		Configuration.reorderplaylist &&
		Configuration.playlist) {
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.list("p_list").clickItem(0);
			demo.button("down").click();
			
			demo.list("p_list").clickItem(1);
			demo.button("down").click();
			demo.list("p_list").clickItem(0);
			demo.button("up").click();
			
			demo.list("p_list").clickItem(1);
			demo.button("up").click();
		}
	}
	
	//@Test
	public void saveandlistTest() throws IllegalArgumentException, IllegalAccessException {
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
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.lightskin   &&
		Configuration.saveandloadplaylist &&
		Configuration.playlist &&
		Configuration.controlplayist &&
		Configuration.removetrack) {
			
			start();
			
			File file = new File("p2.m3u");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.menuItemWithPath("File", "Export playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file2 = new File("your-turn.mp3");
			demo.fileChooser().selectFile(file2);
			demo.fileChooser().approveButton().click();

		
			}
	}

	@Test
	public void clearplaylistTest() throws IllegalArgumentException, IllegalAccessException {
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
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.lightskin   &&
		Configuration.saveandloadplaylist &&
		Configuration.clearplaylist &&
		Configuration.playlist &&
		Configuration.controlplayist &&
		Configuration.removetrack) {
			
			start();
			
			File file = new File("discreet.mp3");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			file = new File("insight.mp3");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			
			demo.fileChooser().approveButton().click();
			file = new File("long-expected.mp3");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("clear_playlist").click();
			}
	}
	@Test
	public void init_lightskinTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.lightskin=true;
//		
		
		if (Configuration.featureamp &&
				Configuration.gui  &&
				Configuration.player   &&
				Configuration.mp3   &&
				Configuration.skins   &&
				Configuration.lightskin   ) {
			
			start();
			gui.init();
			DefaultPanel head = (DefaultPanel) MemberModifier.field(GUI.class, "head").get(gui);
			DefaultPanel meta = (DefaultPanel) MemberModifier.field(GUI.class, "meta").get(gui);
			DefaultPanel panelPlaylist = (DefaultPanel) MemberModifier.field(GUI.class, "panelPlaylist").get(gui);
			DefaultPanel content = (DefaultPanel) MemberModifier.field(GUI.class, "content").get(gui);
			DefaultPanel vol = (DefaultPanel) MemberModifier.field(GUI.class, "vol").get(gui);
			DefaultPanel buttons = (DefaultPanel) MemberModifier.field(GUI.class, "buttons").get(gui);
			
			assertTrue(head.getBackground() == Color.WHITE);
			assertTrue(meta.getBackground() == Color.WHITE);
			assertTrue(panelPlaylist.getBackground() ==Color.WHITE);
			assertTrue(content.getBackground() ==Color.WHITE);
			assertTrue(vol.getBackground() ==Color.WHITE);
			assertTrue(buttons.getBackground() ==Color.WHITE);
		}
	}
	@Test
	public void initTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.gui=true;
//		Configuration.player=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.darkskin=true;
//		
		
		if (Configuration.featureamp &&
		Configuration.gui  &&
		Configuration.player   &&
		Configuration.mp3   &&
		Configuration.skins   &&
		Configuration.darkskin   ) {
			
			start();
			gui.init();
			DefaultPanel head = (DefaultPanel) MemberModifier.field(GUI.class, "head").get(gui);
			DefaultPanel meta = (DefaultPanel) MemberModifier.field(GUI.class, "meta").get(gui);
			DefaultPanel panelPlaylist = (DefaultPanel) MemberModifier.field(GUI.class, "panelPlaylist").get(gui);
			DefaultPanel content = (DefaultPanel) MemberModifier.field(GUI.class, "content").get(gui);
			DefaultPanel vol = (DefaultPanel) MemberModifier.field(GUI.class, "vol").get(gui);
			DefaultPanel buttons = (DefaultPanel) MemberModifier.field(GUI.class, "buttons").get(gui);
			
			assertTrue(head.getBackground() == Color.DARK_GRAY);
			assertTrue(meta.getBackground() == Color.DARK_GRAY);
			assertTrue(panelPlaylist.getBackground() ==Color.DARK_GRAY);
			assertTrue(content.getBackground() ==Color.DARK_GRAY);
			assertTrue(vol.getBackground() ==Color.DARK_GRAY);
			assertTrue(buttons.getBackground() ==Color.DARK_GRAY);
		}
	}
	@Test
	public void LoadFolderTest() throws IllegalArgumentException, IllegalAccessException {
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
		if (Configuration.featureamp &&
		Configuration.gui &&
		Configuration.player &&
		Configuration.mp3 &&
		Configuration.skins &&
		Configuration.lightskin &&
		Configuration.skiptrack  &&
		Configuration.removetrack  &&
		Configuration.playlist  &&
		Configuration.reorderplaylist  &&
		Configuration.saveandloadplaylist &&
		Configuration.loadfolder) {
			start();
			
			demo.menuItemWithPath("File", "Open Folder...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().approveButton().click();
			
			demo.button("play").click();
		}
	}
//
//	@Test
//	public void queueListTest() throws IllegalArgumentException, IllegalAccessException {
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
//		
//		if (Configuration.time &&
//				Configuration.resizable &&
//				Configuration.wav &&
//				Configuration.supportedformats &&
//				Configuration.playlist &&
//				Configuration.control &&
//				Configuration.gui &&
//				Configuration.featureamp &&
//				Configuration.showtime &&
//				Configuration.id3information &&
//				Configuration.loadfolder &&
//				Configuration.base &&
//				Configuration.mp3 &&
//				Configuration.skins &&
//				Configuration.openfile &&
//				Configuration.queuetrack ) {
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
//
//	@Test
//	public void setTitleTest() throws IllegalArgumentException, IllegalAccessException {
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
//		
//		if (Configuration.time &&
//				Configuration.resizable &&
//				Configuration.wav &&
//				Configuration.supportedformats &&
//				Configuration.playlist &&
//				Configuration.control &&
//				Configuration.gui &&
//				Configuration.featureamp &&
//				Configuration.showtime &&
//				Configuration.id3information &&
//				Configuration.loadfolder &&
//				Configuration.base &&
//				Configuration.wav &&
//				Configuration.skins &&
//				Configuration.openfile) {
//			
//			start();
//			JFrame frame = (JFrame) MemberModifier.field(App.class, "frame").get(gui);
//			gui.setTitle("test");
//			assertEquals(gui.getFrame().getTitle(),"test");
//		}
//		
//			
//	}
//	

	
	private void start(){
		gui = new GUI();
		gui.init();
		demo = new FrameFixture(gui);
	}
}
