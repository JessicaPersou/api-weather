package com.weather.api.controller;

import com.weather.api.model.ForecastResponse;
import com.weather.api.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private static final String CLIMATEMPO_API_KEY = "e992a4b6fbaaee595df54f5e99cd84ac";
    private static final String BASE_URL = "http://apiadvisor.climatempo.com.br/api/v1/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentWeather(@RequestParam("cityId") Long cityId){
        String url = BASE_URL + "weather/locale/" + cityId + "/current?token=" + CLIMATEMPO_API_KEY;
        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
        return ResponseEntity.ok(weatherResponse);
    }

    @GetMapping("/forecast")
    public ResponseEntity<?> getWeatherForecast(@RequestParam("cityId") Long cityId) {
        String url = BASE_URL + "forecast/locale/" + cityId + "/days/15?token=" + CLIMATEMPO_API_KEY;
        ForecastResponse forecastResponse = restTemplate.getForObject(url, ForecastResponse.class);
        return ResponseEntity.ok(forecastResponse);
    }
}
