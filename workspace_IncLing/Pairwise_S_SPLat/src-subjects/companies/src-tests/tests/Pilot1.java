package tests;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
import org.junit.Test;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.company.impl.bean.EmployeeImpl;
import org.softlang.features.Logging;
import org.softlang.features.Precedence;
import org.softlang.swing.controller.Controller;
import org.softlang.swing.model.Model;
import org.softlang.swing.view.MainView;

import splat.CompaniesVariables;

public class Pilot1 extends CompaniesTest {

  @Override
  protected void configure() {
    // set mandatory features
    super.configure();
    CompaniesVariables.getSINGLETON().setGUI___(true);
    if (testName == null) {
      throw new RuntimeException();
    }
    System.out.println("METHOD NAME:" + testName.getMethodName());
    if (testName.getMethodName().equals("test1")) {
      CompaniesVariables.getSINGLETON().setCUT_NO_DEPARTMENT___(true);
    } else if (testName.getMethodName().equals("test2")
        || testName.getMethodName().equals("test2A")) {
      CompaniesVariables.getSINGLETON().setCUT_NO_MANAGER___(true);
    } else if (testName.getMethodName().equals("test2B")) {
      CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
      CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
    } else if (testName.getMethodName().equals("test3")) {
      CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
    } else if (testName.getMethodName().equals("test4")) {
      CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(true);
    } else if (testName.getMethodName().equals("test5")
        || testName.getMethodName().startsWith("test6")
        || testName.getMethodName().equals("test7")) {
      CompaniesVariables.getSINGLETON().setGUI___(false);
      CompaniesVariables.getSINGLETON().setLOGGING___(true);

      if (testName.getMethodName().equals("test7")
          || testName.getMethodName().equals("test6PreTrue"))
        CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);

    } else {
      System.err.printf("%s did not set default configuration",
          testName.getMethodName());
    }
  }

  FrameFixture window1, window2;
  Model model1, model2;
  MainView view1, view2;
  Controller controller1, controller2;

  static Model model;
  static MainView view;
  static Controller controller;

  @Override
  @Before
  public void setup() {
    configure();

    FailOnThreadViolationRepaintManager.install();
    GuiQuery<MainView> action1 = new GuiQuery<MainView>() {
      protected MainView executeInEDT() {

        model1 = new Model(new BeanFactory());
        if (testName.getMethodName().startsWith("test2"))
          model1 = new Model(new PojoFactory());

        view1 = new MainView(model1);
        controller1 = new Controller(model1, view1);
        controller1.start();
        return view1;

      }

    };
    if (!(testName.getMethodName().equals("test5"))
        && !(testName.getMethodName().startsWith("test6"))
        && !(testName.getMethodName().equals("test7"))) {
      MainView frame1 = GuiActionRunner.execute(action1);
      window1 = new FrameFixture(frame1);
      window1.show(new Dimension(500, 500));
    }

  }

  // @Test
  // public void test1() {
  //
  // // clicking on the tree
  // JTreeFixture tree = window1.tree();
  // assertThat(tree).isNotNull(); // sanity test
  // tree = tree.selectPath("meganalysis/Development/Ray (Manager)");
  // tree.click();
  //
  // // getting the value of "name" in the text component
  // GenericTypeMatcher<JTextComponent> textAreaMatcherName = new
  // GenericTypeMatcher<JTextComponent>(
  // JTextComponent.class) {
  // @Override
  // protected boolean isMatching(JTextComponent tcomp) {
  // String expected = "Ray";
  // String actual = tcomp.getText();
  // return actual == null ? false : expected.equals(actual);
  // }
  // };
  // JTextComponentFixture Name = window1.textBox(textAreaMatcherName);
  // Name.enterText("1");
  // // clicking on the button "cut", this changes the value of "total"
  // GenericTypeMatcher<JButton> noButtonMatcher = new
  // GenericTypeMatcher<JButton>(
  // JButton.class) {
  // @Override
  // protected boolean isMatching(JButton button) {
  // String expected = "cut";
  // String actual = button.getText();
  // return actual == null ? false : expected.equals(actual);
  // }
  // };
  // JButtonFixture noButton = window1.button(noButtonMatcher);
  // noButton.requireEnabled();
  // noButton.requireVisible();
  // noButton.click();
  //
  // // asserting that the value of "total" was changed
  // // after clicking on the button "cut"
  // assertTrue(model1.str.equals("LINE NUM:92 at method name:Model.cut"));
  //
  // // DG- CHECK
  // // In the exec, cut company,employee,department
  //
  // }
  //
  // @Test
  // public void test2() {
  //
  // // clicking on the tree
  // JTreeFixture tree = window1.tree();
  // assertThat(tree).isNotNull(); // sanity test
  // tree = tree.selectPath("meganalysis/Development/");
  // tree.click();
  //
  // // getting the value of "name" in the text component
  // GenericTypeMatcher<JTextComponent> textAreaMatcherName = new
  // GenericTypeMatcher<JTextComponent>(
  // JTextComponent.class) {
  // @Override
  // protected boolean isMatching(JTextComponent tcomp) {
  // String expected = "Development";
  // String actual = tcomp.getText();
  // return actual == null ? false : expected.equals(actual);
  // }
  // };
  // JTextComponentFixture Name = window1.textBox(textAreaMatcherName);
  // Name.enterText("1");
  // // clicking on the button "cut", this changes the value of "total"
  // GenericTypeMatcher<JButton> noButtonMatcher = new
  // GenericTypeMatcher<JButton>(
  // JButton.class) {
  // @Override
  // protected boolean isMatching(JButton button) {
  // String expected = "cut";
  // String actual = button.getText();
  // return actual == null ? false : expected.equals(actual);
  // }
  // };
  // JButtonFixture noButton = window1.button(noButtonMatcher);
  // noButton.requireEnabled();
  // noButton.requireVisible();
  // noButton.click();
  //
  // // asserting that the value of "total" was changed
  // // after clicking on the button "cut"
  // assertTrue(model1.str.equals("LINE NUM:99 at method name:Model.cut"));
  //
  // }
  //
  // @Test
  // public void test2A() {
  //
  // // clicking on the tree
  // JTreeFixture tree = window1.tree();
  // assertThat(tree).isNotNull(); // sanity test
  // tree = tree.selectPath("meganalysis/");
  // tree.click();
  //
  // // getting the value of "name" in the text component
  // GenericTypeMatcher<JTextComponent> textAreaMatcherName = new
  // GenericTypeMatcher<JTextComponent>(
  // JTextComponent.class) {
  // @Override
  // protected boolean isMatching(JTextComponent tcomp) {
  // String expected = "meganalysis";
  // String actual = tcomp.getText();
  // return actual == null ? false : expected.equals(actual);
  // }
  // };
  // JTextComponentFixture Name = window1.textBox(textAreaMatcherName);
  // Name.enterText("1");
  // // clicking on the button "cut", this changes the value of "total"
  // GenericTypeMatcher<JButton> noButtonMatcher = new
  // GenericTypeMatcher<JButton>(
  // JButton.class) {
  // @Override
  // protected boolean isMatching(JButton button) {
  // String expected = "cut";
  // String actual = button.getText();
  // return actual == null ? false : expected.equals(actual);
  // }
  // };
  // JButtonFixture noButton = window1.button(noButtonMatcher);
  // noButton.requireEnabled();
  // noButton.requireVisible();
  // noButton.click();
  //
  // // asserting that the value of "total" was changed
  // // after clicking on the button "cut"
  // assertTrue(model1.str.equals("LINE NUM:99 at method name:Model.cut"));
  //
  // }
  //
  // @Test
  // public void test2B() {
  //
  // // clicking on the tree
  // JTreeFixture tree = window1.tree();
  // assertThat(tree).isNotNull(); // sanity test
  // tree = tree
  // .selectPath("meganalysis/Development/Dev1/Dev1.1/Karl (Manager)");
  // tree.click();
  //
  // // clicking on the button "cut", this changes the value of "total"
  // GenericTypeMatcher<JButton> noButtonMatcher = new
  // GenericTypeMatcher<JButton>(
  // JButton.class) {
  // @Override
  // protected boolean isMatching(JButton button) {
  // String expected = "cut";
  // String actual = button.getText();
  // return actual == null ? false : expected.equals(actual);
  // }
  // };
  // JButtonFixture noButton = window1.button(noButtonMatcher);
  // noButton.requireEnabled();
  // noButton.requireVisible();
  // noButton.click();
  //
  // // getting the value of "name" in the text component
  // GenericTypeMatcher<JTextComponent> textAreaMatcher1 = new
  // GenericTypeMatcher<JTextComponent>(
  // JTextComponent.class) {
  // @Override
  // protected boolean isMatching(JTextComponent tcomp) {
  // //String expected = "1172.5";
  // String expected = "1172";
  // String actual = tcomp.getText();
  // //return actual == null ? false : expected.equals(actual);
  // return actual == null ? false : actual.contains(expected);
  // }
  // };
  // JTextComponentFixture total1 = window1.textBox(textAreaMatcher1);
  // // asserting that the value of "total" was changed
  // // after clicking on the button "cut"
  //
  // //assertTrue(total1.text().equals("1172.5"));
  // assertTrue(total1.text().contains("1172"));
  //
  // }
  //
  // @Test
  // public void test3() {
  //
  // // clicking on the tree
  // JTreeFixture tree = window1.tree();
  // assertThat(tree).isNotNull(); // sanity test
  // tree = tree.selectPath("meganalysis/Research/Craig (Manager)");
  // tree.click();
  //
  // // // getting the value of "name" in the text component
  // // GenericTypeMatcher<JTextComponent> textAreaMatcher = new
  // // GenericTypeMatcher<JTextComponent>(
  // // JTextComponent.class) {
  // // @Override
  // // protected boolean isMatching(JTextComponent tcomp) {
  // // String expected = "123456.0";
  // // String actual = tcomp.getText();
  // // return actual == null ? false : expected.equals(actual);
  // // }
  // // };
  // // JTextComponentFixture total = window1.textBox(textAreaMatcher);
  // // total.enterText("3");
  //
  // tree = tree.selectPath("meganalysis/Research/");
  // tree.click();
  //
  // GenericTypeMatcher<JTextComponent> textAreaMatcher1 = new
  // GenericTypeMatcher<JTextComponent>(
  // JTextComponent.class) {
  // @Override
  // protected boolean isMatching(JTextComponent tcomp) {
  // //String expected = "137035.03";
  // String expected = "137035";
  // String actual = tcomp.getText();
  // //return actual == null ? false : expected.equals(actual);
  // return actual == null ? false : actual.contains(expected);
  // }
  // };
  // JTextComponentFixture total1 = window1.textBox(textAreaMatcher1);
  // // asserting that the value of "total" was changed
  // // after clicking on the button "cut"
  // //assertTrue(total1.text().equals("137035.03"));
  // assertTrue(total1.text().contains("137035"));
  //
  // }
  //
  // @Test
  // public void test4() {
  //
  // // clicking on the tree
  // JTreeFixture tree = window1.tree();
  // assertThat(tree).isNotNull(); // sanity test
  // tree = tree.selectPath("meganalysis/Research/Erik");
  // tree.click();
  //
  // // getting the value of "name" in the text component
  // GenericTypeMatcher<JTextComponent> textAreaMatcher = new
  // GenericTypeMatcher<JTextComponent>(
  // JTextComponent.class) {
  // @Override
  // protected boolean isMatching(JTextComponent tcomp) {
  // //String expected = "12345.0";
  // String expected = "12345";
  // String actual = tcomp.getText();
  // //return actual == null ? false : expected.equals(actual);
  // return actual == null ? false : actual.contains(expected);
  // }
  // };
  // JTextComponentFixture total = window1.textBox(textAreaMatcher);
  // total.enterText("5");
  //
  // tree = tree.selectPath("meganalysis/Research/");
  // tree.click();
  //
  // GenericTypeMatcher<JTextComponent> textAreaMatcher1 = new
  // GenericTypeMatcher<JTextComponent>(
  // JTextComponent.class) {
  // @Override
  // protected boolean isMatching(JTextComponent tcomp) {
  // // String expected = "137035.05";
  // //String expected = "124695.0";
  // String expected = "124695";
  // String actual = tcomp.getText();
  // //return actual == null ? false : expected.equals(actual);
  // return actual == null ? false : actual.contains(expected);
  // }
  // };
  // JTextComponentFixture total1 = window1.textBox(textAreaMatcher1);
  //
  // // asserting that the value of "total" was changed
  // // after clicking on the button "cut"
  // // assertTrue(total1.text().equals("137035.05"));
  // //assertTrue(total1.text().equals("124695.0"));
  // assertTrue(total1.text().contains("124695"));
  //
  // }
  //
  // /*
  // * public static void main(String[] args) {
  // * CompaniesVariables.getSINGLETON().setGUI___(true);
  // * CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
  // *
  // *
  // * model = new Model(new BeanFactory());
  // *
  // * view = new MainView(model);
  // *
  // * Controller controller = new Controller(model, view);
  // *
  // * controller.teststr = ""; controller.teststr1 = "34567.0";
  // * controller.start();
  // *
  // * //DG //In the exec, cut company,employee,department }
  // */
  // // SEPERATE TEST FOR ACCESS CONTROL

  @Test
  public void test5() {
    // Create company

    // CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);

    CompanyImpl samplecomp = new CompanyImpl();
    Logging l = new Logging();

    samplecomp.addObserver(l);
    samplecomp.setName("company1");

    assertEquals(samplecomp.str, "LINE NO:34 at method:Logging.update"); // CHECKS

    samplecomp.str = "";
    samplecomp.deleteObserver(l);

    samplecomp.setName("company2");
    assertFalse(samplecomp.str.equals("LINE NO:34 at method:Logging.update"));
  }

  @Test
  public void test6PreTrue() {

    EmployeeImpl sampleEmp = new EmployeeImpl();
    sampleEmp.setName("Divya");
    sampleEmp.setAddress("Austin,TX");
    sampleEmp.setManager(true);
    sampleEmp.setSalary(10);

    Logging l = new Logging();
    sampleEmp.addObserver(l);
    sampleEmp.setSalary(50);

    assertEquals(10, (int) sampleEmp.getOldSalary());
    assertEquals(sampleEmp.str, "LINE NO:34 at method:Logging.update"); // checks
                                                                        // notifyobservers
                                                                        // of
                                                                        // setSalary
    assertEquals(50, (int) sampleEmp.getSalary());
    assertEquals("Divya", sampleEmp.getName());// checks if the name of the
                                               // company were changed
    assertEquals("Austin,TX", sampleEmp.getAddress());

    assertEquals(true, sampleEmp.getManager());

    // assertEquals(sampleCompany.companyStr,"LINE NUM:54at METHOD NAME:addObserver");
  }

  @Test
  public void test6() {

    EmployeeImpl sampleEmp = new EmployeeImpl();
    sampleEmp.setName("Divya");
    sampleEmp.setAddress("Austin,TX");
    sampleEmp.setManager(true);
    sampleEmp.setSalary(10);

    Logging l = new Logging();
    sampleEmp.addObserver(l);
    sampleEmp.setSalary(50);

    assertEquals(sampleEmp.str, "LINE NO:34 at method:Logging.update"); // checks
                                                                        // notifyobservers
                                                                        // of
                                                                        // setSalary
    assertEquals(50, (int) sampleEmp.getSalary());
    assertEquals("Divya", sampleEmp.getName());// checks if the name of the
                                               // company were changed
    assertEquals("Austin,TX", sampleEmp.getAddress());

    assertEquals(true, sampleEmp.getManager());

    // assertEquals(sampleCompany.companyStr,"LINE NUM:54at METHOD NAME:addObserver");
  }

  @Test
  public void test7() {

    // Create company
    CompanyImpl sampleCompany = new CompanyImpl();
    Logging log = new Logging();
    sampleCompany.addObserver(log);
    Precedence pre = new Precedence();
    sampleCompany.addObserver(pre);
    // / assertTrue(sampleCompany.observerAdded);//checks if observers were
    // added to the subunits
    assertEquals(2, sampleCompany.countObservers());// checks if observers were
                                                    // added to sampleCompany
  }

  @After
  public void teardown() {
    if (!(testName.getMethodName().equals("test5"))
        && !(testName.getMethodName().startsWith("test6"))
        && !(testName.getMethodName().equals("test7")))
      window1.cleanUp();
    System.out.println(CompaniesVariables.getSINGLETON().toString());
    // CompaniesVariables.getSINGLETON().restore();
  }

}
