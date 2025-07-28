package com.example.caching.weather.service;

import com.example.caching.weather.WeatherApplication;
import com.example.caching.weather.entity.Weather;
import com.example.caching.weather.repository.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    public WeatherRepo weatherRepo;

    public Weather addWeather(Weather weather){
        return weatherRepo.save(weather);
    }

    @Cacheable(value = "weathercache")
    public Weather getWeather(String city){
        return weatherRepo.findById(city).orElseThrow(()-> new RuntimeException("City Not Found"));
    }

    @CachePut
    public Weather updateWeather(String city, Weather weather){
        Weather existingCity=weatherRepo.findById(city).orElseThrow(()-> new RuntimeException("City Not Found"));
        existingCity.setTemperature(weather.getTemperature());

        return weatherRepo.save(existingCity);
    }

    @CacheEvict
    public void deleteCity(String city){
        Weather deleteCity = weatherRepo.findById(city).orElseThrow(()-> new RuntimeException("City not Found"));
        weatherRepo.deleteById(city);
    }
}
