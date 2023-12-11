package com.SICOMPA.backendSICOMPA.EntityManager;

import com.SICOMPA.backendSICOMPA.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdminEntityManager extends JpaRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a INNER JOIN User u ON a.user_id = u.id WHERE u.email = ?1 AND u.password = ?2")
    Optional<Admin> findAdminByEmailAndPassword(String email, String password);

    @Query("SELECT a FROM Admin a WHERE a.user_id = ?1")
    Optional<Admin> findExistingAdmin(Long user_id);

    @Query("SELECT a FROM Admin a WHERE a.user_id = ?1")
    List<Admin> findAllByUser(Long user_id);
}
