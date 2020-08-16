package main; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import javax.swing.JFileChooser; 
import javax.swing.SwingUtilities; 

public  class  OpenDirectory  implements ActionListener {
	
  private static OpenDirectory singleInstance = new OpenDirectory();

	
  
  public static OpenDirectory getInstance() {
    return singleInstance;
  }

	

  private OpenDirectory() {
		if (specifications.Configuration.loadfolder) {
	  		}
	}

	

  public void actionPerformed(ActionEvent e) {
    final JFileChooser fc = new JFileChooser();

    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    int returnVal = fc.showOpenDialog(null);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          Playlist.getInstance().addFolder(fc.getSelectedFile().getAbsolutePath());
        }
      });
    }
  }


}
