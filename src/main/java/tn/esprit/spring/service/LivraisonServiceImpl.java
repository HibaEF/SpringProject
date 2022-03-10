package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Livraison;
import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.repository.LivraisonRepository;
@Service

public class LivraisonServiceImpl implements LivraisonService {
	private final LivraisonRepository lvr;
	@Autowired
	public LivraisonServiceImpl(LivraisonRepository lvr) {
		this.lvr=lvr;
	}
	@Override
	public List<Livraison> retrieveAllLivraisons() {
		return (List<Livraison>)lvr.findAll();
	}

	@Override
	public Livraison addLivraison(Livraison L) {
		lvr.save(L);
		return L;
	}

	@Override
	public void deleteLivraison(Long id) {
		lvr.deleteById(id);		
	}

	@Override
	public Livraison updateLivraison(Livraison L) {
		lvr.save(L);
		return L;
	}

	@Override
	public Livraison retrieveLivraison(Long id) {
		Livraison lv = lvr.findById(id).get();
		return lv;	
	}
	@Override
	public List<Livraison> FindByIdLivreur(Long id) {
		return (List<Livraison>) lvr.findByIdLivreur(id);

	}
	@Override
	public List<Livraison> findByDate(Date d) {
		return (List<Livraison>) lvr.findByDate(d);
	}
	@Override
	public List<Livraison> orderByDate() {
		return (List<Livraison>)lvr.orderByDate();

	}
	@Override
	public Livraison deliverLivraison(Long id) {
		Livraison lv = lvr.findById(id).get();
		lv.setStatus(true);
		lvr.save(lv);
		return lv;
	}
	@Override
	public int CountDelivered() {
         int x= lvr.CountDelivered();
         return x;
	}
	@Override
	public int CountUndelivered() {
        int x= lvr.CountUndelivered();
		return x;
	}

}
