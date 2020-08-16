package testset;


import piece.Piece;
import piece.Space;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class SpaceTest {

	private Space space;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		space= new Space();
	}


	@Test
	public void testIsPieceNull()  {
		assertTrue(space.isPieceNull());
		space=new Space(new Piece(0,0,1));
		
		assertFalse(space.isPieceNull());
	}
	
	
	
}
