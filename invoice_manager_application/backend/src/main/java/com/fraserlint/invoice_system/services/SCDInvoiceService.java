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

// Get total amount for a tax year
    public double getTotalAmountForTaxYear(int year) {
        // Define the start and end date of the British tax year
        LocalDate startDate = LocalDate.of(year, Month.APRIL, 6);
        LocalDate endDate = LocalDate.of(year + 1, Month.APRIL, 5);

        // Fetch all invoices between the start and end date
        List<SCDInvoice> invoices = scdInvoiceRepository.findByDateBetween(startDate, endDate);

        // Calculate the total amount for the tax year
        return invoices.stream().mapToDouble(SCDInvoice::getAmount).sum();
    }


    // Get total amount for a specified week
    public double getTotalForWeek(String startDate) {
        // Parse the incoming string into LocalDate
        LocalDate parsedStartDate = LocalDate.parse(startDate);

        // Work out the start and end of the week
        LocalDate startOfWeek = parsedStartDate.with(DayOfWeek.MONDAY); // Start of the week (Monday)
        LocalDate endOfWeek = parsedStartDate.with(DayOfWeek.SUNDAY);   // End of the week (Sunday)

        // Fetch the invoices between start and end of the week
        List<SCDInvoice> weeklyInvoices = scdInvoiceRepository.findByDateBetween(startOfWeek, endOfWeek);

        // Calculate and return the total amount for that week
        return weeklyInvoices.stream().mapToDouble(SCDInvoice::getAmount).sum();
    }
}
