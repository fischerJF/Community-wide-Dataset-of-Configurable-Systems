package main; 

import main.Utils; 

public  class  Song {
	
  private String title;

	
  private String interpreter;

	
  private String album;

	
  private int trackNr;

	
  private long duration;

	
  private String filename;

	
  private String type;

	
  private boolean tagsEnabled;

	
  
  public Song(String filenameIn, boolean tagsEnabledIn, String titleIn, String interpreterIn, String albumIn, int trackNrIn, long durationIn, String typeIn) {
		if (specifications.Configuration.gui) {
	    title = titleIn;
	    album = albumIn;
	    interpreter = interpreterIn;
	    trackNr = trackNrIn;
	    duration = durationIn;
	    filename = filenameIn;
	    type = typeIn;
	    tagsEnabled = tagsEnabledIn;
	  		}
	}

	
 
  public String getFilename() {
    return filename;
  }

	
  
  public String getType() {
    return type;
  }

	
  
  public long getDuration() {
    return duration;
  }

	

  public int getTrackNr() {
    return trackNr;
  }

	
  
  public String toString() {
    if (tagsEnabled) {
      return trackNr + ". " + interpreter + " - " + album + " - " + title + " (" + Utils.timeToString(duration) + ")";
    } else {
      return filename + " (" + Utils.timeToString(duration) + ")";
    }
  }


}
