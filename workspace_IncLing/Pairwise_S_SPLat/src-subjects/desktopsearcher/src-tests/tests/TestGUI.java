package tests;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.awt.Dialog;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import junit.framework.Assert;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JComboBoxFixture;
import org.fest.swing.fixture.JFileChooserFixture;
import org.fest.swing.fixture.JLabelFixture;
import org.fest.swing.fixture.JOptionPaneFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import splat.DesktopSearcherVariables;
import desktopsearcher.MainFrame;
import desktopsearcher.MrPinkMain;

public class TestGUI extends DesktopSearcherTest {

	// BASE, HTML, TXT, LATEX, USER_INTERFACE, COMMAND_LINE, GUI,
	// GUI_PREFERENCES, QUERY_HISTORY, INDEX_HISTORY, SINGLE_DIRECTORY,
	// MULTI_DIRECTORY, NORMAL_VIEW, TREE_VIEW, WINDOWS, LINUX
	@Override
	protected void configure() {
		super.configure();
		if (testName == null) {
			throw new RuntimeException();
		}

		// set common features
		DesktopSearcherVariables.getSINGLETON().setGUI(true);

		String mName = testName.getMethodName();
		/**
		 * set specific features for each test
		 */
//		if (mName.equals("testIndexNoFile_SingleDir")) {
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setTXT(false);
//			DesktopSearcherVariables.getSINGLETON().setHTML(false);
//			DesktopSearcherVariables.getSINGLETON().setLATEX(false);
//		} else if (mName.equals("testIndexTXT_SingleDir")) {
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setTXT(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testIndexHTML_SingleDir")) {
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setHTML(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testIndexLATEX_SingleDir")) {
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setLATEX(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testIndexNoFile_MultiDir")) {
//			DesktopSearcherVariables.getSINGLETON().setMULTI_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setTXT(false);
//			DesktopSearcherVariables.getSINGLETON().setHTML(false);
//			DesktopSearcherVariables.getSINGLETON().setLATEX(false);
//		} else if (mName.equals("testIndexLATEX_MultiDir")) {
//			DesktopSearcherVariables.getSINGLETON().setMULTI_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setLATEX(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testIndexTXT_MultiDir")) {
//			DesktopSearcherVariables.getSINGLETON().setMULTI_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setTXT(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testIndexHTML_MultiDir")) {
//			DesktopSearcherVariables.getSINGLETON().setMULTI_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setHTML(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testSearchNoFile_NormalView")) {
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testSearchTXT_NormalView")) {
//			DesktopSearcherVariables.getSINGLETON().setTXT(true);
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testSearchHTML_NormalView")) {
//			DesktopSearcherVariables.getSINGLETON().setHTML(true);
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testSearchLATEX_NormalView")) {
//			DesktopSearcherVariables.getSINGLETON().setLATEX(true);
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testSearchTXT_TreeView")) {
//			DesktopSearcherVariables.getSINGLETON().setTXT(true);
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//			DesktopSearcherVariables.getSINGLETON().setTREE_VIEW(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testSearchHTML_TreeView")) {
//			DesktopSearcherVariables.getSINGLETON().setHTML(true);
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//			DesktopSearcherVariables.getSINGLETON().setTREE_VIEW(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testSearchLATEX_TreeView")) {
//			DesktopSearcherVariables.getSINGLETON().setLATEX(true);
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//			DesktopSearcherVariables.getSINGLETON().setTREE_VIEW(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testSearchNoFile_TreeView")) {
//			DesktopSearcherVariables.getSINGLETON().setTXT(true);
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//			DesktopSearcherVariables.getSINGLETON().setTREE_VIEW(true);
//			DesktopSearcherVariables.getSINGLETON().setTXT(false);
//			DesktopSearcherVariables.getSINGLETON().setHTML(false);
//			DesktopSearcherVariables.getSINGLETON().setLATEX(false);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testHistory_SingleDir")) {
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(true);
//			// DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(true);
//		} else if (mName.equals("testOptions_SingleDir")) {
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setGUI_PREFERENCES(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testOptions_MultiDir")) {
//			DesktopSearcherVariables.getSINGLETON().setMULTI_DIRECTORY(true);
//			DesktopSearcherVariables.getSINGLETON().setGUI_PREFERENCES(true);
//			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
//		} else if (mName.equals("testNoPath")) {
//			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//		}
	}

	static FrameFixture window;
	MainFrame mainFrame;

	static final String OUTPUT_PATH = homeDir + "/src-tests/outGUI.txt";
	static final String VALID_INDEX_PATH = homeDir + "/files";
	static final String SEARCHED_STRING = "test";

	@Before
	public void setup() throws FileNotFoundException {
		writeOutput(OUTPUT_PATH);
		FailOnThreadViolationRepaintManager.install();
		GuiQuery<MainFrame> action = new GuiQuery<MainFrame>() {
			protected MainFrame executeInEDT() {
				configure();
				 mainFrame = new MainFrame(new MrPinkMain());
//				mainFrame = (MainFrame) new MrPinkMain().userInterface;
				return mainFrame;
			}
		};
		mainFrame = GuiActionRunner.execute(action);
		window = new FrameFixture(mainFrame);
		window.show(new Dimension(600, 400));
	}

	@Test
	public void testIndexNoFile_SingleDir() {
		assertTrue(getNumberOfIndexedFiles_SingleDir() == 0);
	}

	@Test
	public void testIndexTXT_SingleDir() {
		assertTrue(getNumberOfIndexedFiles_SingleDir() >= 5);
	}

	@Test
	public void testIndexHTML_SingleDir() {
		assertTrue(getNumberOfIndexedFiles_SingleDir() >= 3);
	}

	@Test
	public void testIndexLATEX_SingleDir() {
		assertTrue(getNumberOfIndexedFiles_SingleDir() >= 2);
	}

	@Test
	public void testIndexNoFile_MultiDir() {
		assertTrue(getNumberOfIndexedFiles_MultiDir() == 0);
	}

	@Test
	public void testIndexTXT_MultiDir() {
		assertTrue(getNumberOfIndexedFiles_MultiDir() >= 5);
	}

	@Test
	public void testIndexHTML_MultiDir() {
		assertTrue(getNumberOfIndexedFiles_MultiDir() >= 3);
	}

	@Test
	public void testIndexLATEX_MultiDir() {
		assertTrue(getNumberOfIndexedFiles_MultiDir() >= 2);
	}

	@Test
	public void testSearchNoFile_NormalView() throws IOException {
		assertTrue(getNumberOfMatchingDocs_NormalView() == 0);
	}

	@Test
	public void testSearchTXT_NormalView() throws IOException {
		assertTrue(getNumberOfMatchingDocs_NormalView() >= 3);
	}

	@Test
	public void testSearchHTML_NormalView() throws IOException {
		assertTrue(getNumberOfMatchingDocs_NormalView() >= 2);
	}

	@Test
	public void testSearchLATEX_NormalView() throws IOException {
		assertTrue(getNumberOfMatchingDocs_NormalView() >= 1);
	}

	@Test
	public void testOptions_SingleDir() {
		// first indexes the files
		getNumberOfIndexedFiles_SingleDir();
		testOptions();
	}

	@Test
	public void testOptions_MultiDir() {
		// first indexes the files
		getNumberOfIndexedFiles_MultiDir();
		testOptions();
	}

	@Test
	public void testSearchTXT_TreeView() throws IOException {
		assertTrue(getNumberOfMatchingDocs_TreeView() >= 3);
	}

	@Test
	public void testSearchHTML_TreeView() throws IOException {
		assertTrue(getNumberOfMatchingDocs_TreeView() >= 2);
	}

	@Test
	public void testSearchLATEX_TreeView() throws IOException {
		assertTrue(getNumberOfMatchingDocs_TreeView() >= 1);
	}

	@Test
	public void testSearchNoFile_TreeView() throws IOException {
		assertTrue(getNumberOfMatchingDocs_TreeView() == 0);
	}

	@Test
	public void testNoPath() {
		// Click "Change" button
		JButtonFixture button = window.button(getButtonMatcher("Refresh"));
		Assert.assertNotNull(button);
		button.requireVisible();
		button.requireEnabled();
		button.click();

		// error message dialog
		GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
				Dialog.class) {
			@Override
			protected boolean isMatching(Dialog dialog) {
				return dialog.getTitle().equals("An error occurred!")
						&& dialog.isVisible();
			}
		};
		DialogFixture errorDialog = window.dialog(diaglogMatcher);
		Assert.assertNotNull(errorDialog);

		JOptionPaneFixture errorPanel = errorDialog.optionPane();
		assertThat(errorPanel).isNotNull();

		assertThat(errorPanel.label("OptionPane.label").text()).isEqualTo(
				"No path given.");

		JButtonFixture okbutton = errorPanel.button(getButtonMatcher("OK"));
		Assert.assertNotNull(okbutton);
		okbutton.requireVisible();
		okbutton.requireEnabled();
		okbutton.click();
	}

	@Test
	public void testHistory_SingleDir() {
		// Click "Change" button
		JButtonFixture button = window.button(getButtonMatcher("Change"));
		Assert.assertNotNull(button);
		button.requireVisible();
		button.requireEnabled();
		button.click();

		// History dialog
		GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
				Dialog.class) {
			@Override
			protected boolean isMatching(Dialog dialog) {
				return dialog.getTitle().equals("Index Selection")
						&& dialog.isVisible();
			}
		};
		DialogFixture historyDialog = window.dialog(diaglogMatcher);
		Assert.assertNotNull(historyDialog);

		JButtonFixture okbutton = historyDialog.button(getButtonMatcher("OK"));
		Assert.assertNotNull(okbutton);
		okbutton.requireVisible();
		okbutton.requireEnabled();
		okbutton.click();

		// choosing the directory for indexing
		JFileChooserFixture fileChooser = historyDialog.fileChooser();
		fileChooser.setCurrentDirectory(new File(homeDir));
		fileChooser.setCurrentDirectory(new File(homeDir));// dealing with more
		// than a call to
		// the fileChooser
		fileChooser.selectFile(new File(VALID_INDEX_PATH));
		fileChooser.approveButton().requireEnabled();
		fileChooser.approve();
	}

	/****************************************************************************************************/

	private int getNumberOfMatchingDocs_NormalView() throws IOException {
		// before running the search, we need indexing files
		getNumberOfIndexedFiles_SingleDir();

		// running the search
		JComboBoxFixture comboBoxSearch = window.comboBox();
		comboBoxSearch.enterText(SEARCHED_STRING);

		// Click "Search" button
		JButtonFixture button = window.button(getButtonMatcher("Search"));
		Assert.assertNotNull(button);
		button.requireVisible();
		button.requireEnabled();
		button.click();
		return getNumberMatchingDocs(OUTPUT_PATH, SEARCHED_STRING);
	}

	private void testOptions() {
		// Click "Options" button
		JButtonFixture button = window.button(getButtonMatcher("Options"));
		Assert.assertNotNull(button);
		button.requireVisible();
		button.requireEnabled();
		button.click();

		// Options dialog
		GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
				Dialog.class) {
			@Override
			protected boolean isMatching(Dialog dialog) {
				return dialog.getTitle().equals("Options")
						&& dialog.isVisible();
			}
		};
		DialogFixture optionsDialog = window.dialog(diaglogMatcher);
		Assert.assertNotNull(optionsDialog);

		// changing the option
		optionsDialog.radioButton(getRadioButtonMatcher("Show largest files"));

		JButtonFixture okbutton = optionsDialog.button(getButtonMatcher("OK"));
		Assert.assertNotNull(okbutton);
		okbutton.requireVisible();
		okbutton.requireEnabled();
		okbutton.click();

		// add assertion
	}

	private int getNumberOfMatchingDocs_TreeView() throws IOException {
		// before running the search, we need indexing files
		getNumberOfIndexedFiles_SingleDir();

		// running the search
		JComboBoxFixture comboBoxSearch = window.comboBox();
		comboBoxSearch.enterText(SEARCHED_STRING);

		// Click "Search" button
		JButtonFixture button = window.button(getButtonMatcher("Search"));
		Assert.assertNotNull(button);
		button.requireVisible();
		button.requireEnabled();
		button.click();

		// JPanelFixture searchPanel = window.panel("searchResultContainer");
		// JSplitPaneFixture splitPanel = searchPanel.splitPane("splitView");

		// // clicking on the tree
		// JTreeFixture tree = window.panel("searchResultContainer").tree();
		// assertThat(tree).isNotNull(); // sanity test
		// tree = tree.selectPath("Results/VALID_INDEX_PATH/file1.txt");
		// tree.click();

		return getNumberMatchingDocs(OUTPUT_PATH, SEARCHED_STRING);
	}

	private int getNumberOfIndexedFiles_SingleDir() {
		// Click "Change" button
		JButtonFixture button = window.button(getButtonMatcher("Change"));
		Assert.assertNotNull(button);
		button.requireVisible();
		button.requireEnabled();
		button.click();
		ChooseIndexDir();
		String result = testIndex();
		return Integer.parseInt(result.split(" ")[0]);

	}

	private int getNumberOfIndexedFiles_MultiDir() {
		// Click "Add" button
		JButtonFixture button = window.button(getButtonMatcher("Add"));
		Assert.assertNotNull(button);
		button.requireVisible();
		button.requireEnabled();
		button.click();

		ChooseIndexDir();

		// clicking "Index" button
		JButtonFixture indexButton = window.button(getButtonMatcher("Index"));
		Assert.assertNotNull(indexButton);
		indexButton.requireVisible();
		indexButton.requireEnabled();
		indexButton.click();

		String result = testIndex();
		return Integer.parseInt(result.split(" ")[0]);

	}

	private String testIndex() {
		// validating the dialog boxes
		JOptionPaneFixture indexing_dialog = window.optionPane();
		assertThat(indexing_dialog).isNotNull();
		indexing_dialog.requireTitle("Indexing");
		indexing_dialog.requireInformationMessage().requireMessage(
				"The directory " + VALID_INDEX_PATH + " is being indexed.");

		JButtonFixture okbutton = indexing_dialog
				.button(getButtonMatcher("OK"));
		Assert.assertNotNull(okbutton);
		okbutton.requireVisible();
		okbutton.requireEnabled();
		okbutton.click();

		JOptionPaneFixture done_indexing_dialog = window.optionPane();
		assertThat(done_indexing_dialog).isNotNull();
		done_indexing_dialog.requireTitle("Done indexing.");

		JLabelFixture label = done_indexing_dialog.label("OptionPane.label");
		String message = label.text();

		// OK button
		JButtonFixture okdonebutton = done_indexing_dialog
				.button(getButtonMatcher("OK"));
		Assert.assertNotNull(okbutton);
		okdonebutton.requireVisible();
		okdonebutton.requireEnabled();
		okdonebutton.click();

		return message;
	}

	private void ChooseIndexDir() {
		GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
				Dialog.class) {
			@Override
			protected boolean isMatching(Dialog dialog) {
				return dialog.getTitle().equals("Open") && dialog.isVisible();
			}
		};
		DialogFixture dialog = window.dialog(diaglogMatcher);
		Assert.assertNotNull(dialog);

		// choosing the directory for indexing
		JFileChooserFixture fileChooser = dialog.fileChooser();
		fileChooser.setCurrentDirectory(new File(homeDir));
		fileChooser.setCurrentDirectory(new File(homeDir));// dealing with more
															// than a call to
															// the fileChooser
		fileChooser.selectFile(new File(VALID_INDEX_PATH));
		fileChooser.approveButton().requireEnabled();
		fileChooser.approve();
	}

	private GenericTypeMatcher<JButton> getButtonMatcher(
			final String buttonNameExpected) {
		GenericTypeMatcher<JButton> buttonMatcher = new GenericTypeMatcher<JButton>(
				JButton.class) {
			@Override
			protected boolean isMatching(JButton button) {
				String expected = buttonNameExpected;
				String actual = button.getText();
				return actual == null ? false : expected.equals(actual);
			}
		};
		return buttonMatcher;
	}

	private GenericTypeMatcher<JRadioButton> getRadioButtonMatcher(
			final String buttonNameExpected) {
		GenericTypeMatcher<JRadioButton> buttonMatcher = new GenericTypeMatcher<JRadioButton>(
				JRadioButton.class) {
			@Override
			protected boolean isMatching(JRadioButton button) {
				String expected = buttonNameExpected;
				String actual = button.getText();
				return actual == null ? false : expected.equals(actual);
			}
		};
		return buttonMatcher;
	}

	@After
	public void teardown() {
		window.cleanUp();
//		 DesktopSearcherVariables.getSINGLETON().restore();
		deleteDirectory(new File(homeDir + "/index"));
	}

//	@AfterClass
//	public static void closeWindow() {
//		window.close();
//	 }

}
