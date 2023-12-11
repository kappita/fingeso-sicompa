package com.SICOMPA.backendSICOMPA.Responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class QuotaResponse {
    private float resident_quota;
    private float community_quota;
    private float usage_percentage;
}
