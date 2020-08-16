package testset;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import players.Player;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class PlayerTest {

	
	@Before
	public void setUp() {
	}

	@Test
	public void getFileFilterTest() {
		assertNull(Player.getFileFilter());
	}
	
	@Test
	public void getTrackMetadataTest() {
		assertNull(Player.getTrackMetadata(" "));
	}

	@Test
	public void getExtensionTest() {
		File f= new File("media/note.mp3");
		assertEquals(Player.getExtension(f),"mp3");
		
		f= new File("media/hollow.ogg");
		assertEquals(Player.getExtension(f),"ogg");
	}
	
		

}