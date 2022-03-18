package com.pucminas.tcc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.pucminas.tcc.model.Projeto;
import com.pucminas.tcc.model.dao.ProjetoDAO;

@FacesConverter (value = "projetoConverter", forClass = Projeto.class)
public class ProjetoConverter implements Converter{
	
	ProjetoDAO projetoDAO = new ProjetoDAO();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
            return projetoDAO.buscarProjeto(value);
        }
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Projeto)) {
			String projetoId = ((Projeto) value).getId();
			return projetoId;
        } 
		return null;
	}
	
	

}
