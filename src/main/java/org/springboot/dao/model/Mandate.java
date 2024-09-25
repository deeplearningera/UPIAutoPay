package org.springboot.dao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Mandate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mandateId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false, length = 50)
    private String frequency;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "bank_details_id")
    private BankDetails bankDetails;
}

