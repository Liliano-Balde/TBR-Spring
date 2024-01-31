package com.lbg.TBR.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.TBR.domain.PropertiesToLet;
import com.lbg.TBR.services.PropertiesToLetService;

@RestController
@RequestMapping("/PLet")

public class PropertiesToLetController {

	private PropertiesToLetService service;

	public PropertiesToLetController(PropertiesToLetService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<PropertiesToLet> createPropertiesToLet(@RequestBody PropertiesToLet newPropertiesToLet) {
		return this.service.createPropertiesToLet(newPropertiesToLet);
	}

	@GetMapping("/get")
	public List<PropertiesToLet> getPropertiesToLet() {
		return this.service.getPropertiesToLet();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PropertiesToLet> getPropertiesToLet(@PathVariable int id) {
		return this.service.getPropertiesToLet(id);
	}

}
