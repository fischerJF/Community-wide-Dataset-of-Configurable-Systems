package featureamp.gui.elements; 

import javax.swing.JLabel; 

import featureamp.FeatureAMP; 

/**
 * TODO description
 */
public  class  Label  extends JLabel {
	
	
	public static final long serialVersionUID = 1l;

	 
	
	public Label(String text) {
//		if (specifications.Configuration.base) {
			// Base
			super(text);
			setBackground(FeatureAMP.BG);
			setForeground(FeatureAMP.FG);
//				}
	}


}
