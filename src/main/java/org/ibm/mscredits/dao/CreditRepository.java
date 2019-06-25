package org.ibm.mscredits.dao;


import org.ibm.mscredits.entities.Credit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {
    Page<Credit> findAllBySimulation_ClientIdEquals(Long clientId, Pageable pageable);
    @Query(value = "SELECT c FROM Credit c,Etape e WHERE e MEMBER OF c.etapes AND e.nom =:nom AND e.validateur IS NULL ")
    Page<Credit> findAllByEtapesNeedApproval(@Param("nom") String nom, Pageable pageable);
    @Query(value = "SELECT c FROM Credit c,Etape e,Simulation s WHERE e MEMBER OF c.etapes AND s.id = c.simulation.id AND e.nom =:nom AND e.validateur IS NULL AND s.montant=:montant")
    Page<Credit> findAllByEtapesNeedApprovalAndAboveABalance(@Param("nom") String nom,@Param("montant") Double montant, Pageable pageable);
}
