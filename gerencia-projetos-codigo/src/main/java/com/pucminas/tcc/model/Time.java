package com.pucminas.tcc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Time {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne 
	@JoinColumn(name = "projetoId")
	private Projeto projeto;
	
	@OneToOne 
	@JoinColumn(name = "gerenteProjetoId")
	private Usuario gerenteProjeto;
	
	@OneToOne 
	@JoinColumn(name = "funcionalId")
	private Usuario funcional;
	
	@OneToOne 
	@JoinColumn(name = "arquitetoId")
	private Usuario arquiteto;
	
	@OneToOne 
	@JoinColumn(name = "desenvolvedor1Id")
	private Usuario desenvolvedor1;
	
	@OneToOne 
	@JoinColumn(name = "desenvolvedor2Id")
	private Usuario desenvolvedor2;
	
	@OneToOne 
	@JoinColumn(name = "arquitetoQAId")
	private Usuario arquitetoQA;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Usuario getGerenteProjeto() {
		return gerenteProjeto;
	}

	public void setGerenteProjeto(Usuario gerenteProjeto) {
		this.gerenteProjeto = gerenteProjeto;
	}

	public Usuario getFuncional() {
		return funcional;
	}

	public void setFuncional(Usuario funcional) {
		this.funcional = funcional;
	}

	public Usuario getArquiteto() {
		return arquiteto;
	}

	public void setArquiteto(Usuario arquiteto) {
		this.arquiteto = arquiteto;
	}

	public Usuario getDesenvolvedor1() {
		return desenvolvedor1;
	}

	public void setDesenvolvedor1(Usuario desenvolvedor1) {
		this.desenvolvedor1 = desenvolvedor1;
	}

	public Usuario getDesenvolvedor2() {
		return desenvolvedor2;
	}

	public void setDesenvolvedor2(Usuario desenvolvedor2) {
		this.desenvolvedor2 = desenvolvedor2;
	}

	public Usuario getArquitetoQA() {
		return arquitetoQA;
	}

	public void setArquitetoQA(Usuario arquitetoQA) {
		this.arquitetoQA = arquitetoQA;
	}
	
	
	
}
