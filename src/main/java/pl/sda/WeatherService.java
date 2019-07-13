package pl.sda;

import pl.sda.model.Current;
import org.json.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WeatherService {
    private String finalURL, serviceAdress, serviceKey;

    public WeatherService(String adress, String key){
        this.serviceAdress = adress;
        this.serviceKey = key;
        this.finalURL = this.serviceAdress+"?key="+this.serviceKey;
    }

    public Current getCityWeather(String city){
        String cityURL = finalURL+"&q="+city;
        URL url = null;
        try {
            url = new URL(cityURL);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        Scanner scanner = null;
        try {
            scanner = new Scanner(url.openStream());
        } catch (IOException e){
            e.printStackTrace();
        }

        return new Current();
    }
}
