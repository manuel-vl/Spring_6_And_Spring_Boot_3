package com.manuelvl.curso.springboot.app.springbootfacturaciondependencyinjection.controllers;

import com.manuelvl.curso.springboot.app.springbootfacturaciondependencyinjection.models.Client;
import com.manuelvl.curso.springboot.app.springbootfacturaciondependencyinjection.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    // Invoice es un componente de Spring
    @Autowired
    private Invoice invoice;

    @GetMapping("")
    public Invoice show(){
        Invoice i=new Invoice();
        Client c=new Client();

        c.setLastname(invoice.getClient().getLastname());
        c.setName(invoice.getClient().getName());
        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItemInvoices(invoice.getItemInvoices());

        return i;
    }
}
