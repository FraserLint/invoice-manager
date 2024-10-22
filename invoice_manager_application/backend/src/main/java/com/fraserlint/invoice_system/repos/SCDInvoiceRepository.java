package com.fraserlint.invoice_system.repos;

import com.fraserlint.invoice_system.entities.SCDInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SCDInvoiceRepository extends JpaRepository<SCDInvoice, Long> {
    // Find invoices by date range
    List<SCDInvoice> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
