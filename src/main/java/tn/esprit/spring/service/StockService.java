package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Stock;

public interface StockService {
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);
	Stock updateStock(Stock u);

	Optional<Stock> retrieveStock(Long id);
 
	List<Stock> findByDate(Date date);

	void status();
	void deleteStock(Long id);
}
