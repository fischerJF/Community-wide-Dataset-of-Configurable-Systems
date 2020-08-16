package desktopsearcher;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import splat.DesktopSearcherVariables;

/**
 * Hauptklasse.
 * 
 * Diese Klasse enthaelt das eigentliche Programm.
 * <p>
 * Das Programm beendet sich mit Code 0x0, falls alles OK verlief. Wenn ein
 * Fehler aufgetreten ist (Index nicht gefunden o.ae.), wird 0x1 zurueckgegeben.
 * 
 * @author Mr. Pink
 */
public class MrPinkMain {

	Indexer index = null;
	public UI userInterface;

	/**
	 * Konstruktor.
	 * 
	 * Erzeugt einen neuen MainFrame und uebergibt sich selbst als Parent.
	 * 
	 */
	public MrPinkMain() {
		init();
	}

	protected void init() {
		if (DesktopSearcherVariables.getSINGLETON().isCOMMAND_LINE()) {
			Commandline cmd = new Commandline(this);// MainFrame(this);
			userInterface = cmd;
//			 cmd.startCommandline(); //comment for testing
		} else if (DesktopSearcherVariables.getSINGLETON().isGUI()) {
			userInterface = new MainFrame(this);
		}
	}

	/**
	 * Einstiegspunkt.
	 * 
	 * @param args
	 *            die uebergebenen Programmargumente
	 */
	public static void main(String[] args) {
		DesktopSearcherVariables.getSINGLETON().setCOMMAND_LINE(true);
		DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//		DesktopSearcherVariables.getSINGLETON().setTXT(true);
//		DesktopSearcherVariables.getSINGLETON().setHTML(true);
		DesktopSearcherVariables.getSINGLETON().setLATEX(true);
//		DesktopSearcherVariables.getSINGLETON().setGUI(false);
//		DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(true);
//		DesktopSearcherVariables.getSINGLETON().setMULTI_DIRECTORY(false);
//		DesktopSearcherVariables.getSINGLETON().setGUI_PREFERENCES(false);
//		DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(true);
//		DesktopSearcherVariables.getSINGLETON().setTREE_VIEW(false);
//		DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
//		DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(true);
		DesktopSearcherVariables.getSINGLETON().setLINUX(true);
//		DesktopSearcherVariables.getSINGLETON().setWINDOWS(false);
		new MrPinkMain();
	}

	/**
	 * Komplette Ausgabe der Ergebnisse.
	 * 
	 * Diese Methode gibt die einzelnen gefundenen Dokumente aus. Dabei werden
	 * neben dem Titel und dem Pfad auch noch die Dateigroesse oder der
	 * Zeitpunkt der letzten Aenderung ausgegeben, falls der letzte Parameter
	 * entsprechend gesetzt wird.
	 * 
	 * @param hits
	 *            die IDs der Trefferdokumente
	 * @param index
	 *            Indexer auf dem gearbeitet wird
	 * @param interestingField
	 *            Field nach dem gesucht wurde. Der Parameter ist nur bei
	 *            Anfragen, die nach "largest" oder "mostRecent" gestellt
	 *            wurden, relevant.
	 */
	protected static void printHits(ScoreDoc[] hits, Indexer index,
			String interestingField) {
		try {
			System.out.println(interestingField);
			// for (ScoreDoc doc : hits) {
			for (int i = 0; i < hits.length; i++) {
				ScoreDoc doc = hits[i];

				int documentID = doc.doc;
				Object[] ret = index.getDocument(documentID);
				Document document = (Document) ret[0];

				String value = document.getField(interestingField)
						.stringValue();

				if (interestingField.equals("lastModify")) {
					Timestamp ts = new Timestamp(new Long(value));
					Date d = new Date(ts.getTime());

					value = d.toString();
				} else if (interestingField.equals("size")) {
					value += " Byte";
				}

				System.out.println("  -> doc #" + documentID + " (" + value
						+ ")");
				System.out.println("  -> title "
						+ document.getField("title").stringValue());
				System.out.println("  -> path "
						+ document.getField("path").stringValue());
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	public void createIndex(String dataDir) {
		if (DesktopSearcherVariables.getSINGLETON().isCOMMAND_LINE()) {
			try {
				index = new Indexer("./index");
				index.createIndex(dataDir);
			} catch (Exception e) {
//				System.out.println(" failed.");
//				System.err.println(e.getMessage());
//				System.err.println("Aborting.");
//				System.exit(1);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (DesktopSearcherVariables.getSINGLETON().isGUI()) {
			if (DesktopSearcherVariables.getSINGLETON().isSINGLE_DIRECTORY()) {
				try {
					index = new Indexer("./index");
					index.createIndex(dataDir);
				} catch (Exception e) {
//					System.out.println(" failed.");
//					System.err.println(e.getMessage());
//					System.err.println("Aborting.");
//					System.exit(1);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void createIndex(String[] dataDirs) {
		if (DesktopSearcherVariables.getSINGLETON().isGUI()) {
			if (DesktopSearcherVariables.getSINGLETON().isMULTI_DIRECTORY()) {
				try {
					index = new Indexer("./index");
					index.createIndex(dataDirs);
				} catch (Exception e) {
//					System.out.println(" failed.");
//					System.err.println(e.getMessage());
//					System.err.println("Aborting.");
//					System.exit(1);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void searchInIndex(String query, int maxResults, int searchMode)
			throws Exception {
		if (DesktopSearcherVariables.getSINGLETON().isUSER_INTERFACE()) {
			if (index == null) {
				userInterface
						.printErrorMessage("Bisher wurde noch kein Pfad indexiert");
				return;
			}

			TopDocs hits = null;
			if (searchMode == OptionStorage.SEARCHLASTMODIFIED) {
				// Suche nach den X juengsten Dokumenten

				System.out.print("Getting the " + maxResults
						+ " newest documents...");
				hits = index.getMostRecentDocuments(maxResults);

				if (hits != null) {
					System.out.println(" found " + hits.totalHits
							+ " documents.");
					// MrPinkMain.printHits(hits.scoreDocs, index,
					// "lastModify");
					userInterface.printSearch_SearchPanel(hits.scoreDocs,
							index, null);
				} else {
					System.out.println(" no documents found.");
				}
			} else if (searchMode == OptionStorage.SEARCHLARGEST) {
				// Suche nach den X groessten Dokumente

				System.out.print("Getting the " + maxResults
						+ " largest documents...");
				hits = index.getLargestDocuments(maxResults);

				if (hits != null) {
					System.out.println(" found " + hits.totalHits
							+ " documents.");
					userInterface.printSearch_SearchPanel(hits.scoreDocs,
							index, null);
				} else {
					System.out.println(" no documents found.");
				}
			} else if (searchMode == OptionStorage.SEARCHNORMAL) {
				// Suche nach Suchbegriff

				System.out.print("Searching for '" + query + "'...");
				hits = index.search(query, maxResults);

				if (hits != null) {
					System.out.println(" found " + hits.totalHits
							+ " matching documents.");
					userInterface.printSearch_SearchPanel(hits.scoreDocs,
							index, query);
				} else {
					System.out.println(" no matching documents found.");
				}
			} else {
				throw new IndexerException("Unknown search mode.");
			}
		}
	}
}
