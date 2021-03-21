
 
import java.awt.Container; 
import java.awt.FlowLayout; 
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
 
public  class  Suchen  extends JFrame {
	
    public String text;

	
    public JEditorPane view;

	
    public JDialog findDialog;

	
    Document dc ;

	
    JLabel searchContentLabel;

	
    public JTextField findText;

	
    public JCheckBox matchcase;

	
    ButtonGroup bGroup;

	
    public JRadioButton up;

	
    public JRadioButton down;

	
    
    
    public Suchen(JEditorPane mynote)
    {
		view = mynote;
		findDialog=new JDialog(this,"Suchen",true);
		dc = view.getDocument();
		try {
			text = dc.getText(0, dc.getLength());
		} catch (BadLocationException e2) {
			e2.printStackTrace();
		}
		Container con=findDialog.getContentPane();
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		searchContentLabel=new JLabel("Inhalt(N) :");
		findText=new JTextField(33);
		matchcase =new JCheckBox("Klein- und GrossBuchstaben(C)");

		bGroup=new ButtonGroup();
		up=new JRadioButton("Oben(U)");
		down=new JRadioButton("Unter(D)");
		down.setSelected(true);
		bGroup.add(up);
		bGroup.add(down);
		JButton searchNext=new JButton("Naechst(F)");
		
		searchNext.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e){
					find_next();
				}
		});
		
		JButton cancel=new JButton("cancel");
		cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					findDialog.dispose();
				}
		});
	
		JPanel bottomPanel=new JPanel();
		JPanel topPanel=new JPanel();
	
		JPanel direction=new JPanel();
		direction.setBorder(BorderFactory.createTitledBorder("Richtung"));
		direction.add(up);
		direction.add(down);

		topPanel.add(searchContentLabel);
		topPanel.add(findText);
		topPanel.add(searchNext);
		bottomPanel.add(matchcase);
		bottomPanel.add(direction);
		bottomPanel.add(cancel);

		con.add(topPanel);
		con.add(bottomPanel);
		
	
		findDialog.setSize(450,140);
		findDialog.setResizable(false);
		findDialog.setLocation(230,280);
		findDialog.setVisible(true);
		
	}

	
    
 public  int find_next(){



		
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
			JOptionPane.showMessageDialog(null, "koennen nicht suchen!", "Notepad",JOptionPane.INFORMATION_MESSAGE); 
			a = -1;
		
		}
		return a;
	
 }


}
