package com.Atyeti.Stockscrenner.controller;

import com.Atyeti.Stockscrenner.apiResponse.StockApiResponse;
import com.Atyeti.Stockscrenner.apiResponse.StockDailyData;
import com.Atyeti.Stockscrenner.entity.StockAnalysis;
import com.Atyeti.Stockscrenner.service.StockAnalysisService;
import com.Atyeti.Stockscrenner.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/stocks")
public class StockController {
    private final StockService stockService;
    StockAnalysisService stockAnalysisService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<?> fetchAndSaveStock(@PathVariable String symbol) {
        try {
            StockApiResponse stockData = stockService.getStock(symbol.toUpperCase());
            if (stockData == null) {
                return new ResponseEntity<>("No response received", HttpStatus.SERVICE_UNAVAILABLE);
            }
            Map<String, StockDailyData> timeSeriesDaily = stockData.getTimeSeriesDaily();
            if (timeSeriesDaily == null || timeSeriesDaily.isEmpty()) {
                return new ResponseEntity<>("No daily data Found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(timeSeriesDaily, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/analyze/{symbol}")
    public ResponseEntity<StockAnalysis> analyzeStock(@PathVariable String symbol) {
        StockApiResponse response = stockService.getStock(symbol);
        StockAnalysis stockAnalysis = StockAnalysisService.calculateIndicators(response);
        return ResponseEntity.ok(stockAnalysis);
    }
}
