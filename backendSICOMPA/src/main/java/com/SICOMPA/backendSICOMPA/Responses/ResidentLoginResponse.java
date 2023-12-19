package com.SICOMPA.backendSICOMPA.Responses;

import com.SICOMPA.backendSICOMPA.Entity.Resident;
import com.SICOMPA.backendSICOMPA.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
// Objeto de respuesta de un inicio de sesión
public class ResidentLoginResponse {
    private User user;
    private List<ResidentWithQuota> residents;
}
