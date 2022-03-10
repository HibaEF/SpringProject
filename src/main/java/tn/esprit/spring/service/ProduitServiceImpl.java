package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;

import tn.esprit.spring.repository.ProduitRepository;


@Service
public class ProduitServiceImpl implements ProduitService{
	
	
	
	 @Autowired
	    ProduitRepository produitRepository;
	    
		@Override
	    public List<Produit> addProduits(Produit produit) {
	        produitRepository.save(produit);
			return produitRepository.findAll();


	    }

	    
		@Override
	    public Produit getProduitById(long id) {
	        return  produitRepository.findById(id).get();
	    }
		@Override
		public List<Produit> retrieveAllProduits(){
			return (List<Produit>)produitRepository.findAll();
		}






	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(long idProduit) {
		produitRepository.deleteById(idProduit);
	}
	
	@Override
	public Produit addProduit(Produit produit) {
		// TODO Auto-generated method stub
	produitRepository.save(produit);
	return produit;
	}


	@Override
	public Produit modifierLike(long idProduit, boolean like) {
		// TODO Auto-generated method stub
		Produit p=this.produitRepository.findById(idProduit).get();
		if (like)
			p.setNbrLike(p.getNbrLike()+1);
		else
			p.setNbrLike(p.getNbrLike()-1);
		return this.produitRepository.save(p);		
	}
	
	
	
}
