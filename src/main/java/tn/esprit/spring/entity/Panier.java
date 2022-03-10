/*package tn.esprit.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="panier")
@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)	


public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idPanier;
    @JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy="p")
	 Set<DetailFacture> detailFacture;
	
	 long prixTotal;
	 int nombreArticle;
	
	 float montantRemise;
	 
	 @OneToOne
	 User u;

}
*/