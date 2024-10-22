package com.fraserlint.invoice_system.services;

import com.fraserlint.invoice_system.entities.SanitaryBinInvoice;
import com.fraserlint.invoice_system.repos.SanitaryBinInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class SanitaryBinInvoiceService {

    @Autowired
    private SanitaryBinInvoiceRepository sanitaryBinInvoiceRepository;

    // Add a new invoice
    public SanitaryBinInvoice addInvoice(SanitaryBinInvoice invoice){
        return sanitaryBinInvoiceRepository.save(invoice);
    }

    // Get all invoices for the tax year
    public List<SanitaryBinInvoice> getInvoicesForTaxYear(int year) {
        LocalDate startDate = LocalDate.of(year, Month.APRIL, 6);
        LocalDate endDate = LocalDate.of(year + 1, Month.APRIL, 5);
        return sanitaryBinInvoiceRepository.findByDateBetween(startDate, endDate);
    }

    // Calculate profit for each company
    public List<Object[]> calculateProfitPerCompany() {
        return sanitaryBinInvoiceRepository.calculateProfitPerCompany();
    }

    // Get total amount for a specified week
    public double getTotalForWeek(LocalDate startDate) {
        LocalDate startOfWeek = startDate.with(DayOfWeek.MONDAY); // Calculate the start of the week (Monday)
        LocalDate endOfWeek = startOfWeek.with(DayOfWeek.SUNDAY);   // Calculate the end of the week (Sunday)
        List<SanitaryBinInvoice> weeklyInvoices = sanitaryBinInvoiceRepository.findByDateBetween(startOfWeek, endOfWeek);
        return weeklyInvoices.stream().mapToDouble(SanitaryBinInvoice::getExpense).sum();
    }

    // Calculate profit for a tax year
    public double getTotalProfitForYear(int year) {
        LocalDate startDate = LocalDate.of(year, Month.APRIL, 6);
        LocalDate endDate = LocalDate.of(year + 1, Month.APRIL, 5);
        return sanitaryBinInvoiceRepository.findByDateBetween(startDate, endDate)
                .stream()
                .mapToDouble(SanitaryBinInvoice::getProfit)
                .sum();
    }
}
