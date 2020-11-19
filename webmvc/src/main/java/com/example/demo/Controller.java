package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;

	@RestController	
	@RequestMapping ("/test")//IMPLEMENTANDO UM MODULO DO JAVA, PARA HABILITAR UM 
	public class Controller implements WebMvcConfigurer {

		public void addViewControllers(ViewControllerRegistry index) {
			index.addViewController("/").setViewName("forward:/index.html");
		}

	
	/*PARA ACESSAR A PÁGINA PELO LOCALHOST:8080
	public void addViewControllers (ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}*/
	
	//injetar o repositório=repository
	@Autowired
	private ManutencaoRepository repository;
	
	@Autowired
	private Services service;

	//
	@GetMapping("/teste")
	    public ResponseEntity<List<ManutencaoTable>> listAllItens() {
	        List<ManutencaoTable> itens= service.findAllItens();
	        if(itens.isEmpty()){// SE ITENS ESTIVEREM VAZIOS VAI RETORNAR UMA RESPOSTA
	            return new ResponseEntity<List<ManutencaoTable>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        } //SENÃO VAI DAR ESSA RESPOSTA
	        return new ResponseEntity<List<ManutencaoTable>>(itens, HttpStatus.ACCEPTED);
	    }

	
	
	//quatro métodos, get, post, put, delete
	//localhost:8080/manutencoes - PEGAR TUDO DA TABELA
	@GetMapping("/manutencoes")
	public List<ManutencaoTable> buscarTodos() {
		return repository.findAll();
	}
		
	/*PATH SERVE PARA PEGAR O PARÂMETRO
	@GetMapping("/manutencoes/{id}")
	public Optional<ManutencaoTable> buscarUm(@PathVariable Long id) {
		return repository.findById(id);
	}
	*/
	
	//deste jeito nao retornar erro
	@GetMapping("/manutencoes/id/{id}")
	public Optional<ManutencaoTable> buscarUm(@PathVariable Long id) {
		return repository.findById(id);
	}
		
//		APARECE NOT FOUND 404
	//@GetMapping("/manutencoes/id/{id}")
//		public ResponseEntity<ManutencaoTable> getById(@PathVariable long id){
//			return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
//					.orElse(ResponseEntity.notFound().build());
//		}

	
	
	
	
	//INSERIR UM NOVO OBJETO, NESTE CASO NA MESMA URL (LOCALHOST:8080/MANUTENCOES)
	@PostMapping("/manutencoes")
	public ManutencaoTable criar (@RequestBody ManutencaoTable objetinho) {
		repository.save(objetinho);
		return objetinho;
	}
	
	@PutMapping ("/manutencoes/{id}")
	public ManutencaoTable atualizar (@PathVariable Long id, @RequestBody ManutencaoTable objetinho) {
		objetinho.setId(id);
		repository.save(objetinho);
		return objetinho;
	}
	

	//new
		@GetMapping("/manutencoes/teste/{nome}")
		public List<ManutencaoTable> buscarPorNome(@PathVariable String nome) {
			return repository.findByNome(nome);
		}
		
	//new2
		@GetMapping("/manutencoes/{nome}/{categoria}")
		public Optional<ManutencaoTable> findByNomeAndCategoria(@PathVariable String nome, @PathVariable String categoria) {
			return repository.findByNomeAndCategoria(nome, categoria);
		}
		
		//delete
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}	

		
	
	
	/*@RestController
public class Controller implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
	
	@Autowired
	private ManutencaoRepository repository;

	//localhost:8080/manutencoes
	@GetMapping("/manutencoes")
	public List<ManutencaoTable> buscarTodos() {
		return repository.findAll();
	}
	
	//post é inserir, neste caso na mesma URL (localhost:8080/manutencoes)
	@PostMapping("/manutencoes")
	public ManutencaoTable criar(@RequestBody ManutencaoTable objetoManutencao) {
		repository.save(objetoManutencao);
		return objetoManutencao;
	}
*/
	
}


//CONTROLLER =  RESQUEST E GETMAPPING
//VIEW = FRONT