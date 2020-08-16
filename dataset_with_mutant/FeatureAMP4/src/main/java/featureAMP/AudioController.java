package featureAMP;
import java.util.Collection; 

public  interface  AudioController {
	
	
	public final static int STATUS_READY = 0;

	
	public final static int STATUS_PLAYING = 1;

	
	public final static int STATUS_PAUSED = 2;

	

	public AudioFile getAudioFile();

	

	public int getCurrentSec();

	

	public String getCurrentTime();

	
	
	public int getStatus();

	

	public void play();

	

	public void pause();

	

	public void resume();

	

	public void stop();

	
	
	public void setVolume(int percent);

	

	public void addTimeListener(Listener<AudioController> l);

	

	public boolean removeTimeListener(Listener<AudioController> l);

	
	
	public Collection<Listener<AudioController>> getTimeListeners();

	
	
	public void addFinishedListener(Listener<AudioController> l);

	

	public boolean removeFinishedListener(Listener<AudioController> l);

	
	
	public Collection<Listener<AudioController>> getFinishedListeners();

	
	
	public void addPlayListener(Listener<AudioController> l);

	

	public boolean removePlayListener(Listener<AudioController> l);

	
	
	public Collection<Listener<AudioController>> getPlayListeners();

	
	
	public void addPauseListener(Listener<AudioController> l);

	

	public boolean removePauseListener(Listener<AudioController> l);

	
	
	public Collection<Listener<AudioController>> getPauseListeners();

	
	
	public void addResumeListener(Listener<AudioController> l);

	

	public boolean removeResumeListener(Listener<AudioController> l);

	
	
	public Collection<Listener<AudioController>> getResumeListeners();

	
	
	public void addStopListener(Listener<AudioController> l);

	

	public boolean removeStopListener(Listener<AudioController> l);

	
	
	public Collection<Listener<AudioController>> getStopListeners();


}
