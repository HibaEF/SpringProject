package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.*;
@Repository
public interface FournisseurRepository  extends  CrudRepository<Fournisseur, Long> {

	@Query("SELECT f FROM Fournisseur f WHERE f.libelle like %?1 ")
	List<Fournisseur> findByLibelle(String libelle);
	
	@Query("SELECT f FROM Fournisseur f WHERE f.code like %?1")
	List<Fournisseur> findByCode(String code);
	@Query("SELECT f FROM Fournisseur f WHERE f.adresse like %?1")
	List<Fournisseur> findByAdresse(String adresse);
	
	@Query("SELECT f FROM Fournisseur f ORDER BY f.libelle ASC")
	List<Fournisseur> SortUp();
	
	@Query("SELECT f FROM Fournisseur f Order BY f.libelle DESC")
	List<Fournisseur> SortDown();
}