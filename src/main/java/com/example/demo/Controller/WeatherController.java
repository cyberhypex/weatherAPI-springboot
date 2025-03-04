package com.example.demo.Controller;


import com.example.demo.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
  private  WeatherService weatherService;

    @GetMapping("/current/{city}")
    public String getCurrentWeather(@PathVariable String city){
        return weatherService.callWeatherApi("/current.json",city);
    }

    @GetMapping("/forecast/{city}/{days}")
    public String getForecast(@PathVariable String city,
                              @PathVariable String days

    )  {
        if (!days.matches("\\d+")) {

            throw new RuntimeException("Days must be a number");

        }
        return weatherService.callWeatherApi("/forecast.json",city,days);
    }

    @GetMapping("/astronomy/{city}")
    public String getAstronomy(@PathVariable String city){
        return weatherService.callWeatherApi("/astronomy.json",city);
    }

}
