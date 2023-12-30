package com.tagirmurzagaleev.spring_course.validator;

import com.tagirmurzagaleev.spring_course.entity.Sensor;
import com.tagirmurzagaleev.spring_course.service.SensorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

@Component
public class SensorValidate implements Validator {

    @Autowired
    private SensorService sensorService;


    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        System.out.println(sensorService.findByName(sensor.getName()).get());
        if (sensorService.findByName(sensor.getName()).isPresent()){
            errors.rejectValue("name", "Sensor already is registered!");
        }
    }
}
