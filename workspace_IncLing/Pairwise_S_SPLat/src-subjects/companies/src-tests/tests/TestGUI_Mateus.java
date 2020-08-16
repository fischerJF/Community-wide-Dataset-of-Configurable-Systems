package tests;

import static org.fest.assertions.Assertions.assertThat;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;

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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.softlang.company.factory.BeanFactory;
import org.softlang.swing.controller.Controller;
import org.softlang.swing.model.Model;
import org.softlang.swing.view.MainView;

import splat.CompaniesVariables;

public class TestGUI_Mateus extends CompaniesTest{

  @Rule
  public TestName testName = new TestName();

  // TREE_STRUCTURE___, LOGGING___,
  // CUT_WHATEVER___, CUT_NO_DEPARTMENT___, CUT_NO_MANAGER___,
  // GUI___, PRECEDENCE___,
  // TOTAL_WALKER___, TOTAL_REDUCER___, ACCESS_CONTROL___

  // worry about:
  // LOGGING___,
  // CUT_NO_DEPARTMENT___, CUT_NO_MANAGER___,
  // GUI___, PRECEDENCE___,
  // TOTAL_WALKER___, TOTAL_REDUCER___,

  protected void configure() {
    super.configure();
    if (testName == null) {
      throw new RuntimeException();
    }
    String mName = testName.getMethodName();
    /**
     * set specific features for each test
     */
    if (mName.equals("testTotalValueDepartment")) {
//      CompaniesVariables.getSINGLETON().setGUI___(true);
//      CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
//      CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
    } else if (mName.equals("testGuiOps")) {
//      CompaniesVariables.getSINGLETON().setGUI___(true);
//      CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
//      CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
    } else if (mName.equals("testLogging")) {
//      CompaniesVariables.getSINGLETON().setGUI___(true);
//      CompaniesVariables.getSINGLETON().setLOGGING___(true);
//      CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
//      CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
    } else if (mName.equals("testCutNoDep")) {
//      CompaniesVariables.getSINGLETON().setGUI___(true);
//      CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
//      CompaniesVariables.getSINGLETON().setCUT_NO_DEPARTMENT___(true);
    } else if (mName.equals("testCutNoManager")) {
//      CompaniesVariables.getSINGLETON().setGUI___(true);
//      CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
//      CompaniesVariables.getSINGLETON().setCUT_NO_MANAGER___(true);
    } else if (mName.equals("testPrecedence")) {
//      CompaniesVariables.getSINGLETON().setGUI___(true);
//      CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
//      CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(true);
//      CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);
    } else if (mName.equals("testTotalReducer")) {
//      CompaniesVariables.getSINGLETON().setGUI___(true);
//      CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
//      CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(true);
    }
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
    tree = tree.selectPath("meganalysis/Development");
    tree.click();

    // getting the value of "total" in the text component
    JTextComponentFixture totalValue = window
        .textBox(getJTextAreaMatcher("262712.0"));

    // clicking on the button "cut", this changes the value of "total"
    JButtonFixture noButton = window.button(getJButtonMatcher("cut"));
    noButton.requireEnabled();
    noButton.requireVisible();
    noButton.click();

    // asserting that the value of "total" was changed
    // after clicking on the button "cut"
    assertThat(totalValue.text()).isNotEqualTo("262712.0");
  }

  @Test
  public void testGuiOps() {
    // clicking on the tree
    JTreeFixture tree = window.tree();
    assertThat(tree).isNotNull(); // sanity test
    tree = tree.selectPath("meganalysis/Development/Ray (Manager)");
    tree.click();

    // getting the value of "total" in the text component
    JTextComponentFixture totalValue = window
        .textBox(getJTextAreaMatcher("234567.0"));

    // change name of manager
    window.textBox(getJTextAreaMatcher("Ray")).requireEditable()
        .requireEnabled().selectAll().deleteText().enterText("Fubar").click();
    // change address
    window.textBox(getJTextAreaMatcher("Redmond")).requireEditable()
        .requireEnabled().selectAll().deleteText().enterText("Moon");

    window.focus().click();

    // tree reflects the changes...
    window.tree().selectPath("meganalysis").click();
    tree = window.tree().selectPath("meganalysis/Development/Fubar (Manager)");
    tree.click();

    // asserting that the value of "total" did not change
    assertThat(totalValue.text()).isEqualTo("234567.0");
    Assert.assertNotNull(window.textBox(getJTextAreaMatcher("Moon")));
  }

  @Test
  public void testLogging() {
    // intercept logging
    Interceptor ic = new Interceptor(System.out);
    ic.attachOut();

    try {
      // clicking on the tree
      JTreeFixture tree = window.tree();
      assertThat(tree).isNotNull(); // sanity test
      tree = tree.selectPath("meganalysis/Development");
      tree.click();

      // clicking on the button "cut", this changes the value of "total"
      JButtonFixture noButton = window.button(getJButtonMatcher("cut"));
      noButton.requireEnabled();
      noButton.requireVisible();
      noButton.click();

      List<String> logs = Arrays
          .asList("Salary of Ray adjusted to 117283.5",
              "Salary of Klaus adjusted to 11728.0",
              "Salary of Karl adjusted to 1172.5",
              "Salary of Joe adjusted to 1172");
      ic.checkOutput(logs);
    } finally {
      ic.detachOut();
      ic.close();
    }
  }

  @Test
  public void testCutNoDep() {
    // clicking on the tree
    JTreeFixture tree = window.tree();
    assertThat(tree).isNotNull(); // sanity test
    tree = tree.selectPath("meganalysis");
    tree.click();

    // getting the value of "total" in the text component
    JTextComponentFixture totalValue = window
        .textBox(getJTextAreaMatcher("399747.0"));

    // clicking on the button "cut", this changes the value of "total"
    JButtonFixture noButton = window.button(getJButtonMatcher("cut"));
    noButton.requireEnabled();
    noButton.requireVisible();
    noButton.click();

    // asserting that the value of "total" was changed
    // after clicking on the button "cut"
    assertThat(totalValue.text()).isEqualTo("199873.5");
    
    // DEP cut
    
    //clicking on the tree
    tree = window.tree();
    assertThat(tree).isNotNull(); // sanity test
    tree = tree.selectPath("meganalysis/Development");
    tree.click();

    // getting the value of "total" in the text component
    totalValue = window.textBox(getJTextAreaMatcher("131356.0"));

    // clicking on the button "cut", this *doesn't* changes the value of "total"
    noButton = window.button(getJButtonMatcher("cut"));
    noButton.requireEnabled();
    noButton.requireVisible();
    noButton.click();

    // asserting that the value of "total" was changed
    // after clicking on the button "cut"
    assertThat(totalValue.text()).isEqualTo("131356.0");

  }


  @Test
  public void testCutNoManager() {
   // clicking on the tree
    JTreeFixture tree = window.tree();
    assertThat(tree).isNotNull(); // sanity test
    tree = tree.selectPath("meganalysis");
    tree.click();

    // getting the value of "total" in the text component
    JTextComponentFixture totalValue = window
        .textBox(getJTextAreaMatcher("399747.0"));

    // clicking on the button "cut", this changes the value of "total"
    JButtonFixture noButton = window.button(getJButtonMatcher("cut"));
    noButton.requireEnabled();
    noButton.requireVisible();
    noButton.click();

    // asserting that the value of "total" was changed
    // after clicking on the button "cut"
    assertThat(totalValue.text()).isEqualTo("199873.5");
    
    // DEP cut
    
    //clicking on the tree
    tree = window.tree();
    assertThat(tree).isNotNull(); // sanity test
    tree = tree.selectPath("meganalysis/Development/Ray (Manager)");
    tree.click();

    // getting the value of "total" in the text component
    totalValue = window.textBox(getJTextAreaMatcher("117283.5"));

    // clicking on the button "cut", this *doesn't* changes the value of "total"
    noButton = window.button(getJButtonMatcher("cut"));
    noButton.requireEnabled();
    noButton.requireVisible();
    noButton.click();

    // asserting that the value of "total" was changed
    // after clicking on the button "cut"
    assertThat(totalValue.text()).isEqualTo("117283.5");
  }

  // Precedence constraint violated for employee "Ray".

  @Test
  public void testPrecedence() {
    // clicking on the tree
    JTreeFixture tree = window.tree();
    assertThat(tree).isNotNull(); // sanity test
    tree = tree.selectPath("meganalysis/Development/Ray (Manager)");
    tree.click();

    // getting the value of "total" in the text component
    JTextComponentFixture totalValue = window
        .textBox(getJTextAreaMatcher("234567.0"));
    
    // change name of manager
    window.textBox(getJTextAreaMatcher("234567.0")).requireEditable()
        .requireEnabled().selectAll().deleteText().enterText("1").click();
   
    window.focus().click();

    // tree reflects the changes...
    window.tree().selectPath("meganalysis").click();
    tree = tree.selectPath("meganalysis/Development/Ray (Manager)");
    tree.click();

    // asserting that the value of "total" did not change
    assertThat(totalValue.text()).isEqualTo("234567.0");
  }

//  @Test //Same as the first test, but with a different aggregator/reducer
//  public void testTotalReducer() {
//    // clicking on the tree
//    JTreeFixture tree = window.tree();
//    assertThat(tree).isNotNull(); // sanity test
//    tree = tree.selectPath("meganalysis/Development");
//    tree.click();
//
//    // getting the value of "total" in the text component
//    GenericTypeMatcher<JTextComponent> textAreaMatcher = new GenericTypeMatcher<JTextComponent>(
//        JTextComponent.class) {
//      @Override
//      protected boolean isMatching(JTextComponent tcomp) {
//        String expected = "262712.0";
//        String actual = tcomp.getText();
//        return actual == null ? false : expected.equals(actual);
//      }
//    };
//    JTextComponentFixture totalValue = window.textBox(textAreaMatcher);
//
//    // clicking on the button "cut", this changes the value of "total"
//    GenericTypeMatcher<JButton> noButtonMatcher = new GenericTypeMatcher<JButton>(
//        JButton.class) {
//      @Override
//      protected boolean isMatching(JButton button) {
//        String expected = "cut";
//        String actual = button.getText();
//        return actual == null ? false : expected.equals(actual);
//      }
//    };
//    JButtonFixture noButton = window.button(noButtonMatcher);
//    noButton.requireEnabled();
//    noButton.requireVisible();
//    noButton.click();
//
//    // asserting that the value of "total" was changed
//    // after clicking on the button "cut"
//    assertThat(totalValue.text()).isNotEqualTo("262712.0");
//  }

  private GenericTypeMatcher<JTextComponent> getJTextAreaMatcher(
      final String text) {
    return new GenericTypeMatcher<JTextComponent>(JTextComponent.class) {
      @Override
      protected boolean isMatching(JTextComponent tcomp) {
        String expected = text;
        String actual = tcomp.getText();
        return actual == null ? false : expected.equals(actual);
      }
    };
  }

  private GenericTypeMatcher<JButton> getJButtonMatcher(final String expected) {
    return new GenericTypeMatcher<JButton>(JButton.class) {
      @Override
      protected boolean isMatching(JButton button) {
        String actual = button.getText();
        return actual == null ? false : expected.equals(actual);
      }
    };
  }

  // Suggestions for testing:
  // check the employee view and the department view
  // change the names, salaries and total values and check... and so on.

  @After
  public void teardown() {
    window.cleanUp();
//    CompaniesVariables.getSINGLETON().restore();
  }

}
