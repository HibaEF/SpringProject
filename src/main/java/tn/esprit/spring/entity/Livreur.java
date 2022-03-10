package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="Livreur")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Livreur implements Serializable {
@Autowired
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="id")
private Long id;
private String NomLiv;
private String PrenomLiv;
private String VilleLiv;
private String adresseLiv;
private String MdpLiv;
private int TelLiv;
private Double LngLiv;
private Double LatLiv;
private Boolean status;
@OneToMany(mappedBy="L")

private List <Livraison> ListLivraisons;
}
