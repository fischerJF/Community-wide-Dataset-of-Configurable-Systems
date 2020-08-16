package org.softlang.company.factory;






import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.company.impl.bean.DepartmentImpl;
import org.softlang.company.impl.bean.EmployeeImpl;

/**
 * A factory that constructs (a kind of) "beans" as opposed to POJPs
 */
public class BeanFactory implements Factory {
	public Company mkCompany() { return new CompanyImpl(); }
	public Department mkDepartment() { return new DepartmentImpl(); }
	public Employee mkEmployee() { return new EmployeeImpl(); }
}
