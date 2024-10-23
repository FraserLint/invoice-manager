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
    public double getTotalForWeek(String startDate) {
        // Parse the incoming string into LocalDate
        LocalDate parsedStartDate = LocalDate.parse(startDate);

        // Work out the start and end of the week
        LocalDate startOfWeek = parsedStartDate.with(DayOfWeek.MONDAY); // Start of the week (Monday)
        LocalDate endOfWeek = parsedStartDate.with(DayOfWeek.SUNDAY);   // End of the week (Sunday)

        // Fetch the invoices between start and end of the week
        List<SanitaryBinInvoice> weeklyInvoices = sanitaryBinInvoiceRepository.findByDateBetween(startOfWeek, endOfWeek);

        // Calculate and return the total amount for that week
        return weeklyInvoices.stream().mapToDouble(SanitaryBinInvoice::getProfit).sum();
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
