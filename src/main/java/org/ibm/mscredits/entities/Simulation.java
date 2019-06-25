package org.ibm.mscredits.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Simulation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Double montant;
    protected Double mensualite;
    protected Long taux;
    protected Long duree;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    protected Produit produit;
    protected Long clientId;
    @OneToOne(mappedBy = "simulation")
    @JsonBackReference
    protected Credit credit;
    public String toString(){
        return String.format("Simulation : {id: %d, montant: %f, taux: %d, duree: %d, mensualite: %f, produit: %d, client: %s }",id,montant,taux,duree,mensualite,produit.getId(),(clientId!=null)?"UNKNOWN":clientId);
    }
}
