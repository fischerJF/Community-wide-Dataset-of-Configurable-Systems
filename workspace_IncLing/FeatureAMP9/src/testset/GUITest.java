package testset;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextField;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import gui.Gui;
import gui.Playlist;
import players.Player;
import players.TrackMetadata;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class GUITest {

	private Gui gui;

	@Before
	public void setUp() {
		gui = new Gui();
	}

	@Test
	public void init__wrappee__GUITest() throws Exception {
		Whitebox.invokeMethod(gui, "init__wrappee__GUI");

		JMenu menu = (JMenu) MemberModifier.field(Gui.class, "fileMenu").get(gui);
		assertTrue(menu instanceof JMenu);
		assertNotNull(menu);
		assertEquals(menu.getText(), "File");

		assertTrue(menu.getMenuComponent(0) instanceof JMenuItem);
		assertTrue(menu.getMenuComponent(1) instanceof Separator);
		assertTrue(menu.getMenuComponent(2) instanceof JMenuItem);
		
//		JButton close = (JButton) MemberModifier.field(Gui.class, "closeButton").get(gui);
//		assertEquals(close.getActionCommand(), "exit");
		
		JButton play = (JButton) MemberModifier.field(Gui.class, "playButton").get(gui);
		assertTrue(play instanceof JButton);
		assertNotNull(play);
		assertEquals(play.getText(), "Play");
		assertEquals(play.getName(), "play");
		assertEquals(play.getActionCommand(), "play");
		assertNotNull(play.getComponentListeners());

		JButton pause = (JButton) MemberModifier.field(Gui.class, "pauseButton").get(gui);
		assertTrue(pause instanceof JButton);
		assertNotNull(pause);
		assertEquals(pause.getText(), "Pause");
		assertEquals(pause.getName(), "pause");
		assertEquals(pause.getActionCommand(), "pause");
		assertNotNull(pause.getComponentListeners());

		JButton stop = (JButton) MemberModifier.field(Gui.class, "stopButton").get(gui);
		assertTrue(stop instanceof JButton);
		assertNotNull(stop);
		assertEquals(stop.getText(), "Stop");
		assertEquals(stop.getName(), "stop");
		assertEquals(stop.getActionCommand(), "stop");
		assertNotNull(stop.getComponentListeners());
	}

	@Test
	public void init__wrappee__MuteTest() throws Exception {
//		Configuration.mute = true;

		if (Configuration.mute) {
			Whitebox.invokeMethod(gui, "init__wrappee__Mute");
			JButton mute = (JButton) MemberModifier.field(Gui.class, "muteButton").get(gui);
			assertTrue(mute instanceof JButton);
			assertNotNull(mute);
			double d = 16.0;
			assertTrue(mute.getPreferredSize().getWidth() == d);
			assertTrue(mute.getPreferredSize().getHeight() == d);
			assertTrue(mute.getMaximumSize().getWidth() == d);
			assertTrue(mute.getMaximumSize().getHeight() == d);
			assertEquals(mute.getActionCommand(), "mute");
			assertNotNull(mute.getComponentListeners());
			assertNull(mute.getIcon());
		}
	}

	@Test
	public void init__wrappee__Mute_MuteFalse_Test() throws Exception {
//		Configuration.mute = false;
//		Configuration.volumecontrol = true;
		if (!Configuration.mute && Configuration.volumecontrol) {
			Whitebox.invokeMethod(gui, "init__wrappee__Mute");
			JSlider volume = (JSlider) MemberModifier.field(Gui.class, "volume").get(gui);
			assertTrue(volume instanceof JSlider);
			assertNotNull(volume);
			assertEquals(volume.getMinimum(), 0);
			assertEquals(volume.getMaximum(), 100);
			assertEquals(volume.getValue(), 100);
			assertNotNull(volume.getChangeListeners());
			JLabel volLabel = (JLabel) MemberModifier.field(Gui.class, "volLabel").get(gui);
			assertTrue(volLabel instanceof JLabel);
			assertNotNull(volLabel);
			assertEquals(volLabel.getText(), "100");
		}
	}

	@Test
	public void init__wrappee__ProgressBarTest() throws Exception {
//		Configuration.progressbar = true;
		if (Configuration.progressbar) {
			Whitebox.invokeMethod(gui, "init__wrappee__ProgressBar");
			JProgressBar pb = (JProgressBar) MemberModifier.field(Gui.class, "pb").get(gui);

			assertEquals(pb.getMinimum(), 0);
			assertEquals(pb.getMaximum(), 10000);

			assertEquals(pb.getValue(), 0);

		}
	}

	@Test
	public void init__wrappee__ProgressBar_progressbarFalse_Test() throws Exception {
//		Configuration.progressbar = false;
		if (!Configuration.progressbar) {
			init__wrappee__GUITest();
		}
	}

	@Test
	public void init__wrappee__VolumeControlTest() throws Exception {
//		Configuration.volumecontrol = true;
		if (Configuration.volumecontrol) {
			Whitebox.invokeMethod(gui, "init__wrappee__VolumeControl");
			JSlider volume = (JSlider) MemberModifier.field(Gui.class, "volume").get(gui);

			assertEquals(volume.getMinimum(), 0);
			assertEquals(volume.getMaximum(), 100);
			assertEquals(volume.getValue(), 100);

			assertEquals(volume.getValue(), 100);

		}
	}

	@Test
	public void init__wrappee__VolumeControl_volumecontrolFalse_Test() throws Exception {
//		Configuration.volumecontrol = false;
		if (!Configuration.volumecontrol) {
			Whitebox.invokeMethod(gui, "init__wrappee__ProgressBar");
			init__wrappee__ProgressBarTest();
		}
	}

	@Test
	public void init__wrappee__ShowCoverTest() throws Exception {
//		Configuration.showcover = true;
		if (Configuration.showcover) {
			Whitebox.invokeMethod(gui, "init__wrappee__ShowCover");
			JLabel cover = (JLabel) MemberModifier.field(Gui.class, "cover").get(gui);
		}
	}

	@Test
	public void init__wrappee__ShowCover_showcoverFalse_Test() throws Exception {
//		Configuration.showcover = false;
		if (!Configuration.showcover) {
			Whitebox.invokeMethod(gui, "init__wrappee__ShowCover");
			init__wrappee__MuteTest();
		}
	}

//	@Test
//	public void init__wrappee__Playlist() throws Exception {
//		 Configuration.playlist=true;
//		 if (Configuration.playlist) {
//		 Whitebox.invokeMethod(gui, "init__wrappee__Playlist");
//		 JList jplaylist= (JList) MemberModifier.field(Gui.class,
//		 "jplaylist").get(gui);
//		// assertTrue(jplaylist instanceof JList);
//		 }
//	}

	@Test
	public void init__wrappee__ShuffleRepeatTest() throws Exception {
//		Configuration.shufflerepeat = true;
		if (Configuration.shufflerepeat) {
			Whitebox.invokeMethod(gui, "init__wrappee__ShuffleRepeat");
			JButton buton = (JButton) MemberModifier.field(Gui.class, "shuffleButton").get(gui);
			assertTrue(buton instanceof JButton);
			assertNotNull(buton);
			assertEquals(buton.getText(), "Shuffle");
			assertEquals(buton.getActionCommand(), "shuffle");
			assertNotNull(buton.getComponentListeners());

			JButton modeButton = (JButton) MemberModifier.field(Gui.class, "modeButton").get(gui);
			assertTrue(modeButton instanceof JButton);
			assertNotNull(modeButton);
			assertEquals(modeButton.getText(), "Linear");
			assertEquals(modeButton.getActionCommand(), "mode");
			assertNotNull(modeButton.getComponentListeners());
		}
	}

	@Test
	public void init__wrappee__SkipTrackTest() throws Exception {
//		Configuration.skiptrack = true;
		if (Configuration.skiptrack) {
			Whitebox.invokeMethod(gui, "init__wrappee__SkipTrack");
			JButton skipButton = (JButton) MemberModifier.field(Gui.class, "skipButton").get(gui);
			assertTrue(skipButton instanceof JButton);
			assertEquals(skipButton.getText(), "Skip");
			assertNotNull(skipButton.getComponentListeners());
		}
	}

	@Test
	public void init__wrappee__RemoveTrackTest() throws Exception {
//		Configuration.removetrack = true;
		if (Configuration.removetrack) {
			Whitebox.invokeMethod(gui, "init__wrappee__RemoveTrack");
			JButton removeButton = (JButton) MemberModifier.field(Gui.class, "removeButton").get(gui);
			assertTrue(removeButton instanceof JButton);
			assertEquals(removeButton.getText(), "Remove");
			assertNotNull(removeButton.getComponentListeners());
		}
	}

	@Test
	public void init__wrappee__ClearPlaylistTest() throws Exception {
//		Configuration.clearplaylist = true;
		if (Configuration.clearplaylist) {
			Whitebox.invokeMethod(gui, "init__wrappee__ClearPlaylist");
			JButton clearButton = (JButton) MemberModifier.field(Gui.class, "clearButton").get(gui);
			assertTrue(clearButton instanceof JButton);
			assertEquals(clearButton.getText(), "Clear");
			assertNotNull(clearButton.getComponentListeners());
		}
	}

	@Test
	public void init__wrappee__ReorderPlaylistTest() throws Exception {
//		Configuration.reorderplaylist=true;
		if (Configuration.reorderplaylist) {
			Whitebox.invokeMethod(gui, "init__wrappee__ReorderPlaylist");
			JButton upButton = (JButton) MemberModifier.field(Gui.class, "upButton").get(gui);
			assertTrue(upButton instanceof JButton);
			assertEquals(upButton.getText(), "Up");
			assertEquals(upButton.getActionCommand(), "up");
			assertNotNull(upButton.getComponentListeners());

			
			JButton downButton = (JButton) MemberModifier.field(Gui.class, "downButton").get(gui);
			assertTrue(downButton instanceof JButton);
			assertEquals(downButton.getText(), "Down");
			assertEquals(downButton.getActionCommand(), "down");
			assertNotNull(downButton.getComponentListeners());

		}
	}
	
	@Test
	public void init__wrappee__SaveAndLoadPlaylistTest_() throws Exception {
//		Configuration.saveandloadplaylist=true;
		if (Configuration.saveandloadplaylist) {
			Whitebox.invokeMethod(gui, "init__wrappee__SaveAndLoadPlaylist");
			JButton upButton = (JButton) MemberModifier.field(Gui.class, "skipButton").get(gui);
			assertTrue(upButton instanceof JButton);
			assertEquals(upButton.getText(), "Skip");
			assertNotNull(upButton.getComponentListeners());
			JMenuItem exportPlist = (JMenuItem) MemberModifier.field(Gui.class, "exportPlist").get(gui);
			assertTrue(exportPlist instanceof JMenuItem);
			assertEquals(exportPlist.getText(), "Export playlist");
			assertEquals(exportPlist.getActionCommand(), "export");
			
			JMenuItem importPlist = (JMenuItem) MemberModifier.field(Gui.class, "importPlist").get(gui);
			assertEquals(importPlist.getText(), "Import playlist");
			assertEquals(importPlist.getActionCommand(), "import");
			assertNotNull(importPlist.getComponentListeners());
		}
//		Configuration.saveandloadplaylist=false;
	}
	
	@Test
	public void initTest() throws Exception {
//		Configuration.queuetrack=true;
		if (Configuration.queuetrack) {
			Whitebox.invokeMethod(gui, "init");
			JButton queueButton = (JButton) MemberModifier.field(Gui.class, "queueButton").get(gui);
			assertTrue(queueButton instanceof JButton);
			assertTrue(queueButton instanceof JButton);
			assertEquals(queueButton.getText(), "+ Queue");
			assertEquals(queueButton.getActionCommand(), "queue");
			assertNotNull(queueButton.getComponentListeners());
		}
	}
	
//	@Test
	public void grouplayoutTest() throws Exception {
		
		Whitebox.invokeMethod(gui, "init__wrappee__GUI");
		gui.grouplayout();
		GroupLayout.SequentialGroup horz = (GroupLayout.SequentialGroup) MemberModifier.field(Gui.class, "horzCoverPbButtonsVolume").get(gui);
		assertTrue(horz instanceof GroupLayout.SequentialGroup);
		
		GroupLayout.SequentialGroup horzVolume = (GroupLayout.SequentialGroup) MemberModifier.field(Gui.class, "horzVolume").get(gui);
		assertTrue(horzVolume instanceof GroupLayout.SequentialGroup);
	
		GroupLayout.SequentialGroup horzPlaylist = (GroupLayout.SequentialGroup) MemberModifier.field(Gui.class, "horzPlaylist").get(gui);
		assertTrue(horzPlaylist instanceof GroupLayout.SequentialGroup);
		
		GroupLayout.ParallelGroup vert = (GroupLayout.ParallelGroup) MemberModifier.field(Gui.class, "vertCoverPbButtonsVolume").get(gui);
		assertTrue(vert instanceof GroupLayout.ParallelGroup);
		
		GroupLayout.SequentialGroup vertPbButtonsVolume = (GroupLayout.SequentialGroup) MemberModifier.field(Gui.class, "vertPbButtonsVolume").get(gui);
		assertTrue(vertPbButtonsVolume instanceof GroupLayout.SequentialGroup);
		
		GroupLayout.ParallelGroup vertVolume = (GroupLayout.ParallelGroup) MemberModifier.field(Gui.class, "vertVolume").get(gui);
		assertTrue(vertVolume instanceof GroupLayout.ParallelGroup);
		
		GroupLayout.ParallelGroup vertPlaylist = (GroupLayout.ParallelGroup) MemberModifier.field(Gui.class, "vertPlaylist").get(gui);
		assertTrue(vertPlaylist instanceof GroupLayout.ParallelGroup);
	}
	
	@Test
	public void addMenuEntryTest() throws Exception {
//		Configuration.saveandloadplaylist=true;
		
		if(Configuration.saveandloadplaylist) {
			Whitebox.invokeMethod(gui, "init__wrappee__SaveAndLoadPlaylist");
			JMenu menu = new JMenu();
			gui.addMenuEntry(menu);
			assertTrue(menu.getMenuComponent(0) instanceof JMenuItem);
			assertTrue(menu.getMenuComponent(1) instanceof JMenuItem);
		}
		Configuration.saveandloadplaylist=false;
	}
	
	@Test
	public void addMenuEntry__wrappee__LoadFolderTest() throws Exception {
//		Configuration.loadfolder=true;
		if (Configuration.loadfolder) {
			Whitebox.invokeMethod(gui, "init__wrappee__LoadFolder");
			JMenu menu = new JMenu();
			Whitebox.invokeMethod(gui, "addMenuEntry__wrappee__LoadFolder", menu);
			assertTrue(menu.getMenuComponent(0) instanceof JMenuItem);
		}
		Configuration.loadfolder=false;
	}
	
//	@Test
	public void start__wrappee__GUITest() throws Exception {
		Whitebox.invokeMethod(gui, "start__wrappee__GUI");
		assertEquals(gui.getTitle(),"featureAMP");
		assertTrue(gui.isVisible());
		assertEquals(gui.getDefaultCloseOperation(),JFrame.EXIT_ON_CLOSE);
		double h=410.0;
		double w=273.0;
		
		assertTrue(gui.getMinimumSize().getHeight()==h);
		assertTrue(gui.getMinimumSize().getWidth()==w);
		Timer timer = (Timer) MemberModifier.field(Gui.class, "guiUpdater").get(gui);
		assertNotNull(timer);
	}
	
	@Test
	public void start__wrappee__LightTest() throws Exception {
//		Configuration.light=true;
		if(Configuration.light) {
			Whitebox.invokeMethod(gui, "start__wrappee__Light");
			assertTrue(gui.getContentPane().getBackground()==Color.WHITE);
		}
	}
	@Test
	public void startTest() {
//		Configuration.dark=true;
		if (Configuration.dark) {
			gui.start();
			assertTrue(gui.getContentPane().getBackground()==Color.DARK_GRAY);
		}
	}
	
//	@Test
//	public void actionPerformed__wrappee__GUITest() throws Exception {
//		ActionEvent e = new ActionEvent(this, 1, "exit");
//		Whitebox.invokeMethod(gui, "actionPerformed__wrappee__GUI",e);
//		assertTrue(true);
//	}
	
	@Test
	public void formatTimeTest() {
		assertEquals(gui.formatTime(36242), "10:04:02");
	}
	@Test
	public void clearTrackTest() {
	
		gui.clearTrack();
		assertNull(gui.metadata);
	}
	
	@Test 
	public void getPlaylistTest() {
		assertTrue(gui.getPlaylist() instanceof Playlist); 
	}
	
	@Test
	public void getSelectedTracksTest() throws IllegalArgumentException, IllegalAccessException {
		JList<TrackMetadata> list = new JList<TrackMetadata>() ;
		JButton t1= new JButton();
		list.add(t1);
		MemberModifier.field(Gui.class, "jplaylist").set(gui, list);
		assertNotNull(gui.getSelectedTracks());
	}
	
	//@Test
	public void refreshPlaylist() throws IllegalArgumentException, IllegalAccessException {
		Playlist playlist = new Playlist();
		playlist.addTrack(new TrackMetadata());
		playlist.addTrack(new TrackMetadata());
		
		MemberModifier.field(Gui.class, "playlist").set(gui, playlist);
		gui.refreshPlaylist();
		assertNotNull(gui.getSelectedTracks());
	}
	
//	@Test
//	public void openFolderTest() {
//		
//		
//		FrameFixture demo = new FrameFixture(gui);
//				gui.start();
//
////		demo.optionPane().button().click();
//		demo.fileChooser().cancelButton().click();
//	}
		
}