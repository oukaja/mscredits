package org.ibm.mscredits.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ibm.mscredits.dao.SimulationRepository;
import org.ibm.mscredits.entities.Simulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@Api(value="Simulation Controller", description="operations to manage Simulations")
public class SimulationController {
    @Autowired
    SimulationRepository rep;
    @GetMapping("/simulations")
    @ApiOperation(value = "list of all Simulations")
    public Page<Simulation> getAll(Pageable pageable){return rep.findAll(pageable);}

    @GetMapping("/simulations/{id}")
    @ApiOperation(value = "get details of a Simulation")
    public Simulation getOne(@PathVariable long id) {
        return rep.findById(id).get();
    }
    @PostMapping("/simulation")
    @ApiOperation(value = "create new Simulation")
    public Simulation create(@RequestBody Simulation o){return rep.save(o);}
    @PutMapping("/simulation")
    @ApiOperation(value = "update a Simulation")
    public Simulation update(@RequestBody Simulation o){return rep.save(o);}


    @GetMapping("/simulations/parclient/{id}")
    @ApiOperation(value = "find simulation that are made by client")
    public Page<Simulation> findAllByClient(@PathVariable Long id,Pageable pageable){return rep.findAllByClientIdEquals(id,pageable);}

    @GetMapping("/simulations/unknown")
    @ApiOperation(value = "find simulations that are made by internautes")
    public Page<Simulation> findAllByNom(Pageable pageable){return rep.findAllByClientIdIsNull(pageable);}

}
