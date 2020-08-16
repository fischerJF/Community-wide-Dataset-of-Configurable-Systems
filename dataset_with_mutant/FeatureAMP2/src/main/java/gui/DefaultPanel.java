package gui; 

import java.awt.Component; 

import javax.swing.JPanel;

import gui.DefaultLayout.ContentContainer;
import gui.DefaultLayout.View; 

/**
 * The DefaultPanel is an improved JPanel. It has the DefaultLayout as its
 * default layout manager. Because of this, it needs the view orientation.
 * 
 * @author joko
 * @version 1.1
 * @since 1.0
 * 
 */
@SuppressWarnings("serial")
public  class  DefaultPanel  extends JPanel {
	

	private ContentContainer content;

	

	/**
	 * Creates a new DefaultPanel with given components and auto gaps before and
	 * after the elements, if this is choosen.
	 * 
	 * @param orientation
	 * @param autoGapBefore
	 * @param autoGapAfter
	 * @param components
	 * @return a DefaultPanel which contains the given elements.
	 */
	public static DefaultPanel createInstance(View orientation,
			boolean autoGapBefore, boolean autoGapAfter,
			Component... components) {

		DefaultPanel p = new DefaultPanel(orientation);

		if (autoGapBefore)
			p.addAutoGap();
		p.addComponents(components);
		if (autoGapAfter)
			p.addAutoGap();

		return p;
	}

	

	/**
	 * Creates a new, improved JPanel.
	 * 
	 * @param viewOrientation
	 *            The orientation for the added elements.
	 */
	public DefaultPanel(View viewOrientation) {
		if (specifications.Configuration.gui) {
	
			DefaultLayout l = new DefaultLayout(this);
			content = l.newContentContainer(viewOrientation);
			l.setContentContainer(content);
				}
	}

	

	/**
	 * Adds some components to the panel.
	 * 
	 * @param comp
	 *            the components
	 */
	public void addComponents(Component... comp) {

		content.addComponents(comp);
	}

	

	/**
	 * Adds a gap between the last and the next element.
	 * 
	 * @param size
	 *            Size of the gap in pixels.
	 */
	public void addGap(int size) {

		content.addGap(size);
	}

	

	/**
	 * Adds a auto sized gap between the last and the next element.
	 */
	public void addAutoGap() {

		content.addAutoGap();
	}

	

	/**
	 * Adds a advanced gap between the last and the next element.
	 * 
	 * @param min
	 *            Minimum size of the gap.
	 * @param pref
	 *            Preferred size of the gap.
	 * @param max
	 *            Maximum size of the gap.
	 */
	public void addGap(int min, int pref, int max) {

		content.addGap(min, pref, max);
	}


}
