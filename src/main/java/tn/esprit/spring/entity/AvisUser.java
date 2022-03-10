package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idAvisUser")
@Table
@Setter
@Getter
@NoArgsConstructor
@ToString
public class AvisUser {

    public AvisUser(Date datePublicationAvis, String description, int note, int NBP, int NBC) {
        this.datePublicationAvis = datePublicationAvis;
        this.description = description;
        this.note = note;
        this.NBP = NBP;
        this.NBC = NBC;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAvisUser")
    private Long idAvisUser;
    @Temporal(TemporalType.DATE)
    private Date datePublicationAvis;
    private String description;
    private int note;
    private int NBP;
    private int NBC;

    @JsonIgnore
    @ManyToOne
    User user_avis;

    @ManyToOne
    Produit produit_avis;

}
