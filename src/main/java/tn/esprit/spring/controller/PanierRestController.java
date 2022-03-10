/*package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;
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

import tn.esprit.spring.entity.Panier;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.PanierServiceImp;

@RestController
@RequestMapping("/panier")

public class PanierRestController {
	@Autowired  
	PanierServiceImp panierServImp;
	
	// http://localhost:8090/SpringMVC/panier/retrieve-all-paniers

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/retrieve-all-paniers")
	@ResponseBody
	List<Panier> getAllPaniers(){
		return this.panierServImp.getAllPanier();
	}
	
	// http://localhost:8090/SpringMVC/servelet/panier/retrieve-panier/{panierId}
	@GetMapping("/retrieve-panier/{panierId}")  
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	private Optional<Panier> getPanier(@PathVariable("panierId") Long panierId)   
	{  
		return this.panierServImp.retrievePanier(panierId);  
	}
	
	// http://localhost:8090/SpringMVC/servelet/panier/remove-panier/{panierId}
	@DeleteMapping("/remove-panier/{panierId}")  
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	private void deletePanier(@PathVariable("panierId") Long panierId)   
	{  
		this.panierServImp.deletePanier(panierId);  
	}
	
	// http://localhost:8090/SpringMVC/servelet/panier/modify-panier	
	@PutMapping("/modify-panier")
	@ResponseBody
	public Panier modifyPanier(@RequestBody Panier p) {
		return this.panierServImp.updatePanier(p);
	}
	
	// http://localhost:8090/SpringMVC/servelet/panier/add-panier	
		/*@PostMapping("/add-panier")
		@ResponseBody
		public Panier addPanier(@RequestBody User p) {//changement du panier p vers user p
			return this.panierServImp.addPanier(p);
		}*/
		/*@GetMapping("panier-by-user/{user_id}")
		@ResponseBody
		public Panier getPanierBuUserId(@PathVariable("user_id") Long user_id) {
			return this.panierServImp.getPanierByUser(user_id);
		}*/
		

	/*
}*/
