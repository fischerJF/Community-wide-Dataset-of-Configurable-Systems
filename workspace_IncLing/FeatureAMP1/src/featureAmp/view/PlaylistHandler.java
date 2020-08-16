package featureAmp.view; 

import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import java.util.Observable; 
import java.util.Observer; 

import javax.swing.BorderFactory; 

import javax.swing.DefaultListModel; 
import javax.swing.JList; 

import featureAmp.MusicFileWrapper; 
import featureAmp.engine.MP3Player; 
import featureAmp.view.PlaylistCellRenderer; 

import java.util.Random; 


public   class  PlaylistHandler {
	
	
	private JList<MusicFileWrapper> playlist = new JList<MusicFileWrapper>();

	
	private DefaultListModel<MusicFileWrapper> model = new DefaultListModel<MusicFileWrapper>();

	
	private App app;

	
	
	private MusicFileWrapper currentFile;

	
	
	public PlaylistHandler(App app){
		if (specifications.Configuration.playlist) {
			this.app = app;
			init();
				}
	}

	
	
	  private void  init__wrappee__Playlist  (){
		this.playlist.setCellRenderer(new PlaylistCellRenderer());
		this.playlist.addMouseListener(mouseListener);
		this.playlist.setBorder(BorderFactory.createLoweredBevelBorder());		
		this.playlist.setModel(model);
		this.playlist.setName("p_list");
	}

	
	
	public void init(){
		if (!specifications.Configuration.queuetrack) {
			init__wrappee__Playlist();
			return;
		}
		init__wrappee__Playlist();
		queue.setModel(queueModel);
		queue.setName("queueLis");
		queue.setCellRenderer(new PlaylistCellRenderer());
	}

	
	
	private MouseListener mouseListener = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2){
				MusicFileWrapper selectedFile = playlist.getSelectedValue(); 
				if(selectedFile!= null){
					app.play(selectedFile);
				}
			}
		}
	};

	
	
	private Observer playerStatusObserver = new Observer() {
		
		@Override
		public void update(Observable arg0, Object arg1) {
			if(arg0 instanceof MP3Player){
				MP3Player player = (MP3Player) arg0;
				if(player.getPlayerStatus() != MP3Player.STATUS_FINISHED){
					return;
				}
				reactToUpdate();
			}
			
		}
	};

	
	
	 private void  reactToUpdate__wrappee__Playlist  () {
		playNextSong(currentFile, false);
	}

	
	
	private void reactToUpdate(){
		if (!specifications.Configuration.queuetrack) {
			reactToUpdate__wrappee__Playlist();
			return;
		}
		if(!queueModel.isEmpty() && queueModel.firstElement() == currentFile){
			queueModel.remove(0);
		}
		reactToUpdate__wrappee__Playlist();
	}

	
	
	public void addSong(MusicFileWrapper file) {
		this.model.addElement(file);
		if(this.model.getSize() == 1){
			this.app.play(file);
		}
	}

	
	
	  private void  playNextSong__wrappee__Playlist  (MusicFileWrapper current, boolean skipped){
		int index = model.indexOf(current);
		if(model.size() > index+1){
			app.play(model.get(index+1));
		}
	}

	
	
	 private void  playNextSong__wrappee__ShuffleRepeat  (MusicFileWrapper current, boolean skiped){
		if (!specifications.Configuration.shufflerepeat) {
			playNextSong__wrappee__Playlist(current, skiped);
			return;
		}
		MusicFileWrapper next = getNextSongToPlay(current);
		if(next != null && skiped && current != next){
			app.play(next);
			return;
		}
		else if (next != null && !skiped){
			app.play(next);
			return;
		}
		playNextSong__wrappee__Playlist(current, skiped);
	}

	
	
	public void playNextSong(MusicFileWrapper current, boolean skipped){
		if (!specifications.Configuration.queuetrack) {
			playNextSong__wrappee__ShuffleRepeat(current, skipped);
			return;
		}
		if(!queueModel.isEmpty() && skipped && queueModel.firstElement() == currentFile){
			queueModel.remove(0);
		}
		if(!queueModel.isEmpty()){
			app.play(queueModel.firstElement());
			return;
		}
		playNextSong__wrappee__ShuffleRepeat(current, skipped);
	}

	
	
	public void update( MP3Player player, MusicFileWrapper currentFile) {
		this.playlist.repaint();
		this.currentFile = currentFile;
		player.addObserver(playerStatusObserver);
	}

	
	
	public JList<MusicFileWrapper> getPlaylist() {
		return playlist;
	}

	

	public DefaultListModel<MusicFileWrapper> getModel() {
		return model;
	}

	
	
	public MusicFileWrapper getNextSongToPlay(MusicFileWrapper current){
		int index = model.indexOf(currentFile);
		switch (app.mode) {
		case REPEAT_TRACK:
			return current;
			
		case SHUFFLE:
			if(model.size() == 1){
				return null;
			}
			Random random = new Random();
			int i;
			do {
				i = random.nextInt(model.size());
			} while(model.indexOf(currentFile) == i);
			
			return (model.get(i));
			
		case REPEAT_PLAYLIST:
			if(model.size() == index+1){
				return(model.firstElement());
			}
			
		case NORMAL:
		default:
			return null;
		}
	}

	
	
	JList<MusicFileWrapper> queue = new JList<MusicFileWrapper>();

	
	DefaultListModel<MusicFileWrapper> queueModel = new DefaultListModel<MusicFileWrapper>();

	
	boolean queueHeadPlayed = false;


}
