package main; 

import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.Rectangle; 
import java.awt.RenderingHints; 
import javax.swing.JComponent; 
import javax.swing.plaf.basic.BasicProgressBarUI; 
import java.awt.Color; 

import main.FeatureAmp; 

/** @see http://stackoverflow.com/questions/8884297 */
public  class  OwnUI  extends BasicProgressBarUI {
	

  private Rectangle r = new Rectangle();

	

  @Override
  protected void paintIndeterminate(Graphics g, JComponent c) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    r = getBox(r);
    g.setColor(FeatureAmp.getForegroundColor());
    g.fillOval(r.x, r.y, r.width, r.height);
  }

	
  
  @Override
  protected Color getSelectionForeground() {
    return FeatureAmp.getBackgroundColor();
  }

	
  
  @Override
  protected Color getSelectionBackground() {
    return FeatureAmp.getForegroundColor();
  }


}
