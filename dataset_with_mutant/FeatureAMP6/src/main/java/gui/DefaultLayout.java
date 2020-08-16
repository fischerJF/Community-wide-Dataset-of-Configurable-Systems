package gui; 

import java.awt.Component; 
import java.awt.Container; 

import javax.swing.GroupLayout; 

/**
 * The DefaultLayout is an improved Layoutmanager, based on the GroupLayout. For
 * creating the layout you give it its host container, the DefaultLAyout does
 * the rest for you. To add elements to the hostcontainer, you create a
 * ContentContainer and tells it in which direction it has to order the
 * elements.<br />
 * <br />
 * DefaultLayer HowTo:<br />
 * 1.) You create a container element, e.g. a JPanel and then you create the
 * DefaultLayout with your container as the parameter.<br />
 * 2.) You create a ContentContainer for all elements you want to put into your
 * container with the method
 * defaultLayout.newContentContainer(alignmentDirection);. The direction can be
 * DefaultLayout.View.HORIZONTAL for a horizontal element order or
 * DefaultLayout.View.VERTICAL for a vertical element order.<br />
 * 3.) All the elements you want to put into the container you add to the
 * ContentContainer with the methods addContentContainer, addComponents,
 * addComponent, addGap, addAutoGap.<br />
 * <br />
 * Example:<br />
 * You want to create a window like this:<br />
 * <code>
 * |------------------------------------------------|<br />
 * |Some text ..................................... |<br />
 * ||----------------------------------------------||<br />
 * ||Text input area ............................. ||<br />
 * || ............................................ ||<br />
 * ||----------------------------------------------||<br />
 * |Some other text ............... [Button][Button]|<br />
 * |------------------------------------------------|<br />
 * </code> <br />
 * The code could look like this:<br />
 * <code>
 *  // Creates a window.<br />
 * JFrame f = new JFrame();<br />
 * <br />
 *  // Creating the panel, the layout and the content container<br /> 
 * JPanel contentPane = new JPanel();<br />
 * DefaultLayout layout = new DefaultLayout(contentPane);<br />
 * ContentContainer cc = layout.newContentContainer(DefaultLayout.View.VERTICAL);<br />
 * <br />
 *  // Creating an other  content container for the last row in the window<br />
 * ContentContainer bottomCc = bottomLayout.newContentContainer(DefaultLayout.View.HORIZONTAL);<br />
 * <br />
 *  // Creating all gui elements we want to show in the window<br />
 * JLabel textOnTop = new JLabel("Please enter your text!");<br />
 * JTextArea textArea = new JTextArea();<br />
 * JScrollPane scrollableTextArea = new JScrollPane(textArea);<br />
 * JLabel textOnBottom = new JLabel("Do you want to safe?");<br />
 * JButton cancel = new JButton("Cancel);<br />
 * JButton save = new JButton("Save);<br />
 * <br />
 *  // Putting the elements for the last row into the panels layout content container. Notice the<br />
 *  // gap between the text and the buttons. This will align the buttons at the right window side.<br />
 * bottomCc.addComponents(textOnBottom);<br />
 * bottomCc.addAutoGap();<br />
 * bottomCc.addComponents(cancel, save);<br />
 *  // Putting the elements for the window into the panels layout content container.<br />
 * cc.addComponents(textOnTop, scrollableTextArea);<br />
 * cc.addContentContainer(bottomCc);<br />
 * <br />
 *  // Setting up the window<br />
 * f.setContentPane(contentPane);<br />
 * f.pack();<br />
 * f.setVisible(true);<br />
 * </code>
 * 
 * @author joko
 * @version 1.0
 * @since 1.0
 * 
 */
public  class  DefaultLayout  extends GroupLayout {
	

	/**
	 * Creates a new DefaultLayout.
	 * 
	 * @param host
	 *            The container to which the new layout contains.
	 */
	public DefaultLayout(Container host) {
//		if (specifications.Configuration.base) {
	
			super(host);
			host.setLayout(this);
			super.setAutoCreateContainerGaps(true);
			super.setAutoCreateGaps(true);
//				}
	}

	

	/**
	 * Creates a content container with the order direction of the container.
	 * 
	 * @param view
	 *            It could be DefaultLayout.View.{HORIZONTAL or VERTICAL}
	 * @return a fresh and empty content container.
	 */
	public ContentContainer newContentContainer(View view) {

		Group sequential = createSequentialGroup();
		Group parallel = createParallelGroup();
		switch (view) {
		case HORIZONTAL:
			return new ContentContainer(sequential, parallel);
		case VERTICAL:
			return new ContentContainer(parallel, sequential);
		}
		return null;
	}

	

	/**
	 * Adds a content container to this content container. It gives you the
	 * possibility to create advanced layouts.
	 * 
	 * @param cc
	 *            The other content container.
	 */
	public void setContentContainer(ContentContainer cc) {

		setHorizontalGroup(cc.horizontal);
		setVerticalGroup(cc.vertical);
	}

	

	/**
	 * Do not use it, the DefaultLayout enables it automatically.
	 */
	@Deprecated
	@Override
	public void setAutoCreateContainerGaps(boolean autoCreateContainerPadding) {
		super.setAutoCreateContainerGaps(autoCreateContainerPadding);
	}

	

	/**
	 * Do not use it, the DefaultLayout enables it automacally.
	 */
	@Deprecated
	@Override
	public void setAutoCreateGaps(boolean autoCreateGaps) {
		super.setAutoCreateGaps(autoCreateGaps);
	}

	

	/**
	 * The ContentContainer class is the wrapper for the elements which are put
	 * into the container. You do not put the elements directly into the
	 * container, you put the elements into the content container and then the
	 * layout manager puts your elements correctly into the container.
	 * 
	 * @author joko
	 * @version 1.0
	 * @since 1.0
	 * 
	 */
	public  class  ContentContainer {
		

		private Group horizontal;

		
		private Group vertical;

		

		private ContentContainer(Group h, Group v) {
		if (specifications.Configuration.base) {
	
				horizontal = h;
				vertical = v;
					}
	}

		

		/**
		 * Adds other content containers to this content container. You can put
		 * as much containers in here as you want.
		 * 
		 * @param cc
		 *            content containers.
		 * @return Itself, so you can call the method iterativly.
		 */
		public ContentContainer addContentContainers(ContentContainer... cc) {

			for (ContentContainer g : cc) {
				horizontal.addGroup(g.horizontal);
				vertical.addGroup(g.vertical);
			}
			return this;
		}

		

		/**
		 * Adds components to your to this content container. You can put as
		 * much components in here as you want.
		 * 
		 * @param comps
		 *            components.
		 * @return Itself.
		 */
		public ContentContainer addComponents(Component... comps) {

			for (Component c : comps) {
				horizontal.addComponent(c);
				vertical.addComponent(c);
			}
			return this;
		}

		

		/**
		 * Adds a gap between the last and the next element.
		 * 
		 * @param size
		 *            The size of the gap in pixels.
		 * @return Itself.
		 */
		public ContentContainer addGap(int size) {

			horizontal.addGap(size);
			vertical.addGap(size);
			return this;
		}

		

		/**
		 * Adds a variable gap between the last and the next element. Normally
		 * you should use this method if you want to some elemts at the left and
		 * some other at the right border.
		 * 
		 * @return Itself
		 */
		public ContentContainer addAutoGap() {

			return addGap(0, 0, Integer.MAX_VALUE);
		}

		

		/**
		 * Adds an other variable gap between the last and the next element.
		 * 
		 * @param min
		 *            Minimum size of the gap.
		 * @param pref
		 *            Preferred size of the gap.
		 * @param max
		 *            Maximum size of the gap.
		 * @return Itself.
		 */
		public ContentContainer addGap(int min, int pref, int max) {

			horizontal.addGap(min, pref, max);
			vertical.addGap(min, pref, max);
			return this;
		}


	}

	

	/**
	 * The View is a set of constants for the orientation of a content
	 * container.
	 * 
	 * @author joko
	 * @version 1.0
	 * @since 1.0
	 * 
	 */
	public enum  View {
		HORIZONTAL ,  VERTICAL}


}
