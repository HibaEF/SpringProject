package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import tn.esprit.spring.entity.Facture;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Table(name="Livraison")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class Livraison implements Serializable {
@Autowired
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY )
@Column(name="id")
private Long id;
@JsonIgnore
@OneToOne
private Facture F ;
@JsonIgnore
@ManyToOne
private Livreur L;
private Date dateLivraisonDate;
private String adresseLvr;
private Boolean status;


}
