package testset;

import java.awt.Dimension;

import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.TestName;
import smashed.Notepad;
import specifications.Configuration;



public abstract class NotepadTest  {

  
  public TestName testName = new TestName();

//   @Rule
//   public Timeout globalTimeout = new Timeout(10000);

  FrameFixture window;
  

  @Before
  public void setup() {
	FailOnThreadViolationRepaintManager.install();
    GuiQuery<Notepad> action = new GuiQuery<Notepad>() {
      protected Notepad executeInEDT() {
        configure();
        Notepad notepad = new Notepad();
        notepad.launch();
        return notepad;
      }
    };
    Notepad frame = GuiActionRunner.execute(action);
    window = new FrameFixture(frame);
    window.show(new Dimension(500, 500));
	  
  }

  protected void configure() {
    // NotepadVariables.getSINGLETON().setBASE___(true);
    // NotepadVariables.getSINGLETON().setBASEMENUBAR___(true);
    // NotepadVariables.getSINGLETON().setBASETOOLBAR___(true);
    // NotepadVariables.getSINGLETON().setEDITMENUBAR___(true);
    // NotepadVariables.getSINGLETON().setEDITTOOLBAR___(true);
    // NotepadVariables.getSINGLETON().setFORMATMENUBAR___(true);
    // NotepadVariables.getSINGLETON().setFORMATTOOLBAR___(true);
    // NotepadVariables.getSINGLETON().setPERSISTENCEMENUBAR___(true);
    // NotepadVariables.getSINGLETON().setPERSISTENCETOOLBAR___(true);
    // NotepadVariables.getSINGLETON().setPRINTMENUBAR___(true);
    // NotepadVariables.getSINGLETON().setPRINTTOOLBAR___(true);
    // NotepadVariables.getSINGLETON().setSEARCHMENUBAR___(true);
    // NotepadVariables.getSINGLETON().setSEARCHTOOLBAR___(true);
    // NotepadVariables.getSINGLETON().setUNDOREDOMENUBAR___(true);
    //
    // NotepadVariables.getSINGLETON().setUNDOREDOTOOLBAR___(true);
    //
    // NotepadVariables.getSINGLETON().setWORDCOUNTMENUBAR___(true);
    // NotepadVariables.getSINGLETON().setWORDCOUNTTOOLBAR___(true);
	  
	  Configuration.BASE=true;
	  Configuration.BASEMENUBAR=true;
	  Configuration.BASETOOLBAR=true;
	  Configuration.EDITMENUBAR=true;
	  Configuration.EDITTOOLBAR=true;
	  Configuration.FORMATMENUBAR=true;
	  Configuration.FORMATTOOLBAR=true;
	  Configuration.PERSISTENCEMENUBAR=true;
	  Configuration.PERSISTENCETOOLBAR=true;
	  Configuration.PRINTMENUBAR=true;
	  Configuration.PRINTTOOLBAR=true;
	  Configuration.SEARCHMENUBAR=true;
	  Configuration.SEARCHTOOLBAR=true;
	  Configuration.UNDOREDOMENUBAR=true;
	 	  Configuration.UNDOREDOTOOLBAR=true;
	      //
	  Configuration.WORDCOUNTMENUBAR=true;
	  Configuration.WORDCOUNTTOOLBAR=true;
  }

  @After
  public void teardown() {
    window.cleanUp();
    // NotepadVariables.getSINGLETON().restore();
  }

}