package tn.esprit.spring.controller;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stock")
public class StockRestController {
	@Autowired
	StockServiceImpl StockService;
	// http://localhost:8089/SpringMVC/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ResponseBody
	@ApiOperation(value = "Récupérer la liste des stocks")
	public List<Stock> getStocks() {
		List<Stock> listStocks = StockService.retrieveAllStocks();
		return listStocks;

	}
	// http://localhost:8089/SpringMVC/stock/retrieve-stock/8
		@GetMapping("/retrieve-stock/{stock-id}")
		@ResponseBody
		@ApiOperation(value = "Récupérer les données de stock")
		public Optional<Stock> retrieveStock(@PathVariable("stock-id") Long stockId) {
		return StockService.retrieveStock(stockId);
		}

		// http://localhost:8089/SpringMVC/stock/add-stock
		@PostMapping("/add-stock")
		@ResponseBody
		@ApiOperation(value = "Ajouter stock")
		public Stock addStock(@RequestBody Stock c)
		{
			Stock stock = StockService.addStock(c);
		return stock;
		}
		// http://localhost:8090/SpringMVC/stock/modify-stock
		@PutMapping("/modify-stock")
		@ResponseBody
		@ApiOperation(value = "Modifier stock")
		public Stock modifyStock(@RequestBody Stock stock) {
		return StockService.updateStock(stock);
		}
		// http://localhost:8090/SpringMVC/stock/retrouver-stock-parDate/08-22-1997
				@GetMapping("/retrouver-stock-parDate/{stock-date}")
				@ResponseBody
				@ApiOperation(value = "Récupérer les  stocks par date")
				public List<Stock> findByDate(@PathVariable("stock-date") Date stockdate) {
				return StockService.findByDate(stockdate);
				}
				// http://localhost:8089/SpringMVC/stock/remove-stock/{stock-id}
				@DeleteMapping("/remove-stock/{stock-id}")
				@ResponseBody
				@ApiOperation(value = "Supprimer stock")
				public void removeStock(@PathVariable("stock-id") Long stockId) {
					StockService.deleteStock(stockId);
				}
				/*
				// http://localhost:8090/SpringMVC/stock/stat-stocks/2
				@GetMapping("/stat-stocks/{stockId}")
				@ResponseBody
				@ApiOperation(value = "Récupérer les produit de stock ")
				public List<Produit> getProduits(@PathVariable("stockId") Long stockId) {
					return this.StockService.statStock(stockId);				
						
				}*/
				
				
}

