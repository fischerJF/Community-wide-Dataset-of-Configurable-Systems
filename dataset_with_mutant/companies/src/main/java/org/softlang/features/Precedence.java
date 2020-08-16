package org.softlang.features;






import java.util.Observable;
import java.util.Observer;

import org.softlang.company.Employee;
import org.softlang.company.Subunit;
import org.softlang.company.impl.bean.DepartmentImpl;
import org.softlang.company.impl.bean.EmployeeImpl;

/**
 * Supervise all salary changes to obey the Precedence feature.
 */
public class Precedence implements Observer {
	
	public void update(Observable o, Object arg) {
		if (o instanceof EmployeeImpl && arg instanceof String) {
			EmployeeImpl e = (EmployeeImpl)o;
			if (((String)arg).equals("salary")) {
				DepartmentImpl d = (DepartmentImpl)e.getParent();
				if (!e.getManager()) {
					// An employee must have a smaller salary than the manager of the department.
					if (e.getSalary() >= d.getManager().getSalary())
						try {
							throw exception(e);
						} catch (Exception e1) {
							e.setSalaryWithOldSalary();
							e.setOldSalary(e.getSalary());
							System.out.println(e1.getMessage());
						}
				} else {
					// A manager of the upper department, if any, must have a greater salary.
					if (d.getParent()!=null && d.getParent() instanceof DepartmentImpl)
						if (e.getSalary() >= ((DepartmentImpl)(d.getParent())).getManager().getSalary())
							try {
								throw exception(e);
							} catch (Exception e1) {
								e.setSalaryWithOldSalary();
								e.setOldSalary(e.getSalary());
								System.out.println(e1.getMessage());
							}
					// All managed employees must have smaller salaries.
					// For sub-departments, the manager is tested only.
					for (Subunit u : d.subunits())
						if (u instanceof DepartmentImpl) {
							if (((DepartmentImpl)u).getManager().getSalary() >= e.getSalary())
								try {
									throw exception(e);
								} catch (Exception e1) {
									e.setSalaryWithOldSalary();
									e.setOldSalary(e.getSalary());
									System.out.println(e1.getMessage());
								}								
						} else {
							if (u!=e && ((EmployeeImpl)u).getSalary() >= e.getSalary())
								try {
									throw exception(e);
								} catch (Exception e1) {
									e.setSalaryWithOldSalary();
									e.setOldSalary(e.getSalary());
									System.out.println(e1.getMessage());
								}								
						}
				}
			}
		}
	}
	
	private Exception exception(Employee e) {
		return new Exception("Precedence constraint violated for employee \"" + e.getName() + "\".");
	} 
}
