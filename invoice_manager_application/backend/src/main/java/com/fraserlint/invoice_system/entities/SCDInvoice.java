package com.fraserlint.invoice_system.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "scd_invoices")
@Data
public class SCDInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDate date;
}
