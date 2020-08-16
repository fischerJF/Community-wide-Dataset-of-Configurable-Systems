package desktopsearcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.TermFreqVector;
import org.apache.lucene.search.ScoreDoc;


/**
 * Hauptfenster der Anwendung.
 * 
 * @author Mr. Pink
 */
public class MainFrame extends JFrame implements UI {
	public static final long serialVersionUID = 1L;

	// Referenz zu der Main-Klasse.
	public MrPinkMain mrPinkMain = null;

	// Components
	public JButton startButton;
	public JPanel searchResultContainer;
	public JPanel groupBoxSearch;
	public JScrollPane scrollPane;
	public JTextArea informationField;

	// public JTextField indexPath;
	public JButton changeButton;
	public JButton refreshButton;

	// public JComboBox indexPath;
	public JButton addButton;
	public JButton removeButton;
	public JButton indexButton;

	public JComponent indexPath;

	public JComboBox queryTextFieldJComboBox;

	protected JScrollPane treeView;
	protected JPanel hitView;
	protected JSplitPane splitView;

	// Hier werden die Einstellung der Optionen gespeichert
	public OptionStorage optionStorage = new OptionStorage(10, false, false);

	/**
	 * Konstruktor.
	 * 
	 * Intitialisiert das Hauptfenster.
	 * 
	 * @param mrPinkMain
	 *            Referenz zu der Main-Klasse.
	 */
	public MainFrame(MrPinkMain mrPinkMain) {
		if (specifications.Configuration.GUI) {
			this.mrPinkMain = mrPinkMain;
			this.setSize(600, 400);
			this.setVisible(true);
			this.setMinimumSize(this.getSize());
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("MrPink");

			initComponents();

			/**
			 * Wegen einem Formatierungsproblem. Wenn diese Zeilen rausgenommen
			 * werden, kann es beim Start des Programmes passieren, das nicht
			 * alle Components des Fraims vernuenftig angezeigt werden.
			 */
			this.setSize(600, 401);
			this.setSize(600, 400);
		}
	}

	ArrayList index_History;

	public void initComponents() {
		if (specifications.Configuration.GUI) {
			createGroupBoxSearch();
			if (specifications.Configuration.INDEX_HISTORY) {
				index_History = new ArrayList();
			}
			if (specifications.Configuration.QUERY_HISTORY) {
				History_Query hq = new History_Query();
				queryTextFieldJComboBox.addActionListener(hq);
			}
			if (specifications.Configuration.SINGLE_DIRECTORY) {
				createGroupBoxIndex();
			} else if (specifications.Configuration.MULTI_DIRECTORY) {
				createGroupBoxIndex();
			}
		}
	}

	/**
	 * Erzeugt die Index-GroupBox mit allen beinhaltenden Elementen.
	 */
	public void createGroupBoxIndex() {
		if (specifications.Configuration.GUI) {
			if (specifications.Configuration.SINGLE_DIRECTORY) {
				JPanel indexGroupBox = makeGroupBox("Indexing", 15, Color.BLACK);

				this.add(indexGroupBox, BorderLayout.NORTH);

				JPanel xAxis1 = new JPanel();
				xAxis1.setName("xAxis1_createGroupBoxIndex");//INSERTED CODE
				xAxis1.setLayout(new BoxLayout(xAxis1, BoxLayout.X_AXIS));

				indexPath = new JTextField();
				indexPath.setEnabled(false);
				indexPath.setBounds(0, 0, 20, 50);
				indexPath.setFont(new Font("", Font.ITALIC, 10));
				xAxis1.add(indexPath);

				changeButton = new JButton("Change");
				changeButton.addActionListener(new ButtonListener(this));
				changeButton.setFont(new Font("", Font.ITALIC, 10));
				xAxis1.add(changeButton);

				indexGroupBox.add(xAxis1);

				JPanel xAxis2 = new JPanel();
				xAxis2.setName("xAxis2_createGroupBoxIndex");//INSERTED CODE
				xAxis2.setLayout(new BoxLayout(xAxis2, BoxLayout.X_AXIS));

				refreshButton = new JButton("Refresh");
				refreshButton.addActionListener(new ButtonListener(this));
				refreshButton.setFont(new Font("", Font.ITALIC, 10));
				xAxis2.add(refreshButton);

				indexGroupBox.add(xAxis2);
			} else if (specifications.Configuration.MULTI_DIRECTORY) {
				JPanel indexGroupBox = makeGroupBox("Indexing", 15, Color.BLACK);

				this.add(indexGroupBox, BorderLayout.NORTH);

				JPanel xAxis1 = new JPanel();
				xAxis1.setName("xAxis1_createGroupBoxIndex");//INSERTED CODE
				xAxis1.setLayout(new BoxLayout(xAxis1, BoxLayout.X_AXIS));

				indexPath = new JComboBox();
				indexPath.setVisible(true);
				indexPath.setBounds(0, 0, 20, 50);
				indexPath.setFont(new Font("", Font.ITALIC, 10));
				xAxis1.add(indexPath);

				addButton = new JButton("Add");
				addButton.addActionListener(new ButtonListener(this));
				addButton.setFont(new Font("", Font.ITALIC, 10));
				xAxis1.add(addButton);

				removeButton = new JButton("Remove");
				removeButton.addActionListener(new ButtonListener(this));
				removeButton.setFont(new Font("", Font.ITALIC, 10));
				xAxis1.add(removeButton);

				indexGroupBox.add(xAxis1);

				JPanel xAxis2 = new JPanel();
				xAxis2.setName("xAxis2_createGroupBoxIndex");//INSERTED CODE
				xAxis2.setLayout(new BoxLayout(xAxis2, BoxLayout.X_AXIS));

				indexButton = new JButton("Index");
				indexButton.addActionListener(new ButtonListener(this));
				indexButton.setFont(new Font("", Font.ITALIC, 10));
				xAxis2.add(indexButton);

				indexGroupBox.add(xAxis2);
			}
		}
	}

	/**
	 * Dialog zur Indexersetllung.
	 * 
	 * Oeffnet eine Dialog der das Indizieren startet oder in dem das Indizieren
	 * abgebrochen werden kann. Fals der zu indizierende Pfad noch nicht
	 * angegeben wurde, kommt eine Fehlermeldung.
	 */
	public void showIndexCreateMessageDialog() {
		if (specifications.Configuration.GUI) {
			if (specifications.Configuration.SINGLE_DIRECTORY) {
				if (((JTextField) indexPath).getText().isEmpty()) {
					printErrorMessage("No path given.");
					return;
				}

				// Index erstellen

				int returnValue = JOptionPane.showOptionDialog(this,
						"The directory " + ((JTextField) indexPath).getText()
								+ " is being indexed.", "Indexing",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if (returnValue == JOptionPane.OK_OPTION) {
					mrPinkMain.createIndex(((JTextField) indexPath).getText());
					this.enableSearchGroupBox(true);
				}
			} else if (specifications.Configuration.MULTI_DIRECTORY) {
				if (((JComboBox) indexPath).getSelectedIndex() == -1) {
					printErrorMessage("No path given.");
					return;
				}

				// Index erstellen
				int returnValue = JOptionPane.showOptionDialog(
						this,
						"The directory "
								+ (String) ((JComboBox) indexPath).getSelectedItem()
								+ " is being indexed.", "Indexing",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if (returnValue == JOptionPane.OK_OPTION) {
					String[] allPaths = new String[((JComboBox) indexPath).getItemCount()];
					for (int i = 0; i < ((JComboBox) indexPath).getItemCount(); i++) {
						allPaths[i] = (String) ((JComboBox) indexPath).getItemAt(i);
					}

					mrPinkMain.createIndex(allPaths);
					this.enableSearchGroupBox(true);
				}
			}
		}
	}

	/**
	 * Erzeugt eine GroupBox.
	 * 
	 * @param title
	 *            Name der GroupBox
	 * @param fontSize
	 *            Groesse der Schrift
	 * @param color
	 *            Farbe der Umrandung
	 * @return das entsprechend praeparierte JPanel-Objekt
	 */
	public static JPanel makeGroupBox(String title, int fontSize, Color color) {
		JPanel panel = new JPanel();
		panel.setName("makeGroupBox");//INSERTED CODE
		if (specifications.Configuration.GUI) {
			Border blackline = BorderFactory.createLineBorder(color);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			TitledBorder border = BorderFactory.createTitledBorder(blackline,
					title, TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.CENTER, new Font("", Font.ITALIC, fontSize));
			panel.setBorder(border);
		}
		return panel;
	}

	JPanel xAxis1;

	/**
	 * Erzeugt die Search-GroupBox mit allen beinhaltenden Elementen.
	 */
	public void createGroupBoxSearch() {
		if (specifications.Configuration.GUI) {
			groupBoxSearch = makeGroupBox("Search", 30, Color.BLACK);
			this.add(groupBoxSearch, BorderLayout.CENTER);
			groupBoxSearch.setLayout(new BorderLayout());

			xAxis1 = new JPanel();
			xAxis1.setName("xAxis1_createGroupBoxSearch");//INSERTED CODE
			xAxis1.setLayout(new BoxLayout(xAxis1, BoxLayout.X_AXIS));

			queryTextFieldJComboBox = new JComboBox();
			queryTextFieldJComboBox.setBounds(0, 0, 20, 50);
			queryTextFieldJComboBox.setFont(new Font("", Font.ITALIC, 15));
			queryTextFieldJComboBox.setEditable(true);
			xAxis1.add(queryTextFieldJComboBox);

			startButton = new JButton("Search");
			startButton.addActionListener(new ButtonListener(this));
			startButton.setFont(new Font("", Font.ITALIC, 15));
			xAxis1.add(startButton);

			createOptionsButton();

			groupBoxSearch.add(xAxis1, BorderLayout.NORTH);

			// Standard-Button setzen

			this.getRootPane().setDefaultButton(startButton);
			this.enableSearchGroupBox(false);

			// resultPanel
			searchResultContainer = new JPanel();
			searchResultContainer.setName("searchResultContainer");//INSERTED CODE
			groupBoxSearch.add(searchResultContainer, BorderLayout.CENTER);
			searchResultContainer.setLayout(new GridBagLayout());
			scrollPane = new JScrollPane(searchResultContainer);

			informationField = new JTextArea(2, 1);
			informationField.setFont(new Font("", Font.ITALIC, 15));
			informationField.setEditable(false);
			informationField.setEnabled(false);
			informationField
					.setText("Type in multiple words to do an 'AND' search (all terms must be present). You can also use + to specify a word that must be contained in the text,\n or - for words you don't want to find. Additionally, you can use the field names 'title' and 'content' to narrow your search.");
			groupBoxSearch.add(informationField, BorderLayout.SOUTH);
			groupBoxSearch.add(scrollPane);
		}
	}

	public JButton optionButton;

	public void createOptionsButton() {
		if (specifications.Configuration.GUI) {
			if (specifications.Configuration.GUI_PREFERENCES) {
				optionButton = new JButton("Options");
				optionButton.addActionListener(new ButtonListener(this));
				optionButton.setFont(new Font("", Font.ITALIC, 15));
				xAxis1.add(optionButton);
			}
		}
	}

	/**
	 * Such-Box (de)aktivieren.
	 * 
	 * @param b
	 *            True zum aktivieren, ansonsten False.
	 */
	public void enableSearchGroupBox(boolean b) {
		if (specifications.Configuration.GUI) {
			this.queryTextFieldJComboBox.setEnabled(b);
			this.startButton.setEnabled(b);
			if (specifications.Configuration.GUI_PREFERENCES) {
				this.optionButton.setEnabled(b);
			}
		}
	}

	/**
	 * Oeffnet einen Dialog, der die Uebergebene Error-Message ausgibt.
	 * 
	 * @param message
	 *            Fehler der ausgegeben werden soll
	 */
	public void printErrorMessage(String message) {
		if (specifications.Configuration.GUI) {
			JOptionPane.showMessageDialog(this, message, "An error occurred!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void printSearch_SearchPanel(ScoreDoc[] hits, Indexer index,
			String query) {
		if (specifications.Configuration.GUI) {
			// die Funktioanlitaet ist in die Features ausgelagert
			if (specifications.Configuration.NORMAL_VIEW) {
				searchResultContainer.setLayout(null);
				try {
					if (hits.length == 0) {
						searchResultContainer.setName("searchResultContainer");//INSERTED CODE
						new NoDocument(searchResultContainer,
								new Point((groupBoxSearch.getWidth() / 2) - 50,
										searchResultContainer
												.getPreferredSize().height));
					} else {

						for (int rankPos = 0; rankPos < hits.length; rankPos++) {
							int documentID = hits[rankPos].doc;
							Object[] ret = index.getDocument(documentID);
							Document document = (Document) ret[0];
							TermFreqVector[] freqVec = (TermFreqVector[]) ret[1];

							String lastModification = document.getField(
									"lastModify").stringValue();
							Timestamp ts = new Timestamp(new Long(
									lastModification));
							Date d = new Date(ts.getTime());
							lastModification = d.toString();

							String size = document.getField("size")
									.stringValue() + " Byte";

							Point position = new Point(
									10,
									searchResultContainer.getPreferredSize().height);
							// DatenSatz erzeugen
							ArrayList daten = new ArrayList();
							// rankingPos
							daten.add((1 + rankPos) + "");
							// ID
							daten.add(documentID + "");
							// name
							daten.add(document.getField("title").stringValue());
							// location
							daten.add(document.getField("path").stringValue());
							// groesse
							daten.add(size);
							// age
							daten.add(lastModification);
							// Woerter
							// wenn eine Query vorhanden ist
							if (query != null) {
								String[] queryTerms = index
										.getQueryTerms(query);
								for (int i = 0; i < queryTerms.length; i++) {
									daten.add(queryTerms[i]);
									daten.add(index.getTermFreq(freqVec,
											queryTerms[i]) + "");
								}
							}

							// Added das Ergebnis auf das Panel
							HitDocument dokL = new HitDocument(
									searchResultContainer, position, daten);
							/**
							 * In diesem Bereich wird die PrefereceSize des
							 * Container an die beinhaltenden Panel angepasst.
							 * Dadurch wird sichergestellt, dass die Scrollbars
							 * wie gewuenscht funktionieren.
							 */
							if (dokL.getWidth() > searchResultContainer
									.getPreferredSize().width) {
								searchResultContainer
										.setPreferredSize(new Dimension(dokL
												.getWidth(), dokL.getY()
												+ dokL.getHeight()));
							} else
								searchResultContainer
										.setPreferredSize(new Dimension(
												groupBoxSearch.getSize().width,
												dokL.getY() + dokL.getHeight()));
						}
						searchResultContainer.repaint();
						scrollPane
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
						scrollPane
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
					}
				} catch (Exception e) {
					System.err.println(e);
					e.printStackTrace();
				}
			} else if (specifications.Configuration.TREE_VIEW) {
				TreeMap hit_list = new TreeMap();
				try {
					if (hits.length == 0) {

					} else {

						for (int rankPos = 0; rankPos < hits.length; rankPos++) {
							int documentID = hits[rankPos].doc;
							Object[] ret = index.getDocument(documentID);
							Document document = (Document) ret[0];
							TermFreqVector[] freqVec = (TermFreqVector[]) ret[1];

							String lastModification = document.getField(
									"lastModify").stringValue();
							Timestamp ts = new Timestamp(new Long(
									lastModification));
							Date d = new Date(ts.getTime());
							lastModification = d.toString();

							String size = document.getField("size")
									.stringValue() + " Byte";

							Point position = new Point(
									10,
									searchResultContainer.getPreferredSize().height);
							// DatenSatz erzeugen
							ArrayList daten = new ArrayList();
							// rankingPos
							daten.add((1 + rankPos) + "");
							// ID
							daten.add(documentID + "");
							// name
							daten.add(document.getField("title").stringValue());
							// location
							daten.add(document.getField("path").stringValue());
							// groesse
							daten.add(size);
							// age
							daten.add(lastModification);
							// Woeter
							// wenn eine Query vorhanden ist
							if (query != null) {
								String[] queryTerms = index
										.getQueryTerms(query);
								for (int i = 0; i < queryTerms.length; i++) {
									daten.add(queryTerms[i]);
									daten.add(index.getTermFreq(freqVec,
											queryTerms[i]) + "");
								}
							}

							// Added das Ergebnis auf das Panel
							HitDocument dokL = new HitDocument(daten);

							hit_list.put(dokL.getPath(), dokL);
							/**
							 * In diesem Bereich wird die PrefereceSize des
							 * Container an die beinhaltenden Panel angepasst.
							 * Dadurch wird sichergestellt, dass die Scrollbars
							 * wie gewuenscht funktionieren.
							 */
						}

						hitView = new JPanel();
						hitView.setPreferredSize(new Dimension(
								searchResultContainer.getSize().width,
								searchResultContainer.getSize().height / 2));

						JTree tree = new SearchResultTree(hit_list, hitView)
								.getTree();
						treeView = new JScrollPane(tree);

						// hitView = new JPanel();

						splitView = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
						splitView.setName("splitView");//INSERTED CODE
						splitView.setTopComponent(treeView);
						splitView.setBottomComponent(hitView);

						splitView.setDividerLocation(searchResultContainer
								.getSize().height / 2);

						GridBagConstraints constraints_Container = new GridBagConstraints(); // "reset Constraints"
						constraints_Container.weightx = 1.0; // need to fill
																// with
																// horizontal
																// complete
						constraints_Container.weighty = 1.0; // need to fill
																// with
																// vertical
																// complete
						constraints_Container.fill = GridBagConstraints.BOTH; // fill
																				// horizontal
																				// and
																				// vertical
																				// (set
																				// weightx
																				// +
																				// weighty!!!)

						searchResultContainer.add(splitView,
								constraints_Container);

						splitView.setSize(new Dimension(searchResultContainer
								.getSize().width, searchResultContainer
								.getSize().height));

						searchResultContainer.repaint();
						// pack();
						scrollPane
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
						scrollPane
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
					}
				} catch (Exception e) {
					System.err.println(e);
					e.printStackTrace();
				}
			}
		}
	}

}
