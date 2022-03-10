package tn.esprit.spring.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Livreur;


@Repository
public interface LivreurRepository extends CrudRepository<Livreur, Long>{



    @Query("SELECT l FROM Livreur l WHERE l.NomLiv like %?1 or l.PrenomLiv like %?1")

	List<Livreur> findByName(String key);
	
	@Query("SELECT l FROM Livreur l WHERE l.VilleLiv like %?1")
	List<Livreur> findByCity(String key);
	
	@Query("SELECT l FROM Livreur l ORDER BY NomLiv ASC")
	List<Livreur> SortUp();
	
	@Query("SELECT l FROM Livreur l Order BY NomLiv DESC")
	List<Livreur> SortDown();
	
	@Query("SELECT l FROM Livreur l WHERE l.status= false")
	List<Livreur> ShowHired();
	
	@Query("SELECT l FROM Livreur l WHERE l.adresseLiv like %?1")
	Livreur getByEmail(String email);
	
	@Query("SELECT l FROM Livreur l WHERE l.adresseLiv like %?1 and l.MdpLiv like %?2")
	Livreur connect(String email, String mdp);
	//
}
