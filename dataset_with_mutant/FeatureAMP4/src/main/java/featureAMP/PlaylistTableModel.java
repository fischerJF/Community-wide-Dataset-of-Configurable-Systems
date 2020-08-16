package featureAMP;
import javax.swing.table.AbstractTableModel; import java.util.List; 

public   class  PlaylistTableModel  extends AbstractTableModel {
	
	
	private static final long serialVersionUID = 1L;

		
	
	private Playlist playlist;

	

	public PlaylistTableModel(Playlist playlist) {
		if (specifications.Configuration.playlist) {
			this.playlist = playlist;
				}
	}

	

	@Override
	public int getRowCount() {
		return this.playlist.getAudioFiles().size();
	}

	

	@Override
	public int getColumnCount() {
		return 6;
	}

	
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
			case 0: return this.getFirstColumnName();
			case 1: return "Track";
			case 2: return "Titel";
			case 3: return "Interpret";
			case 4: return "Album";
			case 5: return "Länge";
		}
		return "";
	}

	
	
	 private String  getFirstColumnName__wrappee__PLAYLIST  () {
		return "";
	}

	
	
	private String getFirstColumnName() {
		if (!specifications.Configuration.queue_track)
			return getFirstColumnName__wrappee__PLAYLIST();
		return "Queue";
	}

	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		AudioFile file = this.playlist.getAudioFiles().get(rowIndex);
		switch(columnIndex) {
		case 0: return this.getFirstColumnValue(rowIndex);
		case 1: return file.getTrack();
		case 2: return file.getTitle();
		case 3: return file.getArtist();
		case 4: return file.getAlbum();
		case 5: return file.getTotalTime();
		}
		return "";
		
	}

	
	
	 private Object  getFirstColumnValue__wrappee__PLAYLIST  (int rowIndex) {
		if (rowIndex == this.playlist.getCurrentFileIndex())
			return "läuft";
		return "";
	}

	
	
	private Object getFirstColumnValue(int rowIndex) {
		if (!specifications.Configuration.queue_track)
			return getFirstColumnValue__wrappee__PLAYLIST(rowIndex);
		
		List<AudioFile> audioFiles = this.playlist.getAudioFiles();
		QueueTrack queueTrack = this.playlist.getFeatureAmp().getQueueTrack();
		
		AudioFile file = audioFiles.get(rowIndex);
		int queueIndex = queueTrack.getQueue().indexOf(file);
		if (queueIndex >= 0)
			return "noch "+(queueIndex+1);
		
		return getFirstColumnValue__wrappee__PLAYLIST(rowIndex);
		
	}


}
