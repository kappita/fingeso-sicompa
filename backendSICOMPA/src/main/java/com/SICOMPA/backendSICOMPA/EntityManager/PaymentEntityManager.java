package com.SICOMPA.backendSICOMPA.EntityManager;

import com.SICOMPA.backendSICOMPA.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentEntityManager extends JpaRepository<Payment, Long> {
}
