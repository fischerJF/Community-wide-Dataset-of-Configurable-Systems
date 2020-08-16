import java.io.File;

import gov.nasa.jpf.JPF;

public class Run {

	public static void main(String[] _) {
		final String path = new File("").getAbsolutePath();
		final String[] args = {
				"+classpath=" + path + "/bin",
				"+search.class=.search.RandomSearch",
//				"com.vogella.junit.first." + "MyClass"
//				"learning.varexj." + "Main"
				"learning.varexj." + "MutantInWhileBlock"
		};

		JPF.main(args);
	}
}
