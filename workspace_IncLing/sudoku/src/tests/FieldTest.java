package tests;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import main.Board;
import main.BoardManager;
import main.Field;
import main.Structure;
import main.SudokuGenerator;
import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class FieldTest {

	private Field field;

	@Before
	public void setup() {
		field = new Field();
	}

	@Test
	public void fieldTest() throws IllegalArgumentException, IllegalAccessException  {
		field.POSSIBILITIES=9;
	
		assertEquals(field.POSSIBILITIES,9);
		
		boolean initialSet = (boolean) MemberModifier.field(Field.class, "initialSet").get(field);
		assertEquals(initialSet,false);

		boolean set = (boolean) MemberModifier.field(Field.class, "set").get(field);
		assertEquals(set,false);
		
//		Configuration.COLOR=true;
		if (Configuration.COLOR) {
			field = new Field();
			String  color = (String) MemberModifier.field(Field.class, "color").get(field);
			assertEquals(color,"");
		}
//		
//		Configuration.SOLVER=true;
		if(Configuration.SOLVER) {
			field.POSSIBILITIES=9;
			field = new Field();
			List remainingPos = (List) MemberModifier.field(Field.class, "remainingPos").get(field);
			assertEquals(remainingPos.size(),9);
			
		}
	}
	@Test
	public void field_Test() throws IllegalArgumentException, IllegalAccessException {
		
//		Configuration.COLOR=true;
		if (Configuration.COLOR) {
			field = new Field(2);
			String  color = (String) MemberModifier.field(Field.class, "color").get(field);
			assertEquals(color,"");
		}
	}
	
	@Test
	public void isInitialSetTest()  {
		field.setInitial(false);
		assertFalse(field.isInitialSet());
	}
	
	@Test 
	public void getRemainingPosTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.SOLVER=true;
		if (Configuration.SOLVER) {
			field = new Field();
			assertNotNull(field.getRemainingPos());	
		}
//		Configuration.SOLVER=false;
		if (!Configuration.SOLVER) {
			assertNull(field.getRemainingPos());
		}
	}
	@Test
	 public void cloneTest() throws CloneNotSupportedException {
//		 Configuration.SOLVER=false;
		 if (!Configuration.SOLVER) {
			 
			 assertNull(field.clone());
		 }
	 }
	@Test
	public void toStringTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.SOLVER=false;
		if (!Configuration.SOLVER) {
			field = new Field();
			assertNull(field.toString());
		}
//		Configuration.SOLVER=true;
		if (Configuration.SOLVER) {
			Field f = new Field();
			if(f.POSSIBILITIES==9) {
			assertEquals(f.toString(), "{123456789}");
			}
			if(f.POSSIBILITIES==4) {
				assertEquals(f.toString(), "{1234}");
			}
		}
	}
	 
	 @Test
	 public void stateCloneTest() throws CloneNotSupportedException {
//		 Configuration.STATES=false;
		 if (!Configuration.STATES) {
			 assertNull(field.stateClone());
		 }
	 }
	
}
