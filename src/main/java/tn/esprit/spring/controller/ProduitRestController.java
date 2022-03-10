package tn.esprit.spring.controller;

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

import java.util.List;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;

//import javax.validation.Valid;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.service.ProduitServiceImpl;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	ProduitServiceImpl p;
	@Autowired 
	ProduitRepository pr;
	
	public  ProduitRestController(ProduitServiceImpl p){
		this.p=p;
	}


	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	
		//@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/retrieve-all-produits")
		@ResponseBody
		@ApiOperation(value = "Récupérer la liste des produits")
		
		public List<Produit> getProduits() {
			List<Produit> listProduits = p.retrieveAllProduits();
			return listProduits;

		}

		
		
		
		
		
		//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addProduit")
	@ApiOperation(value = "Ajouter un nouveau produit")
	public Produit addProduit(@RequestBody Produit pp){
			Produit produit=p.addProduit(pp);
		return produit;
	}
		
		
	
		
		

	@PutMapping("/modifier_produit")
	@ResponseBody
	@ApiOperation(value = "Modifier un produit")

	public Produit updateProduitC(@RequestBody Produit pp) {
		return p.updateProduit(pp);
	}
	



	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	@ApiOperation(value = "Supprimer un produit")
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		p.deleteProduit(produitId);
	}
	
	
	
	

//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getProduit/{produit-id}")
	@ResponseBody
	@ApiOperation(value = "Afficher produit by id")

	public Produit getProduit(@PathVariable("produit-id") Long produitId) {
		return this.pr.findById(produitId).get();
	}
	
	
	@GetMapping("modifierLike/{idProduit}/{like}")
	@ResponseBody
	@ApiOperation(value = "liked")
	public Produit Liked(@PathVariable ("idProduit") Long idProduit, boolean like) {
		
		return p.modifierLike(idProduit, like);
	}
	
	
	
}