package testset;

import static org.junit.Assert.assertNotNull;

import java.awt.Dialog;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

import junit.framework.Assert;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JComboBoxFixture;
import org.fest.swing.fixture.JLabelFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.fest.swing.fixture.JOptionPaneFixture;
import org.fest.swing.fixture.JTextComponentFixture;

public class Helper {
  
  public static String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment()
      .getAvailableFontFamilyNames();

  /**
   * pushed string text on the text field of this dialog and presses OK
   * 
   * @param window
   * @param text
   */
  public static void inputDialog(FrameFixture window, String text) {
    GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
        Dialog.class) {
      @Override
      protected boolean isMatching(Dialog dialog) {
        return dialog.getTitle().equals("Aceptar") && dialog.isVisible();
      }
    };
    DialogFixture dialog = window.dialog(diaglogMatcher);
     assertNotNull(dialog);
    JOptionPaneFixture jOptionPane = window.optionPane();
     assertNotNull(jOptionPane);
    GenericTypeMatcher<JTextComponent> matcher = new GenericTypeMatcher<JTextComponent>(
        JTextComponent.class) {
      @Override
      protected boolean isMatching(JTextComponent dialog) {
        return true;
      }
    };
    JTextComponentFixture textFixture = jOptionPane.textBox(matcher);
     assertNotNull(textFixture);
    textFixture.setText(text);
    jOptionPane.okButton().click();
  }

  /**
   * Initializes
   * 
   * @param window
   * @return
   */
  public static DialogFixture fileNewInitializerMenuBar(FrameFixture window) {
    // type something on the text area
    GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(
        JTextArea.class) {
      @Override
      protected boolean isMatching(JTextArea testArea) {
        return true;
      }
    };
    JTextComponentFixture textArea = window.textBox(textAreaMatcher);
    textArea.setText("hello");

    // Try File > New. It should ask if you want to save
    JMenuItemFixture itemNew = window.menuItemWithPath("File", "New");
    itemNew.click();

    GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
        Dialog.class) {
      @Override
      protected boolean isMatching(Dialog dialog) {
        return dialog.isFocused();
      }
    };

    DialogFixture dialog = window.dialog(diaglogMatcher);
    Assert.assertNotNull(dialog);
    return dialog;
  }

  /**
   * Create a file with some content (if it does not exist)
   */
  static String FILE_NAME = System.getProperty("java.io.tmpdir")
      + System.getProperty("file.separator") + "file.txt";

  public static void saveAFile() throws IOException {
    File file = new File(FILE_NAME);
    FileWriter fw = new FileWriter(file);
    fw.write("typing something to save and open later");
    fw.close();
  }

  /**
   * Initializes
   * 
   * @param window
   * @return
   */
  public static DialogFixture fileInitializerToolBar(FrameFixture window,
      final String buttonNameExpected) {
    // type something on the text area
    GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(
        JTextArea.class) {
      @Override
      protected boolean isMatching(JTextArea testArea) {
        return true;
      }
    };
    JTextComponentFixture textArea = window.textBox(textAreaMatcher);
    textArea.setText("hello");

    // Click Expected button
    GenericTypeMatcher<JButton> buttonMatcher = new GenericTypeMatcher<JButton>(
        JButton.class) {
      @Override
      protected boolean isMatching(JButton arg0) {
        String expected = buttonNameExpected;
        String actual = arg0.getToolTipText();
        return actual == null ? false : expected.equals(actual);
      }
    };

    JButtonFixture button = window.button(buttonMatcher);
    button.requireEnabled();
    button.click();

    // a dialog ask if you want to save what you typed
    GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
        Dialog.class) {
      @Override
      protected boolean isMatching(Dialog dialog) {
        return dialog.isFocused();
      }
    };

    DialogFixture dialog = window.dialog(diaglogMatcher);
    Assert.assertNotNull(dialog);

    return dialog;
  }

  /**
   * Initializes
   * 
   * @param window
   * @return
   */
  public static void fileFormatInitializerMenuBar(FrameFixture window,
      String text, String menuItem) {
    // (1) type some text
    GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(
        JTextArea.class) {
      @Override
      protected boolean isMatching(JTextArea testArea) {
        return true;
      }
    };
    JTextComponentFixture textArea = window.textBox(textAreaMatcher);
    textArea.setText(text);

    // (2) try to change the text font to another using menu bar (Format ->
    // Font)
    JMenuItemFixture itemFormat = window.menuItemWithPath("Format", menuItem);
    itemFormat.click();
  }

  public static void fileFormatInitializerToolBar(FrameFixture window,
      String text, final String buttonNameExpected) {
    // (1) type some text
    GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(
        JTextArea.class) {
      @Override
      protected boolean isMatching(JTextArea testArea) {
        return true;
      }
    };
    JTextComponentFixture textArea = window.textBox(textAreaMatcher);
    textArea.setText(text);

    // (2) try to change the text font to another using tool bar (Font button)
    // Click Expected button
    GenericTypeMatcher<JButton> buttonMatcher = new GenericTypeMatcher<JButton>(
        JButton.class) {
      @Override
      protected boolean isMatching(JButton arg0) {
        String actual = arg0.getToolTipText();
        return actual == null ? false : buttonNameExpected.equals(actual);
      }
    };

    JButtonFixture button = window.button(buttonMatcher);
    button.requireEnabled();
    button.click();
  }

  public static DialogFixture getFileFormatDialog(FrameFixture window) {
    GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
        Dialog.class) {
      @Override
      protected boolean isMatching(Dialog dialog) {
        return dialog.isFocused();
      }
    };

    DialogFixture dialog = window.dialog(diaglogMatcher);
    Assert.assertNotNull(dialog);

    return dialog;
  }

  public static JLabelFixture getFontLabel(DialogFixture fontDialog,
      final String expectedLabelText) {
    // select the font label, where we access ComboBox to change the font
    GenericTypeMatcher<JLabel> labelMatcher = new GenericTypeMatcher<JLabel>(
        JLabel.class) {
      @Override
      protected boolean isMatching(JLabel label) {
        String actual = label.getText();
        return actual == null ? false : expectedLabelText.equals(actual);
      }
    };
    JLabelFixture labelFixture = fontDialog.label(labelMatcher);
    Assert.assertNotNull(labelFixture);

    return labelFixture;
  }

  public static JComboBoxFixture getFontComboBox(DialogFixture fontDialog,
      final String expectedComboBoxText) {
    GenericTypeMatcher<JComboBox> comboBoxMatcher = new GenericTypeMatcher<JComboBox>(
        JComboBox.class) {
      @Override
      protected boolean isMatching(JComboBox comboBox) {
        String actual = comboBox.getSelectedItem().toString();
        return actual == null ? false : expectedComboBoxText.equals(actual);
      }
    };

    JComboBoxFixture comboBoxFixture = fontDialog.comboBox(comboBoxMatcher);
    Assert.assertNotNull(comboBoxFixture);

    return comboBoxFixture;
  }

  public static void clickFontDialogButton(DialogFixture fontDialog,
      final String expectedButtonText) {
    GenericTypeMatcher<JButton> buttonMatcher = new GenericTypeMatcher<JButton>(
        JButton.class) {
      @Override
      protected boolean isMatching(JButton button) {
        String actual = button.getText();
        return actual == null ? false : expectedButtonText.equals(actual);
      }
    };
    JButtonFixture button = fontDialog.button(buttonMatcher);
    Assert.assertNotNull(button);
    button.requireVisible();
    button.requireEnabled();
    button.click();
  }

  public static JComboBoxFixture setFont(DialogFixture fontDialog,
      String labelText, String comboBoxText) {
    // select the font label, where we access ComboBox to change the font
    JLabelFixture label = getFontLabel(fontDialog, labelText);
    label.requireVisible();
    label.requireEnabled();

    // select the new font in ComboBox
    JComboBoxFixture comboBox = getFontComboBox(fontDialog, comboBoxText);

    return comboBox;
  }
  
}
