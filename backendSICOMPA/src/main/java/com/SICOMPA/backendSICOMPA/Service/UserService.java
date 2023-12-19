package com.SICOMPA.backendSICOMPA.Service;


import com.SICOMPA.backendSICOMPA.Entity.Admin;
import com.SICOMPA.backendSICOMPA.Entity.Resident;
import com.SICOMPA.backendSICOMPA.Entity.User;
import com.SICOMPA.backendSICOMPA.EntityManager.AdminEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.ResidentEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.UserEntityManager;
import com.SICOMPA.backendSICOMPA.Forms.LoginForm;
import com.SICOMPA.backendSICOMPA.Responses.ResidentLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    // Registra un usuario en el sistema
    public ResponseEntity<User> register(User user) {
        // Verifica que no exista un usuario con ese correo
        Optional<User> req = userEntityManager.findByEmail(user.getEmail());
        if (req.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        User result = userEntityManager.save(user);

        return ResponseEntity.ok(user);

    }




}
