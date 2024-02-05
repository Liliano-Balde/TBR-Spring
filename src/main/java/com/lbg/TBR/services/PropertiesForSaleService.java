package com.lbg.TBR.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.TBR.domain.PropertiesForSale;
import com.lbg.TBR.repos.PropertiesForSaleRepo;

@Service
public class PropertiesForSaleService {

	private PropertiesForSaleRepo repo;

	public PropertiesForSaleService(PropertiesForSaleRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<PropertiesForSale> createPropertiesForSale(PropertiesForSale newPropertiesForSale) {
		PropertiesForSale created = this.repo.save(newPropertiesForSale);
		return new ResponseEntity<PropertiesForSale>(created, HttpStatus.CREATED);
	}

	public List<PropertiesForSale> getPropertiesForSale() {
		return this.repo.findAll();
	}

	public ResponseEntity<PropertiesForSale> getPropertiesForSale(int id) {
		Optional<PropertiesForSale> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<PropertiesForSale>(HttpStatus.NOT_FOUND);
		}
		PropertiesForSale body = found.get();
		return ResponseEntity.ok(body);
	}

	public boolean deletePropertiesForSale(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public ResponseEntity<PropertiesForSale> editPropertiesForSale(int id, PropertiesForSale newPropertiesForSale) {
		Optional<PropertiesForSale> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<PropertiesForSale>(HttpStatus.NOT_FOUND);
		}
		PropertiesForSale existing = found.get();

		if (newPropertiesForSale.getType() != null) {
			existing.setType(newPropertiesForSale.getType());
		}
		if (newPropertiesForSale.getPrice() != 0) {
			existing.setPrice(newPropertiesForSale.getPrice());
		}
		if (newPropertiesForSale.getBedrooms() != 0) {
			existing.setBedrooms(newPropertiesForSale.getBedrooms());
		}
		if (newPropertiesForSale.getBathrooms() != 0) {
			existing.setBathrooms(newPropertiesForSale.getBathrooms());
		}
		if (newPropertiesForSale.getGarden() != null) {
			existing.setGarden(newPropertiesForSale.getGarden());
		}
		if (newPropertiesForSale.getAddress() != null) {
			existing.setAddress(newPropertiesForSale.getAddress());
		}
		if (newPropertiesForSale.getPostcode() != null) {
			existing.setPostcode(newPropertiesForSale.getPostcode());
		}
		PropertiesForSale edited = this.repo.save(existing);

		return ResponseEntity.ok(edited);
	}

}
