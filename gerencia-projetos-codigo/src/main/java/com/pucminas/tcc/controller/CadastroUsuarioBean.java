package com.pucminas.tcc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Controller;

import com.pucminas.tcc.model.Usuario;
import com.pucminas.tcc.model.dao.UsuarioDAO;

@Controller(value = "cadastroUsuarioBean")
@ManagedBean
public class CadastroUsuarioBean extends FacesBean{
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	private boolean sucesso = false;
	
	public CadastroUsuarioBean() {}

	public String voltar(){
		limparCampos();
        return "/home";
    }
	
	public void cadastrarUsuario() {
		if (verificaCampos(usuario)) {
			sucesso = usuarioDAO.inserirUsuario(usuario);
			if(sucesso) {
				mostrarMensagem("Usuário cadastrado com Sucesso!", null, FacesMessage.SEVERITY_INFO);
				limparCampos();
			}else {
				mostrarMensagem("Erro ao cadastrar o usuário!", "Contate o administrador!", FacesMessage.SEVERITY_ERROR);
			}

		}else {
			mostrarMensagem("Inserir todas as informações para cadastro do usuário!", "Erro no cadastro de usuário!", FacesMessage.SEVERITY_WARN);
		}
		
	}

	private void limparCampos() {
		usuario = new Usuario();
	}

	private boolean verificaCampos(Usuario usuarioInserido) {
		
		if (usuarioInserido.getNome().isEmpty()
				|| usuarioInserido.getEmail().isEmpty()
				|| usuarioInserido.getNascimento() == null
				|| usuarioInserido.getTelefone().isEmpty()
				|| usuarioInserido.getPerfil().isEmpty()
				|| usuarioInserido.getSenha().isEmpty())
			return false;
		else
			return true;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
