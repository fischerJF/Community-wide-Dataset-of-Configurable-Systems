package gui;
import java.awt.Color; 

import java.awt.Container; 

import java.awt.Dimension; 
import java.awt.Image; import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.File; 
import java.io.IOException; 
import java.util.LinkedList; 
import java.util.List; 
import java.util.Timer; 
import java.util.TimerTask; 

import javax.imageio.ImageIO; 

import javax.swing.JButton; 

import javax.swing.JFileChooser; 
import javax.swing.JFrame; import javax.swing.JLabel; 
import javax.swing.JMenu; 
import javax.swing.JMenuBar; 
import javax.swing.JMenuItem;

import player.MP3Player; 
import player.Player; 

import player.PlayerFileFilter; 

import player.TrackMetadata;
import specifications.Configuration;

import javax.swing.JProgressBar; import gui.Picture; import gui.Playlist; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import javax.swing.JList; import gui.Playlist.PlayMode; 
import java.util.Random; 
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader; 
import java.io.FileWriter; 
import javax.swing.filechooser.FileNameExtensionFilter; 
import javax.swing.JSlider; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener; import player.OGGPlayer; 

public   class  GUI  extends DefaultFrame  implements ActionListener, ChangeListener {
	

	private static final long serialVersionUID = 1L;

	
	
	private JLabel title, artist;

	
	private JButton play, pause, stop, open;

	

	//alter Ordnereinstiegspunkt	
	private String oldFile;

	

	Timer guiUpdater = null;

	
	
	List<Class<? extends Player>> players = new LinkedList<Class<? extends Player>>();

	
	public Player currentPlayer = null;

	
	public TrackMetadata metadata = new TrackMetadata();

	
	public List<PlayerFileFilter> fileFilters = new LinkedList<PlayerFileFilter>();

	

	/**
	 * Baut die Gui
	 */
	public GUI() {
		if (Configuration.gui) {
			//Konstruktor
		//	super(HALF, THIRD);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("FeatureAMP");
			//enntsprechenden Player zufügen
			
			initPlayers();
			
			//gewähltes Format abfragen
			for (Class<? extends Player> c : players)
			{
				try {
					PlayerFileFilter ff = (PlayerFileFilter)(c.getMethod("getFileFilter", (Class<?>[])null).invoke(null));
					fileFilters.add(ff);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
				}
	}

	
	DefaultPanel meta;

	
	DefaultPanel head;

	
	DefaultPanel vol;

	
	DefaultPanel content;

	
	DefaultPanel panelPlaylist;

	
	DefaultPanel buttons;

	
	JMenuBar menubar;

	
	JMenu fileMenu;

	
	Image img;

	
	 private void  initPlayers__wrappee__GUI  (){}

	
	 private void  initPlayers__wrappee__mp3  (){
		if (!specifications.Configuration.mp3) {
			initPlayers__wrappee__GUI();
			return;
		}
		initPlayers__wrappee__GUI();
		this.players.add(MP3Player.class);
	}

	
	public void initPlayers(){
		if (!specifications.Configuration.ogg) {
			initPlayers__wrappee__mp3();
			return;
		}
		
	initPlayers__wrappee__mp3();
	this.players.add(OGGPlayer.class);

	}

	
	 private void  init__wrappee__GUI  ()
	{

		/***************General Layout Stuff************************/	
		// WindowIcon
		img = null;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("Icon.png"));
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		


		// menu bar
		menubar = new JMenuBar();
		fileMenu = new JMenu("File");
		menubar.add(fileMenu);

		
		JMenuItem closeButton = new JMenuItem("Exit");
		closeButton.setActionCommand("exit");
		closeButton.addActionListener(this);

		JMenuItem openButton = new JMenuItem("Open File...");
		openButton.setActionCommand("open");
		openButton.addActionListener(this);
		
		
		fileMenu.add(closeButton);
		fileMenu.addSeparator();
		fileMenu.add(openButton);
		this.setJMenuBar(menubar);

		// Metapanel mit Title und Artist
		meta = new DefaultPanel(DefaultLayout.View.VERTICAL);
		// Titlepanel
		DefaultPanel titlepanel = new DefaultPanel(DefaultLayout.View.HORIZONTAL);
		title = new JLabel("");
		titlepanel.addAutoGap();
		titlepanel.addComponents(title);
		titlepanel.addAutoGap();
		// artistpanel
		DefaultPanel artistpanel = new DefaultPanel(DefaultLayout.View.HORIZONTAL);
		artist = new JLabel("");
		artistpanel.addAutoGap();
		artistpanel.addComponents(artist);
		artistpanel.addAutoGap();
		// merge panels to meta panel
		meta.addComponents(titlepanel, artistpanel);
		
		// Standard nur metadata mit Cover falls gewählt.
		head = new DefaultPanel(DefaultLayout.View.VERTICAL);
		
		// Standard Buttons
		buttons = new DefaultPanel(DefaultLayout.View.HORIZONTAL);
		play = new JButton("Play");
		play.setName("play");
		pause = new JButton("Pause");
		pause.setName("pause");
		stop = new JButton("Stop");
		stop.setName("stop");
		open = new JButton("Open");
		open.setName("open");
		open.setActionCommand("open");
		buttons.addAutoGap();
		buttons.addComponents(open, play, pause, stop);
		buttons.addAutoGap();

		// cover
		addCover();
		head.addComponents(meta);
				
		// Content Frame Vertical
		content = new DefaultPanel(DefaultLayout.View.VERTICAL);
		content.addComponents(head);
		content.addComponents(buttons);

		//Progressbar
		addProgress();
		
		//Volume and Mute
		vol = new DefaultPanel(DefaultLayout.View.HORIZONTAL);
		addVolumeControl();
		addMute();
		content.addComponents(vol);
		
		//Playlist
		panelPlaylist = new DefaultPanel(DefaultLayout.View.VERTICAL);
		addPlaylist();
		DefaultPanel doubleContent = new DefaultPanel(DefaultLayout.View.HORIZONTAL);
		doubleContent.addComponents(content);
		doubleContent.addAutoGap();
		doubleContent.addComponents(panelPlaylist);
		setContentPane(doubleContent);

		initButtons();
		// rebuild gui
		pack();
		setVisible(true);

		// prevent resizing to smaller values
		int minW = this.getWidth();
		int minH = this.getHeight();
		this.setMinimumSize(new Dimension(minW, minH));

		this.guiUpdater = new Timer(true);
		this.guiUpdater.scheduleAtFixedRate(new TimerTask() {
			private GUI gui;

			public TimerTask init(GUI gui) {
				this.gui = gui;
				return this;
			}

			public void run() {
				gui.updateGui();
			}
		}.init(this), 0, 1000);
	}

	

	 private void  init__wrappee__ProgressBar  () {
		if (!specifications.Configuration.progressbar) {
			init__wrappee__GUI();
			return;
		}
		progress = new JProgressBar(0, 10000);
		progress.setStringPainted(true);
		progress.setName("progress");
		progress.setValue(0);
		init__wrappee__GUI();
	}

	
	
	 private void  init__wrappee__ShowCover(){
		if (!specifications.Configuration.showcover) {
			init__wrappee__ProgressBar();
			return;
		}
		
		cover = new Picture(300, 300);
		cover.setDefaultPicture();
		cover.setMinimumSize(new Dimension(300, 300));
		cover.setSize(new Dimension(400, 400));
		cover.setMaximumSize(new Dimension(400, 400));
		init__wrappee__ProgressBar();
	}

	
	
	 private void  init__wrappee__Playlist(){
		if (!specifications.Configuration.playlist) {
			init__wrappee__ShowCover();
			return;
		}
		jplaylist = new JList<TrackMetadata>();
		jplaylist.setName("p_list");
		jplaylist.setPreferredSize(new Dimension(100, 100));
		jplaylist.setListData(playlist.getArray());
		jplaylist.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			public void mouseClicked(MouseEvent evt) {
				JList<TrackMetadata> list = (JList<TrackMetadata>) evt.getSource();
				if (evt.getClickCount() >= 2) {
					int index = list.locationToIndex(evt.getPoint());
					TrackMetadata tm = playlist.goTo(index);
					if (tm != null) {
						playTrack(tm);
					}
				}
			}
		});
		init__wrappee__ShowCover();
	}

	
	
	 private void  init__wrappee__LoadFolder(){
		if (!specifications.Configuration.loadfolder) {
			init__wrappee__Playlist();
			return;
		}
		openFolder.setActionCommand("openFolder");
		openFolder.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent e) {
				openFolder();
				
			}
		});
		init__wrappee__Playlist();
		fileMenu.add(openFolder);
	}

	
	
	 private void  init__wrappee__SkipTrack(){
		if (!specifications.Configuration.skiptrack) {
			init__wrappee__LoadFolder();
			return;
		}
		skipTrackButton = new JButton("Skip Track");
		skipTrackButton.setName("skiptrack");
		skipTrackButton.setActionCommand("skipTrack");
		skipTrackButton.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent arg0) {
				//aktuellen Song überspringen und nächsten spielen
				//if modus Shuffle = zufälliges lied 
				if(currentPlayer !=null){
					currentPlayer.stop();
					metadata = playlist.next();
					playTrack(metadata);
				}
				if(currentPlayer != null && PlayMode.Normal != playlist.getMode()){
					currentPlayer.stop();
					Random skip = new Random();
					metadata = playlist.goTo(skip.nextInt(playlist.getList().size()));
					playTrack(metadata);
				}
				
			}
		});
		
		init__wrappee__LoadFolder();
	}

	
	
	 private void  init__wrappee__ShuffleRepeat(){
		if (!specifications.Configuration.shufflerepeat) {
			init__wrappee__SkipTrack();
			return;
		}
		shuffleButton = new JButton("Shuffle");
		shuffleButton.setActionCommand("shuffle");
		shuffleButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				playlist.shuffleList();
				jplaylist.setListData(playlist.getArray());
				pack();
			}
		});

		modeButton = new JButton("Linear");
		
		modeButton.setActionCommand("mode");
		modeButton.setName("mode");
		modeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				switch (getPlaylist().getMode()) {
				case Normal:
					getPlaylist().setMode(PlayMode.RepeatOne);
					modeButton.setText("Repeat One");
					break;
				case RepeatOne:
					getPlaylist().setMode(PlayMode.RepeatAll);
					modeButton.setText("Repeat All");
					break;
				case RepeatAll:
					getPlaylist().setMode(PlayMode.Normal);
					modeButton.setText("Linear");
					break;
				}
			}
		});
		
		init__wrappee__SkipTrack();
	}

	

	 private void  init__wrappee__RemoveTrack() {
		if (!specifications.Configuration.removetrack) {
			init__wrappee__ShuffleRepeat();
			return;
		}
		removeTrackButton = new JButton("Remove Track");
		removeTrackButton.setName("remove");
		removeTrackButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				List<TrackMetadata> tracks = getSelectedTracks();

				for (TrackMetadata track : tracks) {
					if (metadata == track) {

						// aktuellen Player stoppen und zurücksetzen
						if (currentPlayer != null) {
							currentPlayer.stop();
							currentPlayer = null;
						}
						// metadatenlöschen
						if (metadata != null) {
							metadata = playlist.next();
						}
					}
					// track entfernen und Playlist updaten
					playlist.removeTrack(track);
					refreshPlaylist();
				}
			}
		});
		init__wrappee__ShuffleRepeat();
	}

	
	
	 private void  init__wrappee__ClearPlaylist(){
		if (!specifications.Configuration.clearplaylist) {
			init__wrappee__RemoveTrack();
			return;
		}
		clearPlaylistButton = new JButton("Clear Playlist");
		clearPlaylistButton.setName("clear_playlist");
		clearPlaylistButton.setActionCommand("clearPlaylist");
		clearPlaylistButton.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent e) {
				if (currentPlayer != null) {
					currentPlayer.stop();
					currentPlayer = null;
				}
				// metadatenlöschen
				if (metadata != null) {
					metadata = playlist.next();
				}
				
				getPlaylist().clearPlaylist(metadata);
				refreshPlaylist();
				updateGui();
			}
			});
		init__wrappee__RemoveTrack();
	}

	
	
	 private void  init__wrappee__ReorderPlaylist(){
		if (!specifications.Configuration.reorderplaylist) {
			init__wrappee__ClearPlaylist();
			return;
		}
		up = new JButton("UP");
		up.setName("up");
		up.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent arg0) {
				if (playlist != null && !playlist.getList().isEmpty()) {
					
					 int index = jplaylist.getSelectedIndex();
				        if( index == -1 )
				          System.out.println("Select something to move." );
				        else if( index > 0 )
				        {
				          
				          playlist.moveUp(index);
				          refreshPlaylist();
				          jplaylist.setSelectedIndex( index - 1 );
				        }
				}
			}	
		});
	
		down = new JButton("DOWN");
		down.setName("down");
		down.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent arg0) {
				if (playlist != null && !playlist.getList().isEmpty()) {
					int index = jplaylist.getSelectedIndex();
			        if( index == -1 )
			          System.out.println("Select something to move." );
			        else if( index < playlist.getList().size()-1 )
			        {
			          
			          playlist.moveDown(index);
			          refreshPlaylist();
			          jplaylist.setSelectedIndex( index + 1 );
			        }
				}
			}
		});
		init__wrappee__ClearPlaylist();
	}

	

	 private void  init__wrappee__SaveAndLoadPlaylist() {
		if (!specifications.Configuration.saveandloadplaylist) {
			init__wrappee__ReorderPlaylist();
			return;
		}
		exportPlist = new JMenuItem("Export playlist");
		exportPlist.setActionCommand("export");
		exportPlist.addActionListener(new ActionListener() {

			 
			public void actionPerformed(ActionEvent arg0) {
				savePlaylist();

			}
		});
		importPlist = new JMenuItem("Import playlist");
		importPlist.setActionCommand("import");
		importPlist.addActionListener(new ActionListener() {

			 
			public void actionPerformed(ActionEvent e) {
				loadPlaylist();
			}
		});
		init__wrappee__ReorderPlaylist();
		fileMenu.add(exportPlist);
		fileMenu.add(importPlist);
	}

	
		
	 private void  init__wrappee__QueueTrack(){
		if (!specifications.Configuration.queuetrack) {
			init__wrappee__SaveAndLoadPlaylist();
			return;
		}
		addQueue = new JButton("add to Queue");
		addQueue.setName("add");
		deleteQueue = new JButton("delete from Queue");
		deleteQueue.setName("delete");
		clearQueue = new JButton("clear Queue");
		clearQueue.setName("clear");
		
		jqueue = new JList<TrackMetadata>();
		jqueue.setPreferredSize(new Dimension(100, 100));
		jqueue.setListData(playlist.getQueueArray());

		
		addQueue.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent e) {
				List<TrackMetadata> tracks = getSelectedTracks();
				
				for (TrackMetadata track : tracks) {
					playlist.queue.add(track);
					System.out.println("track:"+ track.getFileName()+"added");
					//Playlist updaten
					refreshQueue();
					
				}
			}
		});
		deleteQueue.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent arg0) {
				List<TrackMetadata> tracks = getSelectedQueueTracks();

				for (TrackMetadata track : tracks) {
					if (metadata == track) {

						// aktuellen Player stoppen und zurücksetzen
						if (currentPlayer != null) {
							currentPlayer.stop();
							currentPlayer = null;
						}
						// metadatenlöschen
						if (metadata != null) {
							metadata = playlist.next();
						}
					}
					// track entfernen und Playlist updaten
					playlist.queue.remove(track);
					refreshQueue();
				}
			}
		});
		clearQueue.addActionListener(new ActionListener() {

			 
			public void actionPerformed(ActionEvent e) {
				if (currentPlayer != null) {
					currentPlayer.stop();
					currentPlayer = null;
				}
				// metadatenlöschen
				if (metadata != null) {
					metadata = playlist.next();
				}

				playlist.queue.clear();
				refreshQueue();
				updateGui();
			}
		});
		init__wrappee__SaveAndLoadPlaylist();
	}

	
	
	 private void  init__wrappee__VolumeControl(){
		if (!specifications.Configuration.volumecontrol) {
			init__wrappee__QueueTrack();
			return;
		}
		volume = new JSlider(0, 100, 100);
		volume.addChangeListener(this);
		volume.setName("volumeSlider");
		volLabel = new JLabel(String.valueOf(this.volume.getMaximum()));
		init__wrappee__QueueTrack();
	}

	
	
	 private void  init__wrappee__Mute(){
		if (!specifications.Configuration.mute) {
			init__wrappee__VolumeControl();
			return;
		}
		muteButton = new JButton();
		muteButton.setText("Mute");
		muteButton.setName("mute");
		muteButton.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent arg0) {
				if (muted) {
					setVolume(oldVol);
					muteButton.setText("Mute");
				} else {
					oldVol = getVolume();
					setVolume(0);
					muteButton.setText("Unmute");
				}
				muted = !muted;				
			}
		});
		init__wrappee__VolumeControl();
	}

	
	
	 private void  init__wrappee__LightSkin  (){
		if (!specifications.Configuration.lightskin) {
			init__wrappee__Mute();
			return;
		}
		init__wrappee__Mute();
		setIconImage(img);
		head.setBackground(Color.WHITE);
		meta.setBackground(Color.WHITE);
		panelPlaylist.setBackground(Color.WHITE);
		content.setBackground(Color.WHITE);
		vol.setBackground(Color.WHITE);
		buttons.setBackground(Color.WHITE);
		
	}

	
	
	public void init(){
		if (!specifications.Configuration.darkskin) {
			init__wrappee__LightSkin();
			return;
		}
		init__wrappee__LightSkin();
		setIconImage(img);
		head.setBackground(Color.DARK_GRAY);
		meta.setBackground(Color.DARK_GRAY);
		panelPlaylist.setBackground(Color.DARK_GRAY);
		content.setBackground(Color.DARK_GRAY);
		vol.setBackground(Color.DARK_GRAY);
		buttons.setBackground(Color.DARK_GRAY);
	}

	
	
	//cover
	 private void  addCover__wrappee__GUI  (){}

	
	private void addCover(){
		if (!specifications.Configuration.showcover) {
			addCover__wrappee__GUI();
			return;
		}
		head.addComponents(cover, meta);
	}

	
	//progressBar
	  private void  addProgress__wrappee__GUI  (){}

	

	public void addProgress() {
		if (!specifications.Configuration.progressbar) {
			addProgress__wrappee__GUI();
			return;
		}
		content.addComponents(progress);
	}

	
	//volume&mute
	private void stateChanged(){}

	
	  private void  addVolumeControl__wrappee__GUI  (){}

	
	
	public void addVolumeControl(){
		if (!specifications.Configuration.volumecontrol) {
			addVolumeControl__wrappee__GUI();
			return;
		}
		
		vol.addComponents(volume);
		vol.addComponents(volLabel);
	}

	
	  private void  addMute__wrappee__GUI  (){}

	
	
	public void addMute(){
		if (!specifications.Configuration.mute) {
			addMute__wrappee__GUI();
			return;
		}
		vol.addComponents(muteButton);
	}

	
	//playlist
	  private void  addPlaylist__wrappee__GUI  (){}

	
	
	public void addPlaylist(){
		if (!specifications.Configuration.playlist) {
			addPlaylist__wrappee__GUI();
			return;
		}
		// Buttons Playlist
		
		buttonsPlaylist = new DefaultPanel(DefaultLayout.View.VERTICAL);
		buttonsPlaylist.addAutoGap();
		addButton();
		buttonsPlaylist.addAutoGap();

		panelPlaylist.addComponents(buttonsPlaylist);
		panelPlaylist.addAutoGap();
		panelPlaylist.addComponents(jplaylist);
		panelPlaylist.addAutoGap();
		addQueue();
		panelPlaylist.addAutoGap();
		
		

	}

	
	

	/**
	 * Initalisiert die Buttons (eventuell Action listener auslagern)
	 */
	private void initButtons() {
		play.addActionListener(new ActionListener() {

			 
			public void actionPerformed(ActionEvent e) {
				if (currentPlayer == null) {
					open(null, oldFile);
					
				} else {
					if (currentPlayer.playerStatus() == Player.STATUS_PAUSED) {
						if (currentPlayer != null) {
							currentPlayer.resume();
						}
					} else if (metadata.getLength() == currentPlayer
							.getPosition()
							|| currentPlayer.playerStatus() == Player.STATUS_FINISHED) {
						currentPlayer.stop();
						currentPlayer.play();
					}
				}
			}
		});
		pause.addActionListener(new ActionListener() {

			 
			public void actionPerformed(ActionEvent e) {
				if (currentPlayer == null) {
					return;
				}
				currentPlayer.pause();

			}
		});
		stop.addActionListener(new ActionListener() {

			 
			public void actionPerformed(ActionEvent e) {
				if (currentPlayer == null) {
					return;
				}
				currentPlayer.stop();
				playbackStopped();
			}
		});
		open.addActionListener(this);
		stateChanged();
	
	}

	
	
	 private void  playbackStopped__wrappee__GUI  () {}

	

	public void playbackStopped() {
		if (!specifications.Configuration.progressbar) {
			playbackStopped__wrappee__GUI();
			return;
		}
		progress.setValue(0);
		progress.setString("0:00");
	}

	
	
	/**
	 * Ließt eine einzelne Datei ein
	 * @param parent
	 * @param filename
	 */
	 private void  open__wrappee__GUI  (Container parent, String filename) {
		JFileChooser fc = new JFileChooser(filename);
		fc.setAcceptAllFileFilterUsed(false);
		
		// get all filefilters from every player and add them to filechooser
		for (Class<? extends Player> c : players)
		{
			try {
				// Reflection fuck yeah
				PlayerFileFilter ff = (PlayerFileFilter)(c.getMethod("getFileFilter", (Class<?>[])null).invoke(null));
				fc.addChoosableFileFilter(ff);
			} catch (Exception e3) {
				System.out.println(e3.getMessage());
				e3.printStackTrace();
			}
		}
		
		// Show Dialog
		int result = fc.showOpenDialog(parent);
		
		// if ok 
		if (result == JFileChooser.APPROVE_OPTION)
		{
			File toOpen = fc.getSelectedFile();
			PlayerFileFilter ff = (PlayerFileFilter)fc.getFileFilter();
			System.out.println(toOpen.getName());
			
			
			if (ff.accept(toOpen)) {
				if (toOpen != null) {
					String newFile = toOpen.getAbsolutePath();
					oldFile = newFile;
					TrackMetadata tm = null;
					try {
						tm = (TrackMetadata) (ff.getParentClass().getMethod(
								"getTrackMetadata",
								new Class<?>[] { String.class }).invoke(null,
								toOpen.getAbsolutePath()));
						if (tm == null) {
							System.err.println("Error with reading file");
						}
						playTrack(tm);
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
	}

	
	
	public void open(Container parent, String filename) {
		if (!specifications.Configuration.playlist) {
			open__wrappee__GUI(parent, filename);
			return;
		}
		JFileChooser fc = new JFileChooser(filename);
		fc.setAcceptAllFileFilterUsed(false);

		// get all filefilters from every player and add them to filechooser
		for (Class<? extends Player> c : players) {
			try {
				// Reflection fuck yeah
				PlayerFileFilter ff = (PlayerFileFilter) (c.getMethod(
						"getFileFilter", (Class<?>[]) null).invoke(null));
				fc.addChoosableFileFilter(ff);
			} catch (Exception e3) {
				System.out.println(e3.getMessage());
				e3.printStackTrace();
			}
		}

		// Show Dialog
		int result = fc.showOpenDialog(parent);

		// if ok
		if (result == JFileChooser.APPROVE_OPTION) {
			File toOpen = fc.getSelectedFile();
			PlayerFileFilter ff = (PlayerFileFilter) fc.getFileFilter();
			System.out.println(toOpen.getName());

			if (ff.accept(toOpen)) {
				if (toOpen != null) {
					String newFile = toOpen.getAbsolutePath();
					oldFile = newFile;
					TrackMetadata tm = null;
					try {
						tm = (TrackMetadata) (ff.getParentClass().getMethod(
								"getTrackMetadata",
								new Class<?>[] { String.class }).invoke(null,
								toOpen.getAbsolutePath()));
						if (tm == null) {
							System.err.println("Error with reading file");
						}

						getPlaylist().addTrack(tm);
						refreshPlaylist();
						if (getPlaylist().getList().size() == 1) {
							// wenn erstes lied, sofort abspielen
							playTrack(tm);
						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
	}

		
	

	/**
	 * Update Gui
	 */
	 private void  updateGui__wrappee__GUI  () {
		if (currentPlayer == null || metadata== null) {
			this.setTitle("featureAMP");
			return;
		}
		
		String title = "";
		
		title = String.format("%s - %s", this.metadata.getArtist(),this.metadata.getTitle());

		this.setTitle(title);
		
	}

	
	 private void  updateGui__wrappee__ShowTime  (){
		if (!specifications.Configuration.showtime) {
			updateGui__wrappee__GUI();
			return;
		}
		if (currentPlayer == null) {
			this.setTitle("featureAMP");
			return;
		}
		updateGui__wrappee__GUI();
		
		long curPos = currentPlayer.getPosition();
		
		String title = String.format("%s / %s - %s - %s", formatTime(curPos),
				formatTime(metadata.getLength()), metadata.getArtist(),
				metadata.getTitle());
		setTitle(title);
	}

	

	 private void  updateGui__wrappee__ProgressBar  () {
		if (!specifications.Configuration.progressbar) {
			updateGui__wrappee__ShowTime();
			return;
		}
		updateGui__wrappee__ShowTime();

		if (currentPlayer != null) {

			long curPos = currentPlayer.getPosition();
			progress.setValue((int) ((curPos / (double) metadata.getLength()) * 10000));
			progress.setString(formatTime(curPos));
		} else {
			progress.setValue(0);
		}
	}

	
	
	 private void  updateGui__wrappee__ShowCover  (){
		if (!specifications.Configuration.showcover) {
			updateGui__wrappee__ProgressBar();
			return;
		}
		updateGui__wrappee__ProgressBar();
		if(metadata != null){
		this.cover.setPicture(metadata.getCover());
		}

	}

	
	
	 private void  updateGui__wrappee__Playlist  (){
		if (!specifications.Configuration.playlist) {
			updateGui__wrappee__ShowCover();
			return;
		}
		updateGui__wrappee__ShowCover();
		if (currentPlayer != null
				&& currentPlayer.getPosition() == metadata.getLength()) {
			System.out.println("next!");
			TrackMetadata next = playlist.next();
			if (next == null) {
				if (currentPlayer != null) {
					currentPlayer.close();
					currentPlayer = null;
				}
				
				if (metadata != null) {
					metadata = null;
				}
				return;
			}
			playTrack(next);
		}
	}

	

	public void updateGui(){
		if (!specifications.Configuration.queuetrack) {
			updateGui__wrappee__Playlist();
			return;
		}
		updateGui__wrappee__Playlist();
		refreshQueue();
	}

	

	/**
	 * @param time
	 * @return
	 */
	public String formatTime(long time) {
		long hours = time / (60 * 60);
		time -= hours * 60 * 60;
		long minutes = time / 60;
		time -= minutes * 60;
		long seconds = time;

		if (hours > 0)
			return String.format("%d:%02d:%02d", hours, minutes, seconds);
		return String.format("%d:%02d", minutes, seconds);
	}

	

	 
	public void actionPerformed(ActionEvent e) {
		try {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "exit":
				if (currentPlayer != null) {
					currentPlayer.close();
				}
				System.exit(0);
				break;
			case "open":
				open(open, oldFile);
				break;	
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	

	/**
	 * Sorgt dafür das gewählte Datei gespielt wird
	 * @param tm
	 */
	public void playTrack(TrackMetadata tm) {
		
		if(tm == null){
			return;
		}

		if (this.currentPlayer != null) {
			this.currentPlayer.stop();
			//#if !Playlist
//@			this.currentPlayer.close();
			//#endif
		}
		
		File file = new File(tm.getFileName());
		PlayerFileFilter ff = null;
		for (PlayerFileFilter pff : fileFilters) {
			if (pff.accept(file)) {
				// nimmt datei an
				try {
					ff = pff;
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		if (ff == null) 
		{
			// keinen Dateifilter gefunden, sollte nicht passieren
			return;
		}
		
		Class<? extends Player> c = ff.getParentClass();
		// construct a new player with reflection because we only have type information
		try {
			currentPlayer = c.getConstructor(TrackMetadata.class).newInstance(tm);
			
			afterPlay();
			
			currentPlayer.play();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			currentPlayer = null;
		}
		// get track metadata once, if none inside, generate empty ones
		this.metadata = tm;
		
		title.setText(metadata.getTitle());
		artist.setText(metadata.getArtist());
		
		if (this.metadata == null) {
			this.metadata = new TrackMetadata();
		}
}

	
	public void afterPlay(){}

	
	private JProgressBar progress;

	
	private Picture cover;

	
	public JList<TrackMetadata> jplaylist = null;

	
	public Playlist playlist = new Playlist();

	
	DefaultPanel buttonsPlaylist;

	
	
	 private void  addButton__wrappee__Playlist  (){}

	
	
	

	 private void  addButton__wrappee__SkipTrack  (){
		if (!specifications.Configuration.skiptrack) {
			addButton__wrappee__Playlist();
			return;
		}
		addButton__wrappee__Playlist();
		buttonsPlaylist.addComponents(skipTrackButton);
	}

	
	
	 private void  addButton__wrappee__ShuffleRepeat  (){
		if (!specifications.Configuration.shufflerepeat) {
			addButton__wrappee__SkipTrack();
			return;
		}
		buttonsPlaylist.addComponents(shuffleButton, modeButton);
		addButton__wrappee__SkipTrack();
	}

	

	 private void  addButton__wrappee__RemoveTrack  () {
		if (!specifications.Configuration.removetrack) {
			addButton__wrappee__ShuffleRepeat();
			return;
		}
		addButton__wrappee__ShuffleRepeat();
		buttonsPlaylist.addComponents(removeTrackButton);
	}

	
	 private void  addButton__wrappee__ClearPlaylist  () {
		if (!specifications.Configuration.clearplaylist) {
			addButton__wrappee__RemoveTrack();
			return;
		}
		addButton__wrappee__RemoveTrack();
		buttonsPlaylist.addComponents(clearPlaylistButton);
	}

	
	
	 private void  addButton__wrappee__ReorderPlaylist  (){
		if (!specifications.Configuration.reorderplaylist) {
			addButton__wrappee__ClearPlaylist();
			return;
		}
		addButton__wrappee__ClearPlaylist();
		buttonsPlaylist.addComponents(up,down);
	}

	
	
	public void addButton() {
		if (!specifications.Configuration.queuetrack) {
			addButton__wrappee__ReorderPlaylist();
			return;
		}
		addButton__wrappee__ReorderPlaylist();
		buttonsPlaylist.addComponents(addQueue);
		buttonsPlaylist.addComponents(deleteQueue);
		buttonsPlaylist.addComponents(clearQueue);
	}

	
	 private void  addQueue__wrappee__Playlist  (){}

	
	
	public void addQueue(){
		if (!specifications.Configuration.queuetrack) {
			addQueue__wrappee__Playlist();
			return;
		}
		panelPlaylist.addComponents(jqueue);
	}

	
	
	public List<TrackMetadata> getSelectedTracks()
	{
		return jplaylist.getSelectedValuesList();
	
	}

	
	
	public Playlist getPlaylist()
	{
		return playlist;
	}

		
	
	
	/**
	 * Aktualisiert die Playlist bei veränderungen
	 */
	public void refreshPlaylist() {
		jplaylist.setListData(playlist.getArray());
		pack();
	}

	
JMenuItem openFolder = new JMenuItem("Open Folder...");

	
	




	private void openFolder() {
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		
		
		// Show Dialog
		int result = fc.showOpenDialog(this);
		
		// if ok 
		if (result == JFileChooser.APPROVE_OPTION)
		{
			File toOpen = fc.getSelectedFile();
			for(File file: toOpen.listFiles()){
				if(!file.isFile())
					continue;
				for (PlayerFileFilter pff : fileFilters) {
					if (pff.accept(file)) {
						// nimmt datei an
						try {
							TrackMetadata tm = (TrackMetadata)(pff.getParentClass().getMethod("getTrackMetadata", new Class<?>[] {String.class}).invoke(null, file.getAbsolutePath()));
							playlist.addTrack(tm);
						} catch (Exception e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
					}
				}
			}
			refreshPlaylist();
			playTrack(playlist.getCurrent());
		}
		
	}

	

	
JButton skipTrackButton = null;

	

	JButton shuffleButton = null;

	
	JButton modeButton = null;

	
	JButton removeTrackButton = null;

	
JButton clearPlaylistButton = null;

	
	
	JButton up;

	
	JButton down;

	
	
	JList <TrackMetadata>list = new JList<TrackMetadata>();

	

	JMenuItem exportPlist;

	
	JMenuItem importPlist;

	

	public void savePlaylist() {

		Playlist playlist = getPlaylist();

		if (playlist.getArray().length == 0)
			return;

		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		fc.addChoosableFileFilter(new FileNameExtensionFilter("m3u Playlist",
				"m3u"));

		int sel = fc.showSaveDialog(this);
		if (sel == JFileChooser.APPROVE_OPTION) {
			String fileName = fc.getSelectedFile().getAbsolutePath();
			if (!fileName.endsWith(".m3u")) {
				fileName += ".m3u";
			}
			StringBuilder m3u = new StringBuilder();
			m3u.append("#EXTM3U\n");
			for (TrackMetadata track : playlist.getList()) {
				m3u.append(String.format("#EXTINF:%s,%s - %s\n",
						track.getLength(), track.getArtist(), track.getTitle()));
				m3u.append(track.getFileName() + "\n");
			}

			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
				bw.write(m3u.toString());
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	

	public void loadPlaylist() {
		Playlist playlist = getPlaylist();

		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		fc.addChoosableFileFilter(new FileNameExtensionFilter("m3u Playlist",
				"m3u"));

		int sel = fc.showOpenDialog(this);

		if (sel == JFileChooser.APPROVE_OPTION) {
			playlist.clearPlaylist(metadata);
			if (currentPlayer != null) {
				currentPlayer.stop();
				metadata = new TrackMetadata();
				currentPlayer = null;
			}

			File file = fc.getSelectedFile();

			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				while ((line = br.readLine()) != null) {
					if (line.startsWith("#"))
						continue;
					TrackMetadata track = MP3Player.getTrackMetadata(line);
					playlist.addTrack(track);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			refreshPlaylist();
			playTrack(getPlaylist().getCurrent());
		}
	}

	
	
	JButton addQueue = null;

	
	JButton deleteQueue = null;

	
	JButton clearQueue = null;

	
	public JList<TrackMetadata> jqueue = null;

	
	
	public List<TrackMetadata> getSelectedQueueTracks()
	{
		return jqueue.getSelectedValuesList();
	
	}

	
	
	/**
	 * Aktualisiert die Queue bei veränderungen
	 */
	public void refreshQueue() {
		jqueue.setListData(playlist.getQueueArray());
		pack();
	}

	
	private JSlider volume;

	
	private JLabel volLabel;

	
	
	public void setVolume(int value)
	{
		volume.setValue(value);
	}

	
	
	public int getVolume()
	{
		return volume.getValue();
	}

	


	public void stateChanged(ChangeEvent arg0) {
		this.volLabel.setText(String.valueOf(this.volume.getValue()));
		if (currentPlayer != null) {
			currentPlayer.setVolume(volume.getValue());
		}
	}

	
	private JButton muteButton;

	
	boolean muted = false;

	
	int oldVol = -1;


}
