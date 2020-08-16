package org.softlang.gui;

import org.softlang.company.factory.BeanFactory;
import org.softlang.swing.controller.Controller;
import org.softlang.swing.model.Model;
import org.softlang.swing.view.MainView;

import splat.CompaniesVariables;

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
    CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(false);
    // CompaniesVariables.getSINGLETON().setCUT_NO_DEPARTMENT___(true);
    // CompaniesVariables.getSINGLETON().setCUT_NO_MANAGER___(false);
    CompaniesVariables.getSINGLETON().setGUI___(true);
    CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);
    // CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(true);
    CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(true);
    // CompaniesVariables.getSINGLETON().setACCESS_CONTROL___(false);

    Model model = new Model(new BeanFactory());
    MainView view = new MainView(model);
    Controller controller = new Controller(model, view);

    controller.start();
  }
}
