package com.Atyeti.Stockscrenner.service;

import com.Atyeti.Stockscrenner.apiResponse.StockApiResponse;
import com.Atyeti.Stockscrenner.repository.StockRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {
    @Value("${alphavantage.api.key}")
    private String apiKey;
    ObjectMapper mapper = new ObjectMapper();
    private final RestTemplate restTemplate;

    public StockService( RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public StockApiResponse getStock(String symbol) {
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + apiKey;
        System.out.println("Constructed URL "+ url);
        ResponseEntity<StockApiResponse> response = restTemplate.exchange(url,HttpMethod.GET,null, StockApiResponse.class);
        return response.getBody();
    }




}
