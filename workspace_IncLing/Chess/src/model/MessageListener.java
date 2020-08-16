package model;
import java.io.DataInputStream;
import java.io.IOException;
import piece.Piece;

public class MessageListener implements Runnable {

  Model m;
	DataInputStream in;
  
	MessageListener(DataInputStream in){
		this.in = in;
		this.m = Model.getInstance();
	}

	public void run(){
		while (true){
		int selX = 0;
		int selY = 0;
		int x = 0;
		int y = 0;
		try{
			selX = in.readInt();
			selY = in.readInt();
			x = in.readInt();
			y = in.readInt();
		}
		catch(IOException e){
			System.out.println(e);
		}
		if(selX == 10){
			m.nextRound();
		}
		else if( x < 10 && y < 10 && selX < 10 && selY < 10){
			Piece p = m.getPiece(selX,selY);
			    m.v.clearOneRende(selX,selY);

			    m.changePosition(x,y,p);
			    m.v.clearAllRender();
			    m.buildIcons();
			    m.v.show();
			}
		}
	}

}
