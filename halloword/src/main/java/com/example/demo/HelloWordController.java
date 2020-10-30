package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//ponto no endereço do site
@RequestMapping("/hello")
@RestController
public class HelloWordController {
	
	
@GetMapping("/word")
	public String hello1() {
	
	return "PERSISTÊNCIA & MENTALIDADE DE CRESCIMENTO & ATENÇÃO AOS DETALHES";
}

@GetMapping("/word2")
public String hello2() {

return "APREDER A UTILIZAR O SPRING-BOOT & MySQL";
}

//www.seusite.com.br/hello/get1

//injeção
	
	

	
	
}
