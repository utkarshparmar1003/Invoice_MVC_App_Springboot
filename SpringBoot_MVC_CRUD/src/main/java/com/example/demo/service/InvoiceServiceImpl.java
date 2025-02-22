package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository repository;
	
	@Override
	public Invoice saveInvoice(Invoice invoice) {
		
		return repository.save(invoice);
	}

	@Override
	public List<Invoice> getAllInvoices() {
		
		return (List<Invoice>) repository.findAll();
	}

	@Override
	public Invoice getInvoiceById(Long id) {
		Optional<Invoice> invoice=repository.findById(id);
		return invoice.get();
	}

	@Override
	public void deleteInvoiceById(Long id) {
		repository.delete(getInvoiceById(id));
		
	}

	@Override
	public void updateInvoice(Invoice invoice) {
	repository.save(invoice);
		
	}

}
