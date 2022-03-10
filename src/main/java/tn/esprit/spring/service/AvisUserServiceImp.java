package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.AvisUser;
import tn.esprit.spring.repository.AvisUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AvisUserServiceImp implements AvisUserService{

    private final AvisUserRepository avisUserRepository;

    @Autowired
    public AvisUserServiceImp(AvisUserRepository avisUserRepository){this.avisUserRepository=avisUserRepository;}

    @Override
    public List<AvisUser> retriveAllAvisUsers() {
        return (List<AvisUser>)avisUserRepository.findAll();
    }

    @Override
    public AvisUser addAvisUser(AvisUser Av) {
        avisUserRepository.save(Av);
        return Av;
    }

    @Override
    public void deleteAvisUser(Long id) {
        avisUserRepository.deleteById(id);
    }

    @Override
    public AvisUser updateAvisUser(AvisUser Av) {
        avisUserRepository.save(Av);
        return Av;
    }

    @Override
    public Optional<AvisUser> retriveAvisUser(Long id) {
        return avisUserRepository.findById(id);
    }

}
