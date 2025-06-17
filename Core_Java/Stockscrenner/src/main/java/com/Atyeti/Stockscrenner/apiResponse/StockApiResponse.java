package com.Atyeti.Stockscrenner.apiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class StockApiResponse {

        @JsonProperty("Meta Data")
        private MetaData metaData;

        @JsonProperty("Time Series (Daily)")
        private Map<String, StockDailyData> timeSeriesDaily;

        // Getters and setters
        public MetaData getMetaData() {
            return metaData;
        }

        public void setMetaData(MetaData metaData) {
            this.metaData = metaData;
        }

        public Map<String, StockDailyData> getTimeSeriesDaily() {
            return timeSeriesDaily;
        }

        public void setTimeSeriesDaily(Map<String, StockDailyData> timeSeriesDaily) {
            this.timeSeriesDaily = timeSeriesDaily;
        }


}
