package featureamp.playlist; 

import java.util.Collection; 
import java.util.LinkedList; 

import java.util.List; 

import javax.swing.event.TableModelEvent; 
import javax.swing.event.TableModelListener; 
import javax.swing.table.TableModel; 

import featureamp.playback.Track; 

/**
 * TODO description
 */
public   class  Playlist  implements TableModel {
	

	private List<Track> items;

	
	public static final int TRACK_NUMBER = 0, TITLE = 1, TIME = 2, ARTIST = 3,
			ALBUM = 4, TRACK = -1;

	

	private List<TableModelListener> listeners;

	

	public Playlist() {
		if (specifications.Configuration.playlist) {
			// Playlist
			items = new LinkedList<Track>();
			listeners = new LinkedList<TableModelListener>();
			
		}
	}

	

	@Override
	public int getRowCount() {
		// Playlist
		return items.size();
	}

	

	
	 private int  getColumnCount__wrappee__Playlist() {
		// Playlist
		return 5;
	}

	

	public int getColumnCount() {
		if (!specifications.Configuration.skiptrack)
			return getColumnCount__wrappee__Playlist();
		// SkipTrack
		return getColumnCount__wrappee__Playlist() + 1;
	}

	

	
	 private String  getColumnName__wrappee__Playlist(int columnIndex) {
		// Playlist
		switch (columnIndex) {
		case TRACK_NUMBER:
			return "Nr.";
		case TITLE:
			return "Name";
		case TIME:
			return "Duration";
		case ARTIST:
			return "Artist";
		case ALBUM:
			return "Album";
		}
		return null;
	}

	

	public String getColumnName(int index) {
		if (!specifications.Configuration.skiptrack)
			return getColumnName__wrappee__Playlist(index);
		// SkipTrack
		return getColumnName__wrappee__Playlist(index) == null ? "Active" : getColumnName__wrappee__Playlist(index);
	}

	

	
	 private Class<?>  getColumnClass__wrappee__Playlist(int columnIndex) {
		// Playlist
		return columnIndex == TRACK_NUMBER ? Integer.class : String.class;
	}

	

	public Class<?> getColumnClass(int columnIndex) {
		if (!specifications.Configuration.skiptrack)
			return getColumnClass__wrappee__Playlist(columnIndex);
		// SkipTrack
		return columnIndex == ENABLED ? Boolean.class : getColumnClass__wrappee__Playlist(columnIndex);
	}

	

	
	 private boolean  isCellEditable__wrappee__Playlist(int rowIndex, int columnIndex) {
		// Playlist
		return false;
	}

	

	public boolean isCellEditable(int row, int col) {
		if (!specifications.Configuration.skiptrack)
			return isCellEditable__wrappee__Playlist(row, col);
		// SkipTrack
		return col == ENABLED;
	}

	

	
	 private Object  getValueAt__wrappee__Playlist(int rowIndex, int columnIndex) {
		// Playlist
		Track t = items.get(rowIndex);
		switch (columnIndex) {
		case ALBUM:
			return t.getAlbum();
		case ARTIST:
			return t.getArtist();
		case TIME:
			return t.getLength();
		case TRACK_NUMBER:
			try {
			return new Integer(t.getTracknumber());
			} catch (Exception e) {
				return -1;
			}
		case TITLE:
			return t.getTitle();
		case TRACK:
			return t;
		}
		return null;
	}

	

	public Object getValueAt(int row, int col) {
		if (!specifications.Configuration.skiptrack)
			return getValueAt__wrappee__Playlist(row, col);
		// SkipTrack
		return col == ENABLED ? ((Track) getValueAt__wrappee__Playlist(row, -1)).enabled()
				: getValueAt__wrappee__Playlist(row, col);
	}

	

	
	 private void  setValueAt__wrappee__Playlist(Object aValue, int rowIndex, int columnIndex) {
		// Playlist
	}

	

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (!specifications.Configuration.skiptrack) {
			setValueAt__wrappee__Playlist(aValue, rowIndex, columnIndex);
			return;
		}
		// SkipTrack
		if (columnIndex == ENABLED) {
			Track t = items.get(rowIndex);
			t.setEnabled((Boolean) aValue);
		}
	}

	

	@Override
	public void addTableModelListener(TableModelListener l) {
		// Playlist
		listeners.add(l);
	}

	

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// Playlist
		listeners.remove(l);
	}

	

	public Track getTrack(int id) {
		// Playlist
		return items.get(id);
	}

	

	public Track addTrack(Track t) {
		// Playlist
		items.add(t);
		for (TableModelListener tml : listeners) {
			tml.tableChanged(new TableModelEvent(this, items.size()));
		}
		return t;
	}

	

	public void addTracks(Collection<Track> tracks) {
		// Playlist
		for (Track t : tracks) {
			items.add(t);
		}
	}

	
	// SkipTrack
	public static final int ENABLED = 5;

	

	public void removeTrack(Track t) {
		// RemoveTrack
		items.remove(t);
		for (TableModelListener tml : listeners) {
			tml.tableChanged(new TableModelEvent(this, items.size()));
		}
	}

	

	public void clear() {
		// ClearPlaylist
		items.clear();
		for (TableModelListener tml : listeners) {
			tml.tableChanged(new TableModelEvent(this, items.size()));
		}
	}

	

	public void reorder(int from, int to) {
		// Reorder
		Track t = items.get(from);
		items.remove(from);
		items.add(from < to ? to - 1 : to, t);
	}

	

	public List<Track> getAll() {
		// SaveAndLoad
		return items;
	}

	

	public void removeFirst() {
		items.remove(0);
		for (TableModelListener tml : listeners) {
			tml.tableChanged(new TableModelEvent(this, items.size()));
		}
	}


}
