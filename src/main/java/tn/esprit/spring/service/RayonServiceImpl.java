package tn.esprit.spring.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.entity.Rayon;

@Service
public class RayonServiceImpl implements RayonService {


	@Autowired
	private RayonRepository RR;
	@Override
	public List<Rayon> retrieveAllRayons() {
		// TODO Auto-generated method stub
		return (List<Rayon>)RR.findAll();
	}

	@Override
	public Rayon addRayon(Rayon r) {
		// TODO Auto-generated method stub
		RR.save(r);
		return r;
	}

	@Override
	public Rayon updateRayon(Rayon u) {
		// TODO Auto-generated method stub
		RR.save(u);
		return u;
	}

	@Override
	public Optional<Rayon> retrieveRayon(Long id) {
		// TODO Auto-generated method stub
		return RR.findById(id);
	}

}
