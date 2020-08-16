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

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class StandardSeparatorHandlerTest {

	private StandardSeparatorHandler ssh;
	private TokenizerProperties properties;
	@Before
	public void setUp(){
		properties=new StandardTokenizerProperties();
		ssh= new StandardSeparatorHandler(properties);
	}
	
	
	@Test
	public void StandardSeparatorHandlerTest() throws IllegalArgumentException, IllegalAccessException {
		assertEquals(MemberModifier.field(StandardSeparatorHandler.class, "_properties").get(ssh),properties);
  	}
	
	@Test
	public void isSeparatorTest() {
		assertFalse(ssh.isSeparator('A'));
		assertTrue(ssh.isSeparator(' '));
	}
	
	@Test
	public void isSeparatorTest2() {
		properties=null;
		ssh= new StandardSeparatorHandler(properties);
		assertFalse(ssh.isSeparator('A'));
		
	}
}
