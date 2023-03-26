package com.redis1.rediscache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis1.rediscache.entity.Invoice;
import com.redis1.rediscache.service.InvoiceService;

@RestController // Spring RestController annotation is used to create RESTful web services using
				// Spring MVC. Spring RestController takes care of mapping request data to the
				// defined request handler method. Once response body is generated from the
				// handler method, it converts it to JSON or XML response.
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	InvoiceService invoiceService;
	
	@PostMapping("/saveInv")
	public Invoice saveInvoice(@RequestBody Invoice inv) {
		
		return invoiceService.saveInvoice(inv);
	}
	
	@PutMapping("/modify/{id}")
	public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Integer Id) {
		return invoiceService.updateInvoice(inv, Id);
		
	}
	@GetMapping("/allInv")
	  public ResponseEntity<List<Invoice>> getAllInvoices(){
		  return ResponseEntity.ok(invoiceService.getAllInvoice());
	  }
	
	 @GetMapping("/getOne/{id}")
	    public Invoice getOneId(@PathVariable Integer id) {
	       return invoiceService.getOneId(id);
	 }
	 @DeleteMapping("/delete/{id}")
	    public String deleteInvoice(@PathVariable Integer id) {
	       invoiceService.deleteInvoice(id);
	       return "Employee with id: "+id+ " Deleted !";
	 }
	
}
