package gui; 

import javax.swing.*; 
import javax.swing.GroupLayout.Group; 

import java.awt.event.*; 

import java.awt.Dimension; 
import java.awt.Component; 
import java.util.*; 
import java.util.Timer; 
import java.io.File; 

import players.*; 
import java.awt.Image; 

import javax.swing.BorderFactory; 
import javax.swing.ImageIcon; 
import javax.swing.JLabel; 
import javax.swing.JProgressBar; 
import players.TrackMetadata; 
import javax.swing.JSlider; 
import javax.swing.event.*; 
import java.awt.event.ActionEvent; 

import javax.imageio.ImageIO; 
import javax.swing.JButton; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.util.List; 
import javax.swing.JFileChooser; 
import javax.swing.JList; 

import players.Player; 
import players.PlayerFileFilter; 
import javax.swing.JMenu; 
import javax.swing.JMenuItem; import gui.Playlist.PlayMode; 
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader; 
import java.io.FileWriter; 
import javax.swing.filechooser.FileNameExtensionFilter; 
import players.MP3Player; 
import java.awt.Color; 
//import players.OGGPlayer; 

public   class  Gui  extends JFrame  implements ActionListener, ChangeListener {
	
	private static final long serialVersionUID = 42L;

	

	// This list holds all available player types. Why types and not instances?
	// That would be too easy. Also reflection is the only good thing java has.
	// Everything else sucks balls.
	List<Class<? extends Player>> players = new LinkedList<Class<? extends Player>>();

	
	public List<PlayerFileFilter> fileFilters = new LinkedList<PlayerFileFilter>();

	
	
	public Player currentPlayer = null;

	
	public TrackMetadata metadata = new TrackMetadata();

	
	
	Timer guiUpdater = null;

	
	
	JButton playButton;

	
	JButton pauseButton;

	
	JButton stopButton;

	
	
	JMenu fileMenu;

	
	
	// Layout groups
	GroupLayout.SequentialGroup horzCoverPbButtonsVolume;

	
	GroupLayout.ParallelGroup horzPbButtonsVolume;

	
	GroupLayout.SequentialGroup horzVolume;

	
	GroupLayout.SequentialGroup horzPlaylist;

	
	GroupLayout.ParallelGroup horzPlaylistButtons;

	
	
	GroupLayout.ParallelGroup vertCoverPbButtonsVolume;

	
	GroupLayout.SequentialGroup vertPbButtonsVolume;

	
	GroupLayout.ParallelGroup vertVolume;

	
	GroupLayout.ParallelGroup vertPlaylist;

	
	GroupLayout.SequentialGroup vertPlaylistButtons;

	

	public Gui() {
		if (specifications.Configuration.gui) {
			initFormats();
			
			// get all filefilters from every player and add them to filechooser
			for (Class<? extends Player> c : players)
			{
				try {
					// Reflection fuck yeah
					PlayerFileFilter ff = (PlayerFileFilter)(c.getMethod("getFileFilter", (Class<?>[])null).invoke(null));
					fileFilters.add(ff);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
				}
	}

	
	
	 private void  initFormats__wrappee__GUI  ()
	{
		// nothing
	}

	
	
	 private void  initFormats__wrappee__MP3  ()
	{
		if (!specifications.Configuration.mp3) {
			initFormats__wrappee__GUI();
			return;
		}
		initFormats__wrappee__GUI();
		// add Players
		this.players.add(MP3Player.class);
	}

	
	
	public void initFormats()
	{
		if (!specifications.Configuration.ogg) {
			initFormats__wrappee__MP3();
			return;
		}
		initFormats__wrappee__MP3();
		// add Players
		this.players.add(OGGPlayer.class);
	}

	
	
	 private void  init__wrappee__GUI  ()
	{
		// Create menu with open and exit buttons
		JMenuBar menubar = new JMenuBar();
		fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		
		JMenuItem openButton = new JMenuItem("Open File...");
		openButton.setActionCommand("open");
		openButton.addActionListener(this);
		
		JMenuItem closeButton = new JMenuItem("Exit");
		closeButton.setActionCommand("exit");
		closeButton.addActionListener(this);
		
		fileMenu.add(openButton);
		addMenuEntry(fileMenu);
		fileMenu.addSeparator();
		fileMenu.add(closeButton);
		this.setJMenuBar(menubar);
		
		// Now buttons
		playButton = new JButton("Play");
		playButton.setName("play");
		playButton.setActionCommand("play");
		playButton.addActionListener(this);
		
		pauseButton = new JButton("Pause");
		pauseButton.setName("pause");
		pauseButton.setActionCommand("pause");
		pauseButton.addActionListener(this);
		
		stopButton = new JButton("Stop");
		stopButton.setName("stop");
		stopButton.setActionCommand("stop");
		stopButton.addActionListener(this);
	}

	

	 private void  init__wrappee__ProgressBar  ()
	{
		if (!specifications.Configuration.progressbar) {
			init__wrappee__GUI();
			return;
		}
		init__wrappee__GUI();
		
		this.pb = new JProgressBar(0, 10000);
		this.pb.setValue(0);
	}

	
	
	 private void  init__wrappee__VolumeControl  ()
	{
		if (!specifications.Configuration.volumecontrol) {
			init__wrappee__ProgressBar();
			return;
		}
		init__wrappee__ProgressBar();
		this.volume = new JSlider(0, 100, 100);
		this.setName("volume");
		this.volume.addChangeListener(this);
		this.volLabel = new JLabel(String.valueOf(this.volume.getMaximum()));
	}

	
	
	 private void  init__wrappee__Mute  ()
	{
		if (!specifications.Configuration.mute) {
			init__wrappee__VolumeControl();
			return;
		}
		init__wrappee__VolumeControl();
		
		muteButton = new JButton();
		muteButton.setName("mute");
		// apparently java ignores the next two setters. i mean, why would it conform to your set maxima?
		// it's not like I KNOW WHAT I WANT TO DO, FUCKING JAVA
		muteButton.setPreferredSize(new Dimension(16, 16)); 
		muteButton.setMaximumSize(new Dimension(16, 16));
		muteButton.setActionCommand("mute");
		muteButton.addActionListener(this);
		try {
			muteButton.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../sound.png"))));
		} catch (Exception e) {
			// no icon for you!
		}
	}

	

	 private void  init__wrappee__ShowCover()	{
		if (!specifications.Configuration.showcover) {
			init__wrappee__Mute();
			return;
		}
		init__wrappee__Mute();
		
		cover = new JLabel();
		cover.setPreferredSize(new Dimension(100,100));
		cover.setMinimumSize(new Dimension(100,100));
		cover.setMaximumSize(new Dimension(100,100));
		cover.setBorder(BorderFactory.createEtchedBorder());
	}

	
	
	 private void  init__wrappee__Playlist()
	{
		if (!specifications.Configuration.playlist) {
			init__wrappee__ShowCover();
			return;
		}
		init__wrappee__ShowCover();
		
		jplaylist = new JList<TrackMetadata>();
		jplaylist.setName("p_list");
		jplaylist.setPreferredSize(new Dimension(100,100));
		jplaylist.setListData(playlist.getArray());
		jplaylist.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        @SuppressWarnings("unchecked")
				JList<TrackMetadata> list = (JList<TrackMetadata>)evt.getSource();
		        if (evt.getClickCount() >= 2) {
		            int index = list.locationToIndex(evt.getPoint());
		            TrackMetadata tm = playlist.goTo(index);
		            if (tm != null) {
		            	playTrack(tm);
		            }
		        }
		    }
		});
	}

	
	
	 private void  init__wrappee__LoadFolder()
	{
		if (!specifications.Configuration.loadfolder) {
			init__wrappee__Playlist();
			return;
		}
		openFolder = new JMenuItem("Load Folder...");
		openFolder.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				openFolder();
			}
		});
		init__wrappee__Playlist();
	}

	
	
	 private void  init__wrappee__ShuffleRepeat  ()
	{
		if (!specifications.Configuration.shufflerepeat) {
			init__wrappee__LoadFolder();
			return;
		}
		init__wrappee__LoadFolder();
		
		shuffleButton = new JButton("Shuffle");
		shuffleButton.setActionCommand("shuffle");
		shuffleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				getPlaylist().shuffleList();
				refreshPlaylist();
			}
		});
		
		modeButton = new JButton("Linear");
		modeButton.setActionCommand("mode");
		modeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				switch (getPlaylist().getMode())
				{
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
	}

	
	
	 private void  init__wrappee__SkipTrack  ()
	{
		if (!specifications.Configuration.skiptrack) {
			init__wrappee__ShuffleRepeat();
			return;
		}
		init__wrappee__ShuffleRepeat();
		skipButton = new JButton("Skip");
		skipButton.setName("skip");
		skipButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				playTrack(getPlaylist().next(true));
				refreshPlaylist();
			}
		});
	}

	
	
	 private void  init__wrappee__RemoveTrack  ()
	{
		if (!specifications.Configuration.removetrack) {
			init__wrappee__SkipTrack();
			return;
		}
		init__wrappee__SkipTrack();
		removeButton = new JButton("Remove");
		removeButton.setName("remove");
		removeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				List<TrackMetadata> tracks = getSelectedTracks();
				
				for (TrackMetadata track : tracks)
				{
					if (metadata == track)
					{
						if (currentPlayer == null) {
							return;
						}
						currentPlayer.stop();
						metadata = new TrackMetadata();
						currentPlayer = null;
						
					}
					getPlaylist().removeTrack(track);
					refreshPlaylist();
				}
			}
		});
	}

	
	
	 private void  init__wrappee__ClearPlaylist  ()
	{
		if (!specifications.Configuration.clearplaylist) {
			init__wrappee__RemoveTrack();
			return;
		}
		init__wrappee__RemoveTrack();
		clearButton =  new JButton("Clear");
		clearButton.setName("clear");
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				getPlaylist().clearList();
				refreshPlaylist();
				if (currentPlayer == null) {
					return;
				}
				currentPlayer.stop();
				metadata = new TrackMetadata();
				currentPlayer = null;
			}
		});
	}

	
	
	 private void  init__wrappee__ReorderPlaylist  ()
	{
		if (!specifications.Configuration.reorderplaylist) {
			init__wrappee__ClearPlaylist();
			return;
		}
		init__wrappee__ClearPlaylist();
		
		upButton = new JButton("Up");
		upButton.setActionCommand("up");
		upButton.setName("up");
		upButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (playlist != null && !playlist.getList().isEmpty()) {
					int index = jplaylist.getSelectedIndex();
					if( index >= 0 )
					{
						playlist.moveUp(index);
						refreshPlaylist();
						jplaylist.setSelectedIndex( index - 1 );
					}
				}
			}
		});
		
		downButton = new JButton("Down");
		downButton.setActionCommand("down");
		downButton.setName("down");
		downButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (playlist != null && !playlist.getList().isEmpty()) {
					int index = jplaylist.getSelectedIndex();
					if( index >= 0 )
					{
						playlist.moveDown(index);
						refreshPlaylist();
						jplaylist.setSelectedIndex( index + 1 );
					}
				}
			}
		});
	}

	
	
	 private void  init__wrappee__SaveAndLoadPlaylist  ()
	{
		if (!specifications.Configuration.saveandloadplaylist) {
			init__wrappee__ReorderPlaylist();
			return;
		}
		
		skipButton = new JButton("Skip");
		skipButton.setName("skip");
		skipButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				playTrack(getPlaylist().next(true));
			}
		});
		
		exportPlist = new JMenuItem("Export playlist");
		exportPlist.setActionCommand("export");
		final Gui gui = this;
		exportPlist.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Playlist playlist = getPlaylist();
				
				if (playlist.getArray().length == 0) 
					return;
				
				JFileChooser fc = new JFileChooser();
				fc.setAcceptAllFileFilterUsed(false);
				fc.addChoosableFileFilter(new FileNameExtensionFilter("m3u Playlist", "m3u"));
				
				int sel = fc.showSaveDialog(gui);
				if (sel == JFileChooser.APPROVE_OPTION)
				{
					String fileName = fc.getSelectedFile().getAbsolutePath();
					if (!fileName.endsWith(".m3u"))
					{
						fileName += ".m3u";
					}
					StringBuilder m3u = new StringBuilder();
					m3u.append("#EXTM3U\n");
					for (TrackMetadata track : playlist.getList())
					{
						m3u.append(String.format("#EXTINF:%s,%s - %s\n", track.getRuntime(), track.getArtist(), track.getTitle()));
						m3u.append(track.getFileName() + "\n");
					}
					
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
						bw.write(m3u.toString());
						bw.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
			
		importPlist = new JMenuItem("Import playlist");
		importPlist.setActionCommand("import");
		importPlist.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Playlist playlist = getPlaylist();
				
				JFileChooser fc = new JFileChooser();
				fc.setAcceptAllFileFilterUsed(false);
				fc.addChoosableFileFilter(new FileNameExtensionFilter("m3u Playlist", "m3u"));
				
				int sel = fc.showOpenDialog(gui);
				
				if (sel == JFileChooser.APPROVE_OPTION)
				{
					playlist.clearList();
					if (currentPlayer != null) {
						currentPlayer.stop();
						metadata = new TrackMetadata();
						currentPlayer = null;
					}
					
					File file = fc.getSelectedFile();
					
					try {
						BufferedReader br = new BufferedReader(new FileReader(file));
						String line;
						while ((line = br.readLine()) != null)
						{
							if (line.startsWith("#"))
								continue;
							TrackMetadata track = MP3Player.getTrackMetadata(line);
							playlist.addTrack(track);
						}
						br.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
					refreshPlaylist();
					playTrack(getPlaylist().getCurrent());
				}
			}
		});
		init__wrappee__ReorderPlaylist();
	}

	
	
	public void init()
	{
		if (!specifications.Configuration.queuetrack) {
			init__wrappee__SaveAndLoadPlaylist();
			return;
		}
		init__wrappee__SaveAndLoadPlaylist();
		
		queueButton = new JButton("+ Queue");
		queueButton.setActionCommand("queue");
		queueButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (playlist != null && !playlist.getList().isEmpty()) {
					int index = jplaylist.getSelectedIndex();
					if( index >= 0 )
					{
						playlist.queueTrack(index);
						refreshPlaylist();
					}
				}
			}
		});
	}

	
	
	public void grouplayout()
	{
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		// layout
		GroupLayout.ParallelGroup horzCoverPbButtonsVolumePlaylistButtons = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		
		horzCoverPbButtonsVolume = layout.createSequentialGroup();
	
		addComponentToGroup(horzCoverPbButtonsVolume);
		
		horzPbButtonsVolume = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);
		
		addComponentToGroup(horzPbButtonsVolume);
		
		
		horzPbButtonsVolume.addGroup(layout.createSequentialGroup()
				.addComponent(playButton)
				.addComponent(pauseButton)
				.addComponent(stopButton)
			);
		
		horzVolume = layout.createSequentialGroup();
		addComponentToGroup(horzVolume);
		horzPbButtonsVolume.addGroup(horzVolume);
		
		horzCoverPbButtonsVolume.addGroup(horzPbButtonsVolume);
		
		horzCoverPbButtonsVolumePlaylistButtons.addGroup(horzCoverPbButtonsVolume);
		
		horzPlaylist = layout.createSequentialGroup();
		addComponentToGroup(horzPlaylist);
		horzPlaylistButtons = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		addComponentToGroup(horzPlaylistButtons);
		horzPlaylist.addGroup(horzPlaylistButtons);
		horzCoverPbButtonsVolumePlaylistButtons.addGroup(horzPlaylist);
		
		layout.setHorizontalGroup(horzCoverPbButtonsVolumePlaylistButtons);
		

		/*******************************/
		GroupLayout.SequentialGroup vertCoverPbButtonsVolumePlaylistbuttons = layout.createSequentialGroup();
		
		vertCoverPbButtonsVolume = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		
		addComponentToGroup(vertCoverPbButtonsVolume);
		
		vertPbButtonsVolume = layout.createSequentialGroup();
		
		addComponentToGroup(vertPbButtonsVolume);
		
		
		vertPbButtonsVolume.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(playButton)
					.addComponent(pauseButton)
					.addComponent(stopButton)
				);
		
		vertVolume = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		addComponentToGroup(vertVolume);
		vertPbButtonsVolume.addGroup(vertVolume);
		
		vertCoverPbButtonsVolume.addGroup(vertPbButtonsVolume);
		
		vertCoverPbButtonsVolumePlaylistbuttons.addGroup(vertCoverPbButtonsVolume);
		
		vertPlaylist = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		addComponentToGroup(vertPlaylist);
		vertPlaylistButtons = layout.createSequentialGroup();
		addComponentToGroup(vertPlaylistButtons);
		vertPlaylist.addGroup(vertPlaylistButtons);

		vertCoverPbButtonsVolumePlaylistbuttons.addGroup(vertPlaylist);

		
		layout.setVerticalGroup(vertCoverPbButtonsVolumePlaylistbuttons);
	}

	
	
	 private void  addComponentToGroup__wrappee__GUI  (Group g) 
	{
		// nothing
	}

	
	
	 private void  addComponentToGroup__wrappee__ProgressBar  (Group g)
	{
		if (!specifications.Configuration.progressbar) {
			addComponentToGroup__wrappee__GUI(g);
			return;
		}
		addComponentToGroup__wrappee__GUI(g);
		
		if (g == horzPbButtonsVolume || g == vertPbButtonsVolume)
		{
			g.addComponent(pb);
		}
	}

	
	
	 private void  addComponentToGroup__wrappee__VolumeControl  (Group g)
	{
		if (!specifications.Configuration.volumecontrol) {
			addComponentToGroup__wrappee__ProgressBar(g);
			return;
		}
		addComponentToGroup__wrappee__ProgressBar(g);
		
		if (g == horzVolume || g == vertVolume) {
			g.addComponent(volume);
			g.addComponent(volLabel);
		}
	}

	
	
	 private void  addComponentToGroup__wrappee__Mute  (Group g)
	{
		if (!specifications.Configuration.mute) {
			addComponentToGroup__wrappee__VolumeControl(g);
			return;
		}
		addComponentToGroup__wrappee__VolumeControl(g);
		if (g == horzVolume || g == vertVolume) {
			g.addComponent(muteButton);
		}
	}

	
	
	 private void  addComponentToGroup__wrappee__ShowCover  (Group g)
	{
		if (!specifications.Configuration.showcover) {
			addComponentToGroup__wrappee__Mute(g);
			return;
		}
		addComponentToGroup__wrappee__Mute(g);
		
		if (g == horzCoverPbButtonsVolume || g == vertCoverPbButtonsVolume)
		{
			g.addComponent(cover);
		}
	}

	
	
	 private void  addComponentToGroup__wrappee__Playlist  (Group g)
	{
		if (!specifications.Configuration.playlist) {
			addComponentToGroup__wrappee__ShowCover(g);
			return;
		}
		addComponentToGroup__wrappee__ShowCover(g);
		if (g == horzPlaylist || g == vertPlaylist)
		{
			g.addComponent(jplaylist);
		}
	}

	
	
	 private void  addComponentToGroup__wrappee__LoadFolder  (Group g)
	{
		if (!specifications.Configuration.loadfolder) {
			addComponentToGroup__wrappee__Playlist(g);
			return;
		}
		addComponentToGroup__wrappee__Playlist(g);
		if (g == horzPlaylist || g == vertPlaylist)
		{
			g.addComponent(jplaylist);
		}
	}

	
	
	 private void  addComponentToGroup__wrappee__ShuffleRepeat  (Group g)
	{
		if (!specifications.Configuration.shufflerepeat) {
			addComponentToGroup__wrappee__LoadFolder(g);
			return;
		}
		addComponentToGroup__wrappee__LoadFolder(g);
		if (g == horzPlaylistButtons || g == vertPlaylistButtons)
		{
			g.addComponent(shuffleButton);
			g.addComponent(modeButton);
		}
	}

	
	
	
	 private void  addComponentToGroup__wrappee__SkipTrack  (Group g)
	{
		if (!specifications.Configuration.skiptrack) {
			addComponentToGroup__wrappee__ShuffleRepeat(g);
			return;
		}
		addComponentToGroup__wrappee__ShuffleRepeat(g);
		if (g == horzPlaylistButtons || g == vertPlaylistButtons)
		{
			g.addComponent(skipButton);
		}
	}

	
	
	
	 private void  addComponentToGroup__wrappee__RemoveTrack  (Group g)
	{
		if (!specifications.Configuration.removetrack) {
			addComponentToGroup__wrappee__SkipTrack(g);
			return;
		}
		addComponentToGroup__wrappee__SkipTrack(g);
		if (g == horzPlaylistButtons || g == vertPlaylistButtons)
		{
			g.addComponent(removeButton);
		}
	}

	
	
	
	 private void  addComponentToGroup__wrappee__ClearPlaylist  (Group g)
	{
		if (!specifications.Configuration.clearplaylist) {
			addComponentToGroup__wrappee__RemoveTrack(g);
			return;
		}
		addComponentToGroup__wrappee__RemoveTrack(g);
		if (g == horzPlaylistButtons || g == vertPlaylistButtons)
		{
			g.addComponent(clearButton);
		}
	}

	
	
	 private void  addComponentToGroup__wrappee__ReorderPlaylist  (Group g)
	{
		if (!specifications.Configuration.reorderplaylist) {
			addComponentToGroup__wrappee__ClearPlaylist(g);
			return;
		}
		addComponentToGroup__wrappee__ClearPlaylist(g);
		if (g == horzPlaylistButtons || g == vertPlaylistButtons)
		{
			g.addComponent(upButton);
			g.addComponent(downButton);
		}
	}

	
	
	public void addComponentToGroup(Group g)
	{
		if (!specifications.Configuration.queuetrack) {
			addComponentToGroup__wrappee__ReorderPlaylist(g);
			return;
		}
		addComponentToGroup__wrappee__ReorderPlaylist(g);
		if (g == horzPlaylistButtons || g == vertPlaylistButtons)
		{
			g.addComponent(queueButton);
		}
	}

	
	
	 private void  addMenuEntry__wrappee__GUI  (JMenu menu)
	{
		//nothing
	}

	
	
	 private void  addMenuEntry__wrappee__LoadFolder  (JMenu menu)
	{
		if (!specifications.Configuration.loadfolder) {
			addMenuEntry__wrappee__GUI(menu);
			return;
		}
		addMenuEntry__wrappee__GUI(menu);
		menu.add(openFolder);
	}

	
	
	public void addMenuEntry(JMenu menu)
	{
		if (!specifications.Configuration.saveandloadplaylist) {
			addMenuEntry__wrappee__LoadFolder(menu);
			return;
		}
		addMenuEntry__wrappee__LoadFolder(menu);
		menu.add(exportPlist);
		menu.add(importPlist);
	}

	
	
	 private void  start__wrappee__GUI  ()
	{
		init();
		grouplayout();
		this.setTitle("featureAMP");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		// prevent resizing to smaller values
		int minW = this.getWidth();
		int minH = this.getHeight();
		this.setMinimumSize(new Dimension(minW, minH));
		
		// Enable GUI updater thread
		this.guiUpdater = new Timer(true);
		this.guiUpdater.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				updateGui();
			}
		}, 1000, 1000);
	}

	
	 private void  start__wrappee__Light  ()
	{
		if (!specifications.Configuration.light) {
			start__wrappee__GUI();
			return;
		}	
		start__wrappee__GUI();
		this.getContentPane().setBackground(Color.WHITE);
	}

	
	public void start()
	{
		if (!specifications.Configuration.dark) {
			start__wrappee__Light();
			return;
		}	
		start__wrappee__Light();
		this.getContentPane().setBackground(Color.DARK_GRAY);
	}

	
	
	 private void  actionPerformed__wrappee__GUI(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch (cmd){
		case "exit":
			if (currentPlayer != null) {
				currentPlayer.close();
			}
			System.exit(0);
			break;
		case "open":
			openFile();
			break;
		case "play":
			play();
			break;
		case "pause":
			if (this.currentPlayer == null) {
				break;
			}
			this.currentPlayer.pause();
			break;
		case "stop":
			if (this.currentPlayer == null) {
				break;
			}
			this.currentPlayer.stop();
			break;
		}
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!specifications.Configuration.mute) {
			actionPerformed__wrappee__GUI(e);
			return;
		}
		actionPerformed__wrappee__GUI(e);
		String cmd = e.getActionCommand();
		if (cmd == "mute"){
			if (muted) {
				setVolume(oldVol);
				try {
					muteButton.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../sound.png"))));
				} catch (Exception e1) {
					// no icon for you!
				}
			} else {
				oldVol = getVolume();
				setVolume(0);
				try {
					muteButton.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../sound_mute.png"))));
				} catch (Exception e2) {
					// no icon for you!
				}
			}
			muted = !muted;
		}
	}

	
	
	 private void  play__wrappee__GUI  ()
	{
		if (this.currentPlayer == null) {
			openFile();
			return;
		}
		this.currentPlayer.play();
	}

	
	
	public void play()
	{
		if (!specifications.Configuration.playlist) {
			play__wrappee__GUI();
			return;
		}
		if (getPlaylist().getList().size() == 0) {
			openFile();
			return;
		}
		if (this.currentPlayer == null) {
			TrackMetadata tm = getPlaylist().goTo(getPlaylist().getList().size() - 1);
			playTrack(tm);
			return;
		}
	}

	
	
	 private void  openFile__wrappee__GUI  ()
	{
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		
		// get all filefilters from every player and add them to filechooser
		for (Class<? extends Player> c : players)
		{
			try {
				// Reflection fuck yeah
				PlayerFileFilter ff = (PlayerFileFilter)(c.getMethod("getFileFilter", (Class<?>[])null).invoke(null));
				fc.addChoosableFileFilter(ff);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		// Show Dialog
		int result = fc.showOpenDialog(this);
		
		// if ok 
		if (result == JFileChooser.APPROVE_OPTION)
		{
			File f = fc.getSelectedFile();
			PlayerFileFilter ff = (PlayerFileFilter)fc.getFileFilter();
			System.out.println(f.getName());
			// Find a fitting Player
			if (ff.accept(f)) {
				try {
					TrackMetadata tm = (TrackMetadata)(ff.getParentClass().getMethod("getTrackMetadata", new Class<?>[] {String.class}).invoke(null, f.getAbsolutePath()));
					if (tm == null) {
						System.err.println("somethings fucky");
					}
		
					playTrack(tm);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	
	
	public void openFile()
	{
		if (!specifications.Configuration.playlist) {
			openFile__wrappee__GUI();
			return;
		}
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		
		// get all filefilters from every player and add them to filechooser
		for (Class<? extends Player> c : players)
		{
			try {
				// Reflection fuck yeah
				PlayerFileFilter ff = (PlayerFileFilter)(c.getMethod("getFileFilter", (Class<?>[])null).invoke(null));
				fc.addChoosableFileFilter(ff);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		// Show Dialog
		int result = fc.showOpenDialog(this);
		
		// if ok 
		if (result == JFileChooser.APPROVE_OPTION)
		{
			File f = fc.getSelectedFile();
			PlayerFileFilter ff = (PlayerFileFilter)fc.getFileFilter();
			System.out.println(f.getName());
			// Find a fitting Player
			if (ff.accept(f)) {
				try {
					TrackMetadata tm = (TrackMetadata)(ff.getParentClass().getMethod("getTrackMetadata", new Class<?>[] {String.class}).invoke(null, f.getAbsolutePath()));
					if (tm == null) {
						System.err.println("somethings fucky");
					}
					
					getPlaylist().addTrack(tm);
					refreshPlaylist();
					if (getPlaylist().getList().size() == 1)
					{
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

	
	
	 private void  updateGui__wrappee__GUI  ()
	{
		if (currentPlayer == null) {
			this.setTitle("featureAMP");
			return;
		}
		
		if (this.metadata == null) {
			this.metadata = new TrackMetadata();
		}
		
		String title = String.format("%s - %s", this.metadata.getArtist(), this.metadata.getTitle());
		this.setTitle(title);
	}

	
	
	 private void  updateGui__wrappee__ProgressBar  ()
	{
		if (!specifications.Configuration.progressbar) {
			updateGui__wrappee__GUI();
			return;
		}
		updateGui__wrappee__GUI();
		
		if (currentPlayer != null) {
			long curPos = currentPlayer.position();
			
			this.pb.setValue((int)((curPos / (double)this.metadata.getRuntime())*10000));
		}
		else
		{
			this.pb.setValue(0);
		}
	}

	
	 private void  updateGui__wrappee__ShowTime  ()
	{
		if (!specifications.Configuration.showtime) {
			updateGui__wrappee__ProgressBar();
			return;
		}
		updateGui__wrappee__ProgressBar();
		if (currentPlayer != null) {
			long curPos = currentPlayer.position();
			String title = String.format("%s / %s - ", formatTime(curPos), formatTime(this.metadata.getRuntime()));
			setTitle(title + getTitle());
		}
	}

	
	
	 private void  updateGui__wrappee__ShowCover  ()
	{
		if (!specifications.Configuration.showcover) {
			updateGui__wrappee__ShowTime();
			return;
		}
		updateGui__wrappee__ShowTime();
		
		if (this.metadata != null){
			Image img = this.metadata.getCover();
			if (img != null)
			{
				cover.setIcon(new ImageIcon(img));
			} else {
				cover.setIcon(null);
			}
		}
	}

	
	
	public void updateGui()
	{
		if (!specifications.Configuration.playlist) {
			updateGui__wrappee__ShowCover();
			return;
		}
		updateGui__wrappee__ShowCover();
		
		if (currentPlayer != null && currentPlayer.position() == metadata.getRuntime()) 
		{
			System.out.println("next!");
			// song is at end
			TrackMetadata nextTrack = playlist.next();
			if (nextTrack == null) {
				// end of playlist
				clearTrack();
			}
			playTrack(nextTrack);
			refreshPlaylist();
		}
	}

	
	
	public String formatTime(long time)
	{
		long hours = time / (60*60);
		time -= hours * 60*60;
		long minutes = time / 60;
		time -= minutes * 60;
		long seconds = time;
		
		if (hours > 0)
			return String.format("%d:%02d:%02d", hours, minutes,seconds);
		return String.format("%d:%02d", minutes, seconds);
	}

	
	
	public void clearTrack() {
		// close old player
		if (currentPlayer != null) {
			currentPlayer.close();
			currentPlayer = null;
		}
		
		if (metadata != null) {
			metadata = null;
		}
	}

	
	
	public void playTrack(TrackMetadata track) {
		if (track == null) {
			// nothing to play
			return;
		}
		
		clearTrack();
		
		File file = new File(track.getFileName());
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
			// no file filter found, this should not happen
			return;
		}
		
		Class<? extends Player> c = ff.getParentClass();
		// construct a new player with reflection because we only have type information
		try {
			currentPlayer = c.getConstructor(TrackMetadata.class).newInstance(track);

			afterPlay();
			
			currentPlayer.play();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			currentPlayer = null;
		}
		// get track metadata once, if none inside, generate empty ones
		this.metadata = track;
		
		if (this.metadata == null) {
			this.metadata = new TrackMetadata();
		}
	}

	
	
	 private void  afterPlay__wrappee__GUI  ()
	{
		// nothing
	}

	
	
	public void afterPlay()
	{
		if (!specifications.Configuration.volumecontrol) {
			afterPlay__wrappee__GUI();
			return;
		}
		currentPlayer.setVolume(getVolume());
	}

	
	JProgressBar pb = null;

	
	JSlider volume = null;

	
	JLabel volLabel = null;

	
	
	public void setVolume(int value)
	{
		volume.setValue(value);
	}

	
	
	public int getVolume()
	{
		return volume.getValue();
	}

	

	@Override
	public void stateChanged(ChangeEvent arg0) {
		this.volLabel.setText(String.valueOf(this.volume.getValue()));
		if (currentPlayer != null) {
			currentPlayer.setVolume(volume.getValue());
		}
	}

	
	JButton muteButton = null;

	
	boolean muted = false;

	
	int oldVol = -1;

	
	JLabel cover = null;

	
	JList<TrackMetadata> jplaylist = null;

	
	Playlist playlist = new Playlist();

	
	
	public List<TrackMetadata> getSelectedTracks()
	{
		return jplaylist.getSelectedValuesList();
	}

	
	
	public void refreshPlaylist() {
		jplaylist.setListData(playlist.getArray());
		pack();
	}

	
	
	public Playlist getPlaylist()
	{
		return playlist;
	}

	
	JMenuItem openFolder;

	
	
	public void openFolder()
	{
		JFileChooser fc = new JFileChooser("");
		fc.setAcceptAllFileFilterUsed(false);
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		// Show Dialog
		int result = fc.showOpenDialog(this);
		
		// if ok 
		if (result == JFileChooser.APPROVE_OPTION)
		{	
			File f = fc.getSelectedFile(); // this should be a folder
			for (File file : f.listFiles())
			{
				if (!file.isFile())
					continue;
				for (PlayerFileFilter pff : fileFilters) {
					if (pff.accept(file)) {
						// nimmt datei an
						try {
							TrackMetadata tm = (TrackMetadata)(pff.getParentClass().getMethod("getTrackMetadata", new Class<?>[] {String.class}).invoke(null, file.getAbsolutePath()));
							getPlaylist().addTrack(tm);
						} catch (Exception e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
					}
				}
			}
			refreshPlaylist();
			playTrack(getPlaylist().getCurrent());
		}
	}

	
	JButton shuffleButton = null;

	
	JButton modeButton = null;

	
JButton skipButton = null;

	
	JButton removeButton = null;

	
	JButton clearButton = null;

	
	JButton upButton = null;

	
	JButton downButton = null;

	
	JMenuItem exportPlist;

	
	JMenuItem importPlist;

	
	JButton queueButton = null;


}
