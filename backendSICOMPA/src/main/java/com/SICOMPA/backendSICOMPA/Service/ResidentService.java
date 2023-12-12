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

    // Agrega un residente a la base de datos
    public ResponseEntity<Resident> createResident(Resident resident) {
        return ResponseEntity.ok(residentManager.save(resident));
    }

    // Obtiene la comunidad de un residente
    public ResponseEntity<Community> getResidentCommunity(Long resident_id) {
        // Comprueba que el residente exista
        Optional<Resident> req = residentManager.findById(resident_id);
        if (req.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Se obtiene la comunidad del residente. Como es Many to One, no debería
        // ser nulo
        Resident resident = req.get();
        Optional<Community> community = communityManager.findById(resident.getCommunity_id());
        if (community.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(community.get());
    }

    // Obtiene la cuota de gastos comunes correspondiente a un residente
    public ResponseEntity<QuotaResponse> getResidentQuota(Long resident_id) {
        // Comprueba que le residente exista
        Optional<Resident> req = residentManager.findById(resident_id);
        if (req.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        // No deberían existir residentes sin comunidad
        Resident resident = req.get();
        Long community_id = resident.getCommunity_id();
        QuotaResponse response = communityService.calculateQuotaProportion(getResidentTotalM2(resident), community_id);
        return ResponseEntity.ok(response);
    }

    // Obtiene los M2 totales utilizados por un residente
    public int getResidentTotalM2(Resident resident) {
        // Suma el total de la residencia y multiplica las existencias por su metraje
        int total = resident.getUsed_m2();
        Community community = communityManager.findById(resident.getCommunity_id()).get();
        total += resident.getUsed_parking() * community.getParking_m2();
        total += resident.getUsed_storage() * community.getStorage_m2();

        return total;
    }


}
