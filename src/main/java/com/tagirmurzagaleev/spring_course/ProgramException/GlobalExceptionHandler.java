package com.tagirmurzagaleev.spring_course.ProgramException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<IncorrectDataException> handleException(SensorExistException exception){
        IncorrectDataException data = new IncorrectDataException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectDataException> handleException(SensorNotCreatedException exception){
        IncorrectDataException data = new IncorrectDataException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectDataException> handleException(SensorNullException exception){
        IncorrectDataException data = new IncorrectDataException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectDataException> handleException(NotSaveSensorException exception){
        IncorrectDataException data = new IncorrectDataException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.FAILED_DEPENDENCY);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectDataException> handleException(Exception exception){
        IncorrectDataException data = new IncorrectDataException();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
