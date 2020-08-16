package org.softlang.proxy;

import org.softlang.company.Employee;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;


/**
 * A proxy for employees to enforce access control policy for salaries.
 */
class ProxyEmployee implements Employee {

  private AccessControl context;
  private Employee subject;

  ProxyEmployee(AccessControl context, Employee subject) {
    this.context = context;
    this.subject = subject;
  }

  public String getName() {
    return subject.getName();
  }

  public void setName(String name) {
    subject.setName(name);
  }

  public String getAddress() {
    return subject.getAddress();
  }

  public void setAddress(String address) {
    subject.setAddress(address);
  }

  public double getSalary() {
    if (context.isReadable())
      return subject.getSalary();
    else
      throw new IllegalArgumentException(
          "Receiver without read access for salary.");
  }

  public void setSalary(double salary) {
    if (context.isWritable())
      subject.setSalary(salary);
    else
      throw new IllegalArgumentException(
          "Receiver without write access for salary.");
  }

  public boolean getManager() {
    return subject.getManager();
  }

  public void setManager(boolean manager) {
    subject.setManager(manager);
  }

  // Delegation is NOT appropriate here.
  public void accept(VoidVisitor v) {
    
  // dealing with annotations
    boolean select = false;
    if (specifications.Configuration.CUT_NO_DEPARTMENT)
      select = true;
    else if (specifications.Configuration.CUT_NO_MANAGER)
      select = true;
    else if (specifications.Configuration.CUT_WHATEVER)
      select = true;
    if (specifications.Configuration.TOTAL_REDUCER)
      select = true;
    else if (specifications.Configuration.TOTAL_WALKER)
      select = true;
    
    if (select) {
      v.visit(this);
    }
  }

  // Delegation is NOT appropriate here.
  public <R> R accept(ReturningVisitor<R> v) {
    
  // dealing with annotations
    boolean select = false;
    if (specifications.Configuration.CUT_NO_DEPARTMENT)
      select = true;
    else if (specifications.Configuration.CUT_NO_MANAGER)
      select = true;
    else if (specifications.Configuration.CUT_WHATEVER)
      select = true;
    if (specifications.Configuration.TOTAL_REDUCER)
      select = true;
    else if (specifications.Configuration.TOTAL_WALKER)
      select = true;
    
    if (select) {
      return v.visit(this);
    } 
    return null;
  }

  /**
   * This method returns the name for the tree-view.
   */
  @Override
  public String toString() {
    if (specifications.Configuration.GUI) {
      String treeName = this.getName();
      if (getManager()) {
        return treeName + " (Manager)";
      }
      return treeName;
    } 
    return "";
  }

}
