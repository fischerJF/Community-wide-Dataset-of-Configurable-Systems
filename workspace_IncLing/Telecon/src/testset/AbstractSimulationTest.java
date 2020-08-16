package testset;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import specifications.Configuration;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import telecom.AbstractSimulation;
import telecom.BasicSimulation;
import telecom.Call;
import telecom.Customer;
import telecom.Historic;

public class AbstractSimulationTest {

	BasicSimulation bs;
	@Before
	public void setUp() {
		bs= new BasicSimulation();
	}

	
	
	@Test 
	public void runTest() throws Exception {
//		Configuration.HISTORIC = true;
		if (Configuration.HISTORIC) {
			Historic.resetRecords();
			bs.run();
			System.out.println(Historic.returnRecords());
			Historic h= new Historic();

			Vector<String>	records= 	(Vector<String>) MemberModifier.field(Historic.class, "records").get(h);			
			assertTrue(records.contains("jim calls mik..."));
			assertTrue(records.contains("jim hangs up..."));
			assertTrue(records.contains("mik calls crista..."));
			assertTrue(records.contains("pickup - caller: Jim(650) receiver: Mik(650)"));
			assertTrue(records.contains("called Name: Mik areacode: 650 to name:Cristaareacode: 415"));
			assertTrue(records.contains("crista hangs up..."));
			assertTrue(records.contains("crista accepts..."));
			}
	}

}
