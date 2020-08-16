package org.softlang.features;






import org.softlang.company.Employee;
import org.softlang.template.Walker;

public class SimpleCut extends Walker {
	public void visit(Employee e) {
		e.setSalary(e.getSalary() / 2.0);
	}
}
