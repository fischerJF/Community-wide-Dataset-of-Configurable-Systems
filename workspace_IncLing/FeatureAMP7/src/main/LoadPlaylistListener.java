package main; 

import java.io.*; 

import javax.swing.JFileChooser; 
import javax.swing.filechooser.FileNameExtensionFilter; 

import javax.swing.*; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import main.OpenFile; 
import main.Playlist; 
import main.Song; 

/**
 * The ActionListener that opens the file dialog
 * @author Arne Kreddig
 */
public  class  LoadPlaylistListener  implements ActionListener {
	
  public LoadPlaylistListener() {
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
    
    int returnVal = fc.showOpenDialog(null);
    
    // If a file has been selected successfully
    if(returnVal == JFileChooser.APPROVE_OPTION) {
      String filename = fc.getSelectedFile().getAbsolutePath();
      
      try {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        Playlist.getInstance().getSongList().clear();
        
        String line = br.readLine();
        
        Song playSong = null;
  
        while (line != null) {
          if (!line.substring(0, 1).equals("#")) {
            File f = new File(line);
            if (f.exists() && f.isFile()) {
              Song newSong = OpenFile.getInstance().parseFile(line);
              if (newSong != null) {
                if (playSong == null) {
                  Playlist.getInstance().addSingleSong(newSong);
                  playSong = newSong;
                } else {
                  Playlist.getInstance().addSong(newSong);
                }
              }
            } else {
              System.out.println("Not a file: " + line);
            }
          }
          line = br.readLine();
        }
        
        br.close();
        
        if (playSong != null) {
          OpenFile.getInstance().createPlayer(playSong.getType(), playSong.getFilename(), false);
        }
      } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(new JFrame(), "Datei konnte nicht ge\u00f6ffnet werden!");
      } catch (IOException ex) {
        System.out.println("Error while reading file");
      }
    }
  }


}
