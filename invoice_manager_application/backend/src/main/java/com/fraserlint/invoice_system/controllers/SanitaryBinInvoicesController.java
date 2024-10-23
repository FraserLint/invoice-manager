package com.fraserlint.invoice_system.controllers;

import com.fraserlint.invoice_system.entities.SanitaryBinInvoice;
import com.fraserlint.invoice_system.services.SanitaryBinInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sanitary-bin-invoices")
public class SanitaryBinInvoicesController {
    @Autowired
    private SanitaryBinInvoiceService sanitaryBinInvoiceService;

    @PostMapping("/add")
    public SanitaryBinInvoice addInvoice(@RequestBody SanitaryBinInvoice invoice) {
        return sanitaryBinInvoiceService.addInvoice(invoice);
    }

    @GetMapping("/tax-year/{year}")
    public List<SanitaryBinInvoice> getInvoicesForTaxYear(@PathVariable int year) {
        return sanitaryBinInvoiceService.getInvoicesForTaxYear(year);
    }

    @GetMapping("/week")
    public double getTotalForWeek(@RequestParam String startDate) {
        return sanitaryBinInvoiceService.getTotalForWeek(startDate);
    }

    @GetMapping("/profit")
    public List<Object[]> calculateProfitPerCompany() {
        return sanitaryBinInvoiceService.calculateProfitPerCompany();
    }

    @GetMapping("/profit/tax-year/{year}")
    public double getTotalProfitForTaxYear(@PathVariable int year) {
        return sanitaryBinInvoiceService.getTotalProfitForYear(year);
    }
}
