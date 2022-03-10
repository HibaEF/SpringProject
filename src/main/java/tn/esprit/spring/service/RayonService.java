package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Rayon;

public interface RayonService {
	List<Rayon> retrieveAllRayons();

	Rayon addRayon(Rayon r);

	Rayon updateRayon(Rayon u);

	Optional<Rayon> retrieveRayon(Long id);
}
