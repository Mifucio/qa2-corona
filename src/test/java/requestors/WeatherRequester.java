package requestors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.WeatherResponse;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    //Send request to the end point, receive data, parse (or map) data, return parsed result
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?id=";
    private final String POSTFIX = "&appid=b1b15e88fa797225412429c1c50c122a1";

    public WeatherResponse getWeather(int cityId) throws JsonProcessingException {
        String url = PREFIX + cityId + POSTFIX;

        //Request weather data & get response
        RestTemplate restTemplate = new RestTemplate();
        String  jsonToParse = restTemplate.getForEntity(url, String.class).getBody();

        //Parse or map JSON to Object
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonToParse, WeatherResponse.class);
    }
}
