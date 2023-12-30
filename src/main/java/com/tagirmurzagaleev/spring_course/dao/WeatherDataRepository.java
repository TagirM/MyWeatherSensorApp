package com.tagirmurzagaleev.spring_course.dao;

import com.tagirmurzagaleev.spring_course.entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Integer> {
    public List<WeatherData> findByRaining(String raining);
}
