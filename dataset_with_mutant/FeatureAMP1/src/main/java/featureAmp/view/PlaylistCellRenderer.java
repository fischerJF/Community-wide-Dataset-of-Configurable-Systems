package featureAmp.view; 

import java.awt.Color; 
import java.awt.Component; 

import javax.swing.DefaultListCellRenderer; 
import javax.swing.JList; 

import featureAmp.MusicFileWrapper; 


@SuppressWarnings("serial")
public  class  PlaylistCellRenderer  extends DefaultListCellRenderer {
	

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list,
			Object value, int index, boolean isSelected, boolean cellHasFocus) {
		
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (!(value instanceof MusicFileWrapper)) {
			return c;
		}
		MusicFileWrapper file = (MusicFileWrapper)value;
		if(file.isPlaying()){
			c.setForeground(Color.BLUE);
		}
		
		return c;
	}


}
