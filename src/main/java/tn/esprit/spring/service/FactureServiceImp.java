package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.UserRepository;  
@Service
public class FactureServiceImp implements FactureService{

	@Autowired  
	FactureRepository fR;
	@Autowired
	UserRepository uR;
	
	@Override
	public List<Facture> getAllFacture() {
		List<Facture> Factures = new ArrayList<Facture>();  
		this.fR.findAll().forEach(fr1 -> Factures.add(fr1));  
		return Factures;
	}

	@Override
	public Facture addFacture(Facture f,Long user_id) {
		User u= uR.findById(user_id).get();
		f.setDateFacture(new Date());
		f.setUser(u);
		f.setActive(true);
		return this.fR.save(f);
	}

	@Override
	public Facture updateFactureStatus(Long idf,boolean status) {
		this.fR.findById(idf).get().setActive(status);
		return this.fR.save(this.fR.findById(idf).get());
	}

	@Override
	public Optional<Facture> retrieveFacture(Long id) {
		return Optional.ofNullable(this.fR.findById(id).get());
	}
	@Override
	public Long getPrixTotalFacture(Long idFacture) {
		return this.fR.getPrixTotalF(idFacture);
	}
	@Override
	public Long getMontantRemiseFacture(Long idFacture) {
		return this.fR.getMontantRemiseF(idFacture);
	}
	@Override
	public void deleteFacture(Long id) {
		this.fR.deleteById(id);
	};
	
	@Override 
	public Facture detailFacture(Long id) {
		return this.fR.findById(id).get();
	}
	@Override
	public List<Long> statsChiffreAffaire() {
		return this.fR.statsChiffreAffaire();
	}
	@Override
	public List<Integer> achatsStats(){
		int valeurFinale[]= {0,0,0,0,0,0,0,0,0,0,0,0}; 
			for(int j=1;j<=12;j++) {
				if(this.fR.idParMois(j)!=null) {
					System.out.println("aaaa");
				List<Long> tabId= this.fR.idParMois(j);
				
					int somme=0;
					for(int i=0;i<tabId.size();i++) {
						if(this.fR.qteParFacture(tabId.get(i))!=null)
							somme+=this.fR.qteParFacture(tabId.get(i));
					}
				System.out.println("somme: "+somme);
			valeurFinale[j-1]=somme;
			}
		}
			List<Integer> vF=new ArrayList<>();
			for(int i= 0;i<12;i++) {
				System.out.println("t: "+valeurFinale[i]);
				vF.add(valeurFinale[i]);
			}
		return vF;

	}
	@Override
	public List<Long> getDeuxChiffreAffaireMois(){
		return this.fR.getDeuxChiffreAffaire();
	}
}
