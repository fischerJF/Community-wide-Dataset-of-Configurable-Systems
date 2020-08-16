package desktopsearcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JComboBox;

import splat.DesktopSearcherVariables;

public class History_Query implements ActionListener {

	String currentPattern = "";
	LinkedList list = new LinkedList();

	public History_Query() {

	}

	public void actionPerformed(ActionEvent e) {
		if (DesktopSearcherVariables.getSINGLETON().isGUI()) {
			if (DesktopSearcherVariables.getSINGLETON().isQUERY_HISTORY()) {
				// in cb steht automatisch die richtige Combobox
				JComboBox cb = (JComboBox) e.getSource();

				if ((!cb.getSelectedItem().equals("No input required."))
						&& (!cb.getSelectedItem().equals(""))) {
					// workaround, because we want no duplicates in the list
					if (!list.contains(cb.getSelectedItem())) {
						list.addFirst(cb.getSelectedItem());
						cb.addItem(currentPattern);
					} else {
						// the choosen Item is in the List, put it in the first
						// line
						// of the combobox again
						list.removeFirstOccurrence(cb.getSelectedItem());
						list.addFirst(cb.getSelectedItem());
						transferCurrentListinComboBox(list, cb);
					}
				}

				// history should not become to long
				if (list.size() > 10) {
					list.removeLast();

					// transfer changes in the combobox
					transferCurrentListinComboBox(list, cb);

				}

				if ((!cb.getSelectedItem().equals("No input required."))
						&& (!cb.getSelectedItem().equals(""))) {
					String newSelection = (String) cb.getSelectedItem();
					currentPattern = newSelection;
				}
				// start Search
			}
		}

	}

	void transferCurrentListinComboBox(LinkedList list, JComboBox cb) {
		if (DesktopSearcherVariables.getSINGLETON().isGUI()) {
			if (DesktopSearcherVariables.getSINGLETON().isQUERY_HISTORY()) {
				// transfer changes in the combobox
				cb.removeAllItems();
				Iterator i = list.iterator();
				while (i.hasNext()) {
					cb.addItem(i.next());
				}
			}
		}
	}

}
