package com.weather.weather_checker.controller;

import com.weather.weather_checker.dto.WeatherRequestDto;
import com.weather.weather_checker.dto.WeatherResponseDto;
import com.weather.weather_checker.service.WeatherService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/search")
    public WeatherResponseDto getWeatherByCity(@RequestParam @NonNull String city){
        return weatherService.getWeatherByCity(city);
    }
}
