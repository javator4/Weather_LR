package pl.sda;

import org.apache.commons.io.IOUtils;
import pl.sda.model.Condition;
import pl.sda.model.Current;
import org.json.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {
    private String finalURL, url, apiKey;

    public WeatherService(String adress, String key){
        this.url = adress;
        this.apiKey = key;
        this.finalURL = this.url +"?key="+this.apiKey+"&q=";
    }

    public Current getCityWeather(String city){
        String cityURL = finalURL+city;
        try {
            String data = IOUtils.toString(new URL(cityURL), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        JSONObject o = new JSONObject(tokener);
        JSONObject o2 = o.getJSONObject("current");
        JSONObject o3 = o2.getJSONObject("condition");

        Current current = Current.builder()
                            .last_updated_epoch(o2.getLong("last_updated_epoch"))
                            .last_updated(o2.getString("last_updated"))
                            .temp_c(o2.getFloat("temp_c"))
                            .temp_f(o2.getFloat("temp_f"))
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
}
