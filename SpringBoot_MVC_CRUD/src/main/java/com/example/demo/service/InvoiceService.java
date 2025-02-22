package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Invoice;

public interface InvoiceService {

	//abstract method to implement by implementation classes
	public Invoice saveInvoice(Invoice invoice);
	public List<Invoice> getAllInvoices();
	public Invoice getInvoiceById(Long id);
	public void deleteInvoiceById(Long id);
	public void updateInvoice(Invoice invoice);
}
