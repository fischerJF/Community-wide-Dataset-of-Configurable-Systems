package featureAMP;
import java.awt.GridLayout; 

import javax.swing.JPanel; import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import javax.swing.JButton; 
import java.util.ArrayList; 
import java.util.List; 

public   class  PlayerControl {
	
	
	private Playlist playlist;

	
	
	private JPanel controlPanel;

	
	
	public PlayerControl(Playlist playlist) {
		if (specifications.Configuration.player_control) {
			
			this.playlist = playlist;
			
			this.controlPanel = new JPanel();
			this.fillControlPanel();
			this.setLayoutManager();
			
				}
	}

	
	
	 private void  fillControlPanel__wrappee__PLAYER_CONTROL  () {}

	
	
	 private void  fillControlPanel__wrappee__SHUFFLE_REPEAT  () {
		if (!specifications.Configuration.shuffle_repeat) {
			fillControlPanel__wrappee__PLAYER_CONTROL();
			return;
		}
		fillControlPanel__wrappee__PLAYER_CONTROL();
		this.shuffleButton = new JButton("Normal");
		this.shuffleButton.setName("playModeButton");
		this.shuffleButton.addActionListener(new ShuffleButtonListener());
		this.controlPanel.add(this.shuffleButton);
	}

	
	
	 private void  fillControlPanel__wrappee__SKIP_TRACK  () {
		if (!specifications.Configuration.skip_track) {
			fillControlPanel__wrappee__SHUFFLE_REPEAT();
			return;
		}
		fillControlPanel__wrappee__SHUFFLE_REPEAT();
		this.skipButton = new JButton("Skip");
		this.skipButton.setName("skip");
		this.skipButton.addActionListener(new SkipButtonListener());
		this.controlPanel.add(this.skipButton);
	}

	
	
	 private void  fillControlPanel__wrappee__REMOVE_TRACK  () {
		if (!specifications.Configuration.remove_track) {
			fillControlPanel__wrappee__SKIP_TRACK();
			return;
		}
		fillControlPanel__wrappee__SKIP_TRACK();
		this.removeButton = new JButton("– Track");
		this.removeButton.setName("remove");
		this.removeButton.addActionListener(new RemoveButtonListener());
		this.controlPanel.add(this.removeButton);
	}

	
	
	 private void  fillControlPanel__wrappee__CLEAR_PLAYLIST  () {
		if (!specifications.Configuration.clear_playlist) {
			fillControlPanel__wrappee__REMOVE_TRACK();
			return;
		}
		fillControlPanel__wrappee__REMOVE_TRACK();
		this.clearButton = new JButton("Clear");
		this.clearButton.setName("clear");
		this.clearButton.addActionListener(new ClearButtonListener());
		this.controlPanel.add(this.clearButton);
	}

	
	
	private void fillControlPanel() {
		if (!specifications.Configuration.reorder_playlist) {
			fillControlPanel__wrappee__CLEAR_PLAYLIST();
			return;
		}
		fillControlPanel__wrappee__CLEAR_PLAYLIST();
		this.upButton = new JButton("auf");
		this.upButton.setName("up");
		this.upButton.addActionListener(new UpButtonListener());
		this.controlPanel.add(this.upButton);
		this.downButton = new JButton("ab");
		this.downButton.setName("down");
		this.downButton.addActionListener(new DownButtonListener());
		this.controlPanel.add(this.downButton);
	}

	
	
	private void setLayoutManager() {
		this.controlPanel.setLayout(
				new GridLayout(1, this.controlPanel.getComponentCount()));
	}

	
	
	public JPanel getControlPanel() {
		return this.controlPanel;
	}

	
	
	public static final int NO_SHUFFLE_REPEAT = 0;

	
	public static final int REPEAT_ONE = 1;

	
	public static final int REPEAT_ALL = 2;

	
	public static final int SHUFFLE_ALL = 3;

	
	
	private JButton shuffleButton;

	
	private int shuffleState = NO_SHUFFLE_REPEAT;

	
	
	 
	
	class  ShuffleButtonListener  implements ActionListener {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (PlayerControl.this.shuffleState) {
			
			case PlayerControl.NO_SHUFFLE_REPEAT:
				PlayerControl.this.shuffleState = PlayerControl.REPEAT_ONE;
				PlayerControl.this.shuffleButton.setText("Rep. 1");
				PlayerControl.this.playlist.updateFinishedListener(
						new RepeatOneFinishedListener());
				break;
				
			case PlayerControl.REPEAT_ONE:
				PlayerControl.this.shuffleState = PlayerControl.REPEAT_ALL;
				PlayerControl.this.shuffleButton.setText("Rep. All");
				PlayerControl.this.playlist.updateFinishedListener(
						new RepeatAllFinishedListener());
				break;
				
			case PlayerControl.REPEAT_ALL:
				PlayerControl.this.shuffleState = PlayerControl.SHUFFLE_ALL;
				PlayerControl.this.shuffleButton.setText("Shuffle");
				PlayerControl.this.playlist.updateFinishedListener(
						new ShuffleAllFinishedListener());
				break;
				
			case PlayerControl.SHUFFLE_ALL:
				PlayerControl.this.shuffleState = PlayerControl.NO_SHUFFLE_REPEAT;
				PlayerControl.this.shuffleButton.setText("Normal");
				PlayerControl.this.playlist.updateFinishedListener(
						PlayerControl.this.playlist.new NextFinishedListener());
				break;
			
			}
			
		}


	}

	
	
	 
	
	class  RepeatOneFinishedListener  implements FinishedListener {
		
		
		@Override
		public Integer getNextIndex() {
			return new Integer(PlayerControl.this.playlist.getCurrentFileIndex());
		}

		
		
		@Override
		public void update(AudioController object) {
			PlayerControl.this.playlist.updateAudioFile(
					this.getNextIndex().intValue());
		}


	}

	
	
	 
	
	class  RepeatAllFinishedListener  implements FinishedListener {
		
		
		@Override
		public Integer getNextIndex() {
			int maxIndex = PlayerControl.this.playlist.getAudioFiles().size()-1;
			if (PlayerControl.this.playlist.getCurrentFileIndex() < maxIndex)
				return new Integer(
						PlayerControl.this.playlist.getCurrentFileIndex() + 1);
			return new Integer(0);
		}

		
		
		@Override
		public void update(AudioController object) {
			PlayerControl.this.playlist.updateAudioFile(
					this.getNextIndex().intValue());
		}


	}

	
	
	 
	
	class  ShuffleAllFinishedListener  implements FinishedListener {
		
		
		@Override
		public Integer getNextIndex() {
			int count = PlayerControl.this.playlist.getAudioFiles().size();
			if (count > 1) {
				int newIndex = PlayerControl.this.playlist.getCurrentFileIndex();
				while (newIndex == PlayerControl.this.playlist.getCurrentFileIndex())
					newIndex = (int) (Math.random()*count);
				return new Integer(newIndex);
			}
			return null;
		}

		
		
		@Override
		public void update(AudioController object) {
			Integer nextIndex = this.getNextIndex();
			if (nextIndex != null)
				PlayerControl.this.playlist.updateAudioFile(nextIndex.intValue());
		}


	}

	
	
	private JButton skipButton;

	
	
	 
	
	class  SkipButtonListener  implements ActionListener {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (PlayerControl.this.playlist.getAudioFiles().size() > 0) {
				
				int newIndex = 0;
				
				int currentIndex = PlayerControl.this.playlist.getCurrentFileIndex();
				Integer suggestedIndex = PlayerControl.this.playlist.getFinishedListener().
						getNextIndex();
				
				if (suggestedIndex == null)
					newIndex = 0;
				else if (suggestedIndex.intValue() == currentIndex) {
					newIndex = currentIndex + 1;
					if (newIndex >= PlayerControl.this.playlist.getAudioFiles().size())
						newIndex = 0;
				}
				else
					newIndex = suggestedIndex.intValue();
				
				PlayerControl.this.playlist.updateAudioFile(newIndex);
				
			}
			
		}


	}

	
	
	private JButton removeButton;

	
	
	 
	
	class  RemoveButtonListener  implements ActionListener {
		
		
		protected void removeRows(int[] rows) {
			
			List<AudioFile> audioFiles = PlayerControl.this.playlist.getAudioFiles();
			List<AudioFile> removeFiles = new ArrayList<AudioFile>();
			
			int oldCurrentFileIndex = PlayerControl.this.playlist.getCurrentFileIndex();
			
			boolean playedFileRemoved = false;
			for (int row: rows) {
				removeFiles.add(audioFiles.get(row));
				if (oldCurrentFileIndex >= row) {
					PlayerControl.this.playlist.setCurrentFileIndex(
							PlayerControl.this.playlist.getCurrentFileIndex() - 1);
					if (oldCurrentFileIndex == row)
						playedFileRemoved = true;
				}
			}
			
			if (PlayerControl.this.playlist.getCurrentFileIndex() < 0)
				PlayerControl.this.playlist.setCurrentFileIndex(0);
			
			PlayerControl.this.playlist.removeAudioFiles(removeFiles);
			PlayerControl.this.playlist.refreshTable();
			
			if (playedFileRemoved) {
				PlayerControl.this.playlist.getFeatureAmp().getAudioController().stop();
				if (audioFiles.size() > 0)
					PlayerControl.this.playlist.updateAudioFileWithoutPlay(
							PlayerControl.this.playlist.getCurrentFileIndex());
				else
					PlayerControl.this.playlist.getFeatureAmp().setAudioController(null);
			}
			
		}

		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (PlayerControl.this.playlist.getAudioFiles().size() > 0) {
			
				int[] rows = PlayerControl.this.playlist.getPlaylistTable().
						getSelectedRows();
				
				if (rows.length > 0)
					this.removeRows(rows);
				
			}
			
		}


	}

	
	
	private JButton clearButton;

	
	
	 
	
	class  ClearButtonListener  extends RemoveButtonListener {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int size = PlayerControl.this.playlist.getAudioFiles().size();
			if (size > 0) {
			
				int[] rows = new int[size];
				for (int i = 0; i < rows.length; i++)
					rows[i] = i;
				
				this.removeRows(rows);
				
			}
			
		}


	}

	
	
	private JButton upButton;

	
	private JButton downButton;

	
	
	private void swapAudioFiles(int row1, int row2) {
		
		List<AudioFile> audioFiles = this.playlist.getAudioFiles();
		
		AudioFile file1 = audioFiles.get(row1);
		AudioFile file2 = audioFiles.get(row2);
		
		audioFiles.set(row1, file2);
		audioFiles.set(row2, file1);
		
		if (row1 == this.playlist.getCurrentFileIndex())
			this.playlist.setCurrentFileIndex(row2);
		else if (row2 == this.playlist.getCurrentFileIndex())
			this.playlist.setCurrentFileIndex(row1);
		
		this.playlist.refreshTable();
		
	}

	
	
	 
	
	class  UpButtonListener  implements ActionListener {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (PlayerControl.this.playlist.getAudioFiles().size() > 0) {
				
				int[] rows = PlayerControl.this.playlist.getPlaylistTable().
						getSelectedRows();
				
				if (rows.length == 1) {
					
					int row = rows[0];
					if (row > 0)
						PlayerControl.this.swapAudioFiles(row, row - 1);
					
				}
				
			}
			
		}


	}

	
	
	 
	
	class  DownButtonListener  implements ActionListener {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int size = PlayerControl.this.playlist.getAudioFiles().size();
			if (size > 0) {
				
				int[] rows = PlayerControl.this.playlist.getPlaylistTable().
						getSelectedRows();
				
				if (rows.length == 1) {
					
					int row = rows[0];
					if (row < (size - 1))
						PlayerControl.this.swapAudioFiles(row, row + 1);
					
				}
				
			}
			
		}


	}


}
