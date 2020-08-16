package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestMAB.class,
  TestMain.class
})

public class TestAll extends SudokuTest{ }