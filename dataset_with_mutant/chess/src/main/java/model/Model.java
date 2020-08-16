package model;
import gui.*;
import piece.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.awt.Point;

public final class Model{
	private  Board t;
	private ServerSocket server;
	private Socket client;
	private boolean multiplayer;
	private boolean isHost;
	private DataOutputStream out;
	private DataInputStream in;
	private Thread synch;
	public View v;
	private Thread roundSych;
	private int currentTurn;
	private int selX,selY;
  private int destX,destY;
	private int dragX,dragY;
	private int mode;
	private final int PORT = 5000;
	RoundState rs;

  private static final Model INSTANCE = new Model();

  // Singleton
  private Model(){
		currentTurn = 0;
		this.isHost = false;
		rs = RoundState.NOCLICK;
	}

	public static Model getInstance(){
		return INSTANCE;
	}

	private void setMode(int mode){
		this.mode = mode;
	}

	public void setView(View v){
		this.v = v;
	}

	public void nextRound(){
		this.currentTurn++;
		this.currentTurn = currentTurn % 2;
	}

	public Piece getPiece(int x,int y){
		return this.t.board[x][y].getPiece();
	}

	public void changePosition(int x, int y, Piece p){
		this.t.changePosition(x,y,p);
	}

	public void clickedPanel(int x, int y){
		switch(rs){
			case NOCLICK:
				//condicional checa se a peça é do jogador da vez, o segundo condicional assegura
				//que o round esta condizente com a peça clicada no multiplayer
				if(t.isPlayerPiece(x,y,currentTurn)){
					if(multiplayer){
						if((isHost && currentTurn == 0) ||(!isHost && currentTurn == 1)){
							v.selectTile(x,y);
							selX = x;
							selY = y;
							rs = RoundState.FIRSTCLICK;
						}
					}
					else{
						v.selectTile(x,y);
						selX = x;
						selY = y;
						rs = RoundState.FIRSTCLICK;
					}
				}
			break;
			case FIRSTCLICK:
        // Deseleciona
	        if (x == selX && y == selY) {
	          v.desselectTile(x,y);
	          rs = RoundState.NOCLICK;
	          break;
	        }
	        // Reseleciona
	        if (t.isPlayerPiece(x,y,currentTurn)) {
	        	if(multiplayer){
	        		if((isHost && currentTurn == 0) || (!isHost && currentTurn == 1)){
			          	v.desselectTile(selX,selY);
			         	v.selectTile(x,y);
						selX = x;
						selY = y;
			          	rs = RoundState.FIRSTCLICK;
	        		}
	        	}
	        	else{
			      	v.desselectTile(selX,selY);
			     	v.selectTile(x,y);
					selX = x;
					selY = y;
			      	rs = RoundState.FIRSTCLICK;
	        	}
	          	break;
				}
	        // Escolhe Dest
	        if (!t.isPlayerPiece(x,y,currentTurn) && t.isValid(x, y, t.board[selX][selY].getPiece()) ) {
	        	if(multiplayer){
	        		sendMove(selX,selY);
	        		sendMove(x,y);
	        	}
			    Piece p = t.board[selX][selY].getPiece();
			    v.desselectTile(selX,selY);
			    v.addPiece(x,y,t.board[selX][selY].getPiece().getType(),t.board[selX][selY].getPiece().getTeam());
			    t.changePosition(x,y,p);
			    if(mode == 1){
		          		t.bestMove(x, y);
			   			int xx = t.getBestX();
			   			int yy = t.getBestY();
			   			Piece pp = t.getBestPiece();
			   			v.selectTile((int)pp.getLocation().getX(),(int)pp.getLocation().getY());
			   			v.desselectTile((int)pp.getLocation().getX(),(int)pp.getLocation().getY());
			   			t.changePosition(xx, yy, pp);
						  this.buildIcons();
			   			currentTurn++;
			   			currentTurn = currentTurn%2;
			   	}
			    this.nextRound();
			    if(multiplayer)
				    this.sendNextRound();
			    rs = RoundState.NOCLICK;
			    this.buildIcons();
			    break;
	        }
	        else {
	          v.desselectTile(selX,selY);
	          rs = RoundState.NOCLICK;
	          break;
	        }
	    }
	    boolean isAI = mode == 1 ? true : false;
	    boolean whiteKingCheck = t.whiteKingCheck(isAI);
	    boolean blackKingCheck = t.blackKingCheck();
	    if(whiteKingCheck){
	    	v.endGame(1);
	    }
	    else if(blackKingCheck){
	    	v.endGame(0);
	    }
	    v.setCheck(whiteKingCheck,blackKingCheck);
	    v.setPlayerTurn(this.currentTurn);
	    v.repaint();
	}

	public void clickedMenu(int x){
		if (x == 0){
			this.buildTabuleiro();
			this.show();
		}
		if(x == 1){
			this.buildTabuleiro(1);
			this.show();
			setMode(1);
		}
		if (x == 2){
			v.setMPMenu();
			this.show();
		}
	}

	public void mpClickedMenu(int x){
		if (x == 0){
			v.setWaitScreen();
			v.repaint();
			this.show();
			this.startHost();
		}
		if (x == 1){
			v.makeDialog();
		}
		else if (x == 2){
			v.setMenu();
			this.show();
		}
	}

	public void buildTabuleiro(){
		t = new Board();
		v.setTable();
		this.buildIcons();
	}

	public void buildTabuleiro(int x){
		t = new Board(x);
		v.setTable();
		this.buildIcons();
	}

	public void buildIcons(){
		v.clearAllRender();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(t.board[i][j].getPiece() != null){
					v.addPiece(i,j,t.board[i][j].getPiece().getType(), t.board[i][j].getPiece().getTeam());
				}
			}
		}
	}

	private void show(){
		v.show();
	}

  // Socket
	private void startHost(){
		try{
			server = new ServerSocket(PORT);
		}
		catch(IOException e){
			System.out.println(e);
		}
		try{
			client = server.accept();
		}
		catch(IOException e){
			System.out.println(e);
		}
		this.connected();
		try{
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
		}
		catch(IOException e){
			System.out.println(e);
		}
		this.isHost = true;
		this.connected();
	}

  public void connected(){
		synch = new Thread(new MessageListener(in));
		synch.start();
		this.multiplayer = true;
		this.buildTabuleiro();
		this.show();
	}

  public void joinConnection(String s){
		try{
			client = new Socket(s,PORT);
		}
		catch(IOException e){
			System.out.println(e);
		}
		if(client.isConnected()){
			try{
				in = new DataInputStream(client.getInputStream());
				out = new DataOutputStream(client.getOutputStream());

			}
			catch(IOException e){
				System.out.println(e);
			}
			this.connected();
		}
	}

  public void getMove(){
		int x = 0;
		int y = 0;
		try{
			x = in.readInt();
			y = in.readInt();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

  public void sendMove(int x, int y){
		try{
			out.writeInt(x);
			out.flush();
			out.writeInt(y);
			out.flush();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

  public void sendNextRound(){
		try{
			out.writeInt(10);
			out.writeInt(10);
			out.writeInt(11);
			out.writeInt(11);
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
  //

}
