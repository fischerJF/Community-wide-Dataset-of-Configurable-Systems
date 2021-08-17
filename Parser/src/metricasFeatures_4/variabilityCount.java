package metricasFeatures_4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import SplatOutput.ReadFile;
import SplatOutput.TargetSystem;

public class variabilityCount {
	static int cont = 0;
	static String nomeClasse = "";
	public static ArrayList<Feature> features = new ArrayList<Feature>();
	public static ArrayList<Feature> featuresAux = new ArrayList<Feature>();
	public static ArrayList<Feature> espalhamento = new ArrayList<Feature>();
    static int contMetodo=0;
    static int somaFeature=0;
	public static void inicialization(TargetSystem t) {

		/* Jtopas */
		if (t == TargetSystem.jTOPAS) {

			features.add(new Feature("BASE"));
			features.add(new Feature("TOKENPOSONLY"));
			features.add(new Feature("COUNTLINES"));
			features.add(new Feature("IMAGEPARTS"));
			features.add(new Feature("BLOCKCOMMENTS"));
			features.add(new Feature("LINECOMMENTS"));
		}
		/* Zipme */
		else if (t == TargetSystem.ZIPME) {
			features.add(new Feature("BASE"));
			features.add(new Feature("COMPRESS"));
			features.add(new Feature("GZIP"));
			features.add(new Feature("EXTRACT"));
			features.add(new Feature("ARCHIVECHECK"));
			features.add(new Feature("CRC"));
			features.add(new Feature("ADLER32CHECKSUM"));
			features.add(new Feature("DERIVATIVE_COMPRESS_ADLER32CHECKSUM"));
			features.add(new Feature("DERIVATIVE_COMPRESS_CRC"));
			features.add(new Feature("DERIVATIVE_COMPRESS_GZIP"));
			features.add(new Feature("DERIVATIVE_COMPRESS_GZIPCRC"));
			features.add(new Feature("DERIVATIVE_EXTRACT_CRC"));
			features.add(new Feature("DERIVATIVE_GZIPCRC"));
		}
		// // email
		else if (t == TargetSystem.EMAIL) {
			features.add(new Feature("BASE"));
			features.add(new Feature("KEYS"));
			features.add(new Feature("ENCRYPT"));
			features.add(new Feature("AUTORESPONDER"));
			features.add(new Feature("ADDRESSBOOK"));
			features.add(new Feature("SIGN"));
			features.add(new Feature("FORWARD"));
			features.add(new Feature("VERIFY"));
			features.add(new Feature("DECRYPT"));
		}
		// GPL
		else if (t == TargetSystem.GPL) {
			features.add(new Feature("BASE"));
			features.add(new Feature("DIRECTED"));
			features.add(new Feature("UNDIRECTED"));
			features.add(new Feature("WEIGHTED"));
			features.add(new Feature("SEARCH"));
			features.add(new Feature("BFS"));
			features.add(new Feature("NUMBER"));
			features.add(new Feature("CONNECTED"));
			features.add(new Feature("STRONGLYCONNECTED"));
			features.add(new Feature("CYCLE"));
			features.add(new Feature("MSTPRIM"));
			features.add(new Feature("MSTKRUSKAL"));
			features.add(new Feature("SHORTEST"));
		}
		// companies
		else if (t == TargetSystem.COMPANIES) {
			features.add(new Feature("TREE_STRUCTURE"));
			features.add(new Feature("LOGGING"));
			features.add(new Feature("CUT_WHATEVER"));
			features.add(new Feature("CUT_NO_DEPARTMENT"));
			features.add(new Feature("CUT_NO_MANAGER"));
			features.add(new Feature("GUI"));
			features.add(new Feature("PRECEDENCE"));
			features.add(new Feature("TOTAL_WALKER"));
			features.add(new Feature("TOTAL_REDUCER"));
			features.add(new Feature("ACCESS_CONTROL"));
		}
		// sudoku
		else if (t == TargetSystem.SUDOKU) {
			features.add(new Feature("BASE"));
			features.add(new Feature("STATES"));
			features.add(new Feature("UNDO"));
			features.add(new Feature("COLOR"));
			features.add(new Feature("SOLVER"));
			features.add(new Feature("GENERATOR"));
			features.add(new Feature("EXTENDEDSUDOKU"));
		}
		// elevator
		else if (t == TargetSystem.ELEVATOR) {
			features.add(new Feature("base"));
			features.add(new Feature("weight"));
			features.add(new Feature("empty"));
			features.add(new Feature("twothirdsfull"));
			features.add(new Feature("executivefloor"));
			features.add(new Feature("overloaded"));
		}
		// Desktopsearcher
		else if (t == TargetSystem.DESCKTOPSEARCHER) {
			features.add(new Feature("BASE"));
			features.add(new Feature("HTML"));
			features.add(new Feature("TXT"));
			features.add(new Feature("LATEX"));
			features.add(new Feature("USER_INTERFACE"));
			features.add(new Feature("COMMAND_LINE"));
			features.add(new Feature("GUI"));
			features.add(new Feature("GUI_PREFERENCES"));
			features.add(new Feature("QUERY_HISTORY"));
			features.add(new Feature("INDEX_HISTORY"));
			features.add(new Feature("SINGLE_DIRECTORY"));
			features.add(new Feature("MULTI_DIRECTORY"));
			features.add(new Feature("NORMAL_VIEW"));
			features.add(new Feature("TREE_VIEW"));
			features.add(new Feature("WINDOWS"));
			features.add(new Feature("LINUX"));
		}
		// NOTEPAD
		else if (t == TargetSystem.NOTEPAD) {
			features.add(new Feature("BASE"));
			features.add(new Feature("BASEMENUBAR"));
			features.add(new Feature("BASETOOLBAR"));
			features.add(new Feature("EDITMENUBAR"));
			features.add(new Feature("EDITTOOLBAR"));
			features.add(new Feature("FORMATMENUBAR"));
			features.add(new Feature("FORMATTOOLBAR"));
			features.add(new Feature("PERSISTENCEMENUBAR"));
			features.add(new Feature("PERSISTENCETOOLBAR"));
			features.add(new Feature("PRINTMENUBAR"));
			features.add(new Feature("PRINTTOOLBAR"));
			features.add(new Feature("SEARCHMENUBAR"));
			features.add(new Feature("SEARCHTOOLBAR"));
			features.add(new Feature("UNDOREDOMENUBAR"));
			features.add(new Feature("UNDOREDOTOOLBAR"));
			features.add(new Feature("WORDCOUNTMENUBAR"));
			features.add(new Feature("WORDCOUNTTOOLBAR"));
		}
		// BANKACCOUNT
		else if (t == TargetSystem.BANKACCOUNT) {
			features.add(new Feature("bankaccount"));
			features.add(new Feature("creditworthiness"));
			features.add(new Feature("dailylimit"));
			features.add(new Feature("interest"));
			features.add(new Feature("interestestimation"));
			features.add(new Feature("lock"));
			features.add(new Feature("logging"));
			features.add(new Feature("overdraft"));
			features.add(new Feature("transaction"));
			features.add(new Feature("transactionlog"));
		}
		// chess
		else if (t == TargetSystem.CHESS) {
			features.add(new Feature("AI_PLAYER"));
			features.add(new Feature("ONLINE_PLAYER"));
			features.add(new Feature("OFFLINE_PLAYER"));
		}
		// ATM
		else if (t == TargetSystem.ATM) {
			features.add(new Feature("LOGGING"));
			features.add(new Feature("DEPOSITING"));
			features.add(new Feature("WITHDRAWING"));
			features.add(new Feature("BALANCE_INQUIRY"));
			features.add(new Feature("ADMIN_CONTROL"));
			features.add(new Feature("USER_INTERFACE"));
			features.add(new Feature("WITHDRAWING_ALL_VALUES"));
		}
		// TASK
		else if (t == TargetSystem.TASK) {
			features.add(new Feature("OBSERVER"));
			features.add(new Feature("REMOVER"));
			features.add(new Feature("LOGGIN"));
		}
		// Telecon
		else if (t == TargetSystem.TELECOM) {
			features.add(new Feature("HISTORIC"));
			features.add(new Feature("TIMING"));
		}
		// vending
		else if (t == TargetSystem.VENDING) {
			features.add(new Feature("base"));
			features.add(new Feature("coinValidation"));
			features.add(new Feature("availability"));
			features.add(new Feature("terminal"));
			features.add(new Feature("keyboard"));
			features.add(new Feature("showStock"));
			features.add(new Feature("flexiblequantity"));
			features.add(new Feature("totalValueCollected"));
		}
		// mine
		else if (t == TargetSystem.MINE) {
			features.add(new Feature("base"));
			features.add(new Feature("highWaterSensor"));
			features.add(new Feature("lowWaterSensor"));
			features.add(new Feature("methaneQuery"));
			features.add(new Feature("methaneAlarm"));
			features.add(new Feature("stopCommand"));
			features.add(new Feature("startCommand"));
		}
		// set
		else if (t == TargetSystem.SET) {
			features.add(new Feature("tree"));
			features.add(new Feature("integerset"));
			features.add(new Feature("hashset"));
		} else if (t == TargetSystem.UNIONFIND) {
			features.add(new Feature("wqu_byheight"));
			features.add(new Feature("quickfind"));
			features.add(new Feature("qu_weighted_modifications"));
			features.add(new Feature("unionfind"));
			features.add(new Feature("qu_weighted"));
			features.add(new Feature("unionfindspl"));
			features.add(new Feature("quickunion"));
			features.add(new Feature("wqu_halfing"));
			features.add(new Feature("wqu_pathcompression"));
			features.add(new Feature("tests"));
		}

		// Prop4j
		else if (t == TargetSystem.PROP4J) {
			features.add(new Feature("operators"));
			features.add(new Feature("or"));
			features.add(new Feature("negation"));
			features.add(new Feature("atmost"));
			features.add(new Feature("node_writer"));
			features.add(new Feature("to_cnf"));
			features.add(new Feature("prop4jspl"));
			features.add(new Feature("extended"));
			features.add(new Feature("tests"));
			features.add(new Feature("equals"));
			features.add(new Feature("node_reader"));
			features.add(new Feature("implies"));
			features.add(new Feature("atleast"));
			features.add(new Feature("choose"));
			features.add(new Feature("input_output"));
			features.add(new Feature("and"));
			features.add(new Feature("satsolver"));
		}
		// FeatureAMP1
		else if (t == TargetSystem.FeatureAMP1) {
			features.add(new Feature("volumecontrol"));
			features.add(new Feature("skiptrack"));
			features.add(new Feature("removetrack"));
			features.add(new Feature("time"));
			features.add(new Feature("resizable"));
			features.add(new Feature("wav"));
			features.add(new Feature("supportedformats"));
			features.add(new Feature("reorderplaylist"));
			features.add(new Feature("playlist"));
			features.add(new Feature("control"));
			features.add(new Feature("light"));
			features.add(new Feature("saveandloadplaylist"));
			features.add(new Feature("gui"));
			features.add(new Feature("featureamp"));
			features.add(new Feature("queuetrack"));
			features.add(new Feature("mute"));
			features.add(new Feature("progressbar"));
			features.add(new Feature("showtime"));
			features.add(new Feature("id3information"));
			features.add(new Feature("showcover"));
			features.add(new Feature("loadfolder"));
			features.add(new Feature("shufflerepeat"));
			features.add(new Feature("base"));
			features.add(new Feature("mp3"));
			features.add(new Feature("skins"));
			features.add(new Feature("dark"));
			features.add(new Feature("openfile"));
			features.add(new Feature("clearplaylist"));
		}

		// FeatureAMP2
		else if (t == TargetSystem.FeatureAMP2) {
			features.add(new Feature("skiptrack"));
			features.add(new Feature("volumecontrol"));
			features.add(new Feature("lightskin"));
			features.add(new Feature("removetrack"));
			features.add(new Feature("time"));
			features.add(new Feature("reorderplaylist"));
			features.add(new Feature("playlist"));
			features.add(new Feature("darkskin"));
			features.add(new Feature("saveandloadplaylist"));
			features.add(new Feature("gui"));
			features.add(new Feature("featureamp"));
			features.add(new Feature("queuetrack"));
			features.add(new Feature("progressbar"));
			features.add(new Feature("mute"));
			features.add(new Feature("showtime"));
			features.add(new Feature("player"));
			features.add(new Feature("controlplayist"));
			features.add(new Feature("showcover"));
			features.add(new Feature("loadfolder"));
			features.add(new Feature("shufflerepeat"));
			features.add(new Feature("ogg"));
			features.add(new Feature("mp3"));
			features.add(new Feature("skins"));
			features.add(new Feature("clearplaylist"));
		}
		// FeatureAMP3
		else if (t == TargetSystem.FeatureAMP3) {
			features.add(new Feature("skiptrack"));
			features.add(new Feature("volumecontrol"));
			features.add(new Feature("playlistcontrol"));
			features.add(new Feature("removetrack"));
			features.add(new Feature("time"));
			features.add(new Feature("wav"));
			features.add(new Feature("reorderplaylist"));
			features.add(new Feature("mp3"));
			features.add(new Feature("playlist"));
			features.add(new Feature("light"));
			features.add(new Feature("saveandloadplaylist"));
			features.add(new Feature("changelistener"));
			features.add(new Feature("gui"));
			features.add(new Feature("featureamp"));
			features.add(new Feature("queuetrack"));
			features.add(new Feature("filesupport"));
			features.add(new Feature("playlistcontextmenu"));
			features.add(new Feature("mute"));
			features.add(new Feature("progressbar"));
			features.add(new Feature("tageditor"));
			features.add(new Feature("showtime"));
			features.add(new Feature("aac"));
			features.add(new Feature("loadfolder"));
			features.add(new Feature("multipleplaylists"));
			features.add(new Feature("showcover"));
			features.add(new Feature("playlistmenu"));
			features.add(new Feature("shufflerepeat"));
			features.add(new Feature("base"));
			features.add(new Feature("ogg"));
			features.add(new Feature("playlisttabs"));
			features.add(new Feature("addplaylistwrapper"));
			features.add(new Feature("skins"));
			features.add(new Feature("dark"));
			features.add(new Feature("clearplaylist"));
		} 
		
		else if (t == TargetSystem.FeatureAMP4) {
			features.add(new Feature("skins"));
			features.add(new Feature("player_control"));
			features.add(new Feature("reorder_playlist"));
			features.add(new Feature("title_time"));
			features.add(new Feature("skip_track"));
			features.add(new Feature("progress"));
			features.add(new Feature("clear_playlist"));
			features.add(new Feature("progress_bar"));
			features.add(new Feature("volume_control"));
			features.add(new Feature("remove_track"));
			features.add(new Feature("light"));
			features.add(new Feature("dark"));
			features.add(new Feature("shuffle_repeat"));
			features.add(new Feature("show_cover"));
			features.add(new Feature("ogg"));
			features.add(new Feature("mp3"));
			features.add(new Feature("save_load_playlist"));
			features.add(new Feature("base_featureamp"));
			features.add(new Feature("load_folder"));
			features.add(new Feature("queue_track"));
			features.add(new Feature("file_support"));
			features.add(new Feature("player_bar"));
			features.add(new Feature("mute"));
			features.add(new Feature("id3_title"));
			features.add(new Feature("playlist"));
		} else if (t == TargetSystem.FeatureAMP5) {
			features.add(new Feature("volumecontrol"));
			features.add(new Feature("skiptrack"));
			features.add(new Feature("removetrack"));
			features.add(new Feature("queueremove"));
			features.add(new Feature("reorderplaylist"));
			features.add(new Feature("playlist"));
			features.add(new Feature("light"));
			features.add(new Feature("saveandloadplaylist"));
			features.add(new Feature("gui"));
			features.add(new Feature("featureamp"));
			features.add(new Feature("filesupport"));
			features.add(new Feature("queuetrack"));
			features.add(new Feature("mute"));
			features.add(new Feature("progressbar"));
			features.add(new Feature("progress"));
			features.add(new Feature("showtime"));
			features.add(new Feature("playlistcontrols"));
			features.add(new Feature("showcover"));
			features.add(new Feature("loadfolder"));
			features.add(new Feature("skiprepeat"));
			features.add(new Feature("shufflerepeat"));
			features.add(new Feature("base"));
			features.add(new Feature("wave"));
			features.add(new Feature("mp3"));
			features.add(new Feature("skins"));
			features.add(new Feature("dark"));
			features.add(new Feature("clearplaylist"));
		} 
		else if (t == TargetSystem.FeatureAMP6) {
			features.add(new Feature("skiptrack"));
			features.add(new Feature("metadata"));
			features.add(new Feature("removetrack"));
			features.add(new Feature("album"));
			features.add(new Feature("wav"));
			features.add(new Feature("nicetohave"));
			features.add(new Feature("playlist"));
			features.add(new Feature("jumpposition"));
			features.add(new Feature("light"));
			features.add(new Feature("openfolder"));
			features.add(new Feature("gui"));
			features.add(new Feature("featureamp"));
			features.add(new Feature("queuetrack"));
			features.add(new Feature("mute"));
			features.add(new Feature("tageditor"));
			features.add(new Feature("tracknumber"));
			features.add(new Feature("codecs"));
			features.add(new Feature("progress"));
			features.add(new Feature("aac"));
			features.add(new Feature("playlistcontrols"));
			features.add(new Feature("multipleplaylists"));
			features.add(new Feature("randomcolor"));
			features.add(new Feature("saveandload"));
			features.add(new Feature("shufflerepeat"));
			features.add(new Feature("base"));
			features.add(new Feature("ogg"));
			features.add(new Feature("youtube"));
			features.add(new Feature("mp3"));
			features.add(new Feature("oscolors"));
			features.add(new Feature("reorder"));
			features.add(new Feature("cover"));
			features.add(new Feature("volume"));
			features.add(new Feature("skins"));
			features.add(new Feature("dark"));
			features.add(new Feature("clearplaylist"));
			features.add(new Feature("remeberstatus"));
			features.add(new Feature("progressbar"));
			features.add(new Feature("titlebar"));
		} else if (t == TargetSystem.FeatureAMP7) {
			features.add(new Feature("openwavfile"));
			features.add(new Feature("volumecontrol"));
			features.add(new Feature("skiptrack"));
			features.add(new Feature("mp3player"));
			features.add(new Feature("removetrack"));
			features.add(new Feature("time"));
			features.add(new Feature("changeplaylist"));
			features.add(new Feature("openmp3file"));
			features.add(new Feature("reorderplaylist"));
			features.add(new Feature("playlist"));
			features.add(new Feature("light"));
			features.add(new Feature("saveandloadplaylist"));
			features.add(new Feature("gui"));
			features.add(new Feature("audioformats"));
			features.add(new Feature("featureamp"));
			features.add(new Feature("queuetrack"));
			features.add(new Feature("mute"));
			features.add(new Feature("progressbar"));
			features.add(new Feature("showtime"));
			features.add(new Feature("showtitle"));
			features.add(new Feature("wavplayer"));
			features.add(new Feature("loadfolder"));
			features.add(new Feature("showcover"));
			features.add(new Feature("shufflerepeat"));
			features.add(new Feature("skins"));
			features.add(new Feature("orangebluest"));
			features.add(new Feature("dark"));
			features.add(new Feature("openfile"));
			features.add(new Feature("clearplaylist"));
		} else if (t == TargetSystem.FeatureAMP8) {
			features.add(new Feature("volumecontrol"));
			features.add(new Feature("skiptrack"));
			features.add(new Feature("playengine"));
			features.add(new Feature("removetrack"));
			features.add(new Feature("wav"));
			features.add(new Feature("reorderplaylist"));
			features.add(new Feature("playlist"));
			features.add(new Feature("control"));
			features.add(new Feature("light"));
			features.add(new Feature("saveandloadplaylist"));
			features.add(new Feature("gui"));
			features.add(new Feature("featureamp"));
			features.add(new Feature("filesupport"));
			features.add(new Feature("queuetrack"));
			features.add(new Feature("progressbar"));
			features.add(new Feature("mute"));
			features.add(new Feature("showtime"));
			features.add(new Feature("loadfolder"));
			features.add(new Feature("tracktime"));
			features.add(new Feature("shufflerepeat"));
			features.add(new Feature("ogg"));
			features.add(new Feature("mp3"));
			features.add(new Feature("skins"));
			features.add(new Feature("dark"));
			features.add(new Feature("choosefile"));
			features.add(new Feature("clearplaylist"));
			features.add(new Feature("showcover"));
		} else if (t == TargetSystem.FeatureAMP9) {
			features.add(new Feature("volumecontrol"));
			features.add(new Feature("skiptrack"));
			features.add(new Feature("removetrack"));
			features.add(new Feature("weichbrodt_featureamp"));
			features.add(new Feature("reorderplaylist"));
			features.add(new Feature("playlist"));
			features.add(new Feature("timedisplay"));
			features.add(new Feature("light"));
			features.add(new Feature("shuffleskipremove"));
			features.add(new Feature("saveandloadplaylist"));
			features.add(new Feature("gui"));
			features.add(new Feature("queuetrack"));
			features.add(new Feature("filesupport"));
			features.add(new Feature("progressbar"));
			features.add(new Feature("mute"));
			features.add(new Feature("showtime"));
			features.add(new Feature("showcover"));
			features.add(new Feature("loadfolder"));
			features.add(new Feature("shufflerepeat"));
			features.add(new Feature("ogg"));
			features.add(new Feature("mp3"));
			features.add(new Feature("skins"));
			features.add(new Feature("dark"));
			features.add(new Feature("clearplaylist"));

		}

		else if (t == TargetSystem.PAYCARD) {
			features.add(new Feature("logging"));
			features.add(new Feature("paycard"));
			features.add(new Feature("maximumrecord"));
			features.add(new Feature("lockout"));
		}
		else if(t == TargetSystem.ARGOUML) {
			features.add(new Feature("LOGGING"));
			features.add(new Feature("COGNITIVE"));
			features.add(new Feature("ACTIVITYDIAGRAM"));
			features.add(new Feature("COLLABORATIONDIAGRAM"));			
			features.add(new Feature("DEPLOYMENTDIAGRAM"));
			features.add(new Feature("SEQUENCEDIAGRAM"));
			features.add(new Feature("STATEDIAGRAM"));
			features.add(new Feature("USECASEDIAGRAM"));
		}
	}

	public void leitor(String arquivo) {

		File dir = new File(arquivo);
	    int chaves=0;
	    boolean feat=false;
		int contlinha=0;
		int posicaoFeature=0;
		boolean entrouMetodo=false;
		boolean entrouFeature=false;
	    ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();
		int cont2 = 0;
		for (int i = 0; i < listas.size(); i++) {

			if((listas.get(i).contains("public")||listas.get(i).contains("private") ||listas.get(i).contains("protected")) 
				&& !listas.get(i).contains("class") && !listas.get(i).contains(";")) {
				System.err.println("\t\t\tmetodo: " + listas.get(i));
				entrouMetodo=true;
			}
			
			if (listas.get(i).contains("if(Configuration.") || listas.get(i).contains("if (Configuration.")
					|| listas.get(i).contains("if(specifications.Configuration")
					|| listas.get(i).contains("if (specifications.Configuration")
					|| listas.get(i).contains("if(!Configuration.") || listas.get(i).contains("if (!Configuration.")
					|| listas.get(i).contains("if(!specifications.Configuration")
					|| listas.get(i).contains("if (!specifications.Configuration")) {
				System.out.println("Linha: " + (i + 1) + " " + listas.get(i));
				cont++;
				cont2++;
				feat=true;
				entrouFeature=true;	
				for (int x = 0; x < features.size(); x++) {
					if (listas.get(i).contains("Configuration." + features.get(x).nome + " ")
							|| listas.get(i).contains("Configuration." + features.get(x).nome + "&")
							|| listas.get(i).contains("Configuration." + features.get(x).nome + "|")
							|| listas.get(i).contains("Configuration." + features.get(x).nome + ")")) {
						features.get(x).quantidade++;
						featuresAux.get(x).quantidade++;
						
						posicaoFeature=x;
						contlinha=0;
						
						
					}
				}
			}
			if(feat && listas.get(i).contains("{")) {
				chaves++;
			}
			if(feat && listas.get(i).contains("}")) {
				chaves--;
			}
			if(feat && chaves==0 ) {
				feat=false;
				contlinha--;
//				features.get(posicaoFeature).LOC_InsideFeatures+=contlinha;
				somaFeature+=contlinha;
				System.out.println("quantidade de linhas da feature: "+ contlinha);
				contlinha=0;
			}
			
			if(feat && chaves!=0) {
				contlinha++;
			}
				
			
	         if(entrouMetodo && entrouFeature) {
	        	 contMetodo ++;
	        	 entrouMetodo=false; 
	        	 entrouFeature=false;
	         }
			
		}
		System.out.println("\t\tSomatorio local:" + cont2 + "  Somatorio total:" + cont );
		int total = 0;
		for (int x = 0; x < featuresAux.size(); x++) {
			if (featuresAux.get(x).quantidade != 0) {
//				System.out.println("\t\t\t\t{\"name\": \"" + featuresAux.get(x).nome + "\", \"value\":"
//						+ featuresAux.get(x).quantidade + ", \"fail\": 0},");
			espalhamento.get(x).quantidade++;
			}
			total += featuresAux.get(x).quantidade;
		}
		for (int x = 0; x < featuresAux.size(); x++) {
			featuresAux.get(x).quantidade = 0;
		}

	}

	public static void main(String[] args) {
		
		String path = "FeatureAMP2/";
		inicialization(TargetSystem.FeatureAMP2 );
		
		for (int x = 0; x < features.size(); x++) {
			featuresAux.add(new Feature(features.get(x).nome) );
			espalhamento.add(new Feature(features.get(x).nome) );			
		}
		
		
		String fileName;
		String fileNameAndPath = null;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		variabilityCount ler = new variabilityCount();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				fileName = listOfFiles[i].getName();
				try {
					fileNameAndPath = path + fileName;
					System.err.println(fileNameAndPath);
					nomeClasse = fileNameAndPath;
					ler.leitor(fileNameAndPath);
					
					
//					for (int x = 0; x < features.size(); x++) {
//						System.out.println(features.get(x).nome + "\t" + features.get(x).LOC_InsideFeatures);
//						somaFeature+=features.get(x).LOC_InsideFeatures;
//					}
					
					System.err.println("\n\n\n******** "+nomeClasse +": \t Methods With Feature Annotation : " +contMetodo);
					System.err.println("******** "+ nomeClasse + ": \t LOC_InsideFeatures: "+ somaFeature+ "\n\n\n");
					contMetodo=0;
                    for (int x = 0; x < features.size(); x++) {
						features.get(x).LOC_InsideFeatures=0;
					}
                    somaFeature=0;
				} catch (Exception e) {
					System.out.println(
							"Erro ao processar o arquivo %s com a mensagem: %s" + fileNameAndPath + e.getMessage());
				}
				// }
			}

		}
		System.out.print("\n somatório total de variabilidade: ");
		System.err.println(cont + "\n\n");
		System.out.println("\n\n\n somatório da variabilidade das features");
		
		Comparator crescente = new ComparadorDeFeature();
        Comparator decrescente = Collections.reverseOrder(crescente);
        Collections.sort (features, crescente);
        
		int total = 0;
		for (int x = 0; x < features.size(); x++) {
			System.out.println(features.get(x).nome + "\t" + features.get(x).quantidade);
			total += features.get(x).quantidade;
		}
		System.out.println("Total: \t" + total);
		
		System.out.println("\n\nEspalhamento de features.");
				
        Collections.sort (espalhamento, crescente);
        
		for (int x = 0; x < espalhamento.size(); x++) {
			System.out.println(espalhamento.get(x).nome + "\t" + espalhamento.get(x).quantidade);
		}
		
		System.out.println("\n\n\nnome  \t\t Occurrences \t Other Features");
		for (int x = 0; x < features.size(); x++) {
			if(features.get(x).quantidade!=0)
			System.out.println(features.get(x).nome + "\t\t" + features.get(x).quantidade +"\t"+ espalhamento.get(x).quantidade);
			
		}
		
		System.out.println("\n\nTodos os arquivos foram processados.");
	}


}