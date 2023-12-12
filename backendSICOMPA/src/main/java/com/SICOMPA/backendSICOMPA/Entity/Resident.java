package com.SICOMPA.backendSICOMPA.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "residente")
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private Long user_id;

    private Long community_id;
    private int used_m2;
    private int used_storage;
    private int used_parking;

}
