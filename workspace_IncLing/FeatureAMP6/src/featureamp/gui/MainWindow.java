package featureamp.gui; 

import java.awt.BorderLayout; 
import java.awt.Dimension; 
import java.awt.Font; 
import java.awt.Toolkit; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.File; 

import javax.sound.sampled.LineEvent; 
import javax.sound.sampled.LineListener; 

import javax.swing.ImageIcon; 
import javax.swing.JLabel; 
import javax.swing.JMenuItem; 
import javax.swing.JPanel; 
import javax.swing.JPopupMenu; 
import javax.swing.border.EmptyBorder; 

import gui.DefaultFrame; 

import gui.IconButton; 

import featureamp.FeatureAMP; 

import featureamp.controler.Kernel; 
import featureamp.gui.elements.Dialogs; 

import featureamp.gui.elements.HPanel; 
import featureamp.gui.elements.Picture; 
import featureamp.gui.elements.VPanel; 

import featureamp.playback.Player; 

import java.awt.Component; 

import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableCellRenderer; 
import javax.swing.table.TableRowSorter; 

import featureamp.gui.elements.Table; 
import featureamp.playback.Track; 
import featureamp.playback.TrackFactory; 

import featureamp.playlist.Playlist; 
import javax.swing.JCheckBox; 

import javax.swing.DropMode; 
import java.util.List; 

import featureamp.controler.M3U; 
import javax.swing.JProgressBar; 

import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener; 

import static javax.sound.sampled.LineEvent.Type.START; 
import static javax.sound.sampled.LineEvent.Type.STOP; 
import featureamp.playback.Player.State; 

/**
 * TODO description
 */
public   class  MainWindow  extends DefaultFrame  implements LineListener {
	

	public static final long serialVersionUID = -1;

	
	private static final String TITLE = "FeatureAMP media player";

	

	private Kernel kernel;

	
	private String currentDirectory;

	

	private HPanel metadata1, playerControls, fileControls;

	
	private VPanel content, metadata2, id3Info, playerElements;

	
	private Picture cover;

	
	private IconButton play, stop, open;

	
	private JPopupMenu mOpen;

	
	private JMenuItem miOpen;

	
	private ImageIcon iPlay, iPause, iStop, iOpen, iOpenFile;

	

	public MainWindow() {
//		if (specifications.Configuration.base) {
			// Base
			super(HALF, THIRD);
			setTitle(TITLE);
			currentDirectory = System.getProperty("user.home");
			kernel = new Kernel();
			Player.getInstance().addLineListener(this);
			init();
//				}
	}

	

	  private void  init__wrappee__Base  () {
		// Base
		JPanel frame = new JPanel(new BorderLayout());
		metadata1 = new HPanel();
		playerControls = new HPanel();
		fileControls = new HPanel();
		content = new VPanel();
		metadata2 = new VPanel();
		id3Info = new VPanel();
		playerElements = new VPanel();
		cover = kernel.getCover();
		metadata2.setPreferredSize(cover.getMinimumSize());

		frame.add(content, BorderLayout.CENTER);
		frame.add(fileControls, BorderLayout.SOUTH);

		fileControls.addAutoGap();
		initContent();
//		playerElements.addAutoGap();

		setContentPane(frame);
		pack();
		metadata1.setMinimumSize(metadata1.getSize());
		Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, metadata1.getSize().height);
		
		metadata1.setMaximumSize(d);
		setMinimumSize(getSize());
		setResizable(true);
		setVisible(true);
	}

	

	public void init() {
		if (!specifications.Configuration.titlebar) {
			init__wrappee__Base();
			return;
		}
		// Titlebar
		init__wrappee__Base();
		Player.getInstance().addLineListener(this);
	}

	

	 private void  initContent__wrappee__Base() {
		// Base
		content.addComponents(metadata1);
		metadata1.addComponents(cover, metadata2);
		metadata2.addAutoGap();
		metadata2.addComponents(id3Info);
		metadata2.addAutoGap();
		metadata2.addComponents(playerElements);
		playerElements.addComponents(playerControls);
		initId3Info();
		initPlayerElements();
		initFileControls();
	}

	

	 private void  initContent__wrappee__Playlist() {
		if (!specifications.Configuration.playlist) {
			initContent__wrappee__Base();
			return;
		}
		// Playlist

		kernel.getPlaylist().setColumsWidths(
				new int[] { Playlist.TRACK_NUMBER, Playlist.TITLE,
						Playlist.TIME, Playlist.ARTIST, Playlist.ALBUM },
				new int[] { N_SIZE, T_SIZE, D_SIZE, T_SIZE, T_SIZE });
		kernel.getPlaylist().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					kernel.playFromPlaylist();
				}
			}
		});
		sorter = new TableRowSorter<Playlist>();
		initContent__wrappee__Base();
		content.addComponents(kernel.getPlaylistElement());
	}

	

	 private void  initContent__wrappee__SkipTrack() {
		if (!specifications.Configuration.skiptrack) {
			initContent__wrappee__Playlist();
			return;
		}
		// SkipTrack
		initContent__wrappee__Playlist();
		kernel.getPlaylist().setDefaultRenderer(Boolean.class, new DefaultTableCellRenderer() {
			
			public static final long serialVersionUID = 1l;
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value,
					boolean isSelected, boolean hasFocus, int row, int column) {
				VPanel p = new VPanel();
				JCheckBox ch = new JCheckBox();
				ch.setSelected(value != null && ((Boolean) value).booleanValue());
				p.addAutoGap();
				p.addComponents(ch);
				p.addAutoGap();
				if (!isSelected) {
					p.setBackground(row % 2 == 0 ? FeatureAMP.BG
							: FeatureAMP.BG2);
				} else {
					p.setBackground(kernel.getPlaylist().getSelectionBackground());
				}
				p.setForeground(FeatureAMP.FG);
				return p;
			}
		});
		kernel.getPlaylist().getColumnModel().getColumn(Playlist.ENABLED).setPreferredWidth(N_SIZE);
		kernel.getPlaylist().moveColumn(Playlist.ENABLED, 0);
	}

	

	 private void  initContent__wrappee__Reorder() {
		if (!specifications.Configuration.reorder) {
			initContent__wrappee__SkipTrack();
			return;
		}
		// Reorder
		initContent__wrappee__SkipTrack();
		kernel.getPlaylist().setDragEnabled(true);
		kernel.getPlaylist().setDropMode(DropMode.INSERT_ROWS);
		kernel.getPlaylist().setTransferHandler(new RowTransferHandler(kernel.getPlaylist()));
	}

	
	
	private void initContent() {
		if (!specifications.Configuration.queuetrack) {
			initContent__wrappee__Reorder();
			return;
		}
		kernel.getPriorityQueue().setColumsWidths(
				new int[] { Playlist.TRACK_NUMBER, Playlist.TITLE,
						Playlist.TIME, Playlist.ARTIST, Playlist.ALBUM },
				new int[] {N_SIZE, T_SIZE, D_SIZE, T_SIZE, T_SIZE});
		kernel.getPriorityQueue().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
//					kernel.playFromPlaylist();
				}
			}
		});
		initContent__wrappee__Reorder();
	}

	

	 private void  initId3Info__wrappee__Base  () {
		// Base
		id3Info.addComponents(kernel.getArtist(), kernel.getTitle(),
				kernel.getLength());
	}

	

	 private void  initId3Info__wrappee__Tracknumber  () {
		if (!specifications.Configuration.tracknumber) {
			initId3Info__wrappee__Base();
			return;
		}
		// TrackNumber
		initId3Info__wrappee__Base();
		id3Info.addComponents(kernel.getTracknumber());
	}

	
	
	private void initId3Info() {
		if (!specifications.Configuration.album) {
			initId3Info__wrappee__Tracknumber();
			return;
		}
		// Album
		initId3Info__wrappee__Tracknumber();
		id3Info.addComponents(kernel.getAlbum());
	}

	

	 private void  initPlayerElements__wrappee__Base() {
		// Base
		iPlay = new ImageIcon("img/play.png");
		iPause = new ImageIcon("img/pause.png");
		iStop = new ImageIcon("img/stop.png");
		
		play = new IconButton(iPlay, new ActionListener() {
        
        
			@Override
			public void actionPerformed(ActionEvent e) {
				playPaue();
			}
		});
		play.setName("play");
		play.setToolTipText("Play/Pause");
		stop = new IconButton(iStop, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		stop.setToolTipText("Stop");
		stop.setName("stop");
		playerControls.addComponents(play, stop);
	}

	
	
	 private void  initPlayerElements__wrappee__SkipTrack() {
		if (!specifications.Configuration.skiptrack) {
			initPlayerElements__wrappee__Base();
			return;
		}
		// SkipTrack
		iSkip = new ImageIcon("img/skip.png");
		skip = new IconButton(iSkip, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				kernel.skip();
			}
		});
		skip.setToolTipText("Play next active title from playlist");
		initPlayerElements__wrappee__Base();
		playerControls.addComponents(skip);
	}

	

	 private void  initPlayerElements__wrappee__ShuffleRepeat() {
		if (!specifications.Configuration.shufflerepeat) {
			initPlayerElements__wrappee__SkipTrack();
			return;
		}
		// ShuffleRepeat
		shuffling = false;
		repeatMode = shuffleRepeatMode = REPEAT_0;
		iShuffle = new ImageIcon("img/shuffle_off.png");
		iShuffled = new ImageIcon("img/shuffle.png");
		iRepeat0 = new ImageIcon("img/repeat_off.png");
		iRepeat1 = new ImageIcon("img/repeat_one.png");
		iRepeatAll = new ImageIcon("img/repeat_all.png");
		shuffle = new IconButton(iShuffle, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (shuffling) {
					shuffle.setIcon(iShuffle);
					repeatMode = shuffleRepeatMode;
				} else {
					shuffle.setIcon(iShuffled);
					shuffleRepeatMode = repeatMode;
					repeatMode = REPEAT_S;
				}
				kernel.setPlaybackMode(repeatMode);
				shuffling = !shuffling;
			}
		});
		shuffle.setToolTipText("Shuffle playlist");
		repeat = new IconButton(iRepeat0, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (repeatMode) {
				case REPEAT_S:
					return;
				case REPEAT_0:
					repeat.setIcon(iRepeat1);
					repeatMode = REPEAT_1;
					repeat.setToolTipText("Set to Repeat All Mode");
					break;
				case REPEAT_1:
					repeat.setIcon(iRepeatAll);
					repeatMode = REPEAT_N;
					repeat.setToolTipText("Turn Repeat mode off");
					break;
				case REPEAT_N:
					repeat.setIcon(iRepeat0);
					repeatMode = REPEAT_0;
					repeat.setToolTipText("Set to Repeat One Mode");
					break;
				}
				kernel.setPlaybackMode(repeatMode);
			}
		});
		repeat.setToolTipText("Set to Repeat One Mode");
		initPlayerElements__wrappee__SkipTrack();
		playerControls.addGap(GAP);
		playerControls.addComponents(shuffle, repeat);
		playerControls.addGap(GAP);
	}

	
//	private HPanel volume;

	 private void  initPlayerElements__wrappee__Volume  () {
		if (!specifications.Configuration.volume) {
			initPlayerElements__wrappee__ShuffleRepeat();
			return;
		}
		// Volume
//		volume = new HPanel();
//		volume.setBorder(new EmptyBorder(0,0,0,0));
		initPlayerElements__wrappee__ShuffleRepeat();
		initVolume();
	}

	

	 private void  initPlayerElements__wrappee__Progressbar() {
		if (!specifications.Configuration.progressbar) {
			initPlayerElements__wrappee__Volume();
			return;
		}
		// Progressbar
		progressbar = new JProgressBar();
		progressbar.setStringPainted(true);
		progressbar.setMinimum(0);
		progressbar.setString(Player.formatTime(0));
		progressbar.setForeground(FeatureAMP.FG);
//		progressbar.setBorderPainted(false);
		initPlayerElements__wrappee__Volume();
		playerElements.addComponents(progressbar);
	}

	

	private void initPlayerElements() {
		if (!specifications.Configuration.jumpposition) {
			initPlayerElements__wrappee__Progressbar();
			return;
		}
		// JumpPosition
		initPlayerElements__wrappee__Progressbar();
		progressbar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1 && playerActive()) {
					int newVal = normalize(e.getX());
					kernel.jumpPosition(newVal);
				}
			}
			
			private boolean playerActive() {
				State s = Player.getInstance().state();
				return s == State.playing || s == State.ready || s == State.paused;
			}

			private int normalize(int pos) {
				return (int) (((float) pos)
						/ (((float) progressbar.getSize().width) + 0.5) * progressbar.getMaximum());
			}
		});
		progressbar.setToolTipText("Jump to any position with only a click");
	}

	

	 private void  initFileControls__wrappee__Base() {
		// Base
		iOpen = new ImageIcon("img/open.png");
		iOpenFile = new ImageIcon("img/audiofile.png");
		mOpen = new JPopupMenu("Open Menu");
		miOpen = new JMenuItem("Open File", iOpenFile);
		
		miOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		JLabel header = new JLabel("Open Menu");
		header.setAlignmentX(RIGHT_ALIGNMENT);
		header.setFont(header.getFont().deriveFont(Font.BOLD));
		header.setBorder(new EmptyBorder(0, 5, 0, 5));
		mOpen.add(header);
		mOpen.addSeparator();
		mOpen.add(miOpen);
		open = new IconButton(iOpen, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mOpen.show(open, open.getWidth(), open.getHeight());
			}
		});
		open.setToolTipText("Open menu");
		open.setName("open");
		fileControls.addComponents(open);
	}

	

	 private void  initFileControls__wrappee__OpenFolder() {
		if (!specifications.Configuration.openfolder) {
			initFileControls__wrappee__Base();
			return;
		}
		// OpenFolder
		iFolder = new ImageIcon("img/folder.png");
		openFolder = new JMenuItem("Open Folder", iFolder);
		openFolder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openFolder();
			}
		});
		initFileControls__wrappee__Base();
		mOpen.add(openFolder);
	}

	

	 private void  initFileControls__wrappee__RemoveTrack() {
		if (!specifications.Configuration.removetrack) {
			initFileControls__wrappee__OpenFolder();
			return;
		}
		// RemoveTrack
		iRemoveTrack = new ImageIcon("img/remove.png");
		removeTrack = new IconButton(iRemoveTrack, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Table ta = kernel.getPlaylist();
				int[] rows = ta.getSelectedRows();
//				int row = kernel.getPlaylist().getSelectedRow();
				if (rows.length > 0) {
					kernel.getPlaylist().setRowSorter(null);
					for (int i = 0; i < rows.length; i++) {
						int row = rows[i] - i;
						Track t = (Track) kernel.getPlaylist().getValueAt(
								row, -1);
						kernel.getPlaylist().getPlModel().removeTrack(t);
						kernel.checkIfStop(t);
					}
					sorter = new TableRowSorter<Playlist>();
					sorter.setModel(kernel.getPlaylist().getPlModel());
					kernel.getPlaylist().setRowSorter(sorter);
				}
			}
		});
		removeTrack.setToolTipText("Remove selected title from playlist");
		removeTrack.setName("removeTrack");
		fileControls.addComponents(removeTrack);
		initFileControls__wrappee__OpenFolder();
	}

	
	
	 private void  initFileControls__wrappee__ClearPlaylist() {
		if (!specifications.Configuration.clearplaylist) {
			initFileControls__wrappee__RemoveTrack();
			return;
		}
		// ClearPlaylist
		
		iClearPlaylist = new ImageIcon("img/clear_playlist.png");
		clearPlaylist = new IconButton(iClearPlaylist, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				kernel.getPlaylist().setRowSorter(null);
				kernel.getPlaylist().getPlModel().clear();
				sorter = new TableRowSorter<Playlist>();
				sorter.setModel(kernel.getPlaylist().getPlModel());
				kernel.getPlaylist().setRowSorter(sorter);
				kernel.stop();
				Player.getInstance().removeTrack();
			}
		});
		clearPlaylist.setToolTipText("Remove all title from playlist");
		clearPlaylist.setName("clearPlayList");
		fileControls.addComponents(clearPlaylist);
		initFileControls__wrappee__RemoveTrack();
	}

	

	 private void  initFileControls__wrappee__SaveAndLoad() {
		if (!specifications.Configuration.saveandload) {
			initFileControls__wrappee__ClearPlaylist();
			return;
		}
		// SaveAndLoad
		initFileControls__wrappee__ClearPlaylist();
		iOpenPlaylist = new ImageIcon("img/playlist.png");
		iSavePlaylist = new ImageIcon("img/save.png");

		openPlaylist = new JMenuItem("Open Playlist", iOpenPlaylist);
		savePlaylist = new JMenuItem("Save Playlist", iSavePlaylist);
		mOpen.add(openPlaylist);
		mOpen.addSeparator();
		mOpen.add(savePlaylist);
		openPlaylist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openPlaylist();
			}
		});
		savePlaylist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				savePlaylist();
			}
		});
	}

	
	
	private void initFileControls() {
		if (!specifications.Configuration.queuetrack) {
			initFileControls__wrappee__SaveAndLoad();
			return;
		}
		// QueueTrack
		queueActive = false;
		iQueue = new ImageIcon("img/priority.png");
		iShowQueue = new ImageIcon("img/eye.png");
		iAddQueue = new ImageIcon("img/add_queue.png");
		mQueue = new JPopupMenu();
		showQueue = new JMenuItem("Show Priority Queue", iShowQueue);
		showQueue.setVisible(false);
		addQueue = new JMenuItem("Add to Priority Queue", iAddQueue);
		mQueue.add(showQueue);
		mQueue.add(addQueue);
		kernel.setQueueMenuItems(showQueue);
		queue = new IconButton(iQueue, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mQueue.show(queue, queue.getWidth(), queue.getHeight());
				
			}
		});
		queue.setToolTipText("Priority Queue");
		showQueue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!queueActive) {
					kernel.showQueue();
					showQueue.setText("Show Playlist");
				} else {
					kernel.showPlaylist();
					showQueue.setText("Show Priority Queue");
				}
				addQueue.setVisible(queueActive);
				queueActive = !queueActive;
			}
		});
		
		addQueue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				kernel.toQueue();
			}
		});
		
		fileControls.addComponents(queue);
		initFileControls__wrappee__SaveAndLoad();
	}

	

	private void playPaue() {
		// Base
		switch (Player.getInstance().state()) {
		case ready:
		case paused:
		case finished:
		case stopped:
			kernel.play();
			break;
		case playing:
			kernel.pause();
		default:
			break;
		}
	}

	

	private void stop() {
		// Base
		kernel.stop();
	}

	

	 private void  openFile__wrappee__Base  () {
		// Base
		File toOpen = Dialogs.openFile(currentDirectory, this);
		if (toOpen != null) {
			kernel.stop();
			openFile(toOpen);
			kernel.play();
		}
	}

	

	private void openFile() {
		if (!specifications.Configuration.playlist) {
			openFile__wrappee__Base();
			return;
		}
		if (kernel.getPlaylist().getRowCount() == 1) {
			File toOpen = Dialogs.openFile(currentDirectory, this);
			if (toOpen != null) {
				// kernel.stop();
				openFile(toOpen);
				// kernel.play();
			}
		} else {
			openFile__wrappee__Base();
		}
	}

	

	 private void  openFile__wrappee__Base  (File f) {
		// Base
		currentDirectory = f.getAbsolutePath();
		kernel.loadTrack(f);
	}

	

	private void openFile(File f) {
		if (!specifications.Configuration.playlist) {
			openFile__wrappee__Base(f);
			return;
		}
		// Playlist
		kernel.getPlaylist().setRowSorter(null);
		openFile__wrappee__Base(f);
		kernel.getPlaylist().setRowSorter(sorter);
		sorter.setModel(kernel.getPlaylist().getPlModel());
		sorter.toggleSortOrder(0);
		Table pl = kernel.getPlaylist();
		if (pl.getRowCount() == 1) {
			Track t = (Track) pl.getValueAt(0, -1);
			kernel.setTrack(t);
		}
	}

	

	
	 private void  update__wrappee__Base(LineEvent e) {
		// Base
	}

	

	
	 private void  update__wrappee__Titlebar(LineEvent e) {
		if (!specifications.Configuration.titlebar) {
			update__wrappee__Base(e);
			return;
		}
		// Titlebar
		update__wrappee__Base(e);
		LineEvent.Type t = e.getType();
		if (t.equals(START)) {
			tu = new TitleUpdater();
			tu.start();
			play.setIcon(iPause);
		} else if (t.equals(STOP)) {
			play.setIcon(iPlay);
			tu.end();
			tu = null;
		}
	}

	

	@Override
	public void update(LineEvent e) {
		if (!specifications.Configuration.progressbar) {
			update__wrappee__Titlebar(e);
			return;
		}
		// Progressbar
		update__wrappee__Titlebar(e);
		LineEvent.Type t = e.getType();
		if (t.equals(START)) {
			bu = new BarUpdater();
			bu.start();
			play.setIcon(iPause);
		} else if (t.equals(STOP)) {
			play.setIcon(iPlay);
			bu.end();
			bu = null;
		}
	}

	

	private static final int N_SIZE = 50, D_SIZE = 75, T_SIZE = 175;

	
	public static final Dimension PLAYLIST_MINIMUM_SIZE = new Dimension(3
			* T_SIZE + N_SIZE + D_SIZE, 250);

	

	private TableRowSorter<Playlist> sorter;

	

	private ImageIcon iFolder;

	
	private JMenuItem openFolder;

	
	
	private void openFolder() {
		// OpenFolder
		File toOpen = Dialogs.openFolder(currentDirectory, this);
		if (toOpen != null) {
			openFolder(toOpen);
		}
	}

	
	
	private void openFolder(File f) {
		// OpenFolder
		for (File f2 : f.listFiles()) {
			if (f2.isDirectory()) {
				openFolder(f2);
			} else if (isAudioFile(f2)){
				openFile(f2);
			}
		}
	}

	
	
	private boolean isAudioFile(File f) {
		// OpenFolder
		boolean b = false;
		for (String format : TrackFactory.getFormats()) {
			b |= f.getName().endsWith(format);
		}
		return b;
	}

	
	
	private ImageIcon iSkip;

	
	private IconButton skip;

	

	private static final int GAP = 30;

	

	public static final int REPEAT_0 = 0, REPEAT_1 = 1, REPEAT_N = 2,
			REPEAT_S = 3;

	

	private ImageIcon iShuffle, iShuffled, iRepeat0, iRepeat1, iRepeatAll;

	
	private IconButton shuffle, repeat;

	
	private boolean shuffling;

	
	private int repeatMode, shuffleRepeatMode;

	

	private ImageIcon iRemoveTrack;

	
	private IconButton removeTrack;

	

	private ImageIcon iClearPlaylist;

	
	private IconButton clearPlaylist;

	

	private JMenuItem openPlaylist, savePlaylist;

	
	private ImageIcon iOpenPlaylist, iSavePlaylist;

	

	private void savePlaylist() {
		// SaveAndLoad
		try {
			File f = Dialogs.savePlaylist(currentDirectory, this);
			if (f != null) {
				f.createNewFile();
				List<Track> t = kernel.getTracks();
				M3U.toFile(t, f);
			}
		} catch (Exception e) {
			System.err.println("Error in feature saveandload");
			System.err.println(e.getMessage());
		}
	}

	

	private void openPlaylist() {
		// SaveAndLoad
		try {
			File f = Dialogs.openPlaylist(currentDirectory, this);
			if (f != null) {
				List<File> l = M3U.toList(f);
				for (File f2 : l) {
					openFile(f2);
				}
			}
		} catch (Exception e) {
			System.err.println("Error in feature saveandload");
			System.err.println(e.getMessage());
	}
	}

	

	private ImageIcon iQueue, iShowQueue, iAddQueue;

	
	private IconButton queue;

	
	private JPopupMenu mQueue;

	
	private JMenuItem showQueue, addQueue;

	
	
	private boolean queueActive;

	
	
	private static final int INTERVALL = 3;

	

	private JProgressBar volumeSlider;

	
	private IconButton volUp, volDown;

	
	private ImageIcon iVolUp, iVolDown;

	

	 private void  initVolume__wrappee__Volume() {
		// Volume
		volumeSlider = new JProgressBar(0, 100);
		volumeSlider.setStringPainted(true);
		volumeSlider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1 && volumeSlider.isEnabled()) {
					volumeSlider.setValue(normalize(e.getX()));
				}
			}

			private int normalize(int pos) {
				return (int) (((float) pos)
						/ (((float) volumeSlider.getSize().width) + 0.5) * 100);
			}
		});
		volumeSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int vol = volumeSlider.getValue();
				kernel.setVolume(vol);
				volumeSlider.setString(vol + "%");
			}
		});
		volumeSlider.setValue(80);
		volumeSlider.setToolTipText("Change Volume by clicking here");
		iVolUp = new ImageIcon("img/volume_up.png");
		iVolDown = new ImageIcon("img/volume_down.png");
		volUp = new IconButton(iVolUp, new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				int vol = volumeSlider.getValue() < 100 - INTERVALL ? volumeSlider.getValue()
						+ INTERVALL : 100;
				volumeSlider.setValue(vol);
			}
		});
		volUp.setToolTipText("Volume Up");
		volUp.setName("volumeUP");
		volDown = new IconButton(iVolDown, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int vol = volumeSlider.getValue() > 1 - INTERVALL ? volumeSlider.getValue()
						- INTERVALL : 0;
				volumeSlider.setValue(vol);
			}
		});
		volDown.setToolTipText("Volume Down");
		volDown.setName("volumeDown");
		playerControls.addComponents(volDown, volumeSlider, volUp);
	}

	

	private void initVolume() {
		if (!specifications.Configuration.mute) {
			initVolume__wrappee__Volume();
			return;
		}
		// Mute
		iMute = new ImageIcon("img/mute.png");
		iMuted = new ImageIcon("img/muted.png");
		isMuted = false;
		mute = new IconButton(iMute, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isMuted) {
					volumeSlider.setValue(mutedVolume);
				} else {
					mutedVolume = volumeSlider.getValue();
					volumeSlider.setValue(0);
				}
				volUp.setEnabled(isMuted);
				volDown.setEnabled(isMuted);
				volumeSlider.setEnabled(isMuted);
				mute.setIcon(isMuted ? iMute : iMuted);
				mute.setToolTipText(isMuted? "Mute volume" : "Unmute volume");
				isMuted = !isMuted;
			}
		});
		mute.setToolTipText("Mute volume");
		mute.setName("muteVolume");
		playerControls.addComponents(mute);
		initVolume__wrappee__Volume();
	}

	

	private boolean isMuted;

	
	private int mutedVolume;

	
	private ImageIcon iMute, iMuted;

	
	private IconButton mute;

	

	private TitleUpdater tu;

	

	private  class  TitleUpdater  extends Thread {
		
		// Titlebar
		private boolean stop = false;

		

		public void run() {
			// Titlebar
			while (!stop) {
				String currentTime = Player.formatTime(Player.getInstance()
						.getTrackPosition());
				setTitle(TITLE + " - " + currentTime);
				try {
					sleep(100);
				} catch (Exception e) {
					System.err.println("Error in feature titlebar");
					System.err.println(e.getMessage());
				}
			}
		}

		

		public void end() {
			// Titlebar
			stop = true;
			if (Player.getInstance().state() == Player.State.finished) {
				Player.getInstance().stop();
			}
			setTitle(Player.getInstance().state() == Player.State.paused ? getTitle()
					: TITLE);
		}


	}

	

	private JProgressBar progressbar;

	
	private BarUpdater bu;

	

	private  class  BarUpdater  extends Thread {
		
		// Progressbar
		private boolean stop = false;

		

		public BarUpdater() {
		if (specifications.Configuration.progressbar) {
				// Progressbar
				progressbar.setMaximum(Player.getInstance().getTrackLength());
					}
	}

		

		public void run() {
			// Progressbar
			while (!stop) {
				int position = Player.getInstance().getTrackPosition();
				String currentTaime = Player.formatTime(position);
				progressbar.setValue(position);
				progressbar.setString(currentTaime);
				try {
					sleep(50);
				} catch (Exception e) {
					System.err.println("Error in feature progressbar");
					System.err.println(e.getMessage());
				}
			}
		}

		

		public void end() {
			// Progressbar
			stop = true;
			if (Player.getInstance().state() == Player.State.finished) {
				Player.getInstance().stop();
			}
			int position = Player.getInstance().getTrackPosition();
			String currentTaime = Player.formatTime(position);
			progressbar.setValue(position);
			progressbar.setString(currentTaime);
		}


	}


}
