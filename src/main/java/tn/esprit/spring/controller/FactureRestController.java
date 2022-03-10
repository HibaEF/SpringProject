package tn.esprit.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.service.FactureServiceImp;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Facture")
public class FactureRestController {
	
	@Autowired
	FactureServiceImp fs;
	@Autowired
	FactureRepository fR;
	@PostMapping("/add-facture/{user_id}")
	@ResponseBody
	public Facture add_facture(@RequestBody Facture f, @PathVariable Long user_id) {
		return this.fs.addFacture(f, user_id);
	}

	@GetMapping("/retreive-all-factures")
	@ResponseBody
	public List<Facture> retreive_all_factures() {
		return this.fs.getAllFacture();
	}
	
	@GetMapping("/update-prixTotal-montantRemise-facture/{id_f}")
	@ResponseBody
	public Facture setFacturePrixTotal_MontantRemise(@PathVariable Long id_f ) {
		 try {
				this.fR.findById(id_f).get().setMontantFacture(this.fs.getPrixTotalFacture(id_f));
				this.fR.findById(id_f).get().setMontantRemise(this.fs.getMontantRemiseFacture(id_f));
				
				 return this.fR.save(this.fR.findById(id_f).get());
			} 
		 catch (Exception e) {System.err.println("aaaa");}
		 return null;
	}
	@GetMapping("/update-facture/{idf}/{status}")
	@ResponseBody
	public Facture update_facture(@PathVariable Long idf,@PathVariable boolean status  ) {
		return this.fs.updateFactureStatus( idf, status);
	}
	@DeleteMapping("/delete-facture/{idf}")
	@ResponseBody
	public void deleteFacture(@PathVariable Long idf) {
		this.fs.deleteFacture(idf);
	}
	@GetMapping("/detail-facture/{idf}")
	@ResponseBody
	public Facture detailFacture(@PathVariable Long idf) {
		return this.fs.detailFacture(idf);
	}
	
	@GetMapping("/stats-chiffre-affaire")
	@ResponseBody
	public List<Long> statsChiffreAffaire() {
		return this.fs.statsChiffreAffaire();
	}
	
	@GetMapping("/stats-nombre-achats")
	@ResponseBody
	public List<Integer> test() {
		return this.fs.achatsStats();
	}
	@GetMapping("/get-deux-ca-successives")
	@ResponseBody
	public List<Long> getDeuxCASuccessives() {
		return this.fs.getDeuxChiffreAffaireMois();
	}
	@GetMapping("/getFactureById/{idF}")
	@ResponseBody
	public Facture getFactureById(@PathVariable Long idF) {
		return this.fR.findById(idF).get();
	}
	
	@PutMapping("/update-facture-detail")
	@ResponseBody
	public Facture updateFactureDetail(@RequestBody Facture f) {
		System.out.println(f);
		return this.fR.save(f);
	}
	
	
}
