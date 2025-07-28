package com.example.caching.weather.repository;

import com.example.caching.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepo extends JpaRepository<Weather, String>{
    void deleteById(String city);
}
