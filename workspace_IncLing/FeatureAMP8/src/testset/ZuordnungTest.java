package testset;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import engine.ID3Tag;
import engine.MP3Player;
import engine.Zuordnung;

import static org.mockito.Matchers.anyObject;

import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

import specifications.Configuration;

public class ZuordnungTest {

	private Zuordnung zuordnung;

	@Before
	public void setUp() {
	}

	@Test
	public void ID3TagTest() throws IllegalArgumentException, IllegalAccessException, UnsupportedTagException,
			InvalidDataException, IOException {
//		Configuration.featureamp = true;
		if (Configuration.featureamp) {
			File mp3 = new File("media/note.mp3");
			zuordnung = new Zuordnung("display",mp3);
			String anzeige = (String) MemberModifier.field(Zuordnung.class, "anzeige").get(zuordnung);
			assertEquals(anzeige, anzeige);

			File file= (File) MemberModifier.field(Zuordnung.class, "file").get(zuordnung);
			assertEquals(file, mp3);
			
			assertEquals(zuordnung.getFile(),mp3);
			assertEquals(zuordnung.getAnzeige(),"display");
		}
	}

	
}
