package com.weather.weather_checker.exception;

import org.springframework.http.HttpStatus;

public class WeatherApiException extends Exception{

    private final HttpStatus statusCode;

    public WeatherApiException(String message, HttpStatus statusCode){
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode(){
        return statusCode;
    }
}
