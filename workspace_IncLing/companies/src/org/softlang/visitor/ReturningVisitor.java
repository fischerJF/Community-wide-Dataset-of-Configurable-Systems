package org.softlang.visitor;






import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;

public interface ReturningVisitor<R> {

	R visit(Company o);
	R visit(Department o);
	R visit(Employee o);

}
