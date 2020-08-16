package featureamp.gui.elements; 

import gui.DefaultLayout; 
import gui.DefaultPanel; 

import featureamp.FeatureAMP; 

/**
 * TODO description
 */
public  class  VPanel  extends DefaultPanel {
	
	
	public static final long serialVersionUID = 1l;

	 

	public VPanel() {
//		if (specifications.Configuration.base) {
			// Base
			super(DefaultLayout.View.VERTICAL);
			setBackground(FeatureAMP.BG);
			setForeground(FeatureAMP.FG);
//				}
	}


}
