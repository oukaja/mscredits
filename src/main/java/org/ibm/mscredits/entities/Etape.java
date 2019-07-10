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
public class Etape implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("etapes")
    protected Credit credit;
    protected String nom;
    protected String validateur;
    protected boolean confirmation=false;
    protected String message;
    protected Date date;

    public String toString() throws NullPointerException{
        return String.format("Etape : {id: %d, nom: %s, validateur: %s, message: %s, date: %s}",id,nom,validateur,message,date.toString());
    }
}
