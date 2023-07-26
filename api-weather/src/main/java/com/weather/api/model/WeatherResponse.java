package com.weather.api.model;

import lombok.Data;

@Data
public class WeatherResponse {
    private String date;
    private String text;
    private String temperature;
}
