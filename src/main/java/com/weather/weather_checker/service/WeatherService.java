package com.weather.weather_checker.service;

import com.weather.weather_checker.dto.WeatherResponseDto;

public interface WeatherService {
    WeatherResponseDto getWeatherByCity(String city);
}
