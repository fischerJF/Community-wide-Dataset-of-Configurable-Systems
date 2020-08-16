package tests;

import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FontFixture;
import org.fest.swing.fixture.JComboBoxFixture;
import org.junit.Test;

public class TestFormatMenuBar extends NotepadTest {

  @Override
  protected void configure() {
    // set mandatory features
    super.configure();
    if (testName == null) {
      throw new RuntimeException();
    }
    String strTestName = testName.getMethodName();
//    if (strTestName.equals("testChangeFontMenuBar")) {
//       NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//       NotepadVariables.getSINGLETON().setFORMATMENUBAR___(true);
//    } else if (strTestName.equals("testChangeFontSizeMenuBar")) {
//       NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//       NotepadVariables.getSINGLETON().setFORMATMENUBAR___(true);
//    } else if (strTestName.equals("testChangeFontTypeMenuBar")) {
//       NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//       NotepadVariables.getSINGLETON().setFORMATMENUBAR___(true);
//    } else if (strTestName.equals("testChangeFontAllMenuBar")) {
//       NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//       NotepadVariables.getSINGLETON().setFORMATMENUBAR___(true);
//    } else if (strTestName.equals("testLineWrap")) {
//       NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
//       NotepadVariables.getSINGLETON().setFORMATMENUBAR___(true);
//    } else {
//      System.err.printf("%s did not set default configuration", strTestName);
//    }
  }

  String selectedFont = Helper.fonts[Helper.fonts.length - 1];

  @Test
  public void testChangeFontMenuBar() {
    // type some initial text and click in menu Format > Font
    Helper.fileFormatInitializerMenuBar(window, "text do be formatted", "Font");

    DialogFixture fontDialog = Helper.getFileFormatDialog(window);

    // select the font label, where we access ComboBox to change the font
    JComboBoxFixture comboBoxFont = Helper.setFont(fontDialog, "Fonts: ",
        Helper.fonts[0]);
    comboBoxFont.requireVisible();
    comboBoxFont.requireEnabled();
    comboBoxFont.selectItem(selectedFont);

    // Press OK button
    Helper.clickFontDialogButton(fontDialog, "OK");

    FontFixture fontFixture = window.textBox().font();
    fontFixture.requireFamily(selectedFont);
  }

  @Test
  public void testChangeFontSizeMenuBar() {
    // Assume.assumeTrue(NotepadVariables.getSINGLETON().isFORMATMENUBAR___());
    // type some initial text and click in menu Format > Font
    Helper.fileFormatInitializerMenuBar(window, "text do be formatted", "Font");

    DialogFixture fontDialog = Helper.getFileFormatDialog(window);

    // select the font label, where we access ComboBox to change the font
    JComboBoxFixture comboBoxSize = Helper.setFont(fontDialog, "Sizes: ", "8");
    comboBoxSize.requireVisible();
    comboBoxSize.requireEnabled();
    comboBoxSize.selectItem("48");

    // Press OK button
    Helper.clickFontDialogButton(fontDialog, "OK");

    FontFixture fontFixture = window.textBox().font();
    fontFixture.requireSize(48);
  }

  @Test
  public void testChangeFontTypeMenuBar() {
    // Assume.assumeTrue(NotepadVariables.getSINGLETON().isFORMATMENUBAR___());
    // type some initial text and click in menu Format > Font
    Helper.fileFormatInitializerMenuBar(window, "text do be formatted", "Font");

    DialogFixture fontDialog = Helper.getFileFormatDialog(window);

    // select the font label, where we access ComboBox to change the font
    JComboBoxFixture comboBoxType = Helper.setFont(fontDialog, "Types: ",
        "Regular");
    comboBoxType.requireVisible();
    comboBoxType.requireEnabled();
    comboBoxType.selectItem("Bold Italic");

    // Press OK button
    Helper.clickFontDialogButton(fontDialog, "OK");

    FontFixture fontFixture = window.textBox().font();
    fontFixture.requireBold();
    fontFixture.requireItalic();
  }

  @Test
  public void testChangeFontAllMenuBar() {
    // type some initial text and click in menu Format > Font
    Helper.fileFormatInitializerMenuBar(window, "text do be formatted", "Font");

    DialogFixture fontDialog = Helper.getFileFormatDialog(window);

    JComboBoxFixture comboBoxFont = Helper.setFont(fontDialog, "Fonts: ",
        Helper.fonts[0]);
    comboBoxFont.requireVisible();
    comboBoxFont.requireEnabled();
    comboBoxFont.selectItem(selectedFont);

    JComboBoxFixture comboBoxSize = Helper.setFont(fontDialog, "Sizes: ", "8");
    comboBoxSize.requireVisible();
    comboBoxSize.requireEnabled();
    comboBoxSize.selectItem("20");

    JComboBoxFixture comboBoxType = Helper.setFont(fontDialog, "Types: ",
        "Regular");
    comboBoxType.requireVisible();
    comboBoxType.requireEnabled();
    comboBoxType.selectItem("Bold Italic");

    // Press OK button
    Helper.clickFontDialogButton(fontDialog, "OK");

    FontFixture fontFixture = window.textBox().font();
    fontFixture.requireFamily(selectedFont);
    fontFixture.requireSize(20);
    fontFixture.requireBold();
    fontFixture.requireItalic();
  }

  @Test
  public void testLineWrap() {
    // with line wrap
    Helper
        .fileFormatInitializerMenuBar(
            window,
            "============================================================================================================================================================================================",
            "Line Wrap");

    // without line wrap
    Helper
        .fileFormatInitializerMenuBar(
            window,
            "============================================================================================================================================================================================",
            "Line Wrap");
  }

}
