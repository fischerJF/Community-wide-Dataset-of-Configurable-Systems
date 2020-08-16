package gui;
import model.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import piece.*;

public class Controller implements MouseListener {

	private Model m;
	private int mode;//0 = menu, 1 = menu multiplayer, 2 = jogo
	private int hl;
	private int dndX,dndY;
	RoundState rs;

	public Controller(){
		rs = RoundState.NOCLICK;
	}

  public void setModel(Model m){
		this.m = m;
	}

  public void setMode(int x){
		this.mode = x;
	}

  public void receivedIP(String s){
		m.joinConnection(s);
	}

  
	public void mouseClicked(MouseEvent arg0) {
		if(mode == 0 ){
			MenuText text = (MenuText)arg0.getSource();
			int x = text.getRelativeX();
			if(x == 0){
				m.clickedMenu(x);
				this.setMode(2);
			}
			else if (x == 2){
				m.clickedMenu(x);
				this.setMode(1);
			}
			else if(x == 1){
				m.clickedMenu(x);
				this.setMode(2);
			}
		}
		else if (mode == 1){
			MenuText text = (MenuText)arg0.getSource();
			int x = text.getRelativeX();
			if (x == 0){
				m.mpClickedMenu(x);
				this.setMode(2);
			}
			else if (x == 1){
				m.mpClickedMenu(x);
				this.setMode(2);
			}
			else if(x == 2){
				m.mpClickedMenu(x);
				this.setMode(0);
			}
		}
		else{
			BoardPanel panel = (BoardPanel)arg0.getSource();
			int x = panel.getRelativeX();
		    int y = panel.getRelativeY();
		    m.clickedPanel(x,y);
		    rs = RoundState.FIRSTCLICK;
		}
	}

  public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(mode == 0 || mode == 1){
			MenuText text = (MenuText)arg0.getSource();
			text.highlight();
		}
	}

  public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(mode == 0 || mode == 1){
			MenuText text = (MenuText)arg0.getSource();
			text.unhighlight();
		}
	}

  public void mousePressed(MouseEvent arg0) {
	}

  public void mouseReleased(MouseEvent arg0) {
  }

}
