package testset;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import UnionFind.Stopwatch;
import specifications.Configuration;

public class StopwatchTest {
		
	    Stopwatch stopwatc;
		@Before
		public void setUp() {
//			Configuration.tests=true;
			
			if(Configuration.tests) {
				stopwatc = new Stopwatch();
			}
		}
		@Test
		public void testaddRecords() throws IllegalArgumentException, IllegalAccessException {
			if(Configuration.tests) {
		long time=	(long) MemberModifier.field(Stopwatch.class, "start").get(stopwatc);
		assertNotEquals(time, 0);
			}
		}
		
		@Test
		public void elapsedTimeTest() {
			if(Configuration.tests) {
			assertNotEquals(stopwatc.elapsedTime(),0);
			}
		}
	

}
