package pl.sda;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsonMapper {
    public static  <T> T mapJsonToClass(URL url, Class<T> mapTo){
        T classToMap;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            classToMap = objectMapper.readValue(url, mapTo);
            return classToMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static  <T> T mapJsonToClass(File file, Class<T> mapTo){
        T classToMap;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            classToMap = objectMapper.readValue(file, mapTo);
            return classToMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
