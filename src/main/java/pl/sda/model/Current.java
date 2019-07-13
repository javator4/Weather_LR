package pl.sda.model;

public class Current {
    private long        last_updated_epoch;
    private String      last_updated;
    private float       temp_c,
                        temp_f;
    private int         is_day;
    private Condition   condition;
    private float       wind_mph,
                        wind_kph;
    private int         wind_degree;
    private String      wind_dir;
    private float       pressure_mb,
                        pressure_in,
                        precip_mm,
                        precip_in;
    private int         humidity,
                        cloud;
    private float       feelslike_c,
                        feelslike_f,
                        vis_km,
                        vis_miles,
                        uv,
                        gust_mph,
                        gust_kph;
}
