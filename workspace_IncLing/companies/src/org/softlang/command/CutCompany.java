package org.softlang.command;

import org.softlang.company.Company;
import org.softlang.company.Employee;
import org.softlang.template.Walker;

import specifications.Configuration;





/**
 * Construct a salary cut for all salaries in a company
 */
public class CutCompany extends Batch {

	public CutCompany(Company c) {
	  
	  // dealing with annotations
		boolean select = false;
		if (Configuration.CUT_NO_DEPARTMENT)
			select = true;
		else if (Configuration.CUT_NO_MANAGER)
			select = true;
		else if (Configuration.CUT_WHATEVER)
			select = true;
		if (Configuration.TOTAL_REDUCER)
			select = true;
		else if (Configuration.TOTAL_WALKER)
			select = true;
		if (select) {
			new Walker() {
				public void visit(Employee e) {
					add(new CutEmployee(e));
				}
			}.postorder(c);
		}
	}
}
