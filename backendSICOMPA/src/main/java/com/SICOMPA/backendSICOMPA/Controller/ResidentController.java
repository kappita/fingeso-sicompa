package com.SICOMPA.backendSICOMPA.Controller;


import com.SICOMPA.backendSICOMPA.Entity.Resident;
import com.SICOMPA.backendSICOMPA.Responses.QuotaResponse;
import com.SICOMPA.backendSICOMPA.Service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resident")
public class ResidentController {
    @Autowired
    ResidentService residentService;
    @PostMapping("/addResident")
    public ResponseEntity<Resident> addResident(@RequestBody Resident resident) {
        return residentService.createResident(resident);
    }

    @GetMapping("/quota/{resident_id}")
    public ResponseEntity<QuotaResponse> getQuota(@PathVariable Long resident_id) {
        return residentService.getResidentQuota(resident_id);
    }
}
