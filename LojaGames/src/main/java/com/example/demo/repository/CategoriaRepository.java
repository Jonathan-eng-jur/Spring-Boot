package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	//pega tudo que a pessoa digita e ignora o maisculo e minusculo
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);
	
	
	@Query(value = "select*from tb_tema where descricao like '%Leis%' ", nativeQuery = true)
	List<Categoria> Pesq();

}
