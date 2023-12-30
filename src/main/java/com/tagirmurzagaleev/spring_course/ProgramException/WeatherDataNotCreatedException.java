package com.tagirmurzagaleev.spring_course.ProgramException;

public class WeatherDataNotCreatedException extends RuntimeException{
    public WeatherDataNotCreatedException(String message) {
        super(message);
    }
}
