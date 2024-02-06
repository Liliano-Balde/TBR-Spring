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

	public boolean deletePropertiesToLet(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public ResponseEntity<PropertiesToLet> editPropertiesToLet(int id, PropertiesToLet newPropertiesToLet) {
		Optional<PropertiesToLet> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<PropertiesToLet>(HttpStatus.NOT_FOUND);
		}
		PropertiesToLet existing = found.get();

		if (newPropertiesToLet.getType() != null) {
			existing.setType(newPropertiesToLet.getType());
		}
		if (newPropertiesToLet.getRent() != 0) {
			existing.setRent(newPropertiesToLet.getRent());
		}
		if (newPropertiesToLet.getBedrooms() != 0) {
			existing.setBedrooms(newPropertiesToLet.getBedrooms());
		}
		if (newPropertiesToLet.getBathrooms() != 0) {
			existing.setBathrooms(newPropertiesToLet.getBathrooms());
		}
		if (newPropertiesToLet.getGarden() != null) {
			existing.setGarden(newPropertiesToLet.getGarden());
		}
		if (newPropertiesToLet.getAddress() != null) {
			existing.setAddress(newPropertiesToLet.getAddress());
		}
		if (newPropertiesToLet.getPostcode() != null) {
			existing.setPostcode(newPropertiesToLet.getPostcode());
		}
		if (newPropertiesToLet.getPropertyStatus() != null) {
			existing.setPropertyStatus(newPropertiesToLet.getPropertyStatus());
		}
		PropertiesToLet edited = this.repo.save(existing);

		return ResponseEntity.ok(edited);
	}

}
