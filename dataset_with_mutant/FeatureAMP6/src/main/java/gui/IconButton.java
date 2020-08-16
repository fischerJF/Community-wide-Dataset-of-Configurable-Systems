package gui; 

import java.awt.event.ActionListener; 

import javax.swing.Icon; 
import javax.swing.JButton; 
import javax.swing.border.EmptyBorder; 

public  class  IconButton  extends JButton {
	

	private static final long serialVersionUID = -1660041958943904773L;

	

	public IconButton(Icon icon, ActionListener l) {
//		if (specifications.Configuration.base) {
			super(icon);
			setBorder(new EmptyBorder(0, 0, 0, 0));
			setBorderPainted(false);
			addActionListener(l);
//				}
	}


}
