package com.tagirmurzagaleev.spring_course.service;

import com.tagirmurzagaleev.spring_course.entity.Sensor;

import java.util.List;
import java.util.Optional;

public interface SensorService {
    public void saveSensor(Sensor sensor);

    public List<Sensor> getSensors();

    public Optional<Sensor> findByName(String name);
}
