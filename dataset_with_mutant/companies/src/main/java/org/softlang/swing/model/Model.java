package org.softlang.swing.model;

import org.softlang.command.CutCompany;
import org.softlang.command.CutEmployee;
import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.factory.Factory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.features.Logging;
import org.softlang.features.OrderedCut;
import org.softlang.features.Precedence;
import org.softlang.features.SimpleCut;
import org.softlang.features.TotalReducer;
import org.softlang.features.TotalWalker;

import specifications.Configuration;

/**
 * The data model.
 * 
 * @author Tobias Zimmer
 */
public class Model {

  private Company company;
  private org.softlang.company.Component currentValue;
  public String str;

  /**
   * Constructor
   */
  public Model(Factory factory) {
    this.str = "";
    // The serialized object has been copied over from elsewhere
    if (factory instanceof PojoFactory) {
      company = (org.softlang.company.impl.pojo.CompanyImpl) createSampleCompany(new PojoFactory());
    } else if (factory instanceof BeanFactory) {
      company = (org.softlang.company.impl.bean.CompanyImpl) createSampleCompany(new BeanFactory());
      if (Configuration.LOGGING) {
        Logging log = new Logging();
        ((org.softlang.company.impl.bean.CompanyImpl) company).addObserver(log);
      }
      if (Configuration.PRECEDENCE) {
        Precedence precedence = new Precedence();
        ((org.softlang.company.impl.bean.CompanyImpl) company)
            .addObserver(precedence);
      }
    }
  }

  /**
   * This method returns the total value for the current company, department or
   * employee.
   * 
   * @return current total value
   */
  public String getTotal() {
    String value = "";
    if (Configuration.TOTAL_WALKER) {
      TotalWalker walker = new TotalWalker();
      walker.postorder(currentValue);
      value = Double.toString(walker.getTotal());
    } else if (Configuration.TOTAL_REDUCER) {
      TotalReducer total = new TotalReducer();
      double valueDouble = total.reduce(currentValue);
      value = Double.toString(valueDouble);
    }
    return value;
  }

  /**
   * This method cuts the current company, department or employee.
   */
  public void cut() {
    if (Configuration.CUT_WHATEVER) {
      SimpleCut simpleCut = new SimpleCut();
      simpleCut.postorder(currentValue);
      // DG
      this.str = "LINE NUM:85 at method name:Model.cut";
    } else if (Configuration.CUT_NO_DEPARTMENT) {
      if (currentValue instanceof Company) {
        CutCompany commandCut = new CutCompany((Company) currentValue);
        commandCut.execute();
      } else if (currentValue instanceof Employee) {
        new CutEmployee((Employee) currentValue).execute();
      }
      // DG
      this.str = "LINE NUM:92 at method name:Model.cut";
    } else if (Configuration.CUT_NO_MANAGER) {
      OrderedCut orderedCut = new OrderedCut();
      orderedCut.postorder(currentValue);
      // DG
      this.str = "LINE NUM:99 at method name:Model.cut";
    }
  }

  // ----------------------------------- GETTER & SETTER
  public void setName(String newValue) {
    currentValue.setName(newValue);
  }

  public void setAddress(String newValue) {
    ((Employee) currentValue).setAddress(newValue);
  }

  public void setSalary(String newValue) {
      ((Employee) currentValue).setSalary(Double.parseDouble(newValue));
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public org.softlang.company.Component getCurrentValue() {
    return currentValue;
  }

  public void setCurrentValue(org.softlang.company.Component currentValue) {
    this.currentValue = currentValue;
  }

  static Company createSampleCompany(Factory f) {

    // Create company
    Company sampleCompany = f.mkCompany();
    sampleCompany.setName("meganalysis");

    // Create all employees
    Employee craig = f.mkEmployee();
    craig.setName("Craig");
    craig.setAddress("Redmond");
    craig.setSalary(123456);
    craig.setManager(true);

    Employee erik = f.mkEmployee();
    erik.setName("Erik");
    erik.setAddress("Utrecht");
    erik.setSalary(12345);

    Employee ralf = f.mkEmployee();
    ralf.setName("Ralf");
    ralf.setAddress("Koblenz");
    ralf.setSalary(1234);

    Employee ray = f.mkEmployee();
    ray.setName("Ray");
    ray.setAddress("Redmond");
    ray.setSalary(234567);
    ray.setManager(true);

    Employee klaus = f.mkEmployee();
    klaus.setName("Klaus");
    klaus.setAddress("Boston");
    klaus.setSalary(23456);
    klaus.setManager(true);

    Employee karl = f.mkEmployee();
    karl.setName("Karl");
    karl.setAddress("Riga");
    karl.setSalary(2345);
    karl.setManager(true);

    Employee joe = f.mkEmployee();
    joe.setName("Joe");
    joe.setAddress("Wifi City");
    joe.setSalary(2344);

    // Create research department
    Department research = f.mkDepartment();
    research.setName("Research");
    research.add(craig);
    research.add(erik);
    research.add(ralf);
    sampleCompany.add(research);

    // Create development department
    Department development = f.mkDepartment();
    development.setName("Development");
    development.add(ray);
    sampleCompany.add(development);

    // Create sub-department dev1
    Department dev1 = f.mkDepartment();
    dev1.setName("Dev1");
    dev1.add(klaus);
    development.add(dev1);

    // Create sub-department dev11
    Department dev11 = f.mkDepartment();
    dev11.setName("Dev1.1");
    dev11.add(karl);
    dev11.add(joe);
    dev1.add(dev11);

    return sampleCompany;
  }

}
