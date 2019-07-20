package pl.sda;
import pl.sda.model.*;
import org.apache.log4j.*;

/**
 * Hello world!
 *
 */
public class App
{
    private static Logger logger = Logger.getLogger(App.class);

    public static void main( String[] args ){
        logger.info("URUCHOMIENIE APLIKACJI");
        logger.warn("WARNING");
        logger.debug("DEBUG");
        logger.error("ERROR");
        WeatherService weatherService = new WeatherService("http://api.apixu.com/v1/current.json", "c43efeb2af124a358ca81413191307");
        Weather weather = weatherService.getWeather("Torun");
        System.out.println(weather);


    }
}
