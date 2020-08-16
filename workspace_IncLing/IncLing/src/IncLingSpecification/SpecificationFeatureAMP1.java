package IncLingSpecification;

import IncLingSpecification.Specification;
import guidsl.SATtest;
import guidsl.Tool;

public class SpecificationFeatureAMP1  extends Specification{
	public static boolean featureamp=true;
	public static boolean gui=true;
	public static boolean base=true;
	public static boolean supportedformats=true;
	
	public static boolean volumecontrol=false;
	public static boolean skiptrack=false;
	public static boolean removetrack=false;
	public static boolean time=false;
	public static boolean resizable=false;
	public static boolean wav=false;
	public static boolean reorderplaylist=false;
	public static boolean playlist=false;
	public static boolean control=false;
	public static boolean light=false;
	public static boolean saveandloadplaylist=false;
	public static boolean queuetrack=false;
	public static boolean mute=false;
	public static boolean progressbar=false;
	public static boolean showtime=false;
	public static boolean id3information=false;
	public static boolean showcover=false;
	public static boolean loadfolder=false;
	public static boolean shufflerepeat=false;
	public static boolean mp3=false;
	public static boolean skins=false;
	public static boolean dark=false;
	public static boolean openfile=false;
	public static boolean clearplaylist=false;
	  
	private static SpecificationFeatureAMP1 SINGLETON;
    
	public static SpecificationFeatureAMP1 getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationFeatureAMP1();
		}
		tool=t;
		return SINGLETON;
	}
	
	public static boolean runTest( SATtest t, boolean compat ) {
	    return (tool.modelDebug(t, makeCnfFile ))? true: false;
	  }

	

	public static String setVOLUMECONTROL() {
		return (volumecontrol) ? "volumecontrol___" : "-volumecontrol___";
		}
		public static String setSKIPTRACK() {
		return (skiptrack) ? "skiptrack___" : "-skiptrack___";
		}
		public static String setREMOVETRACK() {
		return (removetrack) ? "removetrack___" : "-removetrack___";
		}
		public static String setTIME() {
		return (time) ? "time___" : "-time___";
		}
		public static String setRESIZABLE() {
		return (resizable) ? "resizable___" : "-resizable___";
		}
		public static String setWAV() {
		return (wav) ? "wav___" : "-wav___";
		}
		public static String setSUPPORTEDFORMATS() {
		return (supportedformats) ? "supportedformats___" : "-supportedformats___";
		}
		public static String setREORDERPLAYLIST() {
		return (reorderplaylist) ? "reorderplaylist___" : "-reorderplaylist___";
		}
		public static String setPLAYLIST() {
		return (playlist) ? "playlist___" : "-playlist___";
		}
		public static String setCONTROL() {
		return (control) ? "control___" : "-control___";
		}
		public static String setLIGHT() {
		return (light) ? "light___" : "-light___";
		}
		public static String setSAVEANDLOADPLAYLIST() {
		return (saveandloadplaylist) ? "saveandloadplaylist___" : "-saveandloadplaylist___";
		}
		public static String setGUI() {
		return (gui) ? "gui___" : "-gui___";
		}
		public static String setFEATUREAMP() {
		return (featureamp) ? "featureamp___" : "-featureamp___";
		}
		public static String setQUEUETRACK() {
		return (queuetrack) ? "queuetrack___" : "-queuetrack___";
		}
		public static String setMUTE() {
		return (mute) ? "mute___" : "-mute___";
		}
		public static String setPROGRESSBAR() {
		return (progressbar) ? "progressbar___" : "-progressbar___";
		}
		public static String setSHOWTIME() {
		return (showtime) ? "showtime___" : "-showtime___";
		}
		public static String setID3INFORMATION() {
		return (id3information) ? "id3information___" : "-id3information___";
		}
		public static String setSHOWCOVER() {
		return (showcover) ? "showcover___" : "-showcover___";
		}
		public static String setLOADFOLDER() {
		return (loadfolder) ? "loadfolder___" : "-loadfolder___";
		}
		public static String setSHUFFLEREPEAT() {
		return (shufflerepeat) ? "shufflerepeat___" : "-shufflerepeat___";
		}
		public static String setBASE() {
		return (base) ? "base___" : "-base___";
		}
		public static String setMP3() {
		return (mp3) ? "mp3___" : "-mp3___";
		}
		public static String setSKINS() {
		return (skins) ? "skins___" : "-skins___";
		}
		public static String setDARK() {
		return (dark) ? "dark___" : "-dark___";
		}
		public static String setOPENFILE() {
		return (openfile) ? "openfile___" : "-openfile___";
		}
		public static String setCLEARPLAYLIST() {
		return (clearplaylist) ? "clearplaylist___" : "-clearplaylist___";
		}

		  public boolean thereIsBase() {
		    	return true;
		    }

		  public static void init(String... args) {
		    int index = 0;
		    volumecontrol = Boolean.valueOf(args[index++]);
			skiptrack = Boolean.valueOf(args[index++]);
			removetrack = Boolean.valueOf(args[index++]);
			time = Boolean.valueOf(args[index++]);
			resizable = Boolean.valueOf(args[index++]);
			wav = Boolean.valueOf(args[index++]);
			supportedformats = Boolean.valueOf(args[index++]);
			reorderplaylist = Boolean.valueOf(args[index++]);
			playlist = Boolean.valueOf(args[index++]);
			control = Boolean.valueOf(args[index++]);
			light = Boolean.valueOf(args[index++]);
			saveandloadplaylist = Boolean.valueOf(args[index++]);
			gui = Boolean.valueOf(args[index++]);
			featureamp = Boolean.valueOf(args[index++]);
			queuetrack = Boolean.valueOf(args[index++]);
			mute = Boolean.valueOf(args[index++]);
			progressbar = Boolean.valueOf(args[index++]);
			showtime = Boolean.valueOf(args[index++]);
			id3information = Boolean.valueOf(args[index++]);
			showcover = Boolean.valueOf(args[index++]);
			loadfolder = Boolean.valueOf(args[index++]);
			shufflerepeat = Boolean.valueOf(args[index++]);
			base = Boolean.valueOf(args[index++]);
			mp3 = Boolean.valueOf(args[index++]);
			skins = Boolean.valueOf(args[index++]);
			dark = Boolean.valueOf(args[index++]);
			openfile = Boolean.valueOf(args[index++]);
			clearplaylist = Boolean.valueOf(args[index++]);

		  }

}
