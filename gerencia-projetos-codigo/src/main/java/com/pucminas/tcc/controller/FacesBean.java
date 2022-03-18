package com.pucminas.tcc.controller;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class FacesBean {
	
	protected void mostrarMensagem(String mensagem, String detalhe, Severity tipo) {
		FacesMessage mensagemTela = new FacesMessage(tipo, mensagem, detalhe);
		FacesContext.getCurrentInstance().addMessage(null, mensagemTela);
	}

}
