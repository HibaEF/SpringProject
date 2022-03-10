package tn.esprit.spring.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Stock;


@Repository
public interface StockRepository extends  CrudRepository<Stock, Long> {
	@Query("SELECT s FROM Stock s WHERE s.date like %?1 ")
	List<Stock> findByDate(Date date);
	
	/*@Query(value="SELECT * FROM produit where produit.s_id_stock =:stockId " , nativeQuery=true)
	List<Produit> findPByS(Long stockId);*/
	
	
}
