package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.repository.LivreurRepository;
@Slf4j

@Service
public class LivreurServiceImpl implements LivreurService {
	
	  @Value("${accountSID}")
	    private String accountSID;
	 
	  @Value("${accountAuthToken}")
	    private String accountAuthToken;
	 
	  @Value("${twilloSenderNumber}")
	    private String twilloSenderNumber;
	private final LivreurRepository lr;
	
	@Autowired
	public LivreurServiceImpl(LivreurRepository lr) {
		this.lr=lr;
	}
	@Override
	public List<Livreur> retrieveAllLivreurs() {
		return (List<Livreur>)lr.findAll();
	}

	@Override
	public Livreur addLivreur(Livreur L) {
		lr.save(L);
		return L;
	}

	@Override
	public void deleteLivreur(Long id) {
		lr.deleteById(id);		
	}

	@Override
	public Livreur updateLivreur(Livreur L) {
		Livreur lnew= new Livreur();
		lnew= L;
		lnew.setNomLiv(L.getNomLiv());
		lnew.setPrenomLiv(L.getPrenomLiv());
		lnew.setAdresseLiv(L.getAdresseLiv());
		lnew.setVilleLiv(L.getVilleLiv());
		lnew.setMdpLiv(L.getMdpLiv());
		lr.save(lnew);
		return L;
	}

	@Override
	public Livreur retrieveLivreur(Long id) {
		Livreur lvr = lr.findById(id).get();
		return lvr;		 
	}
	
	public String NotifyLivreurBySMS(Livreur l) {
	    
		    Twilio.init(accountSID,accountAuthToken); 
	        Message message = Message.creator( 
	                new com.twilio.type.PhoneNumber("+21696334402"),  
	                "MG5d6c5464c4bb4e513ef13ac860e5a749", 
	                "Notif " +l +"a ete traiter  ")      
	            .create();     
	        
	        log.info("Message Send Succesfully to the number " + "+21696334402");
	   
		
		 
		return "Message Send Succesfully" ;
	}

	@Override
	public List<Livreur> sortUp() {
		return (List<Livreur>)lr.SortUp();
	}
	
	@Override
	public List<Livreur> findByName(String key) {
		return (List<Livreur>)lr.findByName(key);
	}
	
	public List<Livreur> ShowHired() {
		return (List<Livreur>)lr.ShowHired();
	}

	@Override
	public List<Livreur> sortDown() {
		return (List<Livreur>)lr.SortDown();
	}


	@Override
	public List<Livreur> findByCity(String key)
	{
		return (List<Livreur>)lr.findByCity(key);

	}
	@Override
	public Livreur AcceptLivreur(Livreur L) {
		
		L.setStatus(true);
		lr.save(L);
		return L;
	}
	@Override
	public Livreur getByEmail(String email) {
		Livreur lvr= lr.getByEmail(email);
		return lvr;
	}
	@Override
	public Livreur connect(String email, String mdp) {
		Livreur lvr= lr.connect(email, mdp);
		return lvr;
	}
}
