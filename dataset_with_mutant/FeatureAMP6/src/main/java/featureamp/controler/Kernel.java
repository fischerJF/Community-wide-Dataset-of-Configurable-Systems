package featureamp.controler; 

import java.io.File; 

import featureamp.FeatureAMP; 

import featureamp.gui.elements.Label; 
import featureamp.gui.elements.Picture; 

import featureamp.playback.Player; 

import featureamp.playback.Track; 
import featureamp.playback.TrackFactory; 

import javax.sound.sampled.LineEvent; 
import javax.sound.sampled.LineListener; 
import javax.swing.JComponent; 
import featureamp.playlist.Playlist; 

import featureamp.gui.MainWindow; 
import featureamp.gui.elements.ScrollPane; 
import featureamp.gui.elements.Table; 
import featureamp.playback.Player.State; 

import java.util.List; 
import javax.swing.JMenuItem; 

import javax.sound.sampled.FloatControl; 

/**
 * TODO description
 */
public   class  Kernel  implements LineListener {
	

	private Player player;

	
	private Label artist, title, length;

	
	private Picture cover;

	
	private Track t;

	

	public Kernel() {
		if (specifications.Configuration.base) {
			// Base
			player = Player.getInstance();
			init();
				}
	}

	

	 private void  init__wrappee__Base  () {
		// Base
		artist = new Label(" ");
		artist.setToolTipText("Artist");
		title = new Label("No title selected");
		title.setToolTipText("Title");
		length = new Label(" ");
		length.setToolTipText("Duration");
		cover = new Picture(FeatureAMP.COVER_SIZE);
	}

	

	 private void  init__wrappee__Playlist  () {
		if (!specifications.Configuration.playlist) {
			init__wrappee__Base();
			return;
		}
		// Playlist
		playlist = new Playlist();
		table = new Table(playlist);
		playlistElement = new ScrollPane(table);
		playlistElement.setName("p_list");
		
		playlistElement.setPreferredSize(MainWindow.PLAYLIST_MINIMUM_SIZE);
		init__wrappee__Base();
	}

	

	 private void  init__wrappee__ShuffleRepeat  () {
		if (!specifications.Configuration.shufflerepeat) {
			init__wrappee__Playlist();
			return;
		}
		// ShuffleRepeat
		init__wrappee__Playlist();
		player.addLineListener(this);
	}

	

	 private void  init__wrappee__QueueTrack  () {
		if (!specifications.Configuration.queuetrack) {
			init__wrappee__ShuffleRepeat();
			return;
		}
		priorityModel = new Playlist() {
			public int getColumnCount() {
				return 5;
			}
		};
		priorityTable = new Table(priorityModel);
		init__wrappee__ShuffleRepeat();
	}

	
	
	 private void  init__wrappee__Tracknumber  () {
		if (!specifications.Configuration.tracknumber) {
			init__wrappee__QueueTrack();
			return;
		}
		// TrackNumber
		init__wrappee__QueueTrack();
		trackNumber = new Label(" ");
		trackNumber.setToolTipText("Tracknumber on Album");
	}

	
	
	private void init() {
		if (!specifications.Configuration.album) {
			init__wrappee__Tracknumber();
			return;
		}
		// Album
		init__wrappee__Tracknumber();
		album = new Label(" ");
		album.setToolTipText("Album");
	}

	

	 private void  loadTrack__wrappee__Base  (File f) {
		// Base
		t = TrackFactory.createTrack(f);
		player.load(t);
		loadMetaData();
	}

	

	public void loadTrack(File f) {
		if (!specifications.Configuration.playlist) {
			loadTrack__wrappee__Base(f);
			return;
		}
		// Playlist
		t = TrackFactory.createTrack(f);
		table.addTrack(t);
	}

	

	 private void  loadMetaData__wrappee__Base  () {
		// Base
		artist.setText(t.getArtist());
		title.setText(t.getTitle());
		length.setText(Player.formatTime(player.getTrackLength()));
	}

	

	 private void  loadMetaData__wrappee__Cover  () {
		if (!specifications.Configuration.cover) {
			loadMetaData__wrappee__Base();
			return;
		}
		// Cover
		loadMetaData__wrappee__Base();
		cover.setToolTipText("Cover");
		cover.setPicture(t.getCover());
	}

	
	
	 private void  loadMetaData__wrappee__Tracknumber  () {
		if (!specifications.Configuration.tracknumber) {
			loadMetaData__wrappee__Cover();
			return;
		}
		// TrackNumber
		loadMetaData__wrappee__Cover();
		trackNumber.setText(t.getTracknumber().toString());
	}

	
	
	private void loadMetaData() {
		if (!specifications.Configuration.album) {
			loadMetaData__wrappee__Tracknumber();
			return;
		}
		// Album
		loadMetaData__wrappee__Tracknumber();
		album.setText(t.getAlbum());
	}

	

	public void play() {
		// Base
		player.play();
		loadMetaData();
	}

	

	public void pause() {
		// Base
		player.pause();
	}

	

	 private void  stop__wrappee__Base  () {
		// Base
		player.stop();
		artist.setText("");
		title.setText("No title selected");
		length.setText("");
	}

	
	
	 private void  stop__wrappee__Cover  () {
		if (!specifications.Configuration.cover) {
			stop__wrappee__Base();
			return;
		}
		stop__wrappee__Base();
		cover.setDefaultPicture();
	}

	
	
	 private void  stop__wrappee__Tracknumber  () {
		if (!specifications.Configuration.tracknumber) {
			stop__wrappee__Cover();
			return;
		}
		stop__wrappee__Cover();
		trackNumber.setText("");
	}

	
	
	public void stop() {
		if (!specifications.Configuration.album) {
			stop__wrappee__Tracknumber();
			return;
		}
		stop__wrappee__Tracknumber();
		album.setText("");
	}

	

	public Label getArtist() {
		// Base
		return artist;
	}

	

	public Label getTitle() {
		// Base
		return title;
	}

	

	public Label getLength() {
		// Base
		return length;
	}

	

	public Picture getCover() {
		// Base
		return cover;
	}

	

	private int currentId;

	
	private Table table;

	
	private ScrollPane playlistElement  ;

	
	private Playlist playlist;

	

	public JComponent getPlaylistElement() {
		// Playlist
		return playlistElement;
	}

	

	public Table getPlaylist() {
		// Playlist
		return table;
	}

	

	public void setTrack(Track t) {
		// Playlist
		this.t = t;
		player.load(t);
		loadMetaData();
		play();
	}

	

	public void playFromPlaylist() {
		// Playlist
		stop();
		currentId = table.getSelectedRow();
		Track t = getTrack(currentId);
		setTrack(t);
		play();
	}

	

	 private Track  getTrack__wrappee__Playlist  (int id) {
		// Playlist
		return (Track) table.getValueAt(id, -1);
	}

	

	private Track getTrack(int id) {
		if (!specifications.Configuration.skiptrack)
			return getTrack__wrappee__Playlist(id);
		// SkipTrack
		Track t = getTrack__wrappee__Playlist(id);
		return t.enabled() ? t : getTrack((id + 1) % table.getRowCount());
	}

	

	
	 private void  update__wrappee__Playlist(LineEvent e) {
		// ShuffleRepeat
		if (e.getType().equals(LineEvent.Type.STOP)
				&& player.state() == Player.State.finished) {
			chooseNext();
		}
	}

	

	
	 private void  update__wrappee__ShuffleRepeat(LineEvent e) {
		if (!specifications.Configuration.shufflerepeat) {
			update__wrappee__Playlist(e);
			return;
		}
		// ShuffleRepeat
		if (e.getType().equals(LineEvent.Type.STOP)
				&& player.state() == Player.State.finished) {
			chooseNext();
		}
	}

	

	@Override
	public void update(LineEvent e) {
		if (!specifications.Configuration.queuetrack) {
			update__wrappee__ShuffleRepeat(e);
			return;
		}
		if (priorityTable.getRowCount() > 0) {
			if (e.getType().equals(LineEvent.Type.STOP)
					&& player.state() == Player.State.finished) {
				setTrack((Track) priorityTable.getValueAt(0, -1));
				priorityModel.removeFirst();
			}
		} else {
			update__wrappee__ShuffleRepeat(e);
		}
	}

	
	
	 private void  chooseNext__wrappee__Playlist  () {
		currentId = (currentId + 1);
		if (currentId < table.getRowCount()) {
			setTrack(getTrack(currentId));
		}
	}

	

	private void chooseNext() {
		if (!specifications.Configuration.shufflerepeat) {
			chooseNext__wrappee__Playlist();
			return;
		}
		switch (playbackMode) {
		case MainWindow.REPEAT_0:
			chooseNext__wrappee__Playlist();
			return;
		case MainWindow.REPEAT_1:
			play();
			return;
		case MainWindow.REPEAT_N:
			currentId = (currentId + 1) % table.getRowCount();
			setTrack(getTrack(currentId));
			table.setRowSelectionInterval(currentId, currentId);
			return;
		case MainWindow.REPEAT_S:
			currentId = ((int) (Math.random() * (table.getRowCount() + 1)))
					% table.getRowCount();
			setTrack(getTrack(currentId));
			table.setRowSelectionInterval(currentId, currentId);
			return;
		}
	}

	

	 private void  skip__wrappee__SkipTrack  () {
		// SkipTrack
		chooseNext();
//		if (table.getRowCount() > 0
//				&& Player.getInstance().state() == State.playing) {
//			currentId = (currentId + 1) % table.getRowCount();
//			setTrack(getTrack(currentId));
//			table.setRowSelectionInterval(currentId, currentId);
//		}
	}

	

	public void skip() {
		if (!specifications.Configuration.queuetrack) {
			skip__wrappee__SkipTrack();
			return;
		}
		if (priorityTable.getRowCount() > 0) {
			if (Player.getInstance().state() == State.playing) {
				setTrack((Track) priorityTable.getValueAt(0, -1));
				priorityModel.removeFirst();
			}
		} else {
			skip__wrappee__SkipTrack();
		}
	}

	

	private int playbackMode;

	

	public void setPlaybackMode(int mode) {
		// ShuffleRepeat
		playbackMode = mode;
	}

	

	public void removeTrack(Track t) {
		// RemoveTrack
		table.getPlModel().removeTrack(t);
	}

	
	
	public void checkIfStop(Track toRemove) {
		if (toRemove == t) {
			stop();
			player.removeTrack();
			t = null;
		}
	}

	

	public List<Track> getTracks() {
		// SaveAndLoad
		return table.getPlModel().getAll();
	}

	

	private Playlist priorityModel;

	
	private Table priorityTable;

	
	private JMenuItem showQueue;

	

	public void setQueueMenuItems(JMenuItem show) {
		showQueue = show;
	}

	

	public void showQueue() {
		System.out.println("showQueue");
		playlistElement.setViewportView(priorityTable);
	}

	

	public void showPlaylist() {
		System.out.println("showPlaylist");
		playlistElement.setViewportView(table);
	}

	

	public Table getPriorityQueue() {
		return priorityTable;
	}

	

	public void toQueue() {
		int id = table.getSelectedRow();
		if (id >= 0) {
			Track t = (Track) table.getValueAt(id, -1);
			priorityModel.addTrack(t);
			showQueue.setVisible(true);
		}
	}

	

	public void setVolume(int vol) {
		// Volume
		FloatControl fc = Player.getVolumeControl();
		if (fc != null) {
			setVolume(vol, fc);
		}
	}

	
	public void setVolume(int vol, FloatControl fc) {
		// Volume
		int max = 100;
		float f = (float) (-Math.exp(-(a(max) * vol) + b()) + 6);
		fc.setValue(f);
	}

	
	private float a(int max) {
		// Volume
		return (float) (b() / max);
	}

	

	private float b() {
		// Volume
		return (float) Math.log(86);
	}

	

	public void jumpPosition(int newPos) {
		// JumpPosition
		player.jumpTo(newPos);
	}

	
	
	private Label trackNumber;

	
	
	public Label getTracknumber() {
		// TrackNumber
		return trackNumber;
	}

	
	
	private Label album;

	

	public Label getAlbum() {
		// Album
		return album;
	}


}
