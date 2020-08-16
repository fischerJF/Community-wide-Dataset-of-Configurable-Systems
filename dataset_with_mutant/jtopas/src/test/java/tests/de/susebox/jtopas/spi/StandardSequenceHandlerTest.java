package tests.de.susebox.jtopas.spi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import de.susebox.jtopas.Flags;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.spi.StandardSeparatorHandler;
import de.susebox.jtopas.spi.StandardSequenceHandler;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class StandardSequenceHandlerTest {

	private StandardSequenceHandler ssh;
	private TokenizerProperties properties;
	@Before
	public void setUp(){
		properties=new StandardTokenizerProperties();
		ssh= new StandardSequenceHandler(properties);
	}
	
	
	@Test
	public void StandardSeparatorHandlerTest() throws IllegalArgumentException, IllegalAccessException {
		assertEquals(MemberModifier.field(StandardSequenceHandler.class, "_properties").get(ssh),properties);
  	}
	
	@Test
	public void hasSequenceCommentOrString() {
		properties=null;
		ssh= new StandardSequenceHandler(properties);
		assertFalse(ssh.hasSequenceCommentOrString());
		
	}
	}
