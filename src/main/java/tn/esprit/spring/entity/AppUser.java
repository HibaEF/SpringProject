package tn.esprit.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class AppUser implements Serializable {
    private Long idUser;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;
    private String password;
    private String picture;
    private Integer phoneNumber;
    private String adresse;
    private tn.esprit.spring.enumeration.CategorieUser CategorieUser;
    private tn.esprit.spring.enumeration.Profession Profession;
    private Role role;
    private Facture facture;
    private AvisUser avisUser;

}
