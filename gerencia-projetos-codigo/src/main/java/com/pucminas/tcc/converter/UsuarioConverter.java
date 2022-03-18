package com.pucminas.tcc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.pucminas.tcc.model.Usuario;
import com.pucminas.tcc.model.dao.UsuarioDAO;

@FacesConverter (value = "usuarioConverter", forClass = Usuario.class)
public class UsuarioConverter implements Converter{

	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
            return usuarioDAO.buscarUsuario(Long.valueOf(value));
        }
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Usuario)) {
			Long usuarioId = ((Usuario) value).getId();
			return String.valueOf(usuarioId);
        } 
		return "";
	}

}
