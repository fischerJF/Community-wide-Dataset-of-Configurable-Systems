package tests;

import splat.DesktopSearcherVariables;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		DesktopSearcherVariables.getSINGLETON().setTXT(true);
//		DesktopSearcherVariables.getSINGLETON().setHTML(true);
//		DesktopSearcherVariables.getSINGLETON().setLATEX(true);
//		DesktopSearcherVariables.getSINGLETON().setGUI(true);
//
//		if(DesktopSearcherVariables.getSINGLETON().isGUI()){
//			System.out.println("GUI");
//		}
//		if(DesktopSearcherVariables.getSINGLETON().isCOMMAND_LINE()){
//			System.out.println("COMMAND_LINE");
//		}
//		if(DesktopSearcherVariables.getSINGLETON().isLATEX()){
//			System.out.println("LATEX");
//		}
		
		DesktopSearcherVariables.getSINGLETON().setCOMMAND_LINE(false);
		DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(false);
		DesktopSearcherVariables.getSINGLETON().setTXT(false);
		DesktopSearcherVariables.getSINGLETON().setHTML(false);
		DesktopSearcherVariables.getSINGLETON().setLATEX(false);
		DesktopSearcherVariables.getSINGLETON().setGUI(false);
		DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(false);
		DesktopSearcherVariables.getSINGLETON().setMULTI_DIRECTORY(false);
		DesktopSearcherVariables.getSINGLETON().setGUI_PREFERENCES(false);
		DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(false);
		DesktopSearcherVariables.getSINGLETON().setTREE_VIEW(false);
		DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
		DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
		DesktopSearcherVariables.getSINGLETON().setLINUX(false);
		DesktopSearcherVariables.getSINGLETON().setWINDOWS(false);
		System.out.println(DesktopSearcherVariables.getSINGLETON().toString());
	}

}
