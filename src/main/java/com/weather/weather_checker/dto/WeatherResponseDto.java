package com.weather.weather_checker.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WeatherResponseDto {
    private String country;
    private String city;
    private String weather;
    private int temperature;
    private int windSpeed;
}
