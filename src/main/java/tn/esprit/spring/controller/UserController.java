package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.UserServiceImp;

import javax.ws.rs.POST;
import java.security.PublicKey;

@RestController
@RequestMapping("/user-1")
@CrossOrigin(origins = "*")
public class UserController {

    /*@Autowired
    UserServiceImp userServiceImp;*/

    @PostMapping(path = "test-add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public User test(@RequestBody User role){
        return role;
    }

    /*public Role test(@RequestBody Role role){
        return role;
    }*/

}
