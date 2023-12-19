package com.SICOMPA.backendSICOMPA.Controller;

import com.SICOMPA.backendSICOMPA.Entity.Admin;
import com.SICOMPA.backendSICOMPA.Forms.LoginForm;
import com.SICOMPA.backendSICOMPA.Responses.AdminLoginResponse;
import com.SICOMPA.backendSICOMPA.Responses.ResidentLoginResponse;
import com.SICOMPA.backendSICOMPA.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<AdminLoginResponse> login(@RequestBody LoginForm form) {
        return adminService.login(form);
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }
}
