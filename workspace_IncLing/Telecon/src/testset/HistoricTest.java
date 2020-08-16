package testset;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test; 
import specifications.Configuration;
import telecom.Historic;

public class HistoricTest {

	
	
	@Before
	public void setUp() {

		//apenas para criar os casos de teste
		//remover quando terminar
//		Configuration.HISTORIC=true;
	
	}
	//@Test
	public void testaddRecords() {
		
		if(Configuration.HISTORIC) {
			Historic.addRecords("record test 1");
			Historic.addRecords("record test 2");
			Historic.addRecords("record test 3");
			Historic.addRecords("record test 4");
			assertEquals(Historic.returnRecords(), "\nrecord test 1"
					+ "\nrecord test 2"
					+ "\nrecord test 3"
					+ "\nrecord test 4"
					);
		}
	}
	
	@Test
	public void testResetRecords() {
		if(Configuration.HISTORIC) {
			Historic.addRecords("record test 1");
			Historic.addRecords("record test 2");
			Historic.addRecords("record test 3");
			Historic.addRecords("record test 4");
			Historic.resetRecords();
			assertEquals(Historic.returnRecords(), "");
		}
	}
	
	@Test
	public void historicCreation() {
		Historic h = new Historic();
		assertTrue(h !=null);
		assertTrue(h instanceof Historic);
		
	}

}
