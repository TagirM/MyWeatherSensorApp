package com.tagirmurzagaleev.spring_course.service;

import com.tagirmurzagaleev.spring_course.dao.WeatherDataRepository;
import com.tagirmurzagaleev.spring_course.entity.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeatherDataServiceImpl implements WeatherDataService{

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Autowired
    private SensorService sensorService;

    @Override
    public void saveWeatherData(WeatherData weatherData) {
        weatherDataRepository.save(weatherData);
    }

    @Override
    public List<WeatherData> getAll() {
        return weatherDataRepository.findAll();
    }

    @Override
    public int getRaining(String raining) {
        return weatherDataRepository.findByRaining(raining).size();
    }


    public void enrichWeatherData(WeatherData weatherData){
        weatherData.setSensor(sensorService.findByName(weatherData.getSensor().getName()).get());
        weatherData.setWeatherDateTime(LocalDateTime.now());
    }
}
