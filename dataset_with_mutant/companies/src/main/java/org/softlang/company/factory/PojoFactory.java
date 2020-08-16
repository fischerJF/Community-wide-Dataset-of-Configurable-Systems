package org.softlang.company.factory;






import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.company.impl.pojo.CompanyImpl;
import org.softlang.company.impl.pojo.DepartmentImpl;
import org.softlang.company.impl.pojo.EmployeeImpl;

/**
 * A factory that constructs POJPs
 */
public class PojoFactory implements Factory {
	public Company mkCompany() { return new CompanyImpl(); }
	public Department mkDepartment() { return new DepartmentImpl(); }
	public Employee mkEmployee() { return new EmployeeImpl(); }
}
