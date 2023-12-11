package com.SICOMPA.backendSICOMPA.Service;


import com.SICOMPA.backendSICOMPA.Entity.Community;
import com.SICOMPA.backendSICOMPA.Entity.Resident;
import com.SICOMPA.backendSICOMPA.EntityManager.CommunityEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.ResidentEntityManager;
import com.SICOMPA.backendSICOMPA.Responses.QuotaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResidentService {

    @Autowired
    ResidentEntityManager residentManager;

    @Autowired
    CommunityEntityManager communityManager;

    @Autowired
    CommunityService communityService;

    public ResponseEntity<Resident> createResident(Resident resident) {
        return ResponseEntity.ok(residentManager.save(resident));
    }

    public ResponseEntity<Community> getResidentCommunity(Long resident_id) {
        Optional<Resident> req = residentManager.findById(resident_id);
        if (req.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Resident resident = req.get();
        Optional<Community> community = communityManager.findById(resident.getCommunity_id());
        if (community.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(community.get());
    }

    public ResponseEntity<QuotaResponse> getResidentQuota(Long resident_id) {
        Optional<Resident> req = residentManager.findById(resident_id);
        if (req.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Resident resident = req.get();
        Long community_id = resident.getCommunity_id();
        QuotaResponse response = communityService.calculateQuotaProportion(getResidentTotalM2(resident), community_id);
        return ResponseEntity.ok(response);
    }

    public int getResidentTotalM2(Resident resident) {
        int total = resident.getUsed_m2();
        Community community = communityManager.findById(resident.getCommunity_id()).get();
        total += resident.getUsed_parking() * community.getParking_m2();
        total += resident.getUsed_storage() * community.getStorage_m2();

        return total;
    }


}
