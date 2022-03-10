package tn.esprit.spring.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.service.RayonServiceImpl;

@RestController
@RequestMapping("/rayon")
public class RayonRestController {
	@Autowired
	RayonServiceImpl RayonService;
	// http://localhost:8089/SpringMVC/rayon/retrieve-all-rayons
	@GetMapping("/retrieve-all-rayons")
	@ResponseBody
	@ApiOperation(value = "Récupérer la liste des rayons")
	public List<Rayon> getRayons() {
		List<Rayon> listRayons = RayonService.retrieveAllRayons();
		return listRayons;

	}
	// http://localhost:8089/SpringMVC/rayon/retrieve-rayon/8
		@GetMapping("/retrieve-rayon/{rayon-id}")
		@ResponseBody
		@ApiOperation(value = "Récupérer les données de rayon")
		public Optional<Rayon> retrieveRayon(@PathVariable("rayon-id") Long rayonId) {
		return RayonService.retrieveRayon(rayonId);
		}

		// http://localhost:8089/SpringMVC/rayon/add-rayon
		@PostMapping("/add-rayon")
		@ResponseBody
		@ApiOperation(value = "Ajouter rayon")
		public Rayon addRayon(@RequestBody Rayon c)
		{
			Rayon rayon = RayonService.addRayon(c);
		return rayon;
		}
		// http://localhost:8089/SpringMVC/rayon/modify-rayon
		@PutMapping("/modify-rayon")
		@ResponseBody
		@ApiOperation(value = "Modifier rayon")
		public Rayon modifyRayon(@RequestBody Rayon rayon) {
		return RayonService.updateRayon(rayon);
		}
}
