package com.tagirmurzagaleev.spring_course.ProgramException;

public class SensorExistException extends RuntimeException{
    public SensorExistException(String message) {
        super(message);
    }
}
