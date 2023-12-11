package com.SICOMPA.backendSICOMPA.Service;


import com.SICOMPA.backendSICOMPA.Entity.Admin;
import com.SICOMPA.backendSICOMPA.Entity.Resident;
import com.SICOMPA.backendSICOMPA.Entity.User;
import com.SICOMPA.backendSICOMPA.EntityManager.AdminEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.ResidentEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.UserEntityManager;
import com.SICOMPA.backendSICOMPA.Forms.LoginForm;
import com.SICOMPA.backendSICOMPA.Forms.Test;
import com.SICOMPA.backendSICOMPA.Responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;



@Service
public class UserService {
    @Autowired
    private UserEntityManager userEntityManager;

    @Autowired
    private AdminEntityManager adminManager;

    @Autowired
    private ResidentEntityManager residentManager;

    @ResponseBody

    public ResponseEntity<User> register(User user) {
        Optional<User> req = userEntityManager.findByEmail(user.getEmail());
        if (req.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        User result = userEntityManager.save(user);

        return ResponseEntity.ok(user);

    }

    public ResponseEntity<LoginResponse> login(LoginForm form) {
        Optional<User> req = userEntityManager.findByEmailAndPassword(form.getEmail(), form.getPassword());
        if (req.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        User u = req.get();

        List<Resident> resReq = residentManager.findAllByUser(u.getId());
        List<Admin> adminReq = adminManager.findAllByUser(u.getId());

        LoginResponse response = new LoginResponse(u, resReq, adminReq);
        return ResponseEntity.ok(response);


    }


}
