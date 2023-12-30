package com.tagirmurzagaleev.spring_course.validator;

import com.tagirmurzagaleev.spring_course.entity.Sensor;
import com.tagirmurzagaleev.spring_course.entity.WeatherData;
import com.tagirmurzagaleev.spring_course.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class WeatherDataValidator implements Validator {

    @Autowired
    private SensorService sensorService;

    @Override
    public boolean supports(Class<?> clazz) {
        return WeatherData.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        WeatherData weatherData = (WeatherData) target;
        if (weatherData.getSensor()==null){
            return;
        }
        if (sensorService.findByName(weatherData.getSensor().getName()).isEmpty()){
            errors.rejectValue("name", "Sensor is not registered in database!");
        }
    }
}
