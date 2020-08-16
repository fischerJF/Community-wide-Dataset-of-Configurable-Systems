package engine; 

import javax.sound.sampled.SourceDataLine; 
import javax.sound.sampled.DataLine; 
import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.LineUnavailableException; 
import javax.swing.SwingUtilities; 

import main.FeatureAmp; 

import engine.Header; 
import engine.UpdateTime; 

import java.io.FileInputStream; 
import java.io.BufferedInputStream; 

public  class  MP3Player  extends Thread  implements Runnable, PlayerInterface {
	
  public final static int STATUS_READY = 0;

	
  public final static int STATUS_PLAYING = 1;

	
  public final static int STATUS_PAUSED = 2;

	
  public final static int STATUS_FINISHED = 3;

	

  private Decoder decoder;

	
  private static SourceDataLine line;

	
  private BitStream bitstream;

	
  
  private long timeTot = 0;

	
  
  boolean first = true;

	

  private int playerStatus = STATUS_READY;

	
  
  private String file;

	
  
  private UpdateTime<MP3Player> updateThread;

	

  public MP3Player(String filename) {
		if (specifications.Configuration.mp3player) {
	    updateThread = new UpdateTime<MP3Player>(this);
	    file = filename;
	    updateThread.start();
	  		}
	}

	

  public void startOutput(AudioFormat playFormat)
      throws LineUnavailableException {
    DataLine.Info info = new DataLine.Info(SourceDataLine.class, playFormat);
    
    if (!AudioSystem.isLineSupported(info)) {
      throw new LineUnavailableException(
          "sorry, the sound format cannot be played");
    }

    line = (SourceDataLine) AudioSystem.getLine(info);
    line.open(playFormat);
    line.start();
  }

	

  public void stopOutput() {
    if (line != null) {
      line.drain();
      line.stop();
      line.close();
      line = null;
    }
  }

	

  public void run() {
    try {
      int length;
      Header header;
      boolean run = true;
      //Header header = bitstream.readFrame();
      //decoder = new Decoder(header, bitstream);
      while (run) {
        switch (playerStatus) {
          case STATUS_READY:
            if (bitstream != null) {
              stopOutput();
              bitstream.close();
            }
            bitstream = new BitStream(new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)), 2048));
            header = bitstream.readFrame();
            decoder = new Decoder(header, bitstream);
            first = true;
            timeTot = 0;
            synchronized (this) {
              wait();
            }
            break;
          case STATUS_PLAYING:
            if (bitstream == null) {
              bitstream = new BitStream(new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)), 2048));
              header = bitstream.readFrame();
              decoder = new Decoder(header, bitstream);
              first = true;
              timeTot = 0;
            }
            try {
              SampleBuffer output = (SampleBuffer) decoder.decodeFrame();
              length = output.size();
              if (length == 0) {
                if (FeatureAmp.getRepeatMode() == 1) {
                  if (bitstream != null) {
                    stopOutput();
                    bitstream.close();
                  }
                  bitstream = new BitStream(new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)), 2048));
                  header = bitstream.readFrame();
                  decoder = new Decoder(header, bitstream);
                  first = true;
                  timeTot = 0;
                } else {
                  SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                      FeatureAmp.getEndTrackObserv().update();
                    }
                  });
                  playerStatus = STATUS_READY;
                }
                break;
              }
              if (first) {
                first = false;
                //System.out.println("frequency: " + decoder.getOutputFrequency()
                //    + ", channels: " + decoder.getOutputChannels());
                startOutput(new AudioFormat(decoder.getOutputFrequency(), 16,
                    decoder.getOutputChannels(), true, false));
              }
              line.write(output.getBuffer(), 0, length);
              bitstream.closeFrame();
              header = bitstream.readFrame();
              timeTot += 1152000000000l/((long)header.frequency());
              break;
            } catch (Exception e) {
              e.printStackTrace();
              break;
            }
          case STATUS_PAUSED:
            synchronized (this) {
              wait();
            }
            break;
          case STATUS_FINISHED:
            stopOutput();
            bitstream.close();
            run = false;
            updateThread.interrupt();
            break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
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
