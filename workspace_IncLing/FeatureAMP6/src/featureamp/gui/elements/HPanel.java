package featureamp.gui.elements; 

import gui.DefaultLayout; 
import gui.DefaultPanel; 

import featureamp.FeatureAMP; 

/**
 * TODO description
 */
public  class  HPanel  extends DefaultPanel {
	
	
	public static final long serialVersionUID = 1l;

	 

	public HPanel() {
//		if (specifications.Configuration.base) {
			// Base
			super(DefaultLayout.View.HORIZONTAL);
			setBackground(FeatureAMP.BG);
			setForeground(FeatureAMP.FG);
//				}
	}


}
