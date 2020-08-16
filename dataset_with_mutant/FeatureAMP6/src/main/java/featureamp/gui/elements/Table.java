package featureamp.gui.elements; 

import java.awt.Component; 
import java.awt.Dimension; 
import java.awt.Font; 
import java.util.List; 

import javax.swing.BorderFactory; 
import javax.swing.JComponent; 
import javax.swing.JTable; 
import javax.swing.SwingConstants; 
import javax.swing.border.EmptyBorder; 
import javax.swing.table.DefaultTableCellRenderer; 
import javax.swing.table.JTableHeader; 
import javax.swing.table.TableCellRenderer; 
import javax.swing.table.TableModel; 

import featureamp.FeatureAMP; 
import featureamp.playback.Track; 
import featureamp.playlist.Playlist; 

/**
 * TODO description
 */
public  class  Table  extends JTable {
	

	public static final long serialVersionUID = 1l;

	

	private static final int ROW_HIGHT = 25;

	
	private TableCellRenderer renderer;

	
	private Playlist playlist;

	

	public Table(TableModel pl) {
//		if (specifications.Configuration.playlist) {
			// Playlist
			super(pl);
			playlist = (Playlist) pl;
			setIntercellSpacing(new Dimension(0, 0));
			setRowHeight(ROW_HIGHT);
			JTableHeader h = getTableHeader();
			h.setBackground(FeatureAMP.BG2);
			h.setForeground(FeatureAMP.FG);
			h.setPreferredSize(new Dimension(100, ROW_HIGHT));
			renderer = new CellRenderer();
			setDefaultRenderer(String.class, renderer);
			setDefaultRenderer(Integer.class, renderer);
			getTableHeader().setDefaultRenderer(new HeaderRenderer());
//				}
	}

	

	public void setColumsWidths(int[] cols, int[] widths) {
		// Playlist
		for (int i = 0; i < cols.length; i++) {
			getColumnModel().getColumn(cols[i]).setPreferredWidth(widths[i]);
		}
	}

	

	public  class  CellRenderer  extends DefaultTableCellRenderer {
		
		// Playlist

		public static final long serialVersionUID = 1l;

		

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			// Playlist
			if (value instanceof Integer) {
				setHorizontalAlignment(SwingConstants.RIGHT);
				value = new String(value.toString() + "   ");
			} else {
				setHorizontalAlignment(SwingConstants.LEFT);
			}
			JComponent c = (JComponent) super.getTableCellRendererComponent(
					table, value, isSelected, hasFocus, row, column);
			if (!isSelected) {
				c.setBackground(row % 2 == 0 ? FeatureAMP.BG : FeatureAMP.BG2);
			}
			c.setForeground(FeatureAMP.FG);
			c.setBorder(new EmptyBorder(0, 0, 0, 0));
			return c;
		}


	}

	

	public  class  HeaderRenderer  extends DefaultTableCellRenderer {
		
		// Playlist

		public static final long serialVersionUID = 1l;

		

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			// Playlist
			setHorizontalAlignment(SwingConstants.CENTER);
			JComponent c = (JComponent) super.getTableCellRendererComponent(
					table, value, isSelected, hasFocus, row, column);
			c.setBackground(FeatureAMP.BG2);
			Font f = new Font(c.getFont().getName(), Font.BOLD, c.getFont()
					.getSize());
			c.setFont(f);
			c.setForeground(FeatureAMP.FG);
			c.setBorder(BorderFactory.createMatteBorder(2, column == 0 ? 2 : 0,
					2, 2, FeatureAMP.BG));
			return c;
		}


	}

	

	public void addTrack(Track t) {
		// Playlist
		playlist.addTrack(t);
	}

	

	public void addTracks(List<Track> t) {
		// Playlist
		playlist.addTracks(t);
	}

	

	public Playlist getPlModel() {
		return playlist;
	}


}
