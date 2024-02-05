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

import com.lbg.TBR.domain.PropertiesForSale;
import com.lbg.TBR.services.PropertiesForSaleService;

@RestController
@RequestMapping("/PSale")
@CrossOrigin
public class PropertiesForSaleController {

	private PropertiesForSaleService service;

	public PropertiesForSaleController(PropertiesForSaleService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<PropertiesForSale> createPropertiesForSale(
			@RequestBody PropertiesForSale newPropertiesForSale) {
		return this.service.createPropertiesForSale(newPropertiesForSale);
	}

	@GetMapping("/get")
	public List<PropertiesForSale> getPropertiesForSale() {
		return this.service.getPropertiesForSale();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PropertiesForSale> getPropertiesForSale(@PathVariable int id) {
		return this.service.getPropertiesForSale(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deletePropertiesForSale(@PathVariable int id) {
		return this.service.deletePropertiesForSale(id);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<PropertiesForSale> editPropertiesForSale(@PathVariable int id,
			@RequestBody PropertiesForSale newPropertiesForSale) {
		return this.service.editPropertiesForSale(id, newPropertiesForSale);
	}

}
