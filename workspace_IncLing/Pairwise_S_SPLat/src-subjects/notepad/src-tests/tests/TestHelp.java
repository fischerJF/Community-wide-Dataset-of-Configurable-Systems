package tests;

import static org.fest.assertions.Assertions.assertThat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.fest.swing.fixture.JOptionPaneFixture;
import org.fest.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.Test;

public class TestHelp extends NotepadTest{
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
//    if (mName.equals("testAboutToolBar")) {
//      NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
//    } else if (mName.equals("testAboutMenuBar")) {;
//      NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//    }
  }


  @Test
  public void testAboutToolBar() {    
    GenericTypeMatcher<JButton> buttonMatcher = new GenericTypeMatcher<JButton>(
        JButton.class) {
      @Override
      protected boolean isMatching(JButton arg0) {
        String expected = "About Notepad";
        String actual = arg0.getToolTipText();
        return actual == null ? false : expected.equals(actual);
      }
    };

    JButtonFixture button = window.button(buttonMatcher);
    button.requireEnabled();
    button.click();

    JOptionPaneFixture dialog = window.optionPane();

    dialog.requireTitle("About Notepad");
    assertThat(dialog).isNotNull();

    GenericTypeMatcher<JPanel> panelMatcher = new GenericTypeMatcher<JPanel>(
        JPanel.class) {
      @Override
      protected boolean isMatching(JPanel arg0) {
        return arg0 instanceof smashed.About;
      }
    };

    JPanelFixture panelFixture = dialog.panel(panelMatcher);

    final String developer = "Coded by: Salah Al-Thubaiti";

    GenericTypeMatcher<JLabel> labelMatcher = new GenericTypeMatcher<JLabel>(
        JLabel.class) {
      @Override
      protected boolean isMatching(JLabel arg0) {
        String name = arg0.getText();
        return name == null ? false : name.contains(developer);
      }
    };
    panelFixture.label(labelMatcher);
    panelFixture.requireVisible();
    panelFixture.requireEnabled();
    assertThat(panelFixture).isNotNull();
  }

  @Test
  public void testAboutMenuBar() {
    JMenuItemFixture menuItemFixture1 = window.menuItemWithPath("Help", "About Notepad");
    menuItemFixture1.click();
    menuItemFixture1.requireEnabled();
    menuItemFixture1.requireVisible();
    window.close();
  }

  @After
  public void teardown() {
    window.cleanUp();
  }
  
}
