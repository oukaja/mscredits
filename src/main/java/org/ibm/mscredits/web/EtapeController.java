package org.ibm.mscredits.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ibm.mscredits.dao.EtapeRepository;
import org.ibm.mscredits.entities.Etape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@Api(value="Step Controller", description="operations to manage Steps of loans")
public class EtapeController {
    @Autowired
    EtapeRepository rep;
    @GetMapping("/etapes")
    @ApiOperation(value = "list of all Step")
    public Page<Etape> getAll(Pageable pageable){return rep.findAll(pageable);}

    @GetMapping("/etape/{id}")
    @ApiOperation(value = "get details of a Step")
    public Etape getOne(@PathVariable long id) {
        return rep.findById(id).get();
    }
    @PostMapping("/etape")
    @ApiOperation(value = "create new Step")
    public Etape create(@RequestBody Etape o){return rep.save(o);}
    @PutMapping("/etape")
    @ApiOperation(value = "update a Step")
    public Etape update(@RequestBody Etape o){return rep.save(o);}


}
