package com.SICOMPA.backendSICOMPA.Service;

import com.SICOMPA.backendSICOMPA.Entity.Charge;
import com.SICOMPA.backendSICOMPA.EntityManager.AdminEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.ChargeEntityManager;
import com.SICOMPA.backendSICOMPA.Forms.AddChargeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChargeService {
    @Autowired
    ChargeEntityManager chargeManager;
    @Autowired
    AdminEntityManager adminManager;

    @Autowired
    AdminService adminService;

    // Agrega un gasto a una comunidad con el form correspondiente
    public ResponseEntity<Charge> addCharge(AddChargeForm form) {
        // Verifica que el admin corresponda a la comunidad
        if (!adminService.checkCredentials(form.getEmail(),
                                           form.getPassword(),
                                           form.getCharge().getCommunity_id())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        return ResponseEntity.ok(chargeManager.save(form.getCharge()));
    }

}
