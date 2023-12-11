package com.SICOMPA.backendSICOMPA.Service;


import com.SICOMPA.backendSICOMPA.Entity.Admin;
import com.SICOMPA.backendSICOMPA.EntityManager.AdminEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.CommunityEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminEntityManager adminManager;

    @Autowired
    CommunityEntityManager communityManager;

    @ResponseBody

    public ResponseEntity<Admin> addAdmin(Admin admin) {
        Optional<Admin> req = adminManager.findExistingAdmin(admin.getUser_id());
        if (req.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(adminManager.save(admin));
    }
    public boolean checkCredentials(String email, String password, Long community_id) {
        Optional<Admin> req = adminManager.findAdminByEmailAndPassword(email, password);
        if (req.isEmpty()) {
            return false;
        }
        Long admin_community_id = req.get().getCommunity_id();

        return Objects.equals(admin_community_id, community_id);
    }

}
