package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestEditMenuBar.class,
  TestEditToolBar.class,
  TestFileMenuBar.class,
  TestFileToolBar.class,
  TestFormatMenuBar.class,
  TestFormatToolBar.class,
  TestTextArea.class,
  TestHelp.class,
  TestWordCount.class,
  NotepadJUnitTest_lest.class
})

public class TestAll extends NotepadTest{ }
