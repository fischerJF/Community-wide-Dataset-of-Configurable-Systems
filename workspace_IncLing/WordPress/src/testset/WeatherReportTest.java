package testset;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import specifications.Configuration;
import wordPress.WeatherReport;

public class WeatherReportTest {

	WeatherReport wr;
	@Before
	public void setUp() {
		wr= new WeatherReport();
		wr.temparature=30;
	}
	@Test
	public void Test1() {
		if(Configuration.SMILEY) {
			assertEquals(wr.createText("[: weather :]"),"[: weather Smiley:]");
		}
	}
	@Test
	public void Test2() {
		if(Configuration.WEATHER && Configuration.FAHRENHEIT) {
			assertEquals(wr.createText("[: weather :]"),"86.0ºF");
		}
	}
	@Test
	public void Test3() {
		if(Configuration.WEATHER && !Configuration.FAHRENHEIT) {
			assertEquals(wr.createText("[: weather :]"),"30.0ºC");
		}
	}
}
