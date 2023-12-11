package com.SICOMPA.backendSICOMPA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "comunidad")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String name;
    private String address;
    private int total_m2;
    private int storage_m2;
    private int parking_m2;
    private int total_storage_units;
    private int total_parking_units;
}
