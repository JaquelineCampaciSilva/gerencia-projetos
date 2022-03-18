package com.pucminas.tcc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.springframework.stereotype.Controller;

import com.pucminas.tcc.model.Usuario;
import com.pucminas.tcc.model.dao.UsuarioDAO;

@Controller(value = "loginBean")
@ManagedBean
public class LoginBean extends FacesBean{
	
	public LoginBean() {}
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
		
	public String login() {
		
		if(usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty()) {
			usuario = new Usuario();
			mostrarMensagem("Usuário e senha devem ser preenchidos!", "Erro no Login!", FacesMessage.SEVERITY_WARN);
			
			return null;
		}else {
			usuario = usuarioDAO.buscarUsuario(usuario.getEmail(), usuario.getSenha());

			if (usuario == null) {
				usuario = new Usuario();
				mostrarMensagem("Usuário não encontrado!", "Erro no Login!", FacesMessage.SEVERITY_ERROR);

				return null;
			} else {
				return "/home";
			}
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
