package IncLingSpecification;

import IncLingSpecification.Specification;
import guidsl.SATtest;
import guidsl.Tool;

public class SpecificationFeatureAMP6  extends Specification{
	
	public static boolean skiptrack=false;
	public static boolean metadata=false;
	public static boolean removetrack=false;
	public static boolean album=false;
	public static boolean wav=false;
	public static boolean nicetohave=false;
	public static boolean playlist=true;
	public static boolean jumpposition=false;
	public static boolean light=false;
	public static boolean openfolder=false;
	public static boolean gui=true;
	public static boolean featureamp =true;
	public static boolean queuetrack=false;
	public static boolean mute=false;
	public static boolean tageditor=false;
	public static boolean tracknumber=false;
	public static boolean codecs=true;
	public static boolean progress=false;
	public static boolean aac=false;
	public static boolean playlistcontrols=false;
	public static boolean multipleplaylists=false;
	public static boolean randomcolor=false;
	public static boolean saveandload=false;
	public static boolean shufflerepeat=false;
	public static boolean base=true;
	public static boolean ogg=false;
	public static boolean youtube=false;
	public static boolean mp3=false;
	public static boolean oscolors=false;
	public static boolean reorder=false;
	public static boolean cover=false;
	public static boolean volume=false;
	public static boolean skins=false;
	public static boolean dark=false;
	public static boolean clearplaylist=false;
	public static boolean remeberstatus=false;
	public static boolean progressbar=false;
	public static boolean titlebar=false;
	
	private static SpecificationFeatureAMP6 SINGLETON;
    
	public static SpecificationFeatureAMP6 getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationFeatureAMP6();
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

	public static String setbase() {
		return (base) ? "BASE___" : "-BASE___";
	}

	public static String setcodecs() {
		return (codecs) ? "CODECS___" : "-CODECS___";
	}

	public static String setgui() {
		return (gui) ? "GUI___" : "-GUI___";
	}

	public static String setskiptrack() {
		return (skiptrack) ? "SKIPTRACK___" : "-SKIPTRACK___";
	}

	public static String setmetadata() {
		return (metadata) ? "METADATA___" : "-METADATA___";
	}

	public static String setremovetrack() {
		return (removetrack) ? "REMOVETRACK___" : "-REMOVETRACK___";
	}

	public static String setalbum() {
		return (album) ? "ALBUM___" : "-ALBUM___";
	}

	public static String setwav() {
		return (wav) ? "WAV___" : "-WAV___";
	}

	public static String setnicetohave() {
		return (nicetohave) ? "NICETOHAVE___" : "-NICETOHAVE___";
	}

	public static String setplaylist() {
		return (playlist) ? "PLAYLIST___" : "-PLAYLIST___";
	}

	public static String setjumpposition() {
		return (jumpposition) ? "JUMPPOSITION___" : "-JUMPPOSITION___";
	}

	public static String setlight() {
		return (light) ? "LIGHT___" : "-LIGHT___";
	}

	public static String setopenfolder() {
		return (openfolder) ? "OPENFOLDER___" : "-OPENFOLDER___";
	}

	public static String setqueuetrack() {
		return (queuetrack) ? "QUEUETRACK___" : "-QUEUETRACK___";
	}

	public static String setmute() {
		return (mute) ? "MUTE___" : "-MUTE___";
	}

	public static String settageditor() {
		return (tageditor) ? "TAGEDITOR___" : "-TAGEDITOR___";
	}

	public static String settracknumber() {
		return (tracknumber) ? "TRACKNUMBER___" : "-TRACKNUMBER___";
	}

	public static String setprogress() {
		return (progress) ? "PROGRESS___" : "-PROGRESS___";
	}

	public static String setaac() {
		return (aac) ? "AAC___" : "-AAC___";
	}

	public static String setplaylistcontrols() {
		return (playlistcontrols) ? "PLAYLISTCONTROLS___" : "-PLAYLISTCONTROLS___";
	}

	public static String setmultipleplaylists() {
		return (multipleplaylists) ? "MULTIPLEPLAYLISTS___" : "-MULTIPLEPLAYLISTS___";
	}

	public static String setrandomcolor() {
		return (randomcolor) ? "RANDOMCOLOR___" : "-RANDOMCOLOR___";
	}

	public static String setsaveandload() {
		return (saveandload) ? "SAVEANDLOAD___" : "-SAVEANDLOAD___";
	}

	public static String setshufflerepeat() {
		return (shufflerepeat) ? "SHUFFLEREPEAT___" : "-SHUFFLEREPEAT___";
	}

	public static String setogg() {
		return (ogg) ? "OGG___" : "-OGG___";
	}

	public static String setyoutube() {
		return (youtube) ? "YOUTUBE___" : "-YOUTUBE___";
	}

	public static String setmp3() {
		return (mp3) ? "MP3___" : "-MP3___";
	}

	public static String setoscolors() {
		return (oscolors) ? "OSCOLORS___" : "-OSCOLORS___";
	}

	public static String setreorder() {
		return (reorder) ? "REORDER___" : "-REORDER___";
	}

	public static String setcover() {
		return (cover) ? "COVER___" : "-COVER___";
	}

	public static String setvolume() {
		return (volume) ? "VOLUME___" : "-VOLUME___";
	}

	public static String setskins() {
		return (skins) ? "SKINS___" : "-SKINS___";
	}

	public static String setdark() {
		return (dark) ? "DARK___" : "-DARK___";
	}

	public static String setclearplaylist() {
		return (clearplaylist) ? "CLEARPLAYLIST___" : "-CLEARPLAYLIST___";
	}

	public static String setremeberstatus() {
		return (remeberstatus) ? "REMEBERSTATUS___" : "-REMEBERSTATUS___";
	}

	public static String setprogressbar() {
		return (progressbar) ? "PROGRESSBAR___" : "-PROGRESSBAR___";
	}

	public static String settitlebar() {
		return (titlebar) ? "TITLEBAR___" : "-TITLEBAR___";
	}
	
	  public boolean thereIsBase() {
		    	return true;
		    }

		  public static void init(String... args) {
		    int index = 0;
		    featureamp = Boolean.valueOf(args[index++]);
			base = Boolean.valueOf(args[index++]);
			codecs = Boolean.valueOf(args[index++]);
			gui = Boolean.valueOf(args[index++]);
			skiptrack = Boolean.valueOf(args[index++]);
			metadata = Boolean.valueOf(args[index++]);
			removetrack = Boolean.valueOf(args[index++]);
			album = Boolean.valueOf(args[index++]);
			wav = Boolean.valueOf(args[index++]);
			nicetohave = Boolean.valueOf(args[index++]);
			playlist = Boolean.valueOf(args[index++]);
			jumpposition = Boolean.valueOf(args[index++]);
			light = Boolean.valueOf(args[index++]);
			openfolder = Boolean.valueOf(args[index++]);
			queuetrack = Boolean.valueOf(args[index++]);
			mute = Boolean.valueOf(args[index++]);
			tageditor = Boolean.valueOf(args[index++]);
			tracknumber = Boolean.valueOf(args[index++]);
			progress = Boolean.valueOf(args[index++]);
			aac = Boolean.valueOf(args[index++]);
			playlistcontrols = Boolean.valueOf(args[index++]);
			multipleplaylists = Boolean.valueOf(args[index++]);
			randomcolor = Boolean.valueOf(args[index++]);
			saveandload = Boolean.valueOf(args[index++]);
			shufflerepeat = Boolean.valueOf(args[index++]);
			ogg = Boolean.valueOf(args[index++]);
			youtube = Boolean.valueOf(args[index++]);
			mp3 = Boolean.valueOf(args[index++]);
			oscolors = Boolean.valueOf(args[index++]);
			reorder = Boolean.valueOf(args[index++]);
			cover = Boolean.valueOf(args[index++]);
			volume = Boolean.valueOf(args[index++]);
			skins = Boolean.valueOf(args[index++]);
			dark = Boolean.valueOf(args[index++]);
			clearplaylist = Boolean.valueOf(args[index++]);
			remeberstatus = Boolean.valueOf(args[index++]);
			progressbar = Boolean.valueOf(args[index++]);
			titlebar = Boolean.valueOf(args[index++]);
		  }

}
