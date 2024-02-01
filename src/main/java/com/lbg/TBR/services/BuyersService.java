package com.lbg.TBR.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.TBR.domain.Buyers;
import com.lbg.TBR.repos.BuyersRepo;

@Service
public class BuyersService {

	private BuyersRepo repo;

	public BuyersService(BuyersRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Buyers> createBuyers(Buyers newBuyers) {
		Buyers created = this.repo.save(newBuyers);
		return new ResponseEntity<Buyers>(created, HttpStatus.CREATED);
	}

	public List<Buyers> getBuyers() {
		return this.repo.findAll();
	}

	public ResponseEntity<Buyers> getBuyers(int id) {
		Optional<Buyers> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Buyers>(HttpStatus.NOT_FOUND);
		}
		Buyers body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deleteBuyers(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
