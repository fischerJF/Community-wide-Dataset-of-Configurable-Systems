package players; 

import javax.swing.filechooser.FileFilter; 

public abstract  class  PlayerFileFilter  extends FileFilter {
	
	public abstract Class<? extends Player> getParentClass();


}
