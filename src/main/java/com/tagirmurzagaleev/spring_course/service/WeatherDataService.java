package com.tagirmurzagaleev.spring_course.service;

import com.tagirmurzagaleev.spring_course.entity.WeatherData;

import java.util.List;

public interface WeatherDataService {
    public void saveWeatherData(WeatherData weatherData);

    public List<WeatherData> getAll();

    public int getRaining(String raining);

    public void enrichWeatherData(WeatherData weatherData);
}
