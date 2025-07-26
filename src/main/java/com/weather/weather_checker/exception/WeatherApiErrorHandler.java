package com.weather.weather_checker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

@Component
public class WeatherApiErrorHandler {
    public void handleApiError(HttpStatusCode statusCode, String city) throws WeatherApiException{

        HttpStatus status = HttpStatus.resolve(statusCode.value());

        if(status == null){
            throw new WeatherApiException("Unknown api error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        switch (status){
            case NOT_FOUND ->
                    throw new WeatherApiException("City not found:" + city, status);
            case UNAUTHORIZED ->
                    throw new WeatherApiException("Invalid api key", status);
            case TOO_MANY_REQUESTS ->
                    throw new WeatherApiException("Api rate limit exceeded", status);

            default ->
                    throw new WeatherApiException("Weather api error: "+ status, status);
        }
    }
}
