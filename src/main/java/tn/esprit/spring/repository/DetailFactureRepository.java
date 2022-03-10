package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.DetailFacture;
@Repository
public interface DetailFactureRepository extends CrudRepository<DetailFacture,Long> {
	
}
