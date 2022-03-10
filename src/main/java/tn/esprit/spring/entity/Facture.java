package tn.esprit.spring.entity;

import javax.persistence.*;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.entity.DetailFacture;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity

@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)	

@Table(name="facture")
@CrossOrigin(origins = "*", allowedHeaders = "*")


@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idFacture")
public class Facture implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFacture")
    Long idFacture;
    float montantRemise;
    float montantFacture;
    @Temporal(TemporalType.DATE)
    Date dateFacture;
    boolean active;
   // @JsonBackReference
    @ManyToOne
    User user;
    
    @OneToMany(mappedBy = "f",cascade = CascadeType.ALL)
    List<DetailFacture> detailFacture;

    
}
