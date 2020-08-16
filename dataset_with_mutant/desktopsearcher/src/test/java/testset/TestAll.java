package testset;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
//	TestGUIExample.class,
	TestCommandLine.class,
	TestCommandLineExample_Mateus.class,
//	TestGUIExample_Mateus.class
})

public class TestAll extends DesktopSearcherTest{ }