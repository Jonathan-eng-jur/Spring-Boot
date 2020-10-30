package com.example.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class HelloWordModel {
//MVC -- Model (tables)
//MVC -- View (tables)
//MVC -- Controller (cerébro, endereçamento)
//JPA - é a interface

	//CRIANDO ID, AUTO INCREMENTAVEL
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	
	@Column	
	private String nomeServico;
	
	@Column
	@JsonFormat (pattern="yyyy-mm-dd") //usado para formatar a data, junto com a imprtaçãod o Date do JAVA.UTIL
	private Date data;

	
	//Getters e Setters - PARA LIBERAR A VISUALIZAÇÃO- PARA DIVULGAR OS ATRIBUTOS PRIVADOS, PARA PÚBLICO
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
	
	
	



}
