package com.weather.weather_checker.mapper;

import com.weather.weather_checker.dto.WeatherRequestDto;
import com.weather.weather_checker.dto.WeatherResponseDto;
import com.weather.weather_checker.model.WeatherData;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WeatherMapper {
    public WeatherData toEntity(WeatherRequestDto dto){
        return WeatherData.builder().
                city(dto.getCity()).
                build();
    }
    public WeatherResponseDto toDto(WeatherData weather){
        return WeatherResponseDto.builder().
                country(weather.getCountry()).
                city(weather.getCity()).
                weather(weather.getWeather()).
                temperature(weather.getTemperature()).
                windSpeed(weather.getWindSpeed()).
                build();
    }

    public WeatherData mapResponseToWeatherData(Map<String, Object> responseBody){
        Map<String, Object> main = (Map<String, Object>) responseBody.get("main");
        Map<String, Object> wind = (Map<String, Object>) responseBody.get("wind");
        Map<String, Object> sys = (Map<String, Object>) responseBody.get("sys");
        Map<String, Object> weather = ((java.util.List<Map<String, Object>>) responseBody.get("weather")).get(0);

        return WeatherData.builder()
                .city(responseBody.get("name").toString())
                .country(sys.get("country").toString())
                .weather(weather.get("main").toString())
                .temperature(((Number) main.get("temp")).intValue())
                .windSpeed(((Number) wind.get("speed")).intValue())
                .build();
    }
}
