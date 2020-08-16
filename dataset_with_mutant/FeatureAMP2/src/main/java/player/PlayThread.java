package player; 
import javax.sound.sampled.Clip; 
import javax.swing.JProgressBar; 

public  class  PlayThread  extends Thread {
	

	private JProgressBar progress;

	
	private Clip clip;

	
	private boolean running;

	

	public PlayThread(JProgressBar bar, Clip c) {
		if (specifications.Configuration.gui) {
			clip = c;
				progress = bar;
				progress.setMinimum(0);
				progress.setMaximum((int) (clip.getMicrosecondLength() / 1000));
				progress.setValue(0);
				progress.setString("0:00");
			
			running = true;
				}
	}

	
	
	public void stopPressed() {
		running = false;
	}

	

	public void run() {
		while (running) {
			try {
				long currentPosition = clip.getMicrosecondPosition() / 1000; // miliseconds
					progress.setValue((int) currentPosition);
					progress.setString(getTimer());
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
	}

	
	
	private String getTimer() {
		long currentPosition = clip.getMicrosecondPosition() / 1000 / 1000; // seconds
		return (currentPosition / 60) + ":"
				+ ((currentPosition % 60) < 10 ? "0" : "")
				+ (currentPosition % 60);
	}


}
