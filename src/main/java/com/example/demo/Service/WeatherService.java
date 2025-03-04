package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {


    @Value("${weather.api.url}")
    private String apiURL;

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate=new RestTemplate();

    public String callWeatherApi(String endPoint,String query){
        String url=apiURL+endPoint+"?key="+apiKey+"&q="+query;

        return restTemplate.getForObject(url,String.class);
    }
    public String callWeatherApi(String endpoint, String query, String days) {
        String url = apiURL + endpoint + "?key=" + apiKey + "&q=" + query;

        if (days != null && !days.isEmpty()) {
            url += "&days=" + days;
        }

        return restTemplate.getForObject(url, String.class);
    }
}
