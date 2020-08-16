package gui; 

import java.util.LinkedList; 
import java.util.List; 

import player.TrackMetadata; 

public   class  Playlist {
	

	public List<TrackMetadata> tracks;

	
	public int position = 0;

	

	// Konstruktor
	public Playlist() {
		if (specifications.Configuration.playlist) {
			tracks = new LinkedList<TrackMetadata>();
				}
	}

	

	// Liste aller Tracks
	public List<TrackMetadata> getList() {
		return tracks;
	}

	

	// Metadaten Array
	public TrackMetadata[] getArray() {
		return tracks.toArray(new TrackMetadata[] {});
	}

	

	// neuen Track hinzufügen
	public void addTrack(TrackMetadata track) {
		tracks.add(track);
	}

	

	// aktuellen Track löschen
	public void removeTrack(TrackMetadata track) {
		if(tracks.indexOf(track) < position){
			position--;
		}	
		tracks.remove(track);
	}

	
	
	// komplette Liste löschen
	public void clearPlaylist(TrackMetadata track){
		position=0;
		tracks.clear();
	}

	
	// aktueller Track
	public TrackMetadata getCurrent() {
		if (position >= tracks.size())
			return null;
		return tracks.get(position);
	}

	

	// springe zu bestimmtem Track
	public TrackMetadata goTo(int index) {
		if (index < 0 || index >= tracks.size()) {
			return null;
		}
		position = index;
		return getCurrent();
	}

	

	// sortiere die Liste
	public void sortList() {
		TrackMetadata cur = getCurrent();
		java.util.Collections.sort(tracks);
		if (cur == null) {
			return;
		}
		position = tracks.indexOf(cur);
	}

	

	/********* Special Stuff ***********/
	// #if ShuffleRepeat
	public enum  PlayMode {
		Normal ,  RepeatOne ,  RepeatAll}

	

	public PlayMode mode = PlayMode.Normal;

	

	// #endif

	// #if ShuffleRepeat
	public void shuffleList() {
		TrackMetadata cur = getCurrent();
		// waren am ende, einfach shuffeln und fertig
		java.util.Collections.shuffle(tracks);
		if (cur == null) {
			return;
		}
		position = tracks.indexOf(cur);
	}

	

	public void setMode(PlayMode mode) {
		this.mode = mode;
	}

	

	public PlayMode getMode() {
		return this.mode;
	}

	

	// #endif

	 private TrackMetadata  next__wrappee__Playlist  () {
		// #if ShuffleRepeat
		if (mode == PlayMode.Normal) {
			position++;
			if (position >= tracks.size()) {
				// at end, no next
				return null;
			}
			return getCurrent();
		} else if (mode == PlayMode.RepeatOne) {
			if (position >= tracks.size()) {
				// at end, no next
				System.out.println("No next Track!");
				return null;
			}
			return getCurrent();
		} else {
			position++;
			if (position >= tracks.size()) {
				position = 0;
			}
			return getCurrent();
		}
	}

	

	public TrackMetadata next() {
		if (!specifications.Configuration.queuetrack)
			return next__wrappee__Playlist();
		if (queue.isEmpty()) {
			// #if ShuffleRepeat
			if (mode == PlayMode.Normal) {
				position++;
				if (position >= tracks.size()) {
					// at end, no next
					return null;
				}
				return getCurrent();
			} else if (mode == PlayMode.RepeatOne) {
				if (position >= tracks.size()) {
					// at end, no next
					System.out.println("No next Track!");
					return null;
				}
				return getCurrent();
			} else {
				position++;
				if (position >= tracks.size()) {
					position = 0;
				}
				return getCurrent();
			}
		}else{
			TrackMetadata n = queue.get(0);
			queue.remove(n);
			return n;
		}
	}

	
	
	public void moveDown(int index){
		if(index < tracks.size()-1){
		TrackMetadata temp = tracks.get(index);
		tracks.remove( index );
        tracks.add( index + 1, temp );
        position++;
        }else{
        	System.out.println("Is schon letzter...");
        }
		
	}

	
	
	
	
	public void moveUp(int index) {
		if (index > 0) {
			TrackMetadata temp = tracks.get(index);
			tracks.remove(index);
			tracks.add(index - 1, temp);
			position--;
		} else {
			System.out.println("Is schon erster...");
		}
	}

	

	public List<TrackMetadata> queue = new LinkedList<TrackMetadata>();

	
	public TrackMetadata[] getQueueArray() {
		return queue.toArray(new TrackMetadata[] {});
	}


}
