package com.SICOMPA.backendSICOMPA.Responses;

import com.SICOMPA.backendSICOMPA.Entity.Admin;
import com.SICOMPA.backendSICOMPA.Entity.Resident;
import com.SICOMPA.backendSICOMPA.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LoginResponse {
    private User user;
    private List<Resident> residents;
    private List<Admin> admins;
}
