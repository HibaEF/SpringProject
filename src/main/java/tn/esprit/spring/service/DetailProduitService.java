package tn.esprit.spring.service;

import tn.esprit.spring.entity.DetailProduit;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

public interface DetailProduitService {
	
	List<DetailProduit> retrieveAllDetailProduits();

	DetailProduit addDetailProduit(DetailProduit c);

	void deleteDetailProduit(Long id);
	DetailProduit updateDetailProduit(DetailProduit c);
	Optional<DetailProduit> retrieveDetailProduit(Long id);

	
	
}