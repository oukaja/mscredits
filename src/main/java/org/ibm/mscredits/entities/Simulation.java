package org.ibm.mscredits.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Simulation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Double montant;
    protected Double mensualite;
    protected Long taux;
    protected Long duree;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("simulations")
    protected Produit produit;
    protected Long clientId;
    @OneToOne(mappedBy = "simulation",fetch = FetchType.LAZY)
    @JsonIgnoreProperties("simulation")
    protected Credit credit;
    public String toString(){
        return String.format("Simulation : {id: %d, montant: %f, taux: %d, duree: %d, mensualite: %f, produit: %d, client: %s }",id,montant,taux,duree,mensualite,produit.getId(),(clientId!=null)?"UNKNOWN":clientId);
    }
}
