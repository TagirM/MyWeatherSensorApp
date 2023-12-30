package com.tagirmurzagaleev.spring_course.service;

import com.tagirmurzagaleev.spring_course.dao.SensorRepository;
import com.tagirmurzagaleev.spring_course.entity.Sensor;
import com.tagirmurzagaleev.spring_course.entity.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService{

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public void saveSensor(Sensor sensor) {

        sensorRepository.save(sensor);
    }

    @Override
    public List<Sensor> getSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public Optional<Sensor> findByName(String name) {
        return sensorRepository.findByName(name);
    }
}
