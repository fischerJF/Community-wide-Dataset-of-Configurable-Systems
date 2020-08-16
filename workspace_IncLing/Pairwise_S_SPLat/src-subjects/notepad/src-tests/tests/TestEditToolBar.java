package tests;

import javax.swing.JButton;
import javax.swing.JTextArea;

import junit.framework.Assert;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.fest.swing.fixture.JToolBarFixture;
import org.junit.Test;

public class TestEditToolBar extends NotepadTest {

  @Override
  protected void configure() {
    // set mandatory features
    super.configure();
    if (testName == null) {
      throw new RuntimeException();
    }
//    String strTestName = testName.getMethodName();
//    if (strTestName.equals("testCutToolBar")
//        || strTestName.equals("testCopyPasteToolBar")
//        || strTestName.equals("testCutPasteToolBar")) {
//       NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
//       NotepadVariables.getSINGLETON().setEDITTOOLBAR___(true);
//    } else if (strTestName.equals("testFindToolBar")) {
//       NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
//       NotepadVariables.getSINGLETON().setEDITTOOLBAR___(true);
//       NotepadVariables.getSINGLETON().setSEARCHTOOLBAR___(true);
//    } else if (strTestName.equals("testUndoRedoToolBar")) {
//       NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
//       NotepadVariables.getSINGLETON().setEDITTOOLBAR___(true);
////       NotepadVariables.getSINGLETON().setSEARCHTOOLBAR___(true);
//       NotepadVariables.getSINGLETON().setUNDOREDOTOOLBAR___(true);
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

  private void selectAll() {
    findTextArea();
    tareaFixture.setText(sampleText);
    tareaFixture.selectAll();
  }

  @Test
  public void testCutToolBar() {
    // Assume.assumeTrue(NotepadVariables.getSINGLETON().isBASETOOLBAR___()
    // && NotepadVariables.getSINGLETON().isEDITTOOLBAR___());
    selectAll();
    JToolBarFixture tb = window.toolBar();
    JButtonFixture jb = option("Cut", tb);
    Assert.assertNotNull(jb);
    Assert.assertEquals(sampleText, tarea.getSelectedText());
    jb.click();
    Assert.assertEquals(null, tarea.getSelectedText());
  }

  @Test
  public void testCopyPasteToolBar() {
    test_Paste("Copy");
  }

  private void test_Paste(final String op) {
    selectAll();
    JToolBarFixture tb = window.toolBar();
    option(op, tb).click();
    JButtonFixture jb = option("Paste", tb);
    jb.click();
    jb.click();
    tareaFixture.requireText(sampleText + sampleText);
  }

  private JButtonFixture option(final String op, JToolBarFixture tb) {
    GenericTypeMatcher<JButton> jbuttonMatcher = new GenericTypeMatcher<JButton>(
        JButton.class) {
      @Override
      protected boolean isMatching(JButton button) {
        return button == null ? false : button.getToolTipText() == null ? false
            : button.getToolTipText().equals(op);
      }
    };
    return tb.button(jbuttonMatcher);
  }

  @Test
  public void testCutPasteToolBar() {
    test_Paste("Cut");
  }

//  @Ignore
//  @Test
//  public void testFindToolBar() {
//    findTextArea();
//    tareaFixture.setText("The quick brown fox jumps over the lazy dog");
//    JToolBarFixture tb = window.toolBar();
//    option("Find", tb).click();
//    // Sabrina, FEST cannot find this window. please check.
//    Helper.inputDialog(window, "lazy");
//    Assert.assertEquals("lazy", tarea.getSelectedText());
//  }

  @Test
  public void testUndoRedoToolBar() {
    // Assume.assumeTrue(NotepadVariables.getSINGLETON().isBASETOOLBAR___()
    // && NotepadVariables.getSINGLETON().isEDITTOOLBAR___()
    // && NotepadVariables.getSINGLETON().isSEARCHTOOLBAR___()
    // && NotepadVariables.getSINGLETON().isUNDOREDO___()
    // && NotepadVariables.getSINGLETON().isUNDOREDOTOOLBAR___());
    testCutToolBar();
    JToolBarFixture tb = window.toolBar();

    GenericTypeMatcher<JButton> jbuttonMatcher = new GenericTypeMatcher<JButton>(
        JButton.class) {
      @Override
      protected boolean isMatching(JButton button) {
        return button == null ? false : button.getIcon() == null ? false
            : button.getIcon().toString().contains("undo.gif");
      }
    };
    tb.button(jbuttonMatcher).click();
    Assert.assertEquals(sampleText, tarea.getText());

    jbuttonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
      @Override
      protected boolean isMatching(JButton button) {
        return button == null ? false : button.getIcon() == null ? false
            : button.getIcon().toString().contains("redo.gif");
      }
    };
    tb.button(jbuttonMatcher).click();
    Assert.assertEquals("", tarea.getText());
  }

}
