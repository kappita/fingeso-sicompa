package com.SICOMPA.backendSICOMPA.Responses;

import com.SICOMPA.backendSICOMPA.Entity.Admin;
import com.SICOMPA.backendSICOMPA.Entity.Resident;
import com.SICOMPA.backendSICOMPA.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
// Objeto de respuesta de un inicio de sesión
public class LoginResponse {
    private User user;
    private List<Resident> residents;
    private List<Admin> admins;
}
