package testset;

import static org.junit.Assert.assertEquals;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.junit.Assume;
import org.junit.Test;

import specifications.Configuration;

public class TestWordCount extends NotepadTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		if (testName == null) {
			throw new RuntimeException();
		}
		String strTestName = testName.getMethodName();
		// if (strTestName.equals("testWordCountMenuBar")) {
		// NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
		// NotepadVariables.getSINGLETON().setWORDCOUNTMENUBAR___(true);
		// } else if (strTestName.equals("testWordCountToolBar")) {
		// NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
		// NotepadVariables.getSINGLETON().setWORDCOUNTTOOLBAR___(true);
		// } else {
		// System.err.printf("%s did not set default configuration", strTestName);
		// }

	}

	@Test
	public void testWordCountMenuBar() {
		// Assume.assumeTrue(NotepadVariables.getSINGLETON().isWORDCOUNTMENUBAR___());
//		Configuration.BASEMENUBAR = true;
//		Configuration.WORDCOUNTMENUBAR = true;

		if (Configuration.BASEMENUBAR && Configuration.WORDCOUNTMENUBAR) {
			// (1) type some text
			GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(JTextArea.class) {
				@Override
				protected boolean isMatching(JTextArea testArea) {
					return true;
				}
			};
			JTextComponentFixture textArea = window.textBox(textAreaMatcher);
			textArea.setText("word1 word2 word3 word4");

			// (2) count words using menu bar (Word Count -> 123 Word Count)
			GenericTypeMatcher<JMenuItem> menuMatcher = new GenericTypeMatcher<JMenuItem>(JMenuItem.class) {
				@Override
				protected boolean isMatching(JMenuItem menu) {
					String expected = "Word Count";
					String actual = menu.getText();
					return (actual == null ? false : expected.equals(actual) && menu.isShowing());
				}
			};

			JMenuItemFixture itemFormat = window.menuItem(menuMatcher);
			itemFormat.click();

			String[] num_words = window.textBox().text().split(" ");
			assertEquals(4, num_words.length);
		}
	}

	@Test
	public void testWordCountToolBar() {
		// (1) type some text
//		Configuration.BASETOOLBAR = true;
//		Configuration.WORDCOUNTTOOLBAR = true;

		if (Configuration.BASETOOLBAR && Configuration.WORDCOUNTTOOLBAR) {
			GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(JTextArea.class) {
				@Override
				protected boolean isMatching(JTextArea testArea) {
					return true;
				}
			};
			JTextComponentFixture textArea = window.textBox(textAreaMatcher);
			textArea.setText("word1 word2 word3 word4");

			// (2) count words using tool bar (Word Count button)
			GenericTypeMatcher<JButton> buttonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
				@Override
				protected boolean isMatching(JButton button) {
					String expected = "Word count";
					String actual = button.getToolTipText();
					return actual == null ? false : expected.equals(actual);
				}
			};

			JButtonFixture itemFormat = window.button(buttonMatcher);
			itemFormat.click();

			String[] num_words = window.textBox().text().split(" ");
			assertEquals(4, num_words.length);
		}
	}

}
