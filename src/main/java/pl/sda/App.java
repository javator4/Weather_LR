package pl.sda;

import pl.sda.model.Current;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json", "c43efeb2af124a358ca81413191307");
        Current current = weatherService.getCityWeather("Torun");
        System.out.println(current.getHumidity());
    }
}
