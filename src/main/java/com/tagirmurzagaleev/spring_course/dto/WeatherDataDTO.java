package com.tagirmurzagaleev.spring_course.dto;

import com.tagirmurzagaleev.spring_course.entity.Sensor;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class WeatherDataDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull(message = "Value of temperature must be required")
    @Min(-100)
    @Max(100)
    private Double value;


    @NotEmpty(message = "This field of raining must be required")
    private String raining;


    private LocalDateTime weatherDateTime;

    @NotNull(message = "Sensor must be required")
    private Sensor sensor;


    public WeatherDataDTO() {
    }

    public WeatherDataDTO(double value, String raining) {
        this.value = value;
        this.raining = raining;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getRaining() {
        return raining;
    }

    public void setRaining(String raining) {
        this.raining = raining;
    }

    public LocalDateTime getWeatherDateTime() {
        return weatherDateTime;
    }

    public void setWeatherDateTime(LocalDateTime weatherDateTime) {
        this.weatherDateTime = weatherDateTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
