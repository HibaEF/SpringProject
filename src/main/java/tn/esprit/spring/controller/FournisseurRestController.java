package tn.esprit.spring.controller;
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

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.service.FournisseurServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/fournisseur")
public class FournisseurRestController {
	@Autowired
	FournisseurServiceImpl fournisseurService;

	// http://localhost:8089/SpringMVC/fournisseur/retrieve-all-fournisseurs
	@GetMapping("/retrieve-all-fournisseurs")
	@ResponseBody
	@ApiOperation(value = "Récupérer la liste des fournisseurs")
	public List<Fournisseur> getFournisseurs() {
	List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseurs();
	return listFournisseurs;

}
	// http://localhost:8089/SpringMVC/fournisseur/retrieve-fournisseur/8
	@GetMapping("/retrieve-fournisseur/{fournisseur-id}")
	@ResponseBody
	@ApiOperation(value = "Récupérer les données de fournisseur")
	public Optional<Fournisseur> retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
	return fournisseurService.retrieveFournisseur(fournisseurId);
	}

	// http://localhost:8089/SpringMVC/fournisseur/add-fournisseur
	@PostMapping("/add-fournisseur")
	@ResponseBody
	@ApiOperation(value = "Ajouter fournisseurs")
	public Fournisseur addFournisseur(@RequestBody Fournisseur c)
	{
		Fournisseur fournisseur = fournisseurService.addFournisseur(c);
		return fournisseur;
	}
	// http://localhost:8089/SpringMVC/fournisseur/remove-fournisseur/{fournisseur-id}
	@DeleteMapping("/remove-fournisseur/{fournisseur-id}")
	@ResponseBody
	@ApiOperation(value = "Supprimer fournisseur")
	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		fournisseurService.deleteFournisseur(fournisseurId);
	}

	// http://localhost:8089/SpringMVC/fournisseur/modify-fournisseur
	@PutMapping("/modify-fournisseur")
	@ResponseBody
	@ApiOperation(value = "Modifier fournisseur")
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur fournisseur) {
	return fournisseurService.updateFournisseur(fournisseur);
	}
	// http://localhost:8089/SpringMVC/fournisseur/retrouver-fournisseur-parLibelle/"PC"
		@GetMapping("/retrouver-fournisseur-parLibelle/{fournisseur-libelle}")
		@ResponseBody
		@ApiOperation(value = "Récupérer le fournisseur par son libelle")
		public List<Fournisseur>  findByLibelle(@PathVariable("fournisseur-libelle") String fournisseurLibelle) {
		return fournisseurService.findByLibelle(fournisseurLibelle);
		}
		// http://localhost:8089/SpringMVC/fournisseur/retrouver-fournisseur-parCode/"f-456"
			@GetMapping("/retrouver-fournisseur-parCode/{fournisseur-code}")
			@ResponseBody
			@ApiOperation(value = "Récupérer le fournisseur par son code")
			public List<Fournisseur>  findByCode(@PathVariable("fournisseur-code") String fournisseurCode) {
			return fournisseurService.findByCode(fournisseurCode);
			}
			// http://localhost:8089/SpringMVC/fournisseur/retrouver-fournisseur-parAdresse/"PC"
					@GetMapping("/retrouver-fournisseur-parAdresse/{fournisseur-adresse}")
					@ResponseBody
					@ApiOperation(value = "Récupérer le fournisseur par son Adresse")
					public List<Fournisseur> findByAdresse(@PathVariable("fournisseur-adresse") String fournisseurAdresse) {
					return fournisseurService.findByAdresse(fournisseurAdresse);
					}
}