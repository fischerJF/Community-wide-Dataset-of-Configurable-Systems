package featureamp.gui.elements; 

import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.Image; 
import java.io.File; 
import java.io.IOException; 

import javax.imageio.ImageIO; 
import javax.swing.JPanel; 

import featureamp.FeatureAMP; 

/**
 * This class extends a default JPanel to show any picture in the
 * 
 * @author joko
 * @version 2.0
 * @since 1.0
 * 
 */
public  class  Picture  extends JPanel {
	

	private String filename;

	
	private Image i;

	
	private int size;

	
	private Color background;

	

	private static final long serialVersionUID = 188007638510784751L;

	

	public Picture(int size) {
		if (specifications.Configuration.base) {
			// Base
			setSize(size + 20);
			background = FeatureAMP.BG;
			setDefaultPicture();
			init();
				}
	}

	

	private void init() {
	}

	

	public void setSize(int size) {
//		this.size = size - 20;
		this.size = size;
		setMinimumSize(new Dimension(size, size));
		setMaximumSize(new Dimension(size, size));
		setPreferredSize(new Dimension(size, size));
		setSize(new Dimension(size, size));
	}

	

	public void setDefaultPicture() {
		setPicture("img/standard_cover_original_big.png");
	}

	

	public void setPicture(String filename) {
		this.filename = filename;
		i = null;
		repaint();
	}

	

	public void setPicture(Image i) {
		this.i = i;
		repaint();
	}

	

	@Override
	public void paint(Graphics g) {
		try {
			i = i == null ? ImageIO.read(new File(filename)) : i;
			i = i.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH);
			g.setColor(background);
			g.fillRect(0, 0, size, size);
			g.drawImage(i, 0, 0, size, size, null);
//			g.fillRect(0, 0, size + 20, size + 20);
//			g.setColor(FeatureAMP.BG);
//			g.fillRect(10, 10, size, size);
//			g.drawImage(i, 10, 10, size, size, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
