package com.SICOMPA.backendSICOMPA.Forms;

import com.SICOMPA.backendSICOMPA.Entity.Community;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// Formulario para agregar una comunidad
public class AddCommunityForm {
    private String email;
    private String password;
    private Community community;
}
