package org.ibm.mscredits.dao;

import org.ibm.mscredits.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    Page<Produit> findAllByNomContains(String mc,Pageable pageable);
}
