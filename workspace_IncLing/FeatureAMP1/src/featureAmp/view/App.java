package featureAmp.view; 

import java.awt.BorderLayout; 

import java.awt.Color; 
import java.awt.Component; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.IOException; 
import java.util.concurrent.Executors; 
import java.util.concurrent.TimeUnit; 

import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

import javax.swing.Box; 

import javax.swing.JButton; 

import javax.swing.JFileChooser; 
import javax.swing.JFrame; 
import javax.swing.JMenu; 
import javax.swing.JMenuBar; 
import javax.swing.JMenuItem; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.WindowConstants; 
import javax.swing.filechooser.FileNameExtensionFilter; 

import featureAmp.Extensions; 

import featureAmp.MusicFileFactory; 

import featureAmp.MusicFileWrapper; 
import featureAmp.Util; 
import featureAmp.engine.MP3Player; 

import featureAmp.view.VolumeSlider; 

import javax.swing.JToggleButton; 

import java.awt.Image; 
import java.io.File; 

import javax.swing.ImageIcon; 
import javax.swing.JLabel; 
import featureAmp.Resources; 

import javax.swing.JProgressBar; 
import javax.swing.JScrollPane; 
import featureAmp.view.PlaylistHandler; 

import featureAmp.FileNameFilter; 
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.FileReader; 
import java.util.List; 

import featureAmp.view.PlayMode; 


public   class  App {
	
	
	private JButton play;

	
	private JButton stop;

	
	private JButton pause;

	
	private JFrame frame;

	
	private JPanel controlPanel;

	
	private Box lowerCentralArea;

	
	private Box upperCentralArea;

	
	
	private MP3Player player;

	
	private MusicFileWrapper currentFile;

	
	
	private volatile long songLength;

	
	
	private boolean timeWorkerRunning;

	
	private Runnable timeWorker = new Runnable() {
		
		@Override
		public void run() {
			long position = player.getPositionInSeconds();
			String timeString = new StringBuilder(Util.formatTime(position)).append("/")
					.append(Util.formatTime(songLength)).toString();
			
			doTimework(position, timeString);
		}
	};

	
	
	private ActionListener singleFileLoader = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Audio Files", Extensions.extensions);
		    chooser.setFileFilter(filter);
		    chooser.setMultiSelectionEnabled(false);
		    chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
		    int returnVal = chooser.showOpenDialog(frame);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
	            try {
	            	MusicFileWrapper file = MusicFileFactory.createMusicFile(chooser.getSelectedFile());
					notifyFileSelected(file);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}
	            
		    }
		}
	};

	
	
	//can be refined by playlist feature
	 private void  notifyFileSelected__wrappee__Base  (MusicFileWrapper file){
		play(file);
	}

	
	
	private void notifyFileSelected(MusicFileWrapper file){
		if (!specifications.Configuration.playlist) {
			notifyFileSelected__wrappee__Base(file);
			return;
		}
		this.playlistHandler.addSong(file);
	}

	
	
	
	public App(){
		if (specifications.Configuration.base) {
			initGui();
			frame.setVisible(true);
			frame.setSize(1200, 600);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			initListeners();
		}
	}

	

	 private void  initGui__wrappee__Base  (){
		Box verticalBox = Box.createVerticalBox();
		this.upperCentralArea = Box.createHorizontalBox();
		this.lowerCentralArea = Box.createHorizontalBox();
		
		
		this.play = new JButton("Play");
		this.play.setName("play");
		this.pause = new JButton("Pause");
		this.pause.setName("pause");
		this.stop = new JButton("Stop");
		this.stop.setName("stop");
		this.controlPanel = new JPanel();
		controlPanel.add(play);
		controlPanel.add(pause);
		controlPanel.add(stop);
		
		verticalBox.add(Box.createVerticalStrut(10));
		verticalBox.add(lowerCentralArea);
		verticalBox.add(controlPanel);
		
		this.frame = new JFrame("FeatureAmp");
		this.frame.setLayout(new BorderLayout());
		this.frame.add(upperCentralArea, BorderLayout.CENTER);
		this.frame.add(verticalBox, BorderLayout.PAGE_END);
		Component b1 = Box.createVerticalStrut(10);
		Component b2 = Box.createHorizontalStrut(10);
		Component b3 = Box.createHorizontalStrut(10);
		this.frame.add(b1, BorderLayout.PAGE_START);
		this.frame.add(b2, BorderLayout.WEST);
		this.frame.add(b3, BorderLayout.EAST);
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadFileMenuItem = new JMenuItem("Load File");
		loadFileMenuItem.addActionListener(this.singleFileLoader);
		
		fileMenu.add(loadFileMenuItem);
		
		menuBar.add(fileMenu);
		
		frame.setJMenuBar(menuBar);
		
	}

	
	  private void  initGui__wrappee__Resizable  (){
		if (!specifications.Configuration.resizable) {
			initGui__wrappee__Base();
			return;
		}
		initGui__wrappee__Base();
		this.frame.setResizable(true);
	}

	
	
	 private void  initGui__wrappee__VolumeControl() {
		if (!specifications.Configuration.volumecontrol) {
			initGui__wrappee__Resizable();
			return;
		}
		initGui__wrappee__Resizable();
		this.volumeSlider = new VolumeSlider();
		this.controlPanel.add(volumeSlider);
	}

	
	
	 private void  initGui__wrappee__Mute() {
		if (!specifications.Configuration.mute) {
			initGui__wrappee__VolumeControl();
			return;
		}
		initGui__wrappee__VolumeControl();
		this.mute = new JToggleButton("Mute");
		this.mute.setName("mute");
		this.controlPanel.add(mute);
		this.mute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(player != null){
					player.setMute(mute.isSelected());
				}
			}
		});
	}

	
	
	 private void  initGui__wrappee__ShowCover  () {
		if (!specifications.Configuration.showcover) {
			initGui__wrappee__Mute();
			return;
		}
		initGui__wrappee__Mute();
		this.imagePanel = new JLabel(new ImageIcon(Resources.FEATURE_IMAGE));
		this.upperCentralArea.add(imagePanel);
	}

	
	
	 private void  initGui__wrappee__ProgressBar  () {
		if (!specifications.Configuration.progressbar) {
			initGui__wrappee__ShowCover();
			return;
		}
		initGui__wrappee__ShowCover();
		this.progressBar.setStringPainted(true);
		this.lowerCentralArea.add(progressBar);
	}

	
	
	 private void  initGui__wrappee__Light  () {
		if (!specifications.Configuration.light) {
			initGui__wrappee__ProgressBar();
			return;
		}
		initGui__wrappee__ProgressBar();
		setSkinColor(Color.WHITE);
	}

	
	
	 private void  initGui__wrappee__Dark  () {
		if (!specifications.Configuration.dark) {
			initGui__wrappee__Light();
			return;
		}
		initGui__wrappee__Light();
		setSkinColor(Color.darkGray);
	}

	
	
	 private void  initGui__wrappee__Playlist  (){
		if (!specifications.Configuration.playlist) {
			initGui__wrappee__Dark();
			return;
		}
		initGui__wrappee__Dark();
		this.playlistHandler = new PlaylistHandler(this);
		this.upperCentralArea.add(new JScrollPane(playlistHandler.getPlaylist()));
		playlistButtons.setBackground(Color.BLACK);
		this.upperCentralArea.add(playlistButtons);
	}

	
	
	  private void  initGui__wrappee__LoadFolder  (){
		if (!specifications.Configuration.loadfolder) {
			initGui__wrappee__Playlist();
			return;
		}
		initGui__wrappee__Playlist();
		JMenuItem loadFolderMenuItem = new JMenuItem("Load Folder");
		loadFolderMenuItem.addActionListener(folderLoader);
		JMenuBar bar = this.frame.getJMenuBar();
		bar.getMenu(0).add(loadFolderMenuItem);
	}

	
	
	 private void  initGui__wrappee__SaveAndLoadPlaylist  () {
		if (!specifications.Configuration.saveandloadplaylist) {
			initGui__wrappee__LoadFolder();
			return;
		}
		initGui__wrappee__LoadFolder();
		JMenu playlist = new JMenu("Playlists");
		loadMenu.addActionListener(loadListener);
		saveMenu.addActionListener(saveListener);
		playlist.add(loadMenu);
		playlist.add(saveMenu);
		frame.getJMenuBar().add(playlist);
	}

	
	
	 private void  initGui__wrappee__SkipTrack  (){
		if (!specifications.Configuration.skiptrack) {
			initGui__wrappee__SaveAndLoadPlaylist();
			return;
		}
		initGui__wrappee__SaveAndLoadPlaylist();
		skipTrack.addActionListener(listner);
		skipTrack.setName("skiptrack");
		controlPanel.add(skipTrack);
	}

	
	
	 private void  initGui__wrappee__RemoveTrack  () {
		if (!specifications.Configuration.removetrack) {
			initGui__wrappee__SkipTrack();
			return;
		}
		initGui__wrappee__SkipTrack();
		this.remove.addActionListener(removelistener);
		this.remove.setName("remove");
		playlistButtons.add(remove);
	}

	
	
	 private void  initGui__wrappee__ClearPlaylist  () {
		if (!specifications.Configuration.clearplaylist) {
			initGui__wrappee__RemoveTrack();
			return;
		}
		initGui__wrappee__RemoveTrack();
		this.clear.addActionListener(clearlistener);
		this.clear.setName("clear");
		playlistButtons.add(clear);
	}

	

	
	 private void  initGui__wrappee__ShuffleRepeat  (){
		if (!specifications.Configuration.shufflerepeat) {
			initGui__wrappee__ClearPlaylist();
			return;
		}
		initGui__wrappee__ClearPlaylist();
		this.playModeButton = new JButton(this.mode.toString());
		this.playModeButton.setName("playModeButton");
		this.playModeButton.addActionListener(modeListener);
		JLabel label = new JLabel("Playmode: ");
		label.setForeground(Color.GRAY);
		controlPanel.add(label);
		controlPanel.add(playModeButton);
	}

	
	
	 private void  initGui__wrappee__ReorderPlaylist  () {
		if (!specifications.Configuration.reorderplaylist) {
			initGui__wrappee__ShuffleRepeat();
			return;
		}
		initGui__wrappee__ShuffleRepeat();
		up.addActionListener(upListener);
		up.setName("up");
		down.addActionListener(downListener);
		down.setName("down");
		playlistButtons.add(up);
		playlistButtons.add(down);
	}

	
	
	public void  initGui() {
		if (!specifications.Configuration.queuetrack) {
			initGui__wrappee__ReorderPlaylist();
			return;
		}
		initGui__wrappee__ReorderPlaylist();
		addToQueue.addActionListener(addToQueueListener);
		addToQueue.setName("addToQueue");
		removeFromQueue.addActionListener(removeFromQueueListener);
		removeFromQueue.setName("removeFromQueue");
		playlistButtons.add(addToQueue);
		playlistButtons.add(removeFromQueue);
		upperCentralArea.add(new JScrollPane(playlistHandler.queue));
	}

	
	
	 private void  play__wrappee__Base  (MusicFileWrapper file) {
		if(player != null){
			player.close();
		}
		try {
			if(currentFile != null){
				currentFile.setPlaying(false);
			}
			currentFile = file;
			player = new MP3Player(file.getFilePath());
			player.play();
			currentFile.setPlaying(true);
			songLength = player.getLength();
			scheduleTitleWorker();
		} catch (LineUnavailableException e) {
			JOptionPane.showMessageDialog(frame, "Line Unavailable!");
		} catch (UnsupportedAudioFileException e) {
			JOptionPane.showMessageDialog(frame, "Unsupported Audio File!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Unsupported Audio File!");
		}
	}

	
	
	 private void  play__wrappee__VolumeControl  (MusicFileWrapper file){
		if (!specifications.Configuration.volumecontrol) {
			play__wrappee__Base(file);
			return;
		}
		play__wrappee__Base(file);
		volumeSlider.setVolumeControl(player.getVolumeControl());
		volumeSlider.setName("volumeSlider");
	}

	
	
	  private void  play__wrappee__ShowCover  (MusicFileWrapper file){
		if (!specifications.Configuration.showcover) {
			play__wrappee__VolumeControl(file);
			return;
		}
		play__wrappee__VolumeControl(file);
		drawImage();
	}

	
	
	 private void  play__wrappee__ShowTime  (MusicFileWrapper file){
		if (!specifications.Configuration.showtime) {
			play__wrappee__ShowCover(file);
			return;
		}
		play__wrappee__ShowCover(file);
		artist = currentFile.getArtist();
		titel = currentFile.getTitle();
	}

	
	
	public void play(MusicFileWrapper file){
		if (!specifications.Configuration.playlist) {
			play__wrappee__ShowTime(file);
			return;
		}
		play__wrappee__ShowTime(file);
		this.playlistHandler.update(player, file);
	}

	

	private void initListeners(){
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(player == null){
					return;
				}
				player.play();
			}
		});
		
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(player == null){
					return;
				}
				player.stop();
			}
		});
		
		pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(player == null){
					return;
				}
				player.pause();
			}
		});
		
		
	}

	

	public void setTitle(String title) {
		this.frame.setTitle(title);
	}

	

	public JFrame getFrame() {
		return this.frame;
	}

	

	public void stop() {
		this.currentFile = null;
		if (this.player != null) {
			this.player.close();
		}
		this.player = null;
	}

	

	public void setSkinColor(Color color){
		for(Component c: frame.getContentPane().getComponents()){
			c.setBackground(color);
			c.setForeground(color);
		}
		this.frame.getContentPane().setBackground(color);
		this.frame.getContentPane().setForeground(color); 
		this.frame.setBackground(color);
		this.frame.setForeground(color);
		this.controlPanel.setBackground(color);
		this.controlPanel.setForeground(color);
		this.upperCentralArea.setBackground(color);
		this.upperCentralArea.setForeground(color);
		this.lowerCentralArea.setBackground(color);
		this.lowerCentralArea.setForeground(color);
		
	}

	
	
	 private void  doTimework__wrappee__Base  (long position, String timeString){
		// refined by Time features
	}

	

	 private void  doTimework__wrappee__ShowTime  (long position, String timeString){
		if (!specifications.Configuration.showtime) {
			doTimework__wrappee__Base(position, timeString);
			return;
		}
		String frameTitle = new StringBuilder(titel).append(" ")
				.append(artist).append(" ").append(timeString).toString();
		frame.setTitle(frameTitle);
	}

	
	
	private void doTimework(long position, String timeString){
		if (!specifications.Configuration.progressbar) {
			doTimework__wrappee__ShowTime(position, timeString);
			return;
		}
		doTimework__wrappee__ShowTime(position, timeString);
		int progress = (int) ((double)position / (double)songLength * 100);
		progressBar.setValue(progress);
		progressBar.setName("progress_bar");
		progressBar.setString(timeString);
	}

	
	
	private void scheduleTitleWorker(){
		if (!timeWorkerRunning) {
			Executors.newSingleThreadScheduledExecutor()
					.scheduleAtFixedRate(timeWorker, 0, 200,
							TimeUnit.MILLISECONDS);
			timeWorkerRunning = true;
		}
	}

	
	private VolumeSlider volumeSlider;

	

	private JToggleButton mute;

	
	private JLabel imagePanel;

	
	
	private void drawImage(){
		byte[] image = currentFile.getImage();
		ImageIcon imageIcon;
		if(image.length > 0){
			imageIcon = new ImageIcon(currentFile.getImage());
		}
		else{
			imageIcon = new ImageIcon(Resources.FEATURE_IMAGE);
		}
		Image scaled = imageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_FAST);
		imageIcon.setImage(scaled);
		imagePanel.setIcon(imageIcon);
	}

	
	
	private volatile String artist;

	
	private volatile String titel;

	
	
	private JProgressBar progressBar = new JProgressBar();

	

	
	private PlaylistHandler playlistHandler;

	
	private Box playlistButtons = Box.createVerticalBox();

	
	
private ActionListener folderLoader = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = chooser.showOpenDialog(frame);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	File[] files = chooser.getSelectedFile().listFiles(new FileNameFilter());
		    	if(files.length <= 0){
		    		JOptionPane.showMessageDialog(frame, "No Audiofiles found");
		    	}
		    	for (File path : files) {
	    			MusicFileWrapper file = null;
					try {
						file = MusicFileFactory.createMusicFile(path);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage());
					}
	            	playlistHandler.addSong(file);
				}
		    }
		}
	};

	
	
	private JMenuItem loadMenu = new JMenuItem("load playlist");

	
	private JMenuItem saveMenu = new JMenuItem("save playlist");

	
	
	private ActionListener loadListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "M3U Files", "m3u");
		    chooser.setFileFilter(filter);
		    chooser.setMultiSelectionEnabled(false);
		    chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
		    int returnVal = chooser.showOpenDialog(frame);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	playlistHandler.getModel().clear();
		    	BufferedReader br = null;
	            try {
	            	br = new BufferedReader(new FileReader(chooser.getSelectedFile()));
	            	String path = "";
	            	while(path != null){
	            		path = br.readLine();
	            		File file = new File(path);
	            		if (path != null && file.canRead()) {
							playlistHandler.addSong(MusicFileFactory.createMusicFile(file));
						}
	            	}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}	
	            finally{
	            	try {
						br.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(frame, "Error while loading playlist");
					}
	            }
		    }
		}
	};

	
	
	private ActionListener saveListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "M3U Files", "m3u");
			    chooser.setFileFilter(filter);
			    chooser.setMultiSelectionEnabled(false);
			    chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
			    chooser.setSelectedFile(new File("playlist.m3u"));
		    int returnVal = chooser.showSaveDialog(frame);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = chooser.getSelectedFile();
	            StringBuilder builder = new StringBuilder();
	            for(int i = 0; i < playlistHandler.getModel().size(); i++){
	            	MusicFileWrapper musicFile = playlistHandler.getModel().get(i);
	            	builder.append(musicFile.getFilePath()).append("\n");
	            }
	            FileOutputStream fos = null;
	            try {
					fos = new FileOutputStream(file);
					fos.write(builder.toString().getBytes());
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(frame, "Error while saving playlist");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(frame, "Error while saving playlist");
				}
	            finally {
	            	try {
						fos.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(frame, "Error while saving playlist");
					}
	            }
		    }
			
		}
	};

	
	
	private JButton skipTrack = new JButton("Skip Track");

	
	
	private ActionListener listner = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			playlistHandler.playNextSong(currentFile, true);
		}
	};

	
	
	private JButton remove = new JButton("Remove from playlist");

	
	
	private ActionListener removelistener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			List<MusicFileWrapper> selectedValues = playlistHandler.getPlaylist().getSelectedValuesList();
			for (MusicFileWrapper file: selectedValues) {
				playlistHandler.getModel().removeElement(file);
				if(file.isPlaying()){
					stop();
				}
			}
		}
	};

	
	
	private JButton clear = new JButton("Clear Playlist");

	
	
	private ActionListener clearlistener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			playlistHandler.getModel().removeAllElements();
			stop();
		}
	};

	

	private JButton playModeButton;

	
	PlayMode mode = PlayMode.NORMAL;

	
	
	private ActionListener modeListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch (mode) {
			case NORMAL:
				mode = PlayMode.REPEAT_TRACK;
				break;
				
			case REPEAT_TRACK:
				mode = PlayMode.REPEAT_PLAYLIST;
				break;
				
			case REPEAT_PLAYLIST:
				mode = PlayMode.SHUFFLE;
				break;
				
			case SHUFFLE:
				mode = PlayMode.NORMAL;
				break;
				
			default:
				mode = PlayMode.NORMAL;
				break;
			}
			playModeButton.setText(mode.toString());
		}
	};

	
	
	private JButton up = new JButton("Up");

	
	private JButton down = new JButton("Down");

	
	
	private ActionListener upListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = playlistHandler.getPlaylist().getSelectedIndex();
			if(index > 0){
				MusicFileWrapper selected = playlistHandler.getModel().remove(index);
				playlistHandler.getModel().add(index-1, selected);
				playlistHandler.getPlaylist().setSelectedIndex(index-1);
			}
		}
	};

	
	
	private ActionListener downListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = playlistHandler.getPlaylist().getSelectedIndex();
			if(index < playlistHandler.getModel().size()-1){
				MusicFileWrapper selected = playlistHandler.getModel().remove(index);
				playlistHandler.getModel().add(index+1, selected);
				playlistHandler.getPlaylist().setSelectedIndex(index+1);
			}
		}
	};

	
	
	JButton addToQueue = new JButton("Add to Queue");

	
	JButton removeFromQueue = new JButton("Remove from Queue");

	
	
	ActionListener addToQueueListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MusicFileWrapper selected = playlistHandler.getPlaylist().getSelectedValue();
			if(selected != null){
				playlistHandler.queueModel.addElement(selected);
			}
		}
	};

	
	
	ActionListener removeFromQueueListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MusicFileWrapper selected = playlistHandler.queue.getSelectedValue();
			if(selected != null){
				playlistHandler.queueModel.removeElement(selected);
			}
		}
	};


}
