package featureamp; 

import featureamp.gui.MainWindow; 
import featureamp.playback.TrackFactory;
import specifications.Configuration;

import java.awt.Color; 

import javax.swing.JLabel; 

/**
 * TODO description
 */
public   class  FeatureAMP {
	

	public static final int COVER_SIZE = 200;

	

	public static void main(String[] args) {
		// Base
//		Configuration.skiptrack=true;
//		Configuration.metadata=true;
//		Configuration.removetrack=true;
//		Configuration.album=true;
//		Configuration.wav=true;
//		Configuration.nicetohave=true;
//		Configuration.playlist=true;
//		Configuration.jumpposition=true;
//		Configuration.light=true;
//		Configuration.openfolder=true;
//		Configuration.gui=true;
//		Configuration.featureamp=true;
//		Configuration.queuetrack=true;
//		Configuration.mute=true;
//		Configuration.tageditor=true;
//		Configuration.tracknumber=true;
//		Configuration.codecs=true;
//		Configuration.progress=true;
//		Configuration.aac=true;
//		Configuration.playlistcontrols=true;
//		Configuration.multipleplaylists=true;
//		Configuration.randomcolor=true;
//		Configuration.saveandload=true;
//		Configuration.shufflerepeat=true;
//		Configuration.base=true;
//		Configuration.ogg=true;
//		Configuration.youtube=true;
//		Configuration.mp3=true;
//		Configuration.oscolors=true;
//		Configuration.reorder=true;
//		Configuration.cover=true;
//		Configuration.volume=true;
//		Configuration.skins=true;
//		Configuration.dark=true;
//		Configuration.clearplaylist=true;
//		Configuration.remeberstatus=true;
//		Configuration.progressbar=true;
//		Configuration.titlebar=true;

		Configuration.featureamp=true;
		Configuration.base=true;
		Configuration.codecs=true;
		Configuration.mp3=true;
		Configuration.skins=true;
		Configuration.dark=true;
		Configuration.progressbar=true;
		Configuration.mute=true;
		Configuration.gui=true;
		Configuration.playlist=true;
		Configuration.playlistcontrols=true;
		Configuration.removetrack=true;
		Configuration.clearplaylist=true;
		
		TrackFactory.setup();

		new MainWindow();
	}

	

	public static final Color BG = new Color((int) (Math.random() * 255),
			(int) (Math.random() * 255), (int) (Math.random() * 255));

	
	public static  Color BG2; //  = specifications.Configuration.randomcolor ?  brighter(BG) ? BG.brighter() : BG.darker() :  specifications.Configuration.oscolors ?  label.getBackground().darker() :  specifications.Configuration.dark ?  Color.BLACK :  Color.WHITE;

	
	public static  Color FG;  //= specifications.Configuration.randomcolor ?  brighter(BG) ? Color.BLACK : Color.WHITE :  specifications.Configuration.oscolors ?  label.getForeground() :  specifications.Configuration.dark ?  Color.LIGHT_GRAY :  Color.DARK_GRAY;

	FeatureAMP(){
		BG2  = specifications.Configuration.randomcolor ?  brighter(BG) ? BG.brighter() : BG.darker() :  specifications.Configuration.oscolors ?  label.getBackground().darker() :  specifications.Configuration.dark ?  Color.BLACK :  Color.WHITE;
		FG  = specifications.Configuration.randomcolor ?  brighter(BG) ? Color.BLACK : Color.WHITE :  specifications.Configuration.oscolors ?  label.getForeground() :  specifications.Configuration.dark ?  Color.LIGHT_GRAY :  Color.DARK_GRAY;

	}
	

	public static  JLabel label = new JLabel();
	
	

	private static boolean brighter(Color c) {
		int i = c.getRed();
		i = c.getGreen() > i ? c.getGreen() : i;
		i = c.getBlue() > i ? c.getBlue() : i;
		return i > 191;
	}


}
