package com.pucminas.tcc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Controller;

import com.pucminas.tcc.model.Projeto;
import com.pucminas.tcc.model.dao.ProjetoDAO;

@Controller(value = "cadastroProjetoBean")
@ManagedBean
public class CadastroProjetoBean extends FacesBean{
	
	private ProjetoDAO projetoDAO = new ProjetoDAO();
	private Projeto projeto = new Projeto();
	private boolean sucesso = false;
	
	public CadastroProjetoBean(){}
	
	public String voltar(){
		limparCampos();
        return "/home";
    }
	
	public void cadastrarProjeto() {
		if (verificaCampos(projeto)) {
			if(verificaIdProjeto(projeto.getId())) {
				sucesso = projetoDAO.inserirProjeto(projeto);
				if(sucesso) {
					mostrarMensagem("Projeto cadastrado com Sucesso!", null, FacesMessage.SEVERITY_INFO);
					limparCampos();
				}else {
					mostrarMensagem("Erro ao cadastrar o projeto!", "Contate o administrador!", FacesMessage.SEVERITY_ERROR);
				}
			}else {
				mostrarMensagem("ID de Projeto já utilizado, por favor insira um ID diferente!", "Erro no cadastro de projeto!", FacesMessage.SEVERITY_WARN);
			}
		}else {
			mostrarMensagem("Inserir todas as informações para cadastro do projeto!", "Erro no cadastro de projeto!", FacesMessage.SEVERITY_WARN);
		}
	}

	private void limparCampos() {
		projeto = new Projeto();
	}

	private boolean verificaCampos(Projeto projetoInserido) {
		
		if (projetoInserido.getId().isEmpty()
				|| projetoInserido.getNome().isEmpty()
				|| projetoInserido.getDescricao().isEmpty())
			return false;
		else
			return true;
	}
	
	private boolean verificaIdProjeto(String id) {
		
		Projeto projeto = projetoDAO.buscarProjeto(id);
		
		if(projeto != null)
			return false;
		else
			return true;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
