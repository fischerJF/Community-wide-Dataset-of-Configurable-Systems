package featureAMP;
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.LinkedList; 

import javax.swing.JButton; 
import javax.swing.JPanel; 

public  class  QueueTrack {
	
	
	private Playlist playlist;

	
	
	private JPanel queuePanel;

	
	private JButton addButton;

	
	private JButton removeButton;

	
	
	private LinkedList<AudioFile> queue;

	
	
	public QueueTrack(Playlist playlist) {
		if (specifications.Configuration.queue_track) {
			
			this.playlist = playlist;
			
			this.queue = new LinkedList<AudioFile>();
			
			this.queuePanel = new JPanel();
			this.queuePanel.setLayout(new GridLayout(1,2));
			this.addButton = new JButton("+ Queue");
			this.addButton.addActionListener(new AddButtonListener());
			this.queuePanel.add(this.addButton);
			this.removeButton = new JButton("– Queue");
			this.removeButton.addActionListener(new RemoveButtonListener());
			this.queuePanel.add(this.removeButton);
			
				}
	}

	
	
	public JPanel getQueuePanel() {
		return this.queuePanel;
	}

	
	
	public LinkedList<AudioFile> getQueue() {
		return this.queue;
	}

	
	
	 
	
	class  AddButtonListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (QueueTrack.this.playlist.getAudioFiles().size() > 0) {
		
				int[] rows = QueueTrack.this.playlist.getPlaylistTable().getSelectedRows();
				if (rows.length == 1) {
					
					if (QueueTrack.this.playlist.getCurrentFileIndex() != rows[0]) {
						
						AudioFile newFile = QueueTrack.this.playlist.
								getAudioFiles().get(rows[0]);
						
						if (!QueueTrack.this.queue.contains(newFile))
							QueueTrack.this.queue.offerLast(newFile);
						
						QueueTrack.this.playlist.refreshTable();
						
					}
					
				}
				
			}
			
		}


	}

	
	
	 
	
	class  RemoveButtonListener  implements ActionListener {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (QueueTrack.this.playlist.getAudioFiles().size() > 0) {
			
				int[] rows = QueueTrack.this.playlist.getPlaylistTable().getSelectedRows();
				
				for (int row: rows) {
					
					AudioFile removeFile = QueueTrack.this.playlist.
							getAudioFiles().get(row);
					QueueTrack.this.queue.remove(removeFile);
					
				}
				
				QueueTrack.this.playlist.refreshTable();
				
			}
			
		}


	}


}
