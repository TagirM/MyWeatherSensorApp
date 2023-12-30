package com.tagirmurzagaleev.spring_course.dao;

import com.tagirmurzagaleev.spring_course.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorRepository  extends JpaRepository<Sensor, Integer> {
    public Optional<Sensor> findByName(String name);
}
