package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Invoice;

public interface InvoiceRepository  extends CrudRepository<Invoice, Long>{

}
