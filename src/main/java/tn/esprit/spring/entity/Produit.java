package tn.esprit.spring.entity;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Produit implements Serializable {
   //aaa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String code;
    private String libelle;
    private String picture;
    private String description;
    private Long nbrLike;
    private float prixUnitaire;
   
   // 
   @JsonIgnore
    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
    private Set<DetailFacture> detailFacture;
    
    @JsonIgnore
    @ManyToOne
    private Rayon rayon;
    
    @JsonIgnore
    @ManyToOne
    private Stock s;
   @JsonIgnore
    @OneToOne
    private DetailProduit Detailproduit;
   @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Fournisseur> fornisseur;
    @JsonIgnore
    @OneToMany(mappedBy = "produit_avis",cascade = CascadeType.ALL)
    private Set<AvisUser> avisProduit;
    @Column(columnDefinition = "int default 0")
    private Long pourcentageRemise;

}