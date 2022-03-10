package tn.esprit.spring.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;

@Entity
@Table(name="detailfacture")

@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)

public class DetailFacture implements Serializable {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDetailFacture")
    
    Long idDetailFacture;
    @Column(columnDefinition = "int default 1")
    int qte=1;
    float prixTotal;
   
    float montantRemise;
    
    @ManyToOne
    Facture f;
    
    
    @ManyToOne
    Produit produit;
    
   
    
}
