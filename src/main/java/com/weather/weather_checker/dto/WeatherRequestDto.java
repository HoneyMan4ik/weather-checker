package com.weather.weather_checker.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WeatherRequestDto {
    private String city;
}
