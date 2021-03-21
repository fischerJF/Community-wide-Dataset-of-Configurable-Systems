import java.awt.Container; 
import java.awt.Dimension; 
import java.awt.FlowLayout; 
import java.awt.Font; 
import java.awt.GraphicsEnvironment; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import javax.swing.BorderFactory; 
import javax.swing.JButton; 
import javax.swing.JDialog; 
import javax.swing.JEditorPane; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JList; 
import javax.swing.JPanel; 
import javax.swing.JScrollPane; 
import javax.swing.JTextField; 
import javax.swing.ListSelectionModel; 
import javax.swing.SwingConstants; 
import javax.swing.event.ListSelectionEvent; 
import javax.swing.event.ListSelectionListener; 

/**
 * TODO description
 */
public  class  FontDialog  extends JFrame  implements ActionListener {
	
	final JDialog fontDialog;

	
	final JTextField tfFont,tfSize,tfStyle;

	
    public JEditorPane view;

	
    private JButton fontOkButton;

	

	final int fontStyleConst[]={Font.PLAIN,Font.BOLD,Font.ITALIC,Font.BOLD+Font.ITALIC};

	
	final JList listStyle,listFont,listSize;

	
	JLabel sample;

	
	
	public FontDialog(JEditorPane mynote){
		view = mynote;
		fontDialog = new JDialog(this,"Font");
		Container con=fontDialog.getContentPane();
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		java.awt.Font currentFont=view.getFont();
		
		JLabel lblFont=new JLabel("Schriftart(F):");
		lblFont.setPreferredSize(new Dimension(100,20));
		JLabel lblStyle=new JLabel("Schriftschnitt(Y):");
		lblStyle.setPreferredSize(new Dimension(100,20));
		JLabel lblSize=new JLabel("Schriftgrad(S):");
		lblSize.setPreferredSize(new Dimension(100,20));
		tfFont=new JTextField(15);
		tfFont.setText(currentFont.getFontName());
		tfFont.selectAll();
		tfFont.setPreferredSize(new Dimension(200,20));
		tfStyle=new JTextField(15);
		if(currentFont.getStyle()==Font.PLAIN)
			tfStyle.setText("Normal");
		else if(currentFont.getStyle()==Font.BOLD)
			tfStyle.setText("Fett");
		else if(currentFont.getStyle()==Font.ITALIC)
			tfStyle.setText("Kursiv");
		else if(currentFont.getStyle()==(Font.BOLD+Font.ITALIC))
			tfStyle.setText("Fett und Kursiv");
			
		tfFont.selectAll();
		tfStyle.setPreferredSize(new Dimension(200,20));
		tfSize=new JTextField(8);
		tfSize.setText(currentFont.getSize()+"");
		tfSize.selectAll();
		tfSize.setPreferredSize(new Dimension(200,20));
	
							
					
		final String fontStyle[]={"Normal","Fett","Kursiv","Fett und Kursiv"};
		listStyle=new JList(fontStyle);
					
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		final String fontName[]=ge.getAvailableFontFamilyNames();
		int defaultFontIndex=0;
		for(int i=0;i<fontName.length;i++)
			{
				if(fontName[i].equals(currentFont.getFontName()))
					{
						defaultFontIndex=i;
						break;
					}
			}
		listFont=new JList(fontName);
		listFont.setSelectedIndex(defaultFontIndex);			
		listFont.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFont.setVisibleRowCount(7);
		listFont.setFixedCellWidth(82);
		listFont.setFixedCellHeight(20);
		listFont.addListSelectionListener(
			new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent event){
					tfFont.setText(fontName[listFont.getSelectedIndex()]);
					tfFont.requestFocus();
					tfFont.selectAll();	
					updateSample();
				}
			}
			);

		listStyle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if(currentFont.getStyle()==Font.PLAIN)
			listStyle.setSelectedIndex(0);
		else if(currentFont.getStyle()==Font.BOLD)
			listStyle.setSelectedIndex(1);
		else if(currentFont.getStyle()==Font.ITALIC)
			listStyle.setSelectedIndex(2);
		else if(currentFont.getStyle()==(Font.BOLD+Font.ITALIC))
			listStyle.setSelectedIndex(3);
		
		listStyle.setVisibleRowCount(7);
		listStyle.setFixedCellWidth(99);
		listStyle.setFixedCellHeight(20);
		listStyle.addListSelectionListener(
			new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent event){
					tfStyle.setText(fontStyle[listStyle.getSelectedIndex()]);
					tfStyle.requestFocus();
					tfStyle.selectAll();
					updateSample();	
				}
			}
			);			
		
		final String fontSize[]={"8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
		listSize=new JList(fontSize);
		int defaultFontSizeIndex=0;
		for(int i=0;i<fontSize.length;i++)
		{
			if(fontSize[i].equals(currentFont.getSize()+""))
			{
				defaultFontSizeIndex=i;
				break;
			}
		}
		listSize.setSelectedIndex(defaultFontSizeIndex);
		
		listSize.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSize.setVisibleRowCount(7);
		listSize.setFixedCellWidth(39);
		listSize.setFixedCellHeight(20);
		listSize.addListSelectionListener(
			new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent event){
					tfSize.setText(fontSize[listSize.getSelectedIndex()]);
					tfSize.requestFocus();
					tfSize.selectAll();	
					updateSample();
				}
			}
			);
		fontOkButton=new JButton("OK");
		fontOkButton.addActionListener(this);
		JButton cancelButton=new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fontDialog.dispose();
			}
		});
		
		sample=new JLabel("Notepad");
		sample.setHorizontalAlignment(SwingConstants.CENTER);
		sample.setPreferredSize(new Dimension(300,50));
		
		JPanel samplePanel=new JPanel();
		samplePanel.setBorder(BorderFactory.createTitledBorder("Beispiel"));
		samplePanel.add(sample);
		
		con.add(lblFont);
		con.add(lblStyle);
		con.add(lblSize);
		con.add(tfFont);
		con.add(tfStyle);
		con.add(tfSize);
		con.add(fontOkButton);
		con.add(new JScrollPane(listFont));
		con.add(new JScrollPane(listStyle));
		con.add(new JScrollPane(listSize));
		con.add(cancelButton);
		con.add(samplePanel);
		updateSample();
		
		
		fontDialog.setSize(350,340);
		fontDialog.setLocation(200,200);
		fontDialog.setResizable(false);
		fontDialog.setVisible(true);
		}

	
		
		public void updateSample(){
			Font sampleFont=new Font(tfFont.getText(),fontStyleConst[listStyle.getSelectedIndex()],Integer.parseInt(tfSize.getText()));
			sample.setFont(sampleFont);
		}

	
		
	
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==fontOkButton){
				Font tempFont=new java.awt.Font(tfFont.getText(),fontStyleConst[listStyle.getSelectedIndex()],Integer.parseInt(tfSize.getText()));
				view.setFont(tempFont);
				fontDialog.dispose();					
			}
		}


}
