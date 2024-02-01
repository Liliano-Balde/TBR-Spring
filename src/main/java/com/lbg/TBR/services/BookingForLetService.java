package com.lbg.TBR.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.TBR.domain.BookingForLet;
import com.lbg.TBR.repos.BookingForLetRepo;

@Service
public class BookingForLetService {

	private BookingForLetRepo repo;

	public BookingForLetService(BookingForLetRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<BookingForLet> createBookingForLet(BookingForLet newBookingForLet) {
		BookingForLet created = this.repo.save(newBookingForLet);
		return new ResponseEntity<BookingForLet>(created, HttpStatus.CREATED);
	}

	public List<BookingForLet> getBookingForLet() {
		return this.repo.findAll();
	}

	public ResponseEntity<BookingForLet> getBookingForLet(int id) {
		Optional<BookingForLet> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<BookingForLet>(HttpStatus.NOT_FOUND);
		}
		BookingForLet body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deleteBookingForLet(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
