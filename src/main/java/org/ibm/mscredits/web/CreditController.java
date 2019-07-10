package org.ibm.mscredits.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ibm.mscredits.dao.CreditRepository;
import org.ibm.mscredits.dao.EtapeRepository;
import org.ibm.mscredits.dao.SimulationRepository;
import org.ibm.mscredits.entities.Credit;
import org.ibm.mscredits.entities.Etape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;

@CrossOrigin("*")
@RestController
@Api(value="Loan Controller", description="operations to loans ")
public class CreditController {
    @Autowired
    CreditRepository rep;
    @Autowired
    EtapeRepository etapeRepository;
    @Autowired
    SimulationRepository simulationRepository;
    @GetMapping("/credits")
    @ApiOperation(value = "list of all loans")
    public Page<Credit> getAll(Pageable pageable){return rep.findAll(pageable);}

    @GetMapping("/credits/{id}")
    @ApiOperation(value = "list details and steps of a loan")
    public Credit getOne(@PathVariable long id) {
        return rep.findById(id).get();
    }
    @PostMapping("/credit")
    @ApiOperation(value = "create a new loan")
    @Transactional
    public Credit create(@RequestBody Credit o){
        o.setSimulation(simulationRepository.findById(o.getSimulation().getId()).get());
        o=rep.save(o);
        if(o.getEtapes()==null || o.getEtapes().isEmpty()){
            Etape e=new Etape(null,o,"Initialisation","système",true,"votre demande de crédit a été crée.",new Date());
            etapeRepository.save(e);
        }
        else{
            o.getEtapes().forEach(e->{
                etapeRepository.save(e);
            });
        }
        return rep.findById(o.getId()).get();
    }
    @PutMapping("/credit")
    @ApiOperation(value = "update a loan")
    public Credit update(@RequestBody Credit o){return rep.save(o);}

    @GetMapping("/credits/parclient/{id}")
    @ApiOperation(value = "find all loans that are made by a client")
    public Page<Credit> findAllByClient(@PathVariable long id,Pageable pageable) {
        return rep.findAllBySimulation_ClientIdEquals(id, pageable);
    }
    @GetMapping("/credits/validation/{etape}")
    @ApiOperation(value = "find all loans that need to be validated in a specific step")
    public Page<Credit> findAllCreditWithNoValidationStep(@PathVariable String etape,Pageable pageable) {
        return rep.findAllByEtapesNeedApproval(etape, pageable);
    }

    @GetMapping("/credits/validation/{etape}/sur/{montant}")
    @ApiOperation(value = "find all loans that need to be validated in a specific step and above a balance")
    public Page<Credit> findAllCreditWithNoValidationStepAndAboveALine(@PathVariable String etape,@PathVariable Double montant,Pageable pageable) {
        return rep.findAllByEtapesNeedApprovalAndAboveABalance(etape,montant, pageable);
    }
}
