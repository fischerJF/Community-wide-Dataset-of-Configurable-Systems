package featureamp; 
import java.io.File; 

import java.io.IOException; 
import java.util.List; 
import java.util.Map; 
import java.util.Timer; 
import java.util.TimerTask; 
import java.util.Map.Entry; 

import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException; 
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException; 
import org.jaudiotagger.tag.TagException; 

import featureamp.players.MP3Player; 
import featureamp.players.Player; 
import featureamp.players.Player.Status; 

import java.awt.BorderLayout; 

import java.awt.Component; 

import java.awt.Dimension; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.Observer; 
import java.util.concurrent.ExecutionException; 
import java.util.concurrent.FutureTask; 
import featureamp.gui.IconButton; 

import javax.swing.GroupLayout; 
import javax.swing.JFrame; 

import javax.swing.JMenu; 
import javax.swing.JMenuBar; 

import javax.swing.JMenuItem; 
import javax.swing.JPanel; 
import javax.swing.SwingUtilities; 
import javax.swing.GroupLayout.Alignment; 
import javax.swing.GroupLayout.ParallelGroup; 
import javax.swing.GroupLayout.SequentialGroup; 
import javax.swing.LayoutStyle.ComponentPlacement; 
import javax.swing.border.EmptyBorder; 

import featureamp.dialog.FileDialog; 
import featureamp.dialog.OpenDialog; 
import featureamp.dialog.SaveDialog; 
import javax.swing.event.ChangeEvent; 

import javax.swing.event.ChangeListener; 
import java.awt.Color; 
import javax.swing.JTable; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import java.util.ArrayList; 
import javax.swing.JScrollPane; 
import javax.swing.ListSelectionModel; 
import javax.swing.event.ListSelectionEvent; 
import javax.swing.event.ListSelectionListener; 
import javax.swing.table.TableRowSorter; 

import featureamp.playlist.PlaylistDataModel; 

import featureamp.FeatureAmp; 
import featureamp.Song; 
import javax.swing.JPopupMenu; 

import featureamp.Mp3Song; 
import javax.swing.JTabbedPane; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 

import christophedelory.playlist.m3u.M3U; 
import christophedelory.playlist.m3u.M3UProvider; 
import christophedelory.playlist.m3u.Resource; 
import java.util.Collections; 
import java.util.Iterator; 
import java.util.LinkedList; 
import java.util.Random; 

import javax.swing.DropMode; 

import featureamp.reorderplaylist.TableRowTransferHandler; 

import javax.swing.BoxLayout; 
import javax.swing.ImageIcon; 

import javax.swing.JLabel; 
import javax.swing.SwingConstants; 
import javax.swing.JSlider; 
import featureamp.util.Util;
import specifications.Configuration;

import org.jaudiotagger.audio.exceptions.CannotReadException; 

public   class  FeatureAmp  extends JFrame  implements ActionListener, ChangeListener, ListSelectionListener, MouseListener {
	
	private Song currentSong;

	
	
	private Player player;

	
	
	private Timer currentPositionTimer;

	
	
	public FeatureAmp  () {
		if (specifications.Configuration.base) {
			System.out.println("Base()");
				}
	
		if (specifications.Configuration.gui) {
			setLayout(new BorderLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			openDialog = FileDialog.chooser(this/*, this, ".mp3"*/);
			saveDialog = SaveDialog.saver(this/*, this, ".m3u"*/);
			openFile = new JMenuItem("Open file");
			openFile.addActionListener(this);
				}
	
		if (specifications.Configuration.light) {
			getContentPane().setBackground(THEME_COLOR_BG);
				}
	
		if (specifications.Configuration.dark) {
			getContentPane().setBackground(THEME_COLOR_BG);
				}
	
		if (specifications.Configuration.playlist) {
			playlistTable = initPlaylist();
			playlistTable.setName("p_list");
			playlist = (PlaylistDataModel) playlistTable.getModel();
				}
	
		if (specifications.Configuration.playlistcontextmenu) {
			playlistContextMenu = new JPopupMenu("Queue Track");
				}
	
		if (specifications.Configuration.tageditor) {
			openTagEditorMenuItem = new JMenuItem("Open ID3 Tag Editor");
			openTagEditorMenuItem.addActionListener(this);
			playlistContextMenu.add(openTagEditorMenuItem);
			
			tagEditor = new JFrame("Tag Editor");
				}
	
		if (specifications.Configuration.playlisttabs) {
			playlistTabs = new JTabbedPane();
				}
	
		if (specifications.Configuration.loadfolder) {
			loadFolder = new JMenuItem("Load Folder");
			loadFolder.addActionListener(this);
				}
	
		if (specifications.Configuration.saveandloadplaylist) {
			loadPlaylist.addActionListener(this);
			savePlaylist.addActionListener(this);
				}
	
		if (specifications.Configuration.skiptrack) {
			previousButton = new IconButton("\uf048");
			previousButton.setName("previousButton");
			nextButton = new IconButton("\uf051");
			nextButton.setName("nextButton");
			nextButton.addActionListener(this);
				}
	
		if (specifications.Configuration.shufflerepeat) {
			shuffleRepeatButton = new IconButton("\uf01e");
			shuffleRepeatButton.setName("shuffle");
			shuffleRepeatButton.setPreferredSize(new Dimension(25,25));
			shuffleRepeatButton.setToolTipText("Shuffle: Play playlist once.");
			shuffleRepeatButton.addActionListener(this);
				}
	
		if (specifications.Configuration.removetrack) {
			removeTrack = new JMenuItem("Remove Track");
			removeTrack.setEnabled(false);
			removeTrack.addActionListener(this);
			}
	
		if (specifications.Configuration.clearplaylist) {
			clearPlaylistButton = new JMenuItem("Clear Playlist");
			clearPlaylistButton.addActionListener(this);
				}
	
		if (specifications.Configuration.queuetrack) {
			addToQueueMenuItem = new JMenuItem("Add Selected Tracks");
			addToQueueMenuItem.addActionListener(this);
			playlistContextMenu.add(addToQueueMenuItem);
			
			removeFromQueuePopupMenu = new JPopupMenu("Queue");
			removeFromQueueMenuItem = new JMenuItem("Remove Selected Tracks");
			removeFromQueueMenuItem.addActionListener(this);
			removeFromQueuePopupMenu.add(removeFromQueueMenuItem);
			
	        queueTable = addPlaylist("Queue");
	        queueTable.setRowSorter(null);
			queue = (PlaylistDataModel) queueTable.getModel();
				}
	
		if (specifications.Configuration.multipleplaylists) {
			addPlaylistMenuItem = new JMenuItem("New Playlist");
			addPlaylistMenuItem.addActionListener(this);
				}
	
		if (specifications.Configuration.showcover) {
			coverPanel.setLayout(new BoxLayout(coverPanel, BoxLayout.Y_AXIS));
			coverPanel.add(noCoverLabel);
			add(coverPanel, BorderLayout.WEST);
				}
	
		if (specifications.Configuration.volumecontrol) {
			volumeLabel.setPreferredSize(new Dimension(40, 20));
			volumeSlider.setName("volumeSlider");
			volumeSlider.setMinimum(0);
			volumeSlider.setMaximum(100);
			volumeSlider.setValue(100);
			volumeSlider.setPreferredSize(new Dimension(100,25));
			volumeSlider.setMaximumSize(new Dimension(100, 25));
			volumeSlider.addChangeListener(this);
				}
	
		if (specifications.Configuration.mute) {
			
				}
	}

	
	
	private void pause() {
		if(player != null) {
			if(player.getPlayerStatus() == Status.PLAYING) {
				player.pause();
				//pauseButton.setEnabled(false);
				//playButton.setEnabled(true);
				playButton.setText(String.valueOf(ICON_CODE_PLAY));
				stopButton.setEnabled(true);
				stopTimer();
			}
		}
	}

	
	
	private void resume() {
		if(player != null) {
			if(player.getPlayerStatus() == Status.PAUSED) {
				player.resume();
				playButton.setText(String.valueOf(ICON_CODE_PAUSE));
				stopButton.setEnabled(true);
				startTimer();
			}
		}
	}

	
	
	public void unloadSong() {
		if(player != null) {
//			System.out.println("[FeatureAmp.unloadSong]");
			player.close();
			stop();
			player = null;
			playButton.setEnabled(false);
			currentSong = null;
			unload();
			// invokePluginMethod("unload", PlayerEventsListener.class);
			// unload()
		}
	}

		
	
	 private void  stop__wrappee__Base  () {
//		System.out.println("[FeatureAmp.stop]");
		stopTimer();
		player.stop();
		playButton.setText(String.valueOf(ICON_CODE_PLAY));
		stopButton.setEnabled(false);
	}

	
	
	 private void  stop__wrappee__GUI  () {
		if (!specifications.Configuration.gui) {
			stop__wrappee__Base();
			return;
		}
		stop__wrappee__Base();
		String title = updateTitlesAndLabels();
		setTitle(title);
	}

	
	
	public void stop() {
		if (!specifications.Configuration.shufflerepeat) {
			stop__wrappee__GUI();
			return;
		}
		stop__wrappee__GUI();
		resetShuffleType();
	}

	
	
	private void stopTimer() {
		currentPositionTimer.cancel();
		currentPositionTimer.purge();
	}

	
	
	private void startTimer() {
		currentPositionTimer = new Timer();
		currentPositionTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				timerTick();
			}
		}, 100, 100);
	}

	
	
	
	
	 private void  timerTick__wrappee__Base  () {
		if(player != null) {
			long millis_current = player.getPosition() / 1000;
			long millis_total = player.getLength() / 1000;
			
			if(millis_current >= millis_total) {
				_onSongEnded();
			}
			else {
				tick();
				updateTitlesAndLabels();
			}
		}
	}

	
	 
	 private void timerTick() {
		if (!specifications.Configuration.gui) {
			timerTick__wrappee__Base();
			return;
		}
		 timerTick__wrappee__Base();
		 if(player != null) {
			 String title = updateTitlesAndLabels();
			 setTitle(title);
		 }
	 }

	
	
	private void _onSongEnded() {
		stop();
		ended();
		playNextSong();
	}

	
	
	private void playNextSong() {
		Song nextSong = getNextSong();
		
		/*
		Map<Plugin,Object> nextSongReturnValues = invokePluginMethod("nextSong", NextSongProvider.class);
		for(Entry<Plugin, Object> entry : nextSongReturnValues.entrySet()) {
			if(entry.getValue() != null && entry.getValue() instanceof Song) {
				nextSong = (Song) entry.getValue();
			}
		}
		
		Map<Plugin,Object> nextSongOverrideReturnValues = invokePluginMethod("nextSongOverride", NextSongProvider.class);
		for(Entry<Plugin, Object> entry : nextSongOverrideReturnValues.entrySet()) {
			if(entry.getValue() != null && entry.getValue() instanceof Song) {
				nextSong = (Song) entry.getValue();
			}
		}
		*/
		
		if(nextSong != null) {
			playSong(nextSong);
		}
	}

	
	
	private void playPreviousSong() {
		Song song = getPreviousSong();
		
		if(song != null) {
			playSong(song);
		}
	}

	
	
	 private Song  getNextSong__wrappee__Base  () {
		System.out.println("[Base.getNextSong] NULL");
		return null;
	}

	
	
	/*
	 public void playSongAt(int pos) {
		System.out.println("[Playlist] playSongAt: " + pos);
		PlaylistDataModel p = (PlaylistDataModel) playlistTable.getModel();
		Song song = p.getSong(pos);
		amp.playSong(song);
	}
	*/
	
	 private Song  getNextSong__wrappee__Playlist  () {
		if (!specifications.Configuration.playlist)
			return getNextSong__wrappee__Base();
		System.out.println("[Playlist.getNextSong]");
		
		if(currentSongIndex != null && currentSongIndex < playlist.getRowCount() - 1) {
			currentSongIndex++;
			PlaylistDataModel p = (PlaylistDataModel) playlistTable.getModel();
			int index = playlistTable.getRowSorter().convertRowIndexToModel(currentSongIndex);
			return p.getSong(index);
		}
		
		return getNextSong__wrappee__Base();
	}

	

	 private Song  getNextSong__wrappee__ShuffleRepeat  () {
		if (!specifications.Configuration.shufflerepeat)
			return getNextSong__wrappee__Playlist();
		System.out.println("[ShuffleRepeat.getNextSong]");
		
		switch(shuffleType) {
			case REPEAT_ONCE :
				// Do nothing!
			break;
			case REPEAT_PLAYLIST :
				// Only if we reached the end play song
				if(currentSongIndex >= playlist.getRowCount()-1) {
					return playlist.getSongs()[0];
				}
				break;
			case REPEAT_ONE :
				return currentSong;
			case SHUFFLE_RANDOM :
				if(playlistRandomSongIterator.hasNext()) {
					int next = playlistRandomSongIterator.next();
					return playlist.getSongs()[next];
				} else {
					System.err.println("No more songs to play.");
				}
				break;
		}
		
		return getNextSong__wrappee__Playlist();
	}

	
	
	private Song getNextSong() {
		if (!specifications.Configuration.queuetrack)
			return getNextSong__wrappee__ShuffleRepeat();
		if(queue.getRowCount() > 0) {
			System.out.println("[QueueTrack.getNextSong]");
			Song song = queue.getSong(0);
			queue.remove(song);
			return song;
		}
		
		return getNextSong__wrappee__ShuffleRepeat();
	}

	
	
	private Song getPreviousSong() {
		return null;
	}

	
	
	private void filesLoaded(List<File> files) {
		for(File f : files) {
			notifySongLoaded(fileToSong(f));
		}
	}

	
	
	 private Song  fileToSong__wrappee__Base  (File f) {
		return null;
	}

	
	 private Song  fileToSong__wrappee__Mp3  (File f) {
		if (!specifications.Configuration.mp3)
			return fileToSong__wrappee__Base(f);
		if(f.getName().endsWith("mp3")) {
			try {
				return new Mp3Song(f);
			} catch (TagException e) {
				e.printStackTrace();
			} catch (ReadOnlyFileException e) {
				e.printStackTrace();
			} catch (InvalidAudioFrameException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return fileToSong__wrappee__Base(f);
	}

	
	 private Song  fileToSong__wrappee__Wav  (File f) {
		if (!specifications.Configuration.wav)
			return fileToSong__wrappee__Mp3(f);
		if(f.getName().endsWith("wav")) {
			try {
				return new WavSong(f);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return fileToSong__wrappee__Mp3(f);
	}

	
	 private Song  fileToSong__wrappee__Aac  (File f) {
		if (!specifications.Configuration.aac)
			return fileToSong__wrappee__Wav(f);
		if(f.getName().endsWith("aac")) {
			try {
				return new AacSong(f);
			} catch (TagException e) {
				e.printStackTrace();
			} catch (ReadOnlyFileException e) {
				e.printStackTrace();
			} catch (InvalidAudioFrameException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch(CannotReadException e) {
				e.printStackTrace();
			}
		}
		
		return fileToSong__wrappee__Wav(f);
	}

	
	private Song fileToSong(File f) {
		if (!specifications.Configuration.ogg)
			return fileToSong__wrappee__Aac(f);
		if(f.getName().endsWith("ogg")) {
			try {
				return new OggSong(f);
			} catch (TagException e) {
				e.printStackTrace();
			} catch (ReadOnlyFileException e) {
				e.printStackTrace();
			} catch (InvalidAudioFrameException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch(CannotReadException e) {
				
			}
		}
		
		return fileToSong__wrappee__Aac(f);
	}

	
	
	 private void  notifySongLoaded__wrappee__Base  (Song song) {
		// Always play song if there is no current song
		System.out.println("[Base] notifySongLoaded: " + song);
		if(currentSong == null || checkPlaySong(song)) {
			playSong(song);
		}
	}

	
	
	private void notifySongLoaded(Song song) {
		if (!specifications.Configuration.playlist) {
			notifySongLoaded__wrappee__Base(song);
			return;
		}
		System.out.println("[Playlist.notifySongLoaded]");
		playlist.append(song);
		notifySongLoaded__wrappee__Base(song);
		updateSongIndex();
	}

	
	
	 private boolean  checkPlaySong__wrappee__Base  (Song song) {
		return true;
	}

	
	
	public boolean checkPlaySong(Song song) {
		if (!specifications.Configuration.playlist)
			return checkPlaySong__wrappee__Base(song);
		// From Playlist
		return false;
	}

	
	
	public void playSong(Song song) {
		if(player != null) {
			unloadSong();
		}
		
		if(player == null || player.getPlayerStatus() == Status.READY || player.getPlayerStatus() == Status.STOPPED) {
			currentSong = song;
			System.out.println("[Base.playSong] Load: " + currentSong);
			try {
				player = new MP3Player(currentSong.getFilePath());
				load();
				playButton.setText(String.valueOf(ICON_CODE_PAUSE));
				playButton.setName("play");
				playButton.setEnabled(true);
				play();
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				e1.printStackTrace();
			}
		} else if(player.getPlayerStatus() == Status.PAUSED) {
			System.out.println("[FeatureAmp.playSong] Resume");
			player.resume();
		}
		
		startTimer();
		stopButton.setEnabled(true);
		playButton.setText(String.valueOf(ICON_CODE_PAUSE));
	}

	
	
	 private void  play__wrappee__Base  () {
		player.play();
	}

	
	
	/**
	 * When a song is played, load its cover
	 */
	
	 private void  play__wrappee__ShowCover  () {
		if (!specifications.Configuration.showcover) {
			play__wrappee__Base();
			return;
		}
		play__wrappee__Base();
		byte[] albumImageData = currentSong.getImage();
		coverPanel.removeAll();
		if(albumImageData != null) {
			ImageIcon image = new ImageIcon(albumImageData);
			ImageIcon resized = new ImageIcon(image.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH));
			JLabel label = new JLabel(resized);
			label.setVerticalAlignment(SwingConstants.BOTTOM);
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setMinimumSize(new Dimension(100, 100));
			label.setMaximumSize(new Dimension(250, 250));
			coverPanel.add(label);
		} else {
			unload();
		}
		songNameLabel.setText(currentSong.getTitle());
		coverPanel.add(songNameLabel);
	}

	
	
	private void play() {
		if (!specifications.Configuration.progressbar) {
			play__wrappee__ShowCover();
			return;
		}
		play__wrappee__ShowCover();
		positionSlider.setEnabled(true);
		positionSlider.setMaximum(currentSong.getLengthInSeconds() * 10);
		positionSlider.setValue(0);
		label_time_played.setText("00:00");
		label_time_remaining.setText(currentSong.getLength());
	}

	
	
	/**
	 * Empty Stubs
	 */
	
	 private void  load__wrappee__Base  () {
		
	}

	
	
	 private void  load__wrappee__Playlist  () {
		if (!specifications.Configuration.playlist) {
			load__wrappee__Base();
			return;
		}
		load__wrappee__Base();
		updateSongIndex();
	}

	
	
	 private void  load__wrappee__VolumeControl  () {
		if (!specifications.Configuration.volumecontrol) {
			load__wrappee__Playlist();
			return;
		}
		load__wrappee__Playlist();
		player.setVolume(volumeSlider.getValue() / ((float) volumeSlider.getMaximum()));
	}

	
	
	private void load() {
		if (!specifications.Configuration.mute) {
			load__wrappee__VolumeControl();
			return;
		}
		load__wrappee__VolumeControl();
		if(muted) {
			System.out.println("Mute after load");
			player.mute();
		}
	}

	
	
	 private void  unload__wrappee__Base  () {
		
	}

	
	
	 private void  unload__wrappee__Playlist  () {
		if (!specifications.Configuration.playlist) {
			unload__wrappee__Base();
			return;
		}
		unload__wrappee__Base();
		currentSongIndex = null;
	}

	
	
	/**
	 * When the song is unloaded (not stopped!) remove cover
	 */
	
	 private void  unload__wrappee__ShowCover  () {
		if (!specifications.Configuration.showcover) {
			unload__wrappee__Playlist();
			return;
		}
		coverPanel.removeAll();
		coverPanel.add(noCoverLabel);
	}

	
	
	private void unload() {
		if (!specifications.Configuration.progressbar) {
			unload__wrappee__ShowCover();
			return;
		}
		unload__wrappee__ShowCover();
		positionSlider.setValue(0);
		label_time_played.setText("--:--");
		label_time_remaining.setText("--:--");
	}

	
	
	 private void  ended__wrappee__Base  () {
		
	}

	
	
	private void ended() {
		if (!specifications.Configuration.progressbar) {
			ended__wrappee__Base();
			return;
		}
		ended__wrappee__Base();
		positionSlider.setValue(0);
		positionSlider.setEnabled(false);
	}

	
	
	 private void  tick__wrappee__Base  () {
		
	}

	
	
	private void tick() {
		if (!specifications.Configuration.progressbar) {
			tick__wrappee__Base();
			return;
		}
		long millis_current = player.getPosition() / 1000;
		String currentTime = Util.secondsToTimeString((int) (millis_current / 1000));
		positionSlider.setValue( (int) (millis_current / 100) );
		label_time_played.setText(currentTime);
	}

	
	
	private IconButton playButton;

	

	private IconButton stopButton;

	
	
	private JPanel controlsPanel;

	
	
	private SequentialGroup sg;

	
	
	private ParallelGroup pg;

	
	
	private JMenuItem openFile;

	
	
	private final static String ICON_CODE_PLAY = "\uF04B";

	
	
	private final static String ICON_CODE_PAUSE = "\uF04C";

	
	
	private final static String ICON_CODE_STOP = "\uF04D";

	
	
	private SaveDialog saveDialog;

	
	
	private OpenDialog openDialog;

	
	
	 private void  launch__wrappee__GUI  () {
		addComponents();
		createControls();
		createMenus();
		setVisible(true);
		pack();
	}

	
	
	private void launch() {
		if (!specifications.Configuration.light) {
			launch__wrappee__GUI();
			return;
		}
		launch__wrappee__GUI();
	}

	
	
	 private void  addComponents__wrappee__GUI  () {
	}

	
	
	 private void  addComponents__wrappee__Playlist  () {
		if (!specifications.Configuration.playlist) {
			addComponents__wrappee__GUI();
			return;
		}
		addComponents__wrappee__GUI();
		addPlaylistToLayout();
	}

	
	
	private void addComponents() {
		if (!specifications.Configuration.playlisttabs) {
			addComponents__wrappee__Playlist();
			return;
		}
		addComponents__wrappee__Playlist();
		add(playlistTabs, BorderLayout.CENTER);
	}

	
	
	public static void main(String[] args) {
		
		
		
//		Configuration.skiptrack=true;
//		Configuration.volumecontrol=true;
//		Configuration.playlistcontrol=true;
//		Configuration.removetrack=true;
//		Configuration.time=true;
//		Configuration.wav=true;
//		Configuration.reorderplaylist=true;
//		Configuration.mp3=true;
//		Configuration.playlist=true;
//		Configuration.light=true;
//		Configuration.saveandloadplaylist=true;
//		Configuration.changelistener=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.queuetrack=true;
//		Configuration.filesupport=true;
//		Configuration.playlistcontextmenu=true;
//		Configuration.mute=true;
//		Configuration.progressbar=true;
//		Configuration.tageditor=true;
//		Configuration.showtime=true;
//		Configuration.aac=true;
//		Configuration.loadfolder=true;
//		Configuration.multipleplaylists=true;
//		Configuration.showcover=true;
//		Configuration.playlistmenu=true;
//		Configuration.shufflerepeat=true;
//		Configuration.base=true;
//		Configuration.ogg=true;
//		Configuration.playlisttabs=true;
//		Configuration.addplaylistwrapper=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.clearplaylist=true;
		
//		Configuration.filesupport=true;
//		Configuration.aac=true;
//		Configuration.featureamp=true;
//		Configuration.base=true;
//		Configuration.gui=true;
//			Configuration.skins=true;
//  		    Configuration.light=true;
//  		Configuration.time=true;
//  		Configuration.showtime=true;
//		
		Configuration.filesupport=true;
		Configuration.mp3=true;
		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.gui=true;
		Configuration.skins=true;
  		Configuration.light=true;
  		Configuration.playlist=true;
  		Configuration.loadfolder=true;
  		Configuration.playlistcontextmenu=true;
  		Configuration.queuetrack=true;
  		Configuration.playlisttabs=true;
  		Configuration.multipleplaylists=true;
  		Configuration.playlistmenu=true;
  		
  		
  		
  		
  		
  		
  		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FeatureAmp amp = new FeatureAmp();
				amp.launch();
			}
		});
	}

	
	
	 private void  createControls__wrappee__GUI  () {
		controlsPanel = new JPanel();
		controlsPanel.setBorder(new EmptyBorder(10, 10, 10, 10) );
		
		GroupLayout groupLayoutPanel = new GroupLayout(controlsPanel);
		controlsPanel.setLayout(groupLayoutPanel);
		sg = groupLayoutPanel.createSequentialGroup();
		pg = groupLayoutPanel.createParallelGroup(Alignment.CENTER);
		
		createPlayButton();
		createStopButton();
		
		// TODO add other controls
		
		groupLayoutPanel.setHorizontalGroup(sg);
		groupLayoutPanel.setVerticalGroup(pg);
		add(controlsPanel, BorderLayout.SOUTH);
		
		controlsPanel.setBackground(THEME_COLOR_BG);
	}

	

	 private void  createControls__wrappee__ShuffleRepeat  () {
		if (!specifications.Configuration.shufflerepeat) {
			createControls__wrappee__GUI();
			return;
		}
		createControls__wrappee__GUI();
		addControl(shuffleRepeatButton);
	}

	
	
	 private void  createControls__wrappee__VolumeControl  () {
		if (!specifications.Configuration.volumecontrol) {
			createControls__wrappee__ShuffleRepeat();
			return;
		}
		createControls__wrappee__ShuffleRepeat();
		addControl(volumeSlider);
		addControl(volumeLabel);
	}

	
	
	 private void  createControls__wrappee__Mute  () {
		if (!specifications.Configuration.mute) {
			createControls__wrappee__VolumeControl();
			return;
		}
		muteButton = new IconButton("\uf028");
		muteButton.setName("mute");
		muteButton.addActionListener(this);
		createControls__wrappee__VolumeControl();
		addControl(muteButton);
	}

	
	
	private void createControls() {
		if (!specifications.Configuration.progressbar) {
			createControls__wrappee__Mute();
			return;
		}
		createControls__wrappee__Mute();
		
		positionSlider = new JSlider();
		positionSlider.setValue(0);
		positionSlider.setName("progress");
		
		positionSlider.setEnabled(false);
		positionSlider.addChangeListener(this);
		label_time_played = new JLabel("--:--");
		label_time_remaining = new JLabel("--:--");
		label_time_played.setMinimumSize(new Dimension(60,25));
		label_time_remaining.setMinimumSize(new Dimension(60,25));
		
		addControl(label_time_played);
		addControl(positionSlider);
		addControl(label_time_remaining);
	}

	
	
	 private void  createPlayButton__wrappee__GUI  () {
		playButton = new IconButton(ICON_CODE_PLAY, 25);
		playButton.setPreferredSize(new Dimension(35, 35));
		playButton.setEnabled(false);
		playButton.addActionListener(this);
		addControl(playButton);
	}

	
	
	private void createPlayButton() {
		if (!specifications.Configuration.skiptrack) {
			createPlayButton__wrappee__GUI();
			return;
		}
		addControl(previousButton);
		createPlayButton__wrappee__GUI();
		addControl(nextButton);
	}

	
	
	private void createStopButton() {
		stopButton = new IconButton(ICON_CODE_STOP);
		stopButton.setName("stop");
		stopButton.setPreferredSize(new Dimension(25, 25));
		stopButton.setEnabled(false);
		stopButton.addActionListener(this);
		addControl(stopButton);
	}

	
	
	public FutureTask<List<File>> openFileChooser(boolean allowDirectories, String ...allowedFileExtensions) {
		return openDialog.choose(allowDirectories, allowedFileExtensions);
	}

	
	
	public FutureTask<List<File>> openFileSaver(String ...allowedFileExtensions) {
		return saveDialog.save(allowedFileExtensions);
	}

	
	
	
	 private void  actionPerformed__wrappee__GUI(ActionEvent e) {
		Object source = e.getSource();
		if(source == openFile) {
			try {
				List<File> files = openFileChooser(false).get();
				if(files != null) {
					System.out.println("File Loaded: " + files.get(0));
					filesLoaded(files);
				}
			} catch(NullPointerException ex) {
				ex.printStackTrace();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
		} else  if(source == playButton) {
			if(player != null) {
				if(player.getPlayerStatus() == Status.PLAYING) {
					pause();
				} else if(player.getPlayerStatus() == Status.PAUSED) {
					resume();
				} else {
					playSong(currentSong);
				}
			} else {
				playSong(currentSong);
			}
		} else if(source == stopButton) {
			stop();
			// invokePluginMethod("stop", PlayerEventsListener.class);
		}
	}

	
	
	
	 private void  actionPerformed__wrappee__LoadFolder(ActionEvent e) {
		if (!specifications.Configuration.loadfolder) {
			actionPerformed__wrappee__GUI(e);
			return;
		}
		actionPerformed__wrappee__GUI(e);
		
		Object source = e.getSource();
		if(source == loadFolder) {
			try {
				List<File> files = openFileChooser(true).get();
				if(files == null) {
					return;
				}
				filesLoaded(files);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
		}
	}

	
	
	/**
	 * SaveAndLoadPlaylist
	 */
	
	
	 private void  actionPerformed__wrappee__SaveAndLoadPlaylist(ActionEvent e) {
		if (!specifications.Configuration.saveandloadplaylist) {
			actionPerformed__wrappee__LoadFolder(e);
			return;
		}
		actionPerformed__wrappee__LoadFolder(e);
		
		Object source = e.getSource();
		if(source == loadPlaylist) {
			loadPlaylist();
		} else if(source == savePlaylist) {
			savePlaylist();
		}
	}

	
	
	
	 private void  actionPerformed__wrappee__SkipTrack(ActionEvent e) {
		if (!specifications.Configuration.skiptrack) {
			actionPerformed__wrappee__SaveAndLoadPlaylist(e);
			return;
		}
		actionPerformed__wrappee__SaveAndLoadPlaylist(e);
		
		Object source = e.getSource();
		if(source == nextButton) {
			playNextSong();
		} else if(source == previousButton) {
			playPreviousSong();
		}
	}

	

	
	 private void  actionPerformed__wrappee__ShuffleRepeat(ActionEvent ev) {
		if (!specifications.Configuration.shufflerepeat) {
			actionPerformed__wrappee__SkipTrack(ev);
			return;
		}
		actionPerformed__wrappee__SkipTrack(ev);
		
		if(ev.getSource() == shuffleRepeatButton) {
			// REPEAT_ONCE, SHUFFLE_RANDOM, REPEAT_ONE, REPEAT_PLAYLIST
			switch(shuffleType) {
				case REPEAT_ONCE:
					setShuffleType(ShuffleType.SHUFFLE_RANDOM);
				break;
				case SHUFFLE_RANDOM :
					setShuffleType(ShuffleType.REPEAT_ONE);
					break;
				case REPEAT_ONE :
					setShuffleType(ShuffleType.REPEAT_PLAYLIST);
					break;
				case REPEAT_PLAYLIST :
					setShuffleType(ShuffleType.REPEAT_ONCE);
					break;
			}
		}
	}

	
	
	
	 private void  actionPerformed__wrappee__RemoveTrack(ActionEvent ev) {
		if (!specifications.Configuration.removetrack) {
			actionPerformed__wrappee__ShuffleRepeat(ev);
			return;
		}
		actionPerformed__wrappee__ShuffleRepeat(ev);
		if(ev.getSource() == removeTrack) {
			removeSelectedSongs();
			removeTrack.setEnabled(false);
		}
	}

	
	
	
	 private void  actionPerformed__wrappee__ClearPlaylist(ActionEvent e) {
		if (!specifications.Configuration.clearplaylist) {
			actionPerformed__wrappee__RemoveTrack(e);
			return;
		}
		actionPerformed__wrappee__RemoveTrack(e);
		
		if(e.getSource() == clearPlaylistButton) {
			clearPlaylist();
			unloadSong();
		}
	}

	
	
	
	 private void  actionPerformed__wrappee__QueueTrack(ActionEvent e) {
		if (!specifications.Configuration.queuetrack) {
			actionPerformed__wrappee__ClearPlaylist(e);
			return;
		}
		actionPerformed__wrappee__ClearPlaylist(e);
		
		Object source = e.getSource();
		if(source == addToQueueMenuItem) {
			int[] selectedRows = contextMenuTable.getSelectedRows();
			for(int i : selectedRows) {
				int index = contextMenuTable.convertRowIndexToModel(i);
				Song song = ((PlaylistDataModel) contextMenuTable.getModel()).getSong(index);
				queue.append(song);
			}
		} else if(source == removeFromQueueMenuItem) {
			int[] selectedRows = contextMenuTable.getSelectedRows();
			for(int i : selectedRows) {
				int index = contextMenuTable.convertRowIndexToModel(i);
				Song song = ((PlaylistDataModel) contextMenuTable.getModel()).getSong(index);
				queue.remove(song);
			}
		}
	}

	
	
	
	 private void  actionPerformed__wrappee__MultiplePlaylists(ActionEvent e) {
		if (!specifications.Configuration.multipleplaylists) {
			actionPerformed__wrappee__QueueTrack(e);
			return;
		}
		actionPerformed__wrappee__QueueTrack(e);
		
		Object source = e.getSource();
		
		if(source == addPlaylistMenuItem) {
			addPlaylist("New Playlist");
		}
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!specifications.Configuration.mute) {
			actionPerformed__wrappee__MultiplePlaylists(e);
			return;
		}
		actionPerformed__wrappee__MultiplePlaylists(e);
		
		Object source = e.getSource();
		 if(source == muteButton) {
			muted = !muted;
			if(muted) {
				muteButton.setText("\uf026");
			} else {
				muteButton.setText("\uf027");
			}
			
			if(player != null) {
				if(muted) {
					player.unmute();
				} else {
					player.mute();
				}
			}
		}
	}

	
	
	/**
	 * Add a specific control to the controls panel
	 * 
	 * @param component Control to add
	 */
	
	private void addControl(Component component) {
		component.setBackground(THEME_COLOR_BG);
		component.setForeground(THEME_COLOR_FG);
		// min, pref, max
		// GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE
		//System.out.println(component + " -> " + component.getMinimumSize().width + " " + component.getPreferredSize().width + " " + component.getMaximumSize().width);
		if(component.getMinimumSize().width <= component.getPreferredSize().width && component.getPreferredSize().width <= component.getMaximumSize().width) {
			sg.addComponent(component, component.getMinimumSize().width, component.getPreferredSize().width, component.getMaximumSize().width);
		} else {
			sg.addComponent(component, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
		}
		
		sg.addPreferredGap(ComponentPlacement.UNRELATED);
		pg.addComponent(component, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
	}

	
	
	private JMenuBar menuBar;

	
	
	 private void  createMenus__wrappee__GUI  () {
		menuBar = new JMenuBar();
		createFileMenu();
		setJMenuBar(menuBar);
	}

	
	
	private void createMenus() {
		if (!specifications.Configuration.playlistmenu) {
			createMenus__wrappee__GUI();
			return;
		}
		createMenus__wrappee__GUI();
		createPlaylistMenu();
	}

	
	
	private JMenu fileMenu;

	
	
	 private void  createFileMenu__wrappee__GUI  () {
		fileMenu = new JMenu("File");
		fileMenu.add(openFile);
		menuBar.add(fileMenu);
	}

	
	
	private void createFileMenu() {
		if (!specifications.Configuration.loadfolder) {
			createFileMenu__wrappee__GUI();
			return;
		}
		createFileMenu__wrappee__GUI();
		fileMenu.add(loadFolder);
	}

	
	
	  private String  updateTitlesAndLabels__wrappee__GUI  () {
		String title = currentSong.getArtist() + " - " + currentSong.getTitle();
		return title;
	}

	
	private String updateTitlesAndLabels() {
		if (!specifications.Configuration.showtime)
			return updateTitlesAndLabels__wrappee__GUI();
		String title = updateTitlesAndLabels__wrappee__GUI();
		long millis_current = player.getPosition() / 1000;
		String currentTime = Util.secondsToTimeString((int) (millis_current / 1000));
		title += " " + currentTime + " / " + currentSong.getLength();
		return title;
	}

	
	
	 private void  stateChanged__wrappee__ChangeListener(ChangeEvent arg0) {
			
	}

	
	
	
	 private void  stateChanged__wrappee__VolumeControl(ChangeEvent e) {
		if (!specifications.Configuration.volumecontrol) {
			stateChanged__wrappee__ChangeListener(e);
			return;
		}
		stateChanged__wrappee__ChangeListener(e);
		Object source = e.getSource();
		if(source == volumeSlider) {
			volumeChanged(e);
		}
	}

	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if (!specifications.Configuration.progressbar) {
			stateChanged__wrappee__VolumeControl(e);
			return;
		}
		stateChanged__wrappee__VolumeControl(e);
		Object source = e.getSource();
		
		if(source == positionSlider) {
			if(player != null) {
				if(positionSlider.getValue() != ((int) player.getPosition() / 1000 / 100)) {
					player.seek(positionSlider.getValue() * 1000 * 100);
				}
			}
		}
	}

	
	private JMenu playlistMenu;

	
	
	 private void  createPlaylistMenu__wrappee__PlaylistMenu  () {
		playlistMenu = new JMenu("Playlist");
		menuBar.add(playlistMenu);
	}

	

	 private void  createPlaylistMenu__wrappee__SaveAndLoadPlaylist  () {
		if (!specifications.Configuration.saveandloadplaylist) {
			createPlaylistMenu__wrappee__PlaylistMenu();
			return;
		}
		createPlaylistMenu__wrappee__PlaylistMenu();
		playlistMenu.add(loadPlaylist);
		playlistMenu.add(savePlaylist);
	}

	
	
	 private void  createPlaylistMenu__wrappee__RemoveTrack  () {
		if (!specifications.Configuration.removetrack) {
			createPlaylistMenu__wrappee__SaveAndLoadPlaylist();
			return;
		}
		createPlaylistMenu__wrappee__SaveAndLoadPlaylist();
		playlistMenu.add(removeTrack);
	}

	
	
	  private void  createPlaylistMenu__wrappee__ClearPlaylist  () {
		if (!specifications.Configuration.clearplaylist) {
			createPlaylistMenu__wrappee__RemoveTrack();
			return;
		}
		createPlaylistMenu__wrappee__RemoveTrack();
		playlistMenu.add(clearPlaylistButton);
	}

	
	
	public void createPlaylistMenu() {
		if (!specifications.Configuration.multipleplaylists) {
			createPlaylistMenu__wrappee__ClearPlaylist();
			return;
		}
		createPlaylistMenu__wrappee__ClearPlaylist();
		playlistMenu.add(addPlaylistMenuItem);
	}

	
	private final static Color THEME_COLOR_BG  = specifications.Configuration.dark ?  Color.black :  Color.white;

	
	
	private final static Color THEME_COLOR_FG  = specifications.Configuration.dark ?  Color.white :  Color.black;

	
	private JTable playlistTable;

	
	
	private PlaylistDataModel playlist;

	
	
	private Integer currentSongIndex = null;

	
	
	 private JTable  initPlaylist__wrappee__Playlist  () {
		JTable table = new JTable();
		clearPlaylist(table);
		table.setRowHeight(40);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.addMouseListener(this);
		table.setShowHorizontalLines(true);
		table.setGridColor(Color.gray);
		table.getSelectionModel().addListSelectionListener(this);
		table.setFillsViewportHeight(false);
		return table;
	}

	
	/**
	 * Overwrite function from [Playlist] and make table reorderable
	 * @return Playlist Table
	 */
	
	private JTable initPlaylist() {
		if (!specifications.Configuration.reorderplaylist)
			return initPlaylist__wrappee__Playlist();
		JTable table = initPlaylist__wrappee__Playlist();
		System.out.println("ReorderPlaylist.initPlaylist");
		table.setDragEnabled(true);
		table.setDropMode(DropMode.INSERT_ROWS);
		table.setTransferHandler(new TableRowTransferHandler(table)); 
		return table;
	}

	
	
	 private void  addPlaylistToLayout__wrappee__Playlist  () {
		JScrollPane scrollPane = new JScrollPane(playlistTable);
		add(scrollPane, BorderLayout.CENTER);
	}

	
	
	/**
	 * Prevent adding the default playlist and add it to tabs
	 */
	
	private void addPlaylistToLayout() {
		if (!specifications.Configuration.playlisttabs) {
			addPlaylistToLayout__wrappee__Playlist();
			return;
		}
		addPlaylist("Default Playlist", playlistTable);
		playlistTabs.setSelectedIndex(1);
	}

	
	
	private void clearPlaylist() {
		clearPlaylist(playlistTable);
	}

	
	
	private void clearPlaylist(JTable table) {
		PlaylistDataModel playlist = new PlaylistDataModel();
		table.setModel(playlist);
		TableRowSorter<PlaylistDataModel> sorter = new TableRowSorter<PlaylistDataModel>(playlist);
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
	}

	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selection = (ListSelectionModel) e.getSource();
		if(!selection.getValueIsAdjusting()) {
			playlistSelectionChanged(selection);
		}
	}

	
	
	 private void  playlistSelectionChanged__wrappee__Playlist  (ListSelectionModel selection) {
		
	}

	
	
	private void playlistSelectionChanged(ListSelectionModel selection) {
		if (!specifications.Configuration.removetrack) {
			playlistSelectionChanged__wrappee__Playlist(selection);
			return;
		}
		playlistSelectionChanged__wrappee__Playlist(selection);
		removeTrack.setEnabled(!selection.isSelectionEmpty());
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.isPopupTrigger() || e.getButton() != MouseEvent.BUTTON1) {
			return;
		}
		
		JTable playlistTable = (JTable) e.getSource();
		
		if(e.getClickCount() == 2) {
			int[] selectedRows = playlistTable.getSelectedRows();
			for(int i : selectedRows) {
				int index = playlistTable.convertRowIndexToModel(i);
				PlaylistDataModel p = (PlaylistDataModel) playlistTable.getModel();
				Song song = p.getSong(index);
				playSong(song);
			}
		}
	}

	
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	

	
	 private void  mouseReleased__wrappee__Playlist(MouseEvent arg0) {
	}

	
	
	
	 private void  mouseReleased__wrappee__PlaylistContextMenu(MouseEvent e) {
		if (!specifications.Configuration.playlistcontextmenu) {
			mouseReleased__wrappee__Playlist(e);
			return;
		}
		Object source = e.getSource();
		
		if(e.isPopupTrigger()) {
			showContextMenu((JTable) source, e);
		}
	}

	
	
	
	 private void  mouseReleased__wrappee__TagEditor(MouseEvent e) {
		if (!specifications.Configuration.tageditor) {
			mouseReleased__wrappee__PlaylistContextMenu(e);
			return;
		}
		Object source = e.getSource();
		if(source instanceof JTable) {
			JTable table = (JTable) source;
			
			int[] selectedRows = table.getSelectedRows();
			tagEditorSong = null;
			for(int i : selectedRows) {
				int index = table.convertRowIndexToModel(i);
				Song song = ((PlaylistDataModel) table.getModel()).getSong(index);
				// Cannot use instanceof Mp3Song here
				if(song.getFileName().endsWith("mp3")) {
					tagEditorSong = song;
					break;
				}
			}
			openTagEditorMenuItem.setEnabled(tagEditorSong != null);
		}
		
		mouseReleased__wrappee__PlaylistContextMenu(e);
	}

	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (!specifications.Configuration.queuetrack) {
			mouseReleased__wrappee__TagEditor(e);
			return;
		}
		Object source = e.getSource();
		
		if(e.isPopupTrigger()) {
			if(source == queueTable) {
				showQueueRemoveMenu((JTable) source, e);
			}
		}
		
		mouseReleased__wrappee__TagEditor(e);
	}

	
	
	private void updateSongIndex() {
		if(currentSong != null) {
			currentSongIndex = playlist.indexOf(currentSong);
		}
		System.out.println("Playlist.load currentSongIndex = " + currentSongIndex);
	}

	
	private JPopupMenu playlistContextMenu;

	
	
	private JTable contextMenuTable = null;

	
	
	private void showContextMenu(JTable table, MouseEvent e) {
		contextMenuTable = table;
		int r = table.rowAtPoint(e.getPoint());
        if (r >= 0 && r < table.getRowCount()) {
        	table.setRowSelectionInterval(r, r);
        } else {
        	table.clearSelection();
        }

        int rowindex = table.getSelectedRow();
        if(rowindex < 0)
            return;
        
        playlistContextMenu.show(e.getComponent(), e.getX(), e.getY());
	}

		
	private JMenuItem openTagEditorMenuItem;

	
	
	private JFrame tagEditor;

	
	
	private Song tagEditorSong;

	
	private List<JTable> playlists = new LinkedList<JTable>();

	
	
	private JTabbedPane playlistTabs;

	
	
	/**
	 * Function for creating a new Playlist
	 * @param name Name
	 * @return the playlist table
	 */
	
	 private JTable  addPlaylist__wrappee__PlaylistTabs  (String name) {
		// System.out.println("addPlaylist " + name);
		JTable table = initPlaylist();
		addPlaylist(name, table);
		return table;
	}

	
	
	/**
	 * refine method so we can add event handlers
	 * 
	 * @param name
	 * @return
	 */
	
	private JTable addPlaylist(String name) {
		if (!specifications.Configuration.queuetrack)
			return addPlaylist__wrappee__PlaylistTabs(name);
		JTable newPlaylist = addPlaylist__wrappee__PlaylistTabs(name);
		newPlaylist.addMouseListener(this);
		return newPlaylist;
	}

	
	
	/**
	 * Adds a table to the list and tabs
	 * @param name
	 * @param table
	 * @return
	 */
	
	private void addPlaylist(String name, JTable table) {
		playlistTabs.add(name, new JScrollPane(table));
		playlists.add(table);
	}

	
	JMenuItem loadFolder;

	
	JMenuItem loadPlaylist = new JMenuItem("Load Playlist");

	
	JMenuItem savePlaylist = new JMenuItem("Save Playlist");

	
	
	private void loadPlaylistIntoTable(M3U m3uPlaylist) {
		clearPlaylist();
		for(Resource res : m3uPlaylist.getResources()) {
			try {
				// notifySongLoaded(new Mp3Song());
				notifySongLoaded(fileToSong(new File(res.getLocation())));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	
	
	private void loadPlaylist() {
		File targetFile = null;
		try {
			targetFile = openFileChooser(false, ".m3u").get().get(0);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		} catch (ExecutionException e2) {
			e2.printStackTrace();
		} catch(NullPointerException ex) {
			return;
		}
		
		unloadSong();
		System.out.println("Loading Playlist: " + targetFile);
		M3UProvider provider = new M3UProvider();
		try {
			M3U m3uPlaylist = (M3U) provider.readFrom(new FileInputStream(targetFile), null, null);
			loadPlaylistIntoTable(m3uPlaylist);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	
	
	private void savePlaylist() {
		File targetFile = null;
		try {
			targetFile = openFileSaver(".m3u").get().get(0);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		} catch(NullPointerException ex) {
			return;
		}
		
		System.out.println("Save Playlist to: " + targetFile);

		Song[] songs = playlist.getSongs();
		
		try {
			FileOutputStream outputStream = new FileOutputStream(targetFile);
			M3U playlist = new M3U();
			for(Song song : songs) {
				Resource res = new Resource();
				res.setLocation(song.getFilePath());
				playlist.getResources().add(res);
			}
			playlist.setExtensionM3U(true);
			playlist.writeTo(outputStream, "UTF-8");
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	private IconButton previousButton;

	
	private IconButton nextButton;

	
	private IconButton shuffleRepeatButton;

	
	
	public enum  ShuffleType {REPEAT_ONCE ,  SHUFFLE_RANDOM ,  REPEAT_ONE ,  REPEAT_PLAYLIST}

	;

	
	
	private ShuffleType shuffleType = ShuffleType.REPEAT_ONCE;

	
	
	private List<Integer> playlistRandomSongIndexes = null;

	
	
	private Iterator<Integer> playlistRandomSongIterator = null;

	
	
	private void setShuffleType(ShuffleType newType) {
		switch(newType) {
		case REPEAT_ONCE:
			shuffleRepeatButton.setText("\uf01e");
			shuffleRepeatButton.setToolTipText("Shuffle: Play playlist once.");
			break;
		case REPEAT_ONE:
			shuffleRepeatButton.setText("\uf001");
			shuffleRepeatButton.setToolTipText("Shuffle: Repeat Song.");
			break;
		case REPEAT_PLAYLIST:
			shuffleRepeatButton.setText("\uf03a");
			shuffleRepeatButton.setToolTipText("Shuffle: Repeat Playlist.");
			break;
		case SHUFFLE_RANDOM:
			shuffleRepeatButton.setText("\uf074");
			shuffleRepeatButton.setToolTipText("Shuffle: Play Random.");
			
			long seed = System.nanoTime();
			playlistRandomSongIndexes = new LinkedList<Integer>();
			// If we are playing a song, insert at the beginning
			if(currentSongIndex != null) {
				playlistRandomSongIndexes.add(currentSongIndex);
			}
	
			for(int i=0; i<playlist.getRowCount();i++) {
				if(currentSongIndex != i)
					playlistRandomSongIndexes.add(i);
			}
			
			Collections.shuffle(playlistRandomSongIndexes, new Random(seed));
			playlistRandomSongIterator = playlistRandomSongIndexes.iterator();
			
			break;
		}
		
		shuffleType = newType;
	}

	

	private void resetShuffleType() {
		if(shuffleType == ShuffleType.REPEAT_ONE){
			setShuffleType(ShuffleType.REPEAT_ONCE);
		}
	}

	
	private JMenuItem removeTrack;

	
	
	private void removeSelectedSongs() {
		System.out.println("[RemoveTrack.removeSelectedSongs]");
		final PlaylistDataModel p = (PlaylistDataModel) playlistTable.getModel();
		final List<Song> songsToRemove = new ArrayList<Song>();
		
		int[] selectedRows = playlistTable.getSelectedRows();
		for(int i : selectedRows) {
			int index = playlistTable.convertRowIndexToModel(i);
			Song song = p.getSong(index);
			if(song == currentSong) {
				stop();
			}
			songsToRemove.add(song);
		}
		for(Song song : songsToRemove) {
			p.remove(song);
		}
	}

	
	JMenuItem clearPlaylistButton;

	
	private PlaylistDataModel queue = null;

	
	
	private JTable queueTable;

	
	
	private JMenuItem addToQueueMenuItem;

	
	
	private JPopupMenu removeFromQueuePopupMenu;

	
	
	private JMenuItem removeFromQueueMenuItem;

	
	
	private void showQueueRemoveMenu(JTable table, MouseEvent e) {
		int r = table.rowAtPoint(e.getPoint());
        if (r >= 0 && r < table.getRowCount()) {
        	table.setRowSelectionInterval(r, r);
        } else {
        	table.clearSelection();
        }

        int rowindex = table.getSelectedRow();
        if(rowindex < 0)
            return;
        
        removeFromQueuePopupMenu.show(e.getComponent(), e.getX(), e.getY());
	}

	
	private JMenuItem addPlaylistMenuItem;

	
	private JPanel coverPanel = new JPanel();

	
	
	private JLabel noCoverLabel = new JLabel("No cover available");

	

	private JLabel songNameLabel = new JLabel();

	
	private JLabel volumeLabel = new JLabel("100 %");

	;

	
	
	private JSlider volumeSlider = new JSlider();

	
	
	private int volume = 100;

	
	
	 private void  volumeChanged__wrappee__VolumeControl  (ChangeEvent e) {
		volume = (int) (((volumeSlider.getValue()) / ((float) volumeSlider.getMaximum())) * 100);
		volumeLabel.setText(volume + "%");
		
		if(player != null) {
			player.setVolume(volumeSlider.getValue() / ((float) volumeSlider.getMaximum()));
		}
	}

	
	
	private void volumeChanged(ChangeEvent e) {
		if (!specifications.Configuration.mute) {
			volumeChanged__wrappee__VolumeControl(e);
			return;
		}
		volumeChanged__wrappee__VolumeControl(e);
		
		muted = false;
		if(player != null && player.isMuted()) {
			player.unmute();
		}
		
		if(volume >= 50) {
			muteButton.setText("\uf028");
		} else {
			muteButton.setText("\uf027");
		}
	}

	
	private IconButton muteButton;

	
	
	private boolean muted = false;

	
	private JSlider positionSlider;

	
	private JLabel label_time_played;

	
	private JLabel label_time_remaining;


}
