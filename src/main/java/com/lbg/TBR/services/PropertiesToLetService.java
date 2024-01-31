package com.lbg.TBR.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.TBR.domain.PropertiesToLet;
import com.lbg.TBR.repos.PropertiesToLetRepo;

@Service
public class PropertiesToLetService {

	private PropertiesToLetRepo repo;

	public PropertiesToLetService(PropertiesToLetRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<PropertiesToLet> createPropertiesToLet(PropertiesToLet newPropertiesToLet) {
		PropertiesToLet created = this.repo.save(newPropertiesToLet);
		return new ResponseEntity<PropertiesToLet>(created, HttpStatus.CREATED);
	}

	public List<PropertiesToLet> getPropertiesToLet() {
		return this.repo.findAll();
	}

	public ResponseEntity<PropertiesToLet> getPropertiesToLet(int id) {
		Optional<PropertiesToLet> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<PropertiesToLet>(HttpStatus.NOT_FOUND);
		}
		PropertiesToLet body = found.get();
		return ResponseEntity.ok(body);
	}

}
