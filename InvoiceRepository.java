package com.redis1.rediscache.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redis1.rediscache.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
