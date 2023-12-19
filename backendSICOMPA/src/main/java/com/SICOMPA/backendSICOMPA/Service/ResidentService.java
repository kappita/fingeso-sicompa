package com.SICOMPA.backendSICOMPA.Service;


import com.SICOMPA.backendSICOMPA.Entity.Admin;
import com.SICOMPA.backendSICOMPA.Entity.Community;
import com.SICOMPA.backendSICOMPA.Entity.Resident;
import com.SICOMPA.backendSICOMPA.Entity.User;
import com.SICOMPA.backendSICOMPA.EntityManager.CommunityEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.ResidentEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.UserEntityManager;
import com.SICOMPA.backendSICOMPA.Forms.LoginForm;
import com.SICOMPA.backendSICOMPA.Responses.QuotaResponse;
import com.SICOMPA.backendSICOMPA.Responses.ResidentLoginResponse;
import com.SICOMPA.backendSICOMPA.Responses.ResidentWithQuota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResidentService {

    @Autowired
    ResidentEntityManager residentManager;

    @Autowired
    CommunityEntityManager communityManager;

    @Autowired
    CommunityService communityService;

    @Autowired
    UserEntityManager userManager;

    // Inicia la sesión de un usuario
    public ResponseEntity<ResidentLoginResponse> login(LoginForm form) {
        // Confirma que el correo y la contraseña sean válidas
        Optional<User> req = userManager.findByEmailAndPassword(form.getEmail(), form.getPassword());
        if (req.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        User u = req.get();
        // Obtiene las residencias y administraciones del usuario
        List<Resident> resReq = residentManager.findAllByUser(u.getId());
        List<ResidentWithQuota> resQuotas = new ArrayList<>() {
        };
        for (Resident res: resReq) {
            QuotaResponse quota = getResidentQuota(res.getId());
            resQuotas.add(new ResidentWithQuota(res, quota));
            
        }

        ResidentLoginResponse response = new ResidentLoginResponse(u, resQuotas);
        return ResponseEntity.ok(response);


    }

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
    public QuotaResponse getResidentQuota(Long resident_id) {
        // Comprueba que le residente exista
        Optional<Resident> req = residentManager.findById(resident_id);
        if (req.isEmpty()) {
            return null;
        }
        // No deberían existir residentes sin comunidad
        Resident resident = req.get();
        Long community_id = resident.getCommunity_id();
        QuotaResponse quota = communityService.calculateQuotaProportion(getResidentTotalM2(resident), community_id);
        return quota;
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
