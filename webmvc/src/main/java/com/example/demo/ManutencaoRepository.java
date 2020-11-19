package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
															//<TABELAS , tipo de ID>
import org.springframework.stereotype.Repository;

//faz a condução dos dados da tabela ao banco, serve para persistir os dados no banco
//para fazer os gets e posts vc precisa persistir
@Repository
public interface ManutencaoRepository extends JpaRepository <ManutencaoTable, Long> {



	List<ManutencaoTable> findByNome(String nome);

	
	Optional<ManutencaoTable> findByNomeAndCategoria(String nome, String categoria);






	

}

