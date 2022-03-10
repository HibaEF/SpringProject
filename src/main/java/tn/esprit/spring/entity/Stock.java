package tn.esprit.spring.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;


import lombok.experimental.FieldDefaults;
@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")

@Table(name="Stock")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of= {"id","name","qteMin","qte","date","libelleStock"})
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Stock implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idStock")
     long id;
    String name;
    int qte;
    
    int qteMin;
    Date date;
     String libelleStock;
     String logo;
     @JsonIgnore
    @OneToMany (mappedBy ="s")
    List<Produit> pE;
 


}