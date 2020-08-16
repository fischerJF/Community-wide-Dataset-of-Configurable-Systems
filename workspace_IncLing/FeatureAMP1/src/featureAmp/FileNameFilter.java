package featureAmp; 

import java.io.File; 
import java.io.FilenameFilter; 


public   class  FileNameFilter  implements FilenameFilter {
	

	
	 private boolean  accept__wrappee__Base(File dir, String name) {
		return name.endsWith(".mp3");
	}

	
	@Override
	public boolean accept(File file, String name){
		if (!specifications.Configuration.wav)
			return accept__wrappee__Base(file, name);
		return accept__wrappee__Base(file, name) || name.endsWith(".wav");
	}


}
