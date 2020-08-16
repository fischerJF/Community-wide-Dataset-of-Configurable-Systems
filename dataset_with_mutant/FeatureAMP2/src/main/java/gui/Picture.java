package gui; 

import java.awt.Graphics; 
import java.awt.Image; 
import java.io.File; 
import java.io.IOException; 

import javax.imageio.ImageIO; 
import javax.swing.JPanel; 

/**
 * This class extends a default JPanel to show any picture in the
 * 
 * @author joko
 * @version 1.0
 * @since 1.0
 * 
 */
public  class  Picture  extends JPanel {
	

	private String filename;

	
	private Image i;

	
	private int with, hight;

	

	private static final long serialVersionUID = 188007638510784751L;

	

	public Picture(int with, int hight){
		if (specifications.Configuration.gui) {
			this.with = with;
			this.hight = hight;
				}
	}

	
	public void setDefaultPicture() {
		Image img = null;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("standard_cover.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setPicture(img);
	}

	

	public void setPicture(String filename) {
		this.filename = filename;
		i = null;
		repaint();
	}

	

	public void setPicture(Image i) {
		if (i == null) {
			setDefaultPicture();
		} else {
			this.i = i;
		}
		repaint();
	}

	

	@Override
	public void paint(Graphics g) {
		try {
			i = i == null ? ImageIO.read(new File(filename)) : i;
			i = i.getScaledInstance(with, hight, java.awt.Image.SCALE_SMOOTH);
			g.drawImage(i, 0, 0, with, hight, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
