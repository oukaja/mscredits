package org.ibm.mscredits.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produit implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nom;
    protected Date date;
    protected Long tauxMin ;
    protected Long tauxMax;

    @OneToMany(mappedBy = "produit",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("produit")
    List<Simulation> simulations;

    public String toString(){
        return String.format("> Produit :{ id: %d,    nom: %s,    taux: [%d, %d],    date: %s }",id,nom,tauxMin,tauxMax,date.toString()) ;
    }
}

