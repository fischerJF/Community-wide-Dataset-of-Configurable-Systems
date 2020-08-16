package featureamp.gui.elements; 

import java.awt.Component; 

import javax.swing.JScrollPane; 
import javax.swing.border.LineBorder; 

import featureamp.FeatureAMP; 

/**
 * TODO description
 */
public  class  ScrollPane  extends JScrollPane {
	
	
	public static final long serialVersionUID = 1l;

	 

	public ScrollPane(Component view) {
//		if (specifications.Configuration.playlist) {
			// Playlist
			super(view);
			getViewport().setBackground(FeatureAMP.BG);
			setBorder(new LineBorder(FeatureAMP.BG2, 3));
//				}
	}


}
