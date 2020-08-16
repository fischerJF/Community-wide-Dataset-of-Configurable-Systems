package tests;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.fest.swing.fixture.JOptionPaneFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.junit.After;
import org.junit.Test;

public class NotepadJUnitTest_lest extends NotepadTest {

  @Override
  protected void configure() {
    // set mandatory features
    super.configure();
    if (testName == null) {
      throw new RuntimeException();
    }
    String mName = testName.getMethodName();
    /**
     * set optional features specific for each test
     */
//    if (mName.equals("wordCountTest") || mName.equals("insertBlankWord")) {
//       NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//       NotepadVariables.getSINGLETON().setWORDCOUNTMENUBAR___(true);
//    } else if (mName.equals("testButtonCut")) {
//       NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
//       NotepadVariables.getSINGLETON().setEDITTOOLBAR___(true);
//    } else if (mName.equals("selectAll")) {
//       NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//       NotepadVariables.getSINGLETON().setEDITMENUBAR___(true);
//       NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
//       NotepadVariables.getSINGLETON().setEDITTOOLBAR___(true);
//    } else if (mName.equals("seachrButton")) {
//       NotepadVariables.getSINGLETON().setSEARCHMENUBAR___(true);
////       NotepadVariables.getSINGLETON().setSEARCH___(true);
//       NotepadVariables.getSINGLETON().setSEARCHMENUBAR___(true);
//       NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//    } else {
//      System.err.printf("%s did not set default configuration", mName);
//    }
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void wordCountTest() {
    // Assume.assumeTrue(NotepadVariables.getSINGLETON().isWORDCOUNTMENUBAR___());
    GenericTypeMatcher<JMenuItem> menuItemMatcher = new GenericTypeMatcher<JMenuItem>(
        JMenuItem.class) {
      @Override
      protected boolean isMatching(JMenuItem opt) {
        if (opt instanceof JMenu)
          return false;
        else {
          String text = opt.getText();
          // System.out.println(text);
          return text == null ? false : text.equals("Word Count");
        }
      }
    };

    JMenuItemFixture ab = window.menuItem(menuItemMatcher);
    ab.click();
    JOptionPaneFixture dialog = window.optionPane();
    dialog.requireMessage("Word count: 0");
    window.cleanUp();

  }

  @Test
  public void insertBlankWord() {
    GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(
        JTextArea.class) {
      @Override
      protected boolean isMatching(JTextArea arg0) {
        return true;
      }
    };

    JTextComponentFixture area = window.textBox(textAreaMatcher);
    area.enterText(" \n b");

    GenericTypeMatcher<JMenuItem> menuItemMatcher = new GenericTypeMatcher<JMenuItem>(
        JMenuItem.class) {
      @Override
      protected boolean isMatching(JMenuItem opt) {
        if (opt instanceof JMenu)
          return false;
        else {
          String text = opt.getText();
          // // System.out.println(text);
          return text == null ? false : text.equals("Word Count");
        }
      }
    };

    JMenuItemFixture ab = window.menuItem(menuItemMatcher);
    ab.click();
    JOptionPaneFixture dialog = window.optionPane();
    dialog.requireMessage("Word count: 1");
    window.cleanUp();

  }

  @Test
  public void testButtonCut() {
    GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(
        JTextArea.class) {
      @Override
      protected boolean isMatching(JTextArea button) {
        return true;
      }
    };

    GenericTypeMatcher<JButton> but = new GenericTypeMatcher<JButton>(
        JButton.class) {
      @Override
      protected boolean isMatching(JButton button) {
        String expected = "Cut";
        String actual = button.getToolTipText();

        return actual == null ? false : expected.equals(actual);

      }
    };

    JButtonFixture buto = window.button(but);// pesquisando pelo bot??????????????????????????????????????????????????????o
    JTextComponentFixture textArea = window.textBox(textAreaMatcher);// pesquisando
                                                                     // a text
                                                                     // area

    String text = "Hello";
    textArea.enterText(text);
    textArea.select(text);
    buto.click();
    // /JOptionPaneFixture dialog = window.optionPane();
    // dialog.requireTitle("Selecionar uma Op????????????????????????????????????????????????????????????????????????????????????????????????????????????o");
    textArea.requireText("");
    window.cleanUp();
  }

  @Test
  public void selectAll() {
    String text = "Hello";
    String before = text;
    GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(
        JTextArea.class) {
      @Override
      protected boolean isMatching(JTextArea button) {
        return true;
      }
    };
    // Selecionar tudo
    JTextComponentFixture textArea = window.textBox(textAreaMatcher);
    textArea.requireEditable();
    textArea.enterText(text);
    textArea.requireText("Hello");
    GenericTypeMatcher<JMenuItem> menuItemMatcher = new GenericTypeMatcher<JMenuItem>(
        JMenuItem.class) {
      protected boolean isMatching(JMenuItem opt) {
        String text = opt.getText();
        // System.out.println(text);
        return (text == null ? false : text.equals("Select All"));
      }

    };

    JMenuItemFixture ab = window.menuItem(menuItemMatcher);
    ab.click();

    // RECORTAR
    GenericTypeMatcher<JButton> but = new GenericTypeMatcher<JButton>(
        JButton.class) {
      @Override
      protected boolean isMatching(JButton button) {
        String expected = "Cut";
        String actual = button.getToolTipText();

        return actual == null ? false : expected.equals(actual);

      }
    };

    JButtonFixture buto = window.button(but);// pesquisando pelo bot??????????????????????????????????????????????????????o
    buto.click();// clicando no bot??????????????????????????????????????????????????????o selecionado

    // COLAR
    GenericTypeMatcher<JButton> butt = new GenericTypeMatcher<JButton>(
        JButton.class) {
      @Override
      protected boolean isMatching(JButton button) {
        String expected = "Paste";
        String actual = button.getToolTipText();
        return actual == null ? false : expected.equals(actual);

      }
    };

    JButtonFixture buton = window.button(butt);// pesquisando pelo bot??????????????????????????????????????????????????????o
    buton.click();// clicando no bot??????????????????????????????????????????????????????o selecionado

    textArea.requireText(before);
    window.cleanUp();

  }

  @Test
  public void seachrButton() {
    GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(
        JTextArea.class) {
      @Override
      protected boolean isMatching(JTextArea button) {
        return true;
      }
    };

    GenericTypeMatcher<JMenuItem> menuItemMatcher = new GenericTypeMatcher<JMenuItem>(
        JMenuItem.class) {
      protected boolean isMatching(JMenuItem menuIt) {
        String text = menuIt.getText();
        // System.out.println(text);
        return text == null ? false : text.equals("Find");
      }

    };

    JMenuItemFixture ab = window.menuItem(menuItemMatcher);
    JTextComponentFixture textArea = window.textBox(textAreaMatcher);// pesquisando
                                                                     // a text
                                                                     // area
    textArea.enterText("Hello World!!!!");
    ab.click();
    JOptionPaneFixture dialog = window.optionPane();
    dialog.requireTitle("Input");
    dialog.click().cancelButton().click();
    /*
     * dialog.requireTitle("Abourted"); JOptionPaneFixture warning =
     * window.optionPane(); dialog.click().okButton();
     */

  }

}
