package com.fraserlint.invoice_system.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "sanitary_bin_invoices")
@Data
public class SanitaryBinInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private double expense;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private LocalDate date;

    // Calculated field for profit
    public double getProfit() {
        return expense - cost;
    }
}
