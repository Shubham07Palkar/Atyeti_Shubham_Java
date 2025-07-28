package com.example.caching.weather.controller;

import com.example.caching.weather.entity.Weather;
import com.example.caching.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class weatherController {
    @Autowired
    public WeatherService weatherService;

    @PostMapping
    public Weather addWeather(@RequestBody Weather weather){
        return weatherService.addWeather(weather);
    }

    @GetMapping("/{city}")
    public Weather getWeather(@PathVariable String city){
        return weatherService.getWeather(city);
    }

    @PutMapping
    public Weather updateWeather(@RequestBody Weather weather){
        return weatherService.updateWeather(weather.getCity(), weather);
    }

    @DeleteMapping("/{city}")
    public String deleteCity(@PathVariable String city){
        weatherService.deleteCity(city);
        return "Deleted city";
    }
}
