package main; 

import java.io.*; 

import javax.swing.JFileChooser; 
import javax.swing.filechooser.FileNameExtensionFilter; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import main.Playlist; 
import main.Song; 

import java.util.*; 

/**
 * The ActionListener that opens the file dialog
 * @author Arne Kreddig
 */
public  class  SavePlaylistListener  implements ActionListener {
	
  public SavePlaylistListener() {
		if (specifications.Configuration.saveandloadplaylist) {
	  		}
	}

	
  
  /**
   * The method for the action
   * @param e The event that was triggered
   */
  public void actionPerformed(ActionEvent e) {
    FileNameExtensionFilter m3uFilter = new FileNameExtensionFilter("M3U", "m3u");
    JFileChooser fc = new JFileChooser();
    
    fc.setFileFilter(m3uFilter);
    
    int returnVal = fc.showSaveDialog(null);
    
    // If a file has been selected successfully
    if(returnVal == JFileChooser.APPROVE_OPTION) {
      String filename = fc.getSelectedFile().getAbsolutePath();
      
      if (!filename.substring(filename.length()-4).toUpperCase().equals(".M3U")) {
        filename += ".m3u";
      }
      
      try {
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        
        ArrayList<Song> allSongs = Playlist.getInstance().getSongList();
        
        for (int i = 0; i < allSongs.size(); i++) {
          writer.println(allSongs.get(i).getFilename());
        }
        
        writer.close();
      } catch (FileNotFoundException ex) {
        System.out.println("Cannot open file!");
      } catch (UnsupportedEncodingException ex) {
        System.out.println("UTF-8 not supported!");
      }
    }
  }


}
