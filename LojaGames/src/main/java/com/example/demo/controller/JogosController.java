package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.demo.model.Jogos;

import com.example.demo.repository.Jogosrepository;



@RestController
@RequestMapping("/jogos") // qual RI essa classe será acessada, neste caso = /postagens
@CrossOrigin("*") //aceita requisições de qualquer origem
public class JogosController {
	
	@Autowired //injeção de dependência
	private Jogosrepository repository;
	
	@GetMapping //Busca tudo
	public ResponseEntity<List<Jogos>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}") //busca por ID
	public ResponseEntity<Jogos> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Jogos>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Jogos> post (@RequestBody Jogos jogos){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogos));
	}
	
	@PutMapping
	public ResponseEntity<Jogos> put (@RequestBody Jogos jogos){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(jogos));
	}
	
	
	@DeleteMapping ("/{id}") 
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
	
	//new
	
	@GetMapping(value = "/maior") 	public ResponseEntity<List<Jogos>> findAllMaior(){ 		
		return ResponseEntity.ok(repository.findAllMaior()); 	}   
	
	@GetMapping(value = "/ordem")    	public ResponseEntity<List<Jogos>> anosDesc(){    		
		return ResponseEntity.ok(repository.anosDesc());    	}    
	
	@GetMapping(value = "/intervalo")    	public ResponseEntity<List<Jogos>> anosIntervalos(){    		
		return ResponseEntity.ok(repository.anosIntervalos());    	}    
	
	@GetMapping(value = "/asc")    	public ResponseEntity<List<Jogos>> anosAsc(){
   		return ResponseEntity.ok(repository.anosAsc());
   	}

	
	@GetMapping(value = "/pesquisa")    	public ResponseEntity<List<Jogos>> Pesq(){
   		return ResponseEntity.ok(repository.PesqA());
   	}

	
	
	

}
