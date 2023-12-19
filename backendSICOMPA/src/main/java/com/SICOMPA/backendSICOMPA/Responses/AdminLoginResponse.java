package com.SICOMPA.backendSICOMPA.Responses;


import com.SICOMPA.backendSICOMPA.Entity.Admin;
import com.SICOMPA.backendSICOMPA.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AdminLoginResponse {
    private User user;
    private List<Admin> admins;
}
