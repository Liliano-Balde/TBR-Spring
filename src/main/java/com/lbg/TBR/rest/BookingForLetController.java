package com.lbg.TBR.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.TBR.domain.BookingForLet;
import com.lbg.TBR.services.BookingForLetService;

@RestController
@RequestMapping("/BLet")
@CrossOrigin
public class BookingForLetController {

	private BookingForLetService service;

	public BookingForLetController(BookingForLetService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<BookingForLet> createBookingForLet(@RequestBody BookingForLet newBookingForLet) {
		return this.service.createBookingForLet(newBookingForLet);
	}

	@GetMapping("/get")
	public List<BookingForLet> getBookingForLet() {
		return this.service.getBookingForLet();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<BookingForLet> getBookingForLet(@PathVariable int id) {
		return this.service.getBookingForLet(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteBookingForLet(@PathVariable int id) {
		return this.service.deleteBookingForLet(id);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<BookingForLet> editBookingForLet(@PathVariable int id,
			@RequestBody BookingForLet newBookingForLet) {
		return this.service.editBookingForLet(id, newBookingForLet);
	}
}
