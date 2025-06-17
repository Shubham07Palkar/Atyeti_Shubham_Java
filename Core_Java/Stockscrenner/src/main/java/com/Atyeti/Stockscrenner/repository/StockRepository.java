package com.Atyeti.Stockscrenner.repository;

import com.Atyeti.Stockscrenner.entity.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {

}
