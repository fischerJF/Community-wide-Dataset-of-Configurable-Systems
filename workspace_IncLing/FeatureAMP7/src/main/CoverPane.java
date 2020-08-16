package main; 

import javax.swing.*; 
import java.awt.*; 
import java.awt.AlphaComposite; 
import java.awt.Graphics2D; 
import java.awt.RenderingHints; 
import java.awt.image.BufferedImage; 
import java.io.IOException; 
import javax.imageio.ImageIO; 
import java.awt.event.*; 

public  class  CoverPane  extends JPanel {
	
  // Since JPanel is serializable, we need this
  static final long serialVersionUID = 1;

	
  
  private BufferedImage originalImage;

	
  JLabel label;

	
  int type;

	
  double ratio;

	
  
  public CoverPane(JFrame frame) {
		if (specifications.Configuration.showcover) {
	    try {
	      label = new JLabel();
	   
	      setCover(null);
	      resizeCover();
	      setMinimumSize(new Dimension(100, 100));
	      add(label);
	     } catch (Exception e) {
	      e.printStackTrace();
	    }
	     
	    frame.addComponentListener(new ComponentAdapter() { //neuer Listener fuer..
	      public void componentResized(ComponentEvent e) { //..Groessenaenderungen
	        SwingUtilities.invokeLater(new Runnable() {
	          public void run() {
	            resizeCover();
	          }
	        });
	      }
	    });
	  		}
	}

	
  
  public void resizeCover() {
    int height = getHeight()-10;
    int width  = getWidth()-10;
    
    if ((height < 0) || (width < 0)) {
      return;
    }
    
    if (height > (((double)width)*ratio)) {
      height = (int)(((double)width)*ratio);
    } else {
      width = (int)(((double)height)/ratio);
    }

    BufferedImage resizedImage = new BufferedImage(width, height, type);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, width, height, null);
    g.dispose();  
    g.setComposite(AlphaComposite.Src);
   
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    ImageIcon icon = new ImageIcon(resizedImage);
    
    label.setIcon(icon);
  }

	
  
  public void setCover(BufferedImage cover) {
    originalImage = cover;
    
    if (originalImage == null) {
      try {
        originalImage = ImageIO.read(getClass().getResourceAsStream("/main/default_cover.png"));
      } catch (IOException e) {
        e.printStackTrace();
        return;
      }
    }
    
    type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
    ratio = ((double)originalImage.getHeight())/((double)originalImage.getWidth());
    resizeCover();
  }


}
