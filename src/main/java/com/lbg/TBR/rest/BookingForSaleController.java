package com.lbg.TBR.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.TBR.domain.BookingForSale;
import com.lbg.TBR.services.BookingForSaleService;

@RestController
@RequestMapping("/BSale")
@CrossOrigin
public class BookingForSaleController {

	private BookingForSaleService service;

	public BookingForSaleController(BookingForSaleService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<BookingForSale> createBookingForSale(@RequestBody BookingForSale newBookingForSale) {
		return this.service.createBookingForSale(newBookingForSale);
	}

	@GetMapping("/get")
	public List<BookingForSale> getBookingForSale() {
		return this.service.getBookingForSale();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<BookingForSale> getBookingForSale(@PathVariable int id) {
		return this.service.getBookingForSale(id);
	}

}
