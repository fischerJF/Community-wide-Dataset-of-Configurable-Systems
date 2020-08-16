package featureamp.dialog; 

import java.io.File; 
import java.util.LinkedList; 

public  class  SongAppender  extends Thread {
	
	private LinkedList<SongAppender> threads = new LinkedList<SongAppender>();

	
	
	private File file;

	
	
	private LinkedList<File> files = new LinkedList<File>();

	
	
	public SongAppender(File f) {
		if (specifications.Configuration.gui) {
			this.file = f;
				}
	}

	
	
	public LinkedList<File> getFiles() {
		return files;
	}

	
	
	public void run() {
		if(file.isFile()) {
			files.add(file);
			return;
		}
		
		for(File f : file.listFiles()) {
			if(f.isFile()) {
				if(f.getName().endsWith(".mp3")) {
					files.add(f);
				}
			}
			else {
				SongAppender sa = new SongAppender(f);
				threads.add(sa);
				sa.start();
			}
		}
		
		for(SongAppender sa : threads) {
			try {
				sa.join();
				files.addAll(sa.getFiles());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
