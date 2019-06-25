package org.ibm.mscredits.dao;


import org.ibm.mscredits.entities.Simulation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulationRepository extends JpaRepository<Simulation,Long> {
    Page<Simulation> findAllByClientIdIsNull(Pageable pageable);
    Page<Simulation> findAllByClientIdEquals(Long clientId,Pageable pageable);
}
