package desktopsearcher;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import splat.DesktopSearcherVariables;

/**
 * Event-Listener
 * 
 * Die Klasse Listener behandelt alle Events die durch Buttons ausgeloest werden
 * 
 */
public class ButtonListener implements ActionListener {

	Component parents;// = null;
	MainFrame frame;

	public ButtonListener(Component parents) {
		if (DesktopSearcherVariables.getSINGLETON().isGUI()) {
			this.parents = parents;
			frame = (MainFrame) parents;
		}
	}

	String noInput = "No input required.";

	public void actionPerformed(ActionEvent e) {
		if (DesktopSearcherVariables.getSINGLETON().isGUI()) {
			/**
			 * Der startButton startet die Suche. Hierbei kann je nach
			 * Einstellung nach der angegebenen Query gesucht werden, wie auch
			 * nach den groesssten Dateien oder auch nach dem Zeitpunkt der
			 * letzten Aenderung.
			 */
			if (e.getSource().equals(frame.startButton)) {
				frame.searchResultContainer.removeAll();
				frame.searchResultContainer.repaint();

				// setzt die Groesse des Panels wieder zum Standard
				frame.searchResultContainer
						.setPreferredSize(new Dimension(0, 0));

				frame.scrollPane.repaint();

				if (frame.queryTextFieldJComboBox.getSelectedItem() != null) {
					try {
						frame.mrPinkMain.searchInIndex(
								((String) frame.queryTextFieldJComboBox
										.getSelectedItem()),
								frame.optionStorage.getMaxResults(),
								frame.optionStorage.getSearchMode());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					System.out.println("bitte Querry eingeben");
				}
			}

			if (DesktopSearcherVariables.getSINGLETON().isGUI_PREFERENCES()) {
				/**
				 * Beim Betoetigen dieses Buttons wir ein Options-Dialog
				 * geoeffnet, in dem dann alle moeglichen Einstellungen
				 * getoetigt werden koennen.
				 */
				if (e.getSource().equals(frame.optionButton)) {
					OptionWindow.showModal(frame.optionStorage,
							(JFrame) parents);
					if (frame.optionStorage.isSearchLargest()
							|| frame.optionStorage.isSearchMostRecent()) {
						frame.queryTextFieldJComboBox.setEnabled(false);

						frame.queryTextFieldJComboBox.setSelectedItem(noInput);
					} else {
						frame.queryTextFieldJComboBox.setEnabled(true);
						frame.queryTextFieldJComboBox.removeItem(noInput);
						frame.queryTextFieldJComboBox.setSelectedItem("");
					}
				}
			}

			if (DesktopSearcherVariables.getSINGLETON().isSINGLE_DIRECTORY()) {
				/**
				 * Wenn der changeButton betoetigt wird, wird ein FileChooser
				 * geoeffnet, in dem dann ein Pfad, der indiziert werden soll,
				 * selektiert werden kann.
				 */
				if (e.getSource().equals(frame.changeButton)) {
					addingPath();
					frame.enableSearchGroupBox(false);
					frame.showIndexCreateMessageDialog();
				}
				/**
				 * Wenn der refreshButton benoetigt wird, wird der selektierte
				 * Pfad neu indiziert.
				 */
				if (e.getSource().equals(frame.refreshButton)) {
					frame.showIndexCreateMessageDialog();
				}
			} else if (DesktopSearcherVariables.getSINGLETON().isMULTI_DIRECTORY()) {
				/**
				 * Wenn der addButton betoetigt wird, wird ein FileChooser
				 * geoeffnet, in dem dann ein Pfad, der indiziert werden soll,
				 * selektiert werden kann.
				 */
				if (e.getSource().equals(frame.addButton)) {
					addingPath();	
				}
				
				/**
				 * Wenn der removeButton benoetigt wird, wird das aktuell 
		         * selektierte Element entfernt.
				 */
				if (e.getSource().equals(frame.removeButton)) {
					((JComboBox) frame.indexPath).removeItem(((JComboBox) frame.indexPath).getSelectedItem());
				}
				
				/**
				 * Wenn der indexButton benoetigt wird, werden alle Pfad
				 * neu indiziert.
				 */
				if (e.getSource().equals(frame.indexButton)) {
					frame.showIndexCreateMessageDialog();
				}
			}
		}
	}
	

	public void addPathToGui(String path){
		if (DesktopSearcherVariables.getSINGLETON().isGUI()) {
			if (DesktopSearcherVariables.getSINGLETON().isSINGLE_DIRECTORY()) {
				((JTextField) frame.indexPath).setText(path);
			} else if (DesktopSearcherVariables.getSINGLETON()
					.isMULTI_DIRECTORY()) {
				((JComboBox) frame.indexPath).addItem(path);
			}
		}
	}

	public void pathAdded(String path) {
		if (DesktopSearcherVariables.getSINGLETON().isGUI()) {
			if (DesktopSearcherVariables.getSINGLETON().isINDEX_HISTORY()) {
				if (!frame.index_History.contains(path)) {
					frame.index_History.add(path);
				}
			}
		}

	}

	public void addingPath() {
		if (DesktopSearcherVariables.getSINGLETON().isGUI()) {
			if (DesktopSearcherVariables.getSINGLETON().isINDEX_HISTORY()) {
				Index_History_Selector selector = new Index_History_Selector(
						frame, null);
				String path = selector.selectedPath;
				addPathToGui(path);
				pathAdded(path);
				System.out.println("der Path " + selector.selectedPath);
			}
			if (DesktopSearcherVariables.getSINGLETON().isSINGLE_DIRECTORY()) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (JFileChooser.APPROVE_OPTION == fileChooser
						.showOpenDialog(parents)) {
					String path = fileChooser.getSelectedFile().getPath();
					addPathToGui(path);
					pathAdded(path);
				}
			} else if (DesktopSearcherVariables.getSINGLETON()
					.isMULTI_DIRECTORY()) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (JFileChooser.APPROVE_OPTION == fileChooser
						.showOpenDialog(parents)) {
					String path = fileChooser.getSelectedFile().getPath();
					addPathToGui(path);
					pathAdded(path);
				}
			}
		}
	}
}
