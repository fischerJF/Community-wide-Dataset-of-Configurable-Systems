package testset;

import static org.fest.assertions.Assertions.assertThat;

import java.awt.Color;

import javax.swing.JTextArea;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.ColorFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.junit.Test;

import specifications.Configuration;

public class TestTextArea extends NotepadTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		if (testName == null) {
			throw new RuntimeException();
		}
//		String mName = testName.getMethodName();
		/**
		 * set optional features specific for each test
		 */
//		if (mName.equals("testBasic")) {
//			// NotepadVariables.getSINGLETON().setBASE___(true);
//		}
	}

	@Test
	public void testBasic() {
//		Configuration.BASE = true;
		if (Configuration.BASE) {
			GenericTypeMatcher<JTextArea> textAreaMatcher = new GenericTypeMatcher<JTextArea>(JTextArea.class) {
				@Override
				protected boolean isMatching(JTextArea button) {
					return true;
				}
			};
			JTextComponentFixture textArea = window.textBox(textAreaMatcher);
			textArea.requireEditable();
			ColorFixture color = textArea.background();
			
			//assertThat(color).isNotNull();
			color.requireEqualTo(Color.WHITE);
			String text = "Hello";
			textArea.enterText(text);
			//assertThat(textArea.text()).contains(text);
		//	assertThat(textArea).isNotNull();
			textArea.deleteText();
			assertThat(textArea.text()).contains("");
		}
	}

}
