/*package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.PanierRepository;
@Service
public class PanierServiceImp implements PanierService {

	@Autowired
	PanierRepository pr;
	
	@Override
	public List<Panier> getAllPanier() {
		List<Panier> Paniers=new ArrayList<Panier>();
		this.pr.findAll().forEach(p1->Paniers.add(p1));
		return Paniers;
	}	

	@Override
	public Panier addPanier(User u) {
		Panier p=new Panier();
		p.setU(u);
		this.pr.save(p);
		return p;
	}

	@Override
	public Panier updatePanier(Panier p) {
		this.pr.save(p)                                    ;
		return p;
	}

	@Override
	public Optional<Panier> retrievePanier(Long id) {
		return Optional.ofNullable(this.pr.findById(id).get());

	}
	@Override
	public void deletePanier(Long id) {
		this.pr.deleteById(id);
	}
	@Override
	public Panier getPanierByUser(Long user_id) {
		return this.pr.getPanierByIdRep(user_id);
	}
	
	

}*/
