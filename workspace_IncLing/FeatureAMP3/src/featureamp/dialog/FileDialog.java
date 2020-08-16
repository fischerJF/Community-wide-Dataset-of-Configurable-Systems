package featureamp.dialog; 

import java.io.File; 
import java.util.LinkedList; 
import java.util.Observable; 
import java.util.Observer; 

import javax.swing.JFileChooser; 
import javax.swing.JFrame; 
import javax.swing.filechooser.FileFilter; 

public  class  FileDialog  extends Observable {
	
	protected JFrame frame;

	
	
	protected JFileChooser fileChooser;

	
	
	protected boolean searchRecursive = false;

	
	
	protected LinkedList<SongAppender> threads;

	

	protected String[] extensions = {};

	
	
	protected FileDialog(JFrame frame) {
		if (specifications.Configuration.gui) {
			this.frame = frame;
			fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("C:\\Users\\robert\\Music\\Amp\\"));
				}
	}

	
	
	public void addAllowedFileExtensions(final String[] allowedFileExtensions) {
		String[] _extensions = new String[extensions.length+allowedFileExtensions.length];
		int e=0;
		for(;e<extensions.length;e++) {
			_extensions[e] = extensions[e];
		}
		int offset = e;
		for(;e<_extensions.length;e++) {
			_extensions[e] = allowedFileExtensions[e-offset];
		}
		extensions = _extensions;
		
		System.out.println("[GUI.FileDialog] addAllowedFileExtensions("+allowedFileExtensions[0]+")");
		fileChooser.addChoosableFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return allowedFileExtensions[0];
			}
			
			@Override
			public boolean accept(File arg0) {
				if(arg0.isDirectory())
					return true;
				
				for(String ext : allowedFileExtensions) {
					if(arg0.getName().endsWith(ext)) {
						return true;
					}
				}
				
				return false;
			}
		});
	}

	
	
	public static SaveDialog saver(JFrame frame/*, Observer os*//*, String ...allowedFileExtensions*/) {
		SaveDialog f = new SaveDialog(frame);
		//f.addObserver(os);
		return f;
	}

	
	
	public static OpenDialog chooser(JFrame frame/*, Observer os*//*, String ...allowedFileExtensions*/) {
		OpenDialog f = new OpenDialog(frame);
		//f.addObserver(os);
		return f;
	}


}
