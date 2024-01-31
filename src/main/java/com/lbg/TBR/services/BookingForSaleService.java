package com.lbg.TBR.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.TBR.domain.BookingForSale;
import com.lbg.TBR.repos.BookingForSaleRepo;

@Service
public class BookingForSaleService {

	private BookingForSaleRepo repo;

	public BookingForSaleService(BookingForSaleRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<BookingForSale> createBookingForSale(BookingForSale newBookingForSale) {
		BookingForSale created = this.repo.save(newBookingForSale);
		return new ResponseEntity<BookingForSale>(created, HttpStatus.CREATED);
	}

	public List<BookingForSale> getBookingForSale() {
		return this.repo.findAll();
	}

	public ResponseEntity<BookingForSale> getBookingForSale(int id) {
		Optional<BookingForSale> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<BookingForSale>(HttpStatus.NOT_FOUND);
		}
		BookingForSale body = found.get();
		return ResponseEntity.ok(body);
	}

}
