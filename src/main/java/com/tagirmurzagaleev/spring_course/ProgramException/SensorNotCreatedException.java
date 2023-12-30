package com.tagirmurzagaleev.spring_course.ProgramException;

public class SensorNotCreatedException extends RuntimeException{
    public SensorNotCreatedException(String message) {
        super(message);
    }
}
