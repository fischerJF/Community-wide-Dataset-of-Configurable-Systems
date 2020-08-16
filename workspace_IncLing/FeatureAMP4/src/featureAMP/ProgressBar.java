package featureAMP;
import javax.swing.JProgressBar; 

public  class  ProgressBar {
	

	private FeatureAmp featureAmp;

	
	
	private JProgressBar progressBar;

	
	
	public ProgressBar(FeatureAmp featureAmp) {
		if (specifications.Configuration.progress_bar) {
			
			this.featureAmp = featureAmp;
			this.featureAmp.addAudioListener(new AudioListener());
			
			this.progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 1);
			this.progressBar.setName("progress");
				}
	}

	
	
	public JProgressBar getProgressBar() {
		return this.progressBar;
	}

	
	
	 
	
	class  AudioListener  implements Listener<FeatureAmp> {
		

		@Override
		public void update(FeatureAmp object) {
			if (object.getAudioController() != null)
				object.getAudioController().addTimeListener(new TimeListener());
		}


	}

	
	
	 
	
	class  TimeListener  implements Listener<AudioController> {
		

		@Override
		public void update(AudioController object) {
			int current = object.getCurrentSec();
			int max = object.getAudioFile().getTotalSec();
			ProgressBar.this.progressBar.setValue(current);
			ProgressBar.this.progressBar.setMaximum(max);
		}


	}


}
