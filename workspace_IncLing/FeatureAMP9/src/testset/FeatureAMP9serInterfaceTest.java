package testset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;

import gui.Gui;
import gui.Playlist;
import players.MP3Player;
import players.Player;
import players.Player.State;
import players.TrackMetadata;
import specifications.Configuration;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.GroupLayout;
import javax.swing.JList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.fest.swing.fixture.FrameFixture;

public class FeatureAMP9serInterfaceTest {

	private FrameFixture demo;
	private Gui gui;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
		if(demo!=null)
		demo.cleanUp();
	}

	@Test
	public void loadCancelTest() {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.skins) {
			start();

			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().cancelButton().click();
		}
	}

	@Test
	public void OpenFileTest() {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.skins) {
		start();
		demo.menuItemWithPath("File", "Open File...").click();
		demo.fileChooser().setCurrentDirectory(new File("media/", "note.mp3"));
		demo.fileChooser().approveButton().click();
		demo.fileChooser().requireVisible();
		}
	}

	@Test
	public void OpenFile_PlayTest2() throws IllegalArgumentException, IllegalAccessException, UnsupportedAudioFileException, IOException, LineUnavailableException {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.playlist=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.playlist && 
				Configuration.skins) {
			start();
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			
			
		}
	}
	@Test
	public void OpenFile_PauseTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.skins) {
		start();
		demo.menuItemWithPath("File", "Open File...").click();
		demo.fileChooser().setCurrentDirectory(new File("media/"));
		File file= new File("note.mp3");
		demo.fileChooser().selectFile(file);
		demo.fileChooser().approveButton().click();
		
		demo.button("pause").click();
		
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
	}

	@Test
	public void OpenFile_PlayTest() {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.skins) {
		start();
		demo.menuItemWithPath("File","Open File...").click();
		demo.fileChooser().setCurrentDirectory(new File("media/", "note.mp3"));
		demo.fileChooser().approveButton().click();
		demo.fileChooser().requireVisible();
//		demo.button("pause").click();
		demo.button("play").click();
		}
	}

	@Test
	public void OpenFile_StopTest() {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.skins) {
		start();
		demo.menuItemWithPath("File", "Open File...").click();
		demo.fileChooser().setCurrentDirectory(new File("media/"));
		File file= new File("note.mp3");
		demo.fileChooser().selectFile(file);
		demo.fileChooser().approveButton().click();
		demo.button("stop").click();
		}
	}

	//@Test
	public void volumeControlTest() {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.skins) {
		start();
		demo.menuItemWithPath("File", "Open File...").click();
		demo.fileChooser().setCurrentDirectory(new File("media/", "note.mp3"));
		demo.fileChooser().approveButton().click();
		demo.fileChooser().requireVisible();
		demo.button("stop").click();
		}
	}

	@Test
	public void muteTest() {
//		Configuration.mute = true;
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.skins &&
				Configuration.mute) {
			start();
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("mute").click();
		}
	}
	@Test
	public void showCoverTest() {
//		Configuration.mute = true;
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.showcover=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.skins &&
				Configuration.showcover &&
				Configuration.mute) {
			start();
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("mute").click();
		}
	}

	//@Test
	public void progressTest() {
//		Configuration.mute = true;
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.volumecontrol=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.skins &&
				Configuration.volumecontrol &&
				Configuration.mute) {
			start();
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
		//	demo.slider("volume");
			
		}
	}

	@Test
	public void progressBarTest() {
//		Configuration.mute = true;
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.progressbar=true;
		
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.skins &&
				Configuration.progressbar &&
				Configuration.mute) {
			start();
			demo.menuItemWithPath("File", "Open File...").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
			
		}
	}
	@Test
	public void importPlayListTest() throws IllegalArgumentException, IllegalAccessException, UnsupportedAudioFileException, IOException, LineUnavailableException {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.playlist=true;
//		Configuration.saveandloadplaylist=true;
		
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.playlist && 
				Configuration.saveandloadplaylist && 
				Configuration.skins) {
			start();
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("note.mp3");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			
		}
		}
	@Test
	public void exportPlayListTest() throws IllegalArgumentException, IllegalAccessException, UnsupportedAudioFileException, IOException, LineUnavailableException {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.playlist=true;
//		Configuration.saveandloadplaylist=true;

		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.playlist && 
				Configuration.saveandloadplaylist && 
				Configuration.skins) {
			start();
			File file= new File("p1.m3u");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("play").click();
		
		}
	}
	@Test
	public void clearPalyListTest() throws IllegalArgumentException, IllegalAccessException {
		
		
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.playlist=true;
//		Configuration.saveandloadplaylist=true;
		
//		Configuration.clearplaylist=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.saveandloadplaylist && 
				Configuration.clearplaylist && 
				Configuration.skins) {
			start();

			File file= new File("p1.m3u");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.button("clear").click();
			Playlist list1 = (Playlist) MemberModifier.field(Gui.class, "playlist").get(gui);
			assertTrue(list1.getArray().length==0);
		}
	}
//	@Test
	public void playOGGTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.ogg =true; 
//		Configuration.skins=true;
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.ogg && 
				Configuration.skins) {
		start();
		demo.menuItemWithPath("File", "Open File...").click();
		demo.fileChooser().setCurrentDirectory(new File("media/"));
		File file= new File("hollow.ogg");
		demo.fileChooser().selectFile(file);
		demo.fileChooser().approveButton().click();
		
		demo.button("play").click();
		
		}
	}
	@Test
	public void skipTrack_Test() throws IllegalArgumentException, IllegalAccessException, UnsupportedAudioFileException, IOException, LineUnavailableException {

//		  Configuration.playlist=true;
//		  Configuration.saveandloadplaylist=true;
//		  Configuration.weichbrodt_featureamp =true; 
//		  Configuration.timedisplay=true;
//		  Configuration.light =true; 
//		  Configuration.gui =true; 
//		  Configuration.mp3 =true; 
//		  Configuration.skiptrack=true;
//		  Configuration.shuffleskipremove=true;

		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.playlist && 
				Configuration.saveandloadplaylist && 
				Configuration.shuffleskipremove &&
				Configuration.skiptrack) {
			start();
			File file= new File("p1.m3u");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.list("p_list").clickItem(1);
			demo.button("skip").click();
			}
	}
	/**@Test*/
	public void reorder_UP_Test() throws IllegalArgumentException, IllegalAccessException, UnsupportedAudioFileException, IOException, LineUnavailableException {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.playlist=true;
//		Configuration.loadfolder=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.reorderplaylist=true;
		
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.playlist && 
				Configuration.saveandloadplaylist  && 
				Configuration.loadfolder && 
				Configuration.reorderplaylist && 
				Configuration.skins) {
			start();
			File file= new File("p1.m3u");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.list("p_list").clickItem(1);
			Playlist list1 = (Playlist) MemberModifier.field(Gui.class, "playlist").get(gui);
			
			TrackMetadata a[]= new TrackMetadata[list1.getArray().length];
			for (int i = 0; i < list1.getArray().length; i++) {
				a[i]=list1.getArray()[i];
			}	
			demo.button("up").click();
			Playlist list2 = (Playlist) MemberModifier.field(Gui.class, "playlist").get(gui);
			
			boolean test= false;
			for (int i = 0; i < list2.getArray().length; i++) {
				if(a[i] != list2.getArray()[i])
					test=true;
			}
			assertTrue(test);
		}
	}
	///*@Test*/
	public void reorder_down_Test() throws IllegalArgumentException, IllegalAccessException, UnsupportedAudioFileException, IOException, LineUnavailableException {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.playlist=true;
//		Configuration.loadfolder=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.reorderplaylist=true;

		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.playlist && 
				Configuration.saveandloadplaylist  && 
				Configuration.loadfolder && 
				Configuration.reorderplaylist && 
				Configuration.skins) {
			start();
			File file= new File("p1.m3u");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.list("p_list").clickItem(1);
			Playlist list1 = (Playlist) MemberModifier.field(Gui.class, "playlist").get(gui);
		
			TrackMetadata a[]= new TrackMetadata[list1.getArray().length];
			for (int i = 0; i < list1.getArray().length; i++) {
				a[i]=list1.getArray()[i];
			}	
			demo.button("down").click();
			Playlist list2 = (Playlist) MemberModifier.field(Gui.class, "playlist").get(gui);
	
			boolean test= false;
			for (int i = 0; i < list2.getArray().length; i++) {
					if(a[i] != list2.getArray()[i])
						test=true;
			  }
			assertTrue(test);
		}
	}
	//////*@Test*/
	public void removeTest() throws IllegalArgumentException, IllegalAccessException, UnsupportedAudioFileException, IOException, LineUnavailableException {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.playlist=true;
//		Configuration.loadfolder=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.removetrack=true;
//		Configuration.reorderplaylist=true;

		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.playlist && 
				Configuration.saveandloadplaylist  && 
				Configuration.loadfolder && 
				Configuration.removetrack && 
				Configuration.reorderplaylist && 
				Configuration.skins) {
			start();
			File file= new File("p1.m3u");
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			demo.list("p_list").clickItem(1);
			Playlist list1 = (Playlist) MemberModifier.field(Gui.class, "playlist").get(gui);
            int listA=list1.getArray().length;
			demo.button("remove").click();
			Playlist list2 = (Playlist) MemberModifier.field(Gui.class, "playlist").get(gui);
            assertTrue((list2.getArray().length)==(listA-1));
		}
	}
	@Test
	public void loadTest() throws IllegalArgumentException, IllegalAccessException, UnsupportedAudioFileException, IOException, LineUnavailableException {
//		Configuration.weichbrodt_featureamp =true; 
//		Configuration.timedisplay=true;
//		Configuration.light =true; 
//		Configuration.gui =true; 
//		Configuration.mp3 =true; 
//		Configuration.skins=true;
//		Configuration.playlist=true;
//		Configuration.loadfolder=true;
		
		if (Configuration.weichbrodt_featureamp && 
				Configuration.timedisplay && 
				Configuration.light && 
				Configuration.gui && 
				Configuration.mp3 && 
				Configuration.playlist && 
				Configuration.loadfolder && 
				Configuration.skins) {
			System.err.println("entrou");
			start();
			demo.menuItemWithPath("File", "Import playlist").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
		//	File file= new File("note.mp3");
			//demo.fileChooser().selectFile(file);
//			
			demo.fileChooser().approveButton().click();
		}
	}
	
	
	private void start() {
		gui = new Gui();
		gui.start();
		demo = new FrameFixture(gui);
	}
}
