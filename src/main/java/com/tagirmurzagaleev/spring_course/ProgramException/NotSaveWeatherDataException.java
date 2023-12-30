package com.tagirmurzagaleev.spring_course.ProgramException;

public class NotSaveWeatherDataException extends RuntimeException{
    public NotSaveWeatherDataException(String message) {
        super(message);
    }
}
