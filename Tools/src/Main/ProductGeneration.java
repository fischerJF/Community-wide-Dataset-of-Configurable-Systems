package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Combinations.FeatureCombination;
import Combinations.Combination;

public class ProductGeneration {

	public static ArrayList<Feature> features = new ArrayList<Feature>();
	public static List<String> listas;
	public static ArrayList<Combination> combinations = new ArrayList<Combination>();

	public static void leitor(String arquivo) {

		File dir = new File(arquivo);
		ReadFile l = new ReadFile(dir);

		listas = l.getListas();

	}

	public static void print() {

		boolean control;
		boolean valid = false;
		Combination combination = new Combination();
		FeatureCombination f;
		for (int i = 0; i < features.size(); i++) {
			control = false;

			for (int j = 0; j < listas.size(); j++) {
				if (features.get(i).nome.equals(listas.get(j))) {
					System.out.print(features.get(i).nome + ":true, ");
					control = true;
					valid = true;
					f = new FeatureCombination();
					f.setName(features.get(i).nome);
					f.setState("1");
					combination.add(f);
				}
			}
			if (!control) {
				System.out.print(features.get(i).nome + ":false, ");
				f = new FeatureCombination();
				f.setName(features.get(i).nome);
				f.setState("0");
				combination.add(f);
			}

		}
		System.out.println();

		if (valid)
			combinations.add(combination);
	}

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
			features.add(new Feature("Base"));
			features.add(new Feature("Weight"));
			features.add(new Feature("Empty"));
			features.add(new Feature("TwoThirdsFull"));
			features.add(new Feature("ExecutiveFloor"));
			features.add(new Feature("Overloaded"));
		}
		// Desktopsearcher
		else if (t == TargetSystem.DESCKTOPSEARCHER) {
			features.add(new Feature("Base"));
			features.add(new Feature("HTML"));
			features.add(new Feature("TXT"));
			features.add(new Feature("LATEX"));
			features.add(new Feature("User_Interface"));
			features.add(new Feature("Commandline"));
			features.add(new Feature("GUI"));
			features.add(new Feature("Gui_Preferences"));
			features.add(new Feature("Query_History"));
			features.add(new Feature("Index_History"));
			features.add(new Feature("Single_Directory"));
			features.add(new Feature("Multi_Directory"));
			features.add(new Feature("Normal_View"));
			features.add(new Feature("Tree_View"));
			features.add(new Feature("Windows"));
			features.add(new Feature("Linux"));
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
			features.add(new Feature("BANKACCOUNT"));
			features.add(new Feature("CREDITWORTHINESS"));
			features.add(new Feature("DAILYLIMIT"));
			features.add(new Feature("INTEREST"));
			features.add(new Feature("INTERESTESTIMATION"));
			features.add(new Feature("LOCK"));
			features.add(new Feature("LOGGING"));
			features.add(new Feature("OVERDRAFT"));
			features.add(new Feature("TRANSACTION"));
			features.add(new Feature("TRANSACTIONLOG"));
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
			features.add(new Feature("Base"));
			features.add(new Feature("highWaterSensor"));
			features.add(new Feature("lowWaterSensor"));
			features.add(new Feature("methaneQuery"));
			features.add(new Feature("methaneAlarm"));
			features.add(new Feature("stopCommand"));
			features.add(new Feature("startCommand"));
		}
		// set
		else if (t == TargetSystem.SET) {
			features.add(new Feature("Tree"));
			features.add(new Feature("IntegerSet"));
			features.add(new Feature("HashSet"));
		} else if (t == TargetSystem.UNIONFIND) {
			features.add(new Feature("WQU_ByHeight"));
			features.add(new Feature("QuickFind"));
			features.add(new Feature("QU_Weighted_Modifications"));
			features.add(new Feature("UnionFind"));
			features.add(new Feature("QU_Weighted"));
			features.add(new Feature("UnionFindSPL"));
			features.add(new Feature("QuickUnion"));
			features.add(new Feature("WQU_Halfing"));
			features.add(new Feature("WQU_PathCompression"));
			features.add(new Feature("tests"));
		}

		// Prop4j
		else if (t == TargetSystem.PROP4J) {
			features.add(new Feature("Prop4JSPL"));
			features.add(new Feature("Operators"));
			features.add(new Feature("And"));
			features.add(new Feature("Or"));
			features.add(new Feature("Implies"));
			features.add(new Feature("Negation"));
			features.add(new Feature("Equals"));
			features.add(new Feature("extended"));
			features.add(new Feature("AtLeast"));
			features.add(new Feature("AtMost"));
			features.add(new Feature("Choose"));
			features.add(new Feature("Input_Output"));
			features.add(new Feature("Node_Reader"));
			features.add(new Feature("Node_Writer"));
			features.add(new Feature("SatSolver"));
			features.add(new Feature("To_CNF"));
			features.add(new Feature("Tests"));
		}
		// FeatureAMP1
		else if (t == TargetSystem.FeatureAMP1) {
			features.add(new Feature("VolumeControl"));
			features.add(new Feature("SkipTrack"));
			features.add(new Feature("RemoveTrack"));
			features.add(new Feature("Time"));
			features.add(new Feature("Resizable"));
			features.add(new Feature("WAV"));
			features.add(new Feature("SupportedFormats"));
			features.add(new Feature("ReorderPlaylist"));
			features.add(new Feature("Playlist"));
			features.add(new Feature("Control"));
			features.add(new Feature("Light"));
			features.add(new Feature("SaveAndLoadPlaylist"));
			features.add(new Feature("GUI"));
			features.add(new Feature("FeatureAmp"));
			features.add(new Feature("QueueTrack"));
			features.add(new Feature("Mute"));
			features.add(new Feature("ProgressBar"));
			features.add(new Feature("ShowTime"));
			features.add(new Feature("ID3Information"));
			features.add(new Feature("ShowCover"));
			features.add(new Feature("LoadFolder"));
			features.add(new Feature("ShuffleRepeat"));
			features.add(new Feature("Base"));
			features.add(new Feature("MP3"));
			features.add(new Feature("Skins"));
			features.add(new Feature("Dark"));
			features.add(new Feature("OpenFile"));
			features.add(new Feature("ClearPlaylist"));
		}
		//
		// FeatureAMP2
		else if (t == TargetSystem.FeatureAMP2) {
			features.add(new Feature("SkipTrack"));
			features.add(new Feature("VolumeControl"));
			features.add(new Feature("LightSkin"));
			features.add(new Feature("RemoveTrack"));
			features.add(new Feature("Time"));
			features.add(new Feature("ReorderPlaylist"));
			features.add(new Feature("Playlist"));
			features.add(new Feature("DarkSkin"));
			features.add(new Feature("SaveAndLoadPlaylist"));
			features.add(new Feature("GUI"));
			features.add(new Feature("FeatureAMP"));
			features.add(new Feature("QueueTrack"));
			features.add(new Feature("ProgressBar"));
			features.add(new Feature("Mute"));
			features.add(new Feature("ShowTime"));
			features.add(new Feature("Player"));
			features.add(new Feature("ControlPlayist"));
			features.add(new Feature("ShowCover"));
			features.add(new Feature("LoadFolder"));
			features.add(new Feature("ShuffleRepeat"));
			features.add(new Feature("OGG"));
			features.add(new Feature("mp3"));
			features.add(new Feature("Skins"));
			features.add(new Feature("ClearPlaylist"));
		}
		// FeatureAMP3
		else if (t == TargetSystem.FeatureAMP3) {
			features.add(new Feature("SkipTrack"));
			features.add(new Feature("VolumeControl"));
			features.add(new Feature("PlaylistControl"));
			features.add(new Feature("RemoveTrack"));
			features.add(new Feature("Time"));
			features.add(new Feature("Wav"));
			features.add(new Feature("ReorderPlaylist"));
			features.add(new Feature("Mp3"));
			features.add(new Feature("Playlist"));
			features.add(new Feature("Light"));
			features.add(new Feature("SaveAndLoadPlaylist"));
			features.add(new Feature("ChangeListener"));
			features.add(new Feature("GUI"));
			features.add(new Feature("FeatureAmp"));
			features.add(new Feature("QueueTrack"));
			features.add(new Feature("FileSupport"));
			features.add(new Feature("PlaylistContextMenu"));
			features.add(new Feature("Mute"));
			features.add(new Feature("ProgressBar"));
			features.add(new Feature("TagEditor"));
			features.add(new Feature("ShowTime"));
			features.add(new Feature("Aac"));
			features.add(new Feature("LoadFolder"));
			features.add(new Feature("MultiplePlaylists"));
			features.add(new Feature("ShowCover"));
			features.add(new Feature("PlaylistMenu"));
			features.add(new Feature("ShuffleRepeat"));
			features.add(new Feature("Base"));
			features.add(new Feature("Ogg"));
			features.add(new Feature("PlaylistTabs"));
			features.add(new Feature("AddPlaylistWrapper"));
			features.add(new Feature("Skins"));
			features.add(new Feature("Dark"));
			features.add(new Feature("ClearPlaylist"));

		} else if (t == TargetSystem.FeatureAMP4) {
			features.add(new Feature("SKINS"));
			features.add(new Feature("PLAYER_CONTROL"));
			features.add(new Feature("REORDER_PLAYLIST"));
			features.add(new Feature("TITLE_TIME"));
			features.add(new Feature("SKIP_TRACK"));
			features.add(new Feature("PROGRESS"));
			features.add(new Feature("CLEAR_PLAYLIST"));
			features.add(new Feature("PROGRESS_BAR"));
			features.add(new Feature("VOLUME_CONTROL"));
			features.add(new Feature("REMOVE_TRACK"));
			features.add(new Feature("LIGHT"));
			features.add(new Feature("DARK"));
			features.add(new Feature("SHUFFLE_REPEAT"));
			features.add(new Feature("SHOW_COVER"));
			features.add(new Feature("OGG"));
			features.add(new Feature("MP3"));
			features.add(new Feature("SAVE_LOAD_PLAYLIST"));
			features.add(new Feature("BASE_FEATUREAMP"));
			features.add(new Feature("LOAD_FOLDER"));
			features.add(new Feature("QUEUE_TRACK"));
			features.add(new Feature("FILE_SUPPORT"));
			features.add(new Feature("PLAYER_BAR"));
			features.add(new Feature("MUTE"));
			features.add(new Feature("ID3_TITLE"));
			features.add(new Feature("PLAYLIST"));
		} else if (t == TargetSystem.FeatureAMP5) {
			features.add(new Feature("VolumeControl"));
			features.add(new Feature("SkipTrack"));
			features.add(new Feature("RemoveTrack"));
			features.add(new Feature("QueueRemove"));
			features.add(new Feature("ReorderPlaylist"));
			features.add(new Feature("Playlist"));
			features.add(new Feature("Light"));
			features.add(new Feature("SaveAndLoadPlaylist"));
			features.add(new Feature("GUI"));
			features.add(new Feature("FeatureAMP"));
			features.add(new Feature("QueueTrack"));
			features.add(new Feature("Mute"));
			features.add(new Feature("ProgressBar"));
			features.add(new Feature("Progress"));
			features.add(new Feature("ShowTime"));
			features.add(new Feature("PlaylistControls"));
			features.add(new Feature("ShowCover"));
			features.add(new Feature("LoadFolder"));
			features.add(new Feature("SkipRepeat"));
			features.add(new Feature("ShuffleRepeat"));
			features.add(new Feature("Base"));
			features.add(new Feature("Wave"));
			features.add(new Feature("MP3"));
			features.add(new Feature("Skins"));
			features.add(new Feature("Dark"));
			features.add(new Feature("ClearPlaylist"));
			features.add(new Feature("FileSupport"));
		} else if (t == TargetSystem.FeatureAMP6) {
			features.add(new Feature("SkipTrack"));
			features.add(new Feature("Metadata"));
			features.add(new Feature("RemoveTrack"));
			features.add(new Feature("Album"));
			features.add(new Feature("WAV"));
			features.add(new Feature("NiceToHave"));
			features.add(new Feature("Playlist"));
			features.add(new Feature("JumpPosition"));
			features.add(new Feature("Light"));
			features.add(new Feature("OpenFolder"));
			features.add(new Feature("GUI"));
			features.add(new Feature("FeatureAMP"));
			features.add(new Feature("QueueTrack"));
			features.add(new Feature("Mute"));
			features.add(new Feature("TagEditor"));
			features.add(new Feature("Tracknumber"));
			features.add(new Feature("Codecs"));
			features.add(new Feature("Progress"));
			features.add(new Feature("AAC"));
			features.add(new Feature("PlaylistControls"));
			features.add(new Feature("MultiplePlaylists"));
			features.add(new Feature("RandomColor"));
			features.add(new Feature("SaveandLoad"));
			features.add(new Feature("ShuffleRepeat"));
			features.add(new Feature("Base"));
			features.add(new Feature("OGG"));
			features.add(new Feature("YouTube"));
			features.add(new Feature("MP3"));
			features.add(new Feature("OSColors"));
			features.add(new Feature("Reorder"));
			features.add(new Feature("Cover"));
			features.add(new Feature("Volume"));
			features.add(new Feature("Skins"));
			features.add(new Feature("Dark"));
			features.add(new Feature("ClearPlaylist"));
			features.add(new Feature("RemeberStatus"));
			features.add(new Feature("Progressbar"));
			features.add(new Feature("Titlebar"));
		} else if (t == TargetSystem.FeatureAMP7) {
			features.add(new Feature("OpenWAVFile"));
			features.add(new Feature("VolumeControl"));
			features.add(new Feature("SkipTrack"));
			features.add(new Feature("MP3Player"));
			features.add(new Feature("RemoveTrack"));
			features.add(new Feature("Time"));
			features.add(new Feature("ChangePlaylist"));
			features.add(new Feature("OpenMP3File"));
			features.add(new Feature("ReorderPlaylist"));
			features.add(new Feature("Playlist"));
			features.add(new Feature("Light"));
			features.add(new Feature("SaveAndLoadPlaylist"));
			features.add(new Feature("GUI"));
			features.add(new Feature("AudioFormats"));
			features.add(new Feature("FeatureAmp"));
			features.add(new Feature("QueueTrack"));
			features.add(new Feature("Mute"));
			features.add(new Feature("ProgressBar"));
			features.add(new Feature("ShowTime"));
			features.add(new Feature("ShowTitle"));
			features.add(new Feature("WAVPlayer"));
			features.add(new Feature("LoadFolder"));
			features.add(new Feature("ShowCover"));
			features.add(new Feature("ShuffleRepeat"));
			features.add(new Feature("Skins"));
			features.add(new Feature("OrangeBlueST"));
			features.add(new Feature("Dark"));
			features.add(new Feature("OpenFile"));
			features.add(new Feature("ClearPlaylist"));
		} else if (t == TargetSystem.FeatureAMP8) {
			features.add(new Feature("VolumeControl"));
			features.add(new Feature("SkipTrack"));
			features.add(new Feature("PlayEngine"));
			features.add(new Feature("RemoveTrack"));
			features.add(new Feature("WAV"));
			features.add(new Feature("ReorderPlaylist"));
			features.add(new Feature("Playlist"));
			features.add(new Feature("Control"));
			features.add(new Feature("Light"));
			features.add(new Feature("SaveAndLoadPlaylist"));
			features.add(new Feature("GUI"));
			features.add(new Feature("FeatureAMP"));
			features.add(new Feature("FileSupport"));
			features.add(new Feature("QueueTrack"));
			features.add(new Feature("ProgressBar"));
			features.add(new Feature("Mute"));
			features.add(new Feature("ShowTime"));
			features.add(new Feature("LoadFolder"));
			features.add(new Feature("TrackTime"));
			features.add(new Feature("ShuffleRepeat"));
			features.add(new Feature("OGG"));
			features.add(new Feature("MP3"));
			features.add(new Feature("Skins"));
			features.add(new Feature("Dark"));
			features.add(new Feature("ChooseFile"));
			features.add(new Feature("ClearPlaylist"));
			features.add(new Feature("showCover"));
		} else if (t == TargetSystem.FeatureAMP9) {
			features.add(new Feature("VolumeControl"));
			features.add(new Feature("SkipTrack"));
			features.add(new Feature("RemoveTrack"));
			features.add(new Feature("WEICHBRODT_featureAMP"));
			features.add(new Feature("ReorderPlaylist"));
			features.add(new Feature("Playlist"));
			features.add(new Feature("TimeDisplay"));
			features.add(new Feature("Light"));
			features.add(new Feature("ShuffleSkipRemove"));
			features.add(new Feature("SaveAndLoadPlaylist"));
			features.add(new Feature("GUI"));
			features.add(new Feature("QueueTrack"));
			features.add(new Feature("FileSupport"));
			features.add(new Feature("ProgressBar"));
			features.add(new Feature("Mute"));
			features.add(new Feature("ShowTime"));
			features.add(new Feature("ShowCover"));
			features.add(new Feature("LoadFolder"));
			features.add(new Feature("ShuffleRepeat"));
			features.add(new Feature("OGG"));
			features.add(new Feature("MP3"));
			features.add(new Feature("Skins"));
			features.add(new Feature("Dark"));
			features.add(new Feature("ClearPlaylist"));
		}

		else if (t == TargetSystem.PAYCARD) {
			features.add(new Feature("Logging"));
			features.add(new Feature("Paycard"));
			features.add(new Feature("MaximumRecord"));
			features.add(new Feature("LockOut"));
		} else if (t == TargetSystem.CHECKSTYLE) {
			features.add(new Feature("ArrayTypeStyle"));
			features.add(new Feature("AvoidEscapedUnicodeCharacters"));
			features.add(new Feature("FinalParameters"));
			features.add(new Feature("NewlineAtEndOfFile"));
			features.add(new Feature("OuterTypeFilename"));
			features.add(new Feature("Regexp"));
			features.add(new Feature("RegexpignoreComments"));
			features.add(new Feature("RegexpillegalPattern"));
			features.add(new Feature("RegexpcheckForDuplicates"));
			features.add(new Feature("TodoComment"));
			features.add(new Feature("TrailingComment"));
			features.add(new Feature("Translation"));
			features.add(new Feature("UncommentedMain"));
			features.add(new Feature("UpperEll"));
			features.add(new Feature("AnnotationLocation"));
			features.add(new Feature("AnnotationUseStyle"));
			features.add(new Feature("MissingDeprecated"));
			features.add(new Feature("MissingOverride"));
			features.add(new Feature("PackageAnnotation"));
			features.add(new Feature("SuppressWarnings"));
			features.add(new Feature("AvoidNestedBlocks"));
			features.add(new Feature("EmptyBlock"));
			features.add(new Feature("EmptyCatchBlock"));
			features.add(new Feature("LeftCurly"));
			features.add(new Feature("NeedBraces"));
			features.add(new Feature("NeedBracesAllowSingleLineIf"));
			features.add(new Feature("RightCurly"));
			features.add(new Feature("ArrayTrailingComma"));
			features.add(new Feature("AvoidInlineConditionals"));
			features.add(new Feature("CovariantEquals"));
			features.add(new Feature("DeclarationOrder"));
			features.add(new Feature("DefaultComesLast"));
			features.add(new Feature("EmptyStatement"));
			features.add(new Feature("EqualsAvoidNull"));
			features.add(new Feature("EqualsHashCode"));
			features.add(new Feature("ExplicitInitialization"));
			features.add(new Feature("FallThrough"));
			features.add(new Feature("FinalLocalVariable"));
			features.add(new Feature("HiddenField"));
			features.add(new Feature("IllegalCatch"));
			features.add(new Feature("IllegalInstantiation"));
			features.add(new Feature("IllegalThrows"));
			features.add(new Feature("IllegalToken"));
			features.add(new Feature("TW"));
			features.add(new Feature("RegexpMultiline"));
			features.add(new Feature("RegexpSingleline"));
			features.add(new Feature("RegexpSinglelineJava"));
			features.add(new Feature("HeaderCheck"));
			features.add(new Feature("RegexpHeaderCheck"));
			features.add(new Feature("AvoidStarImportCheck"));
			features.add(new Feature("CustomImportOrder"));
			features.add(new Feature("IllegalImport"));
			features.add(new Feature("ImportControl"));
			features.add(new Feature("ImportOrder"));
			features.add(new Feature("RedundantImport"));
			features.add(new Feature("UnusedImports"));
			features.add(new Feature("BooleanExpressionComplexity"));
			features.add(new Feature("ClassDataAbstractionCouplingCheck"));
			features.add(new Feature("ClassFanOutComplexityCheck"));
			features.add(new Feature("CyclomaticComplexity"));
			features.add(new Feature("JavaNCSS"));
			features.add(new Feature("NPathComplexity"));
			features.add(new Feature("ModifierOrder"));
			features.add(new Feature("RedundantModifier"));
			features.add(new Feature("DesignForExtension"));
			features.add(new Feature("HideUtilityClassConstructor"));
			features.add(new Feature("InnerTypeLast"));
			features.add(new Feature("InterfaceIsType"));
			features.add(new Feature("OneTopLevelClass"));
			features.add(new Feature("ThrowsCount"));
			features.add(new Feature("VisibilityModifier"));
			features.add(new Feature("IllegalTypeCheck"));
			features.add(new Feature("InnerAssignment"));
			features.add(new Feature("MagicNumber"));
			features.add(new Feature("MissingCtor"));
			features.add(new Feature("MissingSwitchDefault"));
			features.add(new Feature("ModifiedControlVariable"));
			features.add(new Feature("MultipleStringLiterals"));
			features.add(new Feature("MultipleVariableDeclarations"));
			features.add(new Feature("NestedForDepth"));
			features.add(new Feature("FinalClass"));
			features.add(new Feature("MutableExceptionCheck"));
			features.add(new Feature("IllegalTokenTextCheck"));
			features.add(new Feature("Indentation"));
			features.add(new Feature("IndentationForceStrictCondition"));
			features.add(new Feature("NestedIfDepth"));
			features.add(new Feature("NestedTryDepth"));
			features.add(new Feature("NoClone"));
			features.add(new Feature("NoFinalizer"));
			features.add(new Feature("OneStatementPerLine"));
			features.add(new Feature("OverloadMethodsDeclarationOrder"));
			features.add(new Feature("PackageDeclaration"));
			features.add(new Feature("ParameterAssignment"));
			features.add(new Feature("RequireThis"));
			features.add(new Feature("ReturnCountCheck"));
			features.add(new Feature("SimplifyBooleanExpression"));
			features.add(new Feature("SimplifyBooleanReturn"));
			features.add(new Feature("StringLiteralEquality"));
			features.add(new Feature("SuperClone"));
			features.add(new Feature("SuperFinalize"));
			features.add(new Feature("UnnecessaryParentheses"));
			features.add(new Feature("VariableDeclarationUsageDistance"));
			features.add(new Feature("AtclauseOrder"));
			features.add(new Feature("JavadocMethod"));
			features.add(new Feature("JavadocPackage"));
			features.add(new Feature("JavadocParagraph"));
			features.add(new Feature("JavadocStyle"));
			features.add(new Feature("JavadocTagContinuationIndentation"));
			features.add(new Feature("JavadocType"));
			features.add(new Feature("JavadocVariable"));
			features.add(new Feature("NonEmptyAtclauseDescription"));
			features.add(new Feature("SingleLineJavadoc"));
			features.add(new Feature("SummaryJavadoc"));
			features.add(new Feature("WriteTag"));
			features.add(new Feature("AbbreviationAsWordInName"));
			features.add(new Feature("AbbreviationAsWordInNameignoreFinal"));
			features.add(new Feature("AbbreviationAsWordInNameignoreStatic"));
			features.add(new Feature("AbbreviationAsWordInNameignoreOverriddenMethods"));
			features.add(new Feature("AbstractClassName"));
			features.add(new Feature("AbstractClassNameignoreModifier"));
			features.add(new Feature("AbstractClassNameignoreName"));
			features.add(new Feature("ClassTypeParameterName"));
			features.add(new Feature("ConstantName"));
			features.add(new Feature("InterfaceTypeParameterName"));
			features.add(new Feature("LocalFinalVariableName"));
			features.add(new Feature("LocalVariableName"));
			features.add(new Feature("LocalVariableNameallowOneCharVarInForLoop"));
			features.add(new Feature("MemberName"));
			features.add(new Feature("MethodName"));
			features.add(new Feature("MethodNameallowClassName"));
			features.add(new Feature("MethodTypeParameterName"));
			features.add(new Feature("PackageName"));
			features.add(new Feature("ParameterName"));
			features.add(new Feature("StaticVariableName"));
			features.add(new Feature("TypeName"));
			features.add(new Feature("AnonInnerLength"));
			features.add(new Feature("ExecutableStatementCount"));
			features.add(new Feature("FileLength"));
			features.add(new Feature("LineLength"));
			features.add(new Feature("MethodCount"));
			features.add(new Feature("MethodLength"));
			features.add(new Feature("OuterTypeNumber"));
			features.add(new Feature("ParameterNumber"));
			features.add(new Feature("EmptyForIteratorPad"));
			features.add(new Feature("EmptyLineSeparator"));
			features.add(new Feature("EmptyLineSeparatorallowNoEmptyLineBetweenFields"));
			features.add(new Feature("EmptyLineSeparatorallowMultipleEmptyLines"));
			features.add(new Feature("FileTabCharacter"));
			features.add(new Feature("GenericWhitespace"));
			features.add(new Feature("MethodParamPad"));
			features.add(new Feature("NoLineWrap"));
			features.add(new Feature("NoWhitespaceAfter"));
			features.add(new Feature("NoWhitespaceBefore"));
			features.add(new Feature("OperatorWrap"));
			features.add(new Feature("ParenPad"));
			features.add(new Feature("SeparatorWrap"));
			features.add(new Feature("TypecastParenPad"));
			features.add(new Feature("WhitespaceAfter"));
			features.add(new Feature("WhitespaceAround"));
			features.add(new Feature("WhitespaceAroundAllowEmptyCtors"));
			features.add(new Feature("WhitespaceAroundAllowEmptyMethods"));
			features.add(new Feature("WhitespaceAroundAllowEmptyTypes"));
			features.add(new Feature("WhitespaceAroundAllowEmptyLoops"));
			features.add(new Feature("WhitespaceAroundIgnoreEnhancedForColon"));
		} else if (t == TargetSystem.ARGO) {
			features.add(new Feature("LOGGING"));
			features.add(new Feature("COGNITIVE"));
			features.add(new Feature("ACTIVITYDIAGRAM"));
			features.add(new Feature("COLLABORATIONDIAGRAM"));
			features.add(new Feature("DEPLOYMENTDIAGRAM"));
			features.add(new Feature("SEQUENCEDIAGRAM"));
			features.add(new Feature("STATEDIAGRAM"));
			features.add(new Feature("USECASEDIAGRAM"));
		} else if (t == TargetSystem.VISTEX) {
			features.add(new Feature("SPEICHERN"));
			features.add(new Feature("FORMATIERUNG"));
			features.add(new Feature("EDIEREN"));
			features.add(new Feature("KOMPRIMIERTERTEXT"));
			features.add(new Feature("VISTEX"));
			features.add(new Feature("UNDO"));
			features.add(new Feature("SUCHEN"));
			features.add(new Feature("FARBE"));
			features.add(new Feature("GRAPHANZEIGE"));
			features.add(new Feature("ERSETZEN"));
			features.add(new Feature("GRAPHBEARBEITUNG"));
			features.add(new Feature("EDITOR"));
			features.add(new Feature("TEXTFORMAT"));
			features.add(new Feature("HMTL"));
			features.add(new Feature("SCHRIFTGROESSE"));
			features.add(new Feature("EXPORTIEREN"));
		} else if (t == TargetSystem.WEBSTORE1) {
			features.add(new Feature("BACKEND"));
			features.add(new Feature("WEBSTORE"));
			features.add(new Feature("CHECKOUT"));
			features.add(new Feature("FRONTEND"));
			features.add(new Feature("BASICFRONTENDDEFINITIONS"));
			features.add(new Feature("PRODUCTMANAGEMENT"));
			features.add(new Feature("BASICBACKENDDEFINITIONS"));
			features.add(new Feature("BASICPAYMENTDEFINITIONS"));
			features.add(new Feature("BASE"));
		} else if (t == TargetSystem.WEBSTORE2) {
			features.add(new Feature("WEBSTORE"));
			features.add(new Feature("BASE"));
			features.add(new Feature("BACKEND"));
			features.add(new Feature("BASICBACKENDDEFINITIONS"));
			features.add(new Feature("PRODUCTMANAGEMENT"));
			features.add(new Feature("FRONTEND"));
			features.add(new Feature("BASICFRONTENDDEFINITIONS"));
			features.add(new Feature("CHECKOUT"));
			features.add(new Feature("PAYMENT"));
			features.add(new Feature("BASICPAYMENTDEFINITIONS"));
			features.add(new Feature("BANKSLIP"));
			features.add(new Feature("PAYPAL"));
		} else if (t == TargetSystem.WEBSTORE3) {
			features.add(new Feature("PAYPAL"));
			features.add(new Feature("BANKSLIP"));
			features.add(new Feature("BASICFRONTENDDEFINITIONS"));
			features.add(new Feature("BASE"));
			features.add(new Feature("BACKEND"));
			features.add(new Feature("PAYMENT"));
			features.add(new Feature("WEBSTORE"));
			features.add(new Feature("CHECKOUT"));
			features.add(new Feature("FRONTEND"));
			features.add(new Feature("CONTENTMANAGEMENT"));
			features.add(new Feature("PRODUCTMANAGEMENT"));
			features.add(new Feature("CATEGORYMANAGEMENT"));
			features.add(new Feature("BASICBACKENDDEFINITIONS"));
			features.add(new Feature("BASICPAYMENTDEFINITIONS"));
		} else if (t == TargetSystem.WEBSTORE4) {
			features.add(new Feature("PAYPAL"));
			features.add(new Feature("BANKSLIP"));
			features.add(new Feature("DISPLAYOPTIONS"));
			features.add(new Feature("BASICFRONTENDDEFINITIONS"));
			features.add(new Feature("DISPLAYBYCATEGORY"));
			features.add(new Feature("BASE"));
			features.add(new Feature("BACKEND"));
			features.add(new Feature("PAYMENT"));
			features.add(new Feature("WEBSTORE"));
			features.add(new Feature("CHECKOUT"));
			features.add(new Feature("FRONTEND"));
			features.add(new Feature("CONTENTMANAGEMENT"));
			features.add(new Feature("PRODUCTMANAGEMENT"));
			features.add(new Feature("CATEGORYMANAGEMENT"));
			features.add(new Feature("BASICBACKENDDEFINITIONS"));
			features.add(new Feature("BASICPAYMENTDEFINITIONS"));
		} else if (t == TargetSystem.WEBSTORE5) {
			features.add(new Feature("PAYPAL"));
			features.add(new Feature("BANKSLIP"));
			features.add(new Feature("DISPLAYOPTIONS"));
			features.add(new Feature("BASICFRONTENDDEFINITIONS"));
			features.add(new Feature("DISPLAYBYCATEGORY"));
			features.add(new Feature("BASE"));
			features.add(new Feature("BACKEND"));
			features.add(new Feature("PAYMENT"));
			features.add(new Feature("WEBSTORE"));
			features.add(new Feature("CHECKOUT"));
			features.add(new Feature("FRONTEND"));
			features.add(new Feature("DISPLAYWHATISNEW"));
			features.add(new Feature("CONTENTMANAGEMENT"));
			features.add(new Feature("PRODUCTMANAGEMENT"));
			features.add(new Feature("CATEGORYMANAGEMENT"));
			features.add(new Feature("BASICBACKENDDEFINITIONS"));
			features.add(new Feature("BASICPAYMENTDEFINITIONS"));
		} else if (t == TargetSystem.WEBSTORE6) {
			features.add(new Feature("LOGGING"));
			features.add(new Feature("PAYPAL"));
			features.add(new Feature("BANKSLIP"));
			features.add(new Feature("DISPLAYOPTIONS"));
			features.add(new Feature("BASICFRONTENDDEFINITIONS"));
			features.add(new Feature("DISPLAYBYCATEGORY"));
			features.add(new Feature("LOGIN"));
			features.add(new Feature("BASE"));
			features.add(new Feature("BACKEND"));
			features.add(new Feature("PAYMENT"));
			features.add(new Feature("WEBSTORE"));
			features.add(new Feature("CHECKOUT"));
			features.add(new Feature("FRONTEND"));
			features.add(new Feature("DISPLAYWHATISNEW"));
			features.add(new Feature("CONTENTMANAGEMENT"));
			features.add(new Feature("PRODUCTMANAGEMENT"));
			features.add(new Feature("CATEGORYMANAGEMENT"));
			features.add(new Feature("BASICBACKENDDEFINITIONS"));
			features.add(new Feature("BASICPAYMENTDEFINITIONS"));
		} else if (t == TargetSystem.MobileMedia1) {
			features.add(new Feature("CREATEALBUM"));
			features.add(new Feature("CREATEPHOTO"));
			features.add(new Feature("DELETEPHOTO"));
			features.add(new Feature("DELETEALBUM"));
			features.add(new Feature("ALBUMMANAGEMENT"));
			features.add(new Feature("BASICPHOTOOPERATIONS"));
			features.add(new Feature("VIEWPHOTO"));
			features.add(new Feature("MOBILEMEDIASPLFOP_001"));
			features.add(new Feature("BASE"));
			features.add(new Feature("PHOTOMANAGEMENT"));
		} else if (t == TargetSystem.DIGRAPH) {
			features.add(new Feature("REMOVAL"));
			features.add(new Feature("DIGRAPH"));
			features.add(new Feature("TRANSPOSABLE"));
			features.add(new Feature("SEARCHABLE"));
		} else if (t == TargetSystem.EPL) {
			features.add(new Feature("PP"));
			features.add(new Feature("CE"));
			features.add(new Feature("NP"));
			features.add(new Feature("BE"));
			features.add(new Feature("EXPRESSIONPRODUCTLINE"));
			features.add(new Feature("NUM"));
			features.add(new Feature("CK"));
			features.add(new Feature("BK"));
			features.add(new Feature("STRUCTS"));
			features.add(new Feature("DERIVATIVES"));
			features.add(new Feature("CP"));
			features.add(new Feature("BP"));
			features.add(new Feature("PRINT"));
			features.add(new Feature("NEG"));
			features.add(new Feature("KORE"));
			features.add(new Feature("PE"));
			features.add(new Feature("NE"));
			features.add(new Feature("PK"));
			features.add(new Feature("PLUS"));
			features.add(new Feature("OPERATIONS"));
			features.add(new Feature("EVAL"));
			features.add(new Feature("NK"));
			features.add(new Feature("CORE"));
		} else if (t == TargetSystem.BANKACCOUNT_2) {
			features.add(new Feature("OVERDRAFT"));
			features.add(new Feature("INTEREST"));
			features.add(new Feature("INTERESTESTIMATION"));
			features.add(new Feature("TRANSACTION"));
			features.add(new Feature("DAILYLIMIT"));
			features.add(new Feature("CREDITWORTHINESS"));
			features.add(new Feature("BANKACCOUNT"));
			features.add(new Feature("LOCK"));
		} else if (t == TargetSystem.GAME_OF_LIVE) {
			features.add(new Feature("OPTIONS"));
			features.add(new Feature("DEFAULTGENERATOR"));
			features.add(new Feature("CONCRETGENERATOR"));
			features.add(new Feature("GUIBASE"));
			features.add(new Feature("IO"));
			features.add(new Feature("ABSTRACTGENERATOR"));
			features.add(new Feature("FORMDEFAULTGENERATOR"));
			features.add(new Feature("MODELBASE"));
			features.add(new Feature("FORMGENERATOR"));
			features.add(new Feature("UNDOREDOGENERATOR"));
			features.add(new Feature("VIEW"));
			features.add(new Feature("RANDOMGENERATOR"));
			features.add(new Feature("UNDOREDOTEST"));
			features.add(new Feature("GENERATORSELECTION"));
			features.add(new Feature("POPUPMENU"));
			features.add(new Feature("COMPOSED"));
			features.add(new Feature("TEST"));
			features.add(new Feature("GAMEOFLIFE"));
			features.add(new Feature("UNDOREDOGUIBASE"));
			features.add(new Feature("MODEL"));
			features.add(new Feature("UNDOREDO"));
			features.add(new Feature("RANDOMDEFAULTGENERATOR"));
			features.add(new Feature("GENERATOR"));
		} else if (t == TargetSystem.GPL_2) {
			features.add(new Feature("DIRECTEDWITHNEIGHBORS"));
			features.add(new Feature("GPL"));
			features.add(new Feature("GTP"));
			features.add(new Feature("UNDIRECTEDWITHNEIGHBORS"));
			features.add(new Feature("UNWEIGHTED"));
			features.add(new Feature("CONNECTED"));
			features.add(new Feature("SRC"));
			features.add(new Feature("WGT"));
			features.add(new Feature("HIDDENGTP"));
			features.add(new Feature("DIRECTEDWITHEDGES"));
			features.add(new Feature("MAINGPL"));
			features.add(new Feature("STRONGLYCONNECTED"));
			features.add(new Feature("HIDDENWGT"));
			features.add(new Feature("BFS"));
			features.add(new Feature("IMPLEMENTATION"));
			features.add(new Feature("DFS"));
			features.add(new Feature("TESTPROG"));
			features.add(new Feature("MSTPRIM"));
			features.add(new Feature("WEIGHTED"));
			features.add(new Feature("NUMBER"));
			features.add(new Feature("WEIGHTEDONLYVERTICES"));
			features.add(new Feature("UNDIRECTEDONLYVERTICES"));
			features.add(new Feature("WITHNEIGHBORS"));
			features.add(new Feature("ONLYVERTICES"));
			features.add(new Feature("TRANSPOSE"));
			features.add(new Feature("DIRECTED"));
			features.add(new Feature("DIRECTEDONLYVERTICES"));
			features.add(new Feature("WEIGHTOPTIONS"));
			features.add(new Feature("CYCLE"));
			features.add(new Feature("BASE"));
			features.add(new Feature("MSTKRUSKAL"));
			features.add(new Feature("WEIGHTEDWITHEDGES"));
			features.add(new Feature("UNDIRECTEDWITHEDGES"));
			features.add(new Feature("WITHEDGES"));
			features.add(new Feature("UNDIRECTED"));
			features.add(new Feature("WEIGHTEDWITHNEIGHBORS"));
			features.add(new Feature("ALG"));
			features.add(new Feature("STRONGC"));
		} else if (t == TargetSystem.PREVAYLER) {
			features.add(new Feature("SNAPSHOT"));
			features.add(new Feature("PREVAYLERSPL"));
			features.add(new Feature("MONITOR"));
			features.add(new Feature("REPLICATION"));
			features.add(new Feature("GZIP"));
			features.add(new Feature("CENSOR"));
			features.add(new Feature("SPL"));
		} else if (t == TargetSystem.BERKELEY_DB) {
			features.add(new Feature("FSYNC"));
			features.add(new Feature("LOGGINGEVICTOR"));
			features.add(new Feature("DISKFULLERRO"));
			features.add(new Feature("VERIFIER"));
			features.add(new Feature("CONCURRTRANS"));
			features.add(new Feature("DERIVATIVE_LATCHES_EVICTOR"));
			features.add(new Feature("DERIVATIVE_LATCHES_CHECKLEAKS"));
			features.add(new Feature("CHECKSUM"));
			features.add(new Feature("DERIVATIVE_LOOKAHEADCACHE_EVICTOR_CRITICALEVICTION"));
			features.add(new Feature("DERIVATIVE_LATCHES_RENAMEOP"));
			features.add(new Feature("DERIVATIVE_STATISTICS_VERIFIER"));
			features.add(new Feature("DERIVATIVES"));
			features.add(new Feature("DERIVATIVE_INCOMPRESSOR_DELETEOP"));
			features.add(new Feature("CRITICALEVICTION"));
			features.add(new Feature("DERIVATIVE_FSYNC_LATCHES"));
			features.add(new Feature("CLEANERDAEMON"));
			features.add(new Feature("IO"));
			features.add(new Feature("DERIVATIVE_LOGGINGSEVERE_LOGGINGBASE"));
			features.add(new Feature("DERIVATIVE_LOGGINGFILEHANDLER_LOGGINGBASE"));
			features.add(new Feature("IIO"));
			features.add(new Feature("DERIVATIVE_LATCHES_INCOMPRESSOR"));
			features.add(new Feature("DERIVATIVE_LATCHES_FILEHANDLECACHE"));
			features.add(new Feature("TRANSACTIONS"));
			features.add(new Feature("DERIVATIVE_LOGGINGEVICTOR_EVICTOR"));
			features.add(new Feature("DERIVATIVE_LOGGINGFINEST_TRUNCATEOP"));
			features.add(new Feature("MEMORYBUDGET"));
			features.add(new Feature("CPTIME"));
			features.add(new Feature("DERIVATIVE_STATISTICS_INCOMPRESSOR"));
			features.add(new Feature("CHECKPOINTER"));
			features.add(new Feature("DERIVATIVE_LOOKAHEADCACHE_STATISTICS"));
			features.add(new Feature("DERIVATIVE_LATCHES_STATISTICS_VERIFIER"));
			features.add(new Feature("PERSISTANCE"));
			features.add(new Feature("EVICTORDAEMON"));
			features.add(new Feature("LOGGINGFINE"));
			features.add(new Feature("DERIVATIVE_LOGGINGINFO_MEMORYBUDGET"));
			features.add(new Feature("LOGGINGDBLOGHANDLER"));
			features.add(new Feature("LOOKAHEADCACHE"));
			features.add(new Feature("DIRECTNIO"));
			features.add(new Feature("DERIVATIVE_LOGGINGFINE_INCOMPRESSOR"));
			features.add(new Feature("DERIVATIVE_EVICTOR_MEMORYBUDGET_CRITICALEVICTION"));
			features.add(new Feature("LOGGINGINFO"));
			features.add(new Feature("CPBYTES"));
			features.add(new Feature("DERIVATIVE_LOGGINGEVICTOR_STATISTICS_EVICTOR_LOGGINGBASE"));
			features.add(new Feature("LOGGINGCONSOLEHANDLER"));
			features.add(new Feature("DERIVATIVE_LOGGINGFINER_LOGGINGBASE"));
			features.add(new Feature("LOGGINGRECOVERY"));
			features.add(new Feature("DERIVATIVE_STATISTICS_VERIFIER_DELETEOP"));
			features.add(new Feature("STATISTICS"));
			features.add(new Feature("DERIVATIVE_STATISTICS_VERIFIER_INCOMPRESSOR"));
			features.add(new Feature("DERIVATIVE_LOGGINGFINE_LOGGINGBASE"));
			features.add(new Feature("DERIVATIVE_FSYNC_STATISTICS"));
			features.add(new Feature("IICLEANER"));
			features.add(new Feature("LOGGINGBASE"));
			features.add(new Feature("DERIVATIVE_LATCHES_TRUNCATEOP"));
			features.add(new Feature("DERIVATIVE_LATCHES_VERIFIER_INCOMPRESSOR"));
			features.add(new Feature("DERIVATIVE_LOGGINGCLEANER_DELETEOP"));
			features.add(new Feature("DERIVATIVE_STATISTICS_DELETEOP"));
			features.add(new Feature("SPL"));
			features.add(new Feature("DERIVATIVE_CHECKPOINTERDAEMON_CPBYTES"));
			features.add(new Feature("DERIVATIVE_LATCHES_DELETEOP"));
			features.add(new Feature("DERIVATIVE_LOGGINGFINEST_LOGGINGBASE"));
			features.add(new Feature("OPS"));
			features.add(new Feature("DERIVATIVE_LOGGINGCONSOLEHANDLER_LOGGINGBASE"));
			features.add(new Feature("DERIVATIVE_LOGGINGCONFIG_STATISTICS"));
			features.add(new Feature("DERIVATIVE_LATCHES_STATISTICS"));
			features.add(new Feature("LOGGING"));
			features.add(new Feature("LATCHES"));
			features.add(new Feature("DERIVATIVE_DELETEOP_EVICTOR"));
			features.add(new Feature("DERIVATIVE_DELETEOP_TRUNCATEOP"));
			features.add(new Feature("EVICTOR"));
			features.add(new Feature("DERIVATIVE_LOGGINGFINEST_CPTIME"));
			features.add(new Feature("DERIVATIVE_EVICTOR_CRITICALEVICTION"));
			features.add(new Feature("DERIVATIVE_IO_SYNCHRONIZEDIO"));
			features.add(new Feature("DERIVATIVE_STATISTICS_EVICTOR"));
			features.add(new Feature("CHECKLEAKS"));
			features.add(new Feature("DERIVATIVE_EVICTOR_EVICTORDAEMON"));
			features.add(new Feature("DELETEOP"));
			features.add(new Feature("DERIVATIVE_STATISTICS_CHECKLEAKS"));
			features.add(new Feature("ENVIRONMENTLOCKING"));
			features.add(new Feature("DERIVATIVE_VERIFIER_INCOMPRESSOR"));
			features.add(new Feature("DERIVATIVE_STATISTICS_MEMORYBUDGET"));
			features.add(new Feature("LOGGINGSEVERE"));
			features.add(new Feature("BTREE"));
			features.add(new Feature("DERIVATIVE_INCOMPRESSOR_EVICTOR"));
			features.add(new Feature("DERIVATIVE_LOGGINGFINEST_CPBYTES"));
			features.add(new Feature("NIOACCESS"));
			features.add(new Feature("FILEHANDLECACHE"));
			features.add(new Feature("DERIVATIVE_DELETEOP_MEMORYBUDGET"));
			features.add(new Feature("DERIVATIVE_EVICTOR_MEMORYBUDGET"));
			features.add(new Feature("GENERATEDSPL"));
			features.add(new Feature("SYNCHRONIZEDIO"));
			features.add(new Feature("CHECKPOINTERDAEMON"));
			features.add(new Feature("LOGGINGFINEST"));
			features.add(new Feature("NEWIO"));
			features.add(new Feature("DERIVATIVE_NIO_CHUNKEDNIO"));
			features.add(new Feature("DERIVATIVE_LOGGINGEVICTOR_EVICTOR_LOGGINGBASE"));
			features.add(new Feature("DERIVATIVE_LOGGINGEVICTOR_EVICTOR_MEMORYBUDGET_LOGGINGBASE"));
			features.add(new Feature("DERIVATIVE_LOOKAHEADCACHE_MEMORYBUDGET"));
			features.add(new Feature("CLEANER"));
			features.add(new Feature("LOGGINGFILEHANDLER"));
			features.add(new Feature("TRUNCATEOP"));
			features.add(new Feature("DERIVATIVE_LATCHES_MEMORYBUDGET"));
			features.add(new Feature("DERIVATIVE_LOGGINGRECOVERY_LOGGINGBASE"));
			features.add(new Feature("OLDIO"));
			features.add(new Feature("DERIVATIVE_LOGGINGSEVERE_ENVIRONMENTLOCKING"));
			features.add(new Feature("INCOMPRESSOR"));
			features.add(new Feature("LOGGINGFINER"));
			features.add(new Feature("RENAMEOP"));
			features.add(new Feature("DERIVATIVE_LOGGINGINFO_STATISTICS_VERIFIER"));
			features.add(new Feature("DERIVATIVE_LOGGINGDBLOGHANDLER_LOGGINGBASE"));
			features.add(new Feature("NIO"));
			features.add(new Feature("IEVICTOR"));
			features.add(new Feature("DERIVATIVE_INCOMPRESSOR_EVICTOR_CRITICALEVICTION"));
			features.add(new Feature("LOGGINGCONFIG"));
			features.add(new Feature("LOGGINGCLEANER"));
			features.add(new Feature("CHUNKEDNIO"));
			features.add(new Feature("DERIVATIVE_CPBYTES_CPTIME"));
			features.add(new Feature("DERIVATIVE_LOGGINGCLEANER_LOGGINGBASE"));
			features.add(new Feature("BASE"));
		} else if (t == TargetSystem.NOTEPAD_3) {
			features.add(new Feature("NOTEPAD"));
			features.add(new Feature("CUT"));
			features.add(new Feature("FINDER"));
			features.add(new Feature("UNDO"));
		} else if (t == TargetSystem.MobileMedia2) {
			features.add(new Feature("CREATEALBUM"));
			features.add(new Feature("EDITPHOTOLABEL"));
			features.add(new Feature("DELETEALBUM"));
			features.add(new Feature("BASICPHOTOOPERATIONS"));
			features.add(new Feature("MOBILEMEDIASPLFOP_002"));
			features.add(new Feature("BASE"));
			features.add(new Feature("SORTING"));
			features.add(new Feature("CREATEPHOTO"));
			features.add(new Feature("DELETEPHOTO"));
			features.add(new Feature("ALBUMMANAGEMENT"));
			features.add(new Feature("VIEWPHOTO"));
			features.add(new Feature("PHOTOMANAGEMENT"));
		} else if (t == TargetSystem.MobileMedia3) {
			features.add(new Feature("CREATEALBUM"));
			features.add(new Feature("EDITPHOTOLABEL"));
			features.add(new Feature("DELETEALBUM"));
			features.add(new Feature("MOBILEMEDIASPLFOP_003"));
			features.add(new Feature("FAVOURITES"));
			features.add(new Feature("VIEWFAVOURITES"));
			features.add(new Feature("BASICPHOTOOPERATIONS"));
			features.add(new Feature("BASE"));
			features.add(new Feature("SORTING"));
			features.add(new Feature("CREATEPHOTO"));
			features.add(new Feature("DELETEPHOTO"));
			features.add(new Feature("ALBUMMANAGEMENT"));
			features.add(new Feature("VIEWPHOTO"));
			features.add(new Feature("PHOTOMANAGEMENT"));
			features.add(new Feature("SETFAVOURITES"));
		} else if (t == TargetSystem.MobileMedia4) {
			features.add(new Feature("CREATEALBUM"));
			features.add(new Feature("EDITPHOTOLABEL"));
			features.add(new Feature("DELETEALBUM"));
			features.add(new Feature("COPYPHOTO"));
			features.add(new Feature("MOBILEMEDIASPLFOP_004"));
			features.add(new Feature("FAVOURITES"));
			features.add(new Feature("VIEWFAVOURITES"));
			features.add(new Feature("BASICPHOTOOPERATIONS"));
			features.add(new Feature("BASE"));
			features.add(new Feature("SORTING"));
			features.add(new Feature("CREATEPHOTO"));
			features.add(new Feature("DELETEPHOTO"));
			features.add(new Feature("ALBUMMANAGEMENT"));
			features.add(new Feature("VIEWPHOTO"));
			features.add(new Feature("PHOTOMANAGEMENT"));
			features.add(new Feature("SETFAVOURITES"));

		} else if (t == TargetSystem.MobileMedia5) {
			features.add(new Feature("CREATEALBUM"));
			features.add(new Feature("EDITPHOTOLABEL"));
			features.add(new Feature("SMSTRANSFER"));
			features.add(new Feature("DELETEALBUM"));
			features.add(new Feature("COPYPHOTO"));
			features.add(new Feature("FAVOURITES"));
			features.add(new Feature("VIEWFAVOURITES"));
			features.add(new Feature("BASICPHOTOOPERATIONS"));
			features.add(new Feature("BASE"));
			features.add(new Feature("SORTING"));
			features.add(new Feature("EXTENDEDOPERATIONS"));
			features.add(new Feature("CREATEPHOTO"));
			features.add(new Feature("DELETEPHOTO"));
			features.add(new Feature("MOBILEMEDIASPLFOP_005"));
			features.add(new Feature("ALBUMMANAGEMENT"));
			features.add(new Feature("VIEWPHOTO"));
			features.add(new Feature("RECEIVEPHOTO"));
			features.add(new Feature("SENDPHOTO"));
			features.add(new Feature("PHOTOMANAGEMENT"));
			features.add(new Feature("SETFAVOURITES"));
		}
		else if (t == TargetSystem.MobileMedia6) {
			features.add(new Feature("DELETEALBUM"));
			features.add(new Feature("FAVOURITES"));
			features.add(new Feature("PHOTO"));
			features.add(new Feature("CREATEMEDIA"));
			features.add(new Feature("RECEIVEPHOTO"));
			features.add(new Feature("SENDPHOTO"));
			features.add(new Feature("MEDIAMANAGEMENT"));
			features.add(new Feature("DELETEMEDIA"));
			features.add(new Feature("CREATEALBUM"));
			features.add(new Feature("COPYMEDIA"));
			features.add(new Feature("SMSTRANSFER"));
			features.add(new Feature("BASICMEDIAOPERATIONS"));
			features.add(new Feature("EDITMEDIALABEL"));
			features.add(new Feature("VIEWFAVOURITES"));
			features.add(new Feature("BASE"));
			features.add(new Feature("SORTING"));
			features.add(new Feature("EXTENDEDOPERATIONS"));
			features.add(new Feature("MOBILEMEDIASPLFOP_006"));
			features.add(new Feature("MUSIC"));
			features.add(new Feature("ALBUMMANAGEMENT"));
			features.add(new Feature("VIEWPHOTO"));
			features.add(new Feature("PLAYMUSIC"));
			features.add(new Feature("SETFAVOURITES"));
			features.add(new Feature("MEDIASELECTION"));
		}
		else if (t == TargetSystem.MobileMedia7) {
			features.add(new Feature("PLAYVIDEO"));
			features.add(new Feature("DELETEALBUM"));
			features.add(new Feature("CAPTUREPHOTO"));
			features.add(new Feature("FAVOURITES"));
			features.add(new Feature("PHOTO"));
			features.add(new Feature("CREATEMEDIA"));
			features.add(new Feature("MOBILEMEDIA"));
			features.add(new Feature("RECEIVEPHOTO"));
			features.add(new Feature("SENDPHOTO"));
			features.add(new Feature("MEDIAMANAGEMENT"));
			features.add(new Feature("DELETEMEDIA"));
			features.add(new Feature("CREATEALBUM"));
			features.add(new Feature("COPYMEDIA"));
			features.add(new Feature("SMSTRANSFER"));
			features.add(new Feature("BASICMEDIAOPERATIONS"));
			features.add(new Feature("EDITMEDIALABEL"));
			features.add(new Feature("VIEWFAVOURITES"));
			features.add(new Feature("BASE"));
			features.add(new Feature("SORTING"));
			features.add(new Feature("EXTENDEDOPERATIONS"));
			features.add(new Feature("CAPTUREVIDEO"));
			features.add(new Feature("MUSIC"));
			features.add(new Feature("VIDEO"));
			features.add(new Feature("ALBUMMANAGEMENT"));
			features.add(new Feature("VIEWPHOTO"));
			features.add(new Feature("PLAYMUSIC"));
			features.add(new Feature("SETFAVOURITES"));
			features.add(new Feature("MEDIASELECTION"));
		}

	}

	public ArrayList<Combination> getCombsForTest() {
		return combinations;
	}

	public static void run(TargetSystem tg, String ph) {
		ProductGeneration.inicialization(tg);

		String path = ph;
		String path2 = "";
		String fileName;
		String fileNameAndPath = null;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 1; i < listOfFiles.length; i++) {

			File folder2 = new File(listOfFiles[i].getAbsolutePath());
			path2 = listOfFiles[i].getName();
			File[] listOfFiles2 = folder2.listFiles();

			if (listOfFiles2[0].isFile()) {
				fileName = listOfFiles2[0].getName();
				try {
					fileNameAndPath = path + "/" + path2 + "/" + fileName;
					// System.err.println(fileNameAndPath);

					ProductGeneration.leitor(fileNameAndPath);
					ProductGeneration.print();
				} catch (Exception e) {
					System.out.println(
							"Erro ao processar o arquivo %s com a mensagem: %s" + fileNameAndPath + e.getMessage());
				}
			}

		}
	}

	// public static void main(String[] args) {
	// System.out.println("Inicio...\n");
	//
	// Main.inicialization(TargetSystem.GPL);
	//
	// String path = "ICPL/GPL/products/";
	// String path2="";
	// String fileName;
	// String fileNameAndPath = null;
	// File folder = new File(path);
	// File[] listOfFiles = folder.listFiles();
	//
	// for (int i = 1; i < listOfFiles.length; i++) {
	//
	// File folder2 = new File(listOfFiles[i].getAbsolutePath());
	// path2=listOfFiles[i].getName();
	// File[] listOfFiles2 = folder2.listFiles();
	//
	// if (listOfFiles2[0].isFile()) {
	// fileName = listOfFiles2[0].getName();
	// try {
	// fileNameAndPath = path+path2 +"/"+ fileName;
	// System.err.println(fileNameAndPath);
	//
	// Main.leitor(fileNameAndPath);
	// Main.print();
	// }
	// catch (Exception e) {
	// System.out.println("Erro ao processar o arquivo %s com a mensagem: %s"+
	// fileNameAndPath+ e.getMessage());
	// }
	// }
	//
	// }
	//
	// System.out.println("\nFim.");
	// }
}
