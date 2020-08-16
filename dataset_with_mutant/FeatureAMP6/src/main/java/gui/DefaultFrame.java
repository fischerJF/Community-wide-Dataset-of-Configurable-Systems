package gui; 

import java.awt.Toolkit; 

import javax.swing.JFrame; 
import javax.swing.UIManager; 

/**
 * The DefaultFrame is an improved JFrame. You can instantiate it with two float
 * values to set an automatic position, relative to the window size.
 * 
 * @author joko
 * 
 */
@SuppressWarnings("serial")
public  class  DefaultFrame  extends JFrame {
	

	private float xDistance, yDistance;

	
	private boolean autoLocation;

	

	/** Constants for auto position. */
	public static final float FIFTH = 0.2f, QUATER = 0.25f, THIRD = 0.33f,
			HALF = 0.5f;

	

	/** Creates a new DefaultFrame without auto position enabled. */
	public DefaultFrame() {
//		if (specifications.Configuration.base) {
	
			this(0, 0);
			autoLocation = false;
//				}
	}

	

	/**
	 * Creates a new DefaultFrame with auto position enabled. The value xDist
	 * describes how much of the free screen space is left of the window, yDist
	 * describes how much of the free screen space is above the window.
	 * 
	 * @param xDist
	 * @param yDist
	 */
	public DefaultFrame(float xDist, float yDist) {
		if (specifications.Configuration.base) {
	
			autoLocation = true;
			xDistance = xDist > 1f ? 1f : xDist < 0f ? 0f : xDist;
			yDistance = yDist > 1f ? 1f : yDist < 0f ? 0f : yDist;
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
	}

	

	/**
	 * Evereytime, you change the visibility of the window, it automatically
	 * packs the elements in the window.
	 */
	@Override
	public void setVisible(boolean b) {

		pack();
		super.setVisible(b);
	}

	

	/**
	 * Everytime you pack the window it will reposition it, if autoPosition is
	 * enabled.
	 */
	@Override
	public void pack() {

		super.pack();
		autoLocation();
	}

	

	private void autoLocation() {

		if (autoLocation) {
			int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
			int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
			int windowWidth = getWidth();
			int windowHeight = getHeight();

			int xFree = screenWidth - windowWidth;
			int yFree = screenHeight - windowHeight;

			int xPos = (int) ((float) xFree * xDistance);
			int yPos = (int) ((float) yFree * yDistance);

			setLocation(xPos, yPos);
		}
	}


}
