package tn.esprit.spring.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.repository.StockRepository;

import tn.esprit.spring.entity.Stock;


@Slf4j
@Service
public class StockServiceImpl implements StockService{

	
	@Autowired
	private StockRepository ESR;
	@Override
	public List<Stock> retrieveAllStocks() {
		// TODO Auto-generated method stub
		return (List<Stock>)ESR.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub
		ESR.save(s);
		return s;
	}

	@Override
	public Stock updateStock(Stock u) {
		// TODO Auto-generated method stub
		ESR.save(u);
		return u;
	}

	@Override
	public Optional<Stock> retrieveStock(Long id) {
		// TODO Auto-generated method stub
		return ESR.findById(id);
	}
	@Override
	public List<Stock> findByDate(Date date) {
		// TODO Auto-generated method stub
		return (List<Stock>)ESR.findByDate(date);
	}

	 @Scheduled(cron = "0/15 * * * * *")
		@Override
		public void status() {
			// TODO Auto-generated method stub
			
	        List<Stock> stocks= (List<Stock>)ESR.findAll();
	        if(stocks!=null) {
	        for (Stock stock : stocks){
	        	
	            if (stock.getQte()<=stock.getQteMin()){
	            	log.info("le produit "+ stock.getLibelleStock()+" est epuisé ");
	          
	            }
	         
	        }
	    

		}
	        }

	@Override
	public void deleteStock(Long id) {
		// TODO Auto-generated method stub
		ESR.deleteById(id);
	}
	/*@Override
	public List<Produit> statStock(Long idS) {
	
		List<Produit> listProduit =this.ESR.findPByS(idS);
		return (List<Produit>) listProduit;
	}*/
	
	
}
