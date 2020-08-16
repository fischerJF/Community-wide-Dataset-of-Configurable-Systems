package tests;

import static org.fest.assertions.Assertions.assertThat;

import java.awt.Dialog;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

import junit.framework.Assert;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JFileChooserFixture;
import org.fest.swing.fixture.JOptionPaneFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import splat.DesktopSearcherVariables;
import desktopsearcher.MainFrame;
import desktopsearcher.MrPinkMain;

public class TestGUIExample {

	@Rule
	public TestName testName = new TestName();

	// BASE, HTML, TXT, LATEX, USER_INTERFACE, COMMAND_LINE, GUI,
	// GUI_PREFERENCES, QUERY_HISTORY, INDEX_HISTORY, SINGLE_DIRECTORY,
	// MULTI_DIRECTORY, NORMAL_VIEW, TREE_VIEW, WINDOWS, LINUX
	protected void configure() {
		if (testName == null) {
			throw new RuntimeException();
		}
		String mName = testName.getMethodName();
		/**
		 * set specific features for each test
		 */
		if (mName.equals("testNoFileIndexed")) {
			DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
			DesktopSearcherVariables.getSINGLETON().setGUI(true);
			DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
		} else if (mName.equals("another tests..")) {// replace by the test
														// names

		} // more tests...

	}

	static FrameFixture window;
	MainFrame mainFrame;

	static String homeDir;
	static {
		try {
			homeDir = (new File(".")).getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	static final String VALID_INDEX_PATH = homeDir + "/files";

	@Before
	public void setup() {
		FailOnThreadViolationRepaintManager.install();
		GuiQuery<MainFrame> action = new GuiQuery<MainFrame>() {
			protected MainFrame executeInEDT() {
				configure();
				// mainFrame = new MainFrame(new MrPinkMain());
				mainFrame = (MainFrame) new MrPinkMain().userInterface;
				return mainFrame;
			}
		};
		mainFrame = GuiActionRunner.execute(action);
		window = new FrameFixture(mainFrame);
		window.show(new Dimension(600, 400));
	}

	@Test
	public void testNoFileIndexed() {
		// Click "Change" button
		JButtonFixture button = window.button(getButtonMatcher("Change"));
		Assert.assertNotNull(button);
		button.requireVisible();
		button.requireEnabled();
		button.click();

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
		done_indexing_dialog.requireInformationMessage().requireMessage(
				"0 documents have been indexed.");

		// OK button
		JButtonFixture okdonebutton = done_indexing_dialog
				.button(getButtonMatcher("OK"));
		Assert.assertNotNull(okbutton);
		okdonebutton.requireVisible();
		okdonebutton.requireEnabled();
		okdonebutton.click();

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

	@After
	public void teardown() {
		window.cleanUp();
		DesktopSearcherVariables.getSINGLETON().restore();
	}

}
