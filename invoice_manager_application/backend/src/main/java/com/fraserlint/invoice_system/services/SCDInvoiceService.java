package com.fraserlint.invoice_system.services;

import com.fraserlint.invoice_system.entities.SCDInvoice;
import com.fraserlint.invoice_system.repos.SCDInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class SCDInvoiceService {

    @Autowired
    private SCDInvoiceRepository scdInvoiceRepository;

    // Add a new invoice
    public SCDInvoice addInvoice(SCDInvoice invoice) {
        return scdInvoiceRepository.save(invoice);
    }

    // Get all invoices for a tax year
    public List<SCDInvoice> getInvoicesForTaxYear(int year) {
        LocalDate startDate = LocalDate.of(year, Month.APRIL, 6);
        LocalDate endDate = LocalDate.of(year + 1, Month.APRIL, 5);
        return scdInvoiceRepository.findByDateBetween(startDate, endDate);
    }

    // Get total amount for a specified week
    public double getTotalForWeek(LocalDate startDate) {
        LocalDate startOfWeek = startDate.with(DayOfWeek.MONDAY); // Calculate the start of the week (Monday)
        LocalDate endOfWeek = startDate.with(DayOfWeek.SUNDAY);   // Calculate the end of the week (Sunday)
        List<SCDInvoice> weeklyInvoices = scdInvoiceRepository.findByDateBetween(startOfWeek, endOfWeek);
        return weeklyInvoices.stream().mapToDouble(SCDInvoice::getAmount).sum();
    }
}
