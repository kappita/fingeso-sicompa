package com.SICOMPA.backendSICOMPA.Responses;

import com.SICOMPA.backendSICOMPA.Entity.Resident;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResidentWithQuota {
    private Resident resident;
    private QuotaResponse quota;

}
