package com.SICOMPA.backendSICOMPA.Service;


import com.SICOMPA.backendSICOMPA.Entity.Admin;
import com.SICOMPA.backendSICOMPA.Entity.Resident;
import com.SICOMPA.backendSICOMPA.Entity.User;
import com.SICOMPA.backendSICOMPA.EntityManager.AdminEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.CommunityEntityManager;
import com.SICOMPA.backendSICOMPA.EntityManager.UserEntityManager;
import com.SICOMPA.backendSICOMPA.Forms.LoginForm;
import com.SICOMPA.backendSICOMPA.Responses.AdminLoginResponse;
import com.SICOMPA.backendSICOMPA.Responses.ResidentLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminEntityManager adminManager;

    @Autowired
    CommunityEntityManager communityManager;

    @Autowired
    UserEntityManager userManager;

    // Inicia la sesión de un usuario
    public ResponseEntity<AdminLoginResponse> login(LoginForm form) {
        // Confirma que el correo y la contraseña sean válidas
        Optional<User> req = userManager.findByEmailAndPassword(form.getEmail(), form.getPassword());
        if (req.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        User u = req.get();
        // Obtiene las residencias y administraciones del usuario
        List<Admin> adminReq = adminManager.findAllByUser(u.getId());

        AdminLoginResponse response = new AdminLoginResponse(u, adminReq);
        return ResponseEntity.ok(response);


    }

    @ResponseBody
    // Agrega un administrador al la base de datos
    public ResponseEntity<Admin> addAdmin(Admin admin) {
        // Revisa que el usuario no esté administrando otra comunidad
        Optional<Admin> req = adminManager.findExistingAdmin(admin.getUser_id());
        if (req.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(adminManager.save(admin));
    }
    // Verifica si un admin corresponde a una comunidad
    public boolean checkCredentials(String email, String password, Long community_id) {
        Optional<Admin> req = adminManager.findAdminByEmailAndPassword(email, password);
        if (req.isEmpty()) {
            return false;
        }
        Long admin_community_id = req.get().getCommunity_id();

        return Objects.equals(admin_community_id, community_id);
    }


}
