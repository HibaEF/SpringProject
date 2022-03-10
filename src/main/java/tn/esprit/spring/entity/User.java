package tn.esprit.spring.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;

import lombok.*;
import tn.esprit.spring.enumeration.CategorieUser;
import tn.esprit.spring.enumeration.Profession;

import java.util.Set;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor




@AllArgsConstructor
@ToString
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idUser")

public class User implements Serializable {
    public User(String nom, String prenom, Date dateNaissance, String email, String password, CategorieUser categorieUser, Profession profession) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.password = password;
        CategorieUser = categorieUser;
        Profession = profession;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    private Long idUser;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String email;
    private String password;
    private CategorieUser CategorieUser;
    private Profession Profession;
    private String picture;
    private Integer phoneNumber;
    private String adresse;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<Role> role;

   // @JsonIgnore
   // @JsonManagedReference
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Facture> facture;

    @OneToMany(mappedBy = "user_avis",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AvisUser> avisUser;



}
