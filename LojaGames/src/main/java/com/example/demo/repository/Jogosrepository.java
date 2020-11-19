package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Jogos;


@Repository
public interface Jogosrepository extends JpaRepository<Jogos, Long>{
	
	public List<Jogos> findAllByTituloContainingIgnoreCase (String titulo);
	
	
	@Query(value = "select*from jogos where ano > 2011", nativeQuery = true)
	List<Jogos> findAllMaior();
	
	@Query(value = "select*from jogos ORDER BY ano DESC", nativeQuery = true)
	List<Jogos> anosDesc();
	
	@Query(value = "select*from jogos ORDER BY ano ASC", nativeQuery = true)
	List<Jogos> anosAsc();
	
	@Query(value = "select*from jogos where ano >= 2011 and ano <=2013", nativeQuery = true)
	List<Jogos> anosIntervalos();
	
	@Query(value = "select*from jogos where titulo like '%Direito' ", nativeQuery = true)
	List<Jogos> PesqA();
	
	
	
	

}
