package engine; 

import java.io.File; 
import java.io.IOException; 
import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.DataLine; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.SourceDataLine; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import javax.swing.SwingUtilities; 

import main.FeatureAmp; 

import engine.UpdateTime; 

public  class  WAVPlayer  extends Thread  implements Runnable, PlayerInterface {
	
  public final static int STATUS_INIT = 0;

	
  public final static int STATUS_READY = 1;

	
  public final static int STATUS_PLAYING = 2;

	
  public final static int STATUS_PAUSED = 3;

	
  public final static int STATUS_FINISHED = 4;

	

  private String filename;

	
  private final int EXTERNAL_BUFFER_SIZE = 128;

	 //524288; // 128Kb
  private int playerStatus = STATUS_INIT;

	
  private boolean firstStart = true;

	
  private long timeTot = 0;

	
  
  private UpdateTime<WAVPlayer> updateThread;

	

  public WAVPlayer(String wavfile) {
		if (specifications.Configuration.wavplayer) {
	    filename = wavfile;
	    updateThread = new UpdateTime<WAVPlayer>(this);
	    updateThread.start();
	  		}
	}

	

  public void run() {
    int nBytesRead = 0;
    byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
    SourceDataLine auline = null;
    AudioInputStream audioInputStream = null;
    AudioFormat format = null;

    try {
      playerStatus = STATUS_INIT;
      while (true) {
        if (nBytesRead == -1) {
          playerStatus = STATUS_READY;
        }
        if (playerStatus == STATUS_READY || playerStatus == STATUS_INIT) {
          if (!firstStart) {
            auline.drain();
            auline.close();
          }
          File soundFile = new File(filename);
          if (!soundFile.exists()) {
            System.err.println("Wave file not found: " + filename);
            return;
          }

          try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
          } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
            return;
          } catch (IOException e1) {
            e1.printStackTrace();
            return;
          }

          format = audioInputStream.getFormat();
          DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

          try {
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
          } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
          } catch (Exception e) {
            e.printStackTrace();
            return;
          }

          auline.start();
          timeTot = 0;
          firstStart = false;
          if (playerStatus == STATUS_INIT) {
            playerStatus = STATUS_PLAYING;
          } else {
            playerStatus = STATUS_READY;
            synchronized (this) {
              wait();
            }
          }
        }

        if (playerStatus == STATUS_PAUSED) {
          synchronized (this) {
            wait();
          }
        }
        if(playerStatus == STATUS_FINISHED) {
          break;
        }
        nBytesRead = audioInputStream.read(abData, 0, abData.length);
        if (nBytesRead >= 0) {
          double sampleSize = ((double)format.getSampleSizeInBits())*((double)format.getChannels());
          double samplesProcessed = ( ((double)nBytesRead) * 8.0 )  /  sampleSize;
          double timeNsProcessed = ( ((double)samplesProcessed) * 1000000000.0 )   /   ((double)format.getSampleRate());
          timeTot += (long)timeNsProcessed;
          auline.write(abData, 0, nBytesRead);
        } else {
          SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              FeatureAmp.getEndTrackObserv().update();
            }
          });
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      return;
    } catch (InterruptedException e) {
      System.out.println("WAV-Player interrupted");
    } finally {
      updateThread.interrupt();
      auline.drain();
      auline.close();
    }

  }

	
  
  public void cmdPlay() {
    playerStatus = STATUS_PLAYING;
    synchronized (this) {
      notify();
    }
  }

	

  public void cmdPause() {
    playerStatus = STATUS_PAUSED;
  }

	

  public void cmdResume() {
    playerStatus = STATUS_PLAYING;
    synchronized (this) {
      notify();
    }
  }

	

  public void cmdStop() {
    boolean needNotify = false;
    
    if (playerStatus == STATUS_PAUSED) {
      needNotify = true;
    }
    
    playerStatus = STATUS_READY;
    
    if (needNotify) {
      synchronized (this) {
        notify();
      }
    }
  }

	
  
  public int getPlayerStatus() {
    return playerStatus;
  }

	

  public void cmdClose() {
    if (playerStatus != STATUS_FINISHED) {
      while (isAlive()) {
        playerStatus = STATUS_FINISHED;
        if (playerStatus != STATUS_PLAYING) {
          synchronized (this) {
            notify();
          }
        }
      }
    }
  }

	

  public long getPlayerPosition() {
    return timeTot/1000000;
  }


}
