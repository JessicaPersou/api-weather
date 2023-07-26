package com.weather.api.model;

import lombok.Data;

import java.util.List;

@Data
public class ForecastResponse {

    private List<ForecastData> dara;
}
