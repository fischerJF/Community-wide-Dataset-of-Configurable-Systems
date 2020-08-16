package testset;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;

import elevatorsystem.Environment;
import elevatorsystem.Person;

public class PersonTest {

	Person person;
	Environment env;
	@Before
	public void setUp(){
		env = new Environment(5);
		person=  new Person("Paulo", 40, 1, 4, env);
		
	}
	@Test
	public void testPerson() {
		assertEquals(person.getName(), "Paulo");
		assertEquals(person.getWeight(), 40);
		assertEquals(person.getOrigin(), 1);
		assertEquals(person.getDestination(), 4);
	}
	
	@Test
	public void isDestinationReachedTest() throws IllegalArgumentException, IllegalAccessException {
	MemberModifier.field(Person.class, "destinationReached").set(person, true);

	assertTrue(person.isDestinationReached());
	}
	

}
