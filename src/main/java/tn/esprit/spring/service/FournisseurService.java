package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.spring.entity.Fournisseur;

public interface FournisseurService {
	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur f);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur f);
	Optional<Fournisseur> retrieveFournisseur(Long id);
List<Fournisseur> findByLibelle(String Libelle);
	
	List<Fournisseur> findByCode(String Code);
	
	List<Fournisseur> findByAdresse(String Adresse);
	
	List<Fournisseur> sortUp();
	
	List<Fournisseur> sortDown();
}
