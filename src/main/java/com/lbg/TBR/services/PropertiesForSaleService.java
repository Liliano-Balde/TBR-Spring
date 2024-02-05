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

}
