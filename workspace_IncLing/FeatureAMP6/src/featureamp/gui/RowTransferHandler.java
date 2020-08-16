package featureamp.gui; 

import java.awt.Cursor; 
import java.awt.datatransfer.DataFlavor; 
import java.awt.datatransfer.Transferable; 
import java.awt.dnd.DragSource; 

import javax.activation.DataHandler; 
import javax.swing.JComponent; 
import javax.swing.JTable; 
import javax.swing.TransferHandler; 

import featureamp.playlist.Playlist; 

/**
 * TODO description
 */
public  class  RowTransferHandler  extends TransferHandler {
	
	
	public static final long serialVersionUID = 1l;

	

	private final DataFlavor localObjectFlavor = new DataFlavor(
			Integer.class, 
			"Integer Row Index");

	
	private JTable table = null;

	

	public RowTransferHandler(JTable table) {
		if (specifications.Configuration.reorder) {
			// Reorder
			this.table = table;
				}
	}

	

	@Override
	protected Transferable createTransferable(JComponent c) {
		// Reorder
		assert (c == table);
		return new DataHandler(new Integer(table.getSelectedRow()),
				localObjectFlavor.getMimeType());
	}

	

	@Override
	public boolean canImport(TransferHandler.TransferSupport info) {
		// Reorder
		boolean b = info.getComponent() == table && info.isDrop()
				&& info.isDataFlavorSupported(localObjectFlavor);
		table.setCursor(b ? DragSource.DefaultMoveDrop
				: DragSource.DefaultMoveNoDrop);
		return b;
	}

	

	@Override
	public int getSourceActions(JComponent c) {
		// Reorder
		return TransferHandler.COPY_OR_MOVE;
	}

	

	@Override
	public boolean importData(TransferHandler.TransferSupport info) {
		// Reorder
		JTable target = (JTable) info.getComponent();
		JTable.DropLocation dl = (JTable.DropLocation) info.getDropLocation();
		int index = dl.getRow();
		int max = table.getModel().getRowCount();
		if (index < 0 || index > max)
			index = max;
		target.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		try {
			Integer rowFrom = (Integer) info.getTransferable().getTransferData(
					localObjectFlavor);
			if (rowFrom != -1 && rowFrom != index) {
				((Playlist) table.getModel()).reorder(rowFrom, index);
				if (index > rowFrom)
					index--;
				target.getSelectionModel().addSelectionInterval(index, index);
				return true;
			}
		} catch (Exception e) {
			System.err.println("Error in feature reorder");
			System.err.println(e.getMessage());
		}
		return false;
	}

	

	@Override
	protected void exportDone(JComponent c, Transferable t, int act) {
		// Reorder
		if (act == TransferHandler.MOVE) {
			table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			table.updateUI();
		}
	}


}
