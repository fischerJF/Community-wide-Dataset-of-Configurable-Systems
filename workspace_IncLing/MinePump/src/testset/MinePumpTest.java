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

public class MinePumpTest {

	MinePump minePump;
	Environment env;
	@Before
	public void setup() {
		env = new Environment();
		minePump= new MinePump(env);
	}

	
	@Test
	public void timeShiftTest_1() throws IllegalArgumentException, IllegalAccessException {
 		MemberModifier.field(MinePump.class, "pumpRunning").set(minePump , true);
 		MemberModifier.field(MinePump.class, "systemActive").set(minePump , false);
 		MemberModifier.field(Environment.class, "waterLevel").set(env , WaterLevelEnum.normal);
    	minePump.timeShift();
 		assertEquals(MemberModifier.field(Environment.class, "waterLevel").get(env),WaterLevelEnum.low);
 	}
	@Test
	public void timeShiftTest_2() throws IllegalArgumentException, IllegalAccessException {
 		MemberModifier.field(MinePump.class, "pumpRunning").set(minePump , true);
 		MemberModifier.field(MinePump.class, "systemActive").set(minePump , false);
 		MemberModifier.field(Environment.class, "waterLevel").set(env , WaterLevelEnum.high);
    	minePump.timeShift();
 		assertEquals(MemberModifier.field(Environment.class, "waterLevel").get(env),WaterLevelEnum.normal);
 	}
	@Test
	public void timeShiftTest_3() throws Exception {
 		
// 		Configuration.highWaterSensor=true;
// 		Configuration.lowWaterSensor=false;
// 		Configuration.methaneAlarm=false;
 		if(Configuration.highWaterSensor && !Configuration.lowWaterSensor && !Configuration.methaneAlarm) {
 			
 			MemberModifier.field(MinePump.class, "pumpRunning").set(minePump , false);
 			MemberModifier.field(MinePump.class, "systemActive").set(minePump , true);
            minePump.timeShift();
 			//Whitebox.invokeMethod(minePump, "processEnvironment");
 			assertEquals(MemberModifier.field(MinePump.class, "pumpRunning").get(minePump),true);
 		}
 	}
	@Test
	public void timeShiftTest_4() throws Exception {
// 		Configuration.lowWaterSensor=true;
// 		Configuration.highWaterSensor=false;
// 		Configuration.methaneAlarm=false;
 		if(Configuration.lowWaterSensor && !Configuration.highWaterSensor && !Configuration.methaneAlarm ) {
 			MemberModifier.field(MinePump.class, "pumpRunning").set(minePump , false);
 			MemberModifier.field(MinePump.class, "systemActive").set(minePump , true);
 			minePump.timeShift();
 		 	assertEquals(MemberModifier.field(MinePump.class, "pumpRunning").get(minePump),false);
 		}
 	}
	@Test
	public void timeShiftTest_5() throws Exception {
 		
// 		Configuration.methaneAlarm=true;
// 		Configuration.lowWaterSensor=false;
// 		Configuration.highWaterSensor=false;
 	 		if(Configuration.methaneAlarm && !Configuration.lowWaterSensor && !Configuration.highWaterSensor) {
 			MemberModifier.field(MinePump.class, "pumpRunning").set(minePump , true);
 			MemberModifier.field(MinePump.class, "systemActive").set(minePump , true);
 			minePump.timeShift();
 			assertEquals(MemberModifier.field(MinePump.class, "pumpRunning").get(minePump),false);
 		}
 	 }
	
	@Test
	public void isMethaneAlarmTest() throws Exception {
		Whitebox.invokeMethod(minePump, "isMethaneAlarm");
	 	assertEquals(MemberModifier.field(Environment.class, "methaneLevelCritical").get(env),false);
	}
	
	@Test
	public void getEnvTest() throws Exception{
		assertEquals(Whitebox.invokeMethod(minePump, "getEnv"),env);
	}
	
	@Test
	public void toStringTest() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(MinePump.class, "pumpRunning").set(minePump , true);
		MemberModifier.field(MinePump.class, "systemActive").set(minePump , true);
 		MemberModifier.field(Environment.class, "waterLevel").set(env , WaterLevelEnum.high);
 		MemberModifier.field(Environment.class, "methaneLevelCritical").set(env , true);

		assertEquals(minePump.toString(),"Pump(System:On,Pump:On) Env(Water:high,Meth:CRIT)");	
	}
	
	
	}
