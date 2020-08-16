package testset;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import main.Buttons;
import main.FeatureAmp;
import main.Playlist;
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
	private FrameFixture demo2;
	private FeatureAmp gui;
	private Playlist gui2;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
        if(demo!=null)
		demo.cleanUp();
	}

	@Test
	public void starWAVTest() throws Exception {
		Configuration.gui=true;
		  Configuration.audioformats=true;
		  Configuration.wavplayer=true;
		  Configuration.openwavfile=true;
		  Configuration.openfile=true;
		  Configuration.time=true;
		  Configuration.skins=true;
		  Configuration.light=true;
		  Configuration.playlist=true;
		  Configuration.loadfolder=true;
		
		if (Configuration.gui &&
			Configuration.audioformats &&
			Configuration.wavplayer &&
			Configuration.openwavfile &&
			Configuration.openfile &&
			Configuration.time &&
			Configuration.skins &&
			Configuration.playlist &&
			Configuration.loadfolder &&
			Configuration.light) {
			start();
			
//			JButton startButton= (JButton) MemberModifier.field(Buttons.class, "startButton").get(Buttons.getInstance());
//			JButton pauseButton = (JButton) MemberModifier.field(Buttons.class, "pauseButton").get(Buttons.getInstance());
//			JButton stopButton = (JButton) MemberModifier.field(Buttons.class, "stopButton").get(Buttons.getInstance());
//			
			demo.button("addbutton").click();
			demo.fileChooser().setCurrentDirectory(new File("media/"));
			File file= new File("alarme.wav");
			demo.fileChooser().selectFile(file);
			demo.fileChooser().approveButton().click();
			
			JFrame frame = (JFrame) MemberModifier.field(FeatureAmp.class, "frame").get(gui);
			demo2 = new FrameFixture(frame);
	        demo2.click();
	        
			demo2.button("start").click();
		}
	}

	
	private void start() throws Exception{
		gui = new FeatureAmp();
		gui.run();
	
		
		JFrame frame = (JFrame) MemberModifier.field(FeatureAmp.class, "frame").get(gui);
		JFrame frame2 = (JFrame) MemberModifier.field(Playlist.class, "frame").get(Playlist.getInstance());
		
		
		demo = new FrameFixture(frame2);
	}
}
