package main; 

import javax.swing.*; 

import main.FeatureAmp; 

import java.awt.*; 

 

class  QueueSongCellRenderer  extends JLabel  implements ListCellRenderer {
	
  // Since JPanel is serializable, we need this
  static final long serialVersionUID = 1;

	

  public QueueSongCellRenderer() {
		if (specifications.Configuration.queuetrack) {
	    setOpaque(true);
	  		}
	}

	

  public Component getListCellRendererComponent(JList list, Object value,
      int index, boolean isSelected, boolean cellHasFocus) {

    setText(value.toString());

    setBackground(FeatureAmp.getBackgroundColor());
    setForeground(FeatureAmp.getForegroundColor());

    return this;
  }


}
