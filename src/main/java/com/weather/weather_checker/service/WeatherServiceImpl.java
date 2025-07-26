package com.weather.weather_checker.service;

import com.weather.weather_checker.client.WeatherApiClient;
import com.weather.weather_checker.dto.WeatherResponseDto;
import com.weather.weather_checker.exception.WeatherApiException;
import com.weather.weather_checker.mapper.WeatherMapper;
import com.weather.weather_checker.model.WeatherData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{

    private final WeatherApiClient weatherApiClient;
    private final WeatherMapper weatherDtoMapper;

    @Override
    public WeatherResponseDto getWeatherByCity(String city) {
        try {
            WeatherData weatherData = weatherApiClient.fetchWeatherData(city);
            return weatherDtoMapper.toDto(weatherData);
        }
        catch (WeatherApiException e){
            throw new RuntimeException("Failed to fetch weather", e);
        }

    }
}
