
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import java.io.EOFException; import java.io.File; 
import java.io.IOException; 

import java.net.MalformedURLException; 
import java.net.URL; 

import java.awt.GridLayout; 
import java.awt.Toolkit; 
import java.awt.Dimension; 

import javax.swing.filechooser.FileFilter; 

import javax.swing.JFileChooser; 

import javax.swing.JMenu; 
import javax.swing.JMenuItem; 

import javax.swing.UIManager; 

import javax.swing.ImageIcon; 
import javax.swing.JOptionPane; 
import javax.swing.undo.UndoManager; import java.awt.Button; 
import java.awt.Frame; 
import java.awt.Label; 
import java.awt.TextField; 

import javax.swing.ButtonGroup; 
import javax.swing.JRadioButton; import java.awt.Color; 

import javax.swing.JCheckBoxMenuItem; 
import javax.swing.JColorChooser; 

/**
 * TODO description
 */
public   class  Main   extends javax.swing.JFrame {
	
    
	private static int member = 0;

	
	
    public Main() {
	    setNativeLAF();
	    initComponents();
	    initApp();
	}

	

	public static void main(String args[]) throws IOException {
	    java.awt.EventQueue.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            new Main().setVisible(true);
	        }
	    });
	}

	

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	  private void  initComponents__wrappee__VISTEX  () {
	    OverwriteDialog = new javax.swing.JDialog();
	    OverwriteDLabel = new javax.swing.JLabel();
	    OverwriteDAbord = new javax.swing.JButton();
	    OverwriteDOK = new javax.swing.JButton();
	    
	    ErrorDialog = new javax.swing.JDialog();
	    ErrorDOK = new javax.swing.JButton();
	    ErrorDLabel = new javax.swing.JLabel();
	    
	    Info = new javax.swing.JDialog();
	    info_label = new javax.swing.JLabel();
	    info_button = new javax.swing.JButton();
	    jScrollPane1 = new javax.swing.JScrollPane();
	    editorPane = new javax.swing.JEditorPane();
	    
	    
	    jMenuBar1 = new javax.swing.JMenuBar();
	    initMenuBarItems();
	    
	    OverwriteDialog.setIconImage(null);
	    OverwriteDialog.setModal(true);
	    OverwriteDialog.setResizable(false);
	
	    OverwriteDLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    OverwriteDLabel.setText("jLabel1");
	
	    OverwriteDAbord.setText("Abbrechen");
	    OverwriteDAbord.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            OverwriteDAbordActionPerformed(evt);
	        }
	    });
	
	    OverwriteDOK.setText("Überschreiben");
	    OverwriteDOK.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            OverwriteDOKActionPerformed(evt);
	        }
	    });
	
	    javax.swing.GroupLayout OverwriteDialogLayout = new javax.swing.GroupLayout(OverwriteDialog.getContentPane());
	    OverwriteDialog.getContentPane().setLayout(OverwriteDialogLayout);
	    OverwriteDialogLayout.setHorizontalGroup(
	        OverwriteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(OverwriteDialogLayout.createSequentialGroup()
	            .addContainerGap()
	            .addGroup(OverwriteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(OverwriteDialogLayout.createSequentialGroup()
	                    .addComponent(OverwriteDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
	                    .addContainerGap())
	                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OverwriteDialogLayout.createSequentialGroup()
	                    .addComponent(OverwriteDOK, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                    .addComponent(OverwriteDAbord)
	                    .addGap(75, 75, 75))))
	    );
	    OverwriteDialogLayout.setVerticalGroup(
	        OverwriteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(OverwriteDialogLayout.createSequentialGroup()
	            .addContainerGap()
	            .addComponent(OverwriteDLabel)
	            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
	            .addGroup(OverwriteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                .addComponent(OverwriteDAbord)
	                .addComponent(OverwriteDOK))
	            .addContainerGap())
	    );
	
	    ErrorDialog.setModal(true);
	    ErrorDialog.setResizable(false);
	
	    ErrorDOK.setText("OK");
	    ErrorDOK.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            ErrorDOKActionPerformed(evt);
	        }
	    });
	
	    ErrorDLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    ErrorDLabel.setText("jLabel1");
	
	    javax.swing.GroupLayout ErrorDialogLayout = new javax.swing.GroupLayout(ErrorDialog.getContentPane());
	    ErrorDialog.getContentPane().setLayout(ErrorDialogLayout);
	    ErrorDialogLayout.setHorizontalGroup(
	        ErrorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(ErrorDialogLayout.createSequentialGroup()
	            .addGroup(ErrorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(ErrorDialogLayout.createSequentialGroup()
	                    .addContainerGap()
	                    .addComponent(ErrorDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
	                .addGroup(ErrorDialogLayout.createSequentialGroup()
	                    .addGap(235, 235, 235)
	                    .addComponent(ErrorDOK, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
	            .addContainerGap())
	    );
	    ErrorDialogLayout.setVerticalGroup(
	        ErrorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(ErrorDialogLayout.createSequentialGroup()
	            .addContainerGap()
	            .addComponent(ErrorDLabel)
	            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
	            .addComponent(ErrorDOK)
	            .addContainerGap())
	    );
	
	    Info.setModal(true);
	    Info.setResizable(false);
	
	    info_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	    info_label.setText("hash");
	
	    info_button.setText("OK");
	    info_button.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            info_buttonActionPerformed(evt);
	        }
	    });
	
	    javax.swing.GroupLayout InfoLayout = new javax.swing.GroupLayout(Info.getContentPane());
	    Info.getContentPane().setLayout(InfoLayout);
	    InfoLayout.setHorizontalGroup(
	        InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(InfoLayout.createSequentialGroup()
	            .addGroup(InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(InfoLayout.createSequentialGroup()
	                    .addContainerGap()
	                    .addComponent(info_label, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
	                .addGroup(InfoLayout.createSequentialGroup()
	                    .addGap(141, 141, 141)
	                    .addComponent(info_button, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
	            .addContainerGap())
	    );
	    InfoLayout.setVerticalGroup(
	        InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(InfoLayout.createSequentialGroup()
	            .addContainerGap()
	            .addComponent(info_label)
	            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
	            .addComponent(info_button)
	            .addContainerGap())
	    );
	
	    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	    setName(""); // NOI18N
	
	    editorPane.setDoubleBuffered(true);
	    editorPane.setMargin(new java.awt.Insets(7, 7, 7, 7));
	    editorPane.setSelectionColor(new java.awt.Color(168, 51, 94));
	    editorPane.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyReleased(java.awt.event.KeyEvent evt) {
	            textEntered(evt);
	        }
	    });
	    jScrollPane1.setViewportView(editorPane);
	    
	    doTheMenuBars();
	    doTheLayout();
	}

	
	 public void initComponents()  {
		 initComponents__wrappee__VISTEX();
		 undoMg = new UndoManager();
		 editorPane.getDocument().addUndoableEditListener(undoMg);
		 undoItem = new javax.swing.JMenuItem();
		
	        undoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
	        undoItem.setText("Undo");
	        undoItem.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                undoItemActionPerformed(evt);
	            }
	        });
	        editMenu.add(undoItem);
	        jMenuBar1.add(editMenu);
	       
	}

	
	
	 private void  doTheLayout__wrappee__VISTEX  () {
		this.getContentPane().setLayout(new GridLayout(0, member, 0, 0));
		System.out.println();
	}

	
 	
	private void doTheLayout() {
		member++;
		doTheLayout__wrappee__VISTEX();
		this.add(jScrollPane1);
	}

	
	
	 private void  doTheMenuBars__wrappee__VISTEX  () {
		 setJMenuBar(jMenuBar1);
	}

	
	
	 private void  doTheMenuBars__wrappee__Editor  () {
		doTheMenuBars__wrappee__VISTEX();
		fileMenu.setText("Datei");
		
	    jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
	    jMenuItem3.setText("Neu");
	    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            new_document(evt);
	        }
	    });
	    fileMenu.add(jMenuItem3);
	
	    openItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
	    openItem.setText("Öffnen");
	    openItem.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            openItemActionPerformed(evt);
	        }
	    });
	    fileMenu.add(openItem);
	

	
	    exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
	    exitItem.setText("Beenden");
	    exitItem.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            closeClicked(evt);
	        }
	    });
		
	    fileMenu.add(exitItem);
	
	 
	

	

	    
	    hashMenu.setText("Hash");
	    hashMenu.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	            hashMenuMouseClicked(evt);
	        }
	    });
	    
	    jMenuBar1.add(fileMenu);

	    jMenuBar1.add(hashMenu);	    
	}

	
	  private void  doTheMenuBars__wrappee__Suchen  ()  {
		 doTheMenuBars__wrappee__Editor();
		 suchItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
	        suchItem.setText("Such");
	        suchItem.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                 new Suchen(s.editorPane);
	            }
	        });
	        editMenu.add(suchItem);
	 }

	
	  private void  doTheMenuBars__wrappee__Ersetzen  () {
		 doTheMenuBars__wrappee__Suchen();
		 ersetzItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
	        ersetzItem.setText("Ersetzen");
	        ersetzItem.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                 new Ersetzen(s.editorPane);
	            }
	        });
	        editMenu.add(ersetzItem);
	 }

	
	 private void  doTheMenuBars__wrappee__Schriftgroesse  ()  {
		doTheMenuBars__wrappee__Ersetzen();
		
		formatMenu_Font.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		formatMenu_Font.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	editorPane.requestFocus();
            	new FontDialog(s.editorPane);
            }
        });
		formatMenu.add(formatMenu_Font); 
	}

	
	 private void  doTheMenuBars__wrappee__Farbe  ()  {
		 	doTheMenuBars__wrappee__Schriftgroesse();
			formatMenu_Color_FgColor.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	editorPane.requestFocus();
					Color color=JColorChooser.showDialog(s,"Schriftfarbe",Color.black);
					if(color!=null)
					{
						editorPane.setForeground(color);
					} 
					else
						return;
	            }
	        });
			
			formatMenu_Color_BgColor.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	editorPane.requestFocus();
					Color color=JColorChooser.showDialog(s,"Hintergrundfarbe",Color.white);
					if(color!=null)
					{
						editorPane.setBackground(color);
					} 
					else
						return;
	            }
	        });
			formatMenu.addSeparator();
			formatMenu.add(formatMenu_Color);
			formatMenu_Color.add(formatMenu_Color_FgColor);
			formatMenu_Color.add(formatMenu_Color_BgColor);
			jMenuBar1.add(formatMenu);
		 
	 }

	
	 private void  doTheMenuBars__wrappee__Textformat  () {
	
		doTheMenuBars__wrappee__Farbe();
	    saveItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
	    saveItem.setText("Speichern als Text");
	    saveItem.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            saveItemActionPerformed(evt);
	        }
	    });
	    fileMenu.add(saveItem);
	
	}

	
	 private void  doTheMenuBars__wrappee__Exportieren  () {
	
		doTheMenuBars__wrappee__Textformat();
	    exportMenu.setText("Exportieren als...");
	    jMenuBar1.add(exportMenu);
	
	}

	
	 private void  doTheMenuBars__wrappee__KomprimierterText  () {
	
		doTheMenuBars__wrappee__Exportieren();
	    jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
	    jMenuItem2.setText("komprimierter Text");
	    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            jMenuItem2ActionPerformed(evt);
	        }
	    });
	    exportMenu.add(jMenuItem2);
	
	}

	
    
	private void doTheMenuBars() {
	
		doTheMenuBars__wrappee__KomprimierterText();
	    jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
	    jMenuItem1.setText("HTML");
	    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            jMenuItem1ActionPerformed(evt);
	        }
	    });
	    
	    exportMenu.add(jMenuItem1);
	
	}

	
	
	 private void  initMenuBarItems__wrappee__Editor  () {
		fileMenu = new javax.swing.JMenu();
	    hashMenu = new javax.swing.JMenu();

	    jMenuItem3 = new javax.swing.JMenuItem();
	    
	    openItem = new javax.swing.JMenuItem();
	    exitItem = new javax.swing.JMenuItem();

	}

	
	  private void  initMenuBarItems__wrappee__Edieren  (){
		 editMenu = new javax.swing.JMenu("Editor");
		 initMenuBarItems__wrappee__Editor();
	 }

	
	 
	  private void  initMenuBarItems__wrappee__Suchen  (){
		 initMenuBarItems__wrappee__Edieren();
		 suchItem = new javax.swing.JMenuItem();
		 
	 }

	
	  private void  initMenuBarItems__wrappee__Ersetzen  (){
		 initMenuBarItems__wrappee__Suchen();
		 ersetzItem = new javax.swing.JMenuItem();
	 }

	
	  private void  initMenuBarItems__wrappee__Formatierung  (){
		 formatMenu = new JMenu("Format", true);
		 initMenuBarItems__wrappee__Ersetzen();
	 }

	
	  private void  initMenuBarItems__wrappee__Schriftgroesse  (){
		 initMenuBarItems__wrappee__Formatierung();
		 formatMenu_Font = new JMenuItem("Schriftgroesse...");
	 }

	
	  private void  initMenuBarItems__wrappee__Farbe  (){
		 initMenuBarItems__wrappee__Schriftgroesse();
		 formatMenu_Color = new JMenu("Farbe"); 
		 formatMenu_Color_FgColor=new  JMenuItem("Schrift Farbe");
		 formatMenu_Color_BgColor=new JMenuItem("Hintergrund Farbe");
		 
	 }

	
	
	 private void  initMenuBarItems__wrappee__Textformat  () {
		initMenuBarItems__wrappee__Farbe();
	    saveItem = new javax.swing.JMenuItem();

	}

	
	
	 private void  initMenuBarItems__wrappee__Exportieren  () {
		initMenuBarItems__wrappee__Textformat();
		exportMenu = new javax.swing.JMenu();


	}

	//GEN-LAST:event_jMenuItem2ActionPerformed
	
	 private void  initMenuBarItems__wrappee__KomprimierterText  () {
		initMenuBarItems__wrappee__Exportieren();
	    jMenuItem2 = new javax.swing.JMenuItem();

	}

	
	private void initMenuBarItems() {
		initMenuBarItems__wrappee__KomprimierterText();
	    jMenuItem1 = new javax.swing.JMenuItem();
	}

	
	
	/*
     * defines Toolkit to get screen dimensions
     * myscreeen is the toolkit getting the whole screen width and height
     * designerWidth, -height, -size are the default attributes of the window
     */
    private static final Dimension myscreen = Toolkit.getDefaultToolkit().getScreenSize();

	

    /*
     * defines the width and height of App an saves
     * it into an Dimension designerSize
     */
    private static final int designerWidth = 653;

	
    private static final int designerHeight = 484;

	
    private static final Dimension designerSize = new Dimension(designerWidth, designerHeight);

	

    /*
     * defines the ratio for width and height in screen
     */
    private static final float goldenratioX = (float) .5;

	
    private static final float goldenratioY = (float) .32;

	
    protected static final byte hashBlocksize = (byte) 4;

	

    private File fileOnStack = null;

	
    private String purposeOnStack = null;

	
    private String txtOnStack = null;

	
    private boolean forceFromStack = false;

	
    private String current_hash = "";

	

    /*
     * is the icon shown for the App
     *
     * image icon and task is to be imported into JAR-file
     */
    private static ImageIcon icon_res = new ImageIcon("jte.png");

	
    private URL icon_image_resource;

	
    private URL task_resource;

	

    /*
     * defaultTitle is the title proposed and currentTitle is the title of the file
     * untill saving / loading
     * changedContentMarkInTitle, defaultPrefixInTitle and defaultPostfixInTitle are
     * variables to handle the title deliver a proper design
     */
    private static final String defaultTitle = "untitled";

	
    private String currentTitle = defaultTitle;

	
    private static final char changedContentMarkInTitle = '*';

	
    private static final String defaultPrefixInTitle = "(";

	
    private static final String defaultPostfixInTitle = ") Java Text Editor";

	
    private File MainPath = new File("");

	
    private File currentFilePath = null;

	
    private boolean autosave = false;

	

    /**
     * default extention for zipped texts - adapts downwards automaticly
     */
    private static String name_txtzipped = "zippedtxt";

	
    
    /*
     * defines the sizes and button-text's for overwriting dialogs
     * in the GUI
     */
    private static final int OverwriteDialogSizeW = 550;

	
    private static final int OverwriteDialogSizeH = 123;

	
    private static final String OverwriteDialogLabelPre = "Möchten Sie die bestehende Datei ";

	
    private static final String OverwriteDialogLabelPost = " Überschreiben?";

	
    private static final String OverwriteDialogTitle = "Überschreiben?";

	
    private static final String OverwriteDialogOK = "Überschreiben";

	
    private static final String OverwriteDialogAbord = "Abbrechen";

	

    /*
     * defines the size and button-text for any error dialog
     * shown with custom messages (see also this)
     */
    private static final int ErrorDialogSizeW = 662;

	
    private static final int ErrorDialogSizeH = 104;

	
    private static final String ErrorDialogOK = "OK";

	


    /*
     * defines the size and button-text for any info dialog
     * shown with custom messages (see also this)
     */
    private static final int InfoDialogSizeW = 505;

	
    private static final int InfoDialogSizeH = 95;

	
    private static final String InfoDialogOK = "OK";

	
    private static final String InfoDialogTitle = "Hash";

	


    /*
     * defines the custom dialogs shown when Exceptions are
     * being thrown in file reading/writing
     */
    private static final String ErrorEOFr = "Es konnte kein EOF (Dateiende) gefunden werden!";

	
    private static final String ErrorTooLessSpacew = "Es wurde zuwenig Speicherplatz für diese Operation gefunden werden.";

	
    private static final String ErrorIOr = "Die Datei konnte nicht erfoglreich geöffnet werden.";

	
    private static final String ErrorIOw = "Die Datei konnte nicht erfolgreich geschrieben werden.";

	
    private static final String ErrorGZIPr = "Der Text konnte nicht dekomprimiert werden.";

	
    private static final String ErrorGZIPw = "Der Text konnte nicht komprimiert werden.";

	


    //enth�lt den HashCode der letzten Speicherung
    //bei neuen Dateien 0
    Integer lastSavedHC = 0;

	
    

    /**
     * reads the file using self opening jfilechooser
     * abords if not-readable
     * 
     * call f as null if no file-path known
     * else f is specific path
     */
    protected void openDialog(File f) {
        fileOnStack = f;
        if (f == null) {
            JFileChooser openThis = new JFileChooser();
            txtFileFilter myFilter = new txtFileFilter();
            openThis.setFileFilter(myFilter);
                        
            int returnVal = openThis.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                openDialog(openThis.getSelectedFile());
            }
        } else {
            try {
                String text_read = iointerface.readFile(f);
                if (f.getAbsolutePath().endsWith(".txt")) {
                    currentFilePath = f;
                    autosave = true;
                }

                if (f.getAbsolutePath().endsWith('.' + name_txtzipped)) {
                    try {
                        setTextField(StringZipper.unzipString(text_read));
                    } catch (Exception e) {
                        showError(ErrorGZIPr);
                    }
                } else {
                    setThisTitle(f.getName());
                    setTextField(text_read);
                    current_hash = Utils.getHash(text_read).toString();
                }
            } catch (EOFException e) {
                showError(ErrorEOFr);
            } catch (IOException e) {
                showError(ErrorIOr);
            }
        }
    }

	

    /**
     * delivers the adequate, shortend file name
     *
     * puts within "?" and puts away the end-middle part
     * if name was too long
     */
    private static String deliverFileName(String n) {
        String res = n;

        if(res.length() >= 38) {
            res = (n.substring(0, 22)) + "..." + (n.substring((n.length() - 15), (n.length())));
        }

        return res;
    }

	

    /**
     * shows a hash using information dialog
     * calculates the hash off the text in the main editor pane
     */
    private void showHash() {
        showInfo(editorPane.getText());
    }

	

    /**
     * hides the information dialog
     */
    private void hideInfo() {
        this.Info.setVisible(false);
    }

	

    /**
     * shows information: String text gives the text to show
     * 
     * @param text to be shown in the text dialog
     */
    private void showInfo(String text) {

        this.info_label.setText(Utils.getHash(text).toString());
        this.Info.setVisible(true);
    }

	

    /**
     * sets the document to empty and forgets its paths for saving
     */
    private void createNewDocument() {
        currentFilePath = null;
        autosave = false;
        editorPane.setText("");
        current_hash = Utils.getHash("").toString();
        setThisTitle(defaultTitle);
        setUnchangedTitle();
    }

	

    /**
     * saves the file using self opening jfilechooser
     * overrides directly existing files
     * call f as null if no file-path known
     * else f is path
     * text is the string to save
     * call zipped true for zipping string first
     */
    protected void continueSave() {
        saveDialog(fileOnStack, txtOnStack, purposeOnStack);
    }

	

    /**
     * is the easy-to use overloading caller for saveDialog (see this)
     * here "txt" mode is calling - so we're taking and saving
     * text from the panel
     *
     * saving is, export is not used here
     */


    /**
     * shows the save dialog (java's filechooser) when File f is
     * given as null value
     *
     * if String originaltext is null the main textfield in GUI
     * is being saved (not exported) and the file to be saved will
     * contain this content
     *
     * the String purpose indicates the purpose and manner of saving
     * files can be exported and saved
     * when purpose is "txt" it will save
     * here title is to be changed only
     * when purpose is zipped text or web files exporting mode is used
     * here there's no title change needed
     */
     private void  saveDialog__wrappee__VISTEX  (File f, String originaltext, String purpose) {

    }

	
	 protected void saveDialog(File f, String originaltext, String purpose) {

         String text = ((originaltext == null) ? (saveTextField()) : (originaltext));
         fileOnStack = f;


         if(f == null && ((!purpose.equals("txt") || currentFilePath == null))) {
             JFileChooser openThis = new JFileChooser();

             if (purpose.equals("txt")) {
                 openThis.setFileFilter(new txtOnlyFileFilter());
             } else {
                 if (purpose.equals("zipped")) {
                     openThis.setFileFilter(new txtZipOnlyFileFilter());
                 } else {
                     openThis.setFileFilter(new HTMLFileFilter());
                 }
             }

             int returnVal = openThis.showSaveDialog(null);
             if (returnVal == JFileChooser.APPROVE_OPTION) {
                 saveDialog(openThis.getSelectedFile(), text, purpose);
             }
             openThis.setVisible(false);
         } else {

             f = ((f == null && purpose.equals("txt")) ? (currentFilePath) : (f));
             String path = f.getAbsolutePath();
             String file_extention = ".txt";

             if (!purpose.equals("txt")) {
                 if (purpose.equals("zipped")) {
                     file_extention = '.' + name_txtzipped;
                 } else {
                     file_extention = ".html";
                 }
             }

             File name = ((f.getName().endsWith(file_extention)) ? (f) : (new File(path.subSequence(0, ((int) (Math.max(path.indexOf('.'), path.length())))) + file_extention)));
             if(!name.exists() || forceFromStack || (autosave && purpose.equals("txt"))) {
                 try {

                     try {
                     	
                         String content = ((purpose.equals("zipped")) ? (StringZipper.zipString(text)) : (text));
                         iointerface.writeFile(name, content);
                         if (purpose.equals("txt")) {
                             currentFilePath = name;
                             autosave = true;
                         }
                         
                         
                         if (purpose.equals("txt")) {
                             setThisTitle(name.getName());
                             if(Utils.getHash(content) != null) current_hash = (Utils.getHash(content)).toString();
                         }
                         
                      } catch (IOException e) {
                         showError((purpose.equals("zipped")) ? (ErrorGZIPw) : (ErrorIOw));
                     }
                     

                     fileOnStack = null;
                     purposeOnStack = null;
                     txtOnStack = null;
                     forceFromStack = false;
                 } catch (iointerface.tooFewSpaceException e) {
                     showError(ErrorTooLessSpacew);
                 }
             } else {
                 fileOnStack = name;
                 purposeOnStack = purpose;
                 txtOnStack = text;
                 forceFromStack = true;
                 showOverwrite(name.getName());
                 
             }
         }

     }

	
    protected void saveHTMLDialog  (String text) {
        saveDialog(null, text, "html");
    }

	

    /**
     * sets the text in the main text field and calls hashing methods to
     * update or not title
     */
    protected void setTextField(String s) {
        editorPane.setText(s);
    }

	

    /**
     * serves the hash methode recognizing the current state to be hashed
     */
    protected String saveTextField() {
        String s = editorPane.getText();
        editorPane.transferFocus();
        return s;
    }

	

    /**
     * is the file filter for txt and zipped files used here
     *
     * defines bottom-line drop-down-text and filters
     * files shown using accept(File f) if true is returned
     */
    public  class  txtFileFilter  extends FileFilter {
		
        /**
         * provides the App with data about the file choosen
         */
        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                if (s.substring(i + 1).toLowerCase().equals("txt") || s.substring(i + 1).toLowerCase().equals(name_txtzipped)) {
                    return true;
                }
            }

            return false;
        }

		

        /**
         * attributes shown to the user for which files are not filtered yet
         */
        @Override
        public String getDescription() {
            return "*.txt, *." + name_txtzipped;
        }


	}

	

    /**
     * is the file filter for txt files only
     *
     * defines bottom-line drop-down-text and filters
     * files shown using accept(File f) if true is returned
     */
    public  class  txtOnlyFileFilter  extends FileFilter {
		

        /**
         * provides the App with data about the file choosen
         */
        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                if (s.substring(i + 1).toLowerCase().equals("txt")) {
                    return true;
                }
            }

            return false;
        }

		

        /**
         * attributes shown to the user for which files are not filtered yet
         */
        @Override
        public String getDescription() {
            return "nur *.txt";
        }


	}

	

    /**
     * is the file filter for zipped files only
     *
     * defines bottom-line drop-down-text and filters
     * files shown using accept(File f) if true is returned
     */
    public  class  txtZipOnlyFileFilter  extends FileFilter {
		

        /**
         * provides the App with data about the file choosen
         */
        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                if (s.substring(i + 1).toLowerCase().equals(name_txtzipped)) {
                    return true;
                }
            }

            return false;
        }

		

        /**
         * attributes shown to the user for which files are not filtered yet
         */
        @Override
        public String getDescription() {
            return "nur *." + name_txtzipped;
        }


	}

	

    /**
     * is the file filter for most common web files only
     *
     * defines bottom-line drop-down-text and filters
     * files shown using accept(File f) if true is returned
     */
    public  class  HTMLFileFilter  extends FileFilter {
		

        /**
         * provides the App with data about the file choosen
         */
        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 && i < s.length() - 1) {
                if (s.substring(i + 1).toLowerCase().equals("html") || s.substring(i + 1).toLowerCase().equals("htm")) {
                    return true;
                }
            }

            return false;
        }

		

        /**
         * attributes shown to the user for which files are not filtered yet
         */
        @Override
        public String getDescription() {
            return "*.html, *.htm";
        }


	}

	


    /**
     * provides the App with native Look And Feel, does nothing when not accepted
     * sets the default width and height and the position to absolute position good
     * accessible and finest to the user
     * defines the default title
     *
     * centers the window in 50:50 ratio in width
     * ratio 68:32 in height - golden ratio in nature
     */
    private void setNativeLAF() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
        }


        /**
         * centers the window in 50:50 ratio in width
         * ratio 68:32 in height - golden ratio in nature
         */
        int eff_x = (int) (goldenratioX * (myscreen.width - designerWidth));
        int eff_y = (int) (goldenratioY * (myscreen.height - designerHeight));

        this.setLocation(eff_x, eff_y);
        this.setSize(designerSize);

        try {
            MainPath = new File(getDocumentBase().getPath());
            String path_to_icon = MainPath.getParent() + iointerface.os_file_seperator + "jte.png";
            String path_to_task = MainPath.getParent() + iointerface.os_file_seperator + "Tut6.html";
            icon_image_resource = getClass().getResource(path_to_icon);
            task_resource = getClass().getResource(path_to_task);
            icon_res = new ImageIcon(path_to_icon);
            this.setIconImage((icon_res).getImage());
        } catch (Exception e) {}
        setThisTitle(defaultTitle);
    }

	

    /**
     * return the URL this file is running at
     *
     * casts URLs and special characters to be
     * valid or throws MalformedURLException
     * if input is not valid
     */
    public URL getDocumentBase() throws MalformedURLException {
        URL rc = getClass().getResource(getClass().getSimpleName() + ".class");
        if (rc.getProtocol().equalsIgnoreCase("jar")) {

            String tmp = rc.toString().substring(4, rc.toString().indexOf("!/"));
            tmp = rc.toString().replaceAll("jar:", "").replaceAll("file:/", "file://");
            tmp = tmp.substring(0, tmp.lastIndexOf("!/"));
            rc = new URL(null, tmp);
        }
        return rc;
    }

	

    /**
     * Sets the default title in title bar and updates currentTile,
     * which should be used for adding a star to the title
     */
    private void setThisTitle(String s) {
        currentTitle = deliverFileName(s);
        this.setTitle(defaultPrefixInTitle + currentTitle + defaultPostfixInTitle);
    }

	

    /**
     * set the title with star without redefining the currentTitle-var
     */
    private void setChangedTitle() {
        this.setTitle(defaultPrefixInTitle + currentTitle + changedContentMarkInTitle + defaultPostfixInTitle);
    }

	


    /**
     * set the title without star without redefining the currentTitle-var
     */
    private void setUnchangedTitle() {
        this.setTitle(defaultPrefixInTitle + currentTitle + defaultPostfixInTitle);
    }

	


    /**
     * updates the Title according to identity of text content on what was last saved
     */
    private void confirmChangesToTitle() {
        /*
         * TODO: Aufgabe 6.2
         *
         * Pr�fe ob im editorPane (a) und der Variable current_hash (b) die
         * gleichen Hashes stehen; benutze hierf�r isTheSame(a, b).
         * Die Utils.getHash(s) muss implementiert worden sein und soll benutzt werden.
         * Rufe dann je nach Ergebnis setChangedTitle() oder setUnchangedTitle() auf.
         */
    	
    	if(isTheSame(Utils.getHash(editorPane.getText()).toString().getBytes(),current_hash.getBytes()) == true){
    		setUnchangedTitle();	
    	}
    	else{
    		
    		setChangedTitle();
    		
    	}
    	
    }

	

    /**
     * Prooves weather a and b are insidely the same things
     */
    private static boolean isTheSame(byte[] a, byte[] b) {
        /*
         * TODO: Aufgabe 6.2
         *
         * Pr�fe ob a und b gleich oder unterschiedlich in jeder Position sind.
         */
    	
    	for(int x=0;x < a.length;x++){
    		
    		if(a[x] !=  b[x]) return false;
    		
    	}
    	
        return true;
    }

	


    /**
     * closes the App - extendable to asking when unchanged; like:
     * 0: default
     * 1: ask
     * 2: dont ask
     */
    private void closingApp(byte choice) {
        System.exit(choice);
    }

	

    /**
     * sets the main text labels, sizes, locations and titles
     * for the app to look adequate
     */
    private void initApp() {
        OverwriteDialog.setSize(OverwriteDialogSizeW, OverwriteDialogSizeH);
        OverwriteDialog.setTitle(OverwriteDialogTitle);
        OverwriteDOK.setText(OverwriteDialogOK);
        OverwriteDAbord.setText(OverwriteDialogAbord);
        OverwriteDOK.setText(OverwriteDialogOK);

        info_button.setText(InfoDialogOK);
        this.Info.setTitle(InfoDialogTitle);
        this.Info.setSize(InfoDialogSizeW, InfoDialogSizeH);
        int eff_x = (int) (goldenratioX * (myscreen.width - InfoDialogSizeW));
        int eff_y = (int) (goldenratioY * (myscreen.height - InfoDialogSizeH));

        this.Info.setLocation(eff_x, eff_y);
        current_hash = Utils.getHash(current_hash).toString();

        OverwriteDLabel.setText(OverwriteDialogLabelPre + currentTitle + OverwriteDialogLabelPost);
        eff_x = (int) (goldenratioX * (myscreen.width - OverwriteDialogSizeW));
        eff_y = (int) (goldenratioY * (myscreen.height - OverwriteDialogSizeH));
        OverwriteDialog.setLocation(eff_x, eff_y);

        try {
            OverwriteDialog.setIconImage((icon_res).getImage());
        } catch (Exception e) {}
        OverwriteDialog.setVisible(false);
    }

	

    /**
     * shows an error with custom message (here: String s)
     * opens a dialog box to inform the user
     */
    protected void showError(String s) {
        
        ErrorDialog.setTitle(deliverFileName(fileOnStack.getName()));
        ErrorDLabel.setText(s);
        ErrorDOK.setText(ErrorDialogOK);

        int eff_x = (int) (goldenratioX * (myscreen.width - ErrorDialogSizeW));
        int eff_y = (int) (goldenratioY * (myscreen.height - ErrorDialogSizeH));
        ErrorDialog.setLocation(eff_x, eff_y);
        ErrorDialog.setSize(ErrorDialogSizeW, ErrorDialogSizeH);

        ErrorDialog.setVisible(true);

        fileOnStack = null;
        purposeOnStack = null;
        txtOnStack = null;
        forceFromStack = false;
    }

	

    /**
     * shows a dialog box to confirm user is willing to overwrite
     * the existing file in favour of the new file
     */
    protected void showOverwrite(String filename) {
        OverwriteDLabel.setText(OverwriteDialogLabelPre + deliverFileName(fileOnStack.getName()) + OverwriteDialogLabelPost);
        OverwriteDialog.setVisible(true);
    }

	
    private void openClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openClicked
    }

	//GEN-LAST:event_openClicked

    private void closeClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeClicked
        closingApp((byte) 0);
    }

	//GEN-LAST:event_closeClicked

    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemActionPerformed
        openDialog(null);
    }

	
	private void jMenuItem2ActionPerformed  (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        saveDialog(null, null, "zipped");
    }

	//GEN-LAST:event_jMenuItem2ActionPerformed

    private void OverwriteDOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OverwriteDOKActionPerformed
        continueSave();
        OverwriteDialog.setVisible(false);
    }

	//GEN-LAST:event_OverwriteDOKActionPerformed

    private void OverwriteDAbordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OverwriteDAbordActionPerformed
        OverwriteDialog.setVisible(false);
        fileOnStack = null;
        purposeOnStack = null;
        txtOnStack = null;
        forceFromStack = false;
    }

	//GEN-LAST:event_OverwriteDAbordActionPerformed

    private void ErrorDOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ErrorDOKActionPerformed
        ErrorDialog.setVisible(false);
    }

	//GEN-LAST:event_ErrorDOKActionPerformed

    private void info_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_info_buttonActionPerformed
        hideInfo();
    }

	//GEN-LAST:event_info_buttonActionPerformed
    
    private void hashMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hashMenuMouseClicked
        showHash();
        this.requestFocus();
    }

	//GEN-LAST:event_hashMenuMouseClicked

    private void textEntered(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEntered
        confirmChangesToTitle();
    }

	//GEN-LAST:event_textEntered

    private void new_document(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_document
        createNewDocument();
    }

	

    private void jMenuItem1ActionPerformed  (java.awt.event.ActionEvent evt) {
        saveHTMLDialog(Utils.exportHTML(editorPane.getText(), currentTitle));
    }

	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorDLabel;

	
    private javax.swing.JButton ErrorDOK;

	
    private javax.swing.JDialog ErrorDialog;

	
    private javax.swing.JDialog Info;

	
    private javax.swing.JButton OverwriteDAbord;

	
    private javax.swing.JLabel OverwriteDLabel;

	
    private javax.swing.JButton OverwriteDOK;

	
    private javax.swing.JDialog OverwriteDialog;

	
    private javax.swing.JEditorPane editorPane;

	
    private javax.swing.JScrollPane jScrollPane1;

	
    private javax.swing.JLabel info_label;

	
    private javax.swing.JButton info_button;

	
    
    private javax.swing.JMenuBar jMenuBar1;

	

    private javax.swing.JMenuItem jMenuItem3;

	
    private javax.swing.JMenuItem exitItem;

	
	private javax.swing.JMenu exportMenu  ;

	
    private javax.swing.JMenu fileMenu;

	
    private javax.swing.JMenu hashMenu;

	
    private javax.swing.JMenuItem openItem;

	
	
	private static int getMembers() {
		return member++;
	}

	
	private javax.swing.JMenu editMenu;

	
	Main s = this;

	
	 private javax.swing.JMenuItem undoItem;

	
	 private UndoManager undoMg;

	
	    private void undoItemActionPerformed(java.awt.event.ActionEvent evt) {

            if(undoMg.canUndo()) {
                undoMg.undo();
            } else {
                JOptionPane.showMessageDialog(null,"can not Undo","Warning",JOptionPane.WARNING_MESSAGE);
            }
        
	    }

	
	 private javax.swing.JMenuItem suchItem;

	
	 private javax.swing.JMenuItem ersetzItem;

	
	private JMenu formatMenu;

	
	private JMenuItem formatMenu_Font;

	
	private JMenu formatMenu_Color;

	 
	private JMenuItem formatMenu_Color_FgColor,formatMenu_Color_BgColor;

	
	private javax.swing.JMenuItem saveItem;

	
 
    
    protected void saveDialog(File f) {
        saveDialog(f, saveTextField(), "txt");
    }

	
    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed
        saveDialog(null, null, "txt");
    }

	
	 private javax.swing.JMenuItem jMenuItem2;

	
    private javax.swing.JMenuItem jMenuItem1;


}
