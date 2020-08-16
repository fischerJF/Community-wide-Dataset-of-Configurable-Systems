package gui; 

import java.io.File; 
import java.io.FilenameFilter; import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator; 
import java.util.Enumeration; import java.util.List; 

import javax.swing.DefaultListModel; 

import engine.AudioFile; import java.util.Random; 
import java.util.LinkedList; 

//import com.sun.media.sound.ModelAbstractChannelMixer; 
//import com.sun.media.sound.ModelSource;

public   class  Playlist {
	
	private static  class  CustomListModel <T>  extends DefaultListModel<T> {
		
		@Override
		public void fireContentsChanged(Object source, int index0, int index1) {
			super.fireContentsChanged(source, index0, index1);
		}


	}

	
	
	private CustomListModel<PlaylistItem> model = new CustomListModel<PlaylistItem>();

	
	private int position = -1;

	
	
	DefaultListModel getModel() {
		return model;
	}

	
	
	void loadFolder(File folder) {
		File[] contents = folder.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return Main.FILE_EXTENSIONS.contains(AudioFile.getExtension(name));
			}
		});
		
		List<PlaylistItem> items = new ArrayList<PlaylistItem>();
					
		for(File file : contents)
			items.add(new PlaylistItem(new AudioFile(file)));
		
		Collections.sort(items, new Comparator<PlaylistItem>() {
			@Override
			public int compare(PlaylistItem arg0, PlaylistItem arg1) {
				return arg0.getAudioFile().getMetaData().getTrack()
						- arg1.getAudioFile().getMetaData().getTrack();
			}
		});

		for(PlaylistItem item : items)
			model.addElement(item);
	}

	
	
	boolean empty() {
		return model.isEmpty();
	}

	
	
	int size() {
		return model.size();
	}

	
	
	void add(AudioFile file) {
		model.addElement(new PlaylistItem(file));
	}

	
	
	List<PlaylistItem> items() {
		List<PlaylistItem> result = new ArrayList<PlaylistItem>(model.size());
		
		for(Enumeration<PlaylistItem> e = model.elements(); e.hasMoreElements();)
			result.add(e.nextElement());
		
		return result;
	}

	
	
	 private AudioFile  getNext__wrappee__Playlist  () {
		int nextPos = position + 1;
		if(nextPos >= model.size())
			return null;
		
		setPosition(nextPos);
		return model.get(position).getAudioFile();
	}

	
	
	 private AudioFile  getNext__wrappee__ShuffleRepeat  () {
		if (!specifications.Configuration.shufflerepeat)
			return getNext__wrappee__Playlist();
		if(model.isEmpty())
			return null;
		
		if(shuffle) {
			int position = random.nextInt(model.size());
			setPosition(position);
			return model.get(position).getAudioFile();
		} 
		else if(repeatMode == Repeat.List) {
			if(position + 1 >= model.size())
				position = -1;
			return getNext__wrappee__Playlist();
		}
		else if(repeatMode == Repeat.Track) {
			if(position >= 0)
				return model.get(position).getAudioFile();
			return null;
		}
		else {
			return getNext__wrappee__Playlist();
		}
	}

	
	
	AudioFile getNext() {
		if (!specifications.Configuration.queuetrack)
			return getNext__wrappee__ShuffleRepeat();
		PlaylistItem item = queue.poll();
		if(item == null)
			return getNext__wrappee__ShuffleRepeat();
		
		updateQueuePositions();
		
		setPosition(model.indexOf(item));
		
		return item.getAudioFile();
	}

	
	
	AudioFile moveTo(int position) {
		if(position >= model.size())
			return null;
		setPosition(position);
		return model.get(position).getAudioFile();
	}

	
	
	private void setPosition(int position) {
		this.position = position;
	}

	
	 enum  Repeat { Track ,  List ,  None}

	
	
	private Repeat repeatMode;

	
	private boolean shuffle;

	
	private Random random = new Random();

	
	
	void setRepeat(Repeat mode) {
		this.repeatMode = mode;
	}

	
	
	void setShuffle(boolean shuffle) {
		this.shuffle = shuffle;
	}

	
	
	 private void  remove__wrappee__RemoveTrack  (PlaylistItem item) {
		model.removeElement(item);
		setPosition(Math.min(position, model.size() - 1));
	}

	
	void remove(PlaylistItem item) {
		if (!specifications.Configuration.queueremove) {
			remove__wrappee__RemoveTrack(item);
			return;
		}
		queue.remove(item);
		remove__wrappee__RemoveTrack(item);

		updateQueuePositions();
	}

	
	
	void moveItem(int index, boolean up) {
		int newIndex = index + (up ? -1 : 1);
		
		if(newIndex < 0 || newIndex >= model.size())
			return;
		
		PlaylistItem item = model.get(index);
		model.remove(index);
		model.add(newIndex, item);
		
		if(position == index)
			setPosition(newIndex);
		else if(position == newIndex)
			setPosition(index);		
	}

	
	private LinkedList<PlaylistItem> queue = new LinkedList<PlaylistItem>();

	
	
	private void updateQueuePositions() {
		if(model.isEmpty())
			return;
		
		for(PlaylistItem item : items())
			item.setQueuePosition(-1);
		
		int queuePos = 0;
		
		for(PlaylistItem item : queue) {
			item.setQueuePosition(queuePos);
			queuePos++;
		}
		
		model.fireContentsChanged(model, 0, model.size() - 1);
	}

	
	
	void toggleQueued(PlaylistItem item) {
		if(queue.contains(item))
			queue.remove(item);
		else
			queue.offer(item);
		updateQueuePositions();
	}


}
