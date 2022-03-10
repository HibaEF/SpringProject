package tn.esprit.spring.service;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.repository.FournisseurRepository;

@Service
public class FournisseurServiceImpl implements FournisseurService{

	
	@Autowired
	private  FournisseurRepository Fr;
	
	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		// TODO Auto-generated method stub
		return (List<Fournisseur>)Fr.findAll();
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
	Fr.save(f);
	return f;
	}

	@Override
	public void deleteFournisseur(Long id) {
		// TODO Auto-generated method stub
		Fr.deleteById(id);
		
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
		Fr.save(f);
		return f;
	}
	@Override
	public Optional<Fournisseur> retrieveFournisseur(Long id) {
		// TODO Auto-generated method stub
		return Fr.findById(id);
	}

	@Override
	public List<Fournisseur> findByLibelle(String Libelle) {
		// TODO Auto-generated method stub
		return (List<Fournisseur>)Fr.findByLibelle(Libelle);
	}

	@Override
	public List<Fournisseur> findByCode(String Code) {
		// TODO Auto-generated method stub
		return (List<Fournisseur>)Fr.findByCode(Code);
	}

	@Override
	public List<Fournisseur> findByAdresse(String Adresse) {
		// TODO Auto-generated method stub
		return (List<Fournisseur>)Fr.findByAdresse(Adresse);
	}

	@Override
	public List<Fournisseur> sortUp() {
		// TODO Auto-generated method stub
		return (List<Fournisseur>)Fr.SortUp();
	}

	@Override
	public List<Fournisseur> sortDown() {
		// TODO Auto-generated method stub
		return (List<Fournisseur>)Fr.SortDown();
	}
	

}
