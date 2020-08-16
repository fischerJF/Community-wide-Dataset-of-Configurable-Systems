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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.TestName;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.company.impl.bean.EmployeeImpl;
import org.softlang.features.Logging;
import org.softlang.features.Precedence;
import org.softlang.swing.controller.Controller;
import org.softlang.swing.model.Model;
import org.softlang.swing.view.MainView;

import specifications.Configuration;

public class Pilot_3 extends CompaniesTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		// CompaniesVariables.getSINGLETON().setGUI___(true);
		Configuration.GUI = true;
		// if (testName == null) {
		// throw new RuntimeException();
		// }
		// System.out.println("METHOD NAME:" + testName.getMethodName());
		// if (testName.getMethodName().equals("test1")) {
		//// CompaniesVariables.getSINGLETON().setCUT_NO_DEPARTMENT___(true);
		// } else if (testName.getMethodName().equals("test2")
		// || testName.getMethodName().equals("test2A")) {
		//// CompaniesVariables.getSINGLETON().setCUT_NO_MANAGER___(true);
		// } else if (testName.getMethodName().equals("test2B")) {
		//// CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
		//// CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
		// } else if (testName.getMethodName().equals("test3")) {
		//// CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
		// } else if (testName.getMethodName().equals("test4")) {
		//// CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(true);
		// } else if (testName.getMethodName().equals("test5")
		// || testName.getMethodName().startsWith("test6")
		// || testName.getMethodName().equals("test7")) {
		//// CompaniesVariables.getSINGLETON().setGUI___(false);
		//// CompaniesVariables.getSINGLETON().setLOGGING___(true);
		// if (testName.getMethodName().equals("test7") ||
		// testName.getMethodName().equals("test6PreTrue")){
		//// CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);
		// }
		//
		// } else {
		// System.err.printf("%s did not set default configuration",
		// testName.getMethodName());
		// }
	}

	FrameFixture window_, window2;
	Model model1, model2;
	MainView view1, view2;
	Controller controller1, controller2;

	static Model model;
	static MainView view;
	static Controller controller;

	
	@Before
	public void setup() {
		super.configure();
		FailOnThreadViolationRepaintManager.install();
		GuiQuery<MainView> action1 = new GuiQuery<MainView>() {
			protected MainView executeInEDT() {
				configure();

				model1 = new Model(new BeanFactory());
				// if (testName.getMethodName().startsWith("test2"))
				// model1 = new Model(new PojoFactory());

				view1 = new MainView(model1);
				controller1 = new Controller(model1, view1);
				controller1.start();
				return view1;

			}

		};
		// if (!(testName.getMethodName().equals("test5")) &&
		// !(testName.getMethodName().startsWith("test6")) &&
		// !(testName.getMethodName().equals("test7")) )
		// {
//		MainView frame1 = GuiActionRunner.execute(action1);
//		window_ = new FrameFixture(frame1);
//		window_.show(new Dimension(500, 500));
	}

	

	@Test
	public void test5() {
		// Create company

		// CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);
		Configuration.GUI = true;
		Configuration.LOGGING = true;
		if (Configuration.GUI && Configuration.LOGGING) {
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
	}

	
	@Test
	public void test6() {
		Configuration.GUI = true;
		Configuration.LOGGING = true;
		if (Configuration.GUI && Configuration.LOGGING) {
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

			// assertEquals(sampleCompany.companyStr,"LINE NUM:54at METHOD
			// NAME:addObserver");
		}
	}

	@Test
	public void test7() {
		Configuration.GUI = true;
		Configuration.LOGGING = true;
		Configuration.PRECEDENCE = true;
		if (Configuration.GUI && Configuration.LOGGING && Configuration.PRECEDENCE) {
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
	}

	@After
	public void teardown() {
		// if (!(testName.getMethodName().equals("test5")) &&
		// !(testName.getMethodName().startsWith("test6"))
		// && !(testName.getMethodName().equals("test7")))
//		 window_.cleanUp();
		// // System.out.println(CompaniesVariables.getSINGLETON().toString());
		// // CompaniesVariables.getSINGLETON().restore();
	}

}
