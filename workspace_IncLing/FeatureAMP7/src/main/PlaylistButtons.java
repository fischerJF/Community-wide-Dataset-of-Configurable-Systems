package main; 

import javax.swing.*; 

import main.FeatureAmp; 

import java.awt.Dimension; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import javax.swing.BoxLayout; 
import javax.swing.ButtonGroup; 
import javax.swing.JButton; 
import javax.swing.JCheckBox; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JRadioButton; 
import javax.swing.SwingUtilities; 

import main.Buttons; 
import main.Playlist; 
import main.PlaylistButtons; 
import main.Song; 
import javax.swing.JFrame; 
import javax.swing.JOptionPane; 

public   class  PlaylistButtons  extends JPanel {
	
  // Since JPanel is serializable, we need this
  static final long serialVersionUID = 1;

	
  
  private JPanel buttons = new JPanel();

	
  
  private JButton addButton = new JButton("Lied hinzuf\u00fcgen");

	
  
  private static PlaylistButtons playlistButtonsInstance = new PlaylistButtons();

	
  
  /**
   * Create a layout and the buttons
   */
  private PlaylistButtons() {
		if (specifications.Configuration.playlist) {
	    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    setBackground(FeatureAmp.getBackgroundColor());
	    buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
	    add(buttons);
	       
	    addButton.setMinimumSize(new Dimension(100, 20));
	    addButton.setName("addbutton");
	    addButton.setMaximumSize(new Dimension(20000, 40));
	    addButton.setBackground(FeatureAmp.getBackgroundColor());
	    addButton.setForeground(FeatureAmp.getForegroundColor());
	    
	    buttons.add(addButton);
	    
	    addLoadButton();
	    addShuffleButtons();
	    
	    addButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        SwingUtilities.invokeLater(new Runnable() {
	          public void run() {
	            OpenFile.getInstance().actionPerformed(null);
	          }
	        });
	      }
	    });
	    
	    addRemoveTrack();
	    addClearPlaylist();
	    addReorderPlaylist();
	    
	    addShuffleRepeat();
	  
	  		}
	}

	
  
  public void addComponent(JComponent newComponent) {
    buttons.add(newComponent);
  }

	
  
  public void addComponentTop(JComponent newComponent) {
    add(newComponent);
  }

	

   private void  addLoadButton__wrappee__Playlist  () {
  }

	

  private void addLoadButton() {
		if (!specifications.Configuration.loadfolder) {
			addLoadButton__wrappee__Playlist();
			return;
		}
    loadButton.setMinimumSize(new Dimension(100, 20));
    loadButton.setMaximumSize(new Dimension(20000, 40));
    loadButton.setBackground(FeatureAmp.getBackgroundColor());
    loadButton.setForeground(FeatureAmp.getForegroundColor());
    buttons.add(loadButton);

    loadButton.addActionListener(OpenDirectory.getInstance());
  }

	
  
  private void addShuffleButtons() {
  }

	
  
  public void repaintButtons() {
    buttons.repaint();
  }

	
  
    private void  addRemoveTrack__wrappee__Playlist  () {
  }

	
  public void addRemoveTrack() {
		if (!specifications.Configuration.removetrack) {
			addRemoveTrack__wrappee__Playlist();
			return;
		}
    JButton removeButton = new JButton("Lied l\u00f6schen");
    
    removeButton.setMinimumSize(new Dimension(100, 20));
    removeButton.setMaximumSize(new Dimension(20000, 40));
    removeButton.setBackground(FeatureAmp.getBackgroundColor());
    removeButton.setForeground(FeatureAmp.getForegroundColor());
    
    removeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Object[] selectedSongs = Playlist.getInstance().getList().getSelectedValues();
        
        for (int i = 0; i < selectedSongs.length; i++) {
          Song selectedSong = (Song)selectedSongs[i];
          if (Playlist.getInstance().getCurrentSong() == selectedSong) {
            ActionListener listener = Buttons.getInstance().getStopButtonListener();
            if (listener != null) {
              listener.actionPerformed(null);
            }
          }
          Playlist.getInstance().getSongList().remove(selectedSong);
        }
        Playlist.getInstance().updateSongListGui();
      }
   }); 
    
    addComponent(removeButton);
  }

	
  
    private void  addClearPlaylist__wrappee__Playlist  () {
  }

	
  public void addClearPlaylist() {
		if (!specifications.Configuration.clearplaylist) {
			addClearPlaylist__wrappee__Playlist();
			return;
		}
    JButton clearButton = new JButton("Wiedergabeliste l\u00f6schen");
    
    clearButton.setMinimumSize(new Dimension(100, 20));
    clearButton.setMaximumSize(new Dimension(20000, 40));
    clearButton.setBackground(FeatureAmp.getBackgroundColor());
    clearButton.setForeground(FeatureAmp.getForegroundColor());
    
    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ActionListener listener = Buttons.getInstance().getStopButtonListener();
        if (listener != null) {
          listener.actionPerformed(null);
        }
        Playlist.getInstance().getSongList().clear();
        Playlist.getInstance().updateSongListGui();
      }
    });
    
    addComponent(clearButton);
  }

	
  
    private void  addReorderPlaylist__wrappee__Playlist  () {
  }

	
  public void addReorderPlaylist() {
		if (!specifications.Configuration.reorderplaylist) {
			addReorderPlaylist__wrappee__Playlist();
			return;
		}
    JPanel selector = new JPanel();
    
    selector.setBackground(FeatureAmp.getBackgroundColor());

    JButton trackUp   = new JButton("Lied nach oben verschieben");
    JButton trackDown = new JButton("Lied nach unten verschieben");
    
    trackUp.setBackground(FeatureAmp.getBackgroundColor());
    trackUp.setForeground(FeatureAmp.getForegroundColor());
    trackDown.setBackground(FeatureAmp.getBackgroundColor());
    trackDown.setForeground(FeatureAmp.getForegroundColor());
    
    selector.add(trackUp);
    selector.add(trackDown);

    selector.setLayout(new BoxLayout(selector, BoxLayout.LINE_AXIS));
    addComponentTop(selector);

    trackUp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            Object[] selectedSongs = Playlist.getInstance().getList().getSelectedValues();
            
            if (selectedSongs.length == 1) {
              Song selectedSong = (Song)selectedSongs[0];
              
              int id = Playlist.getInstance().getSongList().indexOf(selectedSong);
              
              if (id != 0) {
                Song exchangeSong = Playlist.getInstance().getSongList().get(id-1);
                Playlist.getInstance().getSongList().set(id, exchangeSong);
                Playlist.getInstance().getSongList().set(id-1, selectedSong);
                Playlist.getInstance().updateSongListGui();
                Playlist.getInstance().getList().setSelectedIndex(id-1);
              }
            } else if (selectedSongs.length == 0) {
              JOptionPane.showMessageDialog(new JFrame(), "Es muss erst ein Lied ausgew\u00e4hlt werden!");
            } else {
              JOptionPane.showMessageDialog(new JFrame(), "Es kann nur genau ein Lied ausgew\u00e4hlt sein!");
            }
          }
        });
      }
    });
    
    trackDown.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            Object[] selectedSongs = Playlist.getInstance().getList().getSelectedValues();
            
            if (selectedSongs.length == 1) {
              Song selectedSong = (Song)selectedSongs[0];
              
              int id = Playlist.getInstance().getSongList().indexOf(selectedSong);
              
              if (id != (Playlist.getInstance().getSize()-1)) {
                Song exchangeSong = Playlist.getInstance().getSongList().get(id+1);
                Playlist.getInstance().getSongList().set(id, exchangeSong);
                Playlist.getInstance().getSongList().set(id+1, selectedSong);
                Playlist.getInstance().updateSongListGui();
                Playlist.getInstance().getList().setSelectedIndex(id+1);
              }
            } else if (selectedSongs.length == 0) {
              JOptionPane.showMessageDialog(new JFrame(), "Es muss erst ein Lied ausgew\u00e4hlt werden!");
            } else {
              JOptionPane.showMessageDialog(new JFrame(), "Es kann nur genau ein Lied ausgew\u00e4hlt sein!");
            }
          }
        });
      }
    });
  }

	
  
    private void  addShuffleRepeat__wrappee__Playlist  () {
  }

	
  public void addShuffleRepeat() {
		if (!specifications.Configuration.shufflerepeat) {
			addShuffleRepeat__wrappee__Playlist();
			return;
		}
    JPanel selector = new JPanel();
    
    selector.setBackground(FeatureAmp.getBackgroundColor());

    ButtonGroup repeatGroup = new ButtonGroup();

    JRadioButton repeatOff = new JRadioButton();
    JRadioButton repeatSong = new JRadioButton();
    JRadioButton repeatPlaylist = new JRadioButton();
    
    repeatOff.setBackground(FeatureAmp.getBackgroundColor());
    repeatOff.setForeground(FeatureAmp.getForegroundColor());
    repeatSong.setBackground(FeatureAmp.getBackgroundColor());
    repeatSong.setForeground(FeatureAmp.getForegroundColor());
    repeatPlaylist.setBackground(FeatureAmp.getBackgroundColor());
    repeatPlaylist.setForeground(FeatureAmp.getForegroundColor());
    
    final JCheckBox shuffleMode = new JCheckBox();
    shuffleMode.setBackground(FeatureAmp.getBackgroundColor());
    shuffleMode.setForeground(FeatureAmp.getForegroundColor());

    JButton shuffleButton = new JButton("Wiedergabeliste verw\u00fcrfeln");
    shuffleButton.setBackground(FeatureAmp.getBackgroundColor());
    shuffleButton.setForeground(FeatureAmp.getForegroundColor());

    selector.setLayout(new BoxLayout(selector, BoxLayout.LINE_AXIS));
    addComponentTop(selector);

    repeatGroup.add(repeatOff);
    repeatGroup.add(repeatSong);
    repeatGroup.add(repeatPlaylist);

    repeatOff.setSelected(true);
    shuffleButton.setMinimumSize(new Dimension(100, 20));
    shuffleButton.setMaximumSize(new Dimension(20000, 40));

    shuffleButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            Playlist.getInstance().shufflePlaylist();
          }
        });
      }
    });

    addComponent(shuffleButton);
      
    shuffleMode.setSelected(false);
      
    shuffleMode.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Playlist.getInstance().setShuffleMode(shuffleMode.isSelected());
      }
    });

    JLabel labelRepeat = new JLabel("Wiederholen");
    labelRepeat.setForeground(FeatureAmp.getForegroundColor());
    selector.add(labelRepeat);
    selector.add(repeatOff);
    JLabel labelOff = new JLabel("Aus");
    labelOff.setForeground(FeatureAmp.getForegroundColor());
    selector.add(labelOff);
    selector.add(repeatSong);
    JLabel labelSong = new JLabel("Lied"); 
    labelSong.setForeground(FeatureAmp.getForegroundColor());
    selector.add(labelSong);
    selector.add(repeatPlaylist);
    JLabel labelPlaylist = new JLabel("Wiedergabeliste");
    labelPlaylist.setForeground(FeatureAmp.getForegroundColor());
    selector.add(labelPlaylist);
          
    JPanel separator = new JPanel();
    separator.setMinimumSize(new Dimension(50, 20));
    separator.setMaximumSize(new Dimension(100, 40));
    separator.setBackground(FeatureAmp.getBackgroundColor());
    selector.add(separator);

    JLabel labelRandom = new JLabel("Zufallsmodus:");
    labelRandom.setForeground(FeatureAmp.getForegroundColor());
    selector.add(labelRandom);
    selector.add(shuffleMode);

    RepeatListener repeatListenerOff = new RepeatListener(0);
    RepeatListener repeatListenerSong = new RepeatListener(1);
    RepeatListener repeatListenerPlaylist = new RepeatListener(2);

    repeatOff.addActionListener(repeatListenerOff);
    repeatSong.addActionListener(repeatListenerSong);
    repeatPlaylist.addActionListener(repeatListenerPlaylist);
  }

	
  
  public static PlaylistButtons getInstance() {
    return playlistButtonsInstance;
  }

	
  private JButton loadButton = new JButton("Ordner laden");

	
  
  public  class  RepeatListener  implements ActionListener {
		
    private short repeatMode;

		

    protected RepeatListener(int repeatModeIn) {
		if (specifications.Configuration.shufflerepeat) {
	      repeatMode = (short)repeatModeIn;
	    		}
	}

		

    public void actionPerformed(ActionEvent e) {
      FeatureAmp.setRepeatMode(repeatMode);
    }


	}


}
