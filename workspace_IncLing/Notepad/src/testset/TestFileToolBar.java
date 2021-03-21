package testset;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JTextArea;

import junit.framework.Assert;
import specifications.Configuration;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JFileChooserFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.junit.Test;

public class TestFileToolBar extends NotepadTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		// NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		if (testName == null) {
			throw new RuntimeException();
		}
		String mName = testName.getMethodName();
		/**
		 * set optional features specific for each test
		 */
		// if (mName.equals("testNewToolBarNo")) {
		//
		// } else if (mName.equals("testNewToolBarYes")) {
		// // NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// } else if (mName.equals("testNewToolBarCancel")) {
		// // NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// } else if (mName.equals("testSaveToolBar")) {
		// // NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// } else if (mName.equals("testSaveAsToolBar")) {
		// // NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// } else if (mName.equals("testNotSave")) {
		// // NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// } else if (mName.equals("testOpenToolBar")) {
		// // NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// } else if (mName.equals("testPrintToolBar")) {
		// // NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setPRINTTOOLBAR___(true);
		// }

	}

	//@Test /*
	public void testNewToolBarCancel() {
		// Assume.assumeTrue(NotepadVariables.getSINGLETON().isPERSISTENCETOOLBAR___());
//		Configuration.PERSISTENCETOOLBAR = true;
//		Configuration.BASETOOLBAR = true;

		if (Configuration.PERSISTENCETOOLBAR && Configuration.BASETOOLBAR) {
			DialogFixture dialog = Helper.fileInitializerToolBar(window, "New");

			// Click No
			GenericTypeMatcher<JButton> noButtonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
				@Override
				protected boolean isMatching(JButton arg0) {
					String expected = "Cancel";
					String actual = arg0.getText();
					return actual == null ? false : expected.equals(actual);
				}
			};
			JButtonFixture noButton = dialog.button(noButtonMatcher);
			noButton.requireEnabled();
			noButton.requireVisible();
			noButton.click();
		}
	}

	@Test
	public void testNewToolBarNo() {
		DialogFixture dialog = Helper.fileInitializerToolBar(window, "New");

		// Click No
		GenericTypeMatcher<JButton> noButtonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
			@Override
			protected boolean isMatching(JButton arg0) {
				String expected = "No";
				String actual = arg0.getText();
				return actual == null ? false : expected.equals(actual);
			}
		};
		JButtonFixture noButton = dialog.button(noButtonMatcher);
		noButton.requireEnabled();
		noButton.requireVisible();
		noButton.click();
	}

	//@Test /*
	public void testNewToolBarYes() {
		// Assume.assumeTrue(NotepadVariables.getSINGLETON().isPERSISTENCETOOLBAR___());
//		Configuration.PERSISTENCETOOLBAR = true;
//		Configuration.BASETOOLBAR = true;

		if (Configuration.PERSISTENCETOOLBAR && Configuration.BASETOOLBAR) {
			DialogFixture dialog = Helper.fileInitializerToolBar(window, "New");

			// Click Yes
			GenericTypeMatcher<JButton> yesButtonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
				@Override
				protected boolean isMatching(JButton arg1) {
					String expected = "Yes";
					String actual = arg1.getText();
					return actual == null ? false : expected.equals(actual);
				}
			};
			JButtonFixture yesButton = dialog.button(yesButtonMatcher);
			yesButton.requireEnabled();
			yesButton.requireVisible();
			yesButton.click();

			JFileChooserFixture fileChooser = dialog.fileChooser();
			JTextComponentFixture fileName = fileChooser
					.setCurrentDirectory(new File(System.getProperty("java.io.tmpdir"))).fileNameTextBox();
			fileName.enterText("tempNew");

			GenericTypeMatcher<JButton> saveButtonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
				@Override
				protected boolean isMatching(JButton arg0) {
					String expected = "Save";
					String actual = arg0.getText();
					return actual == null ? false : expected.equals(actual);
				}
			};

			DialogFixture saveDialog = dialog.dialog();
			assertNotNull(saveDialog);

			JButtonFixture saveButton = saveDialog.button(saveButtonMatcher);
			saveButton.requireEnabled();
			saveButton.requireVisible();
			saveButton.click();

			// remove file
			File toRemove = new File(System.getProperty("java.io.tmpdir") + "tempNew.txt");
			toRemove.delete();
		}
	}

	//@Test /*
	public void testSaveToolBar() {
//		Configuration.PERSISTENCETOOLBAR = true;
//		Configuration.BASETOOLBAR = true;

		if (Configuration.PERSISTENCETOOLBAR && Configuration.BASETOOLBAR) {
			DialogFixture dialog = Helper.fileInitializerToolBar(window, "Save");

			JFileChooserFixture fileChooser = dialog.fileChooser();
			JTextComponentFixture fileName = fileChooser
					.setCurrentDirectory(new File(System.getProperty("java.io.tmpdir"))).fileNameTextBox();
			fileName.enterText("tempSave");

			DialogFixture saveDialog = dialog.dialog();
			assertNotNull(saveDialog);

			// Click save
			GenericTypeMatcher<JButton> saveButtonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
				@Override
				protected boolean isMatching(JButton arg0) {
					String expected = "Save";
					String actual = arg0.getText();
					return actual == null ? false : expected.equals(actual);
				}
			};
			JButtonFixture saveButton = saveDialog.button(saveButtonMatcher);
			saveButton.requireEnabled();
			saveButton.requireVisible();
			saveButton.click();

			// remove file
			File toRemove = new File(System.getProperty("java.io.tmpdir") + "tempSave.txt");
			toRemove.delete();
		}
	}

	//@Test /*
	public void testSaveAsToolBar() {
//		Configuration.PERSISTENCETOOLBAR = true;
//		Configuration.BASETOOLBAR = true;

		if (Configuration.PERSISTENCETOOLBAR && Configuration.BASETOOLBAR) {
			DialogFixture dialog = Helper.fileInitializerToolBar(window, "Save As");

			JFileChooserFixture fileChooser = dialog.fileChooser();
			JTextComponentFixture fileName = fileChooser
					.setCurrentDirectory(new File(System.getProperty("java.io.tmpdir"))).fileNameTextBox();
			fileName.enterText("tempSaveAs");

			DialogFixture saveDialog = dialog.dialog();
			assertNotNull(saveDialog);

			// Click save
			GenericTypeMatcher<JButton> saveButtonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
				@Override
				protected boolean isMatching(JButton button) {
					String expected = "Save";
					String actual = button.getText();
					return actual == null ? false : expected.equals(actual);
				}
			};
			JButtonFixture saveButton = saveDialog.button(saveButtonMatcher);
			saveButton.requireEnabled();
			saveButton.requireVisible();
			saveButton.click();

			// remove file
			File toRemove = new File(System.getProperty("java.io.tmpdir") + "tempSaveAs.txt");
			toRemove.delete();
		}
	}

	// @Ignore
	// @Test
	// public void testOpenToolBar() throws InterruptedException,
	// InvocationTargetException {
	// // (1) Create a file to open later
	// try {
	// Helper.saveAFile();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// // (2) open the created file using button bar (Open)
	// GenericTypeMatcher<JButton> buttonMatcher = new GenericTypeMatcher<JButton>(
	// JButton.class) {
	// @Override
	// protected boolean isMatching(JButton button) {
	// String expected = "Open";
	// String actual = button.getToolTipText();
	// return actual == null ? false : expected.equals(actual);
	// }
	// };
	//
	// final JButtonFixture button = window.button(buttonMatcher);
	// button.requireVisible();
	// button.requireEnabled();
	// button.click();
	//
	// GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
	// Dialog.class) {
	// @Override
	// protected boolean isMatching(Dialog dialog) {
	// return dialog.isFocused();
	// }
	// };
	//
	// DialogFixture dialog = window.dialog(diaglogMatcher);
	// Assert.assertNotNull(dialog);
	//
	// JFileChooserFixture fileChooser = dialog.fileChooser();
	// fileChooser = fileChooser.setCurrentDirectory(
	// new File(System.getProperty("java.io.tmpdir"))).selectFile(
	// new File(Helper.FILE_NAME));
	// fileChooser.cancel();
	//
	// // fileChooser.approve();
	// // assertThat(window.textBox().text()).contains(
	// // "typing something to save and open later");
	//
	// // remove file
	// File toRemove = new File(Helper.FILE_NAME);
	// toRemove.delete();
	//
	// }

	@Test
	public void testPrintToolBar() {
		// Assume.assumeTrue(NotepadVariables.getSINGLETON().isPRINTTOOLBAR___());
		// (1) type some text
//		Configuration.PERSISTENCETOOLBAR = true;
//		Configuration.BASETOOLBAR = true;
//		Configuration.PRINTTOOLBAR = true;
			if (Configuration.PERSISTENCETOOLBAR && Configuration.BASETOOLBAR && Configuration.PRINTTOOLBAR) {

				GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(JTextArea.class) {
					@Override
					protected boolean isMatching(JTextArea testArea) {
						return true;
					}
				};
				JTextComponentFixture textArea = window.textBox(textAreaMatcher);
				textArea.setText("typing something to print");

				// (2) print some existing file using button bar (Print)
				GenericTypeMatcher<JButton> buttonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
					@Override
					protected boolean isMatching(JButton button) {
						String expected = "Print";
						String actual = button.getToolTipText();
						return actual == null ? false : expected.equals(actual);
					}
				};

				JButtonFixture button = window.button(buttonMatcher);
				button.requireEnabled();
				button.click();

				window.close();
			}
		}
	
}
