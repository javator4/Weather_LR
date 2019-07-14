package pl.sda;
import pl.sda.model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json", "c43efeb2af124a358ca81413191307");
        Current current = weatherService.getWeatherData("Torun").getCityWeather();
        Location location = weatherService.getWeatherData("Torun").getLocation();
        System.out.println(location.getLocaltime());
        System.out.println(current.getHumidity());
    }
}
