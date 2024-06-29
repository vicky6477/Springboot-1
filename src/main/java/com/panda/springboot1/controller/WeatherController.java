package com.panda.springboot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather/{cityId}")
public class WeatherController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getWeather(@PathVariable String cityId) {
        String url = "http://t.weather.sojson.com/api/weather/city/" + cityId;
        return restTemplate.getForObject(url, String.class);
    }
}
