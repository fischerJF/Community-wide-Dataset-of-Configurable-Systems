package gui; 
import java.awt.Container; import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.File; 
import java.io.IOException; 

import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import javax.swing.*; 
import javax.swing.filechooser.*; 
import java.util.Set; 
import java.util.HashSet; 

import engine.*; import java.awt.BorderLayout; import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Image; 
import java.awt.image.BufferedImage; 
import java.io.ByteArrayInputStream; 

import javax.imageio.ImageIO; 
import javax.swing.BorderFactory; 

import javax.swing.Box; 
import javax.swing.Icon; 
import javax.swing.ImageIcon; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 

import engine.AudioFile; 

import javax.swing.BoxLayout; 

import javax.swing.JButton; import javax.swing.JProgressBar; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.io.FilenameFilter; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator; 
import java.util.List; 
import engine.Playback;
import specifications.Configuration;

import javax.swing.DefaultListModel; 
import javax.swing.JFileChooser; 
import javax.swing.JList; 
import javax.swing.JMenuItem; 
import javax.swing.JScrollPane; import java.awt.event.ItemEvent; 
import java.awt.event.ItemListener; 
import javax.swing.ButtonGroup; 
import javax.swing.JCheckBox; 
import javax.swing.JRadioButton; 
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader; 
import java.io.FileWriter; 
import javax.swing.JComponent; 
import javax.swing.JOptionPane; 
import javax.swing.filechooser.FileFilter; 
import javax.swing.filechooser.FileNameExtensionFilter; 

public   class  Main  extends JFrame {
	
	private static final int TIMER_INTERVAL = 1000;

	
	static final Set<String> FILE_EXTENSIONS = new HashSet<String>();

	
	
	private JButton btnPlay;

	
	private JButton btnPause;

	
	private JButton btnStop;

	
	
	private JMenu mnFile;

	
	private JMenuItem itOpen;

	
	private JFileChooser fcOpen;

	
	
	private Playback playback;

	
	
	private Timer timer;

	
	
	public Main() {
//		if (FM.FeatureModel.base) {
			super("FeatureAMP");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			initComponents();
			
			pack();
			setSize(400, getSize().height);
			
			timer = new Timer(TIMER_INTERVAL, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					updateWindow();
				}			
			});
			
			timer.start();
//				}
	}

	
	
	 private void  initComponents__wrappee__Base  () {
		// menu
		JMenuBar menuBar = new JMenuBar();
		mnFile = new JMenu("File");
		itOpen = new JMenuItem("Open...");
		mnFile.add(itOpen);
		menuBar.add(mnFile);
		setJMenuBar(menuBar);
		
		// buttons
		btnPlay = new JButton("Play");
		btnPlay.setName("play");
		btnPause = new JButton("Pause");
		btnPause.setName("pause");
		btnStop = new JButton("Stop");
		btnStop.setName("stop");
		
		btnPlay.setEnabled(false);
		btnPause.setEnabled(false);
		btnStop.setEnabled(false);
		
		Container contents = getContentPane();
		contents.setLayout(new BoxLayout(contents, BoxLayout.Y_AXIS));
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.add(btnPlay);
		buttons.add(btnPause);
		buttons.add(btnStop);
		contents.add(buttons);
		
		// open dialog
		fcOpen = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("Audio File", FILE_EXTENSIONS.toArray(new String[0]));
		fcOpen.setFileFilter(filter);
		addActions();
	}

	
	
	 private void  initComponents__wrappee__ShowCover() {
		if (!specifications.Configuration.showcover) {
			initComponents__wrappee__Base();
			return;
		}
		initComponents__wrappee__Base();
		Container contents = getContentPane();
		contents.add(Box.createVerticalStrut(5));
		coverLabel = new JLabel();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Dimension size = new Dimension(COVER_WIDTH, COVER_HEIGHT);
		panel.setPreferredSize(size);
		panel.setMinimumSize(size);
		panel.setMaximumSize(size);
		panel.add(coverLabel, BorderLayout.CENTER);			
		contents.add(panel);
	}

	
	
	 private void  initComponents__wrappee__VolumeControl() {
		if (!specifications.Configuration.volumecontrol) {
			initComponents__wrappee__ShowCover();
			return;
		}
		initComponents__wrappee__ShowCover();
		volumeUp = new JButton("+");
		volumeUp.setName("more_volume");
		volumeDown = new JButton("-");
		volumeDown.setName("less_volume");
		volumeDisplay = new JLabel(String.valueOf(volume));
				
		volumePanel = new JPanel();
		
		volumePanel.add(volumeDown);
		volumePanel.add(Box.createHorizontalStrut(5));
		volumePanel.add(volumeDisplay);
		volumePanel.add(Box.createHorizontalStrut(5));
		volumePanel.add(volumeUp);
		
		volumePanel.setLayout(new BoxLayout(volumePanel, BoxLayout.X_AXIS));
		getContentPane().add(volumePanel);
		
		updateVolumeValue();
		
		volumeUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				increaseVolume();				
			}
		});
		
		volumeDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				decreaseVolume();				
			}
		});
	}

	
	
	 private void  initComponents__wrappee__Mute() {
		if (!specifications.Configuration.mute) {
			initComponents__wrappee__VolumeControl();
			return;
		}
		initComponents__wrappee__VolumeControl();
		
		muteButton = new JButton("Mute");
		muteButton.setName("mute");
		mutedLabel = new JLabel("(muted)");
		
		volumePanel.add(Box.createHorizontalStrut(5));
		volumePanel.add(muteButton);
		volumePanel.add(Box.createHorizontalGlue());
		volumePanel.add(mutedLabel);
		
		mutedLabel.setVisible(false);
		
		muteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				toggleMute();					
			}
		});
	}

	
	
	 private void  initComponents__wrappee__ProgressBar() {
		if (!specifications.Configuration.progressbar) {
			initComponents__wrappee__Mute();
			return;
		}
		initComponents__wrappee__Mute();
		trackProgress = new JProgressBar();
		trackProgress.setName("progress");
		trackProgress.setMinimum(0);
		getContentPane().add(trackProgress);
	}

	
	
	 private void  initComponents__wrappee__Playlist() {
		if (!specifications.Configuration.playlist) {
			initComponents__wrappee__ProgressBar();
			return;
		}
		initComponents__wrappee__ProgressBar();
		playlist = new Playlist();
		itOpenFolder = new JMenuItem("Open Folder...");
		mnFile.add(itOpenFolder);
		fcFolder = new JFileChooser();
		fcFolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		liPlaylist = new JList<PlaylistItem>(playlist.getModel());
		liPlaylist.setName("p_list");
		JScrollPane scrollPane = new JScrollPane(liPlaylist);
		getContentPane().add(scrollPane);
		
		itOpenFolder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chooseFolder();
			}
		});
		
		liPlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if(evt.getClickCount() != 2)
					return;
				playSelectedFile();
			}
		});
	}

	
	
	 private void  initComponents__wrappee__ShuffleRepeat() {
		if (!specifications.Configuration.shufflerepeat) {
			initComponents__wrappee__Playlist();
			return;
		}
		initComponents__wrappee__Playlist();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rbRepeatList = new JRadioButton("List"));
		group.add(rbRepeatTrack = new JRadioButton("Current Track"));
		group.add(rbRepeatNone = new JRadioButton("Off", true));

		cbShuffle = new JCheckBox("Shuffle");
		cbShuffle.setName("shuffle");
		rbRepeatList.setName("rbRepeatList");
		rbRepeatTrack.setName("rbRepeatTrack");
		rbRepeatNone.setName("rbRepeatNone");
		panel.add(cbShuffle);
		panel.add(Box.createHorizontalGlue());
		panel.add(new JLabel("Repeat:"));
		panel.add(rbRepeatList);
		panel.add(rbRepeatTrack);
		panel.add(rbRepeatNone);

		getContentPane().add(panel);
		
		cbShuffle.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				updateShuffleStatus();				
			}
		});
		
		ItemListener radioButtonListener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				updateRepeatStatus();
			}
		};
		
		rbRepeatList.addItemListener(radioButtonListener);
		rbRepeatNone.addItemListener(radioButtonListener);
		rbRepeatTrack.addItemListener(radioButtonListener);
	}

	
	 private void  initComponents__wrappee__SkipTrack() {
		if (!specifications.Configuration.skiptrack) {
			initComponents__wrappee__ShuffleRepeat();
			return;
		}
		initComponents__wrappee__ShuffleRepeat();
		JButton skipButton = new JButton(">");
		skipButton.setName("skipTrack");
		skipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				skip();
			}
		});
		
		getContentPane().add(skipButton);
	}

	
	
	 private void  initComponents__wrappee__RemoveTrack() {
		if (!specifications.Configuration.removetrack) {
			initComponents__wrappee__SkipTrack();
			return;
		}
		initComponents__wrappee__SkipTrack();
		
		JButton removeButton = new JButton("DEL");
		removeButton.setName("del");
		getContentPane().add(removeButton);
		
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeSelection();
			}
		});
	}

	
	
	 private void  initComponents__wrappee__ClearPlaylist() {
		if (!specifications.Configuration.clearplaylist) {
			initComponents__wrappee__RemoveTrack();
			return;
		}
		initComponents__wrappee__RemoveTrack();
		JButton clearButton = new JButton("Clear");
		clearButton.setName("clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearPlaylist();
			}
		});
		
		getContentPane().add(clearButton);
	}

	
	 private void  initComponents__wrappee__ReorderPlaylist() {
		if (!specifications.Configuration.reorderplaylist) {
			initComponents__wrappee__ClearPlaylist();
			return;
		}
		initComponents__wrappee__ClearPlaylist();
		
		JButton btnUp = new JButton("Up");
		btnUp.setName("up");
		JButton btnDown = new JButton("Down");
		btnDown.setName("down");
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				move(true);	
			}
		});
		
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				move(false);				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(btnUp);
		panel.add(btnDown);
	
		getContentPane().add(panel);
	}

	
	
	 private void  initComponents__wrappee__SaveAndLoadPlaylist() {
		if (!specifications.Configuration.saveandloadplaylist) {
			initComponents__wrappee__ReorderPlaylist();
			return;
		}
		initComponents__wrappee__ReorderPlaylist();
		fcLoad = new JFileChooser();
		fcSave = new JFileChooser();
		
		FileFilter filter = new FileNameExtensionFilter("Playlist File", "m3u");
		fcLoad.setFileFilter(filter);
		fcSave.setFileFilter(filter);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setName("load");
		JButton btnSave = new JButton("Save");
		btnSave.setName("save");
		
		btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				load();			
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				save();				
			}
		});
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(btnLoad);
		panel.add(btnSave);
	
		getContentPane().add(panel);
	}

	
	
	 private void  initComponents__wrappee__QueueTrack() {
		if (!specifications.Configuration.queuetrack) {
			initComponents__wrappee__SaveAndLoadPlaylist();
			return;
		}
		initComponents__wrappee__SaveAndLoadPlaylist();
		JButton queueButton = new JButton("De/Enqueue");
		queueButton.setName("de_enqueue");
		queueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				toggleQueued();
			}
		});
		
		getContentPane().add(queueButton);
	}

	
	 private void  initComponents__wrappee__Light  () {
		if (!specifications.Configuration.light) {
			initComponents__wrappee__QueueTrack();
			return;
		}
		initComponents__wrappee__QueueTrack();
		getContentPane().setBackground(Color.WHITE);
	}

	
	private void initComponents() {
		if (!specifications.Configuration.dark) {
			initComponents__wrappee__Light();
			return;
		}
		initComponents__wrappee__Light();
		getContentPane().setBackground(Color.BLACK);
	}

	
	
	private void addActions() {
		itOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chooseFile();				
			}
		});

		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				play();				
			}
		});
		
		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pause();
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				stop();				
			}
		});
	}

	
	
	 private void  chooseFile__wrappee__Base  () {
		if(fcOpen.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
			return;
		
		File file = fcOpen.getSelectedFile();
		
		playFile(new AudioFile(file));
		
		updateWindow();
	}

	
	
	private void chooseFile() {
		if (!specifications.Configuration.playlist) {
			chooseFile__wrappee__Base();
			return;
		}
		if(fcOpen.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
			return;
		
		File file = fcOpen.getSelectedFile();
		AudioFile audioFile = new AudioFile(file);
		playlist.add(audioFile);
				
		if(playlist.size() == 1)
			playNext();
				
		updateWindow();
	}

	
	
	private void playFile(AudioFile file) {
		try {
			createPlayback(file);
			play();
		}
		catch(UnsupportedAudioFileException e) {
			showError("Unsupported file format.");
		}
		catch(LineUnavailableException e) {
			showError("Unable to access audio device.");
		}
		catch(IOException e) {
			showError("Unable to open file.");
		}
	}

	
	
	private void closePlayback() {
		if(playback != null) {
			playback.close();
			playback = null;
		}
	}

	
	
	 private void  createPlayback__wrappee__Base  (AudioFile audioFile) throws UnsupportedAudioFileException, 
		LineUnavailableException, IOException {
		
		closePlayback();

		if(audioFile != null)
			playback = new Playback(audioFile, updateHandler);
	}

	
	
	 private void  createPlayback__wrappee__ShowCover  (AudioFile audioFile) throws UnsupportedAudioFileException, 
	LineUnavailableException, IOException {
		if (!specifications.Configuration.showcover) {
			createPlayback__wrappee__Base(audioFile);
			return;
		}
		clearCover();
		
		createPlayback__wrappee__Base(audioFile);
		
		byte[] imageData;
		
		if(playback != null && null != (imageData = playback.getAudioFile().getMetaData().getImage())) {
			try {
				BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageData));
				Icon icon;
				
				if(image.getWidth() > COVER_WIDTH || image.getHeight() > COVER_HEIGHT) {
					Image scaled = image.getScaledInstance(Math.min(image.getWidth(), COVER_WIDTH),
							Math.min(image.getHeight(), COVER_HEIGHT),
							Image.SCALE_SMOOTH);
					icon = new ImageIcon(scaled);
				}
				else {
					icon = new ImageIcon(image);
				}
				coverLabel.setText(null);
				coverLabel.setIcon(icon);
			}
			catch(IOException e) {
				e.printStackTrace();
				clearCover();
			}
		}
	}

	
	
	 private void  createPlayback__wrappee__VolumeControl  (AudioFile audioFile) throws UnsupportedAudioFileException, 
	LineUnavailableException, IOException {
		if (!specifications.Configuration.volumecontrol) {
			createPlayback__wrappee__ShowCover(audioFile);
			return;
		}
		createPlayback__wrappee__ShowCover(audioFile);
		playback.setVolume(volume);
	}

	
	
	 private void  createPlayback__wrappee__Mute  (AudioFile file) throws UnsupportedAudioFileException, 
		LineUnavailableException, IOException {
		if (!specifications.Configuration.mute) {
			createPlayback__wrappee__VolumeControl(file);
			return;
		}
		createPlayback__wrappee__VolumeControl(file);
		playback.setMute(muteStatus);
	}

	
	
	private void createPlayback(AudioFile file) throws UnsupportedAudioFileException, 
	LineUnavailableException, IOException {
		if (!specifications.Configuration.playlist) {
			createPlayback__wrappee__Mute(file);
			return;
		}
		playbackStopped = true;
		
		createPlayback__wrappee__Mute(file);
	}

	
	
	private Playback.UpdateHandler updateHandler = new Playback.UpdateHandler() {
		public void update() {
			SwingUtilities.invokeLater(new Runnable() { 
				public void run() { updateWindow(); }
			});
		}
	};

	
	
	 private void  updateWindow__wrappee__Base  () {
		if(playback == null) {
			btnPlay.setEnabled(false);
			btnPause.setEnabled(false);
			btnStop.setEnabled(false);
			setTitle("FeatureAMP");
			return;
		}			
		
		int status = playback.getPlayerStatus();
		btnPlay.setEnabled(status != Playback.STATUS_PLAYING);
		btnPause.setEnabled(status == Playback.STATUS_PLAYING);
		btnStop.setEnabled(status == Playback.STATUS_PLAYING || status == Playback.STATUS_PAUSED);
		MetaData metaData = playback.getAudioFile().getMetaData();
		setTitle(metaData.getArtist() + " - " + metaData.getTitle());
	}

	
	
	 private void  updateWindow__wrappee__ProgressBar  () {
		if (!specifications.Configuration.progressbar) {
			updateWindow__wrappee__Base();
			return;
		}
		updateWindow__wrappee__Base();
		if(playback != null) {
			trackProgress.setMaximum(playback.getAudioFile().getMetaData().getDuration());
			trackProgress.setValue(playback.getPosition());
		}
		else {
			trackProgress.setValue(0);
		}
	}

	
	 private void  updateWindow__wrappee__ShowTime  () {
		if (!specifications.Configuration.showtime) {
			updateWindow__wrappee__ProgressBar();
			return;
		}
		updateWindow__wrappee__ProgressBar();
		
		if(playback != null) {
			setTitle(getTitle() + " (" + formatTime(playback.getPosition()) + "/" 
					+ formatTime(playback.getAudioFile().getMetaData().getDuration()) + ")");
		}
	}

	
	
	private void updateWindow() {
		if (!specifications.Configuration.playlist) {
			updateWindow__wrappee__ShowTime();
			return;
		}
		updateWindow__wrappee__ShowTime();
		
		if(!playbackStopped && playback != null && playback.getPlayerStatus() == Playback.STATUS_FINISHED) {
			playNext();
		}
	}

	
	
	private void showError(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	
	
	 private void  play__wrappee__Base  () {
		playback.play();
	}

	
	
	private void play() {
		if (!specifications.Configuration.playlist) {
			play__wrappee__Base();
			return;
		}
		playbackStopped = false;
		play__wrappee__Base();
	}

	
	
	private void pause() {
		playback.pause();
	}

	
	
	 private void  stop__wrappee__Base  () {
		playback.stop();
	}

	
	
	private void stop() {
		if (!specifications.Configuration.playlist) {
			stop__wrappee__Base();
			return;
		}
		playbackStopped = true;
		stop__wrappee__Base();
	}

	
	
	public static void main(String[] args) {
		
//		Configuration.volumecontrol=true;
//		Configuration.skiptrack=true;
//		Configuration.removetrack=true;
//		Configuration.queueremove=true;
//		Configuration.reorderplaylist=true;
//		Configuration.playlist=true;
//		Configuration.light=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.filesupport=true;
//		Configuration.queuetrack=true;
//		Configuration.mute=true;
//		Configuration.progressbar=true;
//		Configuration.progress=true;
//		Configuration.showtime=true;
//		Configuration.playlistcontrols=true;
//		Configuration.showcover=true;
//		Configuration.loadfolder=true;
//		Configuration.skiprepeat=true;
//		Configuration.shufflerepeat=true;
//		Configuration.base=true;
//		Configuration.wave=true;
//		Configuration.mp3=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.clearplaylist=true;
		
		Configuration.filesupport =true;
		Configuration.gui=true;
		Configuration.base=true;
		Configuration.mp3=true;
		Configuration.progress=true;
		Configuration.skins=true;
		Configuration.light=true;
		Configuration.playlist=true;
		Configuration.saveandloadplaylist=true;
		
		
		
		final Main main = new Main();		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				main.setVisible(true);
			}
		});
	}

	
	static {
		FILE_EXTENSIONS.add("mp3");
	}

	
	private JLabel coverLabel;

	
	private static final int COVER_WIDTH = 150;

	
	private static final int COVER_HEIGHT = 150;

	
	
	private void clearCover() {
		coverLabel.setIcon(null);
	}

	
	static {
		FILE_EXTENSIONS.add("wav");
	}

	
	private JButton volumeUp;

	
	private JButton volumeDown;

	
	private JLabel volumeDisplay;

	
	private JPanel volumePanel;

	
	private int volume = 100;

	
	
	private void increaseVolume() {
		volume = Math.min(volume + 1, 100);
		updateVolumeValue();
	}

	
	
	private void decreaseVolume() {
		volume = Math.max(volume - 1, 0);
		updateVolumeValue();
	}

	
	
	private void updateVolumeValue() {
		if(playback != null)
			playback.setVolume(volume);
		volumeDisplay.setText(String.valueOf(volume) + "%");
		volumeUp.setEnabled(volume < 100);
		volumeDown.setEnabled(volume > 0);
	}

	
	private JButton muteButton;

	
	private boolean muteStatus = false;

	
	private JLabel mutedLabel;

	
	
	private void toggleMute() {
		muteStatus = !muteStatus;
		if(playback != null)
			playback.setMute(muteStatus);
		mutedLabel.setVisible(muteStatus);
	}

	
	private JProgressBar trackProgress;

	
	
	
	private static String formatTime(int seconds) {
		int minutes = seconds / 60;
		int remSeconds = seconds % 60;
		return String.format("%d:%02d", minutes, remSeconds);
	}

	
	private JList<PlaylistItem> liPlaylist;

	
	private JMenuItem itOpenFolder;

	
	private JFileChooser fcFolder;

	

	private boolean playbackStopped = true;

	
	
	private Playlist playlist;

	
	
	private void playNext() {
		AudioFile next = playlist.getNext();
		if(next != null)
			playFile(next);
		else
			playbackStopped = true;
	}

	
	
	 private void  playSelectedFile__wrappee__Playlist  () {
		if(liPlaylist.getSelectedValue() == null)
			return;

		AudioFile file = playlist.moveTo(liPlaylist.getSelectedIndex());
		if(file != null)
			playFile(file);
	}

	
	
	private void playSelectedFile() {
		if (!specifications.Configuration.shufflerepeat) {
			playSelectedFile__wrappee__Playlist();
			return;
		}
		if(rbRepeatTrack.isSelected())
			rbRepeatNone.setSelected(true);
		updateRepeatStatus();
		
		playSelectedFile__wrappee__Playlist();
	}

	
	
	private void chooseFolder() {
		if(fcFolder.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
			return;
		
		File folder = fcFolder.getSelectedFile();
		
		boolean wasEmpty = playlist.empty();
		
		playlist.loadFolder(folder);
		
		if(wasEmpty)
			playNext();
	}

	
	private JRadioButton rbRepeatTrack;

	
	private JRadioButton rbRepeatList;

	
	private JRadioButton rbRepeatNone;

	
	private JCheckBox cbShuffle;

	
	
	private void updateShuffleStatus() {
		playlist.setShuffle(cbShuffle.isSelected());
	}

	
	
	private void updateRepeatStatus() {
		cbShuffle.setEnabled(!rbRepeatTrack.isSelected());
		if(rbRepeatTrack.isSelected()) {
			cbShuffle.setSelected(false);
			playlist.setRepeat(Playlist.Repeat.Track);
			if(playback != null && playback.getPlayerStatus() == Playback.STATUS_PLAYING)
				playbackStopped = false;
		}
		else if(rbRepeatList.isSelected()) {
			playlist.setRepeat(Playlist.Repeat.List);
		}
		else if(rbRepeatNone.isSelected()) {
			playlist.setRepeat(Playlist.Repeat.None);
		}
	}

	
	
	 private void  skip__wrappee__SkipTrack  () {
		playNext();
	}

	
	
	private void skip() {
		if (!specifications.Configuration.skiprepeat) {
			skip__wrappee__SkipTrack();
			return;
		}
		if(rbRepeatTrack.isSelected())
			rbRepeatNone.setSelected(true);
		skip__wrappee__SkipTrack();
	}

	
	
	private void removeItem(PlaylistItem item) {
		if(playback != null && item.getAudioFile().equals(playback.getAudioFile())) {
			playbackStopped = true;
			closePlayback();
			updateWindow();
		}
		
		playlist.remove(item);
			
	}

	
	
	private void removeSelection() {
		for(PlaylistItem item : liPlaylist.getSelectedValuesList())
			removeItem(item);
	}

	
	
	private void clearPlaylist() {
		for(PlaylistItem item : playlist.items())
			removeItem(item);
	}

	
	
	private int getSelectedItem() {
		int[] indices = liPlaylist.getSelectedIndices();
		if(indices.length != 1) {
			showError("None or multiple items selected.");
			return -1;
		}
		
		return indices[0];
			
	}

	
	
	private void move(boolean up) {
		int index = getSelectedItem();
		if(index < 0)
			return;
		playlist.moveItem(index, up);
	}

	
	private JFileChooser fcLoad;

	
	private JFileChooser fcSave;

	
	
	private void load() {		
		if(fcLoad.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
			return;
		
		clearPlaylist();
				
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fcLoad.getSelectedFile()));
			String line;
			
			while(null != (line = reader.readLine())) {
				line = line.trim();
				if(!line.startsWith("#"))
					playlist.add(new AudioFile(new File(line)));
			}
			reader.close();
			
			playNext();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to open file.");
		}		
	}

	
	
	private void save() {
		if(fcSave.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
			return;
		
		File target = fcSave.getSelectedFile();
		if(!target.getName().endsWith(".m3u"))
			target = new File(target.getPath().concat(".m3u"));
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(target));
			for(PlaylistItem item : playlist.items()) {
				writer.append(item.getAudioFile().getFile().getPath());
				writer.newLine();
			}
			writer.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Unable to save file.");
		}
	}

	
	
	private void toggleQueued() {
		for(PlaylistItem item : liPlaylist.getSelectedValuesList())
			playlist.toggleQueued(item);
	}


}
