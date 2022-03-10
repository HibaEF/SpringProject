package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture,Long> {
	
	@Query(value="SELECT SUM(prix_total) FROM detailfacture WHERE detailfacture.f_id_facture =:idF",nativeQuery=true)
	 Long getPrixTotalF(Long idF);
	
	@Query(value="SELECT SUM(montant_remise) FROM detailfacture WHERE detailfacture.f_id_facture =:idF",nativeQuery=true)
	 Long getMontantRemiseF(Long idF);
	
	/*select date_format(date_facture, '%M'),sum(montant_facture)
       from facture WHERE date_format(date_facture, '%yy')= date_format(NOW(),'%yy')
       group by date_format(date_facture, '%mm') ORDER BY date_format(date_facture, '%mm') ;*/
	
	@Query(value="select sum(montant_facture) from facture WHERE date_format(date_facture, '%yy')= date_format(NOW(),'%yy') group by date_format(date_facture, '%mm') ORDER BY date_format(date_facture, '%mm')",nativeQuery=true)
	List<Long> statsChiffreAffaire();
	
	@Query(value="select id_facture from facture WHERE date_format(date_facture, '%yy')= date_format(NOW(),'%yy') && date_format(date_facture, '%mm')= :m ",nativeQuery=true)
	List<Long> idParMois(int m);
	
	@Query(value=" select sum(qte) FROM detailfacture where detailfacture.f_id_facture =:idF ",nativeQuery=true)
	Long qteParFacture(Long idF);
		
	@Query(value=" select sum(montant_facture) FROM facture where date_format(date_facture, '%yy')= date_format(NOW(),'%yy') && (date_format(date_facture, '%mm')=date_format(NOW(),'%mm')|| date_format(date_facture, '%mm')=(date_format(NOW(),'%mm')-1) ) group by  date_format(date_facture, '%mm') ORDER BY date_format(date_facture, '%mm')  ",nativeQuery=true)
	List<Long>  getDeuxChiffreAffaire();
	
}
