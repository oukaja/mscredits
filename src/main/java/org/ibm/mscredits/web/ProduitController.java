package org.ibm.mscredits.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ibm.mscredits.dao.ProduitRepository;
import org.ibm.mscredits.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@Api(value="Product Controller", description="operations to manage Products")
public class ProduitController {
    @Autowired
    ProduitRepository rep;
    @GetMapping("/produits")
    @ApiOperation(value = "list of all Products")
    public Page<Produit> getAll(Pageable pageable){return rep.findAll(pageable);}

    @GetMapping("/produits/{id}")
    @ApiOperation(value = "get detail of a Product")
    public Produit getOne(@PathVariable long id) {
        return rep.findById(id).get();
    }
    @PostMapping("/produit")
    @ApiOperation(value = "create new Product")
    public Produit create(@RequestBody Produit o){return rep.save(o);}
    @PutMapping("/produit")
    @ApiOperation(value = "update a Product")
    public Produit update(@RequestBody Produit o){return rep.save(o);}


    @GetMapping("/produits/parnom/{mc}")
    @ApiOperation(value = "find Products by name")
    public Page<Produit> findAllByNom(@PathVariable String mc,Pageable pageable){return rep.findAllByNomContains(mc,pageable);}

}
