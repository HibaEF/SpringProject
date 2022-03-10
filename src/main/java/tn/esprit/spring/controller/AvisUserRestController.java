package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.AvisUser;
import tn.esprit.spring.service.AvisUserServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Avis-user")
public class AvisUserRestController {
    @Autowired
    AvisUserServiceImp avisUserService;

    @GetMapping("/retrive-all-avis-user")
    public List<AvisUser> getAllAvisUsers(){
        return avisUserService.retriveAllAvisUsers();
    }

    @GetMapping("/retrive-avis-user/{avis-user-id}")
    public Optional<AvisUser> retriveAvisUser(@PathVariable("avis-user-id") Long id){
        return avisUserService.retriveAvisUser(id);
    }

    @PostMapping("/add-avis-user")
    public AvisUser addAvisUser(@RequestBody AvisUser Au){
        avisUserService.addAvisUser(Au);
        return Au;
    }

    @DeleteMapping("remove-avis-user/{avis-user-id}")
    public void deleteAvisUser(@PathVariable("avis-user-id") Long id){
        avisUserService.deleteAvisUser(id);
    }

    @PutMapping("modify-user")
    public AvisUser modifyAvisUser(@RequestBody AvisUser Au){
       avisUserService.updateAvisUser(Au);
        return Au;
    }
}
