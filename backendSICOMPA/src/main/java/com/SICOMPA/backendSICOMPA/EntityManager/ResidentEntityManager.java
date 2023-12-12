package com.SICOMPA.backendSICOMPA.EntityManager;

import com.SICOMPA.backendSICOMPA.Entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResidentEntityManager extends JpaRepository<Resident, Long> {
    @Query("SELECT r FROM Resident r where r.user_id = ?1")
    List<Resident> findAllByUser(Long user_id);
}
