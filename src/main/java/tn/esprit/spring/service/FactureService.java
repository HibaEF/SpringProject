package tn.esprit.spring.service;
import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;

import tn.esprit.spring.entity.Facture;

@Service

public interface FactureService {
	List<Facture> getAllFacture();
	Facture addFacture(Facture f,Long user_id);
	Facture updateFactureStatus(Long idf,boolean status);
	Optional<Facture> retrieveFacture(Long id);
	Long getPrixTotalFacture(Long idFacture);
	Long getMontantRemiseFacture(Long idFacture);
	void deleteFacture(Long id);
	Facture detailFacture(Long id);
	List<Long> statsChiffreAffaire();
	public List<Integer> achatsStats();
	public List<Long> getDeuxChiffreAffaireMois();

}
