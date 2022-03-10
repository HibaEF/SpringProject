package tn.esprit.spring.service;

import tn.esprit.spring.entity.AvisUser;

import java.util.List;
import java.util.Optional;

public interface AvisUserService {
    List<AvisUser>retriveAllAvisUsers();
    AvisUser addAvisUser(AvisUser Av);
    void deleteAvisUser(Long id);
    AvisUser updateAvisUser(AvisUser Av);
    Optional<AvisUser>retriveAvisUser(Long id);
}
