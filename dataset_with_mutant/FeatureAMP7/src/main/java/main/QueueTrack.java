package main; 

import java.awt.Dimension; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.ArrayList; 

import javax.swing.BoxLayout; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JList; 
import javax.swing.JOptionPane; 
import javax.swing.JScrollPane; 
import javax.swing.SwingUtilities; 

import main.FeatureAmp; 
import main.Playlist; 
import main.PlaylistButtons; 
import main.Song; 

public  class  QueueTrack {
	
  private static QueueTrack instance = new QueueTrack();

	
  
  private JFrame frame;

	
  
  private JList list;

	
  private ArrayList<Song> songList;

	
  
  private QueueTrack() {
		if (specifications.Configuration.queuetrack) {
	    frame = new JFrame();
	    
	    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    
	    frame.setTitle("FeatureAmp - TrackQueue");
	    frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
	    
	    songList = new ArrayList<Song>();
	    list = new JList(songList.toArray());
	    list.setBackground(FeatureAmp.getBackgroundColor());
	    
	    list.setCellRenderer(new QueueSongCellRenderer());
	    
	    JScrollPane listScroller = new JScrollPane(list);
	    listScroller.setPreferredSize(new Dimension(250, 80));
	    
	    /*list.addMouseListener(new MouseAdapter() {
	      public void mousePressed(MouseEvent e) {
	        if (e.getClickCount() == 2 && !e.isConsumed()) {
	          e.consume();
	          Song selectedSong = (Song)list.getSelectedValue();        
	          /*OpenFile.getInstance().createPlayer(selectedSong.getType(), selectedSong.getFilename(), false);
	          currentSong = selectedSong;
	          list.repaint();* /
	        }
	      }
	    });*/
	
	    frame.setSize(600, 400);
	
	    frame.add(listScroller);
	
	    //frame.add(PlaylistButtons.getInstance());
	
	    frame.setVisible(true);
	    
	    JButton trackQueueButton = new JButton("Lied in/aus Queue");
	    trackQueueButton.setBackground(FeatureAmp.getBackgroundColor());
	    trackQueueButton.setForeground(FeatureAmp.getForegroundColor());
	
	    trackQueueButton.setMinimumSize(new Dimension(100, 20));
	    trackQueueButton.setMaximumSize(new Dimension(20000, 40));
	
	    trackQueueButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        SwingUtilities.invokeLater(new Runnable() {
	          public void run() {
	            Object[] selectedSongs = Playlist.getInstance().getList().getSelectedValues();
	            
	            if (selectedSongs.length == 1) {
	              Song selectedSong = (Song)selectedSongs[0];
	              
	              if (songList.indexOf(selectedSong) == -1) {
	                songList.add(selectedSong);
	              } else {
	                songList.remove(selectedSong);
	              }
	              updateSongListGui();
	            } else if (selectedSongs.length == 0) {
	              JOptionPane.showMessageDialog(new JFrame(), "Es muss erst ein Lied ausgew\u00e4hlt werden!");
	            } else {
	              JOptionPane.showMessageDialog(new JFrame(), "Es kann nur genau ein Lied ausgew\u00e4hlt sein!");
	            }
	          }
	        });
	      }
	    });
	
	    PlaylistButtons.getInstance().addComponent(trackQueueButton);
	  		}
	}

	
  
  public Song consumeSong() {
    Song out = songList.get(0);

    songList.remove(0);
    updateSongListGui();

    return out;
  }

	
  
  public boolean songsAvailable() {
    return (songList.size() > 0);
  }

	
  
  public void updateSongListGui() {
    list.setListData(songList.toArray());
  }

	
  
  public static QueueTrack getInstance() {
    return instance;
  }


}
