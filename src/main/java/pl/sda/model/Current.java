package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Override
    public String toString() {
        return "Current{" +
                "last_updated_epoch=" + last_updated_epoch +
                ", last_updated='" + last_updated + '\'' +
                ", temp_c=" + temp_c +
                ", temp_f=" + temp_f +
                ", is_day=" + is_day +
                ", condition=" + condition +
                ", wind_mph=" + wind_mph +
                ", wind_kph=" + wind_kph +
                ", wind_degree=" + wind_degree +
                ", wind_dir='" + wind_dir + '\'' +
                ", pressure_mb=" + pressure_mb +
                ", pressure_in=" + pressure_in +
                ", precip_mm=" + precip_mm +
                ", precip_in=" + precip_in +
                ", humidity=" + humidity +
                ", cloud=" + cloud +
                ", feelslike_c=" + feelslike_c +
                ", feelslike_f=" + feelslike_f +
                ", vis_km=" + vis_km +
                ", vis_miles=" + vis_miles +
                ", uv=" + uv +
                ", gust_mph=" + gust_mph +
                ", gust_kph=" + gust_kph +
                '}';
    }
}
