package testset;


import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import Set.IntegerSet;
import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class IntegerSetTest{

	private  IntegerSet integSet;

	@Before
	public void setup() {
	}

	@Test
	public void insertTree_isEmptyTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.tree=true;
//		Configuration.hashset=false;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			MemberModifier.field(IntegerSet.class, "isEmpty").set(integSet , true);
			integSet.insert(100);
			boolean test=(boolean) MemberModifier.field(IntegerSet.class, "isEmpty").get(integSet);
		    assertFalse(test);
			int element=(int) MemberModifier.field(IntegerSet.class, "rootValue").get(integSet);
			assertEquals(element, 100);
		}
	}
	
	@Test
	public void insertTreeLeftTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.tree=true;
//		Configuration.hashset=false;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(10);
			integSet.insert(5);
			
			IntegerSet left=(IntegerSet) MemberModifier.field(IntegerSet.class, "left").get(integSet);
			assertEquals(left.toString(),"{5}");
			
			int rootValue=(int) MemberModifier.field(IntegerSet.class, "rootValue").get(integSet);
			assertEquals(rootValue,10);
		}
	}
	@Test
	public void insertTreeRightTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.tree=true;
//		Configuration.hashset=false;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(50);
			integSet.insert(25);
			integSet.insert(60);
			
			IntegerSet right=(IntegerSet) MemberModifier.field(IntegerSet.class, "right").get(integSet);
			
			assertEquals(right.toString(),"{60}");
			
			IntegerSet left=(IntegerSet) MemberModifier.field(IntegerSet.class, "left").get(integSet);
			assertEquals(left.toString(),"{25}");
			
			int rootValue=(int) MemberModifier.field(IntegerSet.class, "rootValue").get(integSet);
			assertEquals(rootValue,50);	
			}
	}
	
	@Test
	public void insertHashsetTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.hashset=true;
//		Configuration.tree=false;
//		
		if(Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(100);
			integSet.insert(200);
			HashSet  hashset = (HashSet) MemberModifier.field(IntegerSet.class, "hset").get(integSet);
		
			assertTrue(hashset.contains(100));
			assertTrue(hashset.contains(200));
		}
	}

	@Test
	public void removeHashsetTest() throws IllegalArgumentException, IllegalAccessException{
//		Configuration.hashset=true;
//		Configuration.tree=false;
//		
		if(Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(100);
			integSet.insert(200);
			HashSet  hashset = (HashSet) MemberModifier.field(IntegerSet.class, "hset").get(integSet);
			integSet.remove(100);
			assertFalse(hashset.contains(100));
		}
	}
	
	@Test
	public void removeTreeTest() throws IllegalArgumentException, IllegalAccessException {
	
//		Configuration.hashset=false;
//		Configuration.tree=true;
//	
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(50);
			integSet.insert(25);
			integSet.insert(60);
			integSet.remove(25);
			assertFalse(integSet.isMember(25));
			}
	}

	@Test
	public void isMemberHashsetTest() throws IllegalArgumentException, IllegalAccessException {
	
//		Configuration.hashset=true;
//		Configuration.tree=false;
//	
		if(!Configuration.tree && Configuration.hashset) {
			integSet = new IntegerSet();
			for(int x=0; x<100; x++) {
				integSet.insert(x);
			}
			boolean control=false;
			for(int x=0; x<100; x++) {
				control=integSet.isMember(x);
			}
			assertTrue(control);
		}
	}
	
	@Test
	public void isMemberTreeTest() throws IllegalArgumentException, IllegalAccessException {
	
//		Configuration.hashset=false;
//		Configuration.tree=true;
	
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			for(int x=0; x<100; x++) {
				integSet.insert(x);
			}
			boolean control=false;
			for(int x=0; x<100; x++) {
				control=integSet.isMember(x);
			}
			assertTrue(control);
		}
	}
	
	@Test
	public void isMemberTree_isEmptyTest() throws IllegalArgumentException, IllegalAccessException {
		
//		Configuration.hashset=false;
//		Configuration.tree=true;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			assertFalse(integSet.isMember(10));
		}
	}
	@Test
	public void isMemberHashset_isEmptyTest() throws IllegalArgumentException, IllegalAccessException {
	
//		Configuration.hashset=true;
//		Configuration.tree=false;
//	
		if(!Configuration.tree && Configuration.hashset) {
			integSet = new IntegerSet();
			assertFalse(integSet.isMember(10));
		}
	}
	@Test
	public void isMemberTree_LeftNullTest() throws IllegalArgumentException, IllegalAccessException {
		
//		Configuration.hashset=false;
//		Configuration.tree=true;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(50);
			integSet.insert(30);
			integSet.insert(40);
			integSet.remove(30);
			assertTrue(integSet.isMember(40));
		}
	}
	@Test
	public void isMemberTree_RightNullTest() throws IllegalArgumentException, IllegalAccessException {
		
//		Configuration.hashset=false;
//		Configuration.tree=true;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(50);
			integSet.insert(30);
			integSet.insert(40);
			assertFalse(integSet.isMember(60));
		}
	}
	@Test
	public void removeTree_RightNullTest() throws IllegalArgumentException, IllegalAccessException {
		
//		Configuration.hashset=false;
//		Configuration.tree=true;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(50);
			integSet.insert(30);
			integSet.insert(40);
			integSet.insert(60);
			
			integSet.remove(60);
			
			assertFalse(integSet.isMember(60));
		}
	}
	
	@Test
	public void getPredecessorTest() throws Exception {
//		Configuration.hashset=false;
//		Configuration.tree=true;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(50);
			integSet.insert(60);
			IntegerSet intSet= Whitebox.invokeMethod(integSet, "getPredecessor");
		assertEquals(intSet,null);
		}
	}
	@Test
	public void getPredecessorRightTest() throws Exception {
//		Configuration.hashset=false;
//		Configuration.tree=true;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(15);
			integSet.insert(4);
			integSet.insert(3);
			integSet.insert(6);
			integSet.insert(5);
			integSet.insert(8);
			integSet.insert(7);
			integSet.insert(10);
			
			IntegerSet intSet= Whitebox.invokeMethod(integSet, "getPredecessor");
			assertEquals(intSet.toString(),"{10}");
		}
	}
	@Test
	public void getSuccessorTest() throws Exception {
//		Configuration.hashset=false;
//		Configuration.tree=true;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(5);
			integSet.insert(7);
			integSet.insert(6);
			integSet.insert(9);
			integSet.insert(8);
			integSet.insert(10);
			
			IntegerSet intSet= Whitebox.invokeMethod(integSet, "getSuccessor");
			assertEquals(intSet.toString(),"{6}");
		}
	}
	
	@Test
	public void removeRootTest() throws Exception {
//		Configuration.hashset=false;
//		Configuration.tree=true;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(15);
			integSet.insert(4);
			integSet.insert(3);
			integSet.insert(6);
			integSet.insert(5);
			integSet.insert(8);
			integSet.insert(7);
			integSet.insert(10);
			
			IntegerSet intSet= Whitebox.invokeMethod(integSet, "removeRoot");
			int rootValue=(int) MemberModifier.field(IntegerSet.class, "rootValue").get(integSet);
			assertNotEquals(rootValue,15);	
			}
		}
	@Test
	public void toStringHashsetTest() {
//		Configuration.hashset=true;
//		Configuration.tree=false;
//		
		if(!Configuration.tree && Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(15);
		
			assertEquals(integSet.toString(),"[15]");
		}
		
	}
	@Test
	public void printTreeTest() throws Exception {
//		Configuration.hashset=false;
//		Configuration.tree=true;
//		
		if(Configuration.tree && !Configuration.hashset) {
			integSet = new IntegerSet();
			integSet.insert(20);
			integSet.insert(10);
			integSet.insert(5);
			integSet.insert(15);
			integSet.insert(30);
			integSet.insert(25);
			integSet.insert(35);
			
			String intSet= Whitebox.invokeMethod(integSet, "printTree",true);
			String output="5, 10, 15, 20, 25, 30, 35";
			assertEquals(intSet.toString(),output);
			intSet= Whitebox.invokeMethod(integSet, "printTree",false);					
			output=", 5, 10, 15, 20, 25, 30, 35";
			assertEquals(intSet.toString(),output);
		}
	}
}
