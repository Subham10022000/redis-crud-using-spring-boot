package com.redis1.rediscache.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis1.rediscache.customexception.InvoiceNotFoundException;
import com.redis1.rediscache.entity.Invoice;
import com.redis1.rediscache.repo.InvoiceRepository;
import com.redis1.rediscache.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;

	@Override
	public Invoice saveInvoice(Invoice inv) {
		return invoiceRepository.save(inv);
	}

	@Override
	@CachePut(value = "invoice", key = "#invId")
	public Invoice updateInvoice(Invoice inv, Integer invId) {
		Invoice invoice = invoiceRepository.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
		invoice.setInvAmount(inv.getInvAmount());
		invoice.setInvName(inv.getInvName());
		return invoiceRepository.save(invoice);
	}

	@Override
	@CacheEvict(value = "Invoice", key = "#invId")
	public void deleteInvoice(Integer invId) {
		Invoice invoice = invoiceRepository.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice not found for deletion"));
		invoiceRepository.delete(invoice);

	}

	@Override
	@Cacheable(value = "Invoice", key = "#invId")

	public Invoice getOneId(Integer invId) {
		Invoice invoice = invoiceRepository.findById(invId)
				.orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
		return invoice;

	}

	@Override
	@Cacheable(value = "Invoice")
	public List<Invoice> getAllInvoice() {

		return invoiceRepository.findAll();
	}

}
