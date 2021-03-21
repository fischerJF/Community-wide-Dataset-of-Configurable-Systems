package testset;

import static org.junit.Assert.assertNotNull;

import java.awt.Dialog;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextArea;

import junit.framework.Assert;
import specifications.Configuration;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JFileChooserFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.junit.Test;

public class TestFileMenuBar extends NotepadTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		// NotepadVariables.getSINGLETON().setPERSISTENCEMENUBAR___(true);
		// NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
		if (testName == null) {
			throw new RuntimeException();
		}
		String mName = testName.getMethodName();
		/**
		 * set optional features specific for each test
		 */
		// if (mName.equals("testNewMenuBar")) {
		//
		// } else if (mName.equals("testNewMenuBarNo")
		// || mName.equals("testNewMenuBarYes")
		// || mName.equals("testNewMenuBarYesSavedText")
		// || mName.equals("testNewMenuBarNoSavedText")
		// || mName.equals("testNewMenuBarAfterSavedText")
		// || mName.equals("testOpenMenuBar")
		// || mName.equals("testOpenMenuBarWithoutPreviusFile")) {
		// // NotepadVariables.getSINGLETON().setPERSISTENCEMENUBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// } else if (mName.equals("testNewMenuBarAfterSavedTextWithoutFeature")) {
		// // NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// // NotepadVariables.getSINGLETON().setPERSISTENCEMENUBAR___(true);
		// } else if (mName.equals("testSaveMenuBar")
		// || mName.equals("testSaveAsMenuBar")) {
		// // NotepadVariables.getSINGLETON().setPERSISTENCEMENUBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
		// } else if (mName.equals("testPrintMenuBar")) {
		// // NotepadVariables.getSINGLETON().setPERSISTENCEMENUBAR___(true);
		// NotepadVariables.getSINGLETON().setPRINTMENUBAR___(true);
		// // NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
		// }
	}

	@Test
	public void testNewMenuBarNo() {
		DialogFixture dialog = Helper.fileNewInitializerMenuBar(window);

		// Click no
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

	//@Test //*
	public void testNewMenuBarYes() {
		// Assume.assumeTrue(NotepadVariables.getSINGLETON().isBASEMENUBAR___()
		// && NotepadVariables.getSINGLETON().isPERSISTENCEMENUBAR___());

		Configuration.PERSISTENCEMENUBAR = true;
		Configuration.BASETOOLBAR = true;
		Configuration.BASEMENUBAR = true;
		if (Configuration.PERSISTENCEMENUBAR && Configuration.BASETOOLBAR && Configuration.BASEMENUBAR) {
			DialogFixture dialog = Helper.fileNewInitializerMenuBar(window);

			// Click yes
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

			DialogFixture saveDialog = dialog.dialog();
			Assert.assertNotNull(saveDialog);

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
			File toRemove = new File(System.getProperty("java.io.tmpdir") + "tempNew.txt");
			toRemove.delete();
		}
	}

	//@Test //*
	public void testNewMenuBarYesSavedText() {
//		Configuration.PERSISTENCEMENUBAR = true;
//		Configuration.BASETOOLBAR = true;
//		Configuration.BASEMENUBAR = true;
		if (Configuration.PERSISTENCEMENUBAR && Configuration.BASETOOLBAR && Configuration.BASEMENUBAR) {
			savingText();
			addingMoreText("Yes");
		}
	}

	//@Test //*
	public void testNewMenuBarNoSavedText() {
//		Configuration.PERSISTENCEMENUBAR = true;
//		Configuration.BASETOOLBAR = true;
//		Configuration.BASEMENUBAR = true;
		if (Configuration.PERSISTENCEMENUBAR && Configuration.BASETOOLBAR && Configuration.BASEMENUBAR) {
			savingText();
			addingMoreText("No");
		}
	}

	//@Test //*
	public void testNewMenuBarAfterSavedText() {
//		Configuration.PERSISTENCEMENUBAR = true;
//		Configuration.BASETOOLBAR = true;
//		Configuration.BASEMENUBAR = true;
		if (Configuration.PERSISTENCEMENUBAR && Configuration.BASETOOLBAR && Configuration.BASEMENUBAR) {
			savingText();
			// Try File > New. It should ask if you want to save
			JMenuItemFixture itemNew = window.menuItemWithPath("File", "New");
			itemNew.click();
		}
	}

	//@Test //*
	public void testNewMenuBarAfterSavedTextWithoutFeature() {
//		Configuration.PERSISTENCEMENUBAR = true;
//		Configuration.BASETOOLBAR = true;
//		Configuration.BASEMENUBAR = true;
		if (Configuration.PERSISTENCEMENUBAR && Configuration.BASETOOLBAR && Configuration.BASEMENUBAR) {
			savingText();
			// Try File > New. It should ask if you want to save
			JMenuItemFixture itemNew = window.menuItemWithPath("File", "New");
			itemNew.click();
		}
	}

	private void addingMoreText(final String expectedOption) {
		GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea button) {
				return true;
			}
		};
		JTextComponentFixture textArea = window.textBox(textAreaMatcher);
		textArea.requireEditable();
		String text = " ... xxx";
		textArea.enterText(text);

		DialogFixture dialog2 = Helper.fileNewInitializerMenuBar(window);

		// Click yes
		GenericTypeMatcher<JButton> yesButtonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
			@Override
			protected boolean isMatching(JButton arg1) {
				String expected = expectedOption;
				String actual = arg1.getText();
				return actual == null ? false : expected.equals(actual);
			}
		};
		JButtonFixture yesButton = dialog2.button(yesButtonMatcher);
		yesButton.requireEnabled();
		yesButton.requireVisible();
		yesButton.click();
	}

	private void savingText() {
		// (1) type some text
		GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea testArea) {
				return true;
			}
		};
		JTextComponentFixture textArea = window.textBox(textAreaMatcher);
		textArea.setText("typing something to save");

		// Try File > Save. It should ask if you want to save
		JMenuItemFixture itemNew = window.menuItemWithPath("File", "Save");
		itemNew.click();

		GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(Dialog.class) {
			@Override
			protected boolean isMatching(Dialog dialog) {
				return dialog.isFocused();
			}
		};

		DialogFixture dialog = window.dialog(diaglogMatcher);
		assertNotNull(dialog);

		// (2) save this text using menu bar (Save)
		JFileChooserFixture fileChooser = dialog.fileChooser();
		JTextComponentFixture fileName = fileChooser.setCurrentDirectory(new File(System.getProperty("java.io.tmpdir")))
				.fileNameTextBox();
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
	}

	//@Test //*
	public void testSaveMenuBar() {
		// Assume.assumeTrue(NotepadVariables.getSINGLETON().isBASEMENUBAR___()
		// && NotepadVariables.getSINGLETON().isPERSISTENCEMENUBAR___());
		savingText();

		// (3) remove file
		File toRemove = new File(System.getProperty("java.io.tmpdir") + "tempSave.txt");
		toRemove.delete();
	}

	//@Test //*
	public void testSaveAsMenuBar() {
		// Assume.assumeTrue(NotepadVariables.getSINGLETON().isBASEMENUBAR___()
		// && NotepadVariables.getSINGLETON().isPERSISTENCE___());
		// (1) type some text
//		Configuration.PERSISTENCEMENUBAR = true;
//		Configuration.BASEMENUBAR = true;
		if (Configuration.PERSISTENCEMENUBAR && Configuration.BASEMENUBAR) {
			GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(JTextArea.class) {
				@Override
				protected boolean isMatching(JTextArea testArea) {
					return true;
				}
			};
			JTextComponentFixture textArea = window.textBox(textAreaMatcher);
			textArea.setText("typing something to save");

			// Try File > Save As: It should ask if you want to save
			JMenuItemFixture itemNew = window.menuItemWithPath("File", "Save As");
			itemNew.click();

			GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(Dialog.class) {
				@Override
				protected boolean isMatching(Dialog dialog) {
					return dialog.isFocused();
				}
			};

			DialogFixture dialog = window.dialog(diaglogMatcher);
			assertNotNull(dialog);

			// (2) save this text using menu bar (Save AS)
			JFileChooserFixture fileChooser = dialog.fileChooser();
			JTextComponentFixture fileName = fileChooser
					.setCurrentDirectory(new File(System.getProperty("java.io.tmpdir"))).fileNameTextBox();
			fileName.enterText("tempSaveAs");

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

			// (3) remove file
			File toRemove = new File(System.getProperty("java.io.tmpdir") + "tempSaveAs.txt");
			toRemove.delete();
		}
	}

	// @Ignore
	// @Test
	// public void testOpenMenuBar() throws IOException {
	// // (1) Create a file to open later
	// Helper.saveAFile();
	//
	// // (2) open some existing file using menu bar (Open)
	// JMenuItemFixture itemOpen = window.menuItemWithPath("File", "Open");
	// itemOpen.click();
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
	// fileChooser.setCurrentDirectory(
	// new File(System.getProperty("java.io.tmpdir"))).selectFile(
	// new File(Helper.FILE_NAME));
	// // fileChooser.approve();
	// fileChooser.cancel();
	//
	// // (3) remove file
	// File toRemove = new File(Helper.FILE_NAME);
	// toRemove.delete();
	//
	// }

	//@Test //*
	public void testOpenMenuBarWithoutPreviusFile() throws IOException {
		// (1) Type some text
//		Configuration.PERSISTENCEMENUBAR = true;
//		Configuration.BASETOOLBAR = true;
//		Configuration.BASEMENUBAR = true;
		if (Configuration.PERSISTENCEMENUBAR && Configuration.BASETOOLBAR && Configuration.BASEMENUBAR) {
			GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(JTextArea.class) {
				@Override
				protected boolean isMatching(JTextArea button) {
					return true;
				}
			};
			JTextComponentFixture textArea = window.textBox(textAreaMatcher);
			textArea.requireEditable();
			String text = "Hello";
			textArea.enterText(text);

			// (2) open some existing file using menu bar (Open)
			JMenuItemFixture itemOpen = window.menuItemWithPath("File", "Open");
			itemOpen.click();

			GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(Dialog.class) {
				@Override
				protected boolean isMatching(Dialog dialog) {
					return dialog.isFocused();
				}
			};

			DialogFixture dialog = window.dialog(diaglogMatcher);
			Assert.assertNotNull(dialog);

			// Click yes
			GenericTypeMatcher<JButton> yesButtonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
				@Override
				protected boolean isMatching(JButton arg1) {
					String expected = "Cancel";
					String actual = arg1.getText();
					return actual == null ? false : expected.equals(actual);
				}
			};
			JButtonFixture yesButton = dialog.button(yesButtonMatcher);
			yesButton.requireEnabled();
			yesButton.requireVisible();
			yesButton.click();

			// (3) remove file
			File toRemove = new File(Helper.FILE_NAME);
			toRemove.delete();
		}
	}

	@Test
	public void testPrintMenuBar() {
		// Assume.assumeTrue(NotepadVariables.getSINGLETON().isPRINTMENUBAR___());
		// (1) type some text
//		Configuration.PERSISTENCEMENUBAR= true;
//		  Configuration.PRINTMENUBAR = true;
//		  Configuration.BASEMENUBAR = true;
	      if (Configuration.PERSISTENCEMENUBAR && Configuration.PRINTMENUBAR && Configuration.BASEMENUBAR ) {
		GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(JTextArea.class) {
			@Override
			protected boolean isMatching(JTextArea testArea) {
				return true;
			}
		};
		JTextComponentFixture textArea = window.textBox(textAreaMatcher);
		textArea.setText("typing something to print");

		// (2) print some existing file using menu bar (Print)
		JMenuItemFixture itemPrint = window.menuItemWithPath("File", "Print");
		itemPrint.click();

		window.close();
		}
	}
}
