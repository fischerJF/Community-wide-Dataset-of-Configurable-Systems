package featureAMP;
import java.awt.Dimension; import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.io.File; 
import java.util.ArrayList; 
import java.util.Collection; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 

import javax.swing.JFileChooser; 
import javax.swing.JMenuItem; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.filechooser.FileNameExtensionFilter; 
import java.util.Collections; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 

import christophedelory.playlist.m3u.M3U; 
import christophedelory.playlist.m3u.M3UProvider; 
import christophedelory.playlist.m3u.Resource; import java.util.LinkedList; 

public   class  Playlist {
	
	
	private FeatureAmp featureAmp;

	
	
	private Map<String, AudioController> cachedControllers;

	
	private List<AudioFile> files;

	
	private int currentFileIndex;

	
	private JTable playlistTable;

	
	private JScrollPane scrollPane;

	
	
	private FinishedListener finishedListener;

	
	
	public Playlist(FeatureAmp featureAmp) {
		if (specifications.Configuration.playlist) {
			
			this.featureAmp = featureAmp;
			this.featureAmp.addAudioListener(new AudioListener());
			
			this.cachedControllers = new HashMap<String, AudioController>();
			this.files = new ArrayList<AudioFile>();
			this.currentFileIndex = 0;
			
			this.playlistTable = new JTable(new PlaylistTableModel(this));
			this.playlistTable.setName("p_list");
			this.playlistTable.addMouseListener(new DoubleClickListener());
			this.playlistTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			this.scrollPane = new JScrollPane(this.playlistTable);
			this.scrollPane.setPreferredSize(new Dimension(400, 200));
			
			this.createFinishedListener();
			this.createMenuItems();
			
				}
	}

	
	
	 private void  createFinishedListener__wrappee__PLAYLIST  () {
		this.updateFinishedListener(new NextFinishedListener());
	}

	
	
	private void createFinishedListener() {
		if (!specifications.Configuration.queue_track) {
			createFinishedListener__wrappee__PLAYLIST();
			return;
		}
		this.queueFinishedListener = new QueueFinishedListener();
		this.finishedListener = this.queueFinishedListener;
		createFinishedListener__wrappee__PLAYLIST();
	}

	
	
	 private void  createMenuItems__wrappee__PLAYLIST  () {
		
		JMenuItem loadFileItem = new JMenuItem("Datei öffnen...");
		loadFileItem.addActionListener(new LoadFileListener());
		this.featureAmp.getMenuManager().addMenuItem(0, loadFileItem);

	}

	
	
	 private void  createMenuItems__wrappee__LOAD_FOLDER  () {
		if (!specifications.Configuration.load_folder) {
			createMenuItems__wrappee__PLAYLIST();
			return;
		}
		
		createMenuItems__wrappee__PLAYLIST();
		
		JMenuItem loadFolderItem = new JMenuItem("Ordner öffnen...");
		loadFolderItem.addActionListener(new LoadFolderListener());
		this.featureAmp.getMenuManager().addMenuItem(0, loadFolderItem);
		
	}

	
	
	private void createMenuItems() {
		if (!specifications.Configuration.save_load_playlist) {
			createMenuItems__wrappee__LOAD_FOLDER();
			return;
		}
		
		createMenuItems__wrappee__LOAD_FOLDER();
		
		JMenuItem savePlaylistItem = new JMenuItem("Playlist speichern...");
		savePlaylistItem.addActionListener(new SavePlaylistListener());
		this.featureAmp.getMenuManager().addMenuItem(0, savePlaylistItem);
		
		JMenuItem loadPlaylistItem = new JMenuItem("Playlist öffnen...");
		loadPlaylistItem.addActionListener(new LoadPlaylistListener());
		this.featureAmp.getMenuManager().addMenuItem(0, loadPlaylistItem);
		
	}

	
	
	public FinishedListener getFinishedListener() {
		return this.finishedListener;
	}

	
	
	 private void  updateFinishedListener__wrappee__PLAYLIST  (FinishedListener finishedListener) {
		if (this.featureAmp.getAudioController() != null) {
			this.featureAmp.getAudioController().removeFinishedListener(
					this.finishedListener);
			this.featureAmp.getAudioController().addFinishedListener(
					finishedListener);
		}
		this.finishedListener = finishedListener;
	}

	
	
	public void updateFinishedListener(FinishedListener finishedListener) {
		if (!specifications.Configuration.queue_track) {
			updateFinishedListener__wrappee__PLAYLIST(finishedListener);
			return;
		}
		
		this.queueFinishedListener.setActualListener(finishedListener);
		updateFinishedListener__wrappee__PLAYLIST(this.queueFinishedListener);
		
	}

	
	
	public List<AudioFile> getAudioFiles() {
		return this.files;
	}

	
	
	 private void  removeAudioFiles__wrappee__PLAYLIST  (List<AudioFile> removeFiles) {
		this.files.removeAll(removeFiles);
	}

	
	
	public void removeAudioFiles(List<AudioFile> removeFiles) {
		if (!specifications.Configuration.queue_track) {
			removeAudioFiles__wrappee__PLAYLIST(removeFiles);
			return;
		}
		removeAudioFiles__wrappee__PLAYLIST(removeFiles);
		this.featureAmp.getQueueTrack().getQueue().removeAll(removeFiles);
	}

	
	
	public int getCurrentFileIndex() {
		return this.currentFileIndex;
	}

	
	
	public void setCurrentFileIndex(int index) {
		this.currentFileIndex = index;
	}

	
	
	public JTable getPlaylistTable() {
		return this.playlistTable;
	}

	
	
	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}

	
	
	public FeatureAmp getFeatureAmp() {
		return this.featureAmp;
	}

	
	
	public void refreshTable() {
		this.playlistTable.repaint();
		this.playlistTable.revalidate();
	}

	
	
	public void updateAudioFile(int tableIndex) {
		
		this.updateAudioFileWithoutPlay(tableIndex);
		this.featureAmp.getAudioController().play();
		
	}

	
	
	 private void  updateAudioFileWithoutPlay__wrappee__PLAYLIST  (int tableIndex) {
		
		if (this.featureAmp.getAudioController() != null) {
			this.featureAmp.getAudioController().removeFinishedListener(this.finishedListener);
			this.featureAmp.getAudioController().stop();
		}
		try {
			AudioFile file = this.files.get(tableIndex);
			this.currentFileIndex = tableIndex;
			if (this.cachedControllers.containsKey(file.getFilename()))
				this.featureAmp.setAudioController(
						this.cachedControllers.get(file.getFilename()));
			else {
				this.featureAmp.getFrame().setTitle("lädt...");
				AudioController audioController = AudioFactory.createAudioController(file);
				this.cachedControllers.put(file.getFilename(), audioController);
				this.featureAmp.setAudioController(audioController);
			}
			this.refreshTable();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	public void updateAudioFileWithoutPlay(int tableIndex) {
		if (!specifications.Configuration.queue_track) {
			updateAudioFileWithoutPlay__wrappee__PLAYLIST(tableIndex);
			return;
		}
		
		updateAudioFileWithoutPlay__wrappee__PLAYLIST(tableIndex);
		
		this.featureAmp.getQueueTrack().getQueue().remove(
					this.files.get(this.currentFileIndex));
		
	}

	
	
	 
	
	class  DoubleClickListener  extends MouseAdapter {
		

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				JTable source = (JTable) e.getSource();
				int row = source.getSelectedRow();
				Playlist.this.updateAudioFile(row);
				Playlist.this.currentFileIndex = row;
				Playlist.this.refreshTable();
			}
		}


	}

	
	
	 
	
	class  AudioListener  implements Listener<FeatureAmp> {
		

		@Override
		public void update(FeatureAmp object) {
			if (object.getAudioController() != null)
				object.getAudioController().addFinishedListener(
						Playlist.this.getFinishedListener());
		}


	}

	
	
	 
	
	class  LoadFileListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser fileChooser;
			File currentFile = Playlist.this.featureAmp.getMenuManager().getCurrentFile();
			if (currentFile != null)
				fileChooser = new JFileChooser(currentFile);
			else
				fileChooser = new JFileChooser();
			Collection<String> fileExtensions = AudioFactory.getSupportedFileExtensions();
			fileChooser.setFileFilter(new FileNameExtensionFilter("Audiodateien",
					fileExtensions.toArray(new String[fileExtensions.size()])));
			
			int returnCode = fileChooser.showOpenDialog(
					Playlist.this.featureAmp.getFrame());
			if (returnCode == JFileChooser.APPROVE_OPTION) {
				
				File file = fileChooser.getSelectedFile();
				Playlist.this.featureAmp.getMenuManager().setCurrentFile(file);
				try {
					AudioFile audioFile = AudioFactory.createAudioFile(file);
					Playlist.this.files.add(audioFile);
					Playlist.this.refreshTable();
					if (Playlist.this.files.size() == 1)
						Playlist.this.updateAudioFile(0);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
			
		}


	}

	
	
	public  class  NextFinishedListener  implements FinishedListener {
		
		
		@Override
		public Integer getNextIndex() {
			int maxIndex = Playlist.this.files.size()-1;
			if (Playlist.this.currentFileIndex < maxIndex)
				return new Integer(Playlist.this.currentFileIndex + 1);
			return null;
		}

		
		
		@Override
		public void update(AudioController object) {
			Integer nextIndex = this.getNextIndex();
			if (nextIndex != null)
				Playlist.this.updateAudioFile(nextIndex.intValue());
		}


	}

	
	
	 
	
	class  LoadFolderListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ArrayList<AudioFile> audioFiles = new ArrayList<AudioFile>();
			
			JFileChooser fileChooser;
			File currentFile = Playlist.this.featureAmp.getMenuManager().getCurrentFile();
			if (currentFile != null)
				fileChooser = new JFileChooser(currentFile);
			else
				fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			int returnCode = fileChooser.showOpenDialog(
					Playlist.this.featureAmp.getFrame());
			if (returnCode == JFileChooser.APPROVE_OPTION) {
				
				File folder = fileChooser.getSelectedFile();
				Playlist.this.featureAmp.getMenuManager().setCurrentFile(folder);
				try {
					File[] files = folder.listFiles();
					for (File f : files) {
						try {
							AudioFile audioFile = AudioFactory.createAudioFile(f);
							audioFiles.add(audioFile);
						}
						catch (AudioFactory.AudioFormatNotSupportedException ex) {
							continue;
						}
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
				Collections.sort(audioFiles);
				
				boolean play = false;
				if (Playlist.this.files.size() == 0)
					play = true;
				
				Playlist.this.files.addAll(audioFiles);
				Playlist.this.refreshTable();
				if (play)
					Playlist.this.updateAudioFile(0);
				
			}
			
		}


	}

	
	
	 
	
	class  SavePlaylistListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser fileChooser;
			File currentFile = Playlist.this.featureAmp.getMenuManager().getCurrentFile();
			if (currentFile == null)
				fileChooser = new JFileChooser();
			else
				fileChooser = new JFileChooser(currentFile);
			fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
			fileChooser.setFileFilter(
					new FileNameExtensionFilter("Playlists", "m3u"));
			
			int returnCode = fileChooser.showSaveDialog(Playlist.this.featureAmp.getFrame());
			if (returnCode == JFileChooser.APPROVE_OPTION) {
				
				try {
					File file = fileChooser.getSelectedFile();
					if (!file.getAbsolutePath().endsWith(".m3u")) {
						file = new File(file.getAbsolutePath()+".m3u");
					}
					FileOutputStream outputStream = new FileOutputStream(file);
					M3U m3u = new M3U();
					for(AudioFile f : Playlist.this.files) {
					    Resource res = new Resource();
					    res.setLocation(f.getFilename());
					    m3u.getResources().add(res);
					}
					m3u.setExtensionM3U(true);
					m3u.writeTo(outputStream, "UTF-8"); 
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		}


	}

	
	
	 
	
	class  LoadPlaylistListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser fileChooser;
			File currentFile = Playlist.this.featureAmp.getMenuManager().getCurrentFile();
			if (currentFile == null)
				fileChooser = new JFileChooser();
			else
				fileChooser = new JFileChooser(currentFile);
			fileChooser.setFileFilter(new FileNameExtensionFilter("Playlists", "m3u"));
			
			int returnCode = fileChooser.showOpenDialog(
					Playlist.this.featureAmp.getFrame());
			if (returnCode == JFileChooser.APPROVE_OPTION) {
				
				try {
					File file = fileChooser.getSelectedFile();
					M3UProvider provider = new M3UProvider();
					M3U m3uPlaylist = (M3U) provider.readFrom(
							new FileInputStream(file), null, null);
					Playlist.this.files.clear();
					Collection<Resource> resources = m3uPlaylist.getResources();
					for(Resource res : resources) {
					    File listFile = new File(res.getLocation());
					    try {
						    Playlist.this.files.add(
						    		AudioFactory.createAudioFile(listFile));
					    }
					    catch (AudioFactory.AudioFormatNotSupportedException ex) {}
					}
					Playlist.this.setCurrentFileIndex(0);
					Playlist.this.refreshTable();
					if (Playlist.this.files.size() > 0)
						Playlist.this.updateAudioFile(0);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
			
		}


	}

	
	
	private QueueFinishedListener queueFinishedListener;

	
	
	 
	
	class  QueueFinishedListener  implements FinishedListener {
		
		
		private FinishedListener actualListener;

		
		
		public void setActualListener(FinishedListener actualListener) {
			this.actualListener = actualListener;
		}

		
		
		@Override
		public Integer getNextIndex() {
			
			LinkedList<AudioFile> queue = Playlist.this.featureAmp.
					getQueueTrack().getQueue();
			
			if (!queue.isEmpty())
				return new Integer(Playlist.this.files.indexOf(queue.pollFirst()));
			
			return this.actualListener.getNextIndex();
		
		}

		
		
		@Override
		public void update(AudioController object) {
			Integer nextIndex = this.getNextIndex();
			if (nextIndex != null)
				Playlist.this.updateAudioFile(nextIndex.intValue());
		}


	}


}
