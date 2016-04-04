package br.com.sce.model.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InterfaceComando {

	public String execute (HttpServletRequest request, 
			HttpServletResponse response);
	
}
