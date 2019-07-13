package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String  name,
                    region,
                    country;
    private float   lat,
                    lon;
    private String  tz_id;
    private long    localtime_epoch;
    private String  localtime;
}
