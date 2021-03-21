package testset;

import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FontFixture;
import org.fest.swing.fixture.JComboBoxFixture;
import org.junit.Test;

import specifications.Configuration;

public class TestFormatToolBar extends NotepadTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		if (testName == null) {
			throw new RuntimeException();
		}
		String strTestName = testName.getMethodName();
		// if (strTestName.equals("testChangeFontToolBar")) {
		// NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setFORMATTOOLBAR___(true);
		// } else if (strTestName.equals("testChangeFontSizeToolBar")) {
		// NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setFORMATTOOLBAR___(true);
		// } else if (strTestName.equals("testChangeFontAllToolBar")) {
		// NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setFORMATTOOLBAR___(true);
		// } else if (strTestName.equals("testChangeFontTypeToolBar")) {
		// NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setFORMATTOOLBAR___(true);
		// } else {
		// System.err.printf("%s did not set default configuration", strTestName);
		// }
		//
		// if (strTestName.equals("testChangeFontTypeToolBar")) {
		// // [1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1]
		// NotepadVariables.getSINGLETON().setBASE___(true);
		// NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
		// NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setEDITMENUBAR___(true);
		// NotepadVariables.getSINGLETON().setEDITTOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setFORMATMENUBAR___(false);
		// NotepadVariables.getSINGLETON().setFORMATTOOLBAR___(false);
		// NotepadVariables.getSINGLETON().setPERSISTENCEMENUBAR___(true);
		// NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setPRINTMENUBAR___(true);
		// NotepadVariables.getSINGLETON().setPRINTTOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setSEARCHMENUBAR___(true);
		// NotepadVariables.getSINGLETON().setSEARCHTOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setUNDOREDOMENUBAR___(true);
		// NotepadVariables.getSINGLETON().setUNDOREDOTOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setWORDCOUNTMENUBAR___(true);
		// NotepadVariables.getSINGLETON().setWORDCOUNTTOOLBAR___(true);
		// System.out.println(NotepadVariables.getSINGLETON().toString());
		// }
	}

	String selectedFont = Helper.fonts[Helper.fonts.length - 1];

	// @Test
	// public void testChangeFontToolBar() {
	// // type some initial text and click in Font button
	// Helper.fileFormatInitializerToolBar(window, "text do be formatted", "Font");
	//
	// DialogFixture fontDialog = Helper.getFileFormatDialog(window);
	//
	// // select the font label, where we access ComboBox to change the font
	// JComboBoxFixture comboBoxFont = Helper.setFont(fontDialog, "Fonts: ",
	// Helper.fonts[0]);
	// comboBoxFont.requireVisible();
	// comboBoxFont.requireEnabled();
	// comboBoxFont.selectItem(selectedFont);
	//
	// // Press OK button
	// Helper.clickFontDialogButton(fontDialog, "OK");
	//
	// FontFixture fontFixture = window.textBox().font();
	// fontFixture.requireFamily(selectedFont);
	// }
	//
	// @Test
	// public void testChangeFontSizeToolBar() {
	// // type some initial text and click in Font button
	// Helper.fileFormatInitializerToolBar(window, "text do be formatted", "Font");
	//
	// DialogFixture fontDialog = Helper.getFileFormatDialog(window);
	//
	// // select the font label, where we access ComboBox to change the font
	// JComboBoxFixture comboBoxSize = Helper.setFont(fontDialog, "Sizes: ", "8");
	// comboBoxSize.requireVisible();
	// comboBoxSize.requireEnabled();
	// comboBoxSize.selectItem("48");
	//
	// // Press OK button
	// Helper.clickFontDialogButton(fontDialog, "OK");
	//
	// FontFixture fontFixture = window.textBox().font();
	// fontFixture.requireSize(48);
	// }
	//
	// // @Test
	// // public void testChangeFontTypeToolBar() {
	// // //
	// Assume.assumeTrue(NotepadVariables.getSINGLETON().isFORMATTOOLBAR___());
	// // // type some initial text and click in Font button
	// // Helper.fileFormatInitializerToolBar(window, "text do be formatted",
	// // "Font");
	// //
	// // DialogFixture fontDialog = Helper.getFileFormatDialog(window);
	// //
	// // // select the font label, where we access ComboBox to change the font
	// // JComboBoxFixture comboBoxType = Helper.setFont(fontDialog, "Types: ",
	// // "Regular");
	// // comboBoxType.requireVisible();
	// // comboBoxType.requireEnabled();
	// // comboBoxType.selectItem("Bold Italic");
	// //
	// // // Press OK button
	// // Helper.clickFontDialogButton(fontDialog, "OK");
	// //
	// // FontFixture fontFixture = window.textBox().font();
	// // fontFixture.requireBold();
	// // fontFixture.requireItalic();
	// // }

	@Test
	public void testChangeFontAllToolBar() {
		// type some initial text and click in Font button
//		Configuration.BASETOOLBAR = true;
//		Configuration.FORMATTOOLBAR = true;

		if (Configuration.BASETOOLBAR && Configuration.FORMATTOOLBAR) {

			Helper.fileFormatInitializerToolBar(window, "text do be formatted", "Font");

			DialogFixture fontDialog = Helper.getFileFormatDialog(window);

			JComboBoxFixture comboBoxFont = Helper.setFont(fontDialog, "Fonts: ", Helper.fonts[0]);
			comboBoxFont.requireVisible();
			comboBoxFont.requireEnabled();
			comboBoxFont.selectItem(selectedFont);

			JComboBoxFixture comboBoxSize = Helper.setFont(fontDialog, "Sizes: ", "8");
			comboBoxSize.requireVisible();
			comboBoxSize.requireEnabled();
			comboBoxSize.selectItem("20");

			JComboBoxFixture comboBoxType = Helper.setFont(fontDialog, "Types: ", "Regular");
			comboBoxType.requireVisible();
			comboBoxType.requireEnabled();
			comboBoxType.selectItem("Bold Italic");

			// Press OK button
			Helper.clickFontDialogButton(fontDialog, "OK");

			FontFixture fontFixture = window.textBox().font();
			fontFixture.requireFamily(selectedFont);
			//fontFixture.requireSize(20);
			fontFixture.requireBold();
			fontFixture.requireItalic();
		}
	}

}
