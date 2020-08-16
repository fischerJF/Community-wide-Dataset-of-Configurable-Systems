package main; 

import java.awt.image.BufferedImage; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.File; 

import javax.swing.JFileChooser; 

import engine.PlayerInterface; 
import javax.swing.filechooser.FileNameExtensionFilter; 

import javax.swing.filechooser.FileFilter; 

import com.mpatric.mp3agic.InvalidDataException; 
import com.mpatric.mp3agic.Mp3File; 
import com.mpatric.mp3agic.UnsupportedTagException; 
import com.mpatric.mp3agic.ID3v1; 
import com.mpatric.mp3agic.ID3v2; 

import main.FeatureAmp; 
import main.OpenFile; 

import engine.MP3Player; 

import java.io.IOException; 

import java.io.ByteArrayInputStream; 
import java.io.InputStream; 
import javax.imageio.ImageIO; 

import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 

import engine.WAVPlayer; 

/**
 * This file implements special file open and create player functions for the
 * MP3 player
 * 
 * @author Arne Kreddig
 */
public   class  OpenFile  implements ActionListener {
	
  private static OpenFile currentInstance = new OpenFile();

	
  
  // The last path that was open in the file dialog
  File lastPath;

	
  
  private String artist;

	
  private String title;

	
  private String album;

	
  private long duration;

	
  private int trackNr;

	
  private BufferedImage cover;

	
  private String type;

	
  private boolean newFile = false;

	
  private String filepath;

	
  private boolean tagsEnabled;

	
  
  // The actual Player thread
  static PlayerInterface actualPlayer;

	

  /**
   * Add the MP3 file filter to the filter menu
   */
  private OpenFile  () {
		if (specifications.Configuration.openfile) {
	    lastPath = null;
	  		}
	
		if (specifications.Configuration.openmp3file) {
	    mp3Fc = new FileNameExtensionFilter("MP3", "mp3");
	  		}
	
		if (specifications.Configuration.openwavfile) {
	    wavFc = new FileNameExtensionFilter("WAV", "wav");
	  		}
	}

	
  
  public static OpenFile getInstance() {
    return currentInstance;
  }

	

  /**
   * The method for the action
   * @param e The event that was triggered
   */
  public void actionPerformed(ActionEvent e) {
    final JFileChooser fc = new JFileChooser();
    
    if (lastPath != null) {
      fc.setCurrentDirectory(lastPath);
    }
    
    setFileExtensionFilter(fc);
    
    int returnVal = fc.showOpenDialog(null);
    
    // If a file has been selected successfully
    if(returnVal == JFileChooser.APPROVE_OPTION) {
      lastPath = fc.getSelectedFile().getParentFile();
      createPlayer(fc.getFileFilter().getDescription(), fc.getSelectedFile().getAbsolutePath(), true);
    }
  }

	
  
  /**
   * The prototype for the feature IDE that creates the backend for the player
   * @param type The file filter that was selected with the current file
   * @param filename The filename of the sound file
   */
   private void  createPlayer__wrappee__OpenFile  (String type, String filename, boolean newFile) {
  }

	

  /**
   * Create the MP3 player if the file type is MP3
   * 
   * @param type
   *          The file filter that was used for this file
   * @param filename
   *          The name of the selected file
   */
   private void  createPlayer__wrappee__OpenMP3File  (String typeIn, String filename, boolean newFileIn) {
		if (!specifications.Configuration.openmp3file) {
			createPlayer__wrappee__OpenFile(typeIn, filename, newFileIn);
			return;
		}
    // Was the MP3 file filter used?
    if (typeIn.equals("MP3")) { // Yes: This is a MP3 file
      filepath = filename;
      newFile = newFileIn;
      type = typeIn;
      if (newFile == false || FeatureAmp.getList() == null || FeatureAmp.getList().size() == 0) {
        // Create the player
        try {
          if (actualPlayer != null) {
            actualPlayer.cmdClose();
          }
          actualPlayer = new MP3Player(filename);
          ((MP3Player)actualPlayer).start();
          FeatureAmp.setPlayer(actualPlayer);
          actualPlayer.cmdPlay();
        } catch (Exception ex) {
          ex.printStackTrace();
        }

        // Create an ActionListener for the start button
        ActionListener startListener = new ActionListener() {
          // When the start button is clicked
          public void actionPerformed(ActionEvent e) {
            switch (actualPlayer.getPlayerStatus()) {
              case MP3Player.STATUS_READY:
              case MP3Player.STATUS_FINISHED:
                actualPlayer.cmdPlay();
                break;
              case MP3Player.STATUS_PAUSED:
                actualPlayer.cmdResume();
                break;
            }
          }
        };

        // Create an ActionListener for the stop button
        ActionListener stopListener = new ActionListener() {
          // If stop is clicked
          public void actionPerformed(ActionEvent e) {
            switch (actualPlayer.getPlayerStatus()) {
              case MP3Player.STATUS_PLAYING:
              case MP3Player.STATUS_PAUSED:
                actualPlayer.cmdStop();
                break;
            }
          }
        };

        // Create an ActionListener for the pause button
        ActionListener pauseListener = new ActionListener() {
          // When the pause button is clicked
          public void actionPerformed(ActionEvent e) {
            switch (actualPlayer.getPlayerStatus()) {
              case MP3Player.STATUS_PAUSED:
                actualPlayer.cmdResume();
                break;
              case MP3Player.STATUS_PLAYING:
                actualPlayer.cmdPause();
                break;
            }
          }
        };

        // Update the ActionListeners of the buttons
        Buttons.getInstance().setStartButtonActionListener(startListener);
        Buttons.getInstance().setStopButtonActionListener(stopListener);
        Buttons.getInstance().setPauseButtonActionListener(pauseListener);

        // Try to open the MP3 file to read the ID3 tag
        Mp3File mp3file = null;
        try {
          mp3file = new Mp3File(filename);
        } catch (IOException e) {
          e.printStackTrace();
        } catch (UnsupportedTagException e) {
          e.printStackTrace();
        } catch (InvalidDataException e) {
          e.printStackTrace();
        }
  
        // If the MP3 file could not be opened, use some default values in the
        // title
        if (mp3file == null) {
          FeatureAmp.getNewInfoObserv().update();
          FeatureAmp.getNewTimeObserv().update();
        } else {
          artist = null;
          title = null;
          album = null;
          trackNr = 0;
          cover = null;
          byte[] coverIn = null;
  
          if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3file.getId3v2Tag();
            tagsEnabled = true;
            artist = id3v2Tag.getArtist();
            title = id3v2Tag.getTitle();
            album = id3v2Tag.getAlbum();
            trackNr = parseMP3TrackNr(id3v2Tag.getTrack());
            String coverMime = id3v2Tag.getAlbumImageMimeType();
            if (coverMime != null) {
              coverIn = id3v2Tag.getAlbumImage();
            }
          } else if (mp3file.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
            tagsEnabled = true;
            artist = id3v1Tag.getArtist();
            title = id3v1Tag.getTitle();
            album = id3v1Tag.getAlbum();
            trackNr = parseMP3TrackNr(id3v1Tag.getTrack());
          } else {
            tagsEnabled = false;
            artist = "Unbekannter Interpret";
            title = "Unbekannter Titel";
            album = "Unbekanntes Album";
            trackNr = 0;
          }
  
          if (coverIn != null) {
            InputStream coverStream = new ByteArrayInputStream(coverIn);
            try {
              cover = ImageIO.read(coverStream);
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
          duration = mp3file.getLengthInSeconds();
          FeatureAmp.getNewInfoObserv().update();
          FeatureAmp.getNewTimeObserv().update();
        }
      
      } else {
        FeatureAmp.getNewSongObserv().update();
      }

    } else { // Not an MP3 file -> continue with next file type
      createPlayer__wrappee__OpenFile(typeIn, filename, newFileIn);
    }
  }

	

  /**
   * Create the MP3 player if the file type is MP3
   * 
   * @param type
   *          The file filter that was used for this file
   * @param filename
   *          The name of the selected file
   */
  public void createPlayer(String typeIn, String filename, boolean newFileIn) {
		if (!specifications.Configuration.openwavfile) {
			createPlayer__wrappee__OpenMP3File(typeIn, filename, newFileIn);
			return;
		}
    // Was the WAV file filter used?
    if (typeIn.equals("WAV")) { // Yes: This is a WAV file
      filepath = filename;
      newFile = newFileIn;
      type = typeIn;
      if (newFile == false || FeatureAmp.getList() == null || FeatureAmp.getList().size() == 0) {
        // Create the player
        try {
          if (actualPlayer != null) {
            actualPlayer.cmdClose();
          }
          actualPlayer = new WAVPlayer(filename);
          ((WAVPlayer)actualPlayer).start();
          FeatureAmp.setPlayer(actualPlayer);
        } catch (Exception ex) {
          ex.printStackTrace();
        }

        // Create an ActionListener for the start button
        ActionListener startListener = new ActionListener() {
          // When the start button is clicked
          public void actionPerformed(ActionEvent e) {
            switch (actualPlayer.getPlayerStatus()) {
              case WAVPlayer.STATUS_READY:
              case WAVPlayer.STATUS_FINISHED:
                actualPlayer.cmdPlay();
                break;
              case WAVPlayer.STATUS_PAUSED:
                actualPlayer.cmdResume();
                break;
            }
          }
        };

        // Create an ActionListener for the stop button
        ActionListener stopListener = new ActionListener() {
          // If stop is clicked
          public void actionPerformed(ActionEvent e) {
            switch (actualPlayer.getPlayerStatus()) {
              case WAVPlayer.STATUS_PLAYING:
              case WAVPlayer.STATUS_PAUSED:
                actualPlayer.cmdStop();
                break;
            }
          }
        };

        // Create an ActionListener for the pause button
        ActionListener pauseListener = new ActionListener() {
          // When the pause button is clicked
          public void actionPerformed(ActionEvent e) {
            switch (actualPlayer.getPlayerStatus()) {
              case WAVPlayer.STATUS_PAUSED:
                actualPlayer.cmdResume();
                break;
              case WAVPlayer.STATUS_PLAYING:
                actualPlayer.cmdPause();
                break;
            }
          }
        };

        // Update the ActionListeners of the buttons
        Buttons.getInstance().setStartButtonActionListener(startListener);
        Buttons.getInstance().setStopButtonActionListener(stopListener);
        Buttons.getInstance().setPauseButtonActionListener(pauseListener);
  
        tagsEnabled = false;
        artist = "Unbekannter Interpret";
        title = "Unbekannter Titel";
        album = "Unbekanntes Album";
        trackNr = 0;
        cover = null;
        try {
          File file = new File(filename);
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
          AudioFormat format = audioInputStream.getFormat();
          long frames = audioInputStream.getFrameLength();
          duration = (long)((frames+0.0) / format.getFrameRate());
        } catch (Exception e) {
          System.out.println("Unable to get song duration!");
          duration = 0;
        }
      
        FeatureAmp.getNewInfoObserv().update();
        FeatureAmp.getNewTimeObserv().update();
      } else {
        FeatureAmp.getNewSongObserv().update();
      }

    } else { // Not an WAV file -> continue with next file type
      createPlayer__wrappee__OpenMP3File(typeIn, filename, newFileIn);
    }
  }

	
  
   private Song  parseFile__wrappee__OpenFile  (String file) {
    return null;
  }

	

   private Song  parseFile__wrappee__OpenMP3File  (String file) {
		if (!specifications.Configuration.openmp3file)
			return parseFile__wrappee__OpenFile(file);
    // if (checkCont.toString().substring(0, 7).toUpperCase().equals("SPEAKER"))
    // {
    if (file.substring(file.length() - 3).toUpperCase().equals("MP3")) {
      Song newSong;

      // Try to open the MP3 file to read the ID3 tag
      Mp3File mp3file = null;
      try {
        mp3file = new Mp3File(file);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (UnsupportedTagException e) {
        e.printStackTrace();
      } catch (InvalidDataException e) {
        e.printStackTrace();
      }

      if (mp3file == null) {
        newSong = new Song(file, false, "Unbekannter Interpret", "Unbekannter Titel",
            "Unbekanntes Album", 0, 0, "MP3");
      } else {
        if (mp3file.hasId3v2Tag()) {
          ID3v2 id3v2Tag = mp3file.getId3v2Tag();
          newSong = new Song(file, true, id3v2Tag.getArtist(), id3v2Tag.getTitle(),
              id3v2Tag.getAlbum(), parseMP3TrackNr(id3v2Tag.getTrack()),
              mp3file.getLengthInSeconds(), "MP3");
        } else if (mp3file.hasId3v1Tag()) {
          ID3v1 id3v1Tag = mp3file.getId3v1Tag();
          newSong = new Song(file, true, id3v1Tag.getArtist(), id3v1Tag.getTitle(),
              id3v1Tag.getAlbum(), parseMP3TrackNr(id3v1Tag.getTrack()),
              mp3file.getLengthInSeconds(), "MP3");
        } else {
          newSong = new Song(file, false, "Unbekannter Interpret",
              "Unbekannter Titel", "Unbekanntes Album", 0,
              mp3file.getLengthInSeconds(), "MP3");
        }
      }

      return newSong;

    } else {
      return parseFile__wrappee__OpenFile(file);
    }
  }

	

  public Song parseFile(String file) {
		if (!specifications.Configuration.openwavfile)
			return parseFile__wrappee__OpenMP3File(file);
    if (file.substring(file.length() - 3).toUpperCase().equals("WAV")) {
      long duration;
      try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file));
        AudioFormat format = audioInputStream.getFormat();
        long frames = audioInputStream.getFrameLength();
        duration = (long)((frames+0.0) / format.getFrameRate());
      } catch (Exception e) {
        System.out.println("Unable to get song duration!");
        duration = 0;
      }
      return new Song(file, false, "Unbekannter Interpret", "Unbekannter Titel", "Unbekanntes Album", 0, duration, "WAV");
    } else {
      return parseFile__wrappee__OpenMP3File(file);
    }
  }

	
  
  /**
   * Sets all file types that are allowed in the file dialog
   * This function gets extended by other features
   * @param fc The file chooser that gets extended by the methods of the features
   */
   private void  setFileExtensionFilter__wrappee__OpenFile  (JFileChooser fc) {
    fc.setAcceptAllFileFilterUsed(false);
  }

	

  /**
   * Add the file filter for MP3 files to the file chooser
   * 
   * @param fc
   *          The file chooser
   */
   private void  setFileExtensionFilter__wrappee__OpenMP3File  (JFileChooser fc) {
		if (!specifications.Configuration.openmp3file) {
			setFileExtensionFilter__wrappee__OpenFile(fc);
			return;
		}
    setFileExtensionFilter__wrappee__OpenFile(fc);
    fc.setFileFilter(mp3Fc);
  }

	

  /**
   * Add the file filter for WAV files to the file chooser
   * 
   * @param fc
   *          The file chooser
   */
  public void setFileExtensionFilter(JFileChooser fc) {
		if (!specifications.Configuration.openwavfile) {
			setFileExtensionFilter__wrappee__OpenMP3File(fc);
			return;
		}
    setFileExtensionFilter__wrappee__OpenMP3File(fc);
    fc.setFileFilter(wavFc);
  }

	
  
  public String getArtist() {
    return artist;
  }

	
  
  public String getTitle() {
    return title;
  }

	
  
  public String getAlbum() {
    return album;
  }

	
  
  public long getDuration() {
    return duration;
  }

	
  
  public int getTrackNr() {
    return trackNr;
  }

	
  
  public boolean getNewFile() {
    return newFile;
  }

	
  
  public BufferedImage getCover() {
    return cover;
  }

	
  
  public String getType() {
    return type;
  }

	
  
  public boolean getTagsEnabled() {
    return tagsEnabled;
  }

	
  
  public String getFilename() {
    return filepath;
  }

	
  // The file filter for MP3s
  FileFilter mp3Fc;

	

  private int parseMP3TrackNr(String trackStr) {
    if (trackStr == null) {
      return 0;
    } else {
      int numEnd;
      for (numEnd = 0; numEnd < trackStr.length(); numEnd++) {
        // If we find a non-digit character we return false.
        if (!Character.isDigit(trackStr.charAt(numEnd))) {
          break;
        }
      }
      return Integer.parseInt(trackStr.substring(0, numEnd));
    }
  }

	
  // The file filter for MP3s
  FileFilter wavFc;


}
