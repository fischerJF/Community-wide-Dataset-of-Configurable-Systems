package gui;
import javax.swing.JLabel;
import java.awt.Color;

public class MenuText extends JLabel{
	protected int relativeX;

  MenuText(String s, int x){
    super(s);
    relativeX = x;
  }

  public void highlight(){
    this.setForeground(Color.YELLOW);
  }

  public void unhighlight(){
    this.setForeground(Color.WHITE);
  }

  public void setRelativeX(int x){
		relativeX = x;
	}

	public int getRelativeX(){
		return relativeX;
	}

}
