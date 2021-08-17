package SplatOutput___SAC;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FeatureSplatOutput {

	public ArrayList<Line> fileLine = new ArrayList<Line>();
	public ArrayList<String> features = new ArrayList<String>();

	public void inicialization(TargetSystem t) {

		/* Jtopas */
		if (t == TargetSystem.jTOPAS) {
			
			features.add("BASE");
			features.add("TOKENPOSONLY");
			features.add("COUNTLINES");
			features.add("IMAGEPARTS");
			features.add("BLOCKCOMMENTS");
			features.add("LINECOMMENTS");
		}
		/* Zipme */
		else if (t == TargetSystem.ZIPME) {
			features.add("BASE");
			features.add("COMPRESS");
			features.add("GZIP");
			features.add("EXTRACT");
			features.add("ARCHIVECHECK");
			features.add("CRC");
			features.add("ADLER32CHECKSUM");
			features.add("DERIVATIVE_COMPRESS_ADLER32CHECKSUM");
			features.add("DERIVATIVE_COMPRESS_CRC");
			features.add("DERIVATIVE_COMPRESS_GZIP");
			features.add("DERIVATIVE_COMPRESS_GZIPCRC");
			features.add("DERIVATIVE_EXTRACT_CRC");
			features.add("DERIVATIVE_GZIPCRC");
		}
//		// email
		else if (t == TargetSystem.EMAIL) {
			features.add("BASE");
			features.add("KEYS");
			features.add("ENCRYPT");
			features.add("AUTORESPONDER");
			features.add("ADDRESSBOOK");
			features.add("SIGN");
			features.add("FORWARD");
			features.add("VERIFY");
			features.add("DECRYPT");
		}
	// GPL
				else if (t == TargetSystem.GPL) {
					features.add("BASE");
					features.add("DIRECTED");
					features.add("UNDIRECTED");
					features.add("WEIGHTED");
					features.add("SEARCH");
					features.add("BFS");
					features.add("NUMBER");
					features.add("CONNECTED");
					features.add("STRONGLYCONNECTED");
					features.add("CYCLE");
					features.add("MSTPRIM");
					features.add("MSTKRUSKAL");
					features.add("SHORTEST");
				}
		// companies
				else if (t == TargetSystem.COMPANIES) {
					features.add("TREE_STRUCTURE");
					features.add("LOGGING");
					features.add("CUT_WHATEVER");
					features.add("CUT_NO_DEPARTMENT");
					features.add("CUT_NO_MANAGER");
					features.add("GUI");
					features.add("PRECEDENCE");
					features.add("TOTAL_WALKER");
					features.add("TOTAL_REDUCER");
					features.add("ACCESS_CONTROL");
				}
		// sudoku
				else if (t == TargetSystem.SUDOKU) {
					features.add("BASE");
					features.add("STATES");
					features.add("UNDO");
					features.add("COLOR");
					features.add("SOLVER");
					features.add("GENERATOR");
					features.add("EXTENDEDSUDOKU");
				}
		// elevator
				else if (t == TargetSystem.ELEVATOR) {
					features.add("base");
					features.add("weight");
					features.add("empty");
					features.add("twothirdsfull");
					features.add("executivefloor");
					features.add("overloaded");
				}
		//Desktopsearcher
				else if (t == TargetSystem.DESCKTOPSEARCHER) {
		        features.add("BASE");
				features.add("HTML");
				features.add("TXT");
				features.add("LATEX");
				features.add("USER_INTERFACE");
				features.add("COMMAND_LINE");
				features.add("GUI");
				features.add("GUI_PREFERENCES");
				features.add("QUERY_HISTORY");
				features.add("INDEX_HISTORY");
				features.add("SINGLE_DIRECTORY");
				features.add("MULTI_DIRECTORY");
				features.add("NORMAL_VIEW");
				features.add("TREE_VIEW");
				features.add("WINDOWS");
				features.add("LINUX" );
		}
		//NOTEPAD
		else if (t == TargetSystem.NOTEPAD) {
			features.add("BASE");
			features.add("BASEMENUBAR");
			features.add("BASETOOLBAR");
			features.add("EDITMENUBAR");
			features.add("EDITTOOLBAR");
			features.add("FORMATMENUBAR");
			features.add("FORMATTOOLBAR");
			features.add("PERSISTENCEMENUBAR");
			features.add("PERSISTENCETOOLBAR");
			features.add("PRINTMENUBAR");
			features.add("PRINTTOOLBAR");
			features.add("SEARCHMENUBAR");
			features.add("SEARCHTOOLBAR");
			features.add("UNDOREDOMENUBAR");
			features.add("UNDOREDOTOOLBAR");
			features.add("WORDCOUNTMENUBAR");
			features.add("WORDCOUNTTOOLBAR");
		}
		//BANKACCOUNT
		else if (t == TargetSystem.BANKACCOUNT) {
			features.add("bankaccount");
			features.add("creditworthiness");
			features.add("dailylimit");
			features.add("interest");
			features.add("interestestimation");
			features.add("lock");
			features.add("logging");
			features.add("overdraft");
			features.add("transaction");
			features.add("transactionlog");
		}
		//chess
		else if (t == TargetSystem.CHESS) {
			features.add("AI_PLAYER");
			features.add("ONLINE_PLAYER");
			features.add("OFFLINE_PLAYER");
		}
		//ATM
		else if (t == TargetSystem.ATM) {
			features.add("LOGGING");
			features.add("DEPOSITING");
			features.add("WITHDRAWING");
			features.add("BALANCE_INQUIRY");
			features.add("ADMIN_CONTROL");
			features.add("USER_INTERFACE");
			features.add("WITHDRAWING_ALL_VALUES");
		}
		//TASK
				else if (t == TargetSystem.TASK) {
					features.add("OBSERVER");
					features.add("REMOVER");
					features.add("LOGGIN");
				}
		//Telecon
				else if (t == TargetSystem.TELECOM) {
					features.add("HISTORIC");
					features.add("TIMING");
				}
		//vending
				else if (t == TargetSystem.VENDING) {
					features.add("base");
					features.add("coinValidation");
					features.add("availability");
					features.add("terminal");
					features.add("keyboard");
					features.add("showStock");
					features.add("flexiblequantity");
					features.add("totalValueCollected");
				}
		//mine
				else if (t == TargetSystem.MINE) {
					        features.add("base");
							features.add("highWaterSensor");
							features.add("lowWaterSensor");
							features.add("methaneQuery");
							features.add("methaneAlarm");
							features.add("stopCommand");
							features.add("startCommand");
				}
		//set
				else if (t == TargetSystem.SET) {
					features.add("tree");
					features.add("integerset");
					features.add("hashset");
				}
				else if (t == TargetSystem.UNIONFIND) {
					features.add("wqu_byheight");
					features.add("quickfind");
					features.add("qu_weighted_modifications");
					features.add("unionfind");
					features.add("qu_weighted");
					features.add("unionfindspl");
					features.add("quickunion");
					features.add("wqu_halfing");
					features.add("wqu_pathcompression");
					features.add("tests");
				}
		
		//Prop4j
				else if (t == TargetSystem.PROP4J) {
					features.add("operators");
					features.add("or");
					features.add("negation");
					features.add("atmost");
					features.add("node_writer");
					features.add("to_cnf");
					features.add("prop4jspl");
					features.add("extended");
					features.add("tests");
					features.add("equals");
					features.add("node_reader");
					features.add("implies");
					features.add("atleast");
					features.add("choose");
					features.add("input_output");
					features.add("and");
					features.add("satsolver");
				}
		//FeatureAMP1
//				else if (t == TargetSystem.FeatureAMP1) {
//		features.add("volumecontrol");
//		features.add("skiptrack");
//		features.add("removetrack");
//		features.add("time");
//		features.add("resizable");
//		features.add("wav");
//		features.add("supportedformats");
//		features.add("reorderplaylist");
//		features.add("playlist");
//		features.add("control");
//		features.add("light");
//		features.add("saveandloadplaylist");
//		features.add("gui");
//		features.add("featureamp");
//		features.add("queuetrack");
//		features.add("mute");
//		features.add("progressbar");
//		features.add("showtime");
//		features.add("id3information");
//		features.add("showcover");
//		features.add("loadfolder");
//		features.add("shufflerepeat");
//		features.add("base");
//		features.add("mp3");
//		features.add("skins");
//		features.add("dark");
//		features.add("openfile");
//		features.add("clearplaylist");
//		}
//		
		//FeatureAMP2
//	    else if (t == TargetSystem.FeatureAMP2) {
//			features.add("skiptrack");
//			features.add("volumecontrol");
//			features.add("lightskin");
//			features.add("removetrack");
//			features.add("time");
//			features.add("reorderplaylist");
//			features.add("playlist");
//			features.add("darkskin");
//			features.add("saveandloadplaylist");
//			features.add("gui");
//			features.add("featureamp");
//			features.add("queuetrack");
//			features.add("progressbar");
//			features.add("mute");
//			features.add("showtime");
//			features.add("player");
//			features.add("controlplayist");
//			features.add("showcover");
//			features.add("loadfolder");
//			features.add("shufflerepeat");
//			features.add("ogg");
//			features.add("mp3");
//			features.add("skins");
//			features.add("clearplaylist");
//		}
//		FeatureAMP3
//	    else if (t == TargetSystem.FeatureAMP3) {
//			features.add("skiptrack");
//			features.add("volumecontrol");
//			features.add("playlistcontrol");
//			features.add("removetrack");
//			features.add("time");
//			features.add("wav");
//			features.add("reorderplaylist");
//			features.add("mp3");
//			features.add("playlist");
//			features.add("light");
//			features.add("saveandloadplaylist");
//			features.add("changelistener");
//			features.add("gui");
//			features.add("featureamp");
//			features.add("queuetrack");
//			features.add("filesupport");
//			features.add("playlistcontextmenu");
//			features.add("mute");
//			features.add("progressbar");
//			features.add("tageditor");
//			features.add("showtime");
//			features.add("aac");
//			features.add("loadfolder");
//			features.add("multipleplaylists");
//			features.add("showcover");
//			features.add("playlistmenu");
//			features.add("shufflerepeat");
//			features.add("base");
//			features.add("ogg");
//			features.add("playlisttabs");
//			features.add("addplaylistwrapper");
//			features.add("skins");
//			features.add("dark");
//			features.add("clearplaylist");
//
//		}
		else if (t == TargetSystem.FeatureAMP4) {
			features.add("skins");
			features.add("player_control");
			features.add("reorder_playlist");
			features.add("title_time");
			features.add("skip_track");
			features.add("progress");
			features.add("clear_playlist");
			features.add("progress_bar");
			features.add("volume_control");
			features.add("remove_track");
			features.add("light");
			features.add("dark");
			features.add("shuffle_repeat");
			features.add("show_cover");
			features.add("ogg");
			features.add("mp3");
			features.add("save_load_playlist");
			features.add("base_featureamp");
			features.add("load_folder");
			features.add("queue_track");
			features.add("file_support");
			features.add("player_bar");
			features.add("mute");
			features.add("id3_title");
			features.add("playlist");
		}
		else if (t == TargetSystem.FeatureAMP5) {
			features.add("volumecontrol");
			features.add("skiptrack");
			features.add("removetrack");
			features.add("queueremove");
			features.add("reorderplaylist");
			features.add("playlist");
			features.add("light");
			features.add("saveandloadplaylist");
			features.add("gui");
			features.add("featureamp");
			features.add("filesupport");
			features.add("queuetrack");
			features.add("mute");
			features.add("progressbar");
			features.add("progress");
			features.add("showtime");
			features.add("playlistcontrols");
			features.add("showcover");
			features.add("loadfolder");
			features.add("skiprepeat");
			features.add("shufflerepeat");
			features.add("base");
			features.add("wave");
			features.add("mp3");
			features.add("skins");
			features.add("dark");
			features.add("clearplaylist");
		}
		else if (t == TargetSystem.FeatureAMP6) {
			features.add("skiptrack");
			features.add("metadata");
			features.add("removetrack");
			features.add("album");
			features.add("wav");
			features.add("nicetohave");
			features.add("playlist");
			features.add("jumpposition");
			features.add("light");
			features.add("openfolder");
			features.add("gui");
			features.add("featureamp");
			features.add("queuetrack");
			features.add("mute");
			features.add("tageditor");
			features.add("tracknumber");
			features.add("codecs");
			features.add("progress");
			features.add("aac");
			features.add("playlistcontrols");
			features.add("multipleplaylists");
			features.add("randomcolor");
			features.add("saveandload");
			features.add("shufflerepeat");
			features.add("base");
			features.add("ogg");
			features.add("youtube");
			features.add("mp3");
			features.add("oscolors");
			features.add("reorder");
			features.add("cover");
			features.add("volume");
			features.add("skins");
			features.add("dark");
			features.add("clearplaylist");
			features.add("remeberstatus");
			features.add("progressbar");
			features.add("titlebar");
		}
		else if (t == TargetSystem.FeatureAMP7) {
			features.add("openwavfile");
			features.add("volumecontrol");
			features.add("skiptrack");
			features.add("mp3player");
			features.add("removetrack");
			features.add("time");
			features.add("changeplaylist");
			features.add("openmp3file");
			features.add("reorderplaylist");
			features.add("playlist");
			features.add("light");
			features.add("saveandloadplaylist");
			features.add("gui");
			features.add("audioformats");
			features.add("featureamp");
			features.add("queuetrack");
			features.add("mute");
			features.add("progressbar");
			features.add("showtime");
			features.add("showtitle");
			features.add("wavplayer");
			features.add("loadfolder");
			features.add("showcover");
			features.add("shufflerepeat");
			features.add("skins");
			features.add("orangebluest");
			features.add("dark");
			features.add("openfile");
			features.add("clearplaylist");
		}
		else if (t == TargetSystem.FeatureAMP8) {
			features.add("volumecontrol");
			features.add("skiptrack");
			features.add("playengine");
			features.add("removetrack");
			features.add("wav");
			features.add("reorderplaylist");
			features.add("playlist");
			features.add("control");
			features.add("light");
			features.add("saveandloadplaylist");
			features.add("gui");
			features.add("featureamp");
			features.add("filesupport");
			features.add("queuetrack");
			features.add("progressbar");
			features.add("mute");
			features.add("showtime");
			features.add("loadfolder");
			features.add("tracktime");
			features.add("shufflerepeat");
			features.add("ogg");
			features.add("mp3");
			features.add("skins");
			features.add("dark");
			features.add("choosefile");
			features.add("clearplaylist");
			features.add("showcover");
		}
		else if (t == TargetSystem.FeatureAMP9) {
			features.add("volumecontrol");
			features.add("skiptrack");
			features.add("removetrack");
			features.add("weichbrodt_featureamp");
			features.add("reorderplaylist");
			features.add("playlist");
			features.add("timedisplay");
			features.add("light");
			features.add("shuffleskipremove");
			features.add("saveandloadplaylist");
			features.add("gui");
			features.add("queuetrack");
			features.add("filesupport");
			features.add("progressbar");
			features.add("mute");
			features.add("showtime");
			features.add("showcover");
			features.add("loadfolder");
			features.add("shufflerepeat");
			features.add("ogg");
			features.add("mp3");
			features.add("skins");
			features.add("dark");
			features.add("clearplaylist");

		}
		
		else if (t == TargetSystem.PAYCARD) {
			features.add("logging");
			features.add("paycard");
			features.add("maximumrecord");
			features.add("lockout");
		}
	}

	public void leitor(String arquivo) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();

		for (int i = 0; i < listas.size(); i++) {
			System.out.println("----"+listas.get(i));
			Line lines = new Line();
            lines.featureline = splitLine(listas.get(i));
			fileLine.add(lines);
		}

	}

	public void featureReplacement() {
		Line aux;
         String aux_;
		for (int i = 0; i < fileLine.size(); i++) {
			aux = fileLine.get(i);
			
			for (int j = 0; j < aux.featureline.size(); j++) {
				aux_=aux.featureline.get(j);
				aux_=aux_.replace(" ", "");
				if (aux_.equals("0")) {
					System.out.print(" !" + features.get(j) + ", ");
				} else if (aux_.equals("1")) {
					System.out.print(" " + features.get(j) + ", ");
				}else if (aux_.equals("?")) {
					System.out.print("?, ");
				}
				
				else {
					if(aux_.contains("P")) {
					aux_=aux_.replace("P", " F	at tests");
				    }
				    else {
				    	aux_=aux_.replace("F", " F	at tests");
				    	}
				    
					System.out.print(" " + aux_ );
				}
			}
			System.out.println();

		}
	}

	public void print() {
		for (int i = 0; i < fileLine.size(); i++) {
			System.out.println(fileLine.get(i).featureline);

		}
	}

	public ArrayList<String> splitLine(String line) {
		ArrayList<String> novo = new ArrayList<String>();
		String[] split = line.split(",");

		if (split.length <= 0)
			return null;

		for (String string : split) {
			if (!string.isEmpty())
				novo.add(string);
		}

		return novo;
	}

	public static void main(String[] args) {
		System.out.println("Inicio...");
		FeatureSplatOutput arquivo = new FeatureSplatOutput();
		arquivo.inicialization(TargetSystem.GPL);
		
		arquivo.leitor("src/SplatOutput/FeatureSplatOutput.txt");

		arquivo.featureReplacement();
		System.out.println("Fim.");
	}
}
