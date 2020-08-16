package tests;

import org.junit.Test;

import splat.JTopasVariables;
import tests.de.susebox.jtopas.CustomTestLargeSource;

public class TestMain extends JTopasTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		if (testName == null) {
			throw new RuntimeException();
		}
		String strTestName = testName.getMethodName();
//		if (strTestName.equals("testBestScenario")
//				|| strTestName.equals("testAverageScenario")
//				|| strTestName.equals("testWorstScenario")) {
//			//it works with just BASE___ feature enabled
//		} else {
//			System.err.printf("%s did not set default configuration",
//					strTestName);
//		}
	}
	
	private static String[] input = new String[]{String.valueOf(JTopasVariables.SMALL_LOOPS)};

	@Test
	public void testBestScenario() {
		JTopasVariables.INPUT_PIECE = CustomTestLargeSource.WITHOUT_COMMENTS_CODE_PIECE;
		CustomTestLargeSource.main(input);
	}

	@Test
	public void testAverageScenario() {
		JTopasVariables.INPUT_PIECE = CustomTestLargeSource.BLOCKCOMMENTS_CODE_PIECE;
		CustomTestLargeSource.main(input);
	}

	@Test
	public void testWorstScenario() {
		JTopasVariables.INPUT_PIECE = CustomTestLargeSource.ORIGINAL_CODE_PIECE;
		CustomTestLargeSource.main(input);
	}

}
