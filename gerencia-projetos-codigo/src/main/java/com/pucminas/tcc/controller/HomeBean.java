package com.pucminas.tcc.controller;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Controller;

@Controller(value = "homeBean")
@ManagedBean
public class HomeBean {
	
	public String irCadastroUsuario(){
        return "/cadastroUsuario";
    }
	
	public String irCadastroProjeto(){
        return "/cadastroProjeto";
    }
	
	public String irConfiguraTime() {
		return "/configuraTime";
	}
	
	public String logout() {
		return "/login";
	}

}
