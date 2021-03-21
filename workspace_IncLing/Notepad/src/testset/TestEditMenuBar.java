package testset;

import javax.swing.JTextArea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import specifications.Configuration;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.JMenuItemFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.junit.Assume;
import org.junit.Test;

public class TestEditMenuBar extends NotepadTest {

  @Override
  protected void configure() {
    // set mandatory features
    super.configure();
    if (testName == null) {
      throw new RuntimeException();
    }
    String strTestName = testName.getMethodName();
//    if (strTestName.equals("findTextArea")
//        || strTestName.equals("testSelectAll")
//        || strTestName.equals("testCutMenuBar")
//        || strTestName.equals("testCopyPasteMenuBar")
//        || strTestName.equals("testCutPasteMenuBar")) {
//      NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//      NotepadVariables.getSINGLETON().setEDITMENUBAR___(true);
//    } else if (strTestName.equals("testFindMenuBar")
//        || strTestName.equals("testFindNextMenuBar")) {
//      NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//      NotepadVariables.getSINGLETON().setEDITMENUBAR___(true);
//      NotepadVariables.getSINGLETON().setSEARCHMENUBAR___(true);
//    } else if (strTestName.equals("testUndoRedoMenuBar")) {
//      NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//      NotepadVariables.getSINGLETON().setEDITMENUBAR___(true);
//      // NotepadVariables.getSINGLETON().setSEARCHMENUBAR___(true);
//      NotepadVariables.getSINGLETON().setUNDOREDOMENUBAR___(true);
//    } else {
//      System.err.printf("%s did not set default configuration", strTestName);
//    }
  }

  JTextArea tarea;
  JTextComponentFixture tareaFixture;
  String sampleText = "1 + 1 = 2";

  private void findTextArea() {
    GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(
        JTextArea.class) {
      @Override
      protected boolean isMatching(JTextArea button) {
        tarea = button;
        return true;
      }
    };
    tareaFixture = window.textBox(textAreaMatcher);
  }

  @Test  
  public void testSelectAll() {
//    Assume.assumeTrue(NotepadVariables.getSINGLETON().isBASEMENUBAR___()
//    && NotepadVariables.getSINGLETON().isEDITMENUBAR___());
//	  Configuration.BASEMENUBAR=true;
//	  Configuration.EDITMENUBAR=true;
//	  Configuration.BASE=true;
	  if(Configuration.BASEMENUBAR  && Configuration.EDITMENUBAR) {
		  findTextArea();
		  tareaFixture.setText(sampleText);
		  JMenuItemFixture item1 = window.menuItemWithPath("Edit", "Select All");
//		  item1.click();
//		  assertEquals(sampleText, tarea.getSelectedText());
	  }
  }

  @Test
  public void testCutMenuBar() {
    testSelectAll();
    JMenuItemFixture item1 = window.menuItemWithPath("Edit", "Cut");
    item1.click();
//    tareaFixture.requireText("");
  }

  @Test
  public void testCopyPasteMenuBar() {
    testSelectAll();
    JMenuItemFixture item1 = window.menuItemWithPath("Edit", "Copy");
    item1.click();
//    item1 = window.menuItemWithPath("Edit", "Paste");
    item1.click();
    item1.click();
//    tareaFixture.requireText(sampleText + sampleText);
  }

  //@Test
  public void testCutPasteMenuBar() {
    testSelectAll();
    JMenuItemFixture item1 = window.menuItemWithPath("Edit", "Copy");
    item1.click();
    item1 = window.menuItemWithPath("Edit", "Cut");
    item1.click();
//    tareaFixture.requireEmpty();
   // item1 = window.menuItemWithPath("Edit", "Paste");
   // item1.click();
    tareaFixture.requireText(sampleText);
  }

 // @Test
  public void testFindMenuBar() {
//    Assume.assumeTrue(NotepadVariables.getSINGLETON().isEDITMENUBAR___()
//     && NotepadVariables.getSINGLETON().isBASEMENUBAR___()
//     && NotepadVariables.getSINGLETON().isSEARCHMENUBAR___());
//	  Configuration.EDITMENUBAR=true;
//	  Configuration.BASEMENUBAR=true;
//	  Configuration.SEARCHMENUBAR=true;
	  if(Configuration.EDITMENUBAR && Configuration.BASEMENUBAR && Configuration.SEARCHMENUBAR) {
		findTextArea();
    	tareaFixture.setText("The quick brown fox jumps over the lazy dog");
    	JMenuItemFixture item1 = window.menuItemWithPath("Edit", "Find");
    	item1.click();
    	Helper.inputDialog(window, "lazy");
    	assertEquals("lazy", tarea.getSelectedText());
	  }
  }

  @Test
  public void testFindNextMenuBar() {
//     Assume.assumeTrue(NotepadVariables.getSINGLETON().isEDITMENUBAR___()
//     && NotepadVariables.getSINGLETON().isBASEMENUBAR___()
//     && NotepadVariables.getSINGLETON().isSEARCHMENUBAR___());
//	  Configuration.EDITMENUBAR=true;
//	  Configuration.BASEMENUBAR=true;
//	  Configuration.SEARCHMENUBAR=true;
    if(Configuration.EDITMENUBAR && Configuration.BASEMENUBAR && Configuration.SEARCHMENUBAR ) {
    	//testFindMenuBar();
    	JMenuItemFixture item1 = window.menuItemWithPath("Edit", "Find Next");
    	item1.click();
    //	assertNull(tarea.getSelectedText());
    }
  }

  @Test
  public void testUndoRedoMenuBar() {
    testCutMenuBar();
    JMenuItemFixture item1 = window.menuItemWithPath("Edit", "Undo");
    item1.click();
   // assertEquals(sampleText, tarea.getText());
    item1 = window.menuItemWithPath("Edit", "Redo");
    item1.click();
    assertEquals(sampleText, tarea.getText());
//    assertEquals("", tarea.getText());
  }

}
