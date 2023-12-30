package com.tagirmurzagaleev.spring_course.sensor;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class SensorAPI {
    public static void main(String[] args) {
        try {
            registrationSensor();
            getWeatherData();
            getRainyDaysCount();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sendWeatherData();
        }
    }


    public static void registrationSensor() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "FirstWeatherSensor");
        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);
        String urlRegistration = "http://localhost:8080/sensors/registration";
        String response = restTemplate.postForObject(urlRegistration, request, String.class);
        System.out.println(response);
    }

    public static void sendWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 10; i++) {
            Map<String, String> jsonToSendSensor = new HashMap<>();
            jsonToSendSensor.put("name", "FirstWeatherSensor");
            Map<String, Object> jsonToSend = new HashMap<>();
            jsonToSend.put("value", new Random().nextDouble(-40, 50));
            jsonToSend.put("raining", ((Boolean) new Random().nextBoolean()).toString());
            jsonToSend.put("sensor", jsonToSendSensor);
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);
            String urlRegistration = "http://localhost:8080/measurements/add";
            String response = restTemplate.postForObject(urlRegistration, request, String.class);
            System.out.println(response);
        }
    }

    public static void getWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> jsonToGet = new HashMap<>();
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToGet);
        String urlRegistration = "http://localhost:8080/measurements/";
        ArrayList getAllData = restTemplate.getForObject(urlRegistration, ArrayList.class, request);
        assert getAllData != null;
        for (Object data :
                getAllData) {
            System.out.println(data);
        }
    }

    public static void getRainyDaysCount() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> jsonToGet = new HashMap<>();
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToGet);
        String urlRegistration = "http://localhost:8080/measurements/rainyDaysCount";
        String getData = restTemplate.getForObject(urlRegistration, String.class, request);
        System.out.println(getData);
    }
}
