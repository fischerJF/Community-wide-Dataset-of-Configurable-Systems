package featureAMP;
import javax.swing.JFrame; 

public  class  TitleTimeListener  implements Listener<FeatureAmp> {
	
	
	private FeatureAmp featureAmp;

	

	@Override
	public void update(FeatureAmp object) {
		this.featureAmp = object;
		if (this.featureAmp.getAudioController() != null)
			this.featureAmp.getAudioController().addTimeListener(new TimeListener());
	}

	

	 

	class  TimeListener  implements Listener<AudioController> {
		

		@Override
		public void update(AudioController object) {
			JFrame frame = TitleTimeListener.this.featureAmp.getFrame();
			String currentTime = object.getCurrentTime();
			String totalTime = object.getAudioFile().getTotalTime();
			String artist = object.getAudioFile().getArtist();
			String title = object.getAudioFile().getTitle();
			frame.setTitle("[" + currentTime + "/" + totalTime + "] "
					+ artist + " - " + title);
		}


	}


}
