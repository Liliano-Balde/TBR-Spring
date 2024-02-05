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

}
