package main; 

import java.awt.*; 

import java.util.*; 

import java.awt.event.*; 
import javax.swing.*; 

import main.FeatureAmp; 

import engine.PlayerInterface; 

import main.VolumeControl;
import specifications.Configuration;

import java.awt.MenuItem; 
import main.OpenFile; 

import java.util.Observer; 

import main.ProgressBar; 
import main.OpenDirectory; 
import main.Playlist; 
import main.PlaylistNewInfoObserv; 
import main.PlaylistNewSongObserv; 
import main.PlaylistEndTrackObserv; 
import main.QueueTrack; 
import main.Song; 

import java.awt.Color; 

import main.CoverPane; 
import main.ShowCoverNewInfoObserv; 

public   class  FeatureAmp {
	
  // The main frame of the GUI
  private static JFrame frame;

	
  private static int height = 0;

	
  private static short repeatState = 0;

	
  private static ArrayList<Song> list = null;

	
  private static PlayerInterface currentPlayer;

	
  private static String titleToSet = "FeatureAmp";

	
  private static long currentTime;

	
  
  private static ObserverUtil newSongObserv = new ObserverUtil();

	
  private static ObserverUtil newTimeObserv = new ObserverUtil();

	
  private static ObserverUtil newInfoObserv = new ObserverUtil();

	
  private static ObserverUtil endTrackObserv = new ObserverUtil();

	
  
  // Create the file menu
  public static Menu fileMenu = new Menu("Datei");

  public static JPanel buttonPanel;
  
  /**
   * The main method creates the GUI
   * @param args The default args
   */
  public static void main(String[] args) {
   
	  
//	  Configuration.openwavfile=true;
//		Configuration.volumecontrol=true;
//		Configuration.skiptrack=true;
//		Configuration.mp3player=true;
//		Configuration.removetrack=true;
//		Configuration.time=true;
//		Configuration.changeplaylist=true;
//		Configuration.openmp3file=true;
//		Configuration.reorderplaylist=true;
//		Configuration.playlist=true;
//		Configuration.light=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.gui=true;
//		Configuration.audioformats=true;
//		Configuration.featureamp=true;
//		Configuration.queuetrack=true;
//		Configuration.mute=true;
//		Configuration.progressbar=true;
//		Configuration.showtime=true;
//		Configuration.showtitle=true;
//		Configuration.wavplayer=true;
//		Configuration.loadfolder=true;
//		Configuration.showcover=true;
//		Configuration.shufflerepeat=true;
//		Configuration.skins=true;
//		Configuration.orangebluest=true;
//		Configuration.dark=true;
//		Configuration.openfile=true;
//		Configuration.clearplaylist=true;
	  Configuration.gui=true;
	  Configuration.audioformats=true;
	  Configuration.wavplayer=true;
	  Configuration.openwavfile=true;
	  Configuration.openfile=true;
	  Configuration.time=true;
	  Configuration.skins=true;
	  Configuration.light=true;
	  Configuration.playlist=true;
	  Configuration.loadfolder=true;
	  
	  run();
	 
  }
  public static void run() {
	  frame = new JFrame();
	  fileMenu.setName("file");
	    addOpenFileMenu(fileMenu);
	    
	    MenuItem exitItem = new MenuItem("Beenden");
	    exitItem.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        FeatureAmp.close();
	      }
	    });
	     
	    MenuBar menubar = new MenuBar();
	    menubar.add(fileMenu);
	    
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        FeatureAmp.close();
	      }
	    });
	    
	    frame.setTitle("FeatureAmp");
	    frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
	    
	    frame.setMenuBar(menubar);
	    
	   buttonPanel = Buttons.getInstance();
	    
	    height += 90;
	      
	    addCover();
	    addVolBar();
	    addProgBar();
	    
	    addShowTitle();
	    addShowTime();
	    
	    addSaveAndLoadPlaylist();
	    
	    fileMenu.add(exitItem);
	    
	    frame.add(buttonPanel);
	    
	    frame.setBackground(getBackgroundColor());
	    
	    frame.setSize(600, height);

	    frame.setVisible(true);
	    
	    addQueueTrack();
	    addPlaylist();
  }

	
  
  /**
   * Update the information about the current position within the sound file
   * @param time The new position
   */
  public static void updateTime (long time) {
    currentTime = time;
  }

	
  
  /**
   * Exit the complete player and also the GUI (everything!)
   */
  public static void close() {
    if (currentPlayer != null) {
      currentPlayer.cmdStop();
      currentPlayer.cmdClose();
    }
    System.exit(0);
  }

	
  
  public static void setPlayer(PlayerInterface player) {
    if (currentPlayer != null) {
      if (currentPlayer.getPlayerStatus() != PlayerInterface.STATUS_FINISHED) {
        currentPlayer.cmdClose();
      }
    }
    currentPlayer = player;
  }

	
  
  public static void setRepeatMode(short repeatStateIn) {
    repeatState = repeatStateIn;
  }

	
  
  public static ArrayList<Song> getList() {
    return list;
  }

	
  
  public static void setList(ArrayList<Song> newList) {
    list = newList;
  }

	
  
  public static short getRepeatMode() {
    return repeatState;
  }

	
  
  public static void addToMenu(MenuItem newItem) {
    fileMenu.add(newItem);
  }

	
  
  public static void addComponent(JComponent newComponent) {
    frame.add(newComponent);
  }

	
  
  public static JFrame getFrame() {
    return frame;
  }

	
  
  public static ObserverUtil getNewSongObserv() {
    return newSongObserv;
  }

	
  
  public static ObserverUtil getNewTimeObserv() {
    return newTimeObserv;
  }

	
  
  public static ObserverUtil getNewInfoObserv() {
    return newInfoObserv;
  }

	
  
  public static ObserverUtil getEndTrackObserv() {
    return endTrackObserv;
  }

	
  
  public static long getCurrentTime() {
    return currentTime;
  }

	
  
  public static String getTitleToSet() {
    return titleToSet;
  }

	
  
  public static void setTitleToSet(String newTitle) {
    titleToSet = newTitle;
    frame.setTitle(newTitle);
  }

	
  
  public static void incHeight(int addHeight) {
    height += addHeight;
  }

	
  
   private static void  addCover__wrappee__GUI  () {
  }

	

  public static void addCover() {
		if (!specifications.Configuration.showcover) {
			addCover__wrappee__GUI();
			return;
		}
    coverPane = new CoverPane(getFrame());
    coverPane.setBackground(getBackgroundColor());
    incHeight(300);
    
    addComponent(coverPane);
    
    Observer coverObserver = new ShowCoverNewInfoObserv(coverPane);
    getNewInfoObserv().addObserver(coverObserver);
  }

	
   private static void  addSaveAndLoadPlaylist__wrappee__GUI  () {
  }

	
  public static void addSaveAndLoadPlaylist() {
		if (!specifications.Configuration.saveandloadplaylist) {
			addSaveAndLoadPlaylist__wrappee__GUI();
			return;
		}
    MenuItem saveItem = new MenuItem("Wiedergabeliste speichern");
    saveItem.addActionListener(new SavePlaylistListener());
    addToMenu(saveItem);
    
    MenuItem loadItem = new MenuItem("Wiedergabeliste laden");
    loadItem.addActionListener(new LoadPlaylistListener());
    addToMenu(loadItem);
  }

	
   private static void  addVolBar__wrappee__GUI  () {
  }

	
  
  public static void addVolBar() {
		if (!specifications.Configuration.volumecontrol) {
			addVolBar__wrappee__GUI();
			return;
		}
    volumeBar = VolumeControl.getInstance();
    incHeight(20);
    addComponent(volumeBar);
  }

	
   private static void  addProgBar__wrappee__GUI  () {
  }

	
  
  public static void addProgBar() {
		if (!specifications.Configuration.progressbar) {
			addProgBar__wrappee__GUI();
			return;
		}      
    progBar = new ProgressBar();
    incHeight(20);
    addComponent(progBar);
    
    Observer timeObserver = new ProgressBarObserv(progBar);
    FeatureAmp.getNewTimeObserv().addObserver(timeObserver);
    FeatureAmp.getNewInfoObserv().addObserver(timeObserver);
  }

	
   private static void  addShowTitle__wrappee__GUI  () {
  }

	
  public static void addShowTitle() {
		if (!specifications.Configuration.showtitle) {
			addShowTitle__wrappee__GUI();
			return;
		}
    Observer infoObserver = new ShowTitleObserv();
    FeatureAmp.getNewInfoObserv().addObserver(infoObserver);
  }

	
   private static void  addShowTime__wrappee__GUI  () {
  }

	
  public static void addShowTime() {
		if (!specifications.Configuration.showtime) {
			addShowTime__wrappee__GUI();
			return;
		}
    Observer timeObserver = new ShowTimeObserv();
    getNewTimeObserv().addObserver(timeObserver);
    getNewInfoObserv().addObserver(timeObserver);
  }

	
   private static void  addPlaylist__wrappee__GUI  () {
  }

	
  public static void addPlaylist() {
		if (!specifications.Configuration.playlist) {
			addPlaylist__wrappee__GUI();
			return;
		}
    Playlist.getInstance();
    
    Observer infoObserver = new PlaylistNewInfoObserv();
    getNewInfoObserv().addObserver(infoObserver);
    
    Observer newSongObserver = new PlaylistNewSongObserv();
    getNewSongObserv().addObserver(newSongObserver);
    
    Observer endTrackObserver = new PlaylistEndTrackObserv();
    getEndTrackObserv().addObserver(endTrackObserver);
    
    MenuItem openItem = new MenuItem("Ordner \u00f6ffnen");
    openItem.addActionListener(OpenDirectory.getInstance());
    addToMenu(openItem);
  }

	
   private static void  addQueueTrack__wrappee__GUI  () {
  }

	
  public static void addQueueTrack() {
		if (!specifications.Configuration.queuetrack) {
			addQueueTrack__wrappee__GUI();
			return;
		}
    QueueTrack.getInstance();
  }

	
  
  public static Color getBackgroundColor() {
    return currentBackgroundColor;
  }

	
  
  public static Color getForegroundColor() {
    return currentForegroundColor;
  }

	
  private static VolumeControl volumeBar;

	
  public static void addOpenFileMenu(Menu fileMenu) {
    MenuItem openItem = new MenuItem("Datei \u00f6ffnen");
    openItem.addActionListener(OpenFile.getInstance());
    fileMenu.add(openItem);
  }

	
  private static ProgressBar progBar;

	
  // Ford Racing Orange
  private static Color currentBackgroundColor = new Color(241, 111,  33);

	
  // Ford National Blue
  private static Color currentForegroundColor = new Color( 11,  59, 121);

	
  private static CoverPane coverPane;


}
