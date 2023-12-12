package com.SICOMPA.backendSICOMPA.EntityManager;

import com.SICOMPA.backendSICOMPA.Entity.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChargeEntityManager extends JpaRepository<Charge, Long> {

    @Query("SELECT c " +
            "FROM Charge c " +
            "WHERE c.community_id = ?1 ")
    List<Charge> findPendingChargesOfCommunity(Long community_id);
}
