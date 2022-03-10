/*package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Panier;
@Repository
public interface PanierRepository extends CrudRepository<Panier, Long> {
	@Query(value="SELECT * FROM `panier` WHERE panier.u_id_user = :id_user",nativeQuery = true)
	Panier getPanierByIdRep(Long id_user);
}
*/