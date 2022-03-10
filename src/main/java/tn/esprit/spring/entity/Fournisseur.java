package tn.esprit.spring.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity


@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of= {"idFournissuer","code","libelle"})
@FieldDefaults(level=AccessLevel.PRIVATE)


public class Fournisseur implements Serializable {



    public Fournisseur(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFournissuer")
     Long id;
    String name;
	 String adresse;
     String code;
    String libelle;
    String email;
    String logo;
}
