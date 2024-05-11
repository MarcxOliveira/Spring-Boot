package br.edu.senaisp.Pastel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Pastel.model.Pastel;
import br.edu.senaisp.Pastel.repository.PastelRepository;

@RestController
@RequestMapping ("/pastel")
public class PastelController {
	
	@Autowired
	PastelRepository repository;
	
	@GetMapping
	public List<Pastel> listALL() {
		return repository.list();
	};
	
	@GetMapping ("/{id}")
	public Pastel findById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@PostMapping
	public List<Pastel> insert(@RequestBody Pastel pastel){
		return repository.insert(pastel);
	}
	
	@PutMapping ("/{id}")
	public Pastel altera(@RequestBody Pastel pastel, @PathVariable int id){
		repository.update(pastel, id);
		return findById(id);
	}
	
	@DeleteMapping ("/{id}")
	public void deleta (@PathVariable int id) {
		repository.delete(id);
	}
	
}
