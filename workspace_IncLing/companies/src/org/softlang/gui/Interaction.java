package org.softlang.gui;

import org.softlang.company.factory.BeanFactory;
import org.softlang.swing.controller.Controller;
import org.softlang.swing.model.Model;
import org.softlang.swing.view.MainView;

import specifications.Configuration;

/**
 * This class initializes the MVC-structure of the project. Based on the very
 * simple data structure of the project, there is only one instance of the
 * model.
 * 
 * @author Tobias Zimmer
 */
public class Interaction {
  public static void main(String[] args) {
    
    // CompaniesVariables.getSINGLETON().setLOGGING___(true);
//    Configuration.CUT_WHATEVER=false;
    // CompaniesVariables.getSINGLETON().setCUT_NO_DEPARTMENT___(true);
    // CompaniesVariables.getSINGLETON().setCUT_NO_MANAGER___(false);
//    Configuration.GUI=true;
//    Configuration.PRECEDENCE=true;
    // CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
//    Configuration.TOTAL_REDUCER=true;
    // CompaniesVariables.getSINGLETON().setACCESS_CONTROL___(false);

    Configuration.TREE_STRUCTURE=true;  
    Configuration.TOTAL_WALKER=true;
    Configuration.TOTAL_REDUCER=false;
    Configuration.PRECEDENCE=true;   
    Configuration.LOGGING=true; 
    Configuration.GUI=true;
    Configuration.CUT_WHATEVER=true;
    Configuration.CUT_NO_MANAGER=false;
    Configuration.CUT_NO_DEPARTMENT=false;
    Configuration.ACCESS_CONTROL=true;
    
    
    Model model = new Model(new BeanFactory());
    MainView view = new MainView(model);
    Controller controller = new Controller(model, view);

    
    controller.start();
  }
}
