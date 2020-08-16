package main; 

import javax.swing.*; 

import main.FeatureAmp; 
import main.Playlist; 

import java.awt.*; 

 

class  SongCellRenderer  extends JLabel  implements ListCellRenderer {
	
  // Since JPanel is serializable, we need this
  static final long serialVersionUID = 1;

	

  public SongCellRenderer() {
		if (specifications.Configuration.playlist) {
	    setOpaque(true);
	  		}
	}

	

  public Component getListCellRendererComponent(JList list, Object value,
      int index, boolean isSelected, boolean cellHasFocus) {

    setText(value.toString());

    Color background;
    Color foreground;
    
    final Color midnightBlue = new Color(25, 25, 112);
    final Color darkRed = new Color(139, 0, 0);

    // check if this cell represents the current DnD drop location
    JList.DropLocation dropLocation = list.getDropLocation();
    if (dropLocation != null && !dropLocation.isInsert()
        && dropLocation.getIndex() == index) {

      background = midnightBlue;
      foreground = Color.WHITE;

      // check if this cell is selected
    } else if (isSelected) {
      background = midnightBlue;
      foreground = Color.WHITE;

      // current song
    } else if ( Playlist.getInstance() != null &&
                Playlist.getInstance().getCurrentSong() != null &&
                value.equals(Playlist.getInstance().getCurrentSong()) ) {
      background = darkRed;
      foreground = Color.WHITE;

      // unselected, and not the DnD drop location
    } else {
      background = FeatureAmp.getBackgroundColor();
      foreground = FeatureAmp.getForegroundColor();
    }
    ;

    setBackground(background);
    setForeground(foreground);

    return this;
  }


}
