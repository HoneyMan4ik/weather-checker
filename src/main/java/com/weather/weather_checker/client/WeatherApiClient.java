package com.weather.weather_checker.client;

import com.weather.weather_checker.exception.WeatherApiException;
import com.weather.weather_checker.model.WeatherData;

public interface WeatherApiClient {
    WeatherData fetchWeatherData(String city) throws WeatherApiException;
}
