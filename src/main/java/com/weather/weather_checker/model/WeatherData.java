package com.weather.weather_checker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {
    private String country;
    private String city;
    private String weather;
    private int temperature;
    private int windSpeed;
}
