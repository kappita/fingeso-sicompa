package com.SICOMPA.backendSICOMPA.EntityManager;

import com.SICOMPA.backendSICOMPA.Entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityEntityManager extends JpaRepository<Community, Long> {
}
