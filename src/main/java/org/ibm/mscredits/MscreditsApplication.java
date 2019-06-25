package org.ibm.mscredits;

import org.ibm.mscredits.dao.CreditRepository;
import org.ibm.mscredits.dao.EtapeRepository;
import org.ibm.mscredits.dao.ProduitRepository;
import org.ibm.mscredits.dao.SimulationRepository;
import org.ibm.mscredits.entities.Credit;
import org.ibm.mscredits.entities.Etape;
import org.ibm.mscredits.entities.Produit;
import org.ibm.mscredits.entities.Simulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MscreditsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscreditsApplication.class, args);
    }
    // data pour les test
    /*@Autowired
    ProduitRepository produitRepository;
    @Autowired
    SimulationRepository simulationRepository;
    @Autowired
    CreditRepository creditRepository;
    @Autowired
    EtapeRepository etapeRepository;
    @Override
    public void run(String... args) throws Exception {
        Produit p1=new Produit(null,"crédit personnel",new Date("01/01/2010"),(long)6,(long)12,null);
        p1=produitRepository.save(p1);
        System.out.println(p1.toString());

        Simulation s1=new Simulation(null,(double)10000,(double)1100,(long)10,(long)10,p1,null,null);
        Simulation s2=new Simulation(null,(double)11000,(double)1200,(long)10,(long)10,p1,(long)1,null);
        simulationRepository.save(s1);
        simulationRepository.save(s2);

        simulationRepository.findAll().forEach(System.out::println);

        Credit c1=new Credit(null,Long.parseLong("12123456789002"),s2,new Date(),null);
        creditRepository.save(c1);

        Etape e1=new Etape(null,c1,"initizalisation","system","votre demande de credit a été crée.",new Date());
        Etape e2=new Etape(null,c1,"pre Analyse","système","votre demande de credit a été accepter par le système.",new Date());
        Etape e3=new Etape(null,c1,"analyse",null,null,null);
        Etape e4=new Etape(null,c1,"virement",null,null,null);
        e1=etapeRepository.save(e1);
        e2=etapeRepository.save(e2);
        e3=etapeRepository.save(e3);
        e4=etapeRepository.save(e4);
    }*/
}
