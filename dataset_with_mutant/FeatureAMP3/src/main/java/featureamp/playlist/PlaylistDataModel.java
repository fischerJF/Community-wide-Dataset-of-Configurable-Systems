package featureamp.playlist; 

import java.lang.reflect.InvocationTargetException; 
import java.lang.reflect.Method; 
import java.util.LinkedHashMap; 
import java.util.LinkedList; 
import java.util.Map; 

import javax.swing.table.AbstractTableModel; 

import featureamp.Song; 

public  class  PlaylistDataModel  extends AbstractTableModel {
	
	
	private LinkedList<Song> songs;

	
	
	private Map<String, String> columnsToFunctionsMap = new LinkedHashMap<String,String>();

	
	
	public PlaylistDataModel() {
		if (specifications.Configuration.playlist) {
			songs = new LinkedList<Song>();
			columnsToFunctionsMap.put("Tracknummer", "getTrackNumber");
			columnsToFunctionsMap.put("Title", "getTitle");
			columnsToFunctionsMap.put("Length", "getLength");
			columnsToFunctionsMap.put("Artist", "getArtist");
			columnsToFunctionsMap.put("Album", "getAlbum");
			columnsToFunctionsMap.put("Filename", "getFileName");
			// #if PlaylistShowCover
			// columnsToFunctionsMap.put("Image", "getImageIcon");
			// #endif
				}
	}

	
	
	public Song[] getSongs() {
		Song[] songs = new Song[this.songs.size()];
		return this.songs.toArray(songs);
	}

	
	
	public Song getSong(int index) {
		return songs.get(index);
	}

	

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		String methodName = (String) columnsToFunctionsMap.values().toArray()[columnIndex];
		try {
			Method method = Song.class.getMethod(methodName);
			return method.getReturnType();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return String.class;
	}

	

	@Override
	public int getColumnCount() {
		return columnsToFunctionsMap.size();
	}

	
	
	@Override
	public String getColumnName(int columnIndex) {
		return (String) columnsToFunctionsMap.keySet().toArray()[columnIndex];
	}

	

	@Override
	public int getRowCount() {
		return songs.size();
	}

	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String methodName = (String) columnsToFunctionsMap.values().toArray()[columnIndex];
		Song song = songs.get(rowIndex);
		
		Method method;
		try {
			method = Song.class.getMethod(methodName);
			return method.invoke(song);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

	public void append(Song song) {
		songs.add(song);
		fireTableDataChanged();
	}

	
	
	public int indexOf(Song song) {
		return songs.indexOf(song);
	}

	

	public boolean remove(Song s) {
		boolean status = songs.remove(s);
		fireTableDataChanged();
		return status;
	}

	
	public void moveSong(Song song, Song before) {
		songs.remove(song);
		songs.add(songs.indexOf(before), song);
		fireTableDataChanged();
	}


}
