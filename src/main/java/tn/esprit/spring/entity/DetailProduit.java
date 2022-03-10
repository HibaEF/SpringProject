package tn.esprit.spring.entity;

import tn.esprit.spring.enumeration.CategorieProduit;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idDetailProduit")
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetailProduit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDetailProduit")
    private Long idDetailProduit;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private CategorieProduit CategorieProduit;
    @OneToOne(mappedBy = "Detailproduit",cascade = CascadeType.ALL)
    private Produit produit;

}

