package com.tagirmurzagaleev.spring_course.ProgramException;

public class NotSaveSensorException extends RuntimeException{
    public NotSaveSensorException(String message) {
        super(message);
    }
}
