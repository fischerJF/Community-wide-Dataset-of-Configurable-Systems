package testset;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import MinePumpSystem.Environment;
import MinePumpSystem.MinePump;
import MinePumpSystem.Environment.WaterLevelEnum;
import specifications.Configuration;

import static org.junit.Assert.assertEquals;

public class EnvironmentTest {

	MinePump minePump;
	Environment env;
	@Before
	public void setup() {
		env = new Environment();
		minePump= new MinePump(env);
	}

	
	@Test
	public void getWaterLevelTest() throws Exception {
		MemberModifier.field(Environment.class, "waterLevel").set(env , WaterLevelEnum.normal);
		assertEquals(Whitebox.invokeMethod(env, "getWaterLevel"),WaterLevelEnum.normal);
		
		MemberModifier.field(Environment.class, "waterLevel").set(env , WaterLevelEnum.low);
		assertEquals(Whitebox.invokeMethod(env, "getWaterLevel"),WaterLevelEnum.low);
		
		MemberModifier.field(Environment.class, "waterLevel").set(env , WaterLevelEnum.high);
		assertEquals(Whitebox.invokeMethod(env, "getWaterLevel"),WaterLevelEnum.high);
 	}
	
	@Test
	public void changeMethaneLevelTest() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(Environment.class, "methaneLevelCritical").set(env , false);
		env.changeMethaneLevel();
		assertEquals(MemberModifier.field(Environment.class, "methaneLevelCritical").get(env),true);
		env.changeMethaneLevel();
		assertEquals(MemberModifier.field(Environment.class, "methaneLevelCritical").get(env),false);
	}
	
	@Test
	public void waterRiseTest() throws Exception {
		
		MemberModifier.field(Environment.class, "waterLevel").set(env , WaterLevelEnum.normal);
		env.waterRise();
		assertEquals(Whitebox.invokeMethod(env, "getWaterLevel"),WaterLevelEnum.high);
		
		MemberModifier.field(Environment.class, "waterLevel").set(env , WaterLevelEnum.low);
		env.waterRise();
		assertEquals(Whitebox.invokeMethod(env, "getWaterLevel"),WaterLevelEnum.normal);
		
	}
	
	
	}
