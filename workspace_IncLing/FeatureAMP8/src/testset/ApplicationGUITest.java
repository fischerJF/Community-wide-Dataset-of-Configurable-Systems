package testset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import engine.Application;

import specifications.Configuration;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
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
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import org.fest.swing.fixture.FrameFixture;

public class ApplicationGUITest {

	private FrameFixture demo;
	private Application gui;

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
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.ogg=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {
			start();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("discreet.OGG");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
			assertEquals(menu.getName(), "menu");
		}
		
	}
	@Test
	public void playWAVTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.wav=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.wav &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {
			start();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("alarme.wav");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
			assertEquals(menu.getName(), "menu");
		}
		
	}
	@Test
	public void changeSkinTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.light=false;
//	
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.dark &&
				!Configuration.light
				) {
			start();
			gui.changeSkin();
			
			JFrame frmAsd = (JFrame) MemberModifier.field(Application.class, "frmAsd").get(gui);
			assertTrue(frmAsd.getBackground().getRed()==238);
			assertTrue(frmAsd.getBackground().getGreen()==238);
			assertTrue(frmAsd.getBackground().getBlue()==238);
		}
		
	}
	@Test
	public void playMP3Test() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {
			start();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
			assertEquals(menu.getName(), "menu");
		}

	}

	@Test
	public void stopTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {
			start();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			demo.button("stop").click();
		}

	}

	@Test
	public void pauseTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {
			start();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("pause").click();
			demo.button("play").click();
		}
	}

	@Test
	public void muteTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.mute=true;
//		Configuration.volumecontrol=true;


		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.mute) {
			start();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			assertFalse(gui.muted);
			demo.button("mute").click();
			assertTrue(gui.muted);
			int oldVolume= (int) MemberModifier.field(Application.class, "oldVolume").get(gui);
			assertEquals(oldVolume, 100);
			//assertEquals(gui.getVolume(),0);
			JSlider slider= (JSlider) MemberModifier.field(Application.class, "slider").get(gui);
			assertFalse(slider.isEnabled());
		
			JButton btnmute= (JButton) MemberModifier.field(Application.class, "btnmute").get(gui);
			assertTrue(btnmute.getIcon().toString().contains("mute.png"));
			demo.button("mute").click();
			assertFalse(gui.muted);
			assertTrue(slider.isEnabled()); 
			assertEquals(gui.getVolume(),100);
			btnmute= (JButton) MemberModifier.field(Application.class, "btnmute").get(gui);
			assertTrue(btnmute.getIcon().toString().contains("unmute.png"));
			demo.slider("slider").slideToMinimum();
			assertEquals(gui.getVolume(),0);
			demo.slider("slider").slideToMaximum();
			assertEquals(gui.getVolume(),100);
			demo.slider("slider").slideTo(50);
			assertEquals(gui.getVolume(),50);
			
		}
	}
	@Test
	public void progressBar_2Test() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=false;
//		Configuration.ogg=true;
//		Configuration.gui=false;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=false;
		
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				!Configuration.mp3 &&
				Configuration.ogg &&
				!Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.tracktime &&
				!Configuration.progressbar 
				) {
			start();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
		
			assertTrue(gui.OGG);
		}
		
	}
	@Test
	public void progressBarTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.progressbar
				) {
			start();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
			assertEquals(menu.getName(), "menu");
			demo.progressBar("progressBar").requireValue(25);

		}
		
	}

	@Test
	public void queueListIsEmpty__wrappee__PlaylistTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.progressbar
				) {
			start();
			boolean b = (boolean) Whitebox.invokeMethod(gui, "queueListIsEmpty__wrappee__Playlist");
			assertTrue(b);
		}
	}

//	@Test
	public void removeTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=true;
//		Configuration.removetrack=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.playlist=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.progressbar &&
				Configuration.saveandloadplaylist &&
				Configuration.playlist && 
				Configuration.removetrack 
				) {
			start();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("discreet.OGG");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("discreet.OGG");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			 file = new File("alarme.wav");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("insight.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			 file = new File("note2.aaa");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
			demo.list("p_list").doubleClickItem(0);
			demo.list("p_list").doubleClickItem(1);
			demo.list("p_list").doubleClickItem(2);
			demo.list("p_list").doubleClickItem(3);
			
			
			demo.button("removeTrack").click();
		}
	}

	
	
	
	/**@Test*/
	public void salveTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=true;
//		Configuration.removetrack=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.playlist=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.progressbar &&
				Configuration.saveandloadplaylist &&
				Configuration.playlist && 
				Configuration.removetrack 
				) {
			start();
			File file = new File("p2.m3u");
			demo.menuItemWithPath("Datei", "Playlist laden").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file2 = new File("your-turn.mp3");
			demo.fileChooser().selectFile(file2);
			demo.fileChooser().approveButton().click();

			demo.menuItemWithPath("Datei", "Playlist speichern").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
		}
	}


	
	/*@Test*/
	public void clearListTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=true;
//		Configuration.removetrack=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.playlist=true;
//		Configuration.clearplaylist=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.progressbar &&
				Configuration.saveandloadplaylist &&
				Configuration.playlist && 
				Configuration.removetrack &&
				Configuration.clearplaylist
				) {
					start();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file = new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("insight.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("your-turn.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.button("clearList").click();

		}
	}



	/*@Test*/
	public void shufflerepeatTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=true;
//		Configuration.removetrack=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.playlist=true;
//		Configuration.clearplaylist=true;
//		Configuration.shufflerepeat=true;
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.progressbar &&
				Configuration.saveandloadplaylist &&
				Configuration.playlist && 
				Configuration.removetrack &&
				Configuration.clearplaylist &&
				Configuration.shufflerepeat
				) {
			start();
			JButton repeat;
			JButton playList;
			JButton suffle;
			
			demo.button("shuffle").click();
			repeat = (JButton) MemberModifier.field(Application.class, "repeatTrackbtn").get(gui);
			playList = (JButton) MemberModifier.field(Application.class, "repeatPlaylistbtn").get(gui);
			suffle = (JButton) MemberModifier.field(Application.class, "shufflebtn").get(gui);
			assertNotNull(repeat.getIcon());
			assertTrue(repeat.getIcon().toString().contains("red.png"));
			assertNotNull(playList.getIcon());
			assertTrue(playList.getIcon().toString().contains("red.png"));
			assertNotNull(suffle.getIcon());
			assertTrue(suffle.getIcon().toString().contains("green.png"));
			demo.button("shuffle").click();

			demo.button("repeatTrack").click();
			repeat = (JButton) MemberModifier.field(Application.class, "repeatTrackbtn").get(gui);
			playList = (JButton) MemberModifier.field(Application.class, "repeatPlaylistbtn").get(gui);
			suffle = (JButton) MemberModifier.field(Application.class, "shufflebtn").get(gui);
			assertNotNull(repeat.getIcon());
			assertTrue(repeat.getIcon().toString().contains("green.png"));
			assertNotNull(playList.getIcon());
			assertTrue(playList.getIcon().toString().contains("red.png"));
			assertNotNull(suffle.getIcon());
			assertTrue(suffle.getIcon().toString().contains("red.png"));
			demo.button("repeatTrack").click();
			
				
			demo.button("repeatPlaylist").click();
			repeat = (JButton) MemberModifier.field(Application.class, "repeatTrackbtn").get(gui);
			playList = (JButton) MemberModifier.field(Application.class, "repeatPlaylistbtn").get(gui);
			suffle = (JButton) MemberModifier.field(Application.class, "shufflebtn").get(gui);
			assertNotNull(repeat.getIcon());
			assertTrue(repeat.getIcon().toString().contains("red.png"));
			assertNotNull(playList.getIcon());
			assertTrue(playList.getIcon().toString().contains("green.png"));
			assertNotNull(suffle.getIcon());
			assertTrue(suffle.getIcon().toString().contains("red.png"));

			demo.button("repeatPlaylist").click();
		}
	}

	
	
	
	/**@Test*/
	public void tarckUpDownTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=true;
//		Configuration.removetrack=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.playlist=true;
//		Configuration.clearplaylist=true;
//		Configuration.reorderplaylist=true;
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.progressbar &&
				Configuration.saveandloadplaylist &&
				Configuration.playlist && 
				Configuration.removetrack &&
				Configuration.clearplaylist &&
				Configuration.reorderplaylist
				) {
			start();

			File file = new File("p1.m3u");
			demo.menuItemWithPath("Datei", "Playlist laden").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();

			demo.list("p_list").clickItem(1);
			demo.button("trackUp").click();
			demo.list("p_list").clickItem(0);
			demo.button("trackDown").click();
		}
	}

	/**@Test*/
	public void nextTrackTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.ogg=true;
//		Configuration.wav=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=true;
//		Configuration.removetrack=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.playlist=true;
//		Configuration.clearplaylist=true;
//		Configuration.reorderplaylist=true;
//		Configuration.skiptrack=true;
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.ogg &&
				Configuration.wav &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.progressbar &&
				Configuration.saveandloadplaylist &&
				Configuration.playlist && 
				Configuration.removetrack &&
				Configuration.clearplaylist &&
				Configuration.skiptrack
				) {
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			start();

			File file = new File("p1.m3u");
			demo.menuItemWithPath("Datei", "Playlist laden").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("nextTrack").click();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("alarme.wav");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			demo.button("nextTrack").click();
			demo.menuItemWithPath("Datei", "Datei \u00F6ffnen").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			file = new File("discreet.OGG");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
	
			
			assertTrue(os.toString().contains("discreet.mp3"));
			assertTrue(os.toString().contains("insight.mp3"));
			assertTrue(os.toString().contains("just-like-magic.mp3"));
			assertTrue(os.toString().contains("long-expected.mp3"));
			assertTrue(os.toString().contains("WAV"));
			assertTrue(os.toString().contains("OGG"));
			
		}
	}

	
	
	@Test
	public void queueListTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.queuetrack = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=true;
//		Configuration.removetrack=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.playlist=true;
//		Configuration.clearplaylist=true;
//		Configuration.reorderplaylist=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.progressbar &&
				Configuration.saveandloadplaylist &&
				Configuration.playlist && 
				Configuration.removetrack &&
				Configuration.clearplaylist &&
				Configuration.queuetrack
				) {

			start();

			File file = new File("p1.m3u");
			demo.menuItemWithPath("Datei", "Playlist laden").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.list("p_list").clickItem(1);
			demo.button("right").click();
			
			gui.skiptrack();
			demo.list("p_list").clickItem(0);
			demo.list("p_list").clickItem(0);
			demo.button("right").click();
			gui.skiptrack();

			demo.list("queueLis").clickItem(1);
			demo.button("left").click();
			gui.skiptrack();

			demo.list("queueLis").clickItem(0);
			demo.button("left").click();
			gui.skiptrack();

		}
	}

	@Test
	public void setTitelleisteTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.queuetrack=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.queuetrack ) {
			
			
			start();
			gui.setTitelleiste("test");
			
			JFrame g = (JFrame) MemberModifier.field(Application.class, "frmAsd").get(gui);
			
			assertEquals(g.getTitle(),"test");
			}
	}
	@Test
	public void setFrame_PTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.queuetrack=false;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.gui &&
				Configuration.skins &&
				!Configuration.queuetrack ) {
			
			
			start();
			gui.setFrame();
		
			JFrame g = (JFrame) MemberModifier.field(Application.class, "frmAsd").get(gui);
			
			assertTrue(g.getBounds().getX() == 100);
			assertTrue(g.getBounds().getY() == 100);
			assertTrue(g.getBounds().getWidth() == 807);
			assertTrue(g.getBounds().getHeight() == 511);
			assertTrue(g.getDefaultCloseOperation() == JFrame.EXIT_ON_CLOSE);
			assertTrue(g.getContentPane().getLayout() == null);
			assertTrue(g.getContentPane() != null);
		}
	}
	
	@Test
	public void setFrame__wrappee__FeatureAMPTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.ogg=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {
	
		
		start();
		Whitebox.invokeMethod(gui, "setFrame__wrappee__FeatureAMP");
		JFrame g = (JFrame) MemberModifier.field(Application.class, "frmAsd").get(gui);

		assertTrue(g.getBounds().getX() == 100);
		assertTrue(g.getBounds().getY() == 100);
		assertTrue(g.getBounds().getWidth() == 807);
		assertTrue(g.getBounds().getHeight() == 511);
		assertTrue(g.getDefaultCloseOperation() == JFrame.EXIT_ON_CLOSE);
		assertTrue(g.getContentPane().getLayout() == null);
		assertTrue(g.getContentPane() != null);
		}
	}

	
	

	
	
	
	
	
	
	
	
	//ok
	

	@Test
	public void addButtons__wrappee__VolumeControlTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.ogg=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.volumecontrol=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.volumecontrol) {
	
		start();
		Whitebox.invokeMethod(gui, "addButtons__wrappee__VolumeControl");
		JLabel lbl = (JLabel) MemberModifier.field(Application.class, "lblLautstrke").get(gui);
		assertTrue(lbl.getBounds().getX() == 26);
		assertTrue(lbl.getBounds().getY() == 313);
		assertTrue(lbl.getBounds().getWidth() == 55);
		assertTrue(lbl.getBounds().getHeight() == 14);
		}
	}

	@Test
	public void addButtons__wrappee__RemoveTrackTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.removetrack=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.removetrack 
				) {
			
			start();
			
			JButton  button=null;
			Whitebox.invokeMethod(gui, "addButtons__wrappee__RemoveTrack");
			JFrame frame = (JFrame) MemberModifier.field(Application.class, "frmAsd").get(gui);
			
			for (int i = 0; i < frame.getContentPane().getComponentCount(); i++) {
				if(frame.getContentPane().getComponent(i).getName()!= null && frame.getContentPane().getComponent(i).getName().equals("removeTrack")) {
					button = (JButton) frame.getContentPane().getComponent(i);
				}
			}
			
			assertTrue(button.getBounds().getX() == 635);
			assertTrue(button.getBounds().getY() == 324);
			assertTrue(button.getBounds().getWidth() == 135);
			assertTrue(button.getBounds().getHeight() == 23);
			assertTrue(button.getActionListeners()!= null);
		}
	}
	
	@Test
	public void addButtons__wrappee__ClearPlaylistTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.clearplaylist =true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.clearplaylist 
				) {
			
			start();
			
			JButton  button=null;
			Whitebox.invokeMethod(gui, "addButtons__wrappee__ClearPlaylist");
			JFrame frame = (JFrame) MemberModifier.field(Application.class, "frmAsd").get(gui);
			
			for (int i = 0; i < frame.getContentPane().getComponentCount(); i++) {
				if(frame.getContentPane().getComponent(i).getName()!= null && frame.getContentPane().getComponent(i).getName().equals("clearList")) {
					button = (JButton) frame.getContentPane().getComponent(i);
				}
			}

            assertTrue(button.getBounds().getX() == 361);
			assertTrue(button.getBounds().getY() == 324);
			assertTrue(button.getBounds().getWidth() == 111);
			assertTrue(button.getBounds().getHeight() == 23);
			assertTrue(button.getActionListeners()!= null);
		}
	}
	@Test
	public void addButtons__wrappee__ShuffleRepeatTest() throws Exception {
//	    	Configuration.shufflerepeat = true;
//			Configuration.featureamp=true;
//			Configuration.playengine=true;
//			Configuration.choosefile=true;
//			Configuration.ogg=true;
//			Configuration.gui=true;
//			Configuration.skins=true;
//			Configuration.light=true;
//			Configuration.filesupport=true;
//			Configuration.showtime=true;
//			Configuration.volumecontrol=true;
			
			if (Configuration.featureamp &&
					Configuration.playengine &&
					Configuration.choosefile &&
					Configuration.ogg &&
					Configuration.skins &&
					Configuration.light &&
					Configuration.filesupport &&
					Configuration.showtime &&
					Configuration.volumecontrol &&
					Configuration.shufflerepeat
			) {
		
			start();
			
				
			Whitebox.invokeMethod(gui, "addButtons__wrappee__ShuffleRepeat");
			JLabel repeat = (JLabel) MemberModifier.field(Application.class, "lblRepeatPlaylist").get(gui);
			assertTrue(repeat.getBounds().getX() == 181);
			assertTrue(repeat.getBounds().getY() == 104);
			assertTrue(repeat.getBounds().getWidth() == 82);
			assertTrue(repeat.getBounds().getHeight() == 14);

			JLabel suffle = (JLabel) MemberModifier.field(Application.class, "lblShuffle").get(gui);
			assertTrue(suffle.getBounds().getX() == 181);
			assertTrue(suffle.getBounds().getY() == 150);
			assertTrue(suffle.getBounds().getWidth() == 82);
			assertTrue(suffle.getBounds().getHeight() == 14);
			
			JButton repeatPlaylistbtn = (JButton) MemberModifier.field(Application.class, "repeatPlaylistbtn").get(gui);
			assertTrue(repeatPlaylistbtn.getIcon().toString().contains("red.png"));
		}
	}
	@Test
	public void addButtonsTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showcover=true;
//		Configuration.queuetrack=false;
//		Configuration.reorderplaylist=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.skins &&
				Configuration.gui &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showcover &&
				Configuration.reorderplaylist && 
				!Configuration.queuetrack 
				) {
			start();
			
			gui.addButtons();
			JFrame g = (JFrame) MemberModifier.field(Application.class, "frmAsd").get(gui);
			JButton  button =null;
			JButton  button2 =null;
			
			for (int i = 0; i < g.getContentPane().getComponentCount(); i++) {
				if(g.getContentPane().getComponent(i).getName()!= null && g.getContentPane().getComponent(i).getName().equals("trackUp")) {
					button = (JButton) g.getContentPane().getComponent(i);
				}
				else if(g.getContentPane().getComponent(i).getName()!= null && g.getContentPane().getComponent(i).getName().equals("trackDown")) {
					button2 = (JButton) g.getContentPane().getComponent(i);
				}
			}
			assertTrue(button.getBounds().getX() == 506);
			assertTrue(button.getBounds().getY() == 327);
			assertTrue(button.getBounds().getWidth() == 120);
			assertTrue(button.getBounds().getHeight() == 25);
			assertTrue(button.getActionListeners()!= null);
			
			assertTrue(button2.getBounds().getX() == 506);
			assertTrue(button2.getBounds().getY() == 360);
			assertTrue(button2.getBounds().getWidth() == 120);
			assertTrue(button2.getBounds().getHeight() == 25);
			assertTrue(button2.getActionListeners()!= null);
		}
	}
	@Test
	public void addButtons_2Test() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showcover=true;
//		Configuration.queuetrack=false;
//		Configuration.reorderplaylist=false;
//		Configuration.clearplaylist =true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.skins &&
				Configuration.gui &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showcover &&
				!Configuration.reorderplaylist && 
				!Configuration.queuetrack &&
				Configuration.clearplaylist ) {
			start();
			
			gui.addButtons();
			JFrame g = (JFrame) MemberModifier.field(Application.class, "frmAsd").get(gui);
			JButton  button =null;
			
			for (int i = 0; i < g.getContentPane().getComponentCount(); i++) {
				if(g.getContentPane().getComponent(i).getName()!= null && g.getContentPane().getComponent(i).getName().equals("clearList")) {
					button = (JButton) g.getContentPane().getComponent(i);
				}
			}
			assertTrue(button.getBounds().getX() == 361);
			assertTrue(button.getBounds().getY() == 324);
			assertTrue(button.getBounds().getWidth() == 111);
			assertTrue(button.getBounds().getHeight() == 23);
			assertTrue(button.getActionListeners()!= null);
			
			}
	}
	@Test
	public void addButtons__wrappee__SkipTrackTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.ogg=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.volumecontrol=true;
//		Configuration.skiptrack=true;
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.volumecontrol &&
				Configuration.shufflerepeat &&
				Configuration.skiptrack
		) {
		start();
			
			Configuration.skiptrack = false;
			
			Whitebox.invokeMethod(gui, "addButtons__wrappee__SkipTrack");
			JButton button = (JButton) MemberModifier.field(Application.class, "btnNextTrack").get(gui);
			assertTrue(button.getBounds().getX() == 100);
			assertTrue(button.getBounds().getY() == 279);
			assertTrue(button.getBounds().getWidth() == 64);
			assertTrue(button.getBounds().getHeight() == 23);
		}
	}
	@Test
	public void addButtons__wrappee__PlaylistTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.ogg=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.volumecontrol=true;
//		Configuration.playlist=true;
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.volumecontrol &&
				Configuration.shufflerepeat &&
				Configuration.playlist
		) {
			start();
			
			
			Whitebox.invokeMethod(gui, "addButtons__wrappee__Playlist");
			JScrollPane scroll = (JScrollPane) MemberModifier.field(Application.class, "scrollPane").get(gui);
			assertTrue(scroll.getBounds().getX() == 361);
			assertTrue(scroll.getBounds().getY() == 49);
			assertTrue(scroll.getBounds().getWidth() == 409);
			assertTrue(scroll.getBounds().getHeight() == 264);
		}
	}
	@Test
	public void  addButtons__wrappee__QueueTrackTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.ogg=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.volumecontrol=true;
//		Configuration.queuetrack=true;
//		Configuration.showcover=true;
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.volumecontrol &&
				Configuration.shufflerepeat &&
				Configuration.playlist &&
				Configuration.queuetrack &&
				Configuration.showcover
		) {	start();
			
			
			Whitebox.invokeMethod(gui, "addButtons__wrappee__QueueTrack");
			JScrollPane scroll = (JScrollPane) MemberModifier.field(Application.class, "queueScrollPane").get(gui);
			assertTrue(scroll.getBounds().getX() == 850);
			assertTrue(scroll.getBounds().getY() == 49);
			assertTrue(scroll.getBounds().getWidth() == 259);
			assertTrue(scroll.getBounds().getHeight() == 300);
			
			JButton btnqueueleft  = (JButton) MemberModifier.field(Application.class, "btnqueueleft").get(gui);
			assertTrue(btnqueueleft.getBounds().getX() ==790);
			assertTrue(btnqueueleft.getBounds().getY() == 200);
			assertTrue(btnqueueleft.getBounds().getWidth() == 50);
			assertTrue(btnqueueleft.getBounds().getHeight() == 23);
			
			JLabel coverlbl  = (JLabel) MemberModifier.field(Application.class, "coverlbl").get(gui);
			assertTrue(coverlbl.getBounds().getX() ==13);
			assertTrue(coverlbl.getBounds().getY() == 59);
			assertTrue(coverlbl.getBounds().getWidth() == 164);
			assertTrue(coverlbl.getBounds().getHeight() == 147);
			assertTrue(coverlbl.getIcon().toString().contains("img.jpg"));

		}
	}
	@Test
	public void addEngine_Test() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime 
				) {
			start();
			
			gui.addEngine();	
		}
	}
	@Test
	public void addTrack_Test() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.playlist=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.playlist 
				) {
			start();
			File file = new File("media/note.mp3");
			gui.addTrack("note",file);	
		}
	}
	@Test
	public void stopPlaying_Test() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.playlist=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.playlist 
				) {
			start();
			gui.stopPlaying();	
		}
	}
	@Test
	public void aaddMenu__wrappee__ChooseFile_Test() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.choosefile=true;
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.choosefile
				) {
			start();
			
			
			Whitebox.invokeMethod(gui, "addMenu__wrappee__ChooseFile");
			JMenuBar bar = (JMenuBar) MemberModifier.field(Application.class, "menuBar").get(gui);
			assertNotNull(bar);
		}
	}
	@Test
	public void addButtons__wrappee__ProgressBarTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.progressbar=true;
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime &&
				Configuration.progressbar
				) {
			start();
			
			
			Whitebox.invokeMethod(gui, "addButtons__wrappee__ProgressBar");
			JProgressBar bar = (JProgressBar) MemberModifier.field(Application.class, "progressBar").get(gui);
			assertTrue(bar.getBounds().getX() == 26);
			assertTrue(bar.getBounds().getY() == 251);
			assertTrue(bar.getBounds().getWidth() == 301);
			assertTrue(bar.getBounds().getHeight() == 17);
			assertTrue(bar.isStringPainted());
		}
	}
	@Test
	public void addButtons__wrappee__MuteTest() throws Exception {
//		Configuration.featureamp = true;
//		Configuration.playengine = true;
//		Configuration.choosefile = true;
//		Configuration.ogg = true;
//		Configuration.skins = true;
//		Configuration.light = true;
//		Configuration.filesupport  = true;
//		Configuration.showtime  = true;
//		Configuration.volumecontrol  = true;
//		Configuration.shufflerepeat  = true;
//		Configuration.playlist  = true;
//		Configuration.mute = true;
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.volumecontrol &&
				Configuration.shufflerepeat &&
				Configuration.playlist &&
				Configuration.mute
		) {	
			start();

			
			Whitebox.invokeMethod(gui, "addButtons__wrappee__Mute");
			JButton btnmute = (JButton) MemberModifier.field(Application.class, "btnmute").get(gui);
			assertTrue(btnmute.getIcon().toString().contains("unmute.png"));
		}
	}

	@Test
	public void guiElementsTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.volumecontrol=true;
//		Configuration.mute=true;
		if (Configuration.shufflerepeat &&
		Configuration.featureamp&&
		Configuration.playengine&&
		Configuration.choosefile&&
		Configuration.gui&&
		Configuration.skins&&
		Configuration.light&&
		Configuration.filesupport&&
		Configuration.showtime&&
		Configuration.volumecontrol&&
		Configuration.mute
		) {	

		start();
		JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
		assertEquals(menu.getName(), "menu");
		JMenuItem menuItem = menu.getItem(0);
		assertTrue(menuItem.getComponentListeners() != null);
		}
	}

	@Test
	public void addMenu_2Test() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.saveandloadplaylist=false;
//		Configuration.loadfolder=false;
//		Configuration.choosefile=false;
		if (Configuration.shufflerepeat &&
				Configuration.featureamp&&
				Configuration.playengine&&
				Configuration.gui&&
				Configuration.skins&&
				Configuration.light &&
				!Configuration.loadfolder &&
				!Configuration.choosefile &&
				!Configuration.saveandloadplaylist) {	
			start();
			gui.addMenu();
			JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
			assertNotNull(menu);
			
		}
	}
	@Test
	public void addMenuTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
		if (Configuration.shufflerepeat &&
		Configuration.featureamp&&
		Configuration.playengine&&
		Configuration.choosefile&&
		Configuration.gui&&
		Configuration.skins&&
		Configuration.light
		) {	
			start();
			gui.addMenu();
			JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
			assertNotNull(menu);

		}
	}

	@Test
	public void addMenu__wrappee__LoadFolder_3Test() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.loadfolder=false;
//		Configuration.choosefile=false;
		
		if (Configuration.shufflerepeat &&
				Configuration.featureamp&&
				Configuration.playengine&&
				Configuration.gui&&
				Configuration.skins&&
				Configuration.light&&
				!Configuration.choosefile&&
				!Configuration.loadfolder) {	
			
			start();
			Whitebox.invokeMethod(gui, "addMenu__wrappee__LoadFolder");
			JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
			assertNotNull(menu);
			
		}
	}
	@Test
	public void addMenu__wrappee__LoadFolderTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.volumecontrol=true;
//		Configuration.mute=true;
		if (Configuration.shufflerepeat &&
		Configuration.featureamp&&
		Configuration.playengine&&
		Configuration.choosefile&&
		Configuration.gui&&
		Configuration.skins&&
		Configuration.light&&
		Configuration.filesupport&&
		Configuration.showtime&&
		Configuration.volumecontrol&&
		Configuration.mute
		) {	

			start();
			Whitebox.invokeMethod(gui, "addMenu__wrappee__LoadFolder");
			JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
			assertNotNull(menu);

		}
	}

	@Test
	public void addMenu__wrappee__ChooseFile_2Test() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.choosefile=false;
		if (Configuration.shufflerepeat &&
				Configuration.featureamp&&
				Configuration.playengine&&
				!Configuration.choosefile&&
				Configuration.gui&&
				Configuration.skins&&
				Configuration.light) {	
			start();
			Whitebox.invokeMethod(gui, "addMenu__wrappee__ChooseFile");
			JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
			assertNotNull(menu);
			
		}
	}
	@Test
	public void addMenu__wrappee__ChooseFileTest() throws Exception {
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.volumecontrol=true;
//		Configuration.mute=true;
		if (Configuration.shufflerepeat &&
		Configuration.featureamp&&
		Configuration.playengine&&
		Configuration.choosefile&&
		Configuration.gui&&
		Configuration.skins&&
		Configuration.light&&
		Configuration.filesupport&&
		Configuration.showtime&&
		Configuration.volumecontrol&&
		Configuration.mute
		) {	
			start();
			Whitebox.invokeMethod(gui, "addMenu__wrappee__ChooseFile");
			JMenu menu = (JMenu) MemberModifier.field(Application.class, "menu").get(gui);
			assertNotNull(menu);

		}
	}

	
	@Test
	public void addButtons__wrappee__ShowTimeTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=false;
//		Configuration.ogg=false;
//		Configuration.wav=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=false;
		
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				!Configuration.mp3 &&
				!Configuration.ogg &&
				Configuration.wav &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				!Configuration.showtime) {	
			start();
			
			Whitebox.invokeMethod(gui, "addButtons__wrappee__GUI");
			assertFalse(gui.showTime);
		}
	}
	@Test
	public void addButtons__wrappee__ProgressBar_2Test() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=false;
//		Configuration.ogg=false;
//		Configuration.wav=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.progressbar=false;
		
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				!Configuration.mp3 &&
				!Configuration.ogg &&
				Configuration.wav &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				!Configuration.progressbar) {	
			start();
			
			Whitebox.invokeMethod(gui, "addButtons__wrappee__ProgressBar");
			JProgressBar progressBar = (JProgressBar) MemberModifier.field(Application.class, "progressBar").get(gui);

			assertNull(progressBar);
		}
	}
	@Test
	public void addButtons__wrappee__WAVTest() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=false;
//		Configuration.ogg=false;
//		Configuration.wav=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
		
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				!Configuration.mp3 &&
				!Configuration.ogg &&
				Configuration.wav &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport) {	
			start();
			assertFalse(gui.OGG);
			Whitebox.invokeMethod(gui, "addButtons__wrappee__OGG");
			assertTrue(gui.WAV);
		}
	}
	@Test
	public void addButtons__wrappee__MP3Test() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=false;
//		Configuration.ogg=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
		
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				!Configuration.mp3 &&
				Configuration.ogg &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport) {	
			    start();
				assertFalse(gui.MP3);
				Whitebox.invokeMethod(gui, "addButtons__wrappee__MP3");
				assertTrue(gui.OGG);
		}
	}

	@Test
	public void setFrameTest() throws Exception {
//		Configuration.queuetrack = true;
//		Configuration.shufflerepeat = true;
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.volumecontrol=true;
//		Configuration.mp3=true;
		if (Configuration.shufflerepeat &&
		Configuration.featureamp&&
		Configuration.playengine&&
		Configuration.choosefile&&
		Configuration.gui&&
		Configuration.skins&&
		Configuration.light&&
		Configuration.filesupport&&
		Configuration.showtime&&
		Configuration.volumecontrol&&
		Configuration.mp3 &&
		Configuration.queuetrack) {
			start();
			gui.setFrame();
			JFrame g = (JFrame) MemberModifier.field(Application.class, "frmAsd").get(gui);
			assertTrue(g.getBounds().getX() == 100);
			assertTrue(g.getBounds().getY() == 100);
			assertTrue(g.getBounds().getWidth() == 1207);
			assertTrue(g.getBounds().getHeight() == 511);
			assertTrue(g.getDefaultCloseOperation() == JFrame.EXIT_ON_CLOSE);
			assertTrue(g.getContentPane().getLayout() == null);
			assertTrue(g.getContentPane() != null);
		}

	}

	@Test
	public void setFrameTest2() throws Exception {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {
					start();
			gui.setFrame();
		}

	}

	@Test
	public void myRandomTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {
		
		start();
		int n = gui.myRandom(1, 1);
		assertTrue(n == 1);

		n = gui.myRandom(2, 2);
		assertTrue(n == 2);

		n = gui.myRandom(0, 0);
		assertTrue(n == 0);
		
		n = gui.myRandom(4, 4);
		assertTrue(n == 4);

		n = gui.myRandom(1000, 1001);
		assertTrue(n == 1000 || n == 1001);
		
		}
	}

	@Test
	public void getDurationOfWavInSecondsTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {
		start();
		File file = new File("note.mp3");

		double seconds = gui.getDurationOfWavInSeconds(file);
		double resp = -1.0;
		assertTrue(seconds == resp);
		}
	}

	@Test
	public void getZuordnungslisteTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.mp3 &&
				Configuration.gui &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {
			
		start();
		assertTrue(gui.getZuordnungsliste() != null);
		}
	}
	
	@Test
	public void addEngineTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.ogg=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
		
		if (Configuration.featureamp &&
				Configuration.playengine &&
				Configuration.choosefile &&
				Configuration.ogg &&
				Configuration.skins &&
				Configuration.light &&
				Configuration.filesupport &&
				Configuration.showtime &&
				Configuration.tracktime) {			start();
			
			JButton play = (JButton) MemberModifier.field(Application.class, "btnPlay").get(gui);
			assertTrue(play.getBounds().getX() == 26);
			assertTrue(play.getBounds().getY() == 279);
			assertTrue(play.getBounds().getWidth() == 64);
			assertTrue(play.getBounds().getHeight() == 23);

			JButton stop = (JButton) MemberModifier.field(Application.class, "btnStop").get(gui);
			assertTrue(stop.getBounds().getX() == 174);
			assertTrue(stop.getBounds().getY() == 279);
			assertTrue(stop.getBounds().getWidth() == 72);
			assertTrue(stop.getBounds().getHeight() == 23);
			
			JButton pause = (JButton) MemberModifier.field(Application.class, "btnPause").get(gui);
			assertTrue(pause.getBounds().getX() == 256);
			assertTrue(pause.getBounds().getY() == 279);
			assertTrue(pause.getBounds().getWidth() == 71);
			assertTrue(pause.getBounds().getHeight() == 23);
		}
	}
   @Test
	public void addMenu__wrappee__LoadFolder_2Test() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.featureamp=true;
//		Configuration.playengine=true;
//		Configuration.choosefile=true;
//		Configuration.mp3=true;
//		Configuration.gui=true;
//		Configuration.skins=true;
//		Configuration.light=true;
//		Configuration.filesupport=true;
//		Configuration.showtime=true;
//		Configuration.tracktime=true;
//		Configuration.playlist=true;
//		Configuration.loadfolder=true;
//		Configuration.control=false;
//		
//		Configuration.volumecontrol=true;
//		Configuration.skiptrack=false;
//		Configuration.progressbar=true;	
//		Configuration.removetrack=false;
//		Configuration.wav=true;
//		Configuration.reorderplaylist=false;
//		Configuration.saveandloadplaylist=true;
//		
//		Configuration.queuetrack=true;
//		Configuration.mute=true;
//		Configuration.shufflerepeat=false;
//		Configuration.ogg=true;
//		Configuration.dark=false;
//		Configuration.clearplaylist=false;
//		Configuration.showcover=false;
		
		if (Configuration.featureamp &&
		Configuration.playengine&&
		Configuration.choosefile&&
		Configuration.mp3&&
		Configuration.ogg&&
		Configuration.wav&&
		Configuration.gui&&
		Configuration.skins&&
		Configuration.light&&
		Configuration.filesupport&&
		Configuration.showtime&&
		Configuration.tracktime&&
		Configuration.playlist &&
		Configuration.saveandloadplaylist &&
		Configuration.loadfolder &&
		Configuration.queuetrack
		
		) {
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			
			start();
		
			demo.menuItemWithPath("Datei", "Ordner \u00F6ffnen").click();
			demo.fileChooser().approveButton().click();
			assertTrue(os.toString().contains("discreet.mp3"));
			assertTrue(os.toString().contains("insight.mp3"));
			assertTrue(os.toString().contains("just-like-magic.mp3"));
			assertTrue(os.toString().contains("long-expected.mp3"));
			assertTrue(os.toString().contains("note.mp3"));
			assertTrue(os.toString().contains("your-turn.mp3"));
			assertTrue(os.toString().contains("discreet.OGG"));
			assertTrue(os.toString().contains("alarme.wav"));
		}

	}

	private void start() throws IllegalArgumentException, IllegalAccessException {

		gui = new Application();
		JFrame g = (JFrame) MemberModifier.field(Application.class, "frmAsd").get(gui);
		demo = new FrameFixture(g);
	}
}
