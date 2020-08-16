package featureAMP;
import javax.swing.JFrame; 

 

class  TitleListener  implements Listener<FeatureAmp> {
	
		
	public void update(FeatureAmp object) {
		JFrame frame = object.getFrame();
		if (object.getAudioController() != null) {
			String artist = object.getAudioController().getAudioFile().getArtist();
			String title = object.getAudioController().getAudioFile().getTitle();
			frame.setTitle(artist + " - " + title);
		}
		else 
			frame.setTitle(FeatureAmp.TITLE);
	}


}
