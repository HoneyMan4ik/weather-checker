package com.weather.weather_checker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WeatherApiException.class)
        public ResponseEntity<ErrorObject> handleEventNotFoundException(WeatherApiException ex, WebRequest request){
            ErrorObject errorObject = new ErrorObject();

            errorObject.setStatusCode(ex.getStatusCode().value());
            errorObject.setMessage(ex.getMessage());
            errorObject.setTimestamp(new Date());

            return new ResponseEntity<>(errorObject, ex.getStatusCode());
        }
    }
