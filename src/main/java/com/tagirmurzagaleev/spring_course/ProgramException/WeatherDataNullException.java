package com.tagirmurzagaleev.spring_course.ProgramException;

public class WeatherDataNullException extends RuntimeException{
    public WeatherDataNullException(String message) {
        super(message);
    }
}
