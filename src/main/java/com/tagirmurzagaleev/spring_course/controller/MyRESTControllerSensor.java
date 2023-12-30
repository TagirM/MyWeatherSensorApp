package com.tagirmurzagaleev.spring_course.controller;

import com.tagirmurzagaleev.spring_course.ProgramException.NotSaveSensorException;
import com.tagirmurzagaleev.spring_course.ProgramException.SensorExistException;
import com.tagirmurzagaleev.spring_course.ProgramException.SensorNotCreatedException;
import com.tagirmurzagaleev.spring_course.ProgramException.SensorNullException;
import com.tagirmurzagaleev.spring_course.dto.SensorDTO;
import com.tagirmurzagaleev.spring_course.entity.Sensor;
import com.tagirmurzagaleev.spring_course.service.SensorService;
import com.tagirmurzagaleev.spring_course.validator.SensorValidate;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class MyRESTControllerSensor {

    @Autowired
    private SensorService sensorService;
    @Autowired
    private SensorValidate sensorValidate;

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {
        if (sensorDTO==null){
            throw new SensorNullException("Sensor is null");
        }
        Sensor sensor = convertToSensor(sensorDTO);
        sensorValidate.validate(sensor,bindingResult);
        if (bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error :
                    errors) {
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage() == null ? error.getCode() : error.getDefaultMessage()).append(";");
            }
            throw new SensorNotCreatedException("Sensor not created due to exception: " + errorMsg.toString());
        }
        sensorService.saveSensor(sensor);
        if (sensorService.getSensors() == null) {
            throw new NotSaveSensorException("Sensor did not save.");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
