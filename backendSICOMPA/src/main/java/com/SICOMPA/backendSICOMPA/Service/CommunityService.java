package com.SICOMPA.backendSICOMPA.Service;

import com.SICOMPA.backendSICOMPA.Entity.Admin;
import com.SICOMPA.backendSICOMPA.Entity.Charge;
import com.SICOMPA.backendSICOMPA.Entity.Community;
import com.SICOMPA.backendSICOMPA.EntityManager.AdminEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.ChargeEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.CommunityEntityManager;
import com.SICOMPA.backendSICOMPA.Responses.QuotaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {
    @Autowired
    CommunityEntityManager communityEntityManager;

    @Autowired
    ChargeEntityManager chargeEntityManager;

    @Autowired
    AdminEntityManager adminEntityManager;


    // Crea una comunidad, no hay restricciones ya que el id es autoincrementado
    @ResponseBody
    public ResponseEntity<Community> createCommunity(Community community) {
        return ResponseEntity.ok(communityEntityManager.save(community));
    }

    // Obtiene todos los egresos/gastos de la comunidad
    public ResponseEntity<List<Charge>> getCommunityCharges(Long community_id) {
        List<Charge> pendingCharges = chargeEntityManager.findPendingChargesOfCommunity(community_id);
        return ResponseEntity.ok(pendingCharges);
    }

    // Calcula la cuota correspondiente al mes de una comunidad
    public float calculateQuota(Long community_id) {
        List<Charge> pendingCharges = chargeEntityManager.findPendingChargesOfCommunity(community_id);
        float total = 0;
        // Provisorio: Arreglar query SQL para no tener que calcular
        //             pagos correspondientes al mes en servicio
        // Agrega al total sólo los egresos pendientes por cuota o mes
        for (Charge c: pendingCharges) {
            LocalDate c_date = c.getCreation_date();
            LocalDate current_date = LocalDate.now();
            int charge_months = c_date.getMonthValue() + c_date.getYear() * 12 + c.getDues();
            int current_months = current_date.getMonthValue() + current_date.getYear() * 12;

            // Divide por la cantidad de cuotas
            if (current_months < charge_months) {
                total += (float) c.getAmount() / c.getDues();
            }


        }
        return total;
    }

    // Calcula el total de M2 de una comunidad
    public int calculateTotalM2(Long community_id) {
        Optional<Community> community = communityEntityManager.findById(community_id);
        if (community.isEmpty()) {
            return -1;
        }
        // Suma el total del edificio con la multiplicación de las existencias por su metraje
        Community comm = community.get();
        int total = comm.getTotal_m2();
        total += comm.getParking_m2() * comm.getTotal_parking_units();
        total += comm.getStorage_m2() * comm.getTotal_storage_units();

        return total;

    }

    // Calcula la proporción correspondiente a los m2 de un usuario
    public QuotaResponse calculateQuotaProportion(int resident_m2, Long community_id) {

        int totalM2 = calculateTotalM2(community_id);
        float proportion = (float) resident_m2 / (float) totalM2;
        float quota = calculateQuota(community_id);
        return new QuotaResponse(quota * proportion, quota, proportion);
    }



}
