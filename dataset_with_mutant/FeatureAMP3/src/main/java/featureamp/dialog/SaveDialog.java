package featureamp.dialog; 

import java.io.File; 
import java.util.LinkedList; 
import java.util.List; 
import java.util.concurrent.Callable; 
import java.util.concurrent.FutureTask; 

import javax.swing.JFileChooser; 
import javax.swing.JFrame; 

public  class  SaveDialog  extends FileDialog {
	
	public SaveDialog(JFrame frame) {
		super(frame);
		if (specifications.Configuration.gui) {
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setMultiSelectionEnabled(false);
		}
	}

	
	
	public FutureTask<List<File>> save(String ...allowedFileExtensions) {
		addAllowedFileExtensions(allowedFileExtensions);
		
		FutureTask<List<File>> ft = new FutureTask<List<File>>(new Callable<List<File>>() {
	         public List<File> call() {
	        	 List<File> fileList = new LinkedList<File>();
	        	 
	        	if(fileChooser.showSaveDialog(frame) != JFileChooser.APPROVE_OPTION) {
	        		 return null;
	     		}
	        	
	        	fileList.add(fileChooser.getSelectedFile());
	        	 
				return fileList;
	         }});
		
		ft.run();
		
		return ft;
	}


}
