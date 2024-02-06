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

//delete and update controls to be assessed and added

import com.lbg.TBR.domain.Sellers;
import com.lbg.TBR.services.SellersService;

@RestController
@RequestMapping("/Sellers")
@CrossOrigin

public class SellersController {

	private SellersService service;

	public SellersController(SellersService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Sellers> createSellers(@RequestBody Sellers newSeller) {
		return this.service.createSellers(newSeller);
	}

	@GetMapping("/get")
	public List<Sellers> getSellers() {
		return this.service.getSellers();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Sellers> getSellers(@PathVariable int id) {
		return this.service.getSellers(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteSellers(@PathVariable int id) {
		return this.service.deleteSellers(id);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Sellers> editSellers(@PathVariable int id, @RequestBody Sellers newSellers) {
		return this.service.editSellers(id, newSellers);
	}
}
