package com.tagirmurzagaleev.spring_course.controller;

import com.tagirmurzagaleev.spring_course.ProgramException.*;
import com.tagirmurzagaleev.spring_course.dto.WeatherDataDTO;
import com.tagirmurzagaleev.spring_course.entity.WeatherData;
import com.tagirmurzagaleev.spring_course.service.WeatherDataService;
import com.tagirmurzagaleev.spring_course.validator.WeatherDataValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MyRESTControllerWeatherData {
    @Autowired
    private WeatherDataService weatherDataService;
    @Autowired
    private WeatherDataValidator weatherDataValidator;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addWeatherData(@RequestBody @Valid WeatherDataDTO weatherDataDTO, BindingResult bindingResult){
        if (weatherDataDTO==null){
            throw new WeatherDataNullException("Weather data is null");
        }
        WeatherData weatherData = convertToWeatherData(weatherDataDTO);
        weatherDataValidator.validate(weatherData,bindingResult);
        if (bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error :
                    errors) {
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage() == null ? error.getCode() : error.getDefaultMessage()).append(";");
            }
            throw new WeatherDataNotCreatedException("Weather data not accepted due to exception: " + errorMsg.toString());
        }
        weatherDataService.enrichWeatherData(weatherData);
        weatherDataService.saveWeatherData(weatherData);
        if (weatherDataService.getAll() == null) {
            throw new NotSaveWeatherDataException("Weather data did not save.");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/")
    public List<WeatherData> getAllData(){
        return weatherDataService.getAll();
    }

    @GetMapping("/rainyDaysCount")
    public String getRainingDays(){
        return "Raining days is " + weatherDataService.getRaining("true") + " day.";
    }


    private WeatherData convertToWeatherData(WeatherDataDTO weatherDataDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(weatherDataDTO, WeatherData.class);
    }
}
