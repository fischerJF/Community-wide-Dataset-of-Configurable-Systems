package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  ConnectedTests_Caio.class,
  CycleRelated_Caio.class,
  GraphReturnTests_Caio.class,
  MultiFeatureTest_Caio.class,
  NumberTests_Caio.class,
  TestSuite_NEW.class
 })
public class TestAll extends GPLTest {
}
