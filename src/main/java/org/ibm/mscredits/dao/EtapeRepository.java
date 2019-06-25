package org.ibm.mscredits.dao;


import org.ibm.mscredits.entities.Etape;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapeRepository extends JpaRepository<Etape,Long> {
    Page<Etape> findByCredit_IdEquals(Long creditId, Pageable pageable);
}
