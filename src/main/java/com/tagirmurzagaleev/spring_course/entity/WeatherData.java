package com.tagirmurzagaleev.spring_course.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "weather_data")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    @NotNull(message = "Value of temperature must be required")
    @Min(-100)
    @Max(100)
    private Double value;

    @Column(name = "raining")
    @NotEmpty(message = "This field of raining must be required")
    private String raining;

    @Column(name = "data_time_create")
    private LocalDateTime weatherDateTime;

    @NotNull(message = "Sensor must be required")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private Sensor sensor;

    public WeatherData() {
    }

    public WeatherData(double value, String raining) {
        this.value = value;
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

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", value=" + value +
                ", raining='" + raining + '\'' +
                '}';
    }
}
