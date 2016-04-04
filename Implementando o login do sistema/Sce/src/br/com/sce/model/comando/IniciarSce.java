package br.com.sce.model.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IniciarSce implements InterfaceComando {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		return "cadastro_principal.jsp";
	}

}
