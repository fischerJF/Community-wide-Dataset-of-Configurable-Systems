package testset;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import MinePumpSystem.Actions;
import MinePumpSystem.Environment;
import MinePumpSystem.MinePump;
import MinePumpSystem.PL_Interface_impl;
import MinePumpSystem.Environment.WaterLevelEnum;
import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;

public class ActionsTest {

	Actions mockActions;

	@Before
	public void setup() {
		mockActions = new Actions();
	}

	@Test
	public void actionsTest() throws Exception {
		Environment e = (Environment) MemberModifier.field(Actions.class, "env").get(mockActions);
		MinePump m = (MinePump) MemberModifier.field(Actions.class, "p").get(mockActions);
		assertTrue(e != null);
		assertTrue(m != null);
		assertTrue(m instanceof MinePump);
		assertTrue(e instanceof Environment);
	}

	@Test
	public void getSystemStateTest() throws Exception {
		System.err.println();
		assertEquals(Whitebox.invokeMethod(mockActions, "getSystemState"),
				"Pump(System:On,Pump:Off) Env(Water:normal,Meth:OK)");
	}

	@Test
	public void timeShiftTest() throws Exception {
		
		//remove statements
//		Configuration.highWaterSensor = true;
//		Configuration.lowWaterSensor = false;
//		Configuration.methaneAlarm = false;
//		
		
		if (Configuration.highWaterSensor && !Configuration.lowWaterSensor && !Configuration.methaneAlarm) {
			MinePump m = (MinePump) MemberModifier.field(Actions.class, "p").get(mockActions);

			MemberModifier.field(MinePump.class, "pumpRunning").set(m, false);
			MemberModifier.field(MinePump.class, "systemActive").set(m, true);
			Whitebox.invokeMethod(m, "timeShift");
			assertEquals(MemberModifier.field(MinePump.class, "pumpRunning").get(m), true);
		}
	}
	
	@Test
	public void startSystemTest() throws Exception {
		Whitebox.invokeMethod(mockActions, "startSystem");
		assertTrue(PL_Interface_impl.executedUnimplementedAction);
	}
	
	@Test
	public void stopSystemTest() throws Exception {
		Whitebox.invokeMethod(mockActions, "stopSystem");
		assertTrue(PL_Interface_impl.executedUnimplementedAction);
	}
	
	@Test
	public void methaneChangeTest() throws Exception {
		Environment e = (Environment) MemberModifier.field(Actions.class, "env").get(mockActions);
		MemberModifier.field(Environment.class, "methaneLevelCritical").set(e, false);
		Whitebox.invokeMethod(mockActions, "methaneChange");
		assertEquals(MemberModifier.field(Environment.class, "methaneLevelCritical").get(e),true);
	}
	
	@Test
	public void waterRiseTest() throws Exception {
		Environment e = (Environment) MemberModifier.field(Actions.class, "env").get(mockActions);
		MemberModifier.field(Environment.class, "waterLevel").set(e , WaterLevelEnum.normal);
		Whitebox.invokeMethod(mockActions, "waterRise");
		assertEquals(Whitebox.invokeMethod(e, "getWaterLevel"),WaterLevelEnum.high);
	}
	
	
}
