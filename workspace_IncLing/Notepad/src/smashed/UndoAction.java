package smashed;import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.undo.CannotUndoException;

import annotationclasses___.Feature___;
/*@(UndoRedo)*/



@Feature___("UndoRedo")
public class UndoAction extends AbstractAction {
  /*@(UndoRedo)*/

  @Feature___("UndoRedo")
  protected Notepad notepad;
  /*@(UndoRedo)*/


  @Feature___("UndoRedo")
  public UndoAction(Notepad notepad){
    super( "Undo" );

    putValue( Action.SMALL_ICON, 
        Notepad.getImageIcon("undo.gif"));
    setEnabled( false );
    this.notepad = notepad;
  }
  /*@(UndoRedo)*/

  @Feature___("UndoRedo")
  public void actionPerformed( ActionEvent e ) {
    try {
      notepad.undo.undo();
    }
    catch ( CannotUndoException ex ) {
      System.out.println( "Unable to undo: " + ex );
      ex.printStackTrace();
    }
    update();
    notepad.redoAction.update();
  }
  /*@(UndoRedo)*/

  @Feature___("UndoRedo")
  protected void update() {
    if( notepad.undo.canUndo() ) {
      setEnabled( true );
      putValue( "Undo", notepad.undo.getUndoPresentationName() );
    }
    else {
      setEnabled( false );
      putValue( Action.NAME, "Undo" );
    }
  }
}
