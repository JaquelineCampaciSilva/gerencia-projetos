package com.pucminas.tcc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.springframework.stereotype.Controller;

import com.pucminas.tcc.model.Projeto;
import com.pucminas.tcc.model.Time;
import com.pucminas.tcc.model.Usuario;
import com.pucminas.tcc.model.dao.ProjetoDAO;
import com.pucminas.tcc.model.dao.TimeDAO;
import com.pucminas.tcc.model.dao.UsuarioDAO;

@Controller(value = "configuraTimeBean")
@ManagedBean

public class ConfiguraTimeBean extends FacesBean{
	
	private boolean sucesso = false;
	
	private Projeto projeto = new Projeto();
	private List<Projeto> listaProjetos = new ArrayList<>();
	private ProjetoDAO projetoDAO = new ProjetoDAO();
	
	private Usuario funcional = new Usuario();
	private List<Usuario> listaFuncionais = new ArrayList<>();
	
	private Usuario gerenteProjeto = new Usuario();
	private List<Usuario> listaGerentes = new ArrayList<>();
	
	private Usuario arquiteto = new Usuario();
	private List<Usuario> listaArquitetos = new ArrayList<>();
	
	private Usuario desenvolvedor1 = new Usuario();
	private Usuario desenvolvedor2 = new Usuario();
	private List<Usuario> listaDesenvolvedores = new ArrayList<>();
	
	private Usuario arquitetoQA = new Usuario();
	private List<Usuario> listaArquitetosQA = new ArrayList<>();
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	private Time time = new Time();
	private TimeDAO timeDAO = new TimeDAO();
	
	public ConfiguraTimeBean() {
		listaProjetos = projetoDAO.buscarProjetos();
		listaFuncionais = usuarioDAO.buscarFuncionais();
		listaGerentes = usuarioDAO.buscarGerentes();
		listaArquitetos = usuarioDAO.buscarArquitetos();
		listaDesenvolvedores = usuarioDAO.buscarDesenvolvedores();
		listaArquitetosQA = usuarioDAO.buscarArquitetosQA();
	}
	
	public String voltar(){
		limparCampos();
        return "/home";
    }
	
	public void configurarTime() {
		if (verificaCampos(projeto, funcional, gerenteProjeto, arquiteto, desenvolvedor1, desenvolvedor2, arquitetoQA)) {
			time.setProjeto(projeto);
			time.setGerenteProjeto(gerenteProjeto);
			time.setFuncional(funcional);
			time.setArquiteto(arquiteto);
			time.setDesenvolvedor1(desenvolvedor1);
			time.setDesenvolvedor2(desenvolvedor2);
			time.setArquitetoQA(arquitetoQA);
			sucesso = timeDAO.configurarTime(time);
			if(sucesso) {
				mostrarMensagem("Time configurado com Sucesso!", null, FacesMessage.SEVERITY_INFO);
				limparCampos();
			}else {
				mostrarMensagem("Erro ao configurar o time do projeto!", "Contate o administrador!", FacesMessage.SEVERITY_ERROR);
			}

		}else {
			mostrarMensagem("Inserir todas as informações para configurar o time do projeto!", "Erro na configuração do time!", FacesMessage.SEVERITY_WARN);
		}
		
	}	
	
	private boolean verificaCampos(Projeto projeto, Usuario funcional, Usuario gerenteProjeto, Usuario arquiteto,
			Usuario desenvolvedor1, Usuario desenvolvedor2, Usuario arquitetoQA) {
		
		if(projeto == null
				|| funcional == null
				|| gerenteProjeto == null
				|| arquiteto == null
				|| desenvolvedor1 == null
				|| desenvolvedor2 == null
				|| arquitetoQA == null)
			return false;
		else
			return true;
	}

	private void limparCampos() {
		projeto = new Projeto();
		gerenteProjeto = new Usuario();
		funcional = new Usuario();
		arquiteto = new Usuario();
		desenvolvedor1 = new Usuario();
		desenvolvedor2 = new Usuario();
		arquitetoQA = new Usuario();
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Projeto> getListaProjetos() {
		return listaProjetos;
	}

	public void setListaProjetos(List<Projeto> listaProjetos) {
		this.listaProjetos = listaProjetos;
	}

	public Usuario getFuncional() {
		return funcional;
	}

	public void setFuncional(Usuario funcional) {
		this.funcional = funcional;
	}

	public List<Usuario> getListaFuncionais() {
		return listaFuncionais;
	}

	public void setListaFuncionais(List<Usuario> listaFuncionais) {
		this.listaFuncionais = listaFuncionais;
	}

	public Usuario getGerenteProjeto() {
		return gerenteProjeto;
	}

	public void setGerenteProjeto(Usuario gerenteProjeto) {
		this.gerenteProjeto = gerenteProjeto;
	}

	public List<Usuario> getListaGerentes() {
		return listaGerentes;
	}

	public void setListaGerentes(List<Usuario> listaGerentes) {
		this.listaGerentes = listaGerentes;
	}

	public Usuario getArquiteto() {
		return arquiteto;
	}

	public void setArquiteto(Usuario arquiteto) {
		this.arquiteto = arquiteto;
	}

	public List<Usuario> getListaArquitetos() {
		return listaArquitetos;
	}

	public void setListaArquitetos(List<Usuario> listaArquitetos) {
		this.listaArquitetos = listaArquitetos;
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

	public List<Usuario> getListaDesenvolvedores() {
		return listaDesenvolvedores;
	}

	public void setListaDesenvolvedores(List<Usuario> listaDesenvolvedores) {
		this.listaDesenvolvedores = listaDesenvolvedores;
	}

	public Usuario getArquitetoQA() {
		return arquitetoQA;
	}

	public void setArquitetoQA(Usuario arquitetoQA) {
		this.arquitetoQA = arquitetoQA;
	}

	public List<Usuario> getListaArquitetosQA() {
		return listaArquitetosQA;
	}

	public void setListaArquitetosQA(List<Usuario> listaArquitetosQA) {
		this.listaArquitetosQA = listaArquitetosQA;
	}

}
