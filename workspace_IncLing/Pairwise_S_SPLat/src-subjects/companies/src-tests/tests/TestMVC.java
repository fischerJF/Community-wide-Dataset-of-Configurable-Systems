package tests;

import java.awt.event.KeyListener;

import org.junit.Test;
import org.softlang.company.Component;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.factory.Factory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.company.impl.bean.EmployeeImpl;
import org.softlang.swing.controller.Controller;
import org.softlang.swing.model.Model;
import org.softlang.swing.view.CompanyView;
import org.softlang.swing.view.EmployeeView;
import org.softlang.swing.view.MainView;

/**
 * Test/demonstrate basic operations for totaling and cutting salaries.
 */
public class TestMVC extends CompaniesTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		if (testName == null) {
			throw new RuntimeException();
		}
		String strTestName = testName.getMethodName();
		if (strTestName.equals("testModelView")
				|| strTestName.equals("testModelViewController")) {
			// it works with no feature enabled
		} else {
			System.err.printf("%s did not set default configuration",
					strTestName);
		}
	}

	@Test
	public void testModelView() {
		PojoFactory pojoFactory0 = new PojoFactory();
		Model model0 = new Model((Factory) pojoFactory0);
		EmployeeImpl employeeImpl0 = new EmployeeImpl();
		model0.setCurrentValue((Component) employeeImpl0);
		EmployeeView employeeView0 = new EmployeeView(model0);
		employeeView0.addAddressListener((KeyListener) null);
		employeeView0.toString();
		employeeView0.getComponentCount();
	}

	@Test
	public void testModelViewController() {
		BeanFactory beanFactory0 = new BeanFactory();
		Model model1 = new Model((Factory) beanFactory0);
		CompanyImpl companyImpl0 = new CompanyImpl();
		model1.setCurrentValue((Component) companyImpl0);
		model1.setCurrentValue((Component) companyImpl0);
		model1.getTotal();
		model1.cut();
		CompanyView companyView0 = new CompanyView(model1);
		companyView0.toString();
		companyView0.getComponentCount();
		Controller controller0 = new Controller(model1, (MainView) null);
		controller0.toString();
	}

}
