package com.SICOMPA.backendSICOMPA.Forms;

import com.SICOMPA.backendSICOMPA.Entity.Community;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCommunityForm {
    private String email;
    private String password;
    private Community community;
}
