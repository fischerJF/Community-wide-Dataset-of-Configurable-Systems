package featureAMP;
import java.util.Collection; 
import java.util.LinkedList; 

import java.awt.Toolkit; 

import javax.swing.BoxLayout; import javax.swing.JFrame; 
import javax.swing.JPanel; import javax.swing.UIManager; 

import com.jtattoo.plaf.fast.FastLookAndFeel; 

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import specifications.Configuration; 

public   class  FeatureAmp {
	

	public static final String TITLE = "FeatureAMP";

	
	
	private AudioController audioController;

	
	private Collection<Listener<FeatureAmp>> audioListeners;

	
	
	private JFrame frame;

	
	private MenuManager menuManager;

	
	
	public FeatureAmp() {
		if (specifications.Configuration.base_featureamp) {
			
			// AudioListeners initialisieren
			this.audioListeners = new LinkedList<Listener<FeatureAmp>>();
			
			// Frame initialisieren
			this.frame = new JFrame();
			this.frame.setTitle(TITLE);
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.frame.setResizable(true);
			JPanel contentPane = new JPanel();
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
			this.frame.setContentPane(contentPane);
			
			this.createComponents();
			this.addComponents();
			
			// Mach dich schön und zeig dich!
			this.frame.pack();
			this.frame.setLocation(
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()
						- this.frame.getWidth())/2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()
						- this.frame.getHeight())/2);
			this.frame.setVisible(true);
			
				}
	}

	
	
	public AudioController getAudioController() {
		return this.audioController;
	}

	
	
	public void setAudioController(AudioController audioController) {
		this.audioController = audioController;
		this.notifyAudioListeners();
		this.initAudioController();
	}

	
	
	 private void  initAudioController__wrappee__BASE_FEATUREAMP  () {
		if (this.audioController != null)
			this.audioController.play();
	}

	
	
	private void initAudioController() {
		if (!specifications.Configuration.playlist) {
			initAudioController__wrappee__BASE_FEATUREAMP();
			return;
		}}

	
	
	public void addAudioListener(Listener<FeatureAmp> l) {
		this.audioListeners.add(l);
	}

	
	
	public boolean removeAudioListener(Listener<FeatureAmp> l) {
		return this.audioListeners.remove(l);
	}

	
	
	public Collection<Listener<FeatureAmp>> getAudioListeners() {
		return this.audioListeners;
	}

	
	
	private void notifyAudioListeners() {
		for (Listener<FeatureAmp> l: this.audioListeners)
			l.update(this);
	}

	
	
	public JFrame getFrame() {
		return this.frame;
	}

	
	
	public MenuManager getMenuManager() {
		return this.menuManager;
	}

	
	
	 private void  createComponents__wrappee__BASE_FEATUREAMP  () {
		this.menuManager = new MenuManager(this);
	}

	
	
	 private void  createComponents__wrappee__PLAYER_BAR  () {
		if (!specifications.Configuration.player_bar) {
			createComponents__wrappee__BASE_FEATUREAMP();
			return;
		}
		createComponents__wrappee__BASE_FEATUREAMP();
		this.playerBar = new PlayerBar(this);
	}

	
	
	 private void  createComponents__wrappee__ID3_TITLE  () {
		if (!specifications.Configuration.id3_title) {
			createComponents__wrappee__PLAYER_BAR();
			return;
		}
		createComponents__wrappee__PLAYER_BAR();
		this.addAudioListener(new TitleListener());
	}

	
	
	 private void  createComponents__wrappee__VOLUME_CONTROL  () {
		if (!specifications.Configuration.volume_control) {
			createComponents__wrappee__ID3_TITLE();
			return;
		}
		createComponents__wrappee__ID3_TITLE();
		this.volumeControl = new VolumeControl(this);
	}

	
	
	 private void  createComponents__wrappee__SHOW_COVER  () {
		if (!specifications.Configuration.show_cover) {
			createComponents__wrappee__VOLUME_CONTROL();
			return;
		}
		createComponents__wrappee__VOLUME_CONTROL();
		this.showCover = new ShowCover(this);
	}

	
	
	 private void  createComponents__wrappee__TITLE_TIME  () {
		if (!specifications.Configuration.title_time) {
			createComponents__wrappee__SHOW_COVER();
			return;
		}
		createComponents__wrappee__SHOW_COVER();
		this.addAudioListener(new TitleTimeListener());
	}

	
	
	 private void  createComponents__wrappee__PROGRESS_BAR  () {
		if (!specifications.Configuration.progress_bar) {
			createComponents__wrappee__TITLE_TIME();
			return;
		}
		createComponents__wrappee__TITLE_TIME();
		this.progressBar = new ProgressBar(this);
	}

	
	
	 private void  createComponents__wrappee__PLAYLIST  () {
		if (!specifications.Configuration.playlist) {
			createComponents__wrappee__PROGRESS_BAR();
			return;
		}
		createComponents__wrappee__PROGRESS_BAR();
		this.playlist = new Playlist(this);
	}

	
	
	 private void  createComponents__wrappee__PLAYER_CONTROL  () {
		if (!specifications.Configuration.player_control) {
			createComponents__wrappee__PLAYLIST();
			return;
		}
		createComponents__wrappee__PLAYLIST();
		this.playerControl = new PlayerControl(this.playlist);
	}

	
	
	private void createComponents() {
		if (!specifications.Configuration.queue_track) {
			createComponents__wrappee__PLAYER_CONTROL();
			return;
		}
		createComponents__wrappee__PLAYER_CONTROL();
		this.queueTrack = new QueueTrack(this.playlist);
	}

	
	
	 private void  addComponents__wrappee__BASE_FEATUREAMP  () {
		this.frame.setJMenuBar(this.menuManager.getMenuBar());
	}

	
	
	 private void  addComponents__wrappee__PLAYER_BAR  () {
		if (!specifications.Configuration.player_bar) {
			addComponents__wrappee__BASE_FEATUREAMP();
			return;
		}
		addComponents__wrappee__BASE_FEATUREAMP();
		this.frame.getContentPane().add(this.playerBar.getPlayerPanel());
	}

	
	
	 private void  addComponents__wrappee__VOLUME_CONTROL  () {
		if (!specifications.Configuration.volume_control) {
			addComponents__wrappee__PLAYER_BAR();
			return;
		}
		addComponents__wrappee__PLAYER_BAR();
		this.frame.getContentPane().add(this.volumeControl.getVolumePanel());
	}

	
	
	 private void  addComponents__wrappee__SHOW_COVER  () {
		if (!specifications.Configuration.show_cover) {
			addComponents__wrappee__VOLUME_CONTROL();
			return;
		}
		addComponents__wrappee__VOLUME_CONTROL();
		this.frame.getContentPane().add(this.showCover.getImagePanel());
	}

	
	
	 private void  addComponents__wrappee__PROGRESS_BAR  () {
		if (!specifications.Configuration.progress_bar) {
			addComponents__wrappee__SHOW_COVER();
			return;
		}
		addComponents__wrappee__SHOW_COVER();
		this.frame.getContentPane().add(this.progressBar.getProgressBar());
	}

	
	
	 private void  addComponents__wrappee__PLAYLIST  () {
		if (!specifications.Configuration.playlist) {
			addComponents__wrappee__PROGRESS_BAR();
			return;
		}
		addComponents__wrappee__PROGRESS_BAR();
		this.frame.getContentPane().add(this.playlist.getScrollPane());
	}

	
	
	 private void  addComponents__wrappee__PLAYER_CONTROL  () {
		if (!specifications.Configuration.player_control) {
			addComponents__wrappee__PLAYLIST();
			return;
		}
		addComponents__wrappee__PLAYLIST();
		this.frame.getContentPane().add(this.playerControl.getControlPanel());
	}

	
	
	private void addComponents() {
		if (!specifications.Configuration.queue_track) {
			addComponents__wrappee__PLAYER_CONTROL();
			return;
		}
		addComponents__wrappee__PLAYER_CONTROL();
		this.frame.getContentPane().add(this.queueTrack.getQueuePanel());
	}

	
	
	 private static void  main__wrappee__BASE_FEATUREAMP  (String[] args) {
//		    Configuration.skins=true;
//			Configuration.player_control=true;
//			Configuration.reorder_playlist=true;
//			Configuration.title_time=true;
//			Configuration.skip_track=true;
//			Configuration.progress=true;
//			Configuration.clear_playlist=true;
//			Configuration.progress_bar=true;
//			Configuration.volume_control=true;
//			Configuration.remove_track=true;
//			Configuration.light=true;
//			Configuration.dark=true;
//			Configuration.shuffle_repeat=true;
//			Configuration.show_cover=true;
//			Configuration.ogg=true;
//			Configuration.mp3=true;
//			Configuration.save_load_playlist=true;
//			Configuration.base_featureamp=true;
//			Configuration.load_folder=true;
//			Configuration.queue_track=true;
//			Configuration.file_support=true;
//			Configuration.player_bar=true;
//			Configuration.mute=true;
//			Configuration.id3_title=true;
//			Configuration.playlist=true;
		 
		 Configuration.base_featureamp=true;
		 Configuration.file_support=true;
		 Configuration.mp3=true;
		 Configuration.skins=true;
		 Configuration.light=true;
		 Configuration.id3_title=true;
		 Configuration.player_bar=true;
		 Configuration.progress=true;

		 Configuration.playlist=true;
		 Configuration.player_control=true;
		 Configuration.remove_track=true;
		 
		 
		 new FeatureAmp();
	}

	
	
	 private static void  main__wrappee__LIGHT  (String[] args) {
		if (!specifications.Configuration.light) {
			main__wrappee__BASE_FEATUREAMP(args);
			return;
		}
		FastLookAndFeel.setTheme("Default", "", "FeatureAMP");
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		main__wrappee__BASE_FEATUREAMP(args);
	}

	
	
	public static void main(String[] args) {
		if (!specifications.Configuration.dark) {
			main__wrappee__LIGHT(args);
			return;
		}
		HiFiLookAndFeel.setTheme("Default", "", "FeatureAMP");
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		main__wrappee__LIGHT(args);
	}

	

	private PlayerBar playerBar;

	

	private VolumeControl volumeControl;

	

	private ShowCover showCover;

	

	private ProgressBar progressBar;

	

	private Playlist playlist;

	

	private PlayerControl playerControl;

	

	private QueueTrack queueTrack;

	
	
	public QueueTrack getQueueTrack() {
		return this.queueTrack;
	}


}
