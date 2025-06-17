package com.Atyeti.Stockscrenner.entity;

import java.math.BigDecimal;

public class StockAnalysis {
    private String symbol;
    private BigDecimal movingAverage;
    private BigDecimal high50Day;
    private BigDecimal low50Day;

    public StockAnalysis(BigDecimal high50Day, BigDecimal low50Day, BigDecimal movingAverage) {
        this.high50Day = high50Day;
        this.low50Day = low50Day;
        this.movingAverage = movingAverage;
    }

    public BigDecimal getLow50Day() {
        return low50Day;
    }

    public void setLow50Day(BigDecimal low50Day) {
        this.low50Day = low50Day;
    }

    public BigDecimal getHigh50Day() {
        return high50Day;
    }

    public void setHigh50Day(BigDecimal high50Day) {
        this.high50Day = high50Day;
    }

    public BigDecimal getMovingAverage() {
        return movingAverage;
    }

    public void setMovingAverage(BigDecimal movingAverage) {
        this.movingAverage = movingAverage;
    }

    @Override
    public String toString() {
        return "StockAnalysis {" +
                "50DayHigh=" + high50Day +
                ", movingAverage=" + movingAverage +
                ", 50DayLow=" + low50Day +
                '}';
    }
}
