package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestBasics.class,
  TestObeservability.class,
  TestProxying.class,
  TestUndo.class,
  TestMVC.class,
  TestCombinations.class,
  Pilot_CommandLine.class,
  Pilot.class,
  Example.class,
  TestGUI_Mateus.class,
})

public class TestAll extends CompaniesTest{ }