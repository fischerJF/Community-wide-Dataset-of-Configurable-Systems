package smashed;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import splat.NotepadVariables;
import annotationclasses___.Anonymous___;
import annotationclasses___.Feature___;

@Feature___("Base___")
public class Notepad extends JFrame {
  /* @(Base___) */

  // declaration of the private variables used in the program
  // create the text area
  @Feature___("Base___")
  protected JTextArea textArea;
  /* @(Base___) */

  // for using the methods in these classes
  @Feature___("Base___")
  public Actions actions = new Actions(this);
  /* @(Base___) */

  @Feature___("Base___")
  public Center center = new Center(this);
  /* @(Base___) */

  // Create Scroll pane (JScrollPane) for the JTextArea
  @Feature___("Base___")
  protected JScrollPane scrollpane;

  /* @(Base___) */

  @Feature___("Base___")
  public JTextArea getTextArea() {
    return textArea;
  }

  /* @(Base___) */

  // Constructor of Notepad
  @Feature___("Base___")
  public Notepad() {
    // set the title for Notepad and set the size for it.
    setTitle("Untitled - JAVA(TM) Notepad");
    setSize(800, 600);

    // get the graphical user interface components display area
    Container cp = getContentPane();

    /**
     * adding the text area, adding the tool bar & adding the scroll pane to the
     * container
     */
    cp.add(textArea = new JTextArea());
    cp.add(scrollpane = new JScrollPane(textArea));

    /**
     * setting the default close operation to false & using own action (exiT
     * action @Actions.java)
     */
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      /* @(Base___) */

      @Anonymous___("4")
      @Feature___("Base___")
      public void windowClosing(WindowEvent e) {
        actions.exiT();
      }
    });

    /**
     * initialize fields here. For some reason, when you initialize fields
     * outside of a method, they are null when constructMenu is called
     */
    initializeFields();

    /**
     * for making the program at the center,
     * 
     * @see Center.java
     */
    center.nCenter();

    /**
     * Setting the Line Wrap & Wrap Style Word features are true
     */
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    if (NotepadVariables.getSINGLETON().isUNDOREDO___()) {
      textArea.getDocument().addUndoableEditListener(
          new UndoableEditListener() {
            /* @(UndoRedo) */

            @Anonymous___("5")
            @Feature___("UndoRedo")
            public void undoableEditHappened(UndoableEditEvent e) {
              // Remember the edit and update the menus
              undo.addEdit(e.getEdit());
              undoAction.update();
              redoAction.update();
            }
          });
    }
  }

  /* @(Base___) */

  public void launch() {
    /**
     * Do the menu construction - be it toolbar and/or menubar - here. We need
     * to do it before show().
     */
    constructMenu();

    setVisible(true);
  }

  @Feature___("Base___")
  public static ImageIcon getImageIcon(String filename) {
    String path = System.getProperty("user.dir") + File.separator + "src"
        + File.separator + "images" + File.separator + filename;
    return new ImageIcon(path);
  }

  /* @(Base___) */

  /* @(BaseMenuBar) */

  @Feature___("BaseMenuBar")
  protected JMenuBar Menubar;
  /* @(BaseMenuBar) */

  // Create the menu that contains the items
  @Feature___("BaseMenuBar")
  protected JMenu filE, ediT, vieW, helP;
  /* @(BaseMenuBar) */

  @Feature___("BaseMenuBar")
  protected JMenuItem neW, exiT, abouT;
  /* @(BaseMenuBar) */

  // Create the Tool Bar that contains the JButton
  @Feature___("BaseToolBar")
  protected JToolBar toolBar;
  /* @(BaseToolBar) */

  // Create the buttons
  @Feature___("BaseToolBar")
  protected JButton newButton, aboutButton;

  /* @(BaseToolBar) */

  @Feature___("Base___")
  public void constructMenu() {
    if (NotepadVariables.getSINGLETON().isBASEMENUBAR___()) {
      constructMenuBar();
    }
    if (NotepadVariables.getSINGLETON().isBASETOOLBAR___()) {
      constructToolBar();
    }
  }

  /* @(BaseToolBar) */

  @Feature___("EditMenuBar")
  protected JMenuItem cuT, copY, pastE, selectALL;
  /* @(EditMenuBar) */

  @Feature___("EditToolBar")
  protected JButton undoButton, redoButton, cutButton, copyButton, pasteButton;
  /* @(EditToolBar) */

  @Feature___("FormatMenuBar")
  private JMenuItem fonT;
  /* @(FormatMenuBar) */

  @Feature___("FormatMenuBar")
  private JCheckBoxMenuItem lineWraP;
  /* @(FormatMenuBar) */

  @Feature___("FormatMenuBar")
  private JMenu formaT;

  /* @(FormatMenuBar) */

  // for using lineWrap & textArea @Actions.java
  @Feature___("FormatMenuBar")
  public JCheckBoxMenuItem getLineWrap() {
    return lineWraP;
  }

  /* @(FormatMenuBar) */

  @Feature___("FormatToolBar")
  private JButton fontButton;
  /* @(FormatToolBar) */

  @Feature___("PersistenceMenuBar")
  protected JMenuItem opeN, savE, saveAS;
  /* @(PersistenceMenuBar) */

  @Feature___("PersistenceToolBar")
  protected JButton openButton, saveButton, saveAsButton;
  /* @(PersistenceToolBar) */

  @Feature___("PrintMenuBar")
  private JMenuItem prinT;
  /* @(PrintMenuBar) */

  @Feature___("PrintToolBar")
  private JButton printButton;
  /* @(PrintToolBar) */

  @Feature___("SearchMenuBar")
  private JMenuItem finD;
  /* @(SearchMenuBar) */

  @Feature___("SearchMenuBar")
  private JMenuItem findNexT;
  /* @(SearchMenuBar) */

  @Feature___("SearchToolBar")
  private JButton findButton;
  /* @(SearchToolBar) */

  // for using undo & redo
  @Feature___("UndoRedo")
  protected UndoManager undo;
  /* @(UndoRedo) */

  @Feature___("UndoRedo")
  protected UndoAction undoAction;
  /* @(UndoRedo) */

  @Feature___("UndoRedo")
  protected RedoAction redoAction;

  /* @(UndoRedo) */

  @Feature___("Base___")
  public void initializeFields() {
    if (NotepadVariables.getSINGLETON().isUNDOREDO___()) {
      undo = new UndoManager();
      undoAction = new UndoAction(this);
      redoAction = new RedoAction(this);
    }
  }

  /* @(UndoRedoMenuBar) */

  @Feature___("EditMenuBar")
  public void constructEditMenuBar() {
    if (NotepadVariables.getSINGLETON().isUNDOREDOMENUBAR___()) {
      ediT.add(undoAction);
      ediT.add(redoAction);
    }
    ediT.add(cuT = new JMenuItem("Cut", getImageIcon("cut.gif")));
    ediT.add(copY = new JMenuItem("Copy", getImageIcon("copy.gif")));
    ediT.add(pastE = new JMenuItem("Paste", getImageIcon("paste.gif")));
    ediT.add(selectALL = new JMenuItem("Select All"));

    cuT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
        ActionEvent.CTRL_MASK));
    copY.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
        ActionEvent.CTRL_MASK));
    pastE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
        ActionEvent.CTRL_MASK));
    selectALL.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
        ActionEvent.CTRL_MASK));

    cuT.addActionListener(new ActionListener() {
      /* @(EditMenuBar) */

      @Anonymous___("6")
      @Feature___("EditMenuBar")
      public void actionPerformed(ActionEvent ae) {
        actions.cuT();
      }
    });
    copY.addActionListener(new ActionListener() {
      /* @(EditMenuBar) */

      @Anonymous___("7")
      @Feature___("EditMenuBar")
      public void actionPerformed(ActionEvent ae) {
        actions.copY();
      }
    });
    pastE.addActionListener(new ActionListener() {
      /* @(EditMenuBar) */

      @Anonymous___("8")
      @Feature___("EditMenuBar")
      public void actionPerformed(ActionEvent ae) {
        actions.pastE();
      }
    });
    selectALL.addActionListener(new ActionListener() {
      /* @(EditMenuBar) */

      @Anonymous___("9")
      @Feature___("EditMenuBar")
      public void actionPerformed(ActionEvent ae) {
        actions.selectALL();
      }
    });
  }

  /* @(UndoRedoToolBar) */

  @Feature___("EditToolBar")
  public void constructEditToolBar() {
    if (NotepadVariables.getSINGLETON().isUNDOREDOTOOLBAR___()) {
      toolBar.add(undoAction);
      toolBar.add(redoAction);
    }
    toolBar.add(cutButton = new JButton(getImageIcon("cut.gif")));
    toolBar.add(copyButton = new JButton(getImageIcon("copy.gif")));
    toolBar.add(pasteButton = new JButton(getImageIcon("paste.gif")));

    cutButton.setToolTipText("Cut");
    copyButton.setToolTipText("Copy");
    pasteButton.setToolTipText("Paste");

    cutButton.addActionListener(new ActionListener() {
      /* @(EditToolBar) */

      @Anonymous___("10")
      @Feature___("EditToolBar")
      public void actionPerformed(ActionEvent ae) {
        actions.cuT();
      }
    });
    copyButton.addActionListener(new ActionListener() {
      /* @(EditToolBar) */

      @Anonymous___("11")
      @Feature___("EditToolBar")
      public void actionPerformed(ActionEvent ae) {
        actions.copY();
      }
    });
    pasteButton.addActionListener(new ActionListener() {
      /* @(EditToolBar) */

      @Anonymous___("12")
      @Feature___("EditToolBar")
      public void actionPerformed(ActionEvent ae) {
        actions.pastE();
      }
    });
  }

  /* @(WordCountMenuBar) */

  @Feature___("WordCountMenuBar")
  private JMenuItem wordCountMenuItem;
  /* @(WordCountMenuBar) */

  @Feature___("WordCountMenuBar")
  private JMenu wordCountMenu;

  /* @(WordCountMenuBar) */

  @Feature___("BaseMenuBar")
  public void constructMenuBar() {
    // for setting the menu bar
    setJMenuBar(Menubar = new JMenuBar());

    Menubar.add(filE = new JMenu("File"));
    filE.add(neW = new JMenuItem("New", getImageIcon("new.gif")));
    filE.add(exiT = new JMenuItem("Exit"));
    Menubar.add(helP = new JMenu("Help"));
    helP.add(abouT = new JMenuItem("About Notepad", getImageIcon("about.gif")));

    Menubar.add(ediT = new JMenu("Edit"));
    Menubar.add(vieW = new JMenu("View"));

    /**
     * allowing the file menu to be selected by pressing ALT + F
     */
    filE.setMnemonic('f');
    helP.setMnemonic('h');
    ediT.setMnemonic('e');
    vieW.setMnemonic('v');

    /**
     * allowing the neW menu item to be selected by pressing ALT + N allowing
     * the exiT menu item to be selected by pressing ALT + F4
     */
    neW.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
        ActionEvent.CTRL_MASK));
    exiT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
        ActionEvent.CTRL_MASK));

    /**
     * adding action listener for menu item: neW, opeN, savE, saveAS, prinT,
     * exiT, redO, undO, copY, cuT, pastE, finD, findNexT, selectALL, lineWraP,
     * fonT & abouT the actions was written @Actions.java
     */
    neW.addActionListener(new ActionListener() {
      /* @(BaseMenuBar) */

      @Anonymous___("13")
      @Feature___("BaseMenuBar")
      public void actionPerformed(ActionEvent ae) {
        actions.neW();
      }
    });
    exiT.addActionListener(new ActionListener() {
      /* @(BaseMenuBar) */

      @Anonymous___("14")
      @Feature___("BaseMenuBar")
      public void actionPerformed(ActionEvent ae) {
        actions.exiT();
      }
    });

    abouT.addActionListener(new ActionListener() {
      /* @(BaseMenuBar) */

      @Anonymous___("15")
      @Feature___("BaseMenuBar")
      public void actionPerformed(ActionEvent ae) {
        actions.abouT();
      }
    }

    );

    if (NotepadVariables.getSINGLETON().isEDITMENUBAR___()) {
      constructEditMenuBar();
    }

    if (NotepadVariables.getSINGLETON().isFORMATMENUBAR___()) {
      Menubar.add(formaT = new JMenu("Format"));
      formaT.add(lineWraP = new JCheckBoxMenuItem("Line Wrap"));
      formaT.add(fonT = new JMenuItem("Font", getImageIcon("font.gif")));
      formaT.setMnemonic('o');
      lineWraP.addActionListener(new ActionListener() {
        /* @(FormatMenuBar) */

        @Anonymous___("16")
        @Feature___("FormatMenuBar")
        public void actionPerformed(ActionEvent ae) {
          actions.lineWraP();
        }
      });
      fonT.addActionListener(new ActionListener() {
        /* @(FormatMenuBar) */

        @Anonymous___("17")
        @Feature___("FormatMenuBar")
        public void actionPerformed(ActionEvent ae) {
          actions.fonT();
        }
      });
    }

    if (NotepadVariables.getSINGLETON().isPERSISTENCEMENUBAR___()) {
      filE.add(opeN = new JMenuItem("Open", getImageIcon("open.gif")));
      filE.add(savE = new JMenuItem("Save", getImageIcon("save.gif")));
      filE.add(saveAS = new JMenuItem("Save As", getImageIcon("saveAs.gif")));
      opeN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
          ActionEvent.CTRL_MASK));
      savE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
          ActionEvent.CTRL_MASK));
      opeN.addActionListener(new ActionListener() {
        /* @(PersistenceMenuBar) */

        @Anonymous___("18")
        @Feature___("PersistenceMenuBar")
        public void actionPerformed(ActionEvent ae) {
          actions.opeN();
        }
      });
      savE.addActionListener(new ActionListener() {
        /* @(PersistenceMenuBar) */

        @Anonymous___("19")
        @Feature___("PersistenceMenuBar")
        public void actionPerformed(ActionEvent ae) {
          actions.savE();
        }
      });
      saveAS.addActionListener(new ActionListener() {
        /* @(PersistenceMenuBar) */

        @Anonymous___("20")
        @Feature___("PersistenceMenuBar")
        public void actionPerformed(ActionEvent ae) {
          actions.saveAs();
        }
      });
    }

    if (NotepadVariables.getSINGLETON().isPRINTMENUBAR___()) {
      filE.add(prinT = new JMenuItem("Print", getImageIcon("print.gif")));
      prinT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
          ActionEvent.CTRL_MASK));
      prinT.addActionListener(new ActionListener() {
        /* @(PrintMenuBar) */

        @Anonymous___("21")
        @Feature___("PrintMenuBar")
        public void actionPerformed(ActionEvent ae) {
          actions.prinT();
        }
      });
    }

    if (NotepadVariables.getSINGLETON().isSEARCHMENUBAR___()) {
      ediT.add(finD = new JMenuItem("Find", getImageIcon("find.gif")));
      ediT.add(findNexT = new JMenuItem("Find Next"));
      finD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
          ActionEvent.CTRL_MASK));
      findNexT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,
          ActionEvent.CTRL_MASK));
      finD.addActionListener(new ActionListener() {
        /* @(SearchMenuBar) */

        @Anonymous___("22")
        @Feature___("SearchMenuBar")
        public void actionPerformed(ActionEvent ae) {
          actions.finD();
        }
      });
      findNexT.addActionListener(new ActionListener() {
        /* @(SearchMenuBar) */

        @Anonymous___("23")
        @Feature___("SearchMenuBar")
        public void actionPerformed(ActionEvent ae) {
          actions.findNexT();
        }
      });
    }

    if (NotepadVariables.getSINGLETON().isWORDCOUNTMENUBAR___()) {
      Menubar.add(wordCountMenu = new JMenu("Word Count"));
      wordCountMenu.add(wordCountMenuItem = new JMenuItem("Word Count",
          getImageIcon("wordcount.gif")));
      wordCountMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
          ActionEvent.CTRL_MASK));
      wordCountMenuItem.addActionListener(new ActionListener() {
        /* @(WordCountMenuBar) */

        @Anonymous___("24")
        @Feature___("WordCountMenuBar")
        public void actionPerformed(ActionEvent ae) {
          actions.wordCount();
        }
      });
    }
  }

  /* @(WordCountToolBar) */

  @Feature___("WordCountToolBar")
  private JButton wordCountButton;

  /* @(WordCountToolBar) */

  @Feature___("BaseToolBar")
  public void constructToolBar() {
    getContentPane().add("North", toolBar = new JToolBar("Tool Bar"));

    /**
     * adding newButton, openButton, saveButton, saveAsButton, printButton,
     * undoButton, redoButton, cutButton, copyButton, pasteButton, fontButton &
     * aboutButton to the tool bar, adding a small image icon to the menu item &
     * adding separator between the button
     */
    toolBar.add(newButton = new JButton(getImageIcon("new.gif")));
    toolBar.add(aboutButton = new JButton(getImageIcon("about.gif")));

    // adding a tool tip text to the button for descriping the image icon.
    newButton.setToolTipText("New");
    aboutButton.setToolTipText("About Notepad");

    /**
     * adding action listener for the button in the tool bar: newButton,
     * openButton, saveButton, saveAsButton, printButton, redoButton,
     * undoButton, copyButton, cutButton, pasteButton, findButton, selectALL,
     * lineWraP, fontButton & aboutButton the actions was written @Actions.java
     */
    newButton.addActionListener(new ActionListener() {
      /* @(BaseToolBar) */

      @Anonymous___("25")
      @Feature___("BaseToolBar")
      public void actionPerformed(ActionEvent ae) {
        actions.neW();
      }
    });
    aboutButton.addActionListener(new ActionListener() {
      /* @(BaseToolBar) */

      @Anonymous___("26")
      @Feature___("BaseToolBar")
      public void actionPerformed(ActionEvent ae) {
        actions.abouT();
      }
    });

    if (NotepadVariables.getSINGLETON().isEDITTOOLBAR___()) {
      toolBar.addSeparator();
      constructEditToolBar();
    }

    if (NotepadVariables.getSINGLETON().isFORMATTOOLBAR___()) {
      toolBar.addSeparator();
      toolBar.add(fontButton = new JButton(getImageIcon("font.gif")));
      fontButton.setToolTipText("Font");
      fontButton.addActionListener(new ActionListener() {
        /* @(FormatToolBar) */

        @Anonymous___("27")
        @Feature___("FormatToolBar")
        public void actionPerformed(ActionEvent ae) {
          actions.fonT();
        }
      });
    }

    if (NotepadVariables.getSINGLETON().isPERSISTENCETOOLBAR___()) {
      toolBar.addSeparator();
      toolBar.add(openButton = new JButton(getImageIcon("open.gif")));
      toolBar.add(saveButton = new JButton(getImageIcon("save.gif")));
      toolBar.add(saveAsButton = new JButton(getImageIcon("saveAs.gif")));
      openButton.setToolTipText("Open");
      saveButton.setToolTipText("Save");
      saveAsButton.setToolTipText("Save As");
      openButton.addActionListener(new ActionListener() {
        /* @(PersistenceToolBar) */

        @Anonymous___("28")
        @Feature___("PersistenceToolBar")
        public void actionPerformed(ActionEvent ae) {
          actions.opeN();
        }
      });
      saveButton.addActionListener(new ActionListener() {
        /* @(PersistenceToolBar) */

        @Anonymous___("29")
        @Feature___("PersistenceToolBar")
        public void actionPerformed(ActionEvent ae) {
          actions.savE();
        }
      });
      saveAsButton.addActionListener(new ActionListener() {
        /* @(PersistenceToolBar) */

        @Anonymous___("30")
        @Feature___("PersistenceToolBar")
        public void actionPerformed(ActionEvent ae) {
          actions.saveAs();
        }
      });
    }

    if (NotepadVariables.getSINGLETON().isPRINTTOOLBAR___()) {
      toolBar.addSeparator();
      toolBar.add(printButton = new JButton(getImageIcon("print.gif")));
      printButton.setToolTipText("Print");
      printButton.addActionListener(new ActionListener() {
        /* @(PrintToolBar) */

        @Anonymous___("31")
        @Feature___("PrintToolBar")
        public void actionPerformed(ActionEvent ae) {
          actions.prinT();
        }
      });
    }

    if (NotepadVariables.getSINGLETON().isSEARCHTOOLBAR___()) {
      toolBar.addSeparator();
      toolBar.add(findButton = new JButton(getImageIcon("find.gif")));
      findButton.setToolTipText("Find");
      findButton.addActionListener(new ActionListener() {
        /* @(SearchToolBar) */

        @Anonymous___("32")
        @Feature___("SearchToolBar")
        public void actionPerformed(ActionEvent ae) {
          actions.finD();
        }
      });
    }

    if (NotepadVariables.getSINGLETON().isWORDCOUNTTOOLBAR___()) {
      toolBar.addSeparator();
      toolBar.add(wordCountButton = new JButton(getImageIcon("wordcount.gif")));
      wordCountButton.setToolTipText("Word count");
      wordCountButton.addActionListener(new ActionListener() {
        /* @(WordCountToolBar) */

        @Anonymous___("33")
        @Feature___("WordCountToolBar")
        public void actionPerformed(ActionEvent ae) {
          actions.wordCount();
        }
      });
    }
  }

  public static void main(String args[]) {
    /*
     * Config___.Base___ = true; Config___.BaseMenuBar = true;
     * Config___.BaseToolBar = true; Config___.Edit = true;
     * Config___.EditMenuBar = true; Config___.EditToolBar = true;
     * Config___.Format = true; Config___.FormatMenuBar = true;
     * Config___.FormatToolBar = true; Config___.Persistence = true;
     * Config___.PersistenceMenuBar = true; Config___.PersistenceToolBar = true;
     * Config___.Print = true; Config___.PrintMenuBar = true;
     * Config___.PrintToolBar = true; Config___.Search = true;
     * Config___.SearchMenuBar = true; Config___.SearchToolBar = true;
     * Config___.UndoRedo = true; Config___.UndoRedoMenuBar = true;
     * Config___.UndoRedoToolBar = true; Config___.WordCount = true;
     * Config___.WordCountMenuBar = true; Config___.WordCountToolBar = true;
     */
    NotepadVariables.getSINGLETON().setBASE___(true);
     NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
    NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
     NotepadVariables.getSINGLETON().setEDITMENUBAR___(true);
     NotepadVariables.getSINGLETON().setEDITTOOLBAR___(true);
     NotepadVariables.getSINGLETON().setFORMATMENUBAR___(true);
     NotepadVariables.getSINGLETON().setFORMATTOOLBAR___(true);
     NotepadVariables.getSINGLETON().setPERSISTENCEMENUBAR___(true);
     NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
     NotepadVariables.getSINGLETON().setPRINTMENUBAR___(true);
    NotepadVariables.getSINGLETON().setPRINTTOOLBAR___(true);
     NotepadVariables.getSINGLETON().setSEARCHMENUBAR___(true);
     NotepadVariables.getSINGLETON().setSEARCHTOOLBAR___(true);
     NotepadVariables.getSINGLETON().setUNDOREDOMENUBAR___(true);

     NotepadVariables.getSINGLETON().setUNDOREDOTOOLBAR___(true);

     NotepadVariables.getSINGLETON().setWORDCOUNTMENUBAR___(true);
     NotepadVariables.getSINGLETON().setWORDCOUNTTOOLBAR___(true);
     

    Notepad n = new Notepad();
    n.launch();
  }
}
