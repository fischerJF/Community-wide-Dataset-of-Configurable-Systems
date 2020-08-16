package tests;

import org.junit.Test;

import specifications.Configuration;
//import splat.JTopasVariables;
import tests.de.susebox.jtopas.CustomTestLargeSource;

public class TestMain extends JTopasTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
//		if (testName == null) {
//			throw new RuntimeException();
//		}
//		String strTestName = testName.getMethodName();
//		if (strTestName.equals("testBestScenario")
//				|| strTestName.equals("testAverageScenario")
//				|| strTestName.equals("testWorstScenario")) {
//			//it works with just BASE___ feature enabled
//		} else {
//			System.err.printf("%s did not set default configuration",
//					strTestName);
//		}
	}
	
	private static String[] input = new String[]{String.valueOf(Configuration.SMALL_LOOPS)};

	@Test
	public void testBestScenario() {
	  Configuration.INPUT_PIECE = CustomTestLargeSource.WITHOUT_COMMENTS_CODE_PIECE;
		CustomTestLargeSource.main(input);
	}

	@Test
	public void testAverageScenario() {
	  Configuration.INPUT_PIECE = CustomTestLargeSource.BLOCKCOMMENTS_CODE_PIECE;
		CustomTestLargeSource.main(input);
	}

	@Test
	public void testWorstScenario() {
	  Configuration.INPUT_PIECE = CustomTestLargeSource.ORIGINAL_CODE_PIECE;
		CustomTestLargeSource.main(input);
	}

}
