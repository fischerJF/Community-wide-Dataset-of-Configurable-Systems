package main;

import java.util.List;
import java.util.Random;

import splat.SudokuVariables;

public class SudokuGenerator { 

    public Board generate() { 
        if(SudokuVariables.getSINGLETON().getGENERATOR___()){
	        Board board = new Board();                  
	        fillBoard(board);             
	        makeSolvable(board, 50);      
	        return board; 
        } 
	return null;
    }
    
    public static void fillBoard(Board board){ 
    	if(SudokuVariables.getSINGLETON().getGENERATOR___()){
	        BoardManager bm = new BoardManager(); 	        
	        Random r = new Random(999); 	        
	        bm.setBoard(board);       	
	        int fieldsToFill = Field.POSSIBILITIES * Field.POSSIBILITIES; 	        
	        //set all fields with random numbers if possible
	        //try to solve, if not possible remove one number and try again...	        
	        for(int i=0; i< fieldsToFill; i++){ 	
	            int row = r.nextInt(Field.POSSIBILITIES);
	            int fieldIndex = r.nextInt(Field.POSSIBILITIES); 	            
	            List remainingPos = bm.getField(Structure.ROW, 
	                row, fieldIndex).getRemainingPos(); 	
	            if(remainingPos.size()>0){
	                int value = (Integer)remainingPos.get(r.nextInt(remainingPos.size()));	             
	                boolean result = bm.trySetFieldPrivate(Structure.ROW, row, fieldIndex, new Field(value, true));	        
	                if (!result) {
	                    bm.undo();
	                }  	
	            } else {
	                bm.undo();
	            }
	        } 
    	} 
    } 
    
    private boolean makeSolvable(Board board, int steps){ 
    	if(SudokuVariables.getSINGLETON().getGENERATOR___()){
	        BoardManager bm = new BoardManager(); 
	        bm.setBoard(board); 
	        Random r = new Random(999); 
	        int k = steps;        
	        try{         
		        //board filled, check solution
		        List solutions = bm.solve((Board) board.clone()); 
		        boolean solvable = !solutions.isEmpty(); 
		        while(k>0){ 
		            //remove random number and try again
		            board.removeRandomSetField(); 
		            solutions = bm.solve((Board) board.clone()); 
		            if(!solutions.isEmpty()){ 
		                return true; 
		            } 
		            k--;              
		        }        
	        } catch (CloneNotSupportedException e) { 
	        }
	        return false; 
    	}
	return false;
    }
       
}
