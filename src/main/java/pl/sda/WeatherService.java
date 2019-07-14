package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import pl.sda.model.Condition;
import pl.sda.model.Current;
import org.json.*;
import pl.sda.model.Location;
import pl.sda.model.Weather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Data
public class WeatherService {
    private String finalURL, url, apiKey, city = "";
    private JSONObject jsonData;

    public WeatherService(String adress, String key){
        this.url = adress;
        this.apiKey = key;
        this.finalURL = this.url +"?key="+this.apiKey+"&q=";
    }

    @Deprecated
    public Current getCityWeather(){

        JSONObject currentData = this.jsonData.getJSONObject("current");
        JSONObject conditionData = currentData.getJSONObject("condition");

        Current current = Current.builder()
                .last_updated_epoch(currentData.getLong("last_updated_epoch"))
                .last_updated(currentData.getString("last_updated"))
                .temp_c(currentData.getFloat("temp_c"))
                .temp_f(currentData.getFloat("temp_f"))
                .is_day(currentData.getInt("is_day"))
                .condition(Condition.builder()
                    .text(conditionData.getString("text"))
                    .icon(conditionData.getString("icon"))
                    .code(conditionData.getInt("code"))
                    .build())
                .wind_mph(currentData.getFloat("wind_mph"))
                .wind_kph(currentData.getFloat("wind_kph"))
                .wind_degree(currentData.getInt("wind_degree"))
                .wind_dir(currentData.getString("wind_dir"))
                .pressure_mb(currentData.getFloat("pressure_mb"))
                .pressure_in(currentData.getFloat("pressure_in"))
                .precip_mm(currentData.getFloat("precip_mm"))
                .precip_in(currentData.getFloat("precip_in"))
                .humidity(currentData.getInt("humidity"))
                .cloud(currentData.getInt("cloud"))
                .feelslike_c(currentData.getFloat("feelslike_c"))
                .feelslike_f(currentData.getFloat("feelslike_f"))
                .vis_km(currentData.getFloat("vis_km"))
                .vis_miles(currentData.getFloat("vis_miles"))
                .uv(currentData.getFloat("uv"))
                .gust_mph(currentData.getFloat("gust_mph"))
                .gust_kph(currentData.getFloat("gust_kph"))
                .build();

        return current;
//        return new  Current(o2.getLong("last_updated_epoch"),
//                            o2.getString("last_updated"),
//                            o2.getFloat("temp_c"),
//                            o2.getFloat("temp_f"),
//                            o2.getInt("is_day"),
//                            new Condition(o3.getString("text"),
//                                          o3.getString("icon"),
//                                          o3.getInt("code")),
//                            o2.getFloat("wind_mph"),
//                            o2.getFloat("wind_kph"),
//                            o2.getInt("wind_degree"),
//                            o2.getString("wind_dir"),
//                            o2.getFloat("pressure_mb"),
//                            o2.getFloat("pressure_in"),
//                            o2.getFloat("precip_mm"),
//                            o2.getFloat("precip_in"),
//                            o2.getInt("humidity"),
//                            o2.getInt("cloud"),
//                            o2.getFloat("feelslike_c"),
//                            o2.getFloat("feelslike_f"),
//                            o2.getFloat("vis_km"),
//                            o2.getFloat("vis_miles"),
//                            o2.getFloat("uv"),
//                            o2.getFloat("gust_mph"),
//                            o2.getFloat("gust_kph"));
    }

    @Deprecated
    public Location getLocation(){
        JSONObject locationData = jsonData.getJSONObject("location");

        Location location = Location.builder()
                .name(locationData.getString("name"))
                .region(locationData.getString("region"))
                .country(locationData.getString("country"))
                .lat(locationData.getFloat("lat"))
                .lon(locationData.getFloat("lon"))
                .tz_id(locationData.getString("tz_id"))
                .localtime_epoch(locationData.getLong("localtime_epoch"))
                .localtime(locationData.getString("localtime"))
                .build();

        return location;
    }

    @Deprecated
    public WeatherService getWeatherData(String city){
        if (!this.city.equals(city)){
            this.city = city;
            String cityURL = finalURL+city;

            URL url = null;
            try {
                url = new URL(cityURL);
            } catch (MalformedURLException e){
                e.printStackTrace();
            }
            JSONTokener tokener = null;
            try {
                tokener = new JSONTokener(url.openStream());
            } catch (IOException e){
                e.printStackTrace();
            }

            this.jsonData = new JSONObject(tokener);
        }
        return this;
    }

    public Weather getWeather(String city){
        if (!this.city.equals(city)) {
            this.city = city;
            String cityURL = finalURL + city;

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Weather weather = objectMapper.readValue(new URL(cityURL), Weather.class);
                return weather;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
