package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;
import pl.sda.model.Condition;
import pl.sda.model.Current;
import org.json.*;
import pl.sda.model.Weather;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;

@Data
public class WeatherService {
    private String finalURL, url, apiKey, city = "";

    public WeatherService(String adress, String key){
        this.url = adress;
        this.apiKey = key;
        this.finalURL = this.url +"?key="+this.apiKey+"&q=";
    }


    public Weather getWeather(String city){
        Weather weather = null;
        if (!this.city.equals(city)) {
            this.city = city;
            URL dataURL = getUrlFromString(this.finalURL + city);     // Initialize and build URL object to pass it later to ObjectMapper
            weather = JsonMapper.mapJsonToClass(dataURL, Weather.class);
//            try {
//                objectMapper.writeValue(new File("data.json"), weather);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return weather;
    }



    private URL getUrlFromString(String url){
        URL outcomeUrl = null;
        try {
            outcomeUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return outcomeUrl;
    }

    private void updateFinalURL(){
        this.finalURL = this.url +"?key="+this.apiKey+"&q=";
    }

    public void setUrl(String url){
        this.url = url;
        updateFinalURL();
    }

    public void setApiKey(String apiKey){
        this.apiKey = apiKey;
        updateFinalURL();
    }
}
