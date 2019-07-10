package org.ibm.mscredits.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Credit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Long compteId;
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("credit")
    protected Simulation simulation;
    protected Date date;
    protected Date dateAnnulation;
    @OneToMany(mappedBy = "credit",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("credit")
    protected List<Etape> etapes;

    public String toString(){
        String msg=String.format("Credit : {id: %d, date: %s, simulation: %s",id,date,simulation.toString());
        //if(etapes!=null)    msg+=",etapes:["+etapes.toString()+"]";
        msg+="}";
        return msg;
    }
}
