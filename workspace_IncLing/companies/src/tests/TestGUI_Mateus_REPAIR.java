package tests;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.softlang.company.factory.BeanFactory;
import org.softlang.swing.controller.Controller;
import org.softlang.swing.model.Model;
import org.softlang.swing.view.MainView;

import specifications.Configuration;


public class TestGUI_Mateus_REPAIR extends CompaniesTest{

//  public TestName testName = new TestName();

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
    //super.configure();
//    if (testName == null) {
//      throw new RuntimeException();
//    }else System.out.println(testName.getMethodName());
//    String mName = testName.getMethodName();
    /**
     * set specific features for each test
     */
  //  if (mName.equals("testLogging")) {
//      System.out.println("ola");
//      Configuration.GUI=true;
//      Configuration.LOGGING=true;
//      Configuration.CUT_WHATEVER=true;
//      Configuration.TOTAL_WALKER=true;
  // }
    //else if (mName.equals("testCutNoDep")) {
      Configuration.GUI=true;
//      Configuration.TOTAL_WALKER=true;
//      Configuration.CUT_NO_DEPARTMENT=true;
//    }
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
  public void testLogging() {
    
    
    if(Configuration.GUI &&
    Configuration.LOGGING &&
    Configuration.CUT_WHATEVER &&
    Configuration.TOTAL_WALKER) {
    // intercept logging
    Interceptor ic = new Interceptor(System.out);
    ic.attachOut();

    try {
      // clicking on the tree
      JTreeFixture tree = window.tree();
      assertTrue(tree!=null);
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
//      ic.checkOutput(logs);
      
      //REPAIR
      if ( !Configuration.PRECEDENCE) 
        ic.checkOutput(logs);
      
    } finally {
      ic.detachOut();
      ic.close();
    }
    }
  }

 /* @Test*/
  public void testCutNoDep() {
    /* initialization of the test */
//    Configuration.GUI=true;
//    Configuration.TOTAL_WALKER=true;
//    Configuration.CUT_NO_DEPARTMENT=true;
    
if(Configuration.GUI && Configuration.TOTAL_WALKER && Configuration.CUT_NO_DEPARTMENT) {    
    // clicking on the tree
    JTreeFixture tree = window.tree();
    assertTrue(tree!=null);
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
    
//    assertThat(totalValue.text()).isEqualTo("199873.5");
    
    //REPAIR
    if (!Configuration.PRECEDENCE) {
    	assertEquals(totalValue.text().toString(),"199873.5");
//
//      // DEP cut
//
//      // clicking on the tree
      tree = window.tree();
      assertTrue(tree!=null);
      tree = tree.selectPath("meganalysis/Development");
      tree.click();
//
//      // getting the value of "total" in the text component
      totalValue = window.textBox(getJTextAreaMatcher("131356.0"));
//
//      // clicking on the button "cut", this *doesn't* changes the value of
//      // "total"
      noButton = window.button(getJButtonMatcher("cut"));
      noButton.requireEnabled();
      noButton.requireVisible();
      noButton.click();

//      // asserting that the value of "total" was changed
//      // after clicking on the button "cut"
      assertEquals(totalValue.text().toString(),"131356.0");
    }
    }

  }

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

  @After
  public void teardown() {
    window.cleanUp();
//    String config = CompaniesVariables.getSINGLETON().toString();
//    System.out.println(config);
//    CompaniesVariables.getSINGLETON().restore();
  }

}
