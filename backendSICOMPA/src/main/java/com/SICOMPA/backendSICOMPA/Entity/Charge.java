package com.SICOMPA.backendSICOMPA.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Table(name = "gasto")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String description;
    private int amount;
    private int dues;
    private LocalDate creation_date;
    private Long community_id;
}
