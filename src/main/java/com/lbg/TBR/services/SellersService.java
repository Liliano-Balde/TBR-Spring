package com.lbg.TBR.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.TBR.domain.Sellers;
import com.lbg.TBR.repos.SellersRepo;

@Service
public class SellersService {

	private SellersRepo repo;

	public SellersService(SellersRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Sellers> createSellers(Sellers newSellers) {
		Sellers created = this.repo.save(newSellers);
		return new ResponseEntity<Sellers>(created, HttpStatus.CREATED);
	}

	public List<Sellers> getSellers() {
		return this.repo.findAll();
	}

	public ResponseEntity<Sellers> getSellers(int id) {
		Optional<Sellers> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Sellers>(HttpStatus.NOT_FOUND);
		}
		Sellers body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deleteSellers(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public ResponseEntity<Sellers> update(int id, Sellers newSellers) {
		Optional<Sellers> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Sellers existing = found.get();
		if (newSellers.getFirstName() != null) {
			existing.setFirstName(newSellers.getFirstName());
		}
		if (newSellers.getLastName() != null) {
			existing.setLastName(newSellers.getLastName());
		}
		if (newSellers.getAddress() != null) {
			existing.setAddress(newSellers.getAddress());
		}
		if (newSellers.getPostcode() != null) {
			existing.setPostcode(newSellers.getPostcode());
		}
		if (newSellers.getPhoneNumber() != null) {
			existing.setPhoneNumber(newSellers.getPhoneNumber());
		}
		Sellers updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

}
