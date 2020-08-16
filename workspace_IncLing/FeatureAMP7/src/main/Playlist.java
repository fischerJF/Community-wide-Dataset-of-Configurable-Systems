package main; 

import java.awt.Dimension; 
import java.util.*; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 

import javax.swing.*; 

import main.FeatureAmp; 
import main.OpenFile; 
import main.Song; 

import java.io.*; 
import java.util.ArrayList; 
import java.util.Collections; 
import main.QueueTrack; 

public   class  Playlist {
	
  public static Playlist playlistInstance = new Playlist();

	
  
  private JFrame frame;

	
  private JList list;

	
  
  private ArrayList<Song> songList;

	
  
  private Song currentSong = null;

	
  
  private boolean shuffleMode = false;

	

  private Playlist () {
		if (specifications.Configuration.playlist) {
	    frame = new JFrame();
	       
	    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    
	    frame.setTitle("FeatureAmp - Playlist");
	    frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
	
	    songList = new ArrayList<Song>();
	    list = new JList(songList.toArray());
	    list.setBackground(FeatureAmp.getBackgroundColor());
	    
	    FeatureAmp.setList(songList);
	
	    list.setCellRenderer(new SongCellRenderer());
	   
	   // list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    JScrollPane listScroller = new JScrollPane(list);
	    listScroller.setPreferredSize(new Dimension(250, 80));
	    
	    list.addMouseListener(new MouseAdapter() {
	      public void mousePressed(MouseEvent e) {
	        if (e.getClickCount() == 2 && !e.isConsumed()) {
	          e.consume();
	          Song selectedSong = (Song)list.getSelectedValue();        
	          OpenFile.getInstance().createPlayer(selectedSong.getType(), selectedSong.getFilename(), false);
	          currentSong = selectedSong;
	          list.repaint();
	        }
	      }
	    });
	
	    frame.setSize(1100, 400);
	    
	    frame.add(listScroller);
	    
	    frame.add(PlaylistButtons.getInstance());
	
	    frame.setVisible(true);
	  		}
	}

	
  
  public void shufflePlaylist() {
    Collections.shuffle(songList);
    list.setListData(songList.toArray());
  }

	
  
   private void  nextSong__wrappee__Playlist  () {
    Song newSong;
    int songNr;
    
    if (shuffleMode) {
      Random random = new Random();
      songNr = random.nextInt(getSize());
    } else if (songList.contains(currentSong)) {
      songNr = songList.indexOf(currentSong);
        
      if ( songNr == (songList.size()-1) ) {
        if (FeatureAmp.getRepeatMode() == 2) {
          songNr = 0;
        } else {
          return;
        }
      } else {
        songNr++;
      }
    } else {
      if (songList.size() != 0) {
        songNr = 0;
      } else {
        return;
      }
    }
    newSong = (Song)songList.get(songNr);
    
    OpenFile.getInstance().createPlayer(newSong.getType(), newSong.getFilename(), false);
    currentSong = newSong;
    list.repaint();
  }

	
  public void nextSong() {
		if (!specifications.Configuration.queuetrack) {
			nextSong__wrappee__Playlist();
			return;
		}   
    if (QueueTrack.getInstance().songsAvailable()) {
      Song newSong = QueueTrack.getInstance().consumeSong();
      
      OpenFile.getInstance().createPlayer(newSong.getType(), newSong.getFilename(), false);
      currentSong = newSong;
      list.repaint();
    } else {
      nextSong__wrappee__Playlist();
    }
  }

	
  
  public void addSong(Song song) {
    songList.add(song);
    list.setListData(songList.toArray());
  }

	
  
  public void addSingleSong(Song song) {
    currentSong = song;
    addSong(song);
    currentSong = song;
  }

	
  
  public Song getCurrentSong() {
    return currentSong;
  }

	
  
  public int getSize() {
    return songList.size();
  }

	
  
  public void setShuffleMode(boolean newMode) {
    shuffleMode = newMode;
  }

	
  
  public ArrayList<Song> getSongList() {
    return songList;
  }

	
  
  public JList getList() {
    return list;
  }

	
  
  public void updateSongListGui() {
    list.setListData(songList.toArray());
  }

	
  
  public void repaintPlaylist() {
    frame.repaint();
  }

	

  public static Playlist getInstance() {
    return playlistInstance;
  }

	
  public void addFolder(String folderIn) {
    ArrayList<Song> newSongs = new ArrayList<Song>();
    String file;
    File folder = new File(folderIn);
    File[] listOfFiles = folder.listFiles();
    
    if (!folderIn.substring(folderIn.length()-1).equals("/")) {
      folderIn += "/";
    }

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        file = listOfFiles[i].getName();
        Song newSong = OpenFile.getInstance().parseFile(folderIn + file);
        if (newSong != null) {
          newSongs.add(newSong);
        }
      }
    }
    
    Comparator<Song> sortSongs = new Comparator<Song>() {
      public int compare (Song arg0, Song arg1) {
        if (arg0.getTrackNr() < arg1.getTrackNr()) {
          return -1;
        } else if (arg0.getTrackNr() > arg1.getTrackNr()) {
          return 1;
        } else {
          return 0;
        }
      }
    };
    
    int oldPlaylistSize = getSize();
    
    Collections.sort(newSongs, sortSongs);
       
    songList.addAll(newSongs);
    list.setListData(songList.toArray());
    
    if (oldPlaylistSize == 0 && getSize() != 0) {
      Song playSong = newSongs.get(0);
      
      OpenFile.getInstance().createPlayer(playSong.getType(), playSong.getFilename(), false);
      currentSong = playSong;
      list.repaint();
    }
  }


}
