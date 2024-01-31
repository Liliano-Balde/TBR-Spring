package com.lbg.TBR.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.TBR.domain.PropertiesForSale;
import com.lbg.TBR.services.PropertiesForSaleService;

@RestController
@RequestMapping("/PSale")
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

}
