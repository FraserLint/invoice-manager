package com.fraserlint.invoice_system.controllers;

import com.fraserlint.invoice_system.entities.SCDInvoice;
import com.fraserlint.invoice_system.services.SCDInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scd-invoices")
public class SCDInvoiceController {

    @Autowired
    private SCDInvoiceService scdInvoiceService;

    @PostMapping("/add")
    public SCDInvoice addInvoice(@RequestBody SCDInvoice invoice) {
        return scdInvoiceService.addInvoice(invoice);
    }

    @GetMapping("/tax-year/{year}")
    public List<SCDInvoice> getInvoicesForTaxYear(@PathVariable int year) {
        return scdInvoiceService.getInvoicesForTaxYear((year));
    }

    @GetMapping("/total/tax-year/{year}")
    public double getTotalAmountForTaxYear(@PathVariable int year) {
        return scdInvoiceService.getTotalAmountForTaxYear(year);
    }

    @GetMapping("/week")
    public double getTotalForWeek(@RequestParam String startDate) {
        return scdInvoiceService.getTotalForWeek(startDate);
    }
}
