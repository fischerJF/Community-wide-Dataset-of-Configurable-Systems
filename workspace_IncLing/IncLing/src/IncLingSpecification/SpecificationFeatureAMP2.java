package IncLingSpecification;

import IncLingSpecification.Specification;
import guidsl.SATtest;
import guidsl.Tool;

public class SpecificationFeatureAMP2  extends Specification{
	public static boolean featureamp =true;
	public static boolean gui=true;
	public static boolean player=true;
	public static boolean skiptrack=false;
	public static boolean volumecontrol=false;
	public static boolean lightskin=false;
	public static boolean removetrack=false;
	public static boolean time=false;
	public static boolean reorderplaylist=false;
	public static boolean playlist=false;
	public static boolean darkskin=false;
	public static boolean saveandloadplaylist=false;
	public static boolean queuetrack=false;
	public static boolean progressbar=false;
	public static boolean mute=false;
	public static boolean showtime=false;
	public static boolean controlplayist=false;
	public static boolean showcover=false;
	public static boolean loadfolder=false;
	public static boolean shufflerepeat=false;
	public static boolean ogg=false;
	public static boolean mp3=false;
	public static boolean skins=false;
	public static boolean clearplaylist=false;
	  
	private static SpecificationFeatureAMP2 SINGLETON;
    
	public static SpecificationFeatureAMP2 getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationFeatureAMP2();
		}
		tool=t;
		return SINGLETON;
	}
	
	public static boolean runTest( SATtest t, boolean compat ) {
	    return (tool.modelDebug(t, makeCnfFile ))? true: false;
	  }

	

	public static String setfeatureamp() {
		return (featureamp) ? "FEATUREAMP___" : "-FEATUREAMP___";
	}

	public static String setgui() {
		return (gui) ? "GUI___" : "-GUI___";
	}

	public static String setplayer() {
		return (player) ? "PLAYER___" : "-PLAYER___";
	}

	public static String setskiptrack() {
		return (skiptrack) ? "SKIPTRACK___" : "-SKIPTRACK___";
	}

	public static String setvolumecontrol() {
		return (volumecontrol) ? "VOLUMECONTROL___" : "-VOLUMECONTROL___";
	}

	public static String setlightskin() {
		return (lightskin) ? "LIGHTSKIN___" : "-LIGHTSKIN___";
	}

	public static String setremovetrack() {
		return (removetrack) ? "REMOVETRACK___" : "-REMOVETRACK___";
	}

	public static String settime() {
		return (time) ? "TIME___" : "-TIME___";
	}

	public static String setreorderplaylist() {
		return (reorderplaylist) ? "REORDERPLAYLIST___" : "-REORDERPLAYLIST___";
	}

	public static String setplaylist() {
		return (playlist) ? "PLAYLIST___" : "-PLAYLIST___";
	}

	public static String setdarkskin() {
		return (darkskin) ? "DARKSKIN___" : "-DARKSKIN___";
	}

	public static String setsaveandloadplaylist() {
		return (saveandloadplaylist) ? "SAVEANDLOADPLAYLIST___" : "-SAVEANDLOADPLAYLIST___";
	}

	public static String setqueuetrack() {
		return (queuetrack) ? "QUEUETRACK___" : "-QUEUETRACK___";
	}

	public static String setprogressbar() {
		return (progressbar) ? "PROGRESSBAR___" : "-PROGRESSBAR___";
	}

	public static String setmute() {
		return (mute) ? "MUTE___" : "-MUTE___";
	}

	public static String setshowtime() {
		return (showtime) ? "SHOWTIME___" : "-SHOWTIME___";
	}

	public static String setcontrolplayist() {
		return (controlplayist) ? "CONTROLPLAYIST___" : "-CONTROLPLAYIST___";
	}

	public static String setshowcover() {
		return (showcover) ? "SHOWCOVER___" : "-SHOWCOVER___";
	}

	public static String setloadfolder() {
		return (loadfolder) ? "LOADFOLDER___" : "-LOADFOLDER___";
	}

	public static String setshufflerepeat() {
		return (shufflerepeat) ? "SHUFFLEREPEAT___" : "-SHUFFLEREPEAT___";
	}

	public static String setogg() {
		return (ogg) ? "OGG___" : "-OGG___";
	}

	public static String setmp3() {
		return (mp3) ? "MP3___" : "-MP3___";
	}

	public static String setskins() {
		return (skins) ? "SKINS___" : "-SKINS___";
	}

	public static String setclearplaylist() {
		return (clearplaylist) ? "CLEARPLAYLIST___" : "-CLEARPLAYLIST___";
	}

		  public boolean thereIsBase() {
		    	return false;
		    }

		  public static void init(String... args) {
		    int index = 0;
		    featureamp = Boolean.valueOf(args[index++]);
			gui = Boolean.valueOf(args[index++]);
			player = Boolean.valueOf(args[index++]);
			skiptrack = Boolean.valueOf(args[index++]);
			volumecontrol = Boolean.valueOf(args[index++]);
			lightskin = Boolean.valueOf(args[index++]);
			removetrack = Boolean.valueOf(args[index++]);
			time = Boolean.valueOf(args[index++]);
			reorderplaylist = Boolean.valueOf(args[index++]);
			playlist = Boolean.valueOf(args[index++]);
			darkskin = Boolean.valueOf(args[index++]);
			saveandloadplaylist = Boolean.valueOf(args[index++]);
			queuetrack = Boolean.valueOf(args[index++]);
			progressbar = Boolean.valueOf(args[index++]);
			mute = Boolean.valueOf(args[index++]);
			showtime = Boolean.valueOf(args[index++]);
			controlplayist = Boolean.valueOf(args[index++]);
			showcover = Boolean.valueOf(args[index++]);
			loadfolder = Boolean.valueOf(args[index++]);
			shufflerepeat = Boolean.valueOf(args[index++]);
			ogg = Boolean.valueOf(args[index++]);
			mp3 = Boolean.valueOf(args[index++]);
			skins = Boolean.valueOf(args[index++]);
			clearplaylist = Boolean.valueOf(args[index++]);

		  }

}
