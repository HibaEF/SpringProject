package tn.esprit.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Livraison;
import tn.esprit.spring.entity.Livreur;
import tn.esprit.spring.repository.LivraisonRepository;
import tn.esprit.spring.service.LivraisonServiceImpl;
import tn.esprit.spring.service.LivreurService;
import tn.esprit.spring.service.LivreurServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/livreur")
public class LivreurRestController {
	@Autowired
	LivreurServiceImpl livreurService;
	@Autowired
	LivraisonRepository lr;

	    // http://localhost:8090/SpringMVC/livreur/retrieve-all-livreurs
	    @GetMapping("/retrieve-all-livreurs")
	    @ResponseBody
	    public List<Livreur> getlivreurs() {
	    List<Livreur> listlivreurs = livreurService.retrieveAllLivreurs();
	    return listlivreurs;
	    }
	    
	    // http://localhost:8090/SpringMVC/livreur/show-hired
	    @GetMapping("/show-hired")
	    @ResponseBody
	    public List<Livreur> show() {
	    List<Livreur> listlivreurs = livreurService.ShowHired();
	    return listlivreurs;
	    }
	
	    // http://localhost:8090/SpringMVC/livreur/retrieve-livraisons/{livreur-id}
	    @GetMapping("/retrieve-livraisons/{livreur-id}")
	    @ResponseBody
	    public List<Livraison> getlivraisons(@PathVariable("livreur-id") Long LivreurId) {
	    List<Livraison> listlivreurs = lr.findByIdLivreur(LivreurId);
	    return listlivreurs;
	    }
	   

       // Ajouter Livreur : http://localhost:8090/SpringMVC/livreur/add-livreur
		   @CrossOrigin(origins = "*", allowedHeaders = "*")
		  @PostMapping("/add-livreur")
		  @ResponseBody
		  public Livreur addLivreur(@RequestBody Livreur u) {
		  Livreur Livreur = livreurService.addLivreur(u);
		  return Livreur;
		  }
		  
		  
	   // http://localhost:8090/SpringMVC/livreur/remove-livreur/{livreur-id}
		   @DeleteMapping("/remove-livreur/{livreur-id}")
		   @ResponseBody
		   public void removeLivreur(@PathVariable("livreur-id") Long LivreurId) {
		   livreurService.deleteLivreur(LivreurId);
		   }
		  
       // http://localhost:8090/SpringMVC/livreur/modify-Livreur
		   @CrossOrigin(origins = "*", allowedHeaders = "*")
		   @PutMapping("/modify-livreur")
		   @ResponseBody
		   public Livreur modifyLivreur(@RequestBody Livreur Livreur) {
		   return livreurService.updateLivreur(Livreur);
		   }
		   
		// http://localhost:8090/SpringMVC/livreur/accept-Livreur
		   @CrossOrigin(origins = "*", allowedHeaders = "*")
		   @PutMapping("/accept-Livreur")
		   @ResponseBody
		   public Livreur acceptLivreur(@RequestBody Livreur Livreur) {
		   return livreurService.AcceptLivreur(Livreur);
		   }
	  
		// http://localhost:8090/SpringMVC/livreur/retrieve-livreur/{livreur-id}
		   @GetMapping("/retrieve-livreur/{livreur-id}")
		   @ResponseBody
		   public Livreur retrievelivreur(@PathVariable("livreur-id") Long livreurId) {
		   return livreurService.retrieveLivreur(livreurId);
		   }
		   
		// http://localhost:8090/SpringMVC/livreur/getByEmail/{email}
		   @GetMapping("/getByEmail/{email}")
		   @ResponseBody
		   public Livreur getByEmail(@PathVariable("email") String email) {
		   return livreurService.getByEmail(email);
		   }
		   
		// http://localhost:8090/SpringMVC/livreur/connect/{email}/{mdp}
		   @GetMapping("/connect/{email}/{mdp}")
		   @ResponseBody
		   public Livreur getByEmail(@PathVariable("email") String email,@PathVariable("mdp") String mdp) {
		   return livreurService.connect(email, mdp);
		   }
		   
		    @GetMapping("/sendSMS") 
		    @ResponseBody
			@ApiOperation(value = "SMS notif ")
			public void sendSMSforLivreur(@RequestBody Livreur l) {
		    	livreurService.NotifyLivreurBySMS(l);
			}
	
}
