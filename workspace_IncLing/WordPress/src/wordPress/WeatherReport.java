package wordPress;

import specifications.Configuration;

public class WeatherReport {
	public float temparature;
	public String createText(String c) {
		if (Configuration.SMILEY)
			c = c.replace(":]", "Smiley"+(":]"));
		if (Configuration.WEATHER) {
			String weather = getWeather();
			c = c.replace("[: weather :]", weather);
		}
		return c;
	}

	public String getWeather() {
		if (Configuration.FAHRENHEIT)
			return (temparature * 1.8 + 32) + "ºF";
		return  temparature+ "ºC";
	}
	
	public static void main(String[] args) {
	
		Configuration.WEATHER=true;
		Configuration.SMILEY=true;
		Configuration.FAHRENHEIT=false;
		WeatherReport w = new WeatherReport();
		System.out.println(w.createText("[: weather :]"));
	}
}
