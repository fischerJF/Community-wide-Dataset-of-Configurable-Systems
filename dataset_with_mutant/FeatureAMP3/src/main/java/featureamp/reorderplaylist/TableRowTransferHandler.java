package featureamp.reorderplaylist; 

import java.awt.Cursor; 
import java.awt.datatransfer.DataFlavor; 
import java.awt.datatransfer.Transferable; 
import java.awt.dnd.DragSource; 
import java.util.LinkedHashMap; 
import java.util.LinkedHashSet; 
import java.util.LinkedList; 

import javax.activation.ActivationDataFlavor; 
import javax.activation.DataHandler; 
import javax.swing.JComponent; 
import javax.swing.JTable; 
import javax.swing.TransferHandler; 
import javax.swing.table.TableRowSorter; 

import featureamp.Song; 
import featureamp.playlist.PlaylistDataModel; 

public  class  TableRowTransferHandler  extends TransferHandler {
	
   private final DataFlavor localObjectFlavor = new ActivationDataFlavor(Integer.class, DataFlavor.javaJVMLocalObjectMimeType, "Integer Row Index");

	
   private JTable           table             = null;

	

   public TableRowTransferHandler(JTable table) {
		if (specifications.Configuration.reorderplaylist) {
	      this.table = table;
	   		}
	}

	

   @Override
   protected Transferable createTransferable(JComponent c) {
      assert (c == table);
      System.out.println("[...] createTransferable");
      return new DataHandler(new Integer(table.getSelectedRow()), localObjectFlavor.getMimeType());
   }

	

   @Override
   public boolean canImport(TransferHandler.TransferSupport info) {
      boolean b = info.getComponent() == table && info.isDrop() && info.isDataFlavorSupported(localObjectFlavor);
      table.setCursor(b ? DragSource.DefaultMoveDrop : DragSource.DefaultMoveNoDrop);
      return b;
   }

	

   @Override
   public int getSourceActions(JComponent c) {
      return TransferHandler.COPY_OR_MOVE;
   }

	

   @Override
   public boolean importData(TransferHandler.TransferSupport info) {
	  JTable target = (JTable) info.getComponent();
	  JTable.DropLocation dl = (JTable.DropLocation) info.getDropLocation();
	  int index = dl.getRow();
	  int max = table.getModel().getRowCount();
      if (index < 0 || index > max)
         index = max;
      
      target.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      PlaylistDataModel model = (PlaylistDataModel) target.getModel();
        
      index = target.getRowSorter().convertRowIndexToModel(index);
      Song targetSong = model.getSong(index);
      
      System.out.println("Move before: " + model.getSong(index) + " ("+index+")");
      
      int[] rows = target.getSelectedRows();
      LinkedList<Song> selectedSongs = new LinkedList<Song>();
      
      for(int r=0;r<rows.length;r++) {
    	  selectedSongs.add(model.getSong(target.getRowSorter().convertRowIndexToModel(rows[r])));
      }
      
      target.setRowSorter(null);
      for(Song s : selectedSongs) {
    	  model.moveSong(s, targetSong);
      }
      TableRowSorter<PlaylistDataModel> sorter = new TableRowSorter<PlaylistDataModel>(model);
      target.setRowSorter(sorter);
      return true;
   }

	

   @Override
   protected void exportDone(JComponent c, Transferable t, int act) {
      if (act == TransferHandler.MOVE) {
         table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
   }


}
