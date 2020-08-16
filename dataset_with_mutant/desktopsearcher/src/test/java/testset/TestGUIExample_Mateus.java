//package testset;
//
//import static org.fest.assertions.Assertions.assertThat;
//import static org.junit.Assert.assertNotNull;
//
//import java.awt.Dialog;
//import java.awt.Dimension;
//import java.io.File;
//import java.io.IOException;
//
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JRadioButton;
//
//import org.fest.swing.core.GenericTypeMatcher;
//import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
//import org.fest.swing.edt.GuiActionRunner;
//import org.fest.swing.edt.GuiQuery;
//import org.fest.swing.exception.ComponentLookupException;
//import org.fest.swing.fixture.DialogFixture;
//import org.fest.swing.fixture.FrameFixture;
//import org.fest.swing.fixture.JButtonFixture;
//import org.fest.swing.fixture.JFileChooserFixture;
//import org.fest.swing.fixture.JOptionPaneFixture;
//import org.fest.swing.fixture.JTreeFixture;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.TestName;
//
//import desktopsearcher.HitComponentLabel;
//import desktopsearcher.Index_History_Selector;
//import desktopsearcher.MainFrame;
//import desktopsearcher.MrPinkMain;
//
//public class TestGUIExample_Mateus extends DesktopSearcherTest{
//
//	@Rule
//	public TestName testName = new TestName();
//
//	// BASE, HTML, TXT, LATEX, USER_INTERFACE, COMMAND_LINE, GUI,
//	// GUI_PREFERENCES, QUERY_HISTORY, INDEX_HISTORY, SINGLE_DIRECTORY,
//	// MULTI_DIRECTORY, NORMAL_VIEW, TREE_VIEW, WINDOWS, LINUX
//	protected void configure() {
//		super.configure();
//		if (testName == null) {
//			throw new RuntimeException();
//		}
//		String mName = testName.getMethodName();
//		/**
//		 * set specific features for each test
//		 */
////		if (mName.equals("testNoFileIndexed")) {
////			// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
////			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
////			DesktopSearcherVariables.getSINGLETON().setGUI(true);
////			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
////		} else if (mName.equals("testSearch")) {
////			// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
////			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
////			DesktopSearcherVariables.getSINGLETON().setGUI(true);
////			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
////			DesktopSearcherVariables.getSINGLETON().setTXT(true);
////			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
////		} else if (mName.equals("testHtmlSearch")) {
////			// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
////			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
////			DesktopSearcherVariables.getSINGLETON().setGUI(true);
////			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
////			DesktopSearcherVariables.getSINGLETON().setHTML(true);
////			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
////		} else if (mName.equals("testLatexSearch")) {
////			// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
////			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
////			DesktopSearcherVariables.getSINGLETON().setGUI(true);
////			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
////			DesktopSearcherVariables.getSINGLETON().setLATEX(true);
////			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
////		} else if (mName.equals("testTreeViewTxtSearch")) {
////			// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
////			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
////			DesktopSearcherVariables.getSINGLETON().setGUI(true);
////			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
////			DesktopSearcherVariables.getSINGLETON().setTXT(true);
////			DesktopSearcherVariables.getSINGLETON().setTREE_VIEW(true);
////		} else if (mName.equals("testMultiDirectorySearch")) {
////			// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
////			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
////			DesktopSearcherVariables.getSINGLETON().setGUI(true);
////			DesktopSearcherVariables.getSINGLETON().setMULTI_DIRECTORY(true);
////			DesktopSearcherVariables.getSINGLETON().setTXT(true);
////			DesktopSearcherVariables.getSINGLETON().setTREE_VIEW(true);
////		} else if (mName.equals("testOtherOptions")) {
////			// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
////			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
////			DesktopSearcherVariables.getSINGLETON().setGUI_PREFERENCES(true);
////			DesktopSearcherVariables.getSINGLETON().setGUI(true);
////			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
////			DesktopSearcherVariables.getSINGLETON().setTXT(true);
////			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
////		} else if (mName.equals("testIndexHistory")) {
////			// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
////			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
////			DesktopSearcherVariables.getSINGLETON().setGUI(true);
////			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
////			DesktopSearcherVariables.getSINGLETON().setTXT(true);
////			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
////			DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(true);
////		} else if (mName.equals("testQueryHistory")) {
////			// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
////			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
////			DesktopSearcherVariables.getSINGLETON().setGUI(true);
////			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
////			DesktopSearcherVariables.getSINGLETON().setTXT(true);
////			DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
////			DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(true);
////		}
//	}
//
//	static FrameFixture window;
//	MainFrame mainFrame;
//
//	static String homeDir;
//	static {
//		try {
//			homeDir = (new File(".")).getCanonicalPath();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	};
//	static final String VALID_INDEX_PATH = homeDir + "/files";
//
//	@Before
//	public void setup() {
//		FailOnThreadViolationRepaintManager.install();
//		GuiQuery<MainFrame> action = new GuiQuery<MainFrame>() {
//			protected MainFrame executeInEDT() {
//				configure();
//				// mainFrame = new MainFrame(new MrPinkMain());
//				mainFrame = (MainFrame) new MrPinkMain().userInterface;
//				return mainFrame;
//			}
//		};
//		mainFrame = GuiActionRunner.execute(action);
//		window = new FrameFixture(mainFrame);
//		window.show(new Dimension(600, 400));
//	}
//
////	@Test
////	public void testNoFileIndexed() {
////		// Click "Change" button
////		JButtonFixture button = window.button(getButtonMatcher("Change"));
////		assertNotNull(button);
////		button.requireVisible();
////		button.requireEnabled();
////		button.click();
////
////		GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
////				Dialog.class) {
////			@Override
////			protected boolean isMatching(Dialog dialog) {
////				return dialog.getTitle().equals("Open") && dialog.isVisible();
////			}
////		};
////		DialogFixture dialog = window.dialog(diaglogMatcher);
////		assertNotNull(dialog);
////
////		// choosing the directory for indexing
////		JFileChooserFixture fileChooser = dialog.fileChooser();
////		fileChooser.setCurrentDirectory(new File(homeDir));
////		fileChooser.setCurrentDirectory(new File(homeDir));// dealing with more
////		// than a call to
////		// the fileChooser
////		fileChooser.selectFile(new File(VALID_INDEX_PATH));
////		fileChooser.approveButton().requireEnabled();
////		fileChooser.approve();
////
////		// validating the dialog boxes
////		JOptionPaneFixture indexing_dialog = window.optionPane();
////		assertThat(indexing_dialog).isNotNull();
////		indexing_dialog.requireTitle("Indexing");
////		indexing_dialog.requireInformationMessage().requireMessage(
////				"The directory " + VALID_INDEX_PATH + " is being indexed.");
////
////		JButtonFixture okbutton = indexing_dialog
////				.button(getButtonMatcher("OK"));
////		assertNotNull(okbutton);
////		okbutton.requireVisible();
////		okbutton.requireEnabled();
////		okbutton.click();
////
////		JOptionPaneFixture done_indexing_dialog = window.optionPane();
////		assertThat(done_indexing_dialog).isNotNull();
////		done_indexing_dialog.requireTitle("Done indexing.");
////		done_indexing_dialog.requireInformationMessage().requireMessage(
////				"0 documents have been indexed.");
////
////		// OK button
////		JButtonFixture okdonebutton = done_indexing_dialog
////				.button(getButtonMatcher("OK"));
////		assertNotNull(okbutton);
////		okdonebutton.requireVisible();
////		okdonebutton.requireEnabled();
////		okdonebutton.click();
////	}
//
//	@Test
//	public void testSearch() {
//		indexTestDir();
//		searchTxts();
//		checkTxtLabels("---ranking position 1 ---", "Location: "
//				+ VALID_INDEX_PATH + "/file3.txt", "350323 Byte");
//	}
//
////	@Test
////	public void testHtmlSearch() {
////		indexTestDir();
////		searchHtmls();
////
////		checkTxtLabels("---ranking position 1 ---", "Location: "
////				+ VALID_INDEX_PATH + "/file1.html", "3468 Byte");
////
////		// checkTxtLabels(
////		// "---ranking position 1 ---",
////		// "Location: " + VALID_INDEX_PATH + "/file1.html",
////		// "3468 Byte", "Tue Feb 18 12:00:44 BRT 2014");
////	}
////
////	@Test
////	public void testLatexSearch() {
////		indexTestDir();
////		searchLatex();
////
////		checkTxtLabels("---ranking position 1 ---", "Location: "
////				+ VALID_INDEX_PATH + "/file1.tex", "16869 Byte");
////
////		// checkTxtLabels(
////		// "---ranking position 1 ---",
////		// "Location: " + VALID_INDEX_PATH + "/file1.tex",
////		// "16869 Byte", "Tue Feb 18 11:51:28 BRT 2014");
////	}
////
////	@Test
////	public void testTreeViewTxtSearch() {
////		indexTestDir();
////		searchTxts();
////		// window.tree()
////		// .separator("#")
////		// .node("Results#/home/mateus/workspace/desktopsearcher/files/#file3.txt")
////		// .click();
////
////		JTreeFixture tree = window.tree();
////		tree.separator("#");
////		tree.selectPath("Results#" + VALID_INDEX_PATH + "/file#3.tx#t");
////
////		checkTxtLabels("---ranking position 1 ---", "Location: "
////				+ VALID_INDEX_PATH + "/file3.txt", "350323 Byte");
////
////		// checkTxtLabels("---ranking position 1 ---", "Location: "
////		// + VALID_INDEX_PATH + "/file3.txt", "350323 Byte",
////		// "Tue Feb 18 00:13:22 BRT 2014");
////	}
////
////	// 1,?,1,?,1,0,1,1,0,1,0,1,?,1,?,?,F
////	@Test
////	public void testMultiDirectorySearch() {
////		indexTestMultipleDir();
////		searchTxts();
////		// window.tree()
////		// .separator("#")
////		// .node("Results#/home/mateus/workspace/desktopsearcher/files/#file3.txt")
////		// .click();
////
////		JTreeFixture tree = window.tree();
////		tree.separator("#");
////		tree.selectPath("Results#" + VALID_INDEX_PATH + "/file#3.tx#t");
////
////		checkTxtLabels("---ranking position 1 ---", "Location: "
////				+ VALID_INDEX_PATH + "/file3.txt", "350323 Byte");
////
////		// checkTxtLabels(
////		// "---ranking position 1 ---",
////		// "Location: " + VALID_INDEX_PATH + "/file3.txt",
////		// "350323 Byte", "Tue Feb 18 00:13:22 BRT 2014");
////	}
////
////	@Test
////	public void testOtherOptions() {
////		indexTestDir();
////		searchTxts();
////		checkLabelCount(4);
////
////		window.button(getButtonMatcher("Options")).click();
////		window.dialog(getDialogMatcher("Options")).focus().textBox()
////				.setText("2");
////		window.dialog(getDialogMatcher("Options")).focus()
////				.button(getButtonMatcher("Cancel")).click();
////
////		window.button(getButtonMatcher("Options")).click();
////		window.dialog(getDialogMatcher("Options")).focus().textBox()
////				.setText("2");
////		window.dialog(getDialogMatcher("Options")).focus()
////				.button(getButtonMatcher("OK")).click();
////
////		window.focus();
////		doSearch("org");
////		checkLabelCount(2);
////
////		checkTxtLabels("DokID 2", "DokID 3");
////
////		window.button(getButtonMatcher("Options")).click();
////		window.dialog(getDialogMatcher("Options")).focus()
////				.radioButton(getRadioButtonMatcher("Show largest files"))
////				.click();
////		window.dialog(getDialogMatcher("Options")).focus()
////				.button(getButtonMatcher("OK")).click();
////
////		window.button(getButtonMatcher("Search")).requireEnabled()
////				.requireVisible().click();
////		checkLabelCount(2);
////
////		checkTxtLabels("DokID 4", "DokID 3");
////
////		window.button(getButtonMatcher("Options")).click();
////		window.dialog(getDialogMatcher("Options")).focus()
////				.radioButton(getRadioButtonMatcher("Show last modified files"))
////				.click();
////		window.dialog(getDialogMatcher("Options")).focus()
////				.button(getButtonMatcher("OK")).click();
////
////		window.button(getButtonMatcher("Search")).requireEnabled()
////				.requireVisible().click();
////		checkLabelCount(2);
////
////		checkTxtLabels("DokID 0", "DokID 1");
////	}
////
////	@Test
////	public void testIndexHistory() {
////		JButtonFixture button = window.button(getButtonMatcher("Change"));
////		assertNotNull(button);
////		button.requireVisible();
////		button.requireEnabled();
////		button.click();
////
////		DialogFixture dialog = window.dialog(new GenericTypeMatcher<Dialog>(
////				Dialog.class) {
////			@Override
////			protected boolean isMatching(Dialog component) {
////				boolean b = component instanceof Index_History_Selector
////						&& component.isVisible();
////				return b;
////			}
////		});
////		dialog.focus().radioButton("radioBrowse").requireEnabled().click();
////		dialog.button(getButtonMatcher("Search")).requireEnabled().click();
////
////		// choosing the directory for indexing
////		JFileChooserFixture fileChooser = dialog.fileChooser();
////		fileChooser.setCurrentDirectory(new File(homeDir));
////		fileChooser.setCurrentDirectory(new File(homeDir));// dealing with more
////		// than a call to
////		// the fileChooser
////		fileChooser.selectFile(new File(VALID_INDEX_PATH));
////		fileChooser.approveButton().requireEnabled();
////		fileChooser.approve();
////
////		dialog.button(getButtonMatcher("OK")).requireEnabled().click();
////		// workaround repeated chooser (bug?)
////		dialog.fileChooser().cancel();
////
////		// validating the dialog boxes
////		JOptionPaneFixture indexing_dialog = window.optionPane();
////		assertThat(indexing_dialog).isNotNull();
////		indexing_dialog.requireTitle("Indexing");
////		indexing_dialog.requireInformationMessage().requireMessage(
////				"The directory " + VALID_INDEX_PATH + " is being indexed.");
////
////		JButtonFixture okbutton = indexing_dialog
////				.button(getButtonMatcher("OK"));
////		assertNotNull(okbutton);
////		okbutton.requireVisible();
////		okbutton.requireEnabled();
////		okbutton.click();
////
////		searchTxts();
////		checkTxtLabels("---ranking position 1 ---", "Location: "
////				+ VALID_INDEX_PATH + "/file3.txt", "350323 Byte");
////		// checkTxtLabels(
////		// "---ranking position 1 ---",
////		// "Location: " + VALID_INDEX_PATH + "/file3.txt",
////		// "350323 Byte", "Tue Feb 18 00:13:22 BRT 2014");
////
////		button = window.button(getButtonMatcher("Change"));
////		assertNotNull(button);
////		button.requireVisible();
////		button.requireEnabled();
////		button.click();
////
////		dialog = window.dialog(new GenericTypeMatcher<Dialog>(Dialog.class) {
////			@Override
////			protected boolean isMatching(Dialog component) {
////				boolean b = component instanceof Index_History_Selector
////						&& component.isVisible();
////				return b;
////			}
////		});
////		dialog.focus().radioButton("radioHistory").requireEnabled().click();
////		dialog.list().item(0).click();
////
////		dialog.button(getButtonMatcher("OK")).requireEnabled().click();
////		// workaround repeated chooser (bug?)
////		dialog.fileChooser().cancel();
////
////		// validating the dialog boxes
////		indexing_dialog = window.optionPane();
////		assertThat(indexing_dialog).isNotNull();
////		indexing_dialog.requireTitle("Indexing");
////		indexing_dialog.requireInformationMessage().requireMessage(
////				"The directory " + VALID_INDEX_PATH + " is being indexed.");
////
////		okbutton = indexing_dialog.button(getButtonMatcher("OK"));
////		assertNotNull(okbutton);
////		okbutton.requireVisible();
////		okbutton.requireEnabled();
////		okbutton.click();
////
////		searchTxts();
////		checkTxtLabels("---ranking position 1 ---", "Location: "
////				+ VALID_INDEX_PATH + "/file3.txt", "350323 Byte");
////		// checkTxtLabels(
////		// "---ranking position 1 ---",
////		// "Location: " + VALID_INDEX_PATH + "/file3.txt",
////		// "350323 Byte", "Tue Feb 18 00:13:22 BRT 2014");
////	}
////
////	@Test
////	public void testQueryHistory() {
////		indexTestDir();
////		checkNumberIndexedFiles(5);
////
////		String searchTerm = "org";
////		// enter search query
////		window.panel("xAxis1_createGroupBoxSearch").comboBox().requireEnabled()
////				.requireEditable().requireVisible().enterText(searchTerm);
////
////		JButtonFixture searchButton = window.button(getButtonMatcher("Search"));
////		assertNotNull(searchButton);
////		searchButton.requireVisible().requireEnabled().click();
////
////		checkLabelCount(4);
////		checkTxtLabels("---ranking position 1 ---", "Location: "
////				+ VALID_INDEX_PATH + "/file3.txt", "350323 Byte");
////		// checkTxtLabels(
////		// "---ranking position 1 ---",
////		// "Location: " + VALID_INDEX_PATH + "/file3.txt",
////		// "350323 Byte", "Tue Feb 18 00:13:22 BRT 2014");
////
////		window.panel("xAxis1_createGroupBoxSearch").comboBox().requireEnabled()
////				.requireEditable().requireVisible().replaceText("and");
////
////		searchButton = window.button(getButtonMatcher("Search"));
////		assertNotNull(searchButton);
////		searchButton.requireVisible().requireEnabled().click();
////
////		checkLabelCount(1);
////		checkTxtLabels("---ranking position 1 ---", "Location: "
////				+ VALID_INDEX_PATH + "/file1.txt", "712 Byte");
////		// checkTxtLabels(
////		// "---ranking position 1 ---",
////		// "Location: " + VALID_INDEX_PATH + "/file1.txt",
////		// "712 Byte", "Tue Feb 18 00:11:24 BRT 2014");
////
////		window.panel("xAxis1_createGroupBoxSearch").comboBox().requireEnabled()
////				.requireEditable().requireVisible().selectItem(1);
////
////		searchButton = window.button(getButtonMatcher("Search"));
////		assertNotNull(searchButton);
////		searchButton.requireVisible().requireEnabled().click();
////		checkLabelCount(4);
////		checkTxtLabels("---ranking position 1 ---", "Location: "
////				+ VALID_INDEX_PATH + "/file3.txt", "350323 Byte");
////		// checkTxtLabels(
////		// "---ranking position 1 ---",
////		// "Location: " + VALID_INDEX_PATH + "/file3.txt",
////		// "350323 Byte", "Tue Feb 18 00:13:22 BRT 2014");
////
////	}
////
////	private void checkLabelCount(int expected) {
////		// verify results in labels
////		int count = 0;
////
////		int i = 1;
////		try {
////			while (true) {
////				window.label(getLabelMatcher("ranking position " + i))
////						.requireVisible();
////				i++;
////				count++;
////			}
////		} catch (ComponentLookupException _) {
////		}
////		;
////
////		Assert.assertEquals(expected, count);
////	}
//
//	public void checkTxtLabels(String... labels) {
//		// verify results in labels
//		for (String label : labels) {
//			window.label(getLabelMatcher(label)).requireVisible();
//		}
//	}
//
//	public void searchTxts() {
//		checkNumberIndexedFiles(5);
//		String searchTerm = "org";
//		doSearch(searchTerm);
//	}
//
//	public void indexTestDir() {
//		// Click "Change" button
//		JButtonFixture button = window.button(getButtonMatcher("Change"));
//		assertNotNull(button);
//		button.requireVisible();
//		button.requireEnabled();
//		button.click();
//
//		GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
//				Dialog.class) {
//			@Override
//			protected boolean isMatching(Dialog dialog) {
//				return dialog.getTitle().equals("Open") && dialog.isVisible();
//			}
//		};
//		DialogFixture dialog = window.dialog(diaglogMatcher);
//		assertNotNull(dialog);
//
//		// choosing the directory for indexing
//		JFileChooserFixture fileChooser = dialog.fileChooser();
//		fileChooser.setCurrentDirectory(new File(homeDir));
//		fileChooser.setCurrentDirectory(new File(homeDir));// dealing with more
//		// than a call to
//		// the fileChooser
//		fileChooser.selectFile(new File(VALID_INDEX_PATH));
//		fileChooser.approveButton().requireEnabled();
//		fileChooser.approve();
//
//		// validating the dialog boxes
//		JOptionPaneFixture indexing_dialog = window.optionPane();
//		assertThat(indexing_dialog).isNotNull();
//		indexing_dialog.requireTitle("Indexing");
//		indexing_dialog.requireInformationMessage().requireMessage(
//				"The directory " + VALID_INDEX_PATH + " is being indexed.");
//
//		JButtonFixture okbutton = indexing_dialog
//				.button(getButtonMatcher("OK"));
//		assertNotNull(okbutton);
//		okbutton.requireVisible();
//		okbutton.requireEnabled();
//		okbutton.click();
//	}
//
//	public void indexTestMultipleDir() {
//		// addPath();
//		// JButtonFixture removeButton =
//		// window.button(getButtonMatcher("Remove"));
//		// assertNotNull(removeButton);
//		// removeButton.requireVisible().requireEnabled().click();
//		addPath();
//
//		JButtonFixture indexButton = window.button(getButtonMatcher("Index"));
//		assertNotNull(indexButton);
//		indexButton.requireVisible();
//		indexButton.requireEnabled();
//		indexButton.click();
//
//		// validating the dialog boxes
//		JOptionPaneFixture indexing_dialog = window.optionPane();
//		assertThat(indexing_dialog).isNotNull();
//		indexing_dialog.requireTitle("Indexing");
//		indexing_dialog.requireInformationMessage().requireMessage(
//				"The directory " + VALID_INDEX_PATH + " is being indexed.");
//
//		JButtonFixture okbutton = indexing_dialog
//				.button(getButtonMatcher("OK"));
//		assertNotNull(okbutton);
//		okbutton.requireVisible();
//		okbutton.requireEnabled();
//		okbutton.click();
//	}
//
//	public void addPath() {
//		// Click "Change" button
//		JButtonFixture button = window.button(getButtonMatcher("Add"));
//		assertNotNull(button);
//		button.requireVisible();
//		button.requireEnabled();
//		button.click();
//
//		chooseIndexDir();
//
//		// GenericTypeMatcher<Dialog> diaglogMatcher = new
//		// GenericTypeMatcher<Dialog>(
//		// Dialog.class) {
//		// @Override
//		// protected boolean isMatching(Dialog dialog) {
//		// return dialog.getTitle().equals("Open") && dialog.isVisible();
//		// }
//		// };
//		// DialogFixture dialog = window.dialog(diaglogMatcher);
//		// assertNotNull(dialog);
//		//
//		// // choosing the directory for indexing
//		// JFileChooserFixture fileChooser = dialog.fileChooser();
//		// fileChooser.setCurrentDirectory(new File(homeDir));
//		// fileChooser.setCurrentDirectory(new File(homeDir));// dealing with
//		// more
//		// // than a call to
//		// // the fileChooser
//		// fileChooser.selectFile(new File(VALID_INDEX_PATH));
//		// fileChooser.approveButton().requireEnabled();
//		// fileChooser.approve();
//
//	}
//
//	private void chooseIndexDir() {
//		GenericTypeMatcher<Dialog> diaglogMatcher = new GenericTypeMatcher<Dialog>(
//				Dialog.class) {
//			@Override
//			protected boolean isMatching(Dialog dialog) {
//				return dialog.getTitle().equals("Open") && dialog.isVisible();
//			}
//		};
//		DialogFixture dialog = window.dialog(diaglogMatcher);
//		assertNotNull(dialog);
//
//		// choosing the directory for indexing
//		JFileChooserFixture fileChooser = dialog.fileChooser();
//		fileChooser.setCurrentDirectory(new File(homeDir));
//		fileChooser.setCurrentDirectory(new File(homeDir));// dealing with more
//															// than a call to
//															// the fileChooser
//		fileChooser.selectFile(new File(VALID_INDEX_PATH));
//		fileChooser.approveButton().requireEnabled();
//		fileChooser.approve();
//	}
//
//	public void searchHtmls() {
//		String searchTerm = "feature";
//		checkNumberIndexedFiles(3);
//		doSearch(searchTerm);
//	}
//
//	public void searchLatex() {
//		checkNumberIndexedFiles(2);
//		String searchTerm = "SPL";
//		doSearch(searchTerm);
//	}
//
//	public void doSearch(String searchTerm) {
//		// enter search query
//		window.panel("xAxis1_createGroupBoxSearch").comboBox().requireEnabled()
//				.requireEditable().requireVisible().selectAllText()
//				.clearSelection().enterText(searchTerm);
//
//		JButtonFixture searchButton = window.button(getButtonMatcher("Search"));
//		assertNotNull(searchButton);
//		searchButton.requireVisible();
//		searchButton.requireEnabled();
//		searchButton.click();
//	}
//
//	public void checkNumberIndexedFiles(int n) {
//		JOptionPaneFixture done_indexing_dialog = window.optionPane();
//		assertThat(done_indexing_dialog).isNotNull();
//		done_indexing_dialog.requireTitle("Done indexing.");
//		done_indexing_dialog.requireInformationMessage().requireMessage(
//				n + " documents have been indexed.");
//		// OK button
//		JButtonFixture okdonebutton = done_indexing_dialog
//				.button(getButtonMatcher("OK"));
//		okdonebutton.requireVisible();
//		okdonebutton.requireEnabled();
//		okdonebutton.click();
//	}
//
//	@After
//	public void teardown() {
//			window.cleanUp();
////		DesktopSearcherVariables.getSINGLETON().restore();
//		deleteDirectory(new File(homeDir + "/index"));
//	}
//
//	private GenericTypeMatcher<JButton> getButtonMatcher(
//			final String buttonNameExpected) {
//		GenericTypeMatcher<JButton> buttonMatcher = new GenericTypeMatcher<JButton>(
//				JButton.class) {
//			@Override
//			protected boolean isMatching(JButton button) {
//				String expected = buttonNameExpected;
//				String actual = button.getText();
//				return actual == null ? false : expected.equals(actual)
//						&& button.isShowing();
//			}
//		};
//		return buttonMatcher;
//	}
//
//	private GenericTypeMatcher<HitComponentLabel> getLabelMatcher(
//			final String... snippets) {
//		GenericTypeMatcher<HitComponentLabel> matcher = new GenericTypeMatcher<HitComponentLabel>(
//				HitComponentLabel.class) {
//			@Override
//			protected boolean isMatching(HitComponentLabel arg0) {
//				boolean result = true;
//				for (String s : snippets) {
//					result = arg0.getText().contains(s);
//					if (!result) {
//						break;
//					}
//				}
//				return result;
//			}
//		};
//		return matcher;
//	}
//
//	private GenericTypeMatcher<JRadioButton> getRadioButtonMatcher(
//			final String buttonTextExpected) {
//		GenericTypeMatcher<JRadioButton> buttonMatcher = new GenericTypeMatcher<JRadioButton>(
//				JRadioButton.class) {
//			@Override
//			protected boolean isMatching(JRadioButton button) {
//				String expected = buttonTextExpected;
//				String actual = button.getText();
//				return actual == null ? false : expected.equals(actual);
//			}
//		};
//		return buttonMatcher;
//	}
//
//	private GenericTypeMatcher<JDialog> getDialogMatcher(
//			final String titleExpected) {
//		GenericTypeMatcher<JDialog> buttonMatcher = new GenericTypeMatcher<JDialog>(
//				JDialog.class) {
//			@Override
//			protected boolean isMatching(JDialog dialog) {
//				String expected = titleExpected;
//				String actual = dialog.getTitle();
//				return actual == null ? false : expected.equals(actual)
//						&& dialog.isVisible();
//			}
//		};
//		return buttonMatcher;
//	}
//}