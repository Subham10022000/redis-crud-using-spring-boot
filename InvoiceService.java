package com.redis1.rediscache.service;

import java.util.List;

import com.redis1.rediscache.entity.Invoice;

public interface InvoiceService {
	
	public Invoice saveInvoice(Invoice inv);
	public Invoice updateInvoice(Invoice inv, Integer invId);
	public void deleteInvoice(Integer invId);
	public Invoice getOneId(Integer invId);
	public List<Invoice> getAllInvoice();

}
