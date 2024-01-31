package com.lbg.TBR.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.TBR.domain.Buyers;
import com.lbg.TBR.services.BuyersService;

@RestController
@RequestMapping("/Buyers")
@CrossOrigin
public class BuyersController {

	private BuyersService service;

	public BuyersController(BuyersService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Buyers> createBuyers(@RequestBody Buyers newBuyers) {
		return this.service.createBuyers(newBuyers);
	}

	@GetMapping("/get")
	public List<Buyers> getBuyers() {
		return this.service.getBuyers();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Buyers> getBuyers(@PathVariable int id) {
		return this.service.getBuyers(id);
	}

}
