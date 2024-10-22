package com.fraserlint.invoice_system.repos;

import com.fraserlint.invoice_system.entities.SanitaryBinInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SanitaryBinInvoiceRepository extends JpaRepository<SanitaryBinInvoice, Long> {
    // Find invoices by date range
    List<SanitaryBinInvoice> findByDateBetween(LocalDate startDate, LocalDate endDate);

    // Calculate total profit per company - custom SQL query
    @Query("SELECT s.companyName, SUM(s.expense - s.cost) FROM SanitaryBinInvoice s GROUP BY s.companyName")
    List<Object[]> calculateProfitPerCompany();
}
