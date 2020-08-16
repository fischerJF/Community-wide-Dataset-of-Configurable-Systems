package org.softlang.visitor;






import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;

public interface VoidVisitor {

	void visit(Company o);
	void visit(Department o);
	void visit(Employee o);
		
}
