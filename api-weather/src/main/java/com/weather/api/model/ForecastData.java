package com.weather.api.model;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

@Data
public class ForecastData {
    private String date;
    private String text;
    private String temperature;
}
