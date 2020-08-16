package gui; 

import java.util.LinkedList; 
import java.util.List; 

import players.TrackMetadata; 

public   class  Playlist {
	
	private List<TrackMetadata> tracks;

	
	private int position = 0;

	
	
	public Playlist() {
		if (specifications.Configuration.playlist) {
			tracks = new LinkedList<TrackMetadata>();
				}
	}

	
	
	public void addTrack(TrackMetadata track) {
		tracks.add(track);
	}

	
	
	public void removeTrack(TrackMetadata track) {
		if (tracks.indexOf(track) < position)
		{
			position--;
		}
		tracks.remove(track);
	}

	
	
	public void clearList()
	{
		position = 0;
		tracks.clear();
	}

	
	
	public List<TrackMetadata> getList() {
		return tracks;
	}

	
	
	public TrackMetadata[] getArray() {
		return tracks.toArray(new TrackMetadata[]{});
	}

	
	
	public void shuffleList() {
		TrackMetadata cur = getCurrent();
		//waren am ende, einfach shuffeln und fertig
		java.util.Collections.shuffle(tracks);
		if (cur == null) {
			return;
		}
		position = tracks.indexOf(cur);
	}

	
	
	public TrackMetadata next()
	{
		return next(false);
	}

	
	
	 private TrackMetadata  next__wrappee__Playlist  (boolean force) {
		position++;
		if (position >= tracks.size()) {
			// at end, no next
			return null;
		}
		return getCurrent();
	}

	
	
	 private TrackMetadata  next__wrappee__ShuffleRepeat  (boolean force) {
		if (!specifications.Configuration.shufflerepeat)
			return next__wrappee__Playlist(force);
		if (mode == PlayMode.Normal) {
			position++;
			if (position >= tracks.size()) {
				// at end, no next
				return null;
			}
			return getCurrent();
		} else if (mode == PlayMode.RepeatOne) {
			if (force)
			{
				position++;
				if (position >= tracks.size()) {
					// at end, no next
					return null;
				}
			}
			return getCurrent();
		} else if (mode == PlayMode.RepeatAll) {
			position++;
			if (position >= tracks.size()) {
				position = 0;
			}
			return getCurrent();
		}
		
		return getCurrent();
	}

	
	
	public TrackMetadata next(boolean force)
	{
		if (!specifications.Configuration.queuetrack)
			return next__wrappee__ShuffleRepeat(force);
		if (queue == null)
		{
			queue = new LinkedList<TrackMetadata>();
		}
		
		if (queue.isEmpty())
		{
			return next__wrappee__ShuffleRepeat(force);
		}
		else
		{
			TrackMetadata n = queue.get(0);
			queue.remove(n);
			n.setQueued(-1);
			for (TrackMetadata tm : queue)
			{
				tm.setQueued(queue.indexOf(tm));
			}
			return n;
		}
	}

	
	
	public TrackMetadata getCurrent() {
		if (position >= tracks.size()) {
			return null;
		}
		return tracks.get(position);
	}

	
	
	public TrackMetadata goTo(int index)
	{
		if (index < 0 || index >= tracks.size()) {
			return null;
		}
		position = index;
		return tracks.get(position);
	}

	
	
	public void sortList() {
		TrackMetadata cur = getCurrent();
		java.util.Collections.sort(tracks);
		if (cur == null) {
			return;
		}
		position = tracks.indexOf(cur);
	}

	
	public enum  PlayMode {
		Normal , 
		RepeatOne , 
		RepeatAll}

	
	private PlayMode mode = PlayMode.Normal;

	
	
	public void setMode(PlayMode mode) {
		this.mode = mode;
	}

	
	
	public PlayMode getMode() {
		return this.mode;
	}

	
	public void moveDown(int index){
		if (index < tracks.size() - 1) {
			TrackMetadata cur = getCurrent();
			TrackMetadata temp = tracks.get(index);
			tracks.remove(index);
	        tracks.add(index + 1, temp);
	        position = tracks.indexOf(cur);
        }
	}

	
	
	public void moveUp(int index) {
		if (index > 0) {
			TrackMetadata cur = getCurrent();
			TrackMetadata temp = tracks.get(index);
			tracks.remove(index);
			tracks.add(index - 1, temp);
			position = tracks.indexOf(cur);
		}
	}

	
	private List<TrackMetadata> queue;

	
	
	public void queueTrack(int index)
	{
		if (queue == null)
		{
			queue = new LinkedList<TrackMetadata>();
		}
		
		TrackMetadata track = tracks.get(index);
		
		if (queue.contains(track)){
			queue.remove(track);
			track.setQueued(-1);
			for (TrackMetadata tm : queue)
			{
				tm.setQueued(queue.indexOf(tm));
			}
		} else {
			queue.add(track);
			track.setQueued(queue.indexOf(track));
		}
	}


}
