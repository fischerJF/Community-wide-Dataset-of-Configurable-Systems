import java.awt.Container; 
import java.awt.FlowLayout; 
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import javax.swing.BorderFactory; 
import javax.swing.ButtonGroup; 
import javax.swing.JButton; 
import javax.swing.JCheckBox; 
import javax.swing.JDialog; 
import javax.swing.JEditorPane; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.JPanel; 
import javax.swing.JRadioButton; 
import javax.swing.JTextField; 
import javax.swing.text.BadLocationException; 
import javax.swing.text.Document; 
 
public  class  Ersetzen  extends JFrame {
	
    String text;

	
    public JEditorPane view;

	
    public JDialog replaceDialog;

	
    Document dc ;

	
    JLabel searchContentLabel;

	
    JLabel replaceContentLabel;

	
    public JTextField findText;

	
    public JTextField replaceText;

	
    public JCheckBox matchcase;

	
    ButtonGroup bGroup;

	
    public JRadioButton up;

	
    public JRadioButton down;

	
    public JButton replaceAll;

	
    
    
    public Ersetzen(JEditorPane mynote)
    {
		view = mynote;
		replaceDialog=new JDialog(this,"Ersetzen",true);
		dc = view.getDocument();
		try {
			text = dc.getText(0, dc.getLength());
		} catch (BadLocationException e2) {
			e2.printStackTrace();
		}
		Container con=replaceDialog.getContentPane();
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		searchContentLabel=new JLabel("Inhalt(N) :");
		replaceContentLabel=new JLabel("Ersetzen wie(P) :");
		findText=new JTextField(30);
		replaceText=new JTextField(26);
		matchcase =new JCheckBox("Klein- und Grossbuchstaben(C)");

		bGroup=new ButtonGroup();
		up=new JRadioButton("Oben(U)");
		down=new JRadioButton("Unter(D)");
		down.setSelected(true);
		bGroup.add(up);
		bGroup.add(down);
		JButton replace=new JButton("Ersetzen(R)");
		replaceAll=new JButton("Ersetzen Alles(A)");
		
	
		replace.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int a = 0, b =0; 
				int FindStartPos=view.getCaretPosition();
				String str1, str2, str3, str4, strA, strB; 
				str1 = text; 
				str2 = str1.toLowerCase(); 
				str3 = findText.getText(); 
				str4 = str3.toLowerCase(); 
										
	
				if(matchcase.isSelected()) { 
					strA = str1; 
					strB = str3; 
				} 
				else { 
					strA = str2; 
					strB = str4; 
				} 
			
				if(up.isSelected()){
					
					if(view.getSelectedText()==null){							
						a = strA.lastIndexOf(strB, FindStartPos-1);
					}
					else{
					a = strA.lastIndexOf(strB, FindStartPos-findText.getText().length()-1);	
					}
				}
				else if(down.isSelected()){
						
					if(view.getSelectedText()==null){
						a = strA.indexOf(strB, FindStartPos);
					}
					else{
						a=strA.indexOf(strB,FindStartPos-findText.getText().length()+1);
					}
						
				}
				
				if(a > -1) { 
					if(up.isSelected()){
						view.setCaretPosition(a);
						b = findText.getText().length(); 
						view.select(a, a + b); 
					
					}
					else if(down.isSelected()){
						view.setCaretPosition(a); 
						b = findText.getText().length(); 
						view.select(a, a + b);
					
					
					}
				}
				else { 
					JOptionPane.showMessageDialog(null, "Schon ALles ersetzt!", "Bitte",JOptionPane.INFORMATION_MESSAGE); 
					a = -1;
				
				}

				if(replaceText.getText().length() == 0 && view.getSelectedText() != null)
					view.replaceSelection("");
				
				if(replaceText.getText().length() > 0 && view.getSelectedText() != null) 
					view.replaceSelection(replaceText.getText()); 
				}
		});
		

		replaceAll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				view.setCaretPosition(0);	
				int a=0,b=0,replaceCount=0;
					
				if(findText.getText().length()==0)
					{
						JOptionPane.showMessageDialog(replaceDialog,"Bitte Inhalt anschreiben!","Bitte",JOptionPane.WARNING_MESSAGE);
						findText.requestFocus(true);
						return;
					}
				while( a > -1) { 
														 
					int FindStartPos=view.getCaretPosition();
					String str1 = null, str2, str3, str4, strA, strB; 
					str1 = text;
					str2 = str1.toLowerCase(); 
					str3 = findText.getText(); 
					str4 = str3.toLowerCase(); 
					
					if(matchcase.isSelected()) { 
						strA = str1; 
						strB = str3; 
					} 
					else { 
						strA = str2; 
						strB = str4; 
					} 
					
					if(up.isSelected()){						
						if(view.getSelectedText()==null){							
							a = strA.lastIndexOf(strB, FindStartPos-1);
						}
						else
						{
							a = strA.lastIndexOf(strB, FindStartPos-findText.getText().length()-1);	
						}
					}
					else if(down.isSelected())
						{
							if(view.getSelectedText()==null){
							a = strA.indexOf(strB, FindStartPos);
							}
							else
							{
							a=strA.indexOf(strB,FindStartPos-findText.getText().length()+1);
							}
							
					}
					
					if(a > -1) { 
						if(up.isSelected()){
							view.setCaretPosition(a);
							b = findText.getText().length(); 
							view.select(a, a + b); 
							}
						else if(down.isSelected()){
							view.setCaretPosition(a); 
							b = findText.getText().length(); 
							view.select(a, a + b);
						}
					}			 
					else { 
						if(replaceCount==0){
							JOptionPane.showMessageDialog(replaceDialog, "Kein Inhalt", "Notepad",JOptionPane.INFORMATION_MESSAGE); 
						}
						else
						{
							JOptionPane.showMessageDialog(replaceDialog,"Es gibt "+replaceCount+" Ersetzen!","Erfolg",JOptionPane.INFORMATION_MESSAGE);
						}
					} 
					
					if(replaceText.getText().length() == 0 && view.getSelectedText() != null){
						view.replaceSelection("");
						replaceCount++;
					} 
					
					if(replaceText.getText().length() > 0 && view.getSelectedText() != null) 
					{
						view.replaceSelection(replaceText.getText()); 
						replaceCount++;
					}
				}//end while
			}
		});
		
		JButton cancel=new JButton("Abbrechen");
		cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					replaceDialog.dispose();
				}
		});
	

		JPanel bottomPanel=new JPanel();
		JPanel centerPanel=new JPanel();
		JPanel topPanel=new JPanel();
	
		JPanel direction=new JPanel();
		direction.setBorder(BorderFactory.createTitledBorder("Richtung"));
		direction.add(up);
		direction.add(down);
		
		JPanel replacePanel=new JPanel();
		replacePanel.setLayout(new GridLayout(1,1));
		replacePanel.add(replaceAll);

		topPanel.add(searchContentLabel);
		topPanel.add(findText);
		topPanel.add(replace);
		centerPanel.add(replaceContentLabel);
		centerPanel.add(replaceText);
		centerPanel.add(replacePanel);
		bottomPanel.add(matchcase);
		bottomPanel.add(direction);
		bottomPanel.add(cancel);

		con.add(topPanel);
		con.add(centerPanel);
		con.add(bottomPanel);
		
		replaceDialog.setSize(450,180);
		replaceDialog.setResizable(false);
		replaceDialog.setLocation(230,280);
		replaceDialog.setVisible(true);
		
	}


}
