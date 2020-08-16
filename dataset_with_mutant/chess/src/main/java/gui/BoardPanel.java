package gui;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
public class BoardPanel extends JPanel{
    
	private static final long serialVersionUID = 1L;
	protected int relativeX;
	protected int relativeY;
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    BoardPanel(Color c, int x, int y){
        this.setOpaque(true);
        this.setBackground(c);
        relativeX = x;
        relativeY = y;
    }

	public void setRelativeX(int x){
		relativeX = x;
	}
	
	public void setRelativeY(int y){
		relativeY = y;
	}
	
	public int getRelativeX(){
		return relativeX;
	}
	
	public int getRelativeY(){
		return relativeY;
	}


}
