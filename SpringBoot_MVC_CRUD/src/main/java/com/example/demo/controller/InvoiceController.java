package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	// url: http://localhost:9089/invoice/

	@GetMapping("/")
	public String showHomePage() {
		return "homepage";
	}
	
	@GetMapping("/register")
	public String showRegister() {
		return "registerInvoicePage";
	}

	@PostMapping("/save")
	public String saveInvoice(@ModelAttribute Invoice invoice, Model model) {

		Long id = invoiceService.saveInvoice(invoice).getId();
		String message = "Record with id : '" + id + "' is saved successfully !";
		model.addAttribute("message", message);
		return "registerInvoicePage";
	}

	@GetMapping("/getAllInvoices")
	public String getAllInvoices(@RequestParam(required = false) String message,Model model) {
		List<Invoice> invoices = invoiceService.getAllInvoices();
		model.addAttribute("list", invoices);
		model.addAttribute("message", message);
		return "allInvoicesPage";
	}

	@GetMapping("/edit")
	public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Long id) {

		Invoice invoice = invoiceService.getInvoiceById(id);
		model.addAttribute("invoice", invoice);
		return "editInvoicePage";

	}

	@PostMapping("/update")
	public String updateInvoice(@ModelAttribute Invoice invoice, RedirectAttributes attributes) {
		invoiceService.updateInvoice(invoice);
		Long id = invoice.getId();
		attributes.addAttribute("message", "Invoice with id: '" + id + "' is updated successfully !");
		return "redirect:getAllInvoices";
	}

	@GetMapping("/delete")
	public String deleteInvoice(@RequestParam Long id, RedirectAttributes attributes) {

		invoiceService.deleteInvoiceById(id);
		attributes.addAttribute("message", "Invoice with Id : '" + id + "' is removed successfully!");

		return "redirect:getAllInvoices";
	}
}
