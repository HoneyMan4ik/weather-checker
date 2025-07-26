package com.weather.weather_checker.client;

import com.weather.weather_checker.exception.WeatherApiErrorHandler;
import com.weather.weather_checker.exception.WeatherApiException;
import com.weather.weather_checker.mapper.WeatherMapper;
import com.weather.weather_checker.model.WeatherData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherApiClientImpl implements WeatherApiClient{
    private final RestTemplate restTemplate;
    private final WeatherMapper responseMapper;
    private final WeatherApiErrorHandler errorHandler;

    @Value("${openweather.api.url}")
    private String apiUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.units}")
    private String units;

    private String buildRequestUrl(String city){
        return String.format("%s?q=%s&appid=%s&units=%s", apiUrl, city, apiKey, units);
    }

    @Override
    public WeatherData fetchWeatherData(String city) throws WeatherApiException {
        String url = buildRequestUrl(city);

        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            return responseMapper.mapResponseToWeatherData(response.getBody());
        }catch (HttpClientErrorException e){
            errorHandler.handleApiError(e.getStatusCode(), city);
            return null;
        }catch (Exception e){
            throw new WeatherApiException("Failed to fetch weather data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
