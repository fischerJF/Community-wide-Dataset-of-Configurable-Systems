package featureamp.gui; 

import java.awt.Color; 
import java.awt.Font; 
import java.awt.FontFormatException; 
import java.awt.Insets; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.io.InputStream; 

import javax.swing.JButton; 

@SuppressWarnings("serial")
public  class  IconButton  extends JButton {
	
	private static InputStream in;

	
	
	private static Font baseFont;

	
	
	private static Font iconFont;

	
	
	static {
		try {
			in = new FileInputStream(IconButton.class.getClassLoader().getResource("fontawesome.ttf").getPath());
			baseFont = Font.createFont(Font.TRUETYPE_FONT, in);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public IconButton(char c) {
//		if (specifications.Configuration.gui) {
			this(c, 15);
//				}
	}

	
	
	public IconButton(String t) {
//		if (specifications.Configuration.gui) {
			this(t, 15);
//				}
	}

	
	
	public IconButton(char c, int size)  {
//		if (specifications.Configuration.gui) {
			this(String.valueOf(c), size);
//				}
	}

	
	
	public IconButton(String t, int size)  {
		if (specifications.Configuration.gui) {
			iconFont = baseFont.deriveFont(Font.PLAIN, size);
			setMargin(new Insets(0, 0, 0, 0));
			setSize(25,25);
			setFont(iconFont);
			setText(t);
		    setForeground(Color.BLACK);
		    setBorder(null);
				}
	}


}
