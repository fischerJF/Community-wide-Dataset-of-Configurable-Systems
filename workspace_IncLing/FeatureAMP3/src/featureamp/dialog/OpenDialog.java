package featureamp.dialog; 

import java.io.File; 
import java.util.LinkedList; 
import java.util.List; 
import java.util.concurrent.Callable; 
import java.util.concurrent.FutureTask; 

import javax.swing.JFileChooser; 
import javax.swing.JFrame; 
import javax.swing.filechooser.FileFilter; 
import javax.swing.filechooser.FileNameExtensionFilter; 

//import com.sun.org.glassfish.external.statistics.annotations.Reset; 

public   class  OpenDialog  extends FileDialog {
	
	public OpenDialog(JFrame frame) {
			super(frame);
				
	}

	
	
	private void resetFileFilters() {
		fileChooser.resetChoosableFileFilters();
		fileChooser.setAcceptAllFileFilterUsed(false);
		extensions = new String[0];
	}

	
	
	 private void  addFileFilters__wrappee__GUI  () {
		
	}

	
	 private void  addFileFilters__wrappee__Mp3  () {
		if (!specifications.Configuration.mp3) {
			addFileFilters__wrappee__GUI();
			return;
		}
		addFileFilters__wrappee__GUI();
//		System.out.println("[Mp3.OpenDialog] addFileFilters()");
		String[] extensions = {"mp3"};
		addAllowedFileExtensions(extensions);
	}

	
	 private void  addFileFilters__wrappee__Wav  () {
		if (!specifications.Configuration.wav) {
			addFileFilters__wrappee__Mp3();
			return;
		}
		addFileFilters__wrappee__Mp3();
//		System.out.println("[Wav.OpenDialog] addFileFilters()");
		String[] extensions = {"wav"};
		addAllowedFileExtensions(extensions);
	}

	
	 private void  addFileFilters__wrappee__Aac  () {
		if (!specifications.Configuration.aac) {
			addFileFilters__wrappee__Wav();
			return;
		}
		addFileFilters__wrappee__Wav();
		//System.out.println("[Aac.OpenDialog] addFileFilters()");
		String[] extensions = {"aac"};
		addAllowedFileExtensions(extensions);
	}

	
	private void addFileFilters() {
		if (!specifications.Configuration.ogg) {
			addFileFilters__wrappee__Aac();
			return;
		}
		addFileFilters__wrappee__Aac();
//		System.out.println("[Ogg.OpenDialog] addFileFilters()");
		String[] extensions = {"ogg"};
		addAllowedFileExtensions(extensions);
	}

	
	
	/**
	 * Called from the user
	 * 
	 * @param allowDirectories
	 * @param allowedFileExtensions 
	 * 
	 * @return FutureTask
	 */
	
	public FutureTask<List<File>> choose(boolean allowDirectories, final String... allowedFileExtensions) {
		if(allowDirectories) {
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		} else {
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		}
		resetFileFilters();
		if(allowedFileExtensions.length > 0) {
			addAllowedFileExtensions(allowedFileExtensions);
		} else {
			addFileFilters();
			FileFilter audioFilter = null;
			switch(extensions.length) {
			case 1 :
				audioFilter = new FileNameExtensionFilter("Audio File", extensions[0]);
				break;
			case 2 :
				audioFilter = new FileNameExtensionFilter("Audio Files", extensions[0], extensions[1]);
				break;
			case 3 :
				audioFilter = new FileNameExtensionFilter("Audio Files", extensions[0], extensions[1], extensions[2]);
				break;
			case 4 :
				audioFilter = new FileNameExtensionFilter("Audio Files", extensions[0], extensions[1], extensions[2], extensions[3]);
				break;
			}
			if(audioFilter != null)
				fileChooser.addChoosableFileFilter(audioFilter);
		}
		fileChooser.setMultiSelectionEnabled(allowDirectories);
		
		FutureTask<List<File>> ft = new FutureTask<List<File>>(new Callable<List<File>>() {
	         public List<File> call() {
	        	 List<File> fileList = new LinkedList<File>();
	        	 
	        	 if(fileChooser.showOpenDialog(frame) != JFileChooser.APPROVE_OPTION)
	        		 return null;

					if(fileChooser.getSelectedFiles().length > 0) {
						if(searchRecursive) {
							threads = new LinkedList<SongAppender>();
						}
						
						for(File f : fileChooser.getSelectedFiles()) {
							if(searchRecursive) {
								SongAppender sa = new SongAppender(f);
								threads.add(sa);
								sa.start();
							} else {
								if(f.isDirectory()) {
									File[] files = f.listFiles(new java.io.FileFilter() {
										@Override
										public boolean accept(File f) {
											// Todo other extensions
											return f.isFile() && f.getName().endsWith(".mp3");
										}
									});
									
									for(File file : files) {
										//setChanged();
										//notifyObservers(file);
										fileList.add(file);
									}
								} else {
									//setChanged();
									//notifyObservers(f);
									fileList.add(f);
								}
							}
						}
						
						// After starting the threads wait for threads to finish
						if(searchRecursive) {
							for(SongAppender sa : threads) {
							try {
									sa.join();
									for(File file : sa.getFiles()) {
										//setChanged();
										//notifyObservers(file);
										fileList.add(file);
									}
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					} else {
						File f = fileChooser.getSelectedFile();
						// do we need != null check anymore? because we checked the return type of openFileDialog..
						if(f != null) {
							//setChanged();
							//notifyObservers(f);
							fileList.add(f);
						}
					}
					
					return fileList;
	         }});
		
		ft.run();
		
		return ft;
	}


}
