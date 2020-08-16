package tests;

import static org.fest.assertions.Assertions.assertThat;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.text.JTextComponent;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JButtonFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.fest.swing.fixture.JTreeFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.softlang.company.factory.BeanFactory;
import org.softlang.swing.controller.Controller;
import org.softlang.swing.model.Model;
import org.softlang.swing.view.MainView;

import splat.CompaniesVariables;

public class TestGUIExample extends CompaniesTest{

  @Rule
  public TestName testName = new TestName();

  // TREE_STRUCTURE___, LOGGING___,
  // CUT_WHATEVER___, CUT_NO_DEPARTMENT___, CUT_NO_MANAGER___,
  // GUI___, PRECEDENCE___,
  // TOTAL_WALKER___, TOTAL_REDUCER___, ACCESS_CONTROL___
  protected void configure() {
    if (testName == null) {
      throw new RuntimeException();
    }
    String mName = testName.getMethodName();
    /**
     * set specific features for each test
     */
    if (mName.equals("testTotalValueDepartment")) {
      CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
      CompaniesVariables.getSINGLETON().setGUI___(true);
      CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
    } else if (mName.equals("another tests..")) {//replace by the test names
      
    } // more tests...
  }

  FrameFixture window;
  Model model;
  MainView viewMainFrame;
  Controller controller;

  @Before
  public void setup() {
    FailOnThreadViolationRepaintManager.install();
    GuiQuery<MainView> action = new GuiQuery<MainView>() {
      protected MainView executeInEDT() {
        configure();// sets the required features for each test
        model = new Model(new BeanFactory());
        viewMainFrame = new MainView(model);
        controller = new Controller(model, viewMainFrame);
        controller.start();
        return viewMainFrame;
      }
    };
    MainView frame = GuiActionRunner.execute(action);
    window = new FrameFixture(frame);
    window.show(new Dimension(500, 500));

  }

  @Test
  public void testTotalValueDepartment() {
    // clicking on the tree
    JTreeFixture tree = window.tree();
    assertThat(tree).isNotNull(); // sanity test
    tree.separator("#");
    tree = tree.selectPath("meganalysis#Development");
    tree.click();

    // getting the value of "total" in the text component
    GenericTypeMatcher<JTextComponent> textAreaMatcher = new GenericTypeMatcher<JTextComponent>(
        JTextComponent.class) {
      @Override
      protected boolean isMatching(JTextComponent tcomp) {
        String expected = "262712.0";
        String actual = tcomp.getText();
        return actual == null ? false : expected.equals(actual);
      }
    };
    JTextComponentFixture totalValue = window.textBox(textAreaMatcher);

    // clicking on the button "cut", this changes the value of "total"
    GenericTypeMatcher<JButton> noButtonMatcher = new GenericTypeMatcher<JButton>(
        JButton.class) {
      @Override
      protected boolean isMatching(JButton button) {
        String expected = "cut";
        String actual = button.getText();
        return actual == null ? false : expected.equals(actual);
      }
    };
    JButtonFixture noButton = window.button(noButtonMatcher);
    noButton.requireEnabled();
    noButton.requireVisible();
    noButton.click();

    // asserting that the value of "total" was changed
    // after clicking on the button "cut"
    assertThat(totalValue.text()).isNotEqualTo("262712.0");

  }

  // Suggestions for testing:
  // check the employee view and the department view
  // change the names, salaries and total values and check... and so on.

  @After
  public void teardown() {
    window.cleanUp();
    CompaniesVariables.getSINGLETON().restore();
  }

}
