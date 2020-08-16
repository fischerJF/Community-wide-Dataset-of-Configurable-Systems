package featureAMP;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.Collection; 
import java.util.LinkedList; 

import javax.swing.Timer; 

public abstract  class  AbstractAudioController  implements AudioController {
	

	protected int currentSec;

	
	protected Timer timer;

	
	
	protected LinkedList<Listener<AudioController>> timeListeners;

	
	protected LinkedList<Listener<AudioController>> finishedListeners;

	
	protected LinkedList<Listener<AudioController>> playListeners;

	
	protected LinkedList<Listener<AudioController>> pauseListeners;

	
	protected LinkedList<Listener<AudioController>> resumeListeners;

	
	protected LinkedList<Listener<AudioController>> stopListeners;

	
	
	protected AbstractAudioController() {
		if (specifications.Configuration.base_featureamp) {
			
			this.timer = new Timer(1000, new TimerListener());
			
			this.timeListeners = new LinkedList<Listener<AudioController>>();
			this.finishedListeners = new LinkedList<Listener<AudioController>>();
			this.playListeners = new LinkedList<Listener<AudioController>>();
			this.pauseListeners = new LinkedList<Listener<AudioController>>();
			this.resumeListeners = new LinkedList<Listener<AudioController>>();
			this.stopListeners = new LinkedList<Listener<AudioController>>();
			
				}
	}

	
	
	@Override
	public int getCurrentSec() {
		return this.currentSec;
	}

	

	@Override
	public String getCurrentTime() {
		return "" + (this.currentSec / 60) 
				+ ":" 
				+ String.format("%02d", (this.currentSec % 60));
	}

	

	@Override
	public void addTimeListener(Listener<AudioController> l) {
		this.timeListeners.add(l);
	}

	

	@Override
	public boolean removeTimeListener(Listener<AudioController> l) {
		return this.timeListeners.remove(l);
	}

	

	@Override
	public Collection<Listener<AudioController>> getTimeListeners() {
		return this.timeListeners;
	}

	

	@Override
	public void addFinishedListener(Listener<AudioController> l) {
		this.finishedListeners.add(l);
	}

	

	@Override
	public boolean removeFinishedListener(Listener<AudioController> l) {
		return this.finishedListeners.remove(l);
	}

	

	@Override
	public Collection<Listener<AudioController>> getFinishedListeners() {
		return this.finishedListeners;
	}

	

	@Override
	public void addPlayListener(Listener<AudioController> l) {
		this.playListeners.add(l);
	}

	

	@Override
	public boolean removePlayListener(Listener<AudioController> l) {
		return this.playListeners.remove(l);
	}

	

	@Override
	public Collection<Listener<AudioController>> getPlayListeners() {
		return this.playListeners;
	}

	

	@Override
	public void addPauseListener(Listener<AudioController> l) {
		this.pauseListeners.add(l);
	}

	

	@Override
	public boolean removePauseListener(Listener<AudioController> l) {
		return this.pauseListeners.remove(l);
	}

	

	@Override
	public Collection<Listener<AudioController>> getPauseListeners() {
		return this.pauseListeners;
	}

	

	@Override
	public void addResumeListener(Listener<AudioController> l) {
		this.resumeListeners.add(l);
	}

	

	@Override
	public boolean removeResumeListener(Listener<AudioController> l) {
		return this.resumeListeners.remove(l);
	}

	

	@Override
	public Collection<Listener<AudioController>> getResumeListeners() {
		return this.resumeListeners;
	}

	

	@Override
	public void addStopListener(Listener<AudioController> l) {
		this.stopListeners.add(l);
	}

	

	@Override
	public boolean removeStopListener(Listener<AudioController> l) {
		return this.stopListeners.remove(l);
	}

	

	@Override
	public Collection<Listener<AudioController>> getStopListeners() {
		return this.stopListeners;
	}

	
	
	protected void notifyTimeListeners() {
		for (Listener<AudioController> l: this.timeListeners) {
			l.update(this);
		}
	}

	
	
	protected void notifyFinishedListeners() {
		for (Listener<AudioController> l: this.finishedListeners) {
			l.update(this);
		}
	}

	
	
	protected void notifyPlayListeners() {
		for (Listener<AudioController> l: this.playListeners) {
			l.update(this);
		}
	}

	
	
	protected void notifyPauseListeners() {
		for (Listener<AudioController> l: this.pauseListeners) {
			l.update(this);
		}
	}

	
	
	protected void notifyResumeListeners() {
		for (Listener<AudioController> l: this.resumeListeners) {
			l.update(this);
		}
	}

	
	
	protected void notifyStopListeners() {
		for (Listener<AudioController> l: this.stopListeners) {
			l.update(this);
		}
	}

	
	
	 
	
	class  TimerListener  implements ActionListener {
		
		
		private boolean finished = false;

		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			AbstractAudioController.this.currentSec++;
			if (!this.finished)
				AbstractAudioController.this.notifyTimeListeners();
			
			// Track vorbei?
			if (AbstractAudioController.this.currentSec
					>= AbstractAudioController.this.getAudioFile().getTotalSec()) {
				if (!this.finished) {
					AbstractAudioController.this.stop();
					AbstractAudioController.this.notifyFinishedListeners();
				}
				this.finished = true;
			}
			else
				this.finished = false;
			
		}


	}


}
