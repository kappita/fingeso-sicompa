package com.SICOMPA.backendSICOMPA.Controller;

import com.SICOMPA.backendSICOMPA.Entity.Charge;
import com.SICOMPA.backendSICOMPA.Entity.Community;
import com.SICOMPA.backendSICOMPA.Entity.User;
import com.SICOMPA.backendSICOMPA.Forms.AddChargeForm;
import com.SICOMPA.backendSICOMPA.Forms.AddCommunityForm;
import com.SICOMPA.backendSICOMPA.Service.ChargeService;
import com.SICOMPA.backendSICOMPA.Service.CommunityService;
import com.SICOMPA.backendSICOMPA.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    CommunityService communityService;

    @Autowired
    ChargeService chargeService;
    @PostMapping("/addCommunity")
    public ResponseEntity<Community> addCommunity(@RequestBody Community community) {

        return communityService.createCommunity(community);
    }

    @GetMapping("/charges/{community_id}")
    public ResponseEntity<List<Charge>> getCommunityCharges(@PathVariable Long community_id) {
        return communityService.getCommunityCharges(community_id);
    }

    @PostMapping("/addCharge")
    public ResponseEntity<Charge> addCharge(@RequestBody AddChargeForm form) {
        return chargeService.addCharge(form);
    }
}
