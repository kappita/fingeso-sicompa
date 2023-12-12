package com.SICOMPA.backendSICOMPA.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Table(name = "comunidad")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private int amount;
    private Date creation_date;
    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;
    @OneToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;

}
