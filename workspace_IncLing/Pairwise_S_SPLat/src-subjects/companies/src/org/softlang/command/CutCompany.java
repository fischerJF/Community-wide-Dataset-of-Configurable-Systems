package org.softlang.command;

import org.softlang.company.Company;
import org.softlang.company.Employee;
import org.softlang.template.Walker;

import splat.CompaniesVariables;





/**
 * Construct a salary cut for all salaries in a company
 */
public class CutCompany extends Batch {

	public CutCompany(Company c) {
	  
	  // dealing with annotations
		boolean select = false;
		if (CompaniesVariables.getSINGLETON().isCUT_NO_DEPARTMENT___())
			select = true;
		else if (CompaniesVariables.getSINGLETON().isCUT_NO_MANAGER___())
			select = true;
		else if (CompaniesVariables.getSINGLETON().isCUT_WHATEVER___())
			select = true;
		if (CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___())
			select = true;
		else if (CompaniesVariables.getSINGLETON().isTOTAL_WALKER___())
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
