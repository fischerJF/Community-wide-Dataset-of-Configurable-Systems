package org.softlang.company.impl.pojo;

import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.company.Subunit;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import specifications.Configuration;

public class DepartmentImpl extends ContainerImpl implements Department {

  private List<Department> subdepts;
  private List<Employee> employees;
  private DefaultMutableTreeNode treeNode;

  public DepartmentImpl() {
    super();
    if (Configuration.GUI) {
      subdepts = new LinkedList<Department>();
      employees = new LinkedList<Employee>();
    }
  }

  public void setSubdepts(List<Department> subdepts) {
    if (Configuration.GUI) {
      this.subdepts = subdepts;
    }
  }

  public void setEmployees(List<Employee> employees) {
    if (Configuration.GUI) {
      this.employees = employees;
    }
  }

  public List<Department> getSubdepts() {
    if (Configuration.GUI) {
      return subdepts;
    } 
    return null;
  }

  public List<Employee> getEmployees() {
    if (Configuration.GUI) {
      return employees;
    } 
    return null;
  }

  public void setTreeNode(DefaultMutableTreeNode treeNode) {
    if (Configuration.GUI) {
      this.treeNode = treeNode;
    }
  }

  public DefaultMutableTreeNode getTreeNode() {
    if (Configuration.GUI) {
      return treeNode;
    } 
    return null;
  }

  public boolean add(Subunit u) {
    super.add(u);
    if (Configuration.GUI) {
      if (u instanceof Department) {
        return this.subdepts.add((Department) u);
      } else if (u instanceof Employee) {
        return this.employees.add((Employee) u);
      }
      return false;
    } 
    return false;
  }

  /**
   * This method returns the name for the tree-view.
   */
  @Override
  public String toString() {
    if (Configuration.GUI) {
      String treeName = this.getName();
      return treeName;
    } 
    return "";
  }

  public void accept(VoidVisitor v) {
    
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
      v.visit(this);
    }
  }

  public <R> R accept(ReturningVisitor<R> v) {
    
  // dealing with annotations
    boolean select = false;
    if (Configuration.CUT_NO_DEPARTMENT)
      select = true;
    if (Configuration.CUT_NO_MANAGER)
      select = true;
    if (Configuration.CUT_WHATEVER)
      select = true;
    if (Configuration.TOTAL_REDUCER)
      select = true;
    if (Configuration.TOTAL_WALKER)
      select = true;
    
    if (select) {
      return v.visit(this);
    } 
    return null;
  }

  public Employee getManager() {
    for (Subunit u : subunits())
      if (u instanceof Employee) {
        Employee e = (Employee) u;
        if (e.getManager()) {
          if (Configuration.GUI) {
            employees.remove(e);
          }
          return e;
        }
      }
    return null;
  }
}
