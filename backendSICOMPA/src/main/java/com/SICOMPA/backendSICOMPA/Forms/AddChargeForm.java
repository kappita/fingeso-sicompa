package com.SICOMPA.backendSICOMPA.Forms;

import com.SICOMPA.backendSICOMPA.Entity.Charge;
import lombok.Data;

@Data
// Formulario para agregar un egreso
public class AddChargeForm {
    private String email;
    private String password;
    private Charge charge;
}
